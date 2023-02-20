import java.util.Scanner;

// Ctrl + Shift + / (numpad) : �Լ� �ݱ�
// Ctrl + Shift + * (numpad) : �Լ� ����
// ã�� ���� ��
//		-> Ctrl + F : ã�� ���� !

public class FMain3 {

	public static void getBMI(double height, double weight) {

		System.out.printf("���� : %.1f cm\n", height);
		System.out.printf("������ : %.1f kg\n", weight);

		double stdWeight = (height - 100) * 0.9;
		double bmi = (weight / stdWeight) * 100;
		String bmiText = bmi > 120 ? "��" : "�� ��";
		System.out.printf("����� : %s �Դϴ�.\n", bmiText);
		System.out.println();

	}

	public static void getBMI() {
		Scanner k = new Scanner(System.in);

		System.out.print("������ �Է��ϼ��� : ");
		double height = k.nextDouble();
		System.out.print("�����Ը� �Է��ϼ��� : ");
		double weight = k.nextDouble();

		System.out.printf("���� : %.1f cm\n", height);
		System.out.printf("������ : %.1f kg\n", weight);

		double stdWeight = (height - 100) * 0.9;
		double bmi = (weight / stdWeight) * 100;
		String bmiText = bmi > 120 ? "��" : "�� ��";
		System.out.printf("����� : %s �Դϴ�.\n", bmiText);
		System.out.println();

	}

	public static double getHeight() {
		Scanner k = new Scanner(System.in);
		System.out.print("������ �Է��ϼ��� : ");
		double height = k.nextDouble();
		return height;
	}

	public static double getWeight() {
		Scanner k = new Scanner(System.in);
		System.out.print("�����Ը� �Է��ϼ��� : ");
		double Weight = k.nextDouble();
		return Weight;
	}
	
	public static double getStdWeight(double height) {
		double stdWeight = (height - 100) * 100; 
		return stdWeight;
	}
	
	public static double getBmiResult(double weight, double stdWeight) {
		double bmi = (weight / stdWeight) * 100;
		return bmi;
	}
	
	public static String printBmiResult(double bmi) {
		String bmiResult = (bmi > 120) ? "��" : "�� ��";
		return bmiResult;
	}
	
	public static void main(String[] args) {
//		getBMI(178.1, 83.5);
//		getBMI();
		
		double height = getHeight();
		double weight = getWeight();
		double stdWeight = getStdWeight(height);
		double bmi = getBmiResult(weight, stdWeight);
		String bmiResult = printBmiResult(bmi);
		System.out.println(bmiResult);
		

	}
}
