import java.util.Scanner;

public class YMain2 {
	public static void main(String[] args) {
		Scanner k = new Scanner(System.in);

		System.out.printf("���� ���� : ");
		int korScore = k.nextInt();

		System.out.printf("���� ���� : ");
		int mathScore = k.nextInt();

		System.out.printf("���� ���� : ");
		int engScore = k.nextInt();

		int totalScore = korScore + mathScore + engScore;
		double averageScore = totalScore / 3;

		System.out.println();
		System.out.println("*****************************");
		System.out.println("�Է��� �Ϸ�Ǿ����ϴ�.");
		System.out.println("*****************************");
		System.out.printf("���� ������ %d�� �Դϴ�.\n", korScore);
		System.out.printf("���� ������ %d�� �Դϴ�.\n", mathScore);
		System.out.printf("���� ������ %d�� �Դϴ�.\n", engScore);
		System.out.println("*****************************");
		System.out.printf("�� ������ %d�� �Դϴ�.\n", totalScore);
		System.out.printf("��� ������ %.1f�� �Դϴ�.\n", averageScore);
		System.out.println("*****************************");
		

	}
}
