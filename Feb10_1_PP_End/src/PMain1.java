import java.util.Random;
import java.util.Scanner;

public class PMain1 {

	public static int getComInt() {
		Random r = new Random();
		return r.nextInt(100) + 1;
	}

	public static int inputMyInt() {
		Scanner k = new Scanner(System.in);
		System.out.print("���ڸ� �Է��ϼ��� : ");
		int answer = k.nextInt();
		if (answer < 1 || answer > 100) {
			System.out.println("1 ~ 100 ������ ���ڸ� �Է��ϼ���");
		}
		return (answer >= 1 && answer <= 100) ? answer : inputMyInt();
	}

	public static void compareInt(int comInt) {
		int myInt = 0;
			for (int i = 1; true; i++) {
				myInt = inputMyInt();
				if (comInt == myInt) {
					System.out.printf("%dƮ : %d -> ���� !\n", i, myInt);
					break;
				}
				if (comInt >= myInt) {
					System.out.printf("%dƮ : %d -> UP !\n", i, myInt);
				} else {

					System.out.printf("%dƮ : %d -> Down !\n", i, myInt);
				}
				System.out.println();
			}
	}

	public static void main(String[] args) {
		int comInt = getComInt();
		compareInt(comInt);
		
	}
}
