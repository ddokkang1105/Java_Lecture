import java.util.Scanner;

public class CMain6 {
	
	
	
	public static void main(String[] args) {
		Scanner k = new Scanner(System.in);
		System.out.print("몇 월 : ");
		int month = k.nextInt();
//		boolean evenMonth = (month % 2 ==0);
		int monthTest = 0;
		switch (month) {
		case 1: case 3: case 5: case 7: case 8: case 9: case 11:
			System.out.println("31일");
			break;
		case 4: case 6: case 10: case 12: 
			System.out.println("30일");
			break;
		case 2:
			System.out.println("28일");
			break;

		default:
			System.out.println("잘못된 달 입니다.");
			break;
		}
		

	}
	
	
}
