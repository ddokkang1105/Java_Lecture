import java.util.Scanner;

public class KIMain1 {

	@SuppressWarnings({ "resource", "unused" })
	public static void main(String[] args) throws InterruptedException {
		// Scanner : Java�� ����Ǿ� �ִ� ��� �� �ϳ�
		// Import �� �ҷ�����

		// Scanner�� ����ϱ� ���� ����
		// new ~~ : ��ü
		Scanner keyboard = new Scanner(System.in);

		System.out.print("�̸�: ");
		String name = keyboard.next();

		System.out.print("Ű: ");
		double height = keyboard.nextDouble();

		System.out.print("������: ");
		double weight = keyboard.nextDouble();

		System.out.print("�Ź߻�����: ");
		int shoeSize = keyboard.nextInt();

		System.out.print("���� ���� ���� ��: ");
		String wantTrip = keyboard.next();

		System.out.print("�����ϴ� ����: ");
		int likeNum = keyboard.nextInt();

		System.out.print("��� ������ True / False: ");
		boolean play = keyboard.nextBoolean();

		System.out.println();

		System.out.printf("�� �̸��� %s�Դϴ�.\n", name);
		System.out.printf("�� Ű�� %.01fcm�Դϴ�.\n", height);
		System.out.printf("�� �����Դ� %.01fkg�Դϴ�.\n", weight);
		System.out.printf("�� �Ź߻������ %dmm�Դϴ�.\n", shoeSize);
		System.out.printf("���� ���డ�� ���� ���� %s�Դϴ�.\n", wantTrip);
		System.out.printf("���� �����ϴ� ���ڴ� %d�Դϴ�.\n", likeNum);
		System.out.printf("���� ��� �������� True / False : %b\n", play);
//
// 		System.out.println("�� �̸��� " + name + "�Դϴ�.");
//		System.out.println("�� Ű�� " + height + "�Դϴ�.");
//		System.out.println("�� �����Դ� " + weight + "�Դϴ�.");
//		System.out.println("�� �Ź߻������ " + shoeSize + "�Դϴ�.");
//		System.out.println("���� ���డ�� ���� ���� " + wantTrip + "�Դϴ�.");
//		System.out.println("���� �����ϴ� ���ڴ� " + likeNum + "�Դϴ�.");
//		System.out.println("���� ��� �������� True / False�� " + play + "�Դϴ�.");

		System.out.println();
		System.out.print("���� ������ �ƹ��ų� �Է��ϼ��� : ");
		String input = keyboard.next();
		// ��ĳ���� ��� ����
		keyboard.close();
		System.out.println();
		System.out.print(".\t");
		Thread.sleep(1000);
		System.out.print(".\t");
		Thread.sleep(1000);
		System.out.print(".\n");
		Thread.sleep(1000);
		System.out.print("���α׷��� �����մϴ�.");
		Thread.sleep(500);

//		System.out.print("���� �Է��ϼ��� : ");
//		input = keyboard.nextInt();
//		System.out.print(input + "���� �ԷµǾ����ϴ�.");

	}
}
