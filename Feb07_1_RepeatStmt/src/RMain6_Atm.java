import java.util.Scanner;

public class RMain6_Atm {
	static Scanner k = new Scanner(System.in);
	static int menu = 0;
	static int money = 0;
	static int deposit = 0;
	static int withdraw = 0;

	public static void printAtm() {
		System.out.println("*******ATM*******");
		System.out.println("*===============*");
		System.out.println("*==1. 입금하기==*");
		System.out.println("*===============*");
		System.out.println("*==2. 출금하기==*");
		System.out.println("*===============*");
		System.out.println("*==3. 잔고확인==*");
		System.out.println("*===============*");
		System.out.println("*==4.  ATM종료==*");
		System.out.println("*****************");
		System.out.println();
	}

	public static int inputMenu() {
		System.out.print("메뉴를 선택하세요 : ");
		return k.nextInt();
	}

	public static void doDeposit() throws InterruptedException {
		System.out.println("============================");
		System.out.println("입금을 선택하였습니다.");
		System.out.println("============================");
		System.out.println();
		System.out.print("입금할 금액을 입력해주세요 : ");
		deposit = k.nextInt();
		money += deposit;
		System.out.print(".");
		Thread.sleep(1000);
		System.out.print("\t.");
		Thread.sleep(1000);
		System.out.print("\t.\n");
		Thread.sleep(1000);
		System.out.println();
		System.out.println("============================");
		System.out.printf("%,d원이 입금되었습니다.\n", deposit);
		System.out.println("============================");
		System.out.println();
		System.out.println("3초후에 이동합니다.");
		Thread.sleep(3000);
		System.out.println();
	}

	public static void doWithdraw() throws InterruptedException {
		System.out.println("============================");
		System.out.println("출금을 선택하였습니다.");
		System.out.println("============================");
		System.out.println();
		System.out.print("출금할 금액을 입력해주세요 : ");
		withdraw = k.nextInt();
		if (money >= withdraw) {
			money -= withdraw;
			System.out.print(".");
			Thread.sleep(1000);
			System.out.print("\t.");
			Thread.sleep(1000);
			System.out.print("\t.\n");
			Thread.sleep(1000);
			System.out.println();
			System.out.println("============================");
			System.out.printf("%,d원이 출금되었습니다.\n", withdraw);
			System.out.println("============================");
			System.out.println();
			System.out.println("3초후에 이동합니다.");
			Thread.sleep(3000);
			System.out.println();
		} else {
			System.out.print(".");
			Thread.sleep(1000);
			System.out.print("\t.");
			Thread.sleep(1000);
			System.out.print("\t.\n");
			Thread.sleep(1000);
			System.out.println();
			System.out.println("============================");
			System.out.println("잔액이 부족합니다. 확인해주세요.");
			System.out.println("============================");
			System.out.println();
			System.out.println("3초후에 이동합니다.");
			Thread.sleep(3000);
			System.out.println();
		}
	}

	public static void doCheckMoney() throws InterruptedException {
		System.out.println("============================");
		System.out.println("잔고확인을 선택하였습니다.");
		System.out.println("============================");
		System.out.println("잠시만 기다려주세요.");
		System.out.print(".");
		Thread.sleep(1000);
		System.out.print("\t.");
		Thread.sleep(1000);
		System.out.print("\t.\n");
		Thread.sleep(1000);
		System.out.println();
		System.out.println("============================");
		System.out.printf("보유하신 금액은 %,d원입니다.\n", money);
		System.out.println("============================");
		System.out.println();
		System.out.println("3초후에 이동합니다.");
		Thread.sleep(3000);
		System.out.println();

	}

	public static void exitProgram() throws InterruptedException {
		System.out.println("프로그램을 종료합니다.");
		System.out.print(".");
		Thread.sleep(1000);
		System.out.print("\t.");
		Thread.sleep(1000);
		System.out.print("\t.\n");
		Thread.sleep(1000);
	}

	public static void doWrongMenu() throws InterruptedException {
		System.out.println("잘못된 값입니다. 다시 입력해주세요.");
		System.out.println();
		System.out.print(".");
		Thread.sleep(1000);
		System.out.print("\t.");
		Thread.sleep(1000);
		System.out.print("\t.\n");
		Thread.sleep(1000);
		System.out.println();
	}

	public static void doProgram() throws InterruptedException {
		atm: while (true) {
			printAtm();
			menu = inputMenu();
			System.out.println();
			switch (menu) {
			case 1:
				doDeposit();
				break;
			case 2:
				doWithdraw();
				break;
			case 3:
				doCheckMoney();
				break;
			case 4:
				exitProgram();
				break atm;
			default:
				doWrongMenu();
				break;
			}
		}
	}

	public static void main(String[] args) throws InterruptedException{
		doProgram();
	}

}
