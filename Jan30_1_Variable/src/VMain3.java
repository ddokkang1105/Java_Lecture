
public class VMain3 {
	public static void main(String[] args) {
		// IntroductionMyself();
		TodayLunchGrade();
	}
	
	public static void IntroductionMyself() {
		String myName = "�赵��";
		int year = 2023;
		int month = 1;
		int day = 30;
		String liveIn = "����";
		double sight = -4.0;
		boolean javaExp = true;

		System.out.printf("�̸� : %s\n", myName);
		System.out.printf("���� ��¥ : %4d�� %02d�� %02d��\n", year, month, day);
		System.out.printf("��� �� : %s\n", liveIn);
		System.out.printf("�÷� : %.1f\n", sight);
		System.out.printf("Java ������ ���� : %b\n", javaExp);		
	}
	
	public static void TodayLunchGrade() {
		String lunchMenu = "���";
		int lunchPrice = 10000;
		int lunchCalorie = 555;
		double lunchGrade = 4.6;
		boolean lunchReVisit = true;
		
		System.out.printf("�����̸� : %s\n", lunchMenu);
		System.out.printf("���ɰ��� : %d��\n", lunchPrice);
		System.out.printf("����Į�θ� : %d\n", lunchCalorie);
		System.out.printf("�������� : %.1f��\n", lunchGrade);
		System.out.printf("���߿� �� ���� ������ : %b\n", lunchReVisit);		
		
	}
}
