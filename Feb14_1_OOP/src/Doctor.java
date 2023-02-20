
public class Doctor {
	String doctorName;
	int doctorAge;

	public void callPatient(Patient p) {
		System.out.printf("%s 환자분 들어오세요 ~ \n", p.patientName);
	}

//	public void askHeight() {
//		System.out.println("키가 어떻게 되세요 ~ ? : ");
//		
//	}
	
//	public void askWeight() {
//		System.out.println("몸무게가 어떻게 되세요 ~ ?");
//	}

//	public double getBMI(int height, int weight) {
//		double heightTometer = (double) height / 100;
//		return weight / (heightTometer * heightTometer);
//	}

	public double askHeight(Patient p) {
		System.out.println("키가 어떻게 되세요 ~ ? : ");
		double h = p.answerHeight();
		return h / 100;
	}
	
	public double askWeight(Patient p) {
		System.out.println("몸무게가 어떻게 되세요 ~ ? : ");
		double w = p.answerWeight();
		return w;
	}

	public double getBMI(Patient p) {
		return p.weight / p.height * p.height; 
	}

	public void getResult(double bmi) {
		System.out.printf("BMI 수치가 %.1f 나오셨어요 ~ \n", bmi);
	}

	public void printResult(double bmi) {
		if (bmi >= 40) {
			System.out.printf("%.1f 는 \"고도비만\" 이세요...  \n", bmi);
		} else if (bmi >= 35) {
			System.out.printf("%.1f 는 \"중증도비만\" 이세요...  \n", bmi);
		} else if (bmi >= 30) {
			System.out.printf("%.1f 는 \"경도비만\" 이세요...  \n", bmi);
		} else if (bmi >= 25) {
			System.out.printf("%.1f 는 \"과체중\" 이세요..!  \n", bmi);
		} else if (bmi >= 18.5) {
			System.out.printf("%.1f 는 \"정상\" 이세요..!  \n", bmi);
		} else {
			System.out.printf("%.1f 는 \"저체중\" 이세요..!  \n", bmi);
		}
	}
	
	public void doBMIProgram(Patient p) {
		callPatient(p);
//		Patient p = new Patient();
//		p.patientName = "둘리";
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
