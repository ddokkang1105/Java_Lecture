import java.util.Scanner;

public class YMain1 {
	public static void main(String[] args) {
		Scanner k = new Scanner(System.in);

//		System.out.print("야구공의 개수를 입력하세요 : ");
//		int ball = k.nextInt();
//
//		int box = (ball % 6 == 0) ? ball / 6 : ball / 6 + 1;
//		System.out.printf("야구공 : %d\n", ball);
//		System.out.printf("상자 : %d\n", box);

		System.out.print("신장을 입력하세요 : ");
		double height = k.nextDouble();
		System.out.print("몸무게를 입력하세요 : ");
		double weight = k.nextDouble();

		System.out.printf("신장 : %.1f cm\n", height);
		System.out.printf("몸무게 : %.1f kg\n", weight);

		double genWeight = (height - 100) * 0.9;
		double bmi = (weight / genWeight) * 100;
		String bmiText = bmi > 120 ? "비만" : "안 비만";
		System.out.printf("당신은 : %s 입니다.\n", bmiText);
		
		System.out.println("아무거나 입력하면 프로그램이 종료됩니다.");
		String exit = k.next();
		k.close();
	}
}
