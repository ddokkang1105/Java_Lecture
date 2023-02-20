import java.util.InputMismatchException;
import java.util.Random;
import java.util.Scanner;

public class PMain2 {

	public static void waitTime() throws InterruptedException {
		System.out.println("=================================");
		System.out.println("잠시만 기다려주세요.");
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
			System.out.println("메뉴 1 : 게임 진행");
			System.out.println("메뉴 2 : 게임 전적");
			System.out.println("메뉴 3 : 프로그램 종료");
			System.out.println("=================================");
			System.out.print("메뉴를 선택하세요 : ");
			try {
				menu = k.nextInt();
				switch (menu) {
				case 1:
					System.out.println("=================================");
					System.out.println("게임을 시작합니다 !!");
					waitTime();
					System.out.println("베스킨라빈스 31 ~ Yeah ~");
					System.out.println("=================================");
					b: while (true) {
						System.out.printf("(1 ~ 3)개의 숫자를 입력하세요 : ");
						myInt = k.nextInt();
						if (myInt < 1 || myInt > 3) {
							System.out.println("=================================");
							System.out.println("다시 입력하세요.");
							waitTime();
							continue;
						}
						System.out.println("=================================");
						System.out.print("내가 낸 답 : ");
						for (int i = 0; i < myInt; i++) {
							game++;
							System.out.print(game + " ");
							if (game == 31) {
								System.out.println();
								System.out.println("=================================");
								System.out.println("상대가 이겼다...");
								lose++;
								waitTime();
								break b;
							}
						}

						System.out.println();
						Thread.sleep(1000);
						System.out.println("=================================");
						System.out.print("상대가 낸 답 : ");
						comInt = r.nextInt(3) + 1;
						if (comInt + game >= 31) {
							comInt = 30 - game;
							if (comInt == 0) {
								System.out.print((game + 1) + " ");
								System.out.println();
								System.out.println("=================================");
								System.out.println("내가 이겼다 !!");
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
					System.out.println("게임 전적을 출력합니다.");
					System.out.println("=================================");
					System.out.printf("게임 전적 : %d승 %d패\n", win, lose);
					waitTime();
					break;
				case 3:
					System.out.println("=================================");
					System.out.println("프로그램을 종료합니다.");
					waitTime();
					System.out.println();
					break a;

				default:
					System.out.println("=================================");
					System.out.println("잘못된 입력입니다.");
					System.out.println("다시 입력해주세요.");
					waitTime();
					System.out.println();
					break;
				}
				System.out.println();

			} catch (InputMismatchException e) {
				System.out.println("=================================");
				System.out.println("잘못된 입력입니다.");
				System.out.println("다시 입력해주세요.");
				waitTime();
				k = new Scanner(System.in);
				System.out.println();
				game = 0;
			}

		}

	}
}
