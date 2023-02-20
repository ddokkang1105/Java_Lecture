import java.util.Scanner;

public class YMain3 {

	public static int getHour() {
		Scanner k = new Scanner(System.in);
		System.out.print("시간을 입력하세요 : ");
		int hour = k.nextInt();
		return (hour >= 0 && hour < 24) ? hour : getHour();
	}

	public static void printHour(int hour) {
		System.out.printf("입력한 시간은 %d 시 입니다.\n", hour);
	}

	public static void printdaylife(int hour) {

		boolean rising = (hour >= 6 && hour < 9);
		boolean academy = (hour >= 9 && hour < 18);
		boolean goingHome = (hour >= 18 && hour < 20);
		boolean home = (hour >= 20 && hour < 6);
		if (home) {
			System.out.println("여가시간 + 취침");
		} else if (academy) {
			System.out.println("학원에서 공부");
			switch (hour) {
			case 9:
			case 14:
			case 18:
				System.out.println("QR 찍기");
				break;
			case 13:
				System.out.println("점심 시간");
				break;
			}
		} else if (rising) {
			System.out.println("기상 + 학원 갈 준비");
		} else if (goingHome) {
			System.out.println("집 가자~");

		}
	}

	public static void main(String[] args) {
		int hour = getHour();
		printHour(hour);
		printdaylife(hour);
	}
}
