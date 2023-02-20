import java.util.InputMismatchException;
import java.util.Random;
import java.util.Scanner;

public class PMain3 {

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
		int money = 50000;
		int loanMoney = 0;
		int accloan = 0;
		int repayMoney = 0;
		int batting = 0;
		int comRoll[] = new int[3];
		int myRoll[] = new int[3];
		int comSum = 0;
		int mySum = 0;
		int win = 0;
		int lose = 0;
		int draw = 0;
		int WinLoseDraw = 0;

		w1: while (true) {
			Thread.sleep(1000);
			System.out.println("=================================");
			System.out.println("주사위 굴려굴려 ~ !! ~ !!");
			System.out.println("=================================");
			System.out.println("메뉴 1 : 게임 진행");
			System.out.println("메뉴 2 : 게임 전적 및 소지금");
			System.out.println("메뉴 3 : 머니 대출");
			System.out.println("메뉴 4 : 대출 상환");
			System.out.println("메뉴 5 : 프로그램 종료");
			System.out.println("=================================");
			System.out.print("메뉴를 선택하세요 : ");
			try {
				menu = k.nextInt();
				s1: switch (menu) {
				case 1:
					while (menu == 1) {
						if (money < 1000) {
							System.out.println("=================================");
							System.out.println("배팅할 금액 부족 !! 종료합니다.");
							Thread.sleep(1000);
							waitTime();
							System.out.println();
							break s1;
						}
						System.out.println("=================================");
						System.out.println("게임을 시작합니다 !!");
						waitTime();
						System.out.println("주사위를 굴리자 ~~ 총 3번 !!");
						waitTime();
						Thread.sleep(1000);
						for (int i = 0; i < myRoll.length; i++) {
							myRoll[i] = r.nextInt(6) + 1;
							System.out.printf("%d번째 결과 : %d\n", i + 1, myRoll[i]);
							Thread.sleep(1000);
							mySum += myRoll[i];
						}
						System.out.println("=================================");
						System.out.printf("총 합 : \" %d !\"\n", mySum);
						System.out.println("=================================");
						Thread.sleep(1000);
						System.out.println("배팅을 시작합니다.");
						Thread.sleep(1000);
						System.out.println("=================================");
						System.out.println("주사위 숫자");
						System.out.println("=================================");
						System.out.println("3 ~ 5 : 배당금 2배 !! (비김 포함)");
						System.out.println("6 ~ 8: 배당금 1.8배 !!");
						System.out.println("9 ~ 11: 배당금 1.5배 !!");
						System.out.println("12 ~ 14 : 배당금 1.3배 !!");
						System.out.println("15 ~ 18 : 배당금 1.1배 !!");
						System.out.println("=================================");
						Thread.sleep(2000);
						System.out.printf("현재 소지금 : %,d원\n", money);
						while (true) {
							System.out.println("=================================");
							System.out.print("금액 ( 1,000원 이상 !! ) : ");
							batting = k.nextInt();
							System.out.println("=================================");
							if (batting % 500 == 0) {
								if (batting >= 1000 && money >= batting) {
									money -= batting;
									break;
								} else if (batting < 1000) {
									System.out.println("1,000원이상 배팅하세요 ㅡ.ㅡ");
								} else {
									System.out.println("소지금이 부족합니다.");
								}

							} else {
								System.out.println("기본 단위 500원");
							}
						}
						System.out.printf("%,d원 배팅 ! 시작합니다 !\n", batting);
						Thread.sleep(1000);
						System.out.println("=================================");
						System.out.println("상대방 결과");
						waitTime();
						for (int i = 0; i < comRoll.length; i++) {
							comRoll[i] = r.nextInt(6) + 1;
							System.out.printf("%d번째 결과 : %d\n", i + 1, comRoll[i]);
							Thread.sleep(1000);
							comSum += comRoll[i];
						}
						System.out.println("=================================");
						System.out.printf("상대방 총 합 : \" %d !\"\n", comSum);
						System.out.println("=================================");
						Thread.sleep(1000);
						if (mySum > comSum) {
							System.out.println("이겼다 !!");
							System.out.println("=================================");
							Thread.sleep(1000);
							if (mySum >= 3 && mySum <= 5) {
								System.out.println("!!! 2배 !!!");
								System.out.printf("%,.0f원을 얻었습니다 \\^_^/\n", batting * 2.0);
								money += (batting * 2);
							} else if (mySum >= 6 && mySum <= 8) {
								System.out.println("!!! 1.8배 !!!");
								System.out.printf("%,.0f원을 얻었습니다 \\^_^/\n", batting * 1.8);
								money += (batting * 1.8);
							} else if (mySum >= 9 && mySum <= 11) {
								System.out.println("!!! 1.5배 !!!");
								System.out.printf("%,.0f원을 얻었습니다 \\^_^/\n", batting * 1.5);
								money += (batting * 1.5);
							} else if (mySum >= 12 && mySum <= 14) {
								System.out.println("!!! 1.3배 !!!");
								System.out.printf("%,.0f원을 얻었습니다 \\^_^/\n", batting * 1.3);
								money += (batting * 1.3);
							} else if (mySum >= 15 && mySum <= 18) {
								System.out.println("!!! 1.1배 !!!");
								System.out.printf("%,.0f원을 얻었습니다 \\^_^/\n", batting * 1.1);
								money += (batting * 1.1);
							}
							win++;
						} else if (mySum < comSum) {
							System.out.println("졌다... ");
							System.out.println("=================================");
							Thread.sleep(1000);
							System.out.printf("%,d원을 잃었습니다 ㅠ_ㅠ\n", batting);
							lose++;
						} else {
							System.out.println("비겼다 .. ??");
							System.out.println("=================================");
							Thread.sleep(1000);
							if (mySum >= 3 && mySum <= 5) {
								System.out.println("!!! 2배 !!!");
								System.out.printf("%,.0f원을 얻었습니다 \\^_^/\n", batting * 2.0);
								money += (batting * 2);
							} else {
								System.out.printf("%,d원을 돌려받습니다\n", batting);
								money += batting;
							}
						}
						mySum = comSum = 0;
						WinLoseDraw = win + draw + lose;
						System.out.println("=================================");
						w2: while (true) {
							System.out.print("재도전 ?? (Y : 1/ N : 2) : ");
							menu = k.nextInt();
							System.out.println();
							switch (menu) {
							case 1:
								break w2;
							case 2:
								System.out.println("=================================");
								System.out.println("메뉴로 다시 돌아갑니다.");
								Thread.sleep(1000);
								waitTime();
								System.out.println();
								break s1;
							default:
								System.out.println("=================================");
								System.out.println("잘못된 입력입니다.");
								System.out.println("다시 입력해주세요.");
								Thread.sleep(1000);
								waitTime();
								System.out.println();
								break;
							}
						}
					}
					break;
				case 2:
					System.out.println("=================================");
					System.out.println("게임 전적 및 소지금을 출력합니다.");
					Thread.sleep(1000);
					System.out.println("=================================");
					System.out.printf("게임 전적 : %d승 %d무 %d패\n", win, draw, lose);
					System.out.printf("소지금 : %,d\n", money);
					waitTime();
					break;
				case 3:
					loanMoney = 500000;
					System.out.println("=================================");
					System.out.println("~ 머니 대출 시스템 ~");
					Thread.sleep(1000);
					System.out.println("=================================");
					// 최소 5번 이상 해야 할 수 있도록
					if (WinLoseDraw < 5) {
						System.out.println("에이 ~ 형씨 ~ 3판은 해야지 ^~^ ");
						Thread.sleep(2000);
						System.out.println("=================================");
						System.out.printf("3판 하고 와유 ~~ %d판 째야 ~~\n", WinLoseDraw);
						Thread.sleep(2000);
						waitTime();
						break;
					}
					if (accloan >= loanMoney) {
						System.out.printf("뭐 ? %,d원 빚? 더이상 안돼요 ~ \n", accloan);
						Thread.sleep(2000);
						System.out.println("=================================");
						System.out.println("손모가지 날아가요 ~ 돌아가세요 ㅋ");
						Thread.sleep(2000);
						waitTime();
						break;
					}
					while (true) {
						System.out.print("대출 (1천원 ~ 50만원) : ");
						repayMoney = k.nextInt();
						if (repayMoney >= 1000 && repayMoney <= loanMoney && (repayMoney % 500 == 0)) {
							break;
						} else if (repayMoney % 500 != 0) {
							System.out.println("=================================");
							System.out.println("기본 단위 500원");
							waitTime();
						} else if (repayMoney < 1000) {
							System.out.println("=================================");
							System.out.println("1,000원이상부터 ㅡ.ㅡ");
							waitTime();
						} else {
							System.out.println("=================================");
							System.out.println("그건 못 갚아요 ㅡ.ㅡ");
							waitTime();
						}
					}
					System.out.println("=================================");
					System.out.printf("%,d원을 빌렸습니다...\n", repayMoney);
					Thread.sleep(1000);
					System.out.println("꼭 갚으셔야 합니다...");
					waitTime();
					money += repayMoney;
					accloan += repayMoney;
					System.out.printf("총 %,d원~ 알아두시라고 ~ ^.^\n", accloan);
					System.out.println("=================================");
					break;
				case 4:
					System.out.println("=================================");
					System.out.println("~ 대출 상환 시스템 ~");
					Thread.sleep(1000);
					System.out.println("=================================");
					System.out.printf("대출한 금액 : %,d원\n", accloan);
					Thread.sleep(1000);
					System.out.println("=================================");
					if (accloan == 0) {
						System.out.println("갚을 돈이 없습니다.");
						System.out.println("=================================");
						System.out.println("메뉴로 다시 돌아갑니다.");
						waitTime();
						break;
					}
					while (true) {
						System.out.print("갚을 돈 : ");
						loanMoney = k.nextInt();
						if (loanMoney % 500 != 0) {
							System.out.println("=================================");
							System.out.println("기본 단위 500원");
							waitTime();
						}
						if (loanMoney <= accloan) {
							money -= loanMoney;
							accloan -= loanMoney;
							break;
						}
						System.out.println("금액이 안 맞는데요 ~ ?");
						waitTime();
					}
					System.out.println("=================================");
					System.out.printf("%,d원을 갚았습니다.\n", loanMoney);
					Thread.sleep(1000);
					System.out.println("=================================");
					System.out.printf("남은 대출금 : %,d원\n", accloan);
					if (accloan == 0) {
						System.out.println("=================================");
						System.out.println("고생했어유 사장님 ^&^ 또 봐유 ~~");
						
					}
					waitTime();
					break;
				case 5:
					System.out.println("=================================");
					System.out.println("프로그램을 종료합니다.");
					waitTime();
					System.out.println();
					break w1;

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
				System.out.println("처음으로 돌아갑니다.");
				waitTime();
				k = new Scanner(System.in);
				System.out.println();
			}
		}
	}
}
