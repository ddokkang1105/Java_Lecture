import java.util.Scanner;

public class FMain1 {

	public static void printBigger(int a, int b) {
		int bigger = (a > b) ? a : b;
		System.out.printf("%d �� %d �߿� %d ��/�� �� Ů�ϴ�.\n", a, b, bigger);
	}
	
	public static void printBiggerInput(int a, int b) {
		int bigger = (a > b) ? a : b;
		System.out.printf("%d �� %d �߿� %d ��/�� �� Ů�ϴ�.\n", a, b, bigger);
		
	}

	public static void printBigger(double a, double b) {
		double bigger = (a > b) ? a : b;
		System.out.printf("%.2f �� %.2f �߿� %.2f ��/�� �� Ů�ϴ�.\n", a, b, bigger);
	}

	public static void printBiggerInput(double a, double b) {
		double bigger = (a > b) ? a : b;
		System.out.printf("%.2f �� %.2f �߿� %.2f ��/�� �� Ů�ϴ�.\n", a, b, bigger);
	}

	public static double getBigger(double a, double b) {
		double bigger = (a > b) ? a : b;
		return bigger;
	}
	
	public static void main(String[] args) {
		Scanner k = new Scanner(System.in);

//		printBigger(3, 4);

//		System.out.print("������ ������ �Է��ϼ���: ");
//		int a = k.nextInt();
//		System.out.print("������ ������ �Է��ϼ���: ");
//		int b = k.nextInt();
//		printBiggerInput(a, b);

//		printBigger(3, 4);
//		printBigger(3.323, 3.392);
//		printBigger(3.333333333, 3.333333334);
//		
//		System.out.print("������ �Ǽ��� �Է��ϼ���: ");
//		double a = k.nextDouble();
//		System.out.print("������ �Ǽ��� �Է��ϼ���: ");
//		double b = k.nextDouble();
//		printBiggerInput(a, b);

		double num = getBigger(3.333, 3.334);
		System.out.println(num);
	}
}
