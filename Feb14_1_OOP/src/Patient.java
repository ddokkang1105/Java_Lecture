import java.util.Scanner;

public class Patient {
	String patientName;
	int patientAge;
	Scanner mouth = new Scanner(System.in);
	double height;
	double weight;
	double bmi;
	String bmiResult;
	
	
	
//	public int replyHeight(int height) {
//		System.out.printf("제 키는 %dcm입니다.\n", height);
//		return height;
//	}

	//	public int replyWeight(int weight) {
//		System.out.printf("제 몸무게는 %dkg입니다.\n", weight);
//		return weight;
//	}
	
	public double answerHeight() {
		return mouth.nextDouble();
	}
	
	public double answerWeight() {
		return mouth.nextDouble();
	}
}
