import java.util.Scanner;

// �Լ��� �����ϴ� ����

// ������
// ���� �߰� ����
// ���� �и�
// ����

// main �Լ��� �ڵ带 �ִ��� ª�� �����ϱ� ���ؼ�
// ��ɵ��� ��� �Լ���� �ɷ� ��� !
//		=> ����� ������ ȿ�������� ��� !

// �Լ� ����
// ���� X, ���� X
// ���� X, ���� O
// ���� O, ���� X
// ���� O, ���� O

public class FMain5 {
	
	static Scanner k = new Scanner(System.in);
	
	public static void makeErrand() {
		System.out.println("�Ƶ� ~");
		System.out.println("�� ���״ϱ�");
		System.out.println("���۰���");
		System.out.println("����̶�");
		System.out.println("��ġĵ ���");
		System.out.println("���� ����");
		System.out.println("������~~");
		System.out.println("------------------------------------");
	}

	public static int earnMoney() {
//		Scanner k = new Scanner(System.in);
		System.out.print("�� �ּ��� ��Ӵ� : ");
		int money = k.nextInt();
		System.out.printf("��Ӵϲ��� ���� �̴ּ� ! : %,d��\n", money);
		System.out.println("------------------------------------");
		return money;
		
	}
	
	public static int doErrand(int money) {
		int ramen = 3200;
		int tuna = 2170;
		int snack = 1500;

		int result = money - (ramen + tuna + snack);
		System.out.printf("�ɺθ��ϸ� %d���� ����..����", result);
		System.out.println("------------------------------------");
		return result;
		
	}
	
	public static int calculate(int money) {
		int ramen = 3200;
		int tuna = 2170;
		int snack = 1500;
		int bbingddang = 3000;
		
		int restMoney = money - (ramen + tuna + snack + bbingddang);
		return restMoney;
		
	}

	public static void main(String[] args) {
		makeErrand();
		int money = earnMoney();
		doErrand(money);
		int restMoney = calculate(money);
		System.out.println(restMoney);
	}
}
