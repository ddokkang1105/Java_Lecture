import java.util.Scanner;

public class Controller {
	// 프로그램을 실행 !
	public static Scanner choiceNum = new Scanner(System.in);
	public static ConsoleScreen cs = new ConsoleScreen();
	public static DAO dao = new DAO();
	
	public static void doProgram() {
		int choice = 0;
		a : while (true) {
			try {
				dao.connect();
				// 1~9번 메뉴 뜨는 함수
				System.out.print("메뉴를 선택하세요 (1 ~ 9) : ");
				choice = choiceNum.nextInt();
				System.out.println("=============================================");
				switch (choice) {
				case 1:
					String[] reservation = cs.reserve();
					dao.reserve(reservation);
					break;
				case 2:
					String[] registRest = cs.registRest();
					dao.registRest(registRest);
					break;
				case 3:
					cs.checkReservation();
					dao.checkReservation();
					break;
				case 4:
					cs.showRest();
					dao.showRest();
					break;
				case 5:
					int seat = cs.searchRest();
					dao.searchRest(seat);
					break;
				case 6:
					String name = cs.searchReservation();
					dao.searchReservation(name);
					break;
				case 7:
					String[] changeReservation = cs.changeReservation();
					dao.changeReservation(changeReservation);
					break;
				case 8:
					String cancleReservation = cs.cancleReservation();
					dao.cancleReservation(cancleReservation);
					break;
				case 9:
					System.out.println("프로그램을 종료합니다.");
					System.out.println("=============================================");
					break a;
				default:
					System.out.println("=============================================");
					cs.exitProgram();
					choiceNum = new Scanner(System.in);
					dao.close();
				}
				dao.close();
				
			} catch (Exception e) {
				System.out.println("=============================================");
				System.out.println("잘못 입력하였읍니다.");
				System.out.println("=============================================");
				choiceNum = new Scanner(System.in);
				dao.close();
			}
		}
	}

	
	public static void main(String[] args) {
		doProgram();
	}
}
