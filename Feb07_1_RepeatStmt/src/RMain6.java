import java.util.Scanner;

public class RMain6 {

	public static void main(String[] args) throws InterruptedException {
		Scanner k = new Scanner(System.in);
		int menu = 0;
		int money = 0;
		int deposit = 0;
		int withdraw = 0;
		atm : while (true) {
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
			System.out.print("�޴��� �����ϼ��� : ");
			menu = k.nextInt();
			System.out.println();
			switch (menu) {
			case 1:
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
				break;
			case 2:
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
					break;
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
					break;
				}
			case 3:
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
				break;
			case 4:
				System.out.println("���α׷��� �����մϴ�.");
				System.out.print(".");
				Thread.sleep(1000);
				System.out.print("\t.");
				Thread.sleep(1000);
				System.out.print("\t.\n");
				Thread.sleep(1000);
				break atm;

			default:
				System.out.println("�߸��� ���Դϴ�. �ٽ� �Է����ּ���.");
				System.out.println();
				System.out.print(".");
				Thread.sleep(1000);
				System.out.print("\t.");
				Thread.sleep(1000);
				System.out.print("\t.\n");
				Thread.sleep(1000);
				System.out.println();
				
				break;
			}
		}

	}
}
