import java.util.InputMismatchException;
import java.util.Random;
import java.util.Scanner;

public class PMain3 {

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
			System.out.println("�ֻ��� �������� ~ !! ~ !!");
			System.out.println("=================================");
			System.out.println("�޴� 1 : ���� ����");
			System.out.println("�޴� 2 : ���� ���� �� ������");
			System.out.println("�޴� 3 : �Ӵ� ����");
			System.out.println("�޴� 4 : ���� ��ȯ");
			System.out.println("�޴� 5 : ���α׷� ����");
			System.out.println("=================================");
			System.out.print("�޴��� �����ϼ��� : ");
			try {
				menu = k.nextInt();
				s1: switch (menu) {
				case 1:
					while (menu == 1) {
						if (money < 1000) {
							System.out.println("=================================");
							System.out.println("������ �ݾ� ���� !! �����մϴ�.");
							Thread.sleep(1000);
							waitTime();
							System.out.println();
							break s1;
						}
						System.out.println("=================================");
						System.out.println("������ �����մϴ� !!");
						waitTime();
						System.out.println("�ֻ����� ������ ~~ �� 3�� !!");
						waitTime();
						Thread.sleep(1000);
						for (int i = 0; i < myRoll.length; i++) {
							myRoll[i] = r.nextInt(6) + 1;
							System.out.printf("%d��° ��� : %d\n", i + 1, myRoll[i]);
							Thread.sleep(1000);
							mySum += myRoll[i];
						}
						System.out.println("=================================");
						System.out.printf("�� �� : \" %d !\"\n", mySum);
						System.out.println("=================================");
						Thread.sleep(1000);
						System.out.println("������ �����մϴ�.");
						Thread.sleep(1000);
						System.out.println("=================================");
						System.out.println("�ֻ��� ����");
						System.out.println("=================================");
						System.out.println("3 ~ 5 : ���� 2�� !! (��� ����)");
						System.out.println("6 ~ 8: ���� 1.8�� !!");
						System.out.println("9 ~ 11: ���� 1.5�� !!");
						System.out.println("12 ~ 14 : ���� 1.3�� !!");
						System.out.println("15 ~ 18 : ���� 1.1�� !!");
						System.out.println("=================================");
						Thread.sleep(2000);
						System.out.printf("���� ������ : %,d��\n", money);
						while (true) {
							System.out.println("=================================");
							System.out.print("�ݾ� ( 1,000�� �̻� !! ) : ");
							batting = k.nextInt();
							System.out.println("=================================");
							if (batting % 500 == 0) {
								if (batting >= 1000 && money >= batting) {
									money -= batting;
									break;
								} else if (batting < 1000) {
									System.out.println("1,000���̻� �����ϼ��� ��.��");
								} else {
									System.out.println("�������� �����մϴ�.");
								}

							} else {
								System.out.println("�⺻ ���� 500��");
							}
						}
						System.out.printf("%,d�� ���� ! �����մϴ� !\n", batting);
						Thread.sleep(1000);
						System.out.println("=================================");
						System.out.println("���� ���");
						waitTime();
						for (int i = 0; i < comRoll.length; i++) {
							comRoll[i] = r.nextInt(6) + 1;
							System.out.printf("%d��° ��� : %d\n", i + 1, comRoll[i]);
							Thread.sleep(1000);
							comSum += comRoll[i];
						}
						System.out.println("=================================");
						System.out.printf("���� �� �� : \" %d !\"\n", comSum);
						System.out.println("=================================");
						Thread.sleep(1000);
						if (mySum > comSum) {
							System.out.println("�̰�� !!");
							System.out.println("=================================");
							Thread.sleep(1000);
							if (mySum >= 3 && mySum <= 5) {
								System.out.println("!!! 2�� !!!");
								System.out.printf("%,.0f���� ������ϴ� \\^_^/\n", batting * 2.0);
								money += (batting * 2);
							} else if (mySum >= 6 && mySum <= 8) {
								System.out.println("!!! 1.8�� !!!");
								System.out.printf("%,.0f���� ������ϴ� \\^_^/\n", batting * 1.8);
								money += (batting * 1.8);
							} else if (mySum >= 9 && mySum <= 11) {
								System.out.println("!!! 1.5�� !!!");
								System.out.printf("%,.0f���� ������ϴ� \\^_^/\n", batting * 1.5);
								money += (batting * 1.5);
							} else if (mySum >= 12 && mySum <= 14) {
								System.out.println("!!! 1.3�� !!!");
								System.out.printf("%,.0f���� ������ϴ� \\^_^/\n", batting * 1.3);
								money += (batting * 1.3);
							} else if (mySum >= 15 && mySum <= 18) {
								System.out.println("!!! 1.1�� !!!");
								System.out.printf("%,.0f���� ������ϴ� \\^_^/\n", batting * 1.1);
								money += (batting * 1.1);
							}
							win++;
						} else if (mySum < comSum) {
							System.out.println("����... ");
							System.out.println("=================================");
							Thread.sleep(1000);
							System.out.printf("%,d���� �Ҿ����ϴ� ��_��\n", batting);
							lose++;
						} else {
							System.out.println("���� .. ??");
							System.out.println("=================================");
							Thread.sleep(1000);
							if (mySum >= 3 && mySum <= 5) {
								System.out.println("!!! 2�� !!!");
								System.out.printf("%,.0f���� ������ϴ� \\^_^/\n", batting * 2.0);
								money += (batting * 2);
							} else {
								System.out.printf("%,d���� �����޽��ϴ�\n", batting);
								money += batting;
							}
						}
						mySum = comSum = 0;
						WinLoseDraw = win + draw + lose;
						System.out.println("=================================");
						w2: while (true) {
							System.out.print("�絵�� ?? (Y : 1/ N : 2) : ");
							menu = k.nextInt();
							System.out.println();
							switch (menu) {
							case 1:
								break w2;
							case 2:
								System.out.println("=================================");
								System.out.println("�޴��� �ٽ� ���ư��ϴ�.");
								Thread.sleep(1000);
								waitTime();
								System.out.println();
								break s1;
							default:
								System.out.println("=================================");
								System.out.println("�߸��� �Է��Դϴ�.");
								System.out.println("�ٽ� �Է����ּ���.");
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
					System.out.println("���� ���� �� �������� ����մϴ�.");
					Thread.sleep(1000);
					System.out.println("=================================");
					System.out.printf("���� ���� : %d�� %d�� %d��\n", win, draw, lose);
					System.out.printf("������ : %,d\n", money);
					waitTime();
					break;
				case 3:
					loanMoney = 500000;
					System.out.println("=================================");
					System.out.println("~ �Ӵ� ���� �ý��� ~");
					Thread.sleep(1000);
					System.out.println("=================================");
					// �ּ� 5�� �̻� �ؾ� �� �� �ֵ���
					if (WinLoseDraw < 5) {
						System.out.println("���� ~ ���� ~ 3���� �ؾ��� ^~^ ");
						Thread.sleep(2000);
						System.out.println("=================================");
						System.out.printf("3�� �ϰ� ���� ~~ %d�� °�� ~~\n", WinLoseDraw);
						Thread.sleep(2000);
						waitTime();
						break;
					}
					if (accloan >= loanMoney) {
						System.out.printf("�� ? %,d�� ��? ���̻� �ȵſ� ~ \n", accloan);
						Thread.sleep(2000);
						System.out.println("=================================");
						System.out.println("�ո��� ���ư��� ~ ���ư����� ��");
						Thread.sleep(2000);
						waitTime();
						break;
					}
					while (true) {
						System.out.print("���� (1õ�� ~ 50����) : ");
						repayMoney = k.nextInt();
						if (repayMoney >= 1000 && repayMoney <= loanMoney && (repayMoney % 500 == 0)) {
							break;
						} else if (repayMoney % 500 != 0) {
							System.out.println("=================================");
							System.out.println("�⺻ ���� 500��");
							waitTime();
						} else if (repayMoney < 1000) {
							System.out.println("=================================");
							System.out.println("1,000���̻���� ��.��");
							waitTime();
						} else {
							System.out.println("=================================");
							System.out.println("�װ� �� ���ƿ� ��.��");
							waitTime();
						}
					}
					System.out.println("=================================");
					System.out.printf("%,d���� ���Ƚ��ϴ�...\n", repayMoney);
					Thread.sleep(1000);
					System.out.println("�� �����ž� �մϴ�...");
					waitTime();
					money += repayMoney;
					accloan += repayMoney;
					System.out.printf("�� %,d��~ �˾Ƶνö�� ~ ^.^\n", accloan);
					System.out.println("=================================");
					break;
				case 4:
					System.out.println("=================================");
					System.out.println("~ ���� ��ȯ �ý��� ~");
					Thread.sleep(1000);
					System.out.println("=================================");
					System.out.printf("������ �ݾ� : %,d��\n", accloan);
					Thread.sleep(1000);
					System.out.println("=================================");
					if (accloan == 0) {
						System.out.println("���� ���� �����ϴ�.");
						System.out.println("=================================");
						System.out.println("�޴��� �ٽ� ���ư��ϴ�.");
						waitTime();
						break;
					}
					while (true) {
						System.out.print("���� �� : ");
						loanMoney = k.nextInt();
						if (loanMoney % 500 != 0) {
							System.out.println("=================================");
							System.out.println("�⺻ ���� 500��");
							waitTime();
						}
						if (loanMoney <= accloan) {
							money -= loanMoney;
							accloan -= loanMoney;
							break;
						}
						System.out.println("�ݾ��� �� �´µ��� ~ ?");
						waitTime();
					}
					System.out.println("=================================");
					System.out.printf("%,d���� ���ҽ��ϴ�.\n", loanMoney);
					Thread.sleep(1000);
					System.out.println("=================================");
					System.out.printf("���� ����� : %,d��\n", accloan);
					if (accloan == 0) {
						System.out.println("=================================");
						System.out.println("����߾��� ����� ^&^ �� ���� ~~");
						
					}
					waitTime();
					break;
				case 5:
					System.out.println("=================================");
					System.out.println("���α׷��� �����մϴ�.");
					waitTime();
					System.out.println();
					break w1;

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
				System.out.println("ó������ ���ư��ϴ�.");
				waitTime();
				k = new Scanner(System.in);
				System.out.println();
			}
		}
	}
}
