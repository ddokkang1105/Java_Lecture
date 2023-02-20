import java.util.Scanner;

public class PMain1 {

	public static void showProgram() {
		System.out.println("-------------------------------");
		System.out.println("1��. �л� �� �Է�");
		System.out.println("2��. �л� ���� �Է�");
		System.out.println("3��. �л� ��������Ʈ ���");
		System.out.println("4��. �ְ������� ������� ���");
		System.out.println("5��. ���α׷� ����");
		System.out.println("-------------------------------");
	}

	public static int insertNo() {
		int choice = 0;
		Scanner k = new Scanner(System.in);
		System.out.print("1 ~ 5���� �Է��ϼ���: ");
		choice = k.nextInt();
		System.out.println("-------------------------------");
		return choice;
	}

	public static int insertStuNum() {
		int stuNum = 0;
		Scanner k = new Scanner(System.in);
		System.out.printf("�л� ���� �Է����ּ��� : ");
		stuNum = k.nextInt();
		System.out.println("-------------------------------");
		if (stuNum <= 0) {
			System.out.println("�߸��� �л� �� �Դϴ�.");
			System.out.println();
			System.out.println("�ٽ� �õ��� �ּ���.");
			System.out.println("-------------------------------");
			return stuNum;
		}
		System.out.printf("�Է��� �л� ���� \"%d\"�� �Դϴ�.\n", stuNum);
		System.out.println("-------------------------------");
		return stuNum;
	}

	public static int[] insertStuScore(int stuNum) {
		int[] stuScore = new int[stuNum];
		Scanner k = new Scanner(System.in);
		if (stuNum <= 0) {
			System.out.println("�л� ���� �Էµ��� �ʾҽ��ϴ�.");
			System.out.println();
			System.out.println("�ٽ� �õ��� �ּ���.");
			return stuScore;
		}
		System.out.println("�л� ������ �Է��ּ���.");
		System.out.println("-------------------------------");
		for (int i = 0; i < stuScore.length; i++) {
			System.out.printf("%d��° �л��� ���� : ", i + 1);
			stuScore[i] = k.nextInt();
			if (stuScore[i] < 0 || stuScore[i] > 100) {
				System.out.println("-------------------------------");
				System.out.println("������ �߸� �ԷµǾ����ϴ�.");
				System.out.println("�ٽ� �Է��ϼ���.");
				System.out.println("-------------------------------");
				i--;
			}
		}
		System.out.println("-------------------------------");
		System.out.printf("%d���� �л� ������ ��� �ԷµǾ����ϴ�.\n", stuNum);
		return stuScore;
	}

	public static void printStuScore(int[] stuScore) {
		if (stuScore == null) {
			System.out.println("�л� �� �Ǵ� ������ �Էµ��� �ʾҽ��ϴ�.");
			System.out.println();
			System.out.println("�ٽ� �õ��� �ּ���.");
			System.out.println("-------------------------------");
			return;
		}
		for (int i = 0; i < stuScore.length; i++) {
			System.out.printf("%d��° �л��� ���� : %d\n", i + 1, stuScore[i]);
		}
		System.out.println("-------------------------------");
	}

	public static void printStuMaxAvrScore(int[] stuScore) {
		if (stuScore == null) {
			System.out.println("�л� �� �Ǵ� ������ �Էµ��� �ʾҽ��ϴ�.");
			System.out.println();
			System.out.println("�ٽ� �õ��� �ּ���.");
			System.out.println("-------------------------------");
			return;
		}
		int maxScore = 0;
		double avrScore = 0;
		for (int i = 0; i < stuScore.length; i++) {
			// �ְ����� ���ϱ�
			if (i == 0) {
				maxScore = stuScore[0];
			}
			if (maxScore < stuScore[i]) {
				maxScore = stuScore[i];
			}

			// ������� ���ϱ�
			avrScore += stuScore[i] / (double) stuScore.length;
		}
		System.out.printf("%d�� �л��� �ְ����� : %d\n", stuScore.length, maxScore);
		System.out.printf("%d�� �л��� ������� : %.01f\n", stuScore.length, avrScore);
		System.out.println("-------------------------------");

	}

	public static void exitProgram() {
		System.out.println("���α׷��� �����մϴ�.");
	}

	public static void printWait() throws InterruptedException {
		Thread.sleep(1000);
		System.out.println();
		System.out.println("��������������������������������������������������������������");
		Thread.sleep(500);
		System.out.println("��ø� ��ٷ��ּ���");
		System.out.print(".");
		Thread.sleep(1000);
		System.out.print(" .");
		Thread.sleep(1000);
		System.out.print(" .\n");
		Thread.sleep(500);
		System.out.println("��������������������������������������������������������������");
		System.out.println();
		Thread.sleep(1000);
	}

	public static void doProgram() throws InterruptedException {
		int choice = 0;
		int stuNum = 0;
		int[] stuScore = null;
		a: while (true) {
			showProgram();
			choice = insertNo();
			switch (choice) {
			case 1:
				stuNum = insertStuNum();
				stuScore = null;
				printWait();
				break;
			case 2:
				stuScore = insertStuScore(stuNum);
				printWait();
				break;
			case 3:
				printStuScore(stuScore);
				printWait();
				break;
			case 4:
				printStuMaxAvrScore(stuScore);
				printWait();
				break;
			case 5:
				exitProgram();
				printWait();
				break a;
			default:
				break;
			}
		}
	}

	public static void main(String[] args) throws InterruptedException {
		doProgram();
	}

}
