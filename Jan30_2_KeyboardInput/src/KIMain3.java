import java.util.Scanner;

public class KIMain3 {
	public static void main(String[] args) {

		@SuppressWarnings("resource")
		Scanner bunsik = new Scanner(System.in);
		System.out.print("������ ������ �Է��ϼ��� : ");
		int bboki = bunsik.nextInt();

		System.out.print("Ƣ�� ������ �Է��ϼ��� : ");
		int ttukim = bunsik.nextInt();

		System.out.print("���� ������ �Է��ϼ��� : ");
		int sundae = bunsik.nextInt();

		System.out.print("��� ������ �Է��ϼ��� : ");
		int kimbab = bunsik.nextInt();

		System.out.print("� ������ �Է��ϼ��� : ");
		int odeng = bunsik.nextInt();

		System.out.println("*************************");
		System.out.println("��-----------------------��");
		System.out.println("|\t�ǿ� �н���\t|");
		System.out.println("|-----------------------|");
		System.out.printf("|������\t | %,8d��\t|\n", bboki);
		System.out.println("|-----------------------|");
		System.out.printf("|Ƣ��\t | %,8d��\t|\n", ttukim);
		System.out.println("|-----------------------|");
		System.out.printf("|����\t | %,8d��\t|\n", sundae);
		System.out.println("|-----------------------|");
		System.out.printf("|���\t | %,8d��\t|\n", kimbab);
		System.out.println("|-----------------------|");
		System.out.printf("|�\t | %,8d��\t|\n", odeng);
		System.out.println("��-----------------------��");

		// Thread.sleep(10000);

	}
}
