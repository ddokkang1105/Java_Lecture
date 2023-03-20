import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

// DAO / DTO ����
//		MVC����(Model View Controller)
//		DAO (Data Access Object)
//			: M �߿��� DB������ �۾��� �����ϴ� Ŭ����
//		DTO (Data Tranfer / Temp Object)
//			: DAO�� �۾������ ǥ���ϴ� Ŭ����

// java.util.Date - �ַ�(Spring������ �̰� ����)
// java.sql.Date - JDBC������ �̰� ����

// java.util.Date -> java.sql.Date
//		: new Date(Ŭ������.get��¥���ø��������().getTime());

// java.sql.Date -> java.util.Date : �˾Ƽ� �ٲ���



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
				System.out.println("�߸� �Է��Ͽ����ϴ�.");
				break;
			}
		}
	}
	
	// 1. �����ϱ�
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
		
	
	// 2. ���� ���
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
	
	// 3. ��ü ���� ���� Ȯ�� (�����ȣ �������� ����)
	public void checkReservation() throws SQLException {
		String sql = "select r_no, r_name, "
				+ "r_time from mar15_reservation order by r_no";
		
		pstmt = con.prepareStatement(sql);
		
		rs = pstmt.executeQuery();
		
		while (rs.next()) {
			// rs.getXXX("�÷���") : ���� ��ġ�� �÷� �б�
			// rs.getXXX(�ε���) : ���� �������� �ε��� �÷� �б� (����õ!)

			System.out.print(rs.getString("r_no") + ". ");
			System.out.println(rs.getString("r_name"));
			System.out.println(rs.getString("r_time"));
			System.out.println("=============================================");
		}
	}
	
	// 4. ��ü ���� ��ȸ (������ �������� ����)
	public void showRest() throws SQLException {
		String sql = "select p_location, p_owner, "
				+ "p_seat from mar15_pizzarestaurant order by p_location";
		
		pstmt = con.prepareStatement(sql);
		
		rs = pstmt.executeQuery();
		
		while (rs.next()) {
			// ��ġ(�¼� ��) - ����� �̸�
			System.out.print(rs.getString("p_location") + "(");
			System.out.print(rs.getString("p_seat") + ") - ");
			System.out.print(rs.getString("p_owner"));
			System.out.println();
			System.out.println("=============================================");
		}
	}
	
	// 5. ���� ã�� (�Է��� �¼� �� �̻��� ������ �ִ� ����, ������ �������� ����)
	public void searchRest(int seat) throws SQLException {
	
		String sql = "select p_location, p_owner, "
				+ "p_seat from mar15_pizzarestaurant "
				+ "where p_seat >= ?"
				+ "order by p_location";
		
		pstmt = con.prepareStatement(sql);
		
		pstmt.setInt(1, seat);
		
		rs = pstmt.executeQuery();
		
		while (rs.next()) {
			// ��ġ(�¼� ��) - ����� �̸�
			System.out.println(rs.getString("p_location"));
			System.out.println(rs.getString("p_seat"));
			System.out.println(rs.getString("p_owner"));
			System.out.println("=============================================");
		}

	}
	
	// 6. ���� ã�� (������ �̸����� ã��, ���� ��ȣ������ ����)
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
	
	// 7. ���� ���� ���� (�����ȣ�� �Է��ϸ�, ����ó�� ����)
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
	
	// 8. ���� ��� (�����ȣ�� ���)
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
