import java.util.Scanner;

public class FMain1 {

	public static void printBigger(int a, int b) {
		int bigger = (a > b) ? a : b;
		System.out.printf("%d 와 %d 중에 %d 가/이 더 큽니다.\n", a, b, bigger);
	}
	
	public static void printBiggerInput(int a, int b) {
		int bigger = (a > b) ? a : b;
		System.out.printf("%d 와 %d 중에 %d 가/이 더 큽니다.\n", a, b, bigger);
		
	}

	public static void printBigger(double a, double b) {
		double bigger = (a > b) ? a : b;
		System.out.printf("%.2f 와 %.2f 중에 %.2f 가/이 더 큽니다.\n", a, b, bigger);
	}

	public static void printBiggerInput(double a, double b) {
		double bigger = (a > b) ? a : b;
		System.out.printf("%.2f 와 %.2f 중에 %.2f 가/이 더 큽니다.\n", a, b, bigger);
	}

	public static double getBigger(double a, double b) {
		double bigger = (a > b) ? a : b;
		return bigger;
	}
	
	public static void main(String[] args) {
		Scanner k = new Scanner(System.in);

//		printBigger(3, 4);

//		System.out.print("설정할 정수를 입력하세요: ");
//		int a = k.nextInt();
//		System.out.print("설정할 정수를 입력하세요: ");
//		int b = k.nextInt();
//		printBiggerInput(a, b);

//		printBigger(3, 4);
//		printBigger(3.323, 3.392);
//		printBigger(3.333333333, 3.333333334);
//		
//		System.out.print("설정할 실수를 입력하세요: ");
//		double a = k.nextDouble();
//		System.out.print("설정할 실수를 입력하세요: ");
//		double b = k.nextDouble();
//		printBiggerInput(a, b);

		double num = getBigger(3.333, 3.334);
		System.out.println(num);
	}
}
