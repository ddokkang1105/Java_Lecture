import java.util.Scanner;

// ��������
//		����� boolean
// <, <=, ==, !=, >=, >

// ~�̰� : &&
// ~�Ǵ� : ||
// ����� ������ ��(NOT) : !
// XOR(eXclusive OR) : ^
//		-> �� �Է��� ���� �ٸ� �� '1' ������� ��� !

// A && B
// A || B

public class OMain3 {

	public static void main(String[] args) {
		Scanner k = new Scanner(System.in);

		System.out.print("Ű�� �Է��ϼ��� : ");
		double height = k.nextDouble();

		System.out.print("���̸� �Է��ϼ��� : ");
		int age = k.nextInt();
		System.out.println("===========================");
		System.out.printf("�Է��Ͻ� Ű�� %.1fcm �Դϴ�.\n", height);
		System.out.printf("�Է��Ͻ� ���̴� %d�� �Դϴ�.\n", age);

		boolean ride1 = age > 10;
		System.out.printf("ride1 ž�°����մϱ�? : %b\n", ride1);

//		if (ride1) {
//			System.out.printf("���̰� %d���̹Ƿ� ride1�� Ż �� �ֽ��ϴ�.", age);
//		}

		boolean ride2 = age < 5;
		System.out.printf("ride2 ž�°����մϱ�? : %b\n", ride2);

		boolean ride3 = age == 20;
		System.out.printf("ride3 ž�°����մϱ�? : %b\n", ride3);

		boolean ride4 = age != 1;
		System.out.printf("ride4 ž�°����մϱ�? : %b\n", ride4);

		boolean ride5 = (age % 2 == 1);
		System.out.printf("ride5 ž�°����մϱ�? : %b\n", ride5);

		// ȿ�������� ���� �ڵ� - ���ɼ�
		// boolean ride6 = (age > 3 && (height / 100) > 2);

		// ���� ȿ������ �ڵ�
		// ������ Ȯ���Ͽ� && �� ����� ���� Ȯ���� ���� ���� �տ��ٰ� !!
		// �ݴ�� || �� Ȯ���� ���� ���� �տ��ٰ� !!
		boolean ride6 = ((height / 100) > 2 && age > 3);
		System.out.printf("ride6 ž�°����մϱ�? : %b\n", ride6);

		boolean ride7 = (age < 50 || (height / 100) > 1.9);
		System.out.printf("ride7 ž�°����մϱ�? : %b\n", ride7);

		boolean ride8 = (age < 40 && age > 10);
		System.out.printf("ride8 ž�°����մϱ�? : %b\n", ride8);

		boolean ride9 = (age >= 10) ^ ((height / 100) >= 1.5);
		System.out.printf("ride9 ž�°����մϱ�? : %b\n", ride9);
		
		boolean ride10 = ((age >= 10) && !((height / 100) >= 1.5)) 
				|| (!(age >= 10) && ((height / 100) >= 1.5));
		System.out.printf("ride10 ž�°����մϱ�? : %b\n", ride10);
		
		boolean ride0 = !ride9;
		System.out.printf("ride0 ž�°����մϱ�? : %b\n", ride0);

	}
}
