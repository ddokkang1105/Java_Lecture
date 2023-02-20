import java.util.Random;
import java.util.Scanner;

public class PMain1 {

	public static int getComInt() {
		Random r = new Random();
		return r.nextInt(100) + 1;
	}

	public static int inputMyInt() {
		Scanner k = new Scanner(System.in);
		System.out.print("숫자를 입력하세요 : ");
		int answer = k.nextInt();
		if (answer < 1 || answer > 100) {
			System.out.println("1 ~ 100 사이의 숫자를 입력하세요");
		}
		return (answer >= 1 && answer <= 100) ? answer : inputMyInt();
	}

	public static void compareInt(int comInt) {
		int myInt = 0;
			for (int i = 1; true; i++) {
				myInt = inputMyInt();
				if (comInt == myInt) {
					System.out.printf("%d트 : %d -> 정답 !\n", i, myInt);
					break;
				}
				if (comInt >= myInt) {
					System.out.printf("%d트 : %d -> UP !\n", i, myInt);
				} else {

					System.out.printf("%d트 : %d -> Down !\n", i, myInt);
				}
				System.out.println();
			}
	}

	public static void main(String[] args) {
		int comInt = getComInt();
		compareInt(comInt);
		
	}
}
