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
//		System.out.printf("�� Ű�� %dcm�Դϴ�.\n", height);
//		return height;
//	}

	//	public int replyWeight(int weight) {
//		System.out.printf("�� �����Դ� %dkg�Դϴ�.\n", weight);
//		return weight;
//	}
	
	public double answerHeight() {
		return mouth.nextDouble();
	}
	
	public double answerWeight() {
		return mouth.nextDouble();
	}
}
