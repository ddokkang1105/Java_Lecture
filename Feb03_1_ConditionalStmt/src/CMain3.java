import java.util.Scanner;

// swich-case 

// swich 문 : 비교 조건이 특정한 값이나 문자열일 때
//	break; 를 이용하여 각 조건이 만족하면 switch문 종료하도록

//switch (변수 or 식) {
//case 값 A:
//	변수 or 식의 값이 A일 때 이 부분이 실행
//	break;
//case 값 B:
//	변수 or 식의 값이 B일 때 이 부분이 실행
//	break;
//	
//default:
//	A 값도 B 값도 아닐 때 이 부분이 실행
//	break;
//}


public class CMain3 {
	
	public static void inputNum(int input) {
		switch (input) {
		case 1:
			System.out.println("ㅋㅋ");
			break;
		case 2:
			System.out.println("ㅎㅎ");
			break;
		case 3:
			System.out.println("ㅠㅠ");
			break;
		default:
			System.out.println("졸려...");
			break;
		}
		
	}
	
	public static void main(String[] args) {
		Scanner k = new Scanner(System.in);
		System.out.printf("정수를 입력하세요 : ");
		int input = k.nextInt();
		inputNum(input);
//		switch (input) {
//		case 1:
//			System.out.println("ㅋㅋ");
//			break;
//		case 2:
//			System.out.println("ㅎㅎ");
//			break;
//		case 3:
//			System.out.println("ㅠㅠ");
//			break;
//		default:
//			System.out.println("졸려...");
//			break;
//		}
		
	}
}
