import java.util.InputMismatchException;
import java.util.Random;
import java.util.Scanner;

public class PMain2 {

	public static void waitTime() throws InterruptedException {
		System.out.println("=================================");
		System.out.println("��ø� ��ٷ��ּ���.");
		System.out.print(".");
		Thread.sleep(1000);
		System.out.print(" .");
		Thread.sleep(1000);
		System.out.print(" .\n");
		Thread.sleep(1000);
		System.out.println("=================================");
	}

	public static void main(String[] args) throws InterruptedException {
		Scanner k = new Scanner(System.in);
		Random r = new Random();
		int menu = 0;
		int game = 0;
		int comInt = 0;
		int myInt = 0;
		int win = 0;
		int lose = 0;

		a: while (true) {
			System.out.println("=================================");
			System.out.println("�޴� 1 : ���� ����");
			System.out.println("�޴� 2 : ���� ����");
			System.out.println("�޴� 3 : ���α׷� ����");
			System.out.println("=================================");
			System.out.print("�޴��� �����ϼ��� : ");
			try {
				menu = k.nextInt();
				switch (menu) {
				case 1:
					System.out.println("=================================");
					System.out.println("������ �����մϴ� !!");
					waitTime();
					System.out.println("����Ų��� 31 ~ Yeah ~");
					System.out.println("=================================");
					b: while (true) {
						System.out.printf("(1 ~ 3)���� ���ڸ� �Է��ϼ��� : ");
						myInt = k.nextInt();
						if (myInt < 1 || myInt > 3) {
							System.out.println("=================================");
							System.out.println("�ٽ� �Է��ϼ���.");
							waitTime();
							continue;
						}
						System.out.println("=================================");
						System.out.print("���� �� �� : ");
						for (int i = 0; i < myInt; i++) {
							game++;
							System.out.print(game + " ");
							if (game == 31) {
								System.out.println();
								System.out.println("=================================");
								System.out.println("��밡 �̰��...");
								lose++;
								waitTime();
								break b;
							}
						}

						System.out.println();
						Thread.sleep(1000);
						System.out.println("=================================");
						System.out.print("��밡 �� �� : ");
						comInt = r.nextInt(3) + 1;
						if (comInt + game >= 31) {
							comInt = 30 - game;
							if (comInt == 0) {
								System.out.print((game + 1) + " ");
								System.out.println();
								System.out.println("=================================");
								System.out.println("���� �̰�� !!");
								win++;
								waitTime();
								break b;
							}
						}
						for (int i = 0; i < comInt; i++) {
							game++;
							System.out.print((game) + " ");
						}
						System.out.println();
						System.out.println("=================================");
						System.out.println();
						System.out.println("=================================");
					}
					game = 0;
					break;
				case 2:
					System.out.println("=================================");
					System.out.println("���� ������ ����մϴ�.");
					System.out.println("=================================");
					System.out.printf("���� ���� : %d�� %d��\n", win, lose);
					waitTime();
					break;
				case 3:
					System.out.println("=================================");
					System.out.println("���α׷��� �����մϴ�.");
					waitTime();
					System.out.println();
					break a;

				default:
					System.out.println("=================================");
					System.out.println("�߸��� �Է��Դϴ�.");
					System.out.println("�ٽ� �Է����ּ���.");
					waitTime();
					System.out.println();
					break;
				}
				System.out.println();

			} catch (InputMismatchException e) {
				System.out.println("=================================");
				System.out.println("�߸��� �Է��Դϴ�.");
				System.out.println("�ٽ� �Է����ּ���.");
				waitTime();
				k = new Scanner(System.in);
				System.out.println();
				game = 0;
			}

		}

	}
}
