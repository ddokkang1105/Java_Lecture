import java.util.Iterator;

public class RMain3 {

	public static void main(String[] args) {

//		String lol = "";
//		for (int i = 0; i < 5; i++) {
//			lol += "ㅋ";
//			System.out.println(lol);
//		}

		String blackStar = "★";
		String whiteStar = "☆";
//		for (int i = 0; i < 5; i++) {
//			star += "★";
//			System.out.println(star);
//		}

//		for (int i = 0; i < 5; i++) {
//			for (int j = 0; j <= i; j++) {
//				System.out.print(blackStar);
//			}
//			System.out.println();
//			
//		}

// 첫 번째 방법
//		for (int i = 0; i < 5; i++) {
//			for (int j = 0; j <= i; j++) {
//				if (i == j) {
//					System.out.print(blackStar);
//				} else {
//					System.out.print(" ");
//				}
//			}
//			System.out.println();
//		}

// 두 번째 방법
//		for (int i = 0; i < 5; i++) {
//			for (int j = 0; j < i; j++) {
//					System.out.print(" ");
//			}
//			System.out.println(blackStar);
//		}

// 세 번째 방법
//		for (int i = 0; i < 5; i++) {
//			for (int j = 0; j <= i; j++) {
//				System.out.print((i == j) ? blackStar : " ");
//				
//			}
//			System.out.println();
//		}

//		for (int i = 0; i < 5; i++) {
//			for (int j = 0; j < i; j++) {
//				System.out.print(" ");
//			}
//			System.out.println(blackStar);
//		}

//		for (int i = 5; i > 0; i--) {
//			for (int j = 0; j < i; j++) {
//				
//				if (i % 2 == 1) {
//					System.out.print("★");
//					
//				} else {
//					System.out.print("☆");
//					
//				}
//				
//			}
//			System.out.println();
//		}

//		for (int i = 5; i > 0; i--) {
//			for (int j = 0; j < i; j++) {
//				System.out.print((i % 2 == 0) ? "☆" : "★");
//				
//			}
//			System.out.println();
//		}

//		for (int i = 0; i < 5; i++) {
//			for (int j = 0; j < (5 - i); j++) {
//				System.out.print((i % 2 == 0) ? blackStar : whiteStar);
//				
//			}
//			System.out.println();
//		}

//		for (int i = 1; i < 10; i = i + 2) {
//			for (int j = 1; j <= i; j++) {
//				System.out.print((i % 4 == 1) ? blackStar : whiteStar);
//			
//			}
//			System.out.println();
//		}
//		for (int i = 1; i < 10; i = i + 2) {
//			for (int j = 1; j <= (10 - i); j++) {
//				System.out.print((i % 4 == 1) ? blackStar : whiteStar);
//				
//			}
//			System.out.println();
//		}

//		for (int i = 1; i < 20; i ++) {
//			for (int j = 0; j < 40; j++) {
//				if ((i > 10) && (j > 10)) {
//					System.out.print(blackStar);
//					
//				} else {
//
//				}
//				System.out.println();
//			}
//
//		}

		for (int i = 0; i < 5; i++) {
			for (int j = 0; j < 5; j++) {
				System.out.print("b");
				
			}
			System.out.println();
		}
		
	}
}
