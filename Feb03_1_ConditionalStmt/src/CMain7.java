import java.util.Scanner;

public class CMain7 {

	public static double getHeight() {
		Scanner k = new Scanner(System.in);
		System.out.print("신장을 입력하세요 : ");
		return k.nextDouble();
	}

	public static double getWeight() {
		Scanner k = new Scanner(System.in);
		System.out.print("몸무게를 입력하세요 : ");
		return k.nextDouble();
	}

	public static double getBmi(double height, double weight) {
		double heightToMeter = height / 100;
		return weight / (heightToMeter * heightToMeter);
	}

//	public static void getBmiResultTest(double bmi) {
//		if (bmi >= 40) {
//			System.out.printf("BMI : %.1f\n",bmi);
//			System.out.println("고도비만.....  무조건 빼야해요...");
//			
//		} else if (bmi >= 35) {
//			System.out.printf("BMI : %.1f\n",bmi);
//			System.out.println("중증도 비만... 살빼야 해요 ~");
//			
//		} else if (bmi >= 30) {
//			System.out.printf("BMI : %.1f\n",bmi);
//			System.out.println("경도비만.. 슬슬 빼야 해요 ~");
//			
//		} else if (bmi >= 25) {
//			System.out.printf("BMI : %.1f\n",bmi);
//			System.out.println("과체중 !! 조심해야 해요 ~");
//			
//		} else if (bmi >= 18.5) {
//			System.out.printf("BMI : %.1f\n",bmi);
//			System.out.println("정상체중 !! 유지합시다 ~");
//			
//		} else {
//			System.out.printf("BMI : %.1f\n",bmi);
//			System.out.println("저체중이니까 밥을 더 먹읍시다.");
//		}
//	}

//	public static char returnBmiToChar(double bmi) {
//		char charBmi = ' ';
//		if (bmi >= 40) {
//			System.out.printf("BMI : %.1f\n", bmi);
//			charBmi = '고';
//		} else if (bmi >= 35) {
//			System.out.printf("BMI : %.1f\n", bmi);
//			charBmi = '중';
//		} else if (bmi >= 30) {
//			System.out.printf("BMI : %.1f\n", bmi);
//			charBmi = '경';
//		} else if (bmi >= 25) {
//			System.out.printf("BMI : %.1f\n", bmi);
//			charBmi = '과';
//		} else if (bmi >= 18.5) {
//			System.out.printf("BMI : %.1f\n", bmi);
//			charBmi = '정';
//		} else {
//			System.out.printf("BMI : %.1f\n", bmi);
//			charBmi = '저';
//		}
//		
//		return charBmi;
//	}

	public static char returnBmiToChar(double bmi) {
		char charBmi = '저';
		if (bmi >= 40) {
			System.out.printf("BMI : %.1f\n", bmi);
			charBmi = '고';
		} else if (bmi >= 35) {
			System.out.printf("BMI : %.1f\n", bmi);
			charBmi = '중';
		} else if (bmi >= 30) {
			System.out.printf("BMI : %.1f\n", bmi);
			charBmi = '경';
		} else if (bmi >= 25) {
			System.out.printf("BMI : %.1f\n", bmi);
			charBmi = '과';
		} else if (bmi >= 18.5) {
			System.out.printf("BMI : %.1f\n", bmi);
			charBmi = '정';
		} 
		
		return charBmi;
	}

	public static void getBmiResult(char charBmi) {
		switch (charBmi) {
		case '고':
			System.out.println("고도비만.....  무조건 빼야해요...");
			System.out.println("*****************************");
			System.out.println();
			break;
		case '중':
			System.out.println("중증도 비만... 살빼야 해요 ~");
			System.out.println("*****************************");
			System.out.println();
			break;
		case '경':
			System.out.println("경도비만.. 슬슬 빼야 해요 ~");
			System.out.println("*****************************");
			System.out.println();
			break;
		case '과':
			System.out.println("과체중 !! 조심해야 해요 ~");
			System.out.println("*****************************");
			System.out.println();
			break;
		case '정':
			System.out.println("정상체중 !! 유지합시다 ~");
			System.out.println("*****************************");
			System.out.println();
			break;
		case '저':
			System.out.println("저체중이니까 밥을 더 먹읍시다.");
			System.out.println("*****************************");
			System.out.println();
			break;

		default:
			break;
		}
	}
	
	
	
	public static String exitProgram() {
		System.out.println("종료하려면 아무거나 누르세요.");
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
