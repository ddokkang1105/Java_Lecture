import java.util.Scanner;

// ���� �ð��� �и��ʷ� ��Ÿ���ִ� ��� :
// System.currentTimeMillis();
// ���밪 ���ϱ� : Math.abs();
// Scanner �̿��ؼ� �Է�
//		keyboard.next(); vs keyboard.nextLine();
//		next()�� ����(space) ������ �Է¹��� ���ڿ��� ��ȯ�ϴ� ���
//		nextLine()�� ���๮��(Enter)�� ġ�� ������ �Է¹��� ���ڿ��� ��ȯ�ϴ� ���



public class YMain1 {
	public static void main(String[] args) throws InterruptedException {
//		double time1 = System.currentTimeMillis();
//		double time_1 = time1 / 1000;
//		double sec = time_1 % 60;
//		double min = time_1 / 60;
//		double hour = min / 60;
//		System.out.printf("%.01f\n", time1);
//		System.out.printf("%.01f\n", sec);
//		System.out.printf("%.01f\n", min);
//		System.out.printf("%.01f\n", hour);

		Scanner k = new Scanner(System.in);
		System.out.println("===============================");
		System.out.print("ù ��° ���� : ");
		String name1 = k.nextLine();
		System.out.println("===============================");
		System.out.println("ENTER Ű�� ������ ���۵˴ϴ�.");
		System.out.println("10�ʿ� ������ �¸� !");
		System.out.print("===============================");
		String ready = k.nextLine();
		System.out.println("�غ� �Ǹ� ENTER Ű�� �����ÿ�.");
		System.out.print("===============================");
		double timeStart1 = System.currentTimeMillis();
		String time = k.nextLine();
		double timeEnd1 = System.currentTimeMillis();
		double time1 = (timeEnd1 - timeStart1) / 1000;
		System.out.printf("%.2f�� !!\n", time1);

		System.out.println("===============================");
		System.out.print("�� ��° ���� : ");
		String name2 = k.nextLine();
		System.out.println("===============================");
		System.out.println("ENTER Ű�� ������ ���۵˴ϴ�.");
		System.out.println("10�ʿ� ������ �¸� !");
		System.out.print("===============================");
		ready = k.nextLine();
		System.out.println("�غ� �Ǹ� ENTER Ű�� �����ÿ�.");
		System.out.print("===============================");
		double timeStart2 = System.currentTimeMillis();
		time = k.nextLine();
		double timeEnd2 = System.currentTimeMillis();
		double time2 = (timeEnd2 - timeStart2) / 1000;
		System.out.printf("%.2f�� !!\n", time2);

		boolean winTime = Math.abs(time1 - 10) > Math.abs(time2 - 10);
		if (winTime) {
			System.out.println("===============================");
			System.out.printf("%s �¸� !!\n", name2);
			System.out.printf("%.2f�� �Դϴ� !!", time2);
		} else {
			System.out.println("===============================");
			System.out.printf("%s �¸� !!\n", name1);
			System.out.printf("%.2f�� �Դϴ� !!", time1);
		}

	}
}
