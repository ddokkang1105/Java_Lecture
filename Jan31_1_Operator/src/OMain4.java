import java.util.Scanner;

// **String ��**
// String�� Heap�� �ּڰ��� ����� ������
// �ּڰ��� �ƴ� �ּڰ��� �ִ� ������ ���� ���ϱ� ���ؼ���
// (������).equals �� ����ϸ� �ȴ�.

// Shift ������ ã�ƺ��� !!

// Shift ������ : ���� ����
// ( ������ << ���� )�� ����
// 		<< : �տ� �ִ� ��(������)�� 2������ �ٲٰ�,
//			 �ڿ� �ִ� ��(����)��ŭ �������� �о��.
//			 ����ִ�(������) ĭ ���� 0���� ä���,
//			 2������ �ٽ� 10������ �ٲ��.

// Ex>
// 24�ð�	1 << 0	:	1
// ��������	1 << 1	: 	2
// ����	1 << 2	:	4
// ������	1 << 3	:	8

// A ���� : 2 	-> ��������
// B ���� : 8 	-> ������
// C ���� : 13 	-> 24�ð�, ����, ������
// D ���� : 6 	-> ��������, ����

// ������
//		���� ������ : a++; a--; !a
//		���� ������ : a + b, a > b
//		���� ������ :
//					������ ������ ���� ������ �� ���
//					if������ ��ü�� ����������, ������ �����
//		(����)		���ǽ� ? ������ ������ �� �� �� : ���ǺҼ����� �� ��

// 

public class OMain4 {
	public static void main(String[] args) {
		Scanner k = new Scanner(System.in);

		System.out.print("�̸��� �Է����ּ��� : ");
		String name = k.next();

//		boolean check = name.equals("ȫ�浿");
//		System.out.printf("�̸��� ȫ�浿�Դϱ�? : %s\n", name);
//		System.out.printf("�̸��� ȫ�浿�Դϱ�? : %b\n", check);

//		System.out.println(150 << 6);

		System.out.print("���̸� �Է��ϼ���: ");
		int age = k.nextInt();
		String result = age >= 20 ? "�ȳ��ϼ���" : "NAGA !";
// 		System.out.println(result);
		
		
		result = ((age % 2 == 0) || name.equals("ȫ�浿")) ? "1������" : "2������"; 
		System.out.println(result);
	}
}
