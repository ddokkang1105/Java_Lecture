import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

// DAO / DTO 패턴
//		MVC패턴(Model View Controller)
//		DAO (Data Access Object)
//			: M 중에서 DB관련한 작업을 전담하는 클래스
//		DTO (Data Tranfer / Temp Object)
//			: DAO의 작업결과를 표현하는 클래스

// java.util.Date - 주력(Spring에서는 이걸 원함)
// java.sql.Date - JDBC에서는 이걸 원함

// java.util.Date -> java.sql.Date
//		: new Date(클래스명.get날짜관련멤버변수명().getTime());

// java.sql.Date -> java.util.Date : 알아서 바꿔줌



public class DAO {
	
	public static Connection con = null;
	public static PreparedStatement pstmt = null;
	public static ResultSet rs = null;
	
	public void connect() {
		try {
			con = DdokkangDBManager.connect();
		} catch (Exception e) {
			System.out.println("Connect Fail ...");
		}
	}
	
	public void close() {
		DdokkangDBManager.close(con, pstmt, rs);
	}
	
	public static String[] loadRestaurant() throws SQLException {
		String[] restaurant = new String[10];
		String sql = "select * from mar15_pizzarestaurant";
		
		pstmt = con.prepareStatement(sql);
		
		rs = pstmt.executeQuery();
	
		while (rs.next()) {
			int i = 0;
			restaurant[i] = rs.getString("p_location");
			System.out.println(restaurant[i]);
			i++;
		}
		return restaurant;
		
	}
	
	public static void checkRestaurant(String[] restaurant, String location) {
		for (int i = 0; i < restaurant.length; i++) {
			if (restaurant[i].equals(location)) {
				break;
			} else if (restaurant[i] == null) {
				System.out.println("잘못 입력하였습니다.");
				break;
			}
		}
	}
	
	// 1. 예약하기
	public void reserve(String[] reservation) throws SQLException {
		String name = reservation[0];
		String time = reservation[1];
		String phoneNum = reservation[2];
		String location = reservation[3];
		
		String sql = "insert into mar15_reservation "
				+ "values(mar15_reservation_seq.nextval, "
				+ "?, to_date(?, 'YYYY-MM-DD HH24'), ?, ?)";
		
		pstmt = con.prepareStatement(sql);
		
		pstmt.setString(1, name);
		pstmt.setString(2, time);
		pstmt.setString(3, phoneNum);
		pstmt.setString(4, location);

		pstmt.executeUpdate();
	}
		
	
	// 2. 매장 등록
	public void registRest(String[] registRest) throws SQLException {
		String location = registRest[0];
		String owner = registRest[1];
		int seat = Integer.parseInt(registRest[2]);
		
		String sql = "insert into mar15_pizzarestaurant "
				+ "values(mar15_reservation_seq.nextval, "
				+ "?, ?, ?)";
		
		pstmt = con.prepareStatement(sql);
		
		pstmt.setString(1, location);
		pstmt.setString(2, owner);
		pstmt.setInt(3, seat);

		if (pstmt.executeUpdate() == 1) {
			System.out.println("Success !!");
		} else {
			System.out.println("Fail ..");
		}
		
	}
	
	// 3. 전체 예약 정보 확인 (예약번호 오름차순 정렬)
	public void checkReservation() throws SQLException {
		String sql = "select r_no, r_name, "
				+ "r_time from mar15_reservation order by r_no";
		
		pstmt = con.prepareStatement(sql);
		
		rs = pstmt.executeQuery();
		
		while (rs.next()) {
			// rs.getXXX("컬럼명") : 현재 위치의 컬럼 읽기
			// rs.getXXX(인덱스) : 현재 데이터의 인덱스 컬럼 읽기 (비추천!)

			System.out.print(rs.getString("r_no") + ". ");
			System.out.println(rs.getString("r_name"));
			System.out.println(rs.getString("r_time"));
			System.out.println("=============================================");
		}
	}
	
	// 4. 전체 매장 조회 (지점명 오름차순 정렬)
	public void showRest() throws SQLException {
		String sql = "select p_location, p_owner, "
				+ "p_seat from mar15_pizzarestaurant order by p_location";
		
		pstmt = con.prepareStatement(sql);
		
		rs = pstmt.executeQuery();
		
		while (rs.next()) {
			// 위치(좌석 수) - 사장님 이름
			System.out.print(rs.getString("p_location") + "(");
			System.out.print(rs.getString("p_seat") + ") - ");
			System.out.print(rs.getString("p_owner"));
			System.out.println();
			System.out.println("=============================================");
		}
	}
	
	// 5. 매장 찾기 (입력한 좌석 수 이상을 가지고 있는 매장, 지점명 오름차순 정렬)
	public void searchRest(int seat) throws SQLException {
	
		String sql = "select p_location, p_owner, "
				+ "p_seat from mar15_pizzarestaurant "
				+ "where p_seat >= ?"
				+ "order by p_location";
		
		pstmt = con.prepareStatement(sql);
		
		pstmt.setInt(1, seat);
		
		rs = pstmt.executeQuery();
		
		while (rs.next()) {
			// 위치(좌석 수) - 사장님 이름
			System.out.println(rs.getString("p_location"));
			System.out.println(rs.getString("p_seat"));
			System.out.println(rs.getString("p_owner"));
			System.out.println("=============================================");
		}

	}
	
	// 6. 예약 찾기 (예약자 이름으로 찾기, 예약 번호순으로 정렬)
	public void searchReservation(String name) throws SQLException {
		String sql = "select r_no, r_name, "
				+ "r_time from mar15_reservation "
				+ "where r_name = ?"
				+ "order by r_no";
		
		pstmt = con.prepareStatement(sql);
		
		pstmt.setString(1, name);
		
		rs = pstmt.executeQuery();
		
		while (rs.next()) {
			System.out.print(rs.getString("r_no") + ". ");
			System.out.println(rs.getString("r_name"));
			System.out.println(rs.getString("r_time"));
			System.out.println("=============================================");
		}
		
	}
	
	// 7. 예약 정보 수정 (예약번호를 입력하면, 연락처를 변경)
	public void changeReservation(String[] changeReservation) throws SQLException {
		int r_no = Integer.parseInt(changeReservation[0]);
		String phoneNum = changeReservation[1];
		String sql = "update mar15_reservation "
				+ "set r_phonenum = ? "
				+ "where r_no = ? ";
		
		pstmt = con.prepareStatement(sql);
		
		pstmt.setString(1, phoneNum);
		pstmt.setInt(2, r_no);
		
		if (pstmt.executeUpdate() >= 1) {
			System.out.println("Success !!");
		} else {
			System.out.println("Fail ..");
		}	
		
	}
	
	// 8. 예약 취소 (예약번호로 취소)
	public void cancleReservation(String cancleReservation) throws SQLException {
		String sql = "delete mar15_reservation "
				+ "where r_no = ?";
		
		pstmt = con.prepareStatement(sql);
		
		pstmt.setString(1, cancleReservation);
		
		if (pstmt.executeUpdate() >= 1) {
			System.out.println("Success !!");
		} else {
			System.out.println("Fail ..");
		}	
	}
	
}
