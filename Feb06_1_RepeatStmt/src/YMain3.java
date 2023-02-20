import java.util.Scanner;

public class YMain3 {

	public static int getHour() {
		Scanner k = new Scanner(System.in);
		System.out.print("�ð��� �Է��ϼ��� : ");
		int hour = k.nextInt();
		return (hour >= 0 && hour < 24) ? hour : getHour();
	}

	public static void printHour(int hour) {
		System.out.printf("�Է��� �ð��� %d �� �Դϴ�.\n", hour);
	}

	public static void printdaylife(int hour) {

		boolean rising = (hour >= 6 && hour < 9);
		boolean academy = (hour >= 9 && hour < 18);
		boolean goingHome = (hour >= 18 && hour < 20);
		boolean home = (hour >= 20 && hour < 6);
		if (home) {
			System.out.println("�����ð� + ��ħ");
		} else if (academy) {
			System.out.println("�п����� ����");
			switch (hour) {
			case 9:
			case 14:
			case 18:
				System.out.println("QR ���");
				break;
			case 13:
				System.out.println("���� �ð�");
				break;
			}
		} else if (rising) {
			System.out.println("��� + �п� �� �غ�");
		} else if (goingHome) {
			System.out.println("�� ����~");

		}
	}

	public static void main(String[] args) {
		int hour = getHour();
		printHour(hour);
		printdaylife(hour);
	}
}
