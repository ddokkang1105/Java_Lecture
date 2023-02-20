import java.util.Scanner;

public class KIMain1 {

	@SuppressWarnings({ "resource", "unused" })
	public static void main(String[] args) throws InterruptedException {
		// Scanner : Java에 내장되어 있는 기능 중 하나
		// Import 로 불러오기

		// Scanner를 사용하기 위한 조건
		// new ~~ : 객체
		Scanner keyboard = new Scanner(System.in);

		System.out.print("이름: ");
		String name = keyboard.next();

		System.out.print("키: ");
		double height = keyboard.nextDouble();

		System.out.print("몸무게: ");
		double weight = keyboard.nextDouble();

		System.out.print("신발사이즈: ");
		int shoeSize = keyboard.nextInt();

		System.out.print("여행 가고 싶은 곳: ");
		String wantTrip = keyboard.next();

		System.out.print("좋아하는 숫자: ");
		int likeNum = keyboard.nextInt();

		System.out.print("놀고 싶은지 True / False: ");
		boolean play = keyboard.nextBoolean();

		System.out.println();

		System.out.printf("제 이름은 %s입니다.\n", name);
		System.out.printf("제 키는 %.01fcm입니다.\n", height);
		System.out.printf("제 몸무게는 %.01fkg입니다.\n", weight);
		System.out.printf("제 신발사이즈는 %dmm입니다.\n", shoeSize);
		System.out.printf("제가 여행가고 싶은 곳은 %s입니다.\n", wantTrip);
		System.out.printf("제가 좋아하는 숫자는 %d입니다.\n", likeNum);
		System.out.printf("제가 놀고 싶은지의 True / False : %b\n", play);
//
// 		System.out.println("제 이름은 " + name + "입니다.");
//		System.out.println("제 키는 " + height + "입니다.");
//		System.out.println("제 몸무게는 " + weight + "입니다.");
//		System.out.println("제 신발사이즈는 " + shoeSize + "입니다.");
//		System.out.println("제가 여행가고 싶은 곳은 " + wantTrip + "입니다.");
//		System.out.println("제가 좋아하는 숫자는 " + likeNum + "입니다.");
//		System.out.println("제가 놀고 싶은지의 True / False는 " + play + "입니다.");

		System.out.println();
		System.out.print("끄고 싶으면 아무거나 입력하세요 : ");
		String input = keyboard.next();
		// 스캐너의 기능 끄기
		keyboard.close();
		System.out.println();
		System.out.print(".\t");
		Thread.sleep(1000);
		System.out.print(".\t");
		Thread.sleep(1000);
		System.out.print(".\n");
		Thread.sleep(1000);
		System.out.print("프로그램을 종료합니다.");
		Thread.sleep(500);

//		System.out.print("값을 입력하세요 : ");
//		input = keyboard.nextInt();
//		System.out.print(input + "개가 입력되었습니다.");

	}
}
