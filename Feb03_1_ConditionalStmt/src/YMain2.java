import java.util.Scanner;

public class YMain2 {

	public static int getIntNum1() {
		Scanner k = new Scanner(System.in);
		System.out.print("첫번째 값을 입력하세요: ");
		return new Scanner(System.in).nextInt();
	}

	public static int getIntNum2() {
		Scanner k = new Scanner(System.in);
		System.out.print("두번째 값을 입력하세요: ");
		return new Scanner(System.in).nextInt();
	}

	public static int getOdd(int num1, int num2) {
		return ((num1 + num2) % 2 == 0) ? (num1 + num2) : getOdd(getIntNum1(), getIntNum2());
	}

	public static void main(String[] args) {
		int num1 = getIntNum1();
		int num2 = getIntNum2();
		int result = getOdd(num1, num2);
		System.out.println(result);
	}
}
