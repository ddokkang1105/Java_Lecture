
import java.sql.SQLException;
import java.util.Scanner;

public class ConsoleScreen {
	// 사용자가 콘솔을 볼 수 있거나, 콘솔에 입력할 수 있게
	// 메뉴를 볼 수 있는 기능도 있었으면...
	static Scanner k = new Scanner(System.in);
	
	
	// 1. 예약하기(직접 입력, 날짜는 연-월-일/시:분)
	public String[] reserve() throws SQLException {
		System.out.println("예약을 시작합니다.");
		System.out.println("=============================================");
		String[] reservation = new String[4];
		System.out.print("예약자 성함 : ");
		k = new Scanner(System.in);
		String name = k.nextLine();
		reservation[0] = name;
		System.out.print("예약자 시간 (YYYY-MM-DD 24H) : ");
		String time = k.nextLine();
		reservation[1] = time;
		System.out.print("예약자 전화번호 (XXX-XXXX-XXXX) : ");
		String phoneNum = k.nextLine();
		reservation[2] = phoneNum;
		System.out.print("예약자 지점 : ");
		String location = k.nextLine();
		String[] check = DAO.loadRestaurant();
		DAO.checkRestaurant(check, location);
		reservation[3] = location;
		System.out.println("=============================================");
		return reservation;
		
	}
	
	// 2. 매장 등록
	public String[] registRest() {
		System.out.println("식당 등록을 시작합니다.");
		System.out.println("=============================================");
		String[] restaurantInfo = new String[3];
		System.out.println("식당 위치 (~점) : ");
		String location = k.next();
		restaurantInfo[0] = location;
		System.out.println("식당 주인 : ");
		String owner = k.next();
		restaurantInfo[1] = owner;
		System.out.println("식당 좌석 : ");
		String seat = k.next();
		restaurantInfo[2] = seat;
		System.out.println("=============================================");
		return restaurantInfo;
	}
	
	// 3. 전체 예약 정보 확인 (날짜는 연-월-일 요일 오전/오후 시:분)
	public void checkReservation() {
		System.out.println("전체 예약 정보를 확인합니다.");
		System.out.println("=============================================");
	}
	
	// 4. 전체 매장 조회 (위치(좌석 수) - 사장님 이름)
	public void showRest() {
		System.out.println("전체 매장을 조회합니다. 위치(좌석)-사장님 성함");
		System.out.println("=============================================");
	}
	
	// 5. 매장 찾기 (최소 좌석수 입력 => 좌석 수 이상의 매장 정보를 출력)
	public int searchRest() {
		int seat = 0;
		System.out.println("입력한 좌석 수 이상의 매장 정보를 조회합니다.");
		System.out.println("=============================================");
		System.out.print("좌석 수를 입력하세요 : ");
		seat = k.nextInt();
		System.out.println("=============================================");
		return seat;
	}
	
	// 6. 예약 찾기 (예약자 이름)
	public String searchReservation() {
		String name = null;
		System.out.println("예약한 정보를 조회합니다.");
		System.out.println("=============================================");
		System.out.print("예약하신 성함을 입력하세요 : ");
		name = k.next();
		System.out.println("=============================================");
		return name;
	}
	
	// 7. 예약 정보 수정 (예약번호를 입력하면, 연락처를 변경)
	public String[] changeReservation() {
		String[] changeReservation = new String[2];
		String num = null;
		String phoneNum = null;
		System.out.println("예약한 연락처를 수정합니다.");
		System.out.println("=============================================");
		System.out.print("예약번호를 입력하세요 : ");
		num = k.nextLine();
		changeReservation[0] = num;
		System.out.print("수정할 연락처(XXX-XXXX-XXXX) : ");
		phoneNum = k.nextLine();
		changeReservation[1] = phoneNum;
		
		System.out.println("=============================================");
		return changeReservation;
	}
	// 8. 예약 취소 (예약번호로 취소)
	public String cancleReservation() {
		String cancleReservation = null;
		System.out.println("예약을 취소합니다.");
		System.out.println("=============================================");
		System.out.print("예약번호를 입력하세요 : ");
		cancleReservation = k.next();
		return cancleReservation;
	}
	
	// 9. 종료
	public void exitProgram() {
		System.out.println("잘못된 선택지입니다.");
		System.out.println("=============================================");
	}
}
