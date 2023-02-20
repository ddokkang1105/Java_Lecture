import java.util.Scanner;

// 현재 시간을 밀리초롤 나타내주는 기능 :
// System.currentTimeMillis();
// 절대값 구하기 : Math.abs();
// Scanner 이용해서 입력
//		keyboard.next(); vs keyboard.nextLine();
//		next()는 공백(space) 전까지 입력받은 문자열을 반환하는 기능
//		nextLine()은 개행문자(Enter)를 치기 전까지 입력받은 문자열을 반환하는 기능



public class YMain1 {
	public static void main(String[] args) throws InterruptedException {
//		double time1 = System.currentTimeMillis();
//		double time_1 = time1 / 1000;
//		double sec = time_1 % 60;
//		double min = time_1 / 60;
//		double hour = min / 60;
//		System.out.printf("%.01f\n", time1);
//		System.out.printf("%.01f\n", sec);
//		System.out.printf("%.01f\n", min);
//		System.out.printf("%.01f\n", hour);

		Scanner k = new Scanner(System.in);
		System.out.println("===============================");
		System.out.print("첫 번째 순서 : ");
		String name1 = k.nextLine();
		System.out.println("===============================");
		System.out.println("ENTER 키를 누르면 시작됩니다.");
		System.out.println("10초에 가까우면 승리 !");
		System.out.print("===============================");
		String ready = k.nextLine();
		System.out.println("준비가 되면 ENTER 키를 누르시오.");
		System.out.print("===============================");
		double timeStart1 = System.currentTimeMillis();
		String time = k.nextLine();
		double timeEnd1 = System.currentTimeMillis();
		double time1 = (timeEnd1 - timeStart1) / 1000;
		System.out.printf("%.2f초 !!\n", time1);

		System.out.println("===============================");
		System.out.print("두 번째 순서 : ");
		String name2 = k.nextLine();
		System.out.println("===============================");
		System.out.println("ENTER 키를 누르면 시작됩니다.");
		System.out.println("10초에 가까우면 승리 !");
		System.out.print("===============================");
		ready = k.nextLine();
		System.out.println("준비가 되면 ENTER 키를 누르시오.");
		System.out.print("===============================");
		double timeStart2 = System.currentTimeMillis();
		time = k.nextLine();
		double timeEnd2 = System.currentTimeMillis();
		double time2 = (timeEnd2 - timeStart2) / 1000;
		System.out.printf("%.2f초 !!\n", time2);

		boolean winTime = Math.abs(time1 - 10) > Math.abs(time2 - 10);
		if (winTime) {
			System.out.println("===============================");
			System.out.printf("%s 승리 !!\n", name2);
			System.out.printf("%.2f초 입니다 !!", time2);
		} else {
			System.out.println("===============================");
			System.out.printf("%s 승리 !!\n", name1);
			System.out.printf("%.2f초 입니다 !!", time1);
		}

	}
}
