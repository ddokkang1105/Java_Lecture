import java.util.Scanner;

public class PMain8 {
	
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

	
	public static void main(String[] args) throws InterruptedException {
		
		int choice = 0;
		int stuNum = 0;
		int[] stuScore = null;
		int maxScore = 0;
		double avrScore = 0;
		
		Scanner k = new Scanner(System.in);
		s : while (true) {
			System.out.println("-------------------------------");
			System.out.println("1��. �л� �� �Է�");
			System.out.println("2��. �л� ���� �Է�");
			System.out.println("3��. �л� ��������Ʈ ���");
			System.out.println("4��. �ְ������� ������� ���");
			System.out.println("5��. ���α׷� ����");
			System.out.println("-------------------------------");
			System.out.print("1 ~ 5���� �Է��ϼ���: ");
			choice = k.nextInt();
			System.out.println("-------------------------------");
			switch (choice) {
			case 1:
				System.out.printf("�л� ���� �Է����ּ��� : ");
				stuNum = k.nextInt();
				System.out.println("-------------------------------");
				if (stuNum <= 0) {
					System.out.println("�߸��� �л� �� �Դϴ�.");
					System.out.println();
					System.out.println("�ٽ� �õ��� �ּ���.");
					printWait();
					break;
				}
				stuScore = new int[stuNum];
				System.out.printf("�Է��� �л� ���� \"%d\"�� �Դϴ�.\n", stuNum);
				printWait();
				break;
			case 2:
				if (stuNum <= 0) {
					System.out.println("�л� ���� �Էµ��� �ʾҽ��ϴ�.");
					System.out.println();
					System.out.println("�ٽ� �õ��� �ּ���.");
					printWait();
					break;
				}
				System.out.println("�л� ������ �Է��ּ���.");
				System.out.println("-------------------------------");
				for (int i = 0; i < stuScore.length; i++) {
					System.out.printf("%d��° �л��� ���� : ", i + 1);
					stuScore[i] = k.nextInt();
				}
				System.out.println("-------------------------------");
				System.out.printf("%d���� �л� ������ ��� �ԷµǾ����ϴ�.\n", stuNum);
				printWait();
				break;
			case 3:
				if (stuNum <= 0 || stuScore == null) {
					System.out.println("�л� �� �Ǵ� ������ �Էµ��� �ʾҽ��ϴ�.");
					System.out.println();
					System.out.println("�ٽ� �õ��� �ּ���.");
					printWait();
					break;
				}
				for (int i = 0; i < stuScore.length; i++) {
					System.out.printf("%d��° �л��� ���� : %d\n", i + 1, stuScore[i]);
				}
				printWait();
				break;
			case 4:
				if (stuNum <= 0 || stuScore == null) {
					System.out.println("�л� �� �Ǵ� ������ �Էµ��� �ʾҽ��ϴ�.");
					System.out.println();
					System.out.println("�ٽ� �õ��� �ּ���.");
					printWait();
					break;
				}
				for (int i = 0; i < stuScore.length; i++) {
					
					// �ְ����� ���ϱ�
					if (i == 0) {
						maxScore = stuScore[0];
					}
					if (maxScore < stuScore[i]) {
						maxScore = stuScore[i];
					}
					
					// ������� ���ϱ�
					avrScore += stuScore[i] / (double) stuNum;
				}
				System.out.printf("%d�� �л��� �ְ����� : %d\n", stuNum, maxScore);
				System.out.printf("%d�� �л��� ������� : %.01f\n", stuNum, avrScore);
				printWait();
				
				break;
			case 5:
				System.out.println("���α׷��� �����մϴ�.");
				printWait();
				break s;

			default:
				break;
			}
			
			
			
			
			
			
			
			
		}
		
		
		
	}
}
