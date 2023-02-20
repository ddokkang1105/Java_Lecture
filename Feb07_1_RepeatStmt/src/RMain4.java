import java.util.Scanner;

// continuel 
//		강제반복 ( 턴종료 ) -> 그 턴은 무시 !

// break; 	(공식적) 반복문 종료
// return; 	(비공식적) 반복문 종료


public class RMain4 {
	
	
	
	public static void main(String[] args) {
		
//		for (int i = 0; i < 10; i++) {
//			if (i == 3) {
//				continue;
////				i++;
//			}
//			System.out.println(i);
//			System.out.println("안녕하세요");
//			System.out.println("안녕하세요");
//			System.out.println("안녕하세요");
//			System.out.println("----------------");
//		}

		Scanner k = new Scanner(System.in);
//		String input = "";
//		while (input.equals("ㅎㅇ") != true) {
//			System.out.print("내용 입력 : ");
//			input = k.next();
//			System.out.println("====================");
//			System.out.println(input);
//			System.out.println("====================");
//		}

		String input = null;
		while (true) {
			System.out.print("내용 입력 : ");
			input = k.next();
			System.out.println("====================");
			System.out.println(input);
			System.out.println("====================");
			if (input.equals("ㅎㅇ")) {
				System.out.println("반복문 끝 !");
				break;
			}
		}
		
		
	}
}
