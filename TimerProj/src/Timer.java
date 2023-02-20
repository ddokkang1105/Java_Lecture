import java.util.InputMismatchException;
import java.util.Scanner;
// import java.util.TimerTask;

public class Timer {

	@SuppressWarnings("resource")
	public static void main(String[] args) throws InterruptedException {

		int hour = 0;
		int min = 0;
		int sec = 0;

		int ans = 0;

		// �ð� ����
		System.out.print("�ð��� �Է��ϼ���: ");
		Scanner hourInput = new Scanner(System.in);

		while (true) {
			try {
				hour = hourInput.nextInt();

				if (hour > 0 && hour < 24) {
					while (true) {

						System.out.print("�Է��� �ð��� " + hour + "�� �½��ϱ�? 1. YES 2. NO : ");
						ans = hourInput.nextInt();
						if (ans == 1) {
							System.out.println(hour + "�÷� �ԷµǾ����ϴ�.");
							System.out.println();
							break;

						} else if (ans == 2) {
							while (true) {
								System.out.print("�缳���� �ð��� �Է����ּ���(1 ~ 23) : ");
								hour = hourInput.nextInt();
								if (hour > 0 && hour < 24) {
									break;
								}
							}

						} else {
							while (true) {
								System.out.print("�߸��� ����Դϴ�. �ð��� �ٽ� �Է����ּ��� : ");
								hour = hourInput.nextInt();
								if (hour > 0 && hour < 24) {
									break;
								}
							}
						}
					}
					break;

				} else {
					System.out.print("1 ~ 23�÷� �ٽ� �Է����ּ��� : ");
				}

			} catch (InputMismatchException e) {
				System.out.print("�߸��� ����Դϴ�. �ð��� �ٽ� �Է����ּ��� : ");
				hourInput = new Scanner(System.in);
			}
		}

		// �� ����
		System.out.print("���� �Է��ϼ���: ");
		Scanner minInput = new Scanner(System.in);

		while (true) {
			try {
				min = minInput.nextInt();

				if (min >= 0 && min < 60) {
					while (true) {

						System.out.print("�Է��� ���� " + min + "�� �½��ϱ�? 1. YES 2. NO : ");
						ans = minInput.nextInt();
						if (ans == 1) {
							System.out.println(min + "������ �ԷµǾ����ϴ�.");
							System.out.println();
							break;

						} else if (ans == 2) {
							while (true) {
								System.out.print("�缳���� ���� �Է����ּ���(0 ~ 59) : ");
								min = minInput.nextInt();
								if (min >= 0 && min < 60) {
									break;
								}
							}

						} else {
							while (true) {
								System.out.print("�߸��� ����Դϴ�. ���� �ٽ� �Է����ּ��� : ");
								min = minInput.nextInt();
								if (min >= 0 && min < 60) {
									break;
								}
							}
						}
					}
					break;

				} else {
					System.out.print("0 ~ 59�� �ٽ� �Է����ּ��� : ");
				}

			} catch (InputMismatchException e) {
				System.out.print("�߸��� ����Դϴ�. ���� �ٽ� �Է����ּ��� : ");
				minInput = new Scanner(System.in);
			}
		}
		
		// �� ����
		System.out.print("�ʸ� �Է��ϼ���: ");
		Scanner secInput = new Scanner(System.in);

		while (true) {
			try {
				sec = secInput.nextInt();

				if (sec >= 0 && sec < 59) {
					while (true) {

						System.out.print("�Է��� �ʰ� " + sec + "�ʰ� �½��ϱ�? 1. YES 2. NO : ");
						ans = secInput.nextInt();
						if (ans == 1) {
							System.out.println(hour + "�ʷ� �ԷµǾ����ϴ�.");
							System.out.println();
							break;

						} else if (ans == 2) {
							while (true) {
								System.out.print("�缳���� �ʸ� �Է����ּ���(0 ~ 59) : ");
								sec = secInput.nextInt();
								if (sec >= 0 && sec < 59) {
									break;
								}
							}

						} else {
							while (true) {
								System.out.print("�߸��� ����Դϴ�. �ʸ� �ٽ� �Է����ּ��� : ");
								sec = secInput.nextInt();
								if (sec >= 0 && sec < 60) {
									break;
								}
							}
						}
					}
					break;

				} else {
					System.out.print("0 ~ 59�ʷ� �ٽ� �Է����ּ��� : ");
				}

			} catch (InputMismatchException e) {
				System.out.print("�߸��� ����Դϴ�. �ʸ� �ٽ� �Է����ּ��� : ");
				secInput = new Scanner(System.in);
			}
		}
		
		System.out.printf("Ÿ�̸� ������ �Ϸ��Ͽ����ϴ� : %02d�� %02d�� %02d��\n", hour, min, sec);
		
		Thread.sleep(5000);
		
		// # 2ȸ��
//		while (true) {
//			try {
//				hour = hourInput.nextInt();
//				if (hour < 1 | hour > 23) {
//					System.out.print("1~23�÷� �ٽ� �Է����ּ��� : ");
//				} else {
//					System.out.println(hour + "�÷� �ԷµǾ����ϴ�.");
//					System.out.println();
//					break;
//				}
//			} catch (InputMismatchException e) {
//				System.out.print("�߸��� �ð��Դϴ�. �ٽ� �Է����ּ��� : ");
//				hourInput = new Scanner(System.in);
//			}
//		}

		// # 1ȸ��
//		while (true) {

//			try {
//				hour = hourInput.nextInt();
//				while (true) {
//					if (hour <= 12) {
//						System.out.println("�Է��� �ð��� " + hour + "�� �½��ϱ�? 1. YES 2. NO : ");
//						try {
//							ans = hourInput.nextInt();
//							if (ans == 1) {
//								System.out.println(hour + "�÷� �ԷµǾ����ϴ�.");
//								System.out.println();
//								break;
//							} else if (ans == 2) {
//								System.out.print("�ð��� �ٽ� �Է����ּ��� : ");
//								hour = hourInput.nextInt();
//							} else {
//								System.out.print("1���� 2������ �ٽ� �Է����ּ��� : ");
//								hourInput = new Scanner(System.in);
//							}
//						} catch (InputMismatchException e) {
//							System.out.print("1���� 2������ �ٽ� �Է����ּ��� : ");
//							hourInput = new Scanner(System.in);
//						}
//
//					} else {
//
//						System.out.print("�߸��� �ð��Դϴ�. �ٽ� �Է����ּ��� : ");
//					}
//					break;
////				else {
////
////					System.out.print("�߸��� �ð��Դϴ�. �ٽ� �Է����ּ��� : ");
//				}
//			} catch (InputMismatchException e) {
//				System.out.print("�߸��� �ð��Դϴ�. �ٽ� �Է����ּ��� : ");
//				hourInput = new Scanner(System.in);
//			}
//
//		}

//		  System.out.print("�ð��� �Է��ϼ���: "); h = input1.nextInt();
//		  System.out.print("���� �Է��ϼ���: "); m = input1.nextInt();
//		  System.out.print("���� �Է��ϼ���: "); s = input1.nextInt();
//		  System.out.printf("Ÿ�̸� ������ �Ϸ��Ͽ����ϴ� : %02d�� %02d�� %02d��\n", h, m, s);
//		  System.out.print("�����Ͻðڽ��ϱ�? 1.Yes 2.No : "); int start = input1.nextInt();

		// while �� ����ϱ� -> 1,2�� �Է����� �ʾ��� �� while (start != 1 & start != 2) {
//		  System.out.print("�ùٸ� ���� �ƴմϴ�. �ٽ� �Է����ּ��� : "); start = input1.nextInt(); 
//		  
//	if(start==1)
//	{
//		System.out.println("Ÿ�̸Ӹ� �����մϴ�.");
//	}else if(start==2)
//	{
//		System.out.println("������ �� �̿����ּ��� !");
//	}else
//	{
//		System.out.println("�ùٸ� ���� �ƴմϴ�. �ٽ� �Է����ּ���.");
//	}

	}

}
