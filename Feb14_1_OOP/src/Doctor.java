
public class Doctor {
	String doctorName;
	int doctorAge;

	public void callPatient(Patient p) {
		System.out.printf("%s ȯ�ں� �������� ~ \n", p.patientName);
	}

//	public void askHeight() {
//		System.out.println("Ű�� ��� �Ǽ��� ~ ? : ");
//		
//	}
	
//	public void askWeight() {
//		System.out.println("�����԰� ��� �Ǽ��� ~ ?");
//	}

//	public double getBMI(int height, int weight) {
//		double heightTometer = (double) height / 100;
//		return weight / (heightTometer * heightTometer);
//	}

	public double askHeight(Patient p) {
		System.out.println("Ű�� ��� �Ǽ��� ~ ? : ");
		double h = p.answerHeight();
		return h / 100;
	}
	
	public double askWeight(Patient p) {
		System.out.println("�����԰� ��� �Ǽ��� ~ ? : ");
		double w = p.answerWeight();
		return w;
	}

	public double getBMI(Patient p) {
		return p.weight / p.height * p.height; 
	}

	public void getResult(double bmi) {
		System.out.printf("BMI ��ġ�� %.1f �����̾�� ~ \n", bmi);
	}

	public void printResult(double bmi) {
		if (bmi >= 40) {
			System.out.printf("%.1f �� \"����\" �̼���...  \n", bmi);
		} else if (bmi >= 35) {
			System.out.printf("%.1f �� \"��������\" �̼���...  \n", bmi);
		} else if (bmi >= 30) {
			System.out.printf("%.1f �� \"�浵��\" �̼���...  \n", bmi);
		} else if (bmi >= 25) {
			System.out.printf("%.1f �� \"��ü��\" �̼���..!  \n", bmi);
		} else if (bmi >= 18.5) {
			System.out.printf("%.1f �� \"����\" �̼���..!  \n", bmi);
		} else {
			System.out.printf("%.1f �� \"��ü��\" �̼���..!  \n", bmi);
		}
	}
	
	public void doBMIProgram(Patient p) {
		callPatient(p);
//		Patient p = new Patient();
//		p.patientName = "�Ѹ�";
//		callPatient(p);
//		System.out.println("==============================");
//		askHeight();
//		System.out.println("==============================");
//		p.replyHeight(height);
//		System.out.println("==============================");
//		askWeight();
//		System.out.println("==============================");
//		p.replyWeight(weight);
//		System.out.println("==============================");
//		double bmi = getBMI(height, weight);
//		getResult(bmi);
//		System.out.println("==============================");
//		printResult(bmi);
//		System.out.println("==============================");
	}
}
