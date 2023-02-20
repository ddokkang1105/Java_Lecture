import java.util.Scanner;

public class KIMain3 {
	public static void main(String[] args) {

		@SuppressWarnings("resource")
		Scanner bunsik = new Scanner(System.in);
		System.out.print("떡볶이 가격을 입력하세요 : ");
		int bboki = bunsik.nextInt();

		System.out.print("튀김 가격을 입력하세요 : ");
		int ttukim = bunsik.nextInt();

		System.out.print("순대 가격을 입력하세요 : ");
		int sundae = bunsik.nextInt();

		System.out.print("김밥 가격을 입력하세요 : ");
		int kimbab = bunsik.nextInt();

		System.out.print("어묵 가격을 입력하세요 : ");
		int odeng = bunsik.nextInt();

		System.out.println("*************************");
		System.out.println("▦-----------------------▦");
		System.out.println("|\t또와 분식점\t|");
		System.out.println("|-----------------------|");
		System.out.printf("|떡볶이\t | %,8d원\t|\n", bboki);
		System.out.println("|-----------------------|");
		System.out.printf("|튀김\t | %,8d원\t|\n", ttukim);
		System.out.println("|-----------------------|");
		System.out.printf("|순대\t | %,8d원\t|\n", sundae);
		System.out.println("|-----------------------|");
		System.out.printf("|김밥\t | %,8d원\t|\n", kimbab);
		System.out.println("|-----------------------|");
		System.out.printf("|어묵\t | %,8d원\t|\n", odeng);
		System.out.println("▦-----------------------▦");

		// Thread.sleep(10000);

	}
}
