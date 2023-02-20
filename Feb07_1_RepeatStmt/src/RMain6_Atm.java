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
		System.out.println("*==1. �Ա��ϱ�==*");
		System.out.println("*===============*");
		System.out.println("*==2. ����ϱ�==*");
		System.out.println("*===============*");
		System.out.println("*==3. �ܰ�Ȯ��==*");
		System.out.println("*===============*");
		System.out.println("*==4.  ATM����==*");
		System.out.println("*****************");
		System.out.println();
	}

	public static int inputMenu() {
		System.out.print("�޴��� �����ϼ��� : ");
		return k.nextInt();
	}

	public static void doDeposit() throws InterruptedException {
		System.out.println("============================");
		System.out.println("�Ա��� �����Ͽ����ϴ�.");
		System.out.println("============================");
		System.out.println();
		System.out.print("�Ա��� �ݾ��� �Է����ּ��� : ");
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
		System.out.printf("%,d���� �ԱݵǾ����ϴ�.\n", deposit);
		System.out.println("============================");
		System.out.println();
		System.out.println("3���Ŀ� �̵��մϴ�.");
		Thread.sleep(3000);
		System.out.println();
	}

	public static void doWithdraw() throws InterruptedException {
		System.out.println("============================");
		System.out.println("����� �����Ͽ����ϴ�.");
		System.out.println("============================");
		System.out.println();
		System.out.print("����� �ݾ��� �Է����ּ��� : ");
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
			System.out.printf("%,d���� ��ݵǾ����ϴ�.\n", withdraw);
			System.out.println("============================");
			System.out.println();
			System.out.println("3���Ŀ� �̵��մϴ�.");
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
			System.out.println("�ܾ��� �����մϴ�. Ȯ�����ּ���.");
			System.out.println("============================");
			System.out.println();
			System.out.println("3���Ŀ� �̵��մϴ�.");
			Thread.sleep(3000);
			System.out.println();
		}
	}

	public static void doCheckMoney() throws InterruptedException {
		System.out.println("============================");
		System.out.println("�ܰ�Ȯ���� �����Ͽ����ϴ�.");
		System.out.println("============================");
		System.out.println("��ø� ��ٷ��ּ���.");
		System.out.print(".");
		Thread.sleep(1000);
		System.out.print("\t.");
		Thread.sleep(1000);
		System.out.print("\t.\n");
		Thread.sleep(1000);
		System.out.println();
		System.out.println("============================");
		System.out.printf("�����Ͻ� �ݾ��� %,d���Դϴ�.\n", money);
		System.out.println("============================");
		System.out.println();
		System.out.println("3���Ŀ� �̵��մϴ�.");
		Thread.sleep(3000);
		System.out.println();

	}

	public static void exitProgram() throws InterruptedException {
		System.out.println("���α׷��� �����մϴ�.");
		System.out.print(".");
		Thread.sleep(1000);
		System.out.print("\t.");
		Thread.sleep(1000);
		System.out.print("\t.\n");
		Thread.sleep(1000);
	}

	public static void doWrongMenu() throws InterruptedException {
		System.out.println("�߸��� ���Դϴ�. �ٽ� �Է����ּ���.");
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
