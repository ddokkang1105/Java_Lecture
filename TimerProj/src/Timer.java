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

		// 시각 설정
		System.out.print("시각을 입력하세요: ");
		Scanner hourInput = new Scanner(System.in);

		while (true) {
			try {
				hour = hourInput.nextInt();

				if (hour > 0 && hour < 24) {
					while (true) {

						System.out.print("입력한 시각이 " + hour + "시 맞습니까? 1. YES 2. NO : ");
						ans = hourInput.nextInt();
						if (ans == 1) {
							System.out.println(hour + "시로 입력되었습니다.");
							System.out.println();
							break;

						} else if (ans == 2) {
							while (true) {
								System.out.print("재설정할 시각을 입력해주세요(1 ~ 23) : ");
								hour = hourInput.nextInt();
								if (hour > 0 && hour < 24) {
									break;
								}
							}

						} else {
							while (true) {
								System.out.print("잘못된 대답입니다. 시각을 다시 입력해주세요 : ");
								hour = hourInput.nextInt();
								if (hour > 0 && hour < 24) {
									break;
								}
							}
						}
					}
					break;

				} else {
					System.out.print("1 ~ 23시로 다시 입력해주세요 : ");
				}

			} catch (InputMismatchException e) {
				System.out.print("잘못된 대답입니다. 시각을 다시 입력해주세요 : ");
				hourInput = new Scanner(System.in);
			}
		}

		// 분 설정
		System.out.print("분을 입력하세요: ");
		Scanner minInput = new Scanner(System.in);

		while (true) {
			try {
				min = minInput.nextInt();

				if (min >= 0 && min < 60) {
					while (true) {

						System.out.print("입력한 분이 " + min + "분 맞습니까? 1. YES 2. NO : ");
						ans = minInput.nextInt();
						if (ans == 1) {
							System.out.println(min + "분으로 입력되었습니다.");
							System.out.println();
							break;

						} else if (ans == 2) {
							while (true) {
								System.out.print("재설정할 분을 입력해주세요(0 ~ 59) : ");
								min = minInput.nextInt();
								if (min >= 0 && min < 60) {
									break;
								}
							}

						} else {
							while (true) {
								System.out.print("잘못된 대답입니다. 분을 다시 입력해주세요 : ");
								min = minInput.nextInt();
								if (min >= 0 && min < 60) {
									break;
								}
							}
						}
					}
					break;

				} else {
					System.out.print("0 ~ 59로 다시 입력해주세요 : ");
				}

			} catch (InputMismatchException e) {
				System.out.print("잘못된 대답입니다. 분을 다시 입력해주세요 : ");
				minInput = new Scanner(System.in);
			}
		}
		
		// 초 설정
		System.out.print("초를 입력하세요: ");
		Scanner secInput = new Scanner(System.in);

		while (true) {
			try {
				sec = secInput.nextInt();

				if (sec >= 0 && sec < 59) {
					while (true) {

						System.out.print("입력한 초가 " + sec + "초가 맞습니까? 1. YES 2. NO : ");
						ans = secInput.nextInt();
						if (ans == 1) {
							System.out.println(hour + "초로 입력되었습니다.");
							System.out.println();
							break;

						} else if (ans == 2) {
							while (true) {
								System.out.print("재설정할 초를 입력해주세요(0 ~ 59) : ");
								sec = secInput.nextInt();
								if (sec >= 0 && sec < 59) {
									break;
								}
							}

						} else {
							while (true) {
								System.out.print("잘못된 대답입니다. 초를 다시 입력해주세요 : ");
								sec = secInput.nextInt();
								if (sec >= 0 && sec < 60) {
									break;
								}
							}
						}
					}
					break;

				} else {
					System.out.print("0 ~ 59초로 다시 입력해주세요 : ");
				}

			} catch (InputMismatchException e) {
				System.out.print("잘못된 대답입니다. 초를 다시 입력해주세요 : ");
				secInput = new Scanner(System.in);
			}
		}
		
		System.out.printf("타이머 설정을 완료하였습니다 : %02d시 %02d분 %02d초\n", hour, min, sec);
		
		Thread.sleep(5000);
		
		// # 2회차
//		while (true) {
//			try {
//				hour = hourInput.nextInt();
//				if (hour < 1 | hour > 23) {
//					System.out.print("1~23시로 다시 입력해주세요 : ");
//				} else {
//					System.out.println(hour + "시로 입력되었습니다.");
//					System.out.println();
//					break;
//				}
//			} catch (InputMismatchException e) {
//				System.out.print("잘못된 시각입니다. 다시 입력해주세요 : ");
//				hourInput = new Scanner(System.in);
//			}
//		}

		// # 1회차
//		while (true) {

//			try {
//				hour = hourInput.nextInt();
//				while (true) {
//					if (hour <= 12) {
//						System.out.println("입력한 시각이 " + hour + "시 맞습니까? 1. YES 2. NO : ");
//						try {
//							ans = hourInput.nextInt();
//							if (ans == 1) {
//								System.out.println(hour + "시로 입력되었습니다.");
//								System.out.println();
//								break;
//							} else if (ans == 2) {
//								System.out.print("시각을 다시 입력해주세요 : ");
//								hour = hourInput.nextInt();
//							} else {
//								System.out.print("1번과 2번으로 다시 입력해주세요 : ");
//								hourInput = new Scanner(System.in);
//							}
//						} catch (InputMismatchException e) {
//							System.out.print("1번과 2번으로 다시 입력해주세요 : ");
//							hourInput = new Scanner(System.in);
//						}
//
//					} else {
//
//						System.out.print("잘못된 시각입니다. 다시 입력해주세요 : ");
//					}
//					break;
////				else {
////
////					System.out.print("잘못된 시각입니다. 다시 입력해주세요 : ");
//				}
//			} catch (InputMismatchException e) {
//				System.out.print("잘못된 시각입니다. 다시 입력해주세요 : ");
//				hourInput = new Scanner(System.in);
//			}
//
//		}

//		  System.out.print("시간을 입력하세요: "); h = input1.nextInt();
//		  System.out.print("분을 입력하세요: "); m = input1.nextInt();
//		  System.out.print("초을 입력하세요: "); s = input1.nextInt();
//		  System.out.printf("타이머 설정을 완료하였습니다 : %02d시 %02d분 %02d초\n", h, m, s);
//		  System.out.print("시작하시겠습니까? 1.Yes 2.No : "); int start = input1.nextInt();

		// while 문 사용하기 -> 1,2를 입력하지 않았을 때 while (start != 1 & start != 2) {
//		  System.out.print("올바른 값이 아닙니다. 다시 입력해주세요 : "); start = input1.nextInt(); 
//		  
//	if(start==1)
//	{
//		System.out.println("타이머를 시작합니다.");
//	}else if(start==2)
//	{
//		System.out.println("다음에 또 이용해주세요 !");
//	}else
//	{
//		System.out.println("올바른 값이 아닙니다. 다시 입력해주세요.");
//	}

	}

}
