import java.util.Random;
import java.util.Scanner;

public class PMain3 {

	public static void printRSP() {
		System.out.println("==========================");
		System.out.println("게임을 시작합니다.");
		System.out.println("==========================");
		System.out.println("가위 바위 보 !!");
	}

	public static int getMyRSP() {
		Scanner k = new Scanner(System.in);
		System.out.println("==========================");
		System.out.print("가위(1) 바위(2) 보(3) : ");
		return k.nextInt();

	}

	public static int getComRSP() {
		Random r = new Random();
		return r.nextInt(3) + 1;
	}

	public static void printRSP(int myRSP, int comRSP) {
		String[] rsp = { "가위", "바위", "보" };
		System.out.println("==========================");
		System.out.printf("내가 낸 거 : %s\n", rsp[myRSP - 1]);
		System.out.printf("쟤가 낸 거 : %s\n", rsp[comRSP - 1]);
		System.out.println("==========================");
	}

	public static void compareRSP(int myRSP, int comRSP) throws InterruptedException {
		int win = 0;
		a: while (true) {
			if (myRSP == comRSP) {
				System.out.println("비겼다 !!");
				System.out.println("==========================");
				System.out.println();
			} else {
				if (comRSP == 3) {
					comRSP = 0;
				}
				switch (myRSP - comRSP) {
				case 1:
					win++;
					System.out.println("이겼다 !!");
					System.out.println("==========================");
					System.out.println();
					break;
				case -1:
				case 2:
					System.out.println("졌다 !!");
					System.out.println("==========================");
					System.out.printf("총 %d번 이겼다 !!\n", win);
					System.out.println("==========================");
					System.out.println("ㅋㅋ 종료합니다 ㅋㅋ");
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
		System.out.println("<< 가위바위보 게임 시작 ! >>");
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
		System.out.print("입력 : ");
		int userhand = k.nextInt();
		if (userhand < 1 || userhand > 3) {
			System.out.println("잘못 입력했습니다. 다시 입력하세요.");
		}
		return (userhand >= 1 && userhand <= 3) ? userhand : getUserHand();
	}

	public static void printHand(int user, int com, String[] hand) {
		System.out.println("============================");
		System.out.printf("|| 유저\t\t: %s\t||\n", hand[user]);
		System.out.printf("|| 컴퓨터\t: %s\t||\n", hand[com]);
		System.out.println("============================");
	}

	public static int judge(int user, int com) {
		int game = user - com;
		if (game == 0) {
			System.out.println("무승부");
			return 0;
		} else if (game == -1 || game == 2) {
			System.out.println("패배");
			// 아무거나 넣어도 상관없음
			return -1234;
		} else {
			System.out.println("승리");
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
		System.out.printf("|| %d연승으로 종료 !\t||\n", win);
		System.out.println("============================");
	}

	public static void main(String[] args) throws InterruptedException {
//		doRSP();

		String[] hand = { "ㅋ", "가위", "바위", "보" };
		printStart(hand);

		int com = 0;
		int user = 0;
		int win = 0;

		win = getResult(com, user, win, hand);
		printResult(win);

	}
}
