import java.util.Random;
import java.util.Scanner;

public class PMain3 {

	public static void printRSP() {
		System.out.println("==========================");
		System.out.println("������ �����մϴ�.");
		System.out.println("==========================");
		System.out.println("���� ���� �� !!");
	}

	public static int getMyRSP() {
		Scanner k = new Scanner(System.in);
		System.out.println("==========================");
		System.out.print("����(1) ����(2) ��(3) : ");
		return k.nextInt();

	}

	public static int getComRSP() {
		Random r = new Random();
		return r.nextInt(3) + 1;
	}

	public static void printRSP(int myRSP, int comRSP) {
		String[] rsp = { "����", "����", "��" };
		System.out.println("==========================");
		System.out.printf("���� �� �� : %s\n", rsp[myRSP - 1]);
		System.out.printf("���� �� �� : %s\n", rsp[comRSP - 1]);
		System.out.println("==========================");
	}

	public static void compareRSP(int myRSP, int comRSP) throws InterruptedException {
		int win = 0;
		a: while (true) {
			if (myRSP == comRSP) {
				System.out.println("���� !!");
				System.out.println("==========================");
				System.out.println();
			} else {
				if (comRSP == 3) {
					comRSP = 0;
				}
				switch (myRSP - comRSP) {
				case 1:
					win++;
					System.out.println("�̰�� !!");
					System.out.println("==========================");
					System.out.println();
					break;
				case -1:
				case 2:
					System.out.println("���� !!");
					System.out.println("==========================");
					System.out.printf("�� %d�� �̰�� !!\n", win);
					System.out.println("==========================");
					System.out.println("���� �����մϴ� ����");
					System.out.println("==========================");
					System.out.print(".");
					Thread.sleep(1000);
					System.out.print(" .");
					Thread.sleep(1000);
					System.out.print(" .\n");
					Thread.sleep(1000);
					break a;
				}

			}
			myRSP = getMyRSP();
			comRSP = getComRSP();
			printRSP(myRSP, comRSP);

		}

	}

	public static void doRSP() throws InterruptedException {
		printRSP();
		int myRSP = getMyRSP();
		int comRSP = getComRSP();
		printRSP(myRSP, comRSP);
		compareRSP(myRSP, comRSP);

	}

	///////////////////////////////////////////////////////
	public static void printStart(String[] hand) {
		System.out.println("<< ���������� ���� ���� ! >>");
		System.out.println("============================");
		for (int i = 1; i < hand.length; i++) {
			System.out.printf("|| %d. %s\t\t ||\n", i, hand[i]);

		}
		System.out.println("============================");
	}

	public static int getComHand() {
		Random r = new Random();
		return r.nextInt(3) + 1;
	}

	public static int getUserHand() {
		Scanner k = new Scanner(System.in);
		System.out.print("�Է� : ");
		int userhand = k.nextInt();
		if (userhand < 1 || userhand > 3) {
			System.out.println("�߸� �Է��߽��ϴ�. �ٽ� �Է��ϼ���.");
		}
		return (userhand >= 1 && userhand <= 3) ? userhand : getUserHand();
	}

	public static void printHand(int user, int com, String[] hand) {
		System.out.println("============================");
		System.out.printf("|| ����\t\t: %s\t||\n", hand[user]);
		System.out.printf("|| ��ǻ��\t: %s\t||\n", hand[com]);
		System.out.println("============================");
	}

	public static int judge(int user, int com) {
		int game = user - com;
		if (game == 0) {
			System.out.println("���º�");
			return 0;
		} else if (game == -1 || game == 2) {
			System.out.println("�й�");
			// �ƹ��ų� �־ �������
			return -1234;
		} else {
			System.out.println("�¸�");
			return 1;
		}
	}

	public static int getResult(int com, int user, int win, String[] hand) {
		int result = 0;
		while (true) {
			com = getComHand();
			user = getUserHand();
			printHand(user, com, hand);
			result = judge(user, com);
			if (result == -1234) {
				break;
			}
			win += result;
		}
		return win;
	}

	public static void printResult(int win) {
		System.out.println("============================");
		System.out.printf("|| %d�������� ���� !\t||\n", win);
		System.out.println("============================");
	}

	public static void main(String[] args) throws InterruptedException {
//		doRSP();

		String[] hand = { "��", "����", "����", "��" };
		printStart(hand);

		int com = 0;
		int user = 0;
		int win = 0;

		win = getResult(com, user, win, hand);
		printResult(win);

	}
}
