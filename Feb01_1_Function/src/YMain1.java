import java.util.Scanner;

public class YMain1 {
	public static void main(String[] args) {
		Scanner k = new Scanner(System.in);

//		System.out.print("�߱����� ������ �Է��ϼ��� : ");
//		int ball = k.nextInt();
//
//		int box = (ball % 6 == 0) ? ball / 6 : ball / 6 + 1;
//		System.out.printf("�߱��� : %d\n", ball);
//		System.out.printf("���� : %d\n", box);

		System.out.print("������ �Է��ϼ��� : ");
		double height = k.nextDouble();
		System.out.print("�����Ը� �Է��ϼ��� : ");
		double weight = k.nextDouble();

		System.out.printf("���� : %.1f cm\n", height);
		System.out.printf("������ : %.1f kg\n", weight);

		double genWeight = (height - 100) * 0.9;
		double bmi = (weight / genWeight) * 100;
		String bmiText = bmi > 120 ? "��" : "�� ��";
		System.out.printf("����� : %s �Դϴ�.\n", bmiText);
		
		System.out.println("�ƹ��ų� �Է��ϸ� ���α׷��� ����˴ϴ�.");
		String exit = k.next();
		k.close();
	}
}
