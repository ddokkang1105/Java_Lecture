import java.util.Random;

// �Լ���
//		-> ���� ����� �ϴ��� �� �� �ְ�, ���簰�� �۸�, ��Ÿü or ��ü

// �Ķ����
// 		-> �Լ��� ȣ���ϴ� ��(main)���� �ش� �Լ������� �����͸� ���� ��

// ����Ÿ��
//		-> �ش� �Լ����� �۾��� ����� ȣ���� ��(main)���� ���� ��

public class FMain6 {

	public static int makeRandomInt() {
		return new Random().nextInt();
	}

	public static void sumInt(int randInt1, int randInt2) {
		System.out.println(randInt1 + randInt2);
	}

	public static void main(String[] args) {
		int randInt1 = makeRandomInt();
		int randInt2 = makeRandomInt();
		System.out.println(randInt1);
		System.out.println(randInt2);
		
		sumInt(randInt1, randInt2);
	}
}
