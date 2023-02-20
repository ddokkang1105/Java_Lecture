import java.util.Scanner;

public class CMain7 {

	public static double getHeight() {
		Scanner k = new Scanner(System.in);
		System.out.print("������ �Է��ϼ��� : ");
		return k.nextDouble();
	}

	public static double getWeight() {
		Scanner k = new Scanner(System.in);
		System.out.print("�����Ը� �Է��ϼ��� : ");
		return k.nextDouble();
	}

	public static double getBmi(double height, double weight) {
		double heightToMeter = height / 100;
		return weight / (heightToMeter * heightToMeter);
	}

//	public static void getBmiResultTest(double bmi) {
//		if (bmi >= 40) {
//			System.out.printf("BMI : %.1f\n",bmi);
//			System.out.println("����.....  ������ �����ؿ�...");
//			
//		} else if (bmi >= 35) {
//			System.out.printf("BMI : %.1f\n",bmi);
//			System.out.println("������ ��... �컩�� �ؿ� ~");
//			
//		} else if (bmi >= 30) {
//			System.out.printf("BMI : %.1f\n",bmi);
//			System.out.println("�浵��.. ���� ���� �ؿ� ~");
//			
//		} else if (bmi >= 25) {
//			System.out.printf("BMI : %.1f\n",bmi);
//			System.out.println("��ü�� !! �����ؾ� �ؿ� ~");
//			
//		} else if (bmi >= 18.5) {
//			System.out.printf("BMI : %.1f\n",bmi);
//			System.out.println("����ü�� !! �����սô� ~");
//			
//		} else {
//			System.out.printf("BMI : %.1f\n",bmi);
//			System.out.println("��ü���̴ϱ� ���� �� �����ô�.");
//		}
//	}

//	public static char returnBmiToChar(double bmi) {
//		char charBmi = ' ';
//		if (bmi >= 40) {
//			System.out.printf("BMI : %.1f\n", bmi);
//			charBmi = '��';
//		} else if (bmi >= 35) {
//			System.out.printf("BMI : %.1f\n", bmi);
//			charBmi = '��';
//		} else if (bmi >= 30) {
//			System.out.printf("BMI : %.1f\n", bmi);
//			charBmi = '��';
//		} else if (bmi >= 25) {
//			System.out.printf("BMI : %.1f\n", bmi);
//			charBmi = '��';
//		} else if (bmi >= 18.5) {
//			System.out.printf("BMI : %.1f\n", bmi);
//			charBmi = '��';
//		} else {
//			System.out.printf("BMI : %.1f\n", bmi);
//			charBmi = '��';
//		}
//		
//		return charBmi;
//	}

	public static char returnBmiToChar(double bmi) {
		char charBmi = '��';
		if (bmi >= 40) {
			System.out.printf("BMI : %.1f\n", bmi);
			charBmi = '��';
		} else if (bmi >= 35) {
			System.out.printf("BMI : %.1f\n", bmi);
			charBmi = '��';
		} else if (bmi >= 30) {
			System.out.printf("BMI : %.1f\n", bmi);
			charBmi = '��';
		} else if (bmi >= 25) {
			System.out.printf("BMI : %.1f\n", bmi);
			charBmi = '��';
		} else if (bmi >= 18.5) {
			System.out.printf("BMI : %.1f\n", bmi);
			charBmi = '��';
		} 
		
		return charBmi;
	}

	public static void getBmiResult(char charBmi) {
		switch (charBmi) {
		case '��':
			System.out.println("����.....  ������ �����ؿ�...");
			System.out.println("*****************************");
			System.out.println();
			break;
		case '��':
			System.out.println("������ ��... �컩�� �ؿ� ~");
			System.out.println("*****************************");
			System.out.println();
			break;
		case '��':
			System.out.println("�浵��.. ���� ���� �ؿ� ~");
			System.out.println("*****************************");
			System.out.println();
			break;
		case '��':
			System.out.println("��ü�� !! �����ؾ� �ؿ� ~");
			System.out.println("*****************************");
			System.out.println();
			break;
		case '��':
			System.out.println("����ü�� !! �����սô� ~");
			System.out.println("*****************************");
			System.out.println();
			break;
		case '��':
			System.out.println("��ü���̴ϱ� ���� �� �����ô�.");
			System.out.println("*****************************");
			System.out.println();
			break;

		default:
			break;
		}
	}
	
	
	
	public static String exitProgram() {
		System.out.println("�����Ϸ��� �ƹ��ų� ��������.");
		return new Scanner(System.in).next();
	}
	
	public static void main(String[] args) {
		double height = getHeight();
		double weight = getWeight();
		double bmi = getBmi(height, weight);
//		getBmiResultTest(bmi);
		char charBmi = returnBmiToChar(bmi);
		getBmiResult(charBmi);
		exitProgram();

	}
}
