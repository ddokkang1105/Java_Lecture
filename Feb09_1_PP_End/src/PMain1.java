import java.util.Scanner;

public class PMain1 {

	public static void showProgram() {
		System.out.println("-------------------------------");
		System.out.println("1번. 학생 수 입력");
		System.out.println("2번. 학생 점수 입력");
		System.out.println("3번. 학생 점수리스트 출력");
		System.out.println("4번. 최고점수와 평균점수 출력");
		System.out.println("5번. 프로그램 종료");
		System.out.println("-------------------------------");
	}

	public static int insertNo() {
		int choice = 0;
		Scanner k = new Scanner(System.in);
		System.out.print("1 ~ 5번을 입력하세요: ");
		choice = k.nextInt();
		System.out.println("-------------------------------");
		return choice;
	}

	public static int insertStuNum() {
		int stuNum = 0;
		Scanner k = new Scanner(System.in);
		System.out.printf("학생 수를 입력해주세요 : ");
		stuNum = k.nextInt();
		System.out.println("-------------------------------");
		if (stuNum <= 0) {
			System.out.println("잘못된 학생 수 입니다.");
			System.out.println();
			System.out.println("다시 시도해 주세요.");
			System.out.println("-------------------------------");
			return stuNum;
		}
		System.out.printf("입력한 학생 수는 \"%d\"명 입니다.\n", stuNum);
		System.out.println("-------------------------------");
		return stuNum;
	}

	public static int[] insertStuScore(int stuNum) {
		int[] stuScore = new int[stuNum];
		Scanner k = new Scanner(System.in);
		if (stuNum <= 0) {
			System.out.println("학생 수가 입력되지 않았습니다.");
			System.out.println();
			System.out.println("다시 시도해 주세요.");
			return stuScore;
		}
		System.out.println("학생 점수를 입력주세요.");
		System.out.println("-------------------------------");
		for (int i = 0; i < stuScore.length; i++) {
			System.out.printf("%d번째 학생의 점수 : ", i + 1);
			stuScore[i] = k.nextInt();
			if (stuScore[i] < 0 || stuScore[i] > 100) {
				System.out.println("-------------------------------");
				System.out.println("점수가 잘못 입력되었습니다.");
				System.out.println("다시 입력하세요.");
				System.out.println("-------------------------------");
				i--;
			}
		}
		System.out.println("-------------------------------");
		System.out.printf("%d명의 학생 점수가 모두 입력되었습니다.\n", stuNum);
		return stuScore;
	}

	public static void printStuScore(int[] stuScore) {
		if (stuScore == null) {
			System.out.println("학생 수 또는 점수가 입력되지 않았습니다.");
			System.out.println();
			System.out.println("다시 시도해 주세요.");
			System.out.println("-------------------------------");
			return;
		}
		for (int i = 0; i < stuScore.length; i++) {
			System.out.printf("%d번째 학생의 점수 : %d\n", i + 1, stuScore[i]);
		}
		System.out.println("-------------------------------");
	}

	public static void printStuMaxAvrScore(int[] stuScore) {
		if (stuScore == null) {
			System.out.println("학생 수 또는 점수가 입력되지 않았습니다.");
			System.out.println();
			System.out.println("다시 시도해 주세요.");
			System.out.println("-------------------------------");
			return;
		}
		int maxScore = 0;
		double avrScore = 0;
		for (int i = 0; i < stuScore.length; i++) {
			// 최고점수 구하기
			if (i == 0) {
				maxScore = stuScore[0];
			}
			if (maxScore < stuScore[i]) {
				maxScore = stuScore[i];
			}

			// 평균점수 구하기
			avrScore += stuScore[i] / (double) stuScore.length;
		}
		System.out.printf("%d명 학생의 최고점수 : %d\n", stuScore.length, maxScore);
		System.out.printf("%d명 학생의 평균점수 : %.01f\n", stuScore.length, avrScore);
		System.out.println("-------------------------------");

	}

	public static void exitProgram() {
		System.out.println("프로그램을 종료합니다.");
	}

	public static void printWait() throws InterruptedException {
		Thread.sleep(1000);
		System.out.println();
		System.out.println("♣♣♣♣♣♣♣♣♣♣♣♣♣♣♣♣♣♣♣♣♣♣♣♣♣♣♣♣♣♣♣");
		Thread.sleep(500);
		System.out.println("잠시만 기다려주세요");
		System.out.print(".");
		Thread.sleep(1000);
		System.out.print(" .");
		Thread.sleep(1000);
		System.out.print(" .\n");
		Thread.sleep(500);
		System.out.println("♣♣♣♣♣♣♣♣♣♣♣♣♣♣♣♣♣♣♣♣♣♣♣♣♣♣♣♣♣♣♣");
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
