import java.util.Scanner;


public class KIMain2 {
	public static void main(String[] args) {
		@SuppressWarnings("resource")
		Scanner keyboard = new Scanner(System.in);
//		System.out.print("���簢���� ���� ���̸� �Է��ϼ��� : ");
//		double width = keyboard.nextDouble();
//		System.out.print("���簢���� ���� ���̸� �Է��ϼ��� : ");
//		double length = keyboard.nextDouble();
//		double recArea = width * length;
//		System.out.printf("���簢���� ���̴� : \"%.02f\"�Դϴ�.\n", recArea);
//		
//		System.out.println();
//		System.out.print("�������� �Է��ϼ��� : ");
//		double radius = keyboard.nextDouble();
//		// double cirArea = radius * radius * 3.14;
//		// Math.PI -> ���� ���� ����
//		double cirArea = Math.PI * Math.pow(radius, 2);
//		System.out.printf("���� ���̴� : \"%.2f\"�Դϴ�.\n", cirArea);

		System.out.print("�ð��̳� ���� �˰� ���� �ʸ� �Է��ϼ��� : ");
		int sec = keyboard.nextInt();
		double min = (double) sec / 60;
		double hour = min / 60;
		System.out.printf("%d�ʴ� %.2f���Դϴ�.\n", sec, min);
		System.out.printf("%.2f���� %.2f�ð��Դϴ�.\n", min, hour);
		
		
	}
}
