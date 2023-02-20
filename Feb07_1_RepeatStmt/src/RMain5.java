import java.util.Scanner;

// 반복문에 이름 붙이기
//		-> 반복문 앞에 (이름 :) while () {}

public class RMain5 {

	public static void main(String[] args) {
		Scanner k = new Scanner(System.in);

//		String who = "";
//		while (who.equals("끝") != true) {
//			System.out.print("누구 : ");
//			who = k.next();
//			switch (who) {
//			case "매니저":
//				System.out.println("시스템관리");
//			case "강사":
//				System.out.println("학생관리");
//			case "학생":
//				System.out.println("수업관련 업무");
//				break;
//			default:
//				if (who.equals("끝") != true) {
//					System.out.println("뭐야 ~ ?");
//				}
//				break;
//				
//			}
//			System.out.println();
//		}
//		System.out.println("프로그램을 종료합니다.");

//		String who = null;
//		while (true) {
//			System.out.print("누구 : ");
//			who = k.next();
//			if (who.equals("끝")) {
//				break;
//			} else {
//				switch (who) {
//				case "매니저":
//					System.out.println("시스템관리");
//				case "강사":
//					System.out.println("학생관리");
//				case "학생":
//					System.out.println("수업관련 업무");
//					break;
//				default:
//					System.out.println("뭐야 ~ ?");
//					break;
//				}
//			}
//			System.out.println();
//		}
//		System.out.println("프로그램을 종료합니다.");

//		String who = "";
//		role : while (who.equals("끝") != true) {
//			System.out.print("누구 : ");
//			who = k.next();
//			switch (who) {
//			case "매니저":
//				System.out.println("시스템관리");
//			case "강사":
//				System.out.println("학생관리");
//			case "학생":
//				System.out.println("수업관련 업무");
//				break;
//			case "끝":
//				break role;
//			default:
//				System.out.println("뭐야 ~ ?");
//				break;
//
//			}
//			System.out.println();
//		}
//		System.out.println("프로그램을 종료합니다.");
		
		bb : for (int i = 0; i < 3; i++) {
			aa : for (int j = 0; j < 3; j++) {
				for (int j2 = 0; j2 < 3; j2++) {
					System.out.printf("%d %d %d\n", i, j, j2);
					if (i == 1) {
						System.out.println("중단 !");
						
						// break;			
						// 000 001 002 010 011 012 020 021 022
						// 100 110 120 200 210 220
						// break aa;
						// 000 001 002 010 011 012 020 021 022 
						// 100 200
						// break bb;		
						// 000 001 002 010 011 012 020 021 022
						// 100
						// 틀림 ㅋㅋ
						// if 문 안에 break; 가 걸린다고 해서 
						// 아예 종료되는 것이 아니라
						// if 문의 조건이 맞게 되면 다시 실행한다.
						
					}
				}
			}
		}
		bb : for (int i = 0; i < 3; i++) {
			aa : for (int j = 0; j < 3; j++) {
				for (int j2 = 0; j2 < 3; j2++) {
					System.out.printf("%d %d %d\n", i, j, j2);
					while (i == 1) {
						System.out.println("중단 !");
						break;
					}
				}
			}
		}
		
		
		
		
	}
}
