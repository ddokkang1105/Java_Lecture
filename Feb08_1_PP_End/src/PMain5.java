// ���� ���� ... @0@ ~!
// Call By Value, Call By Reference
// ��� ���� ����Ǿ����� ������ �� �־�� �Ѵ�.

// Call By Value
// : ������ '��'�� �����ؼ� �Լ��� �Ķ���� ������ ����ϴ� ��

// Call By Reference
// : ������ �����ϴ� �ּڰ�(������)�� �Ķ���ͷ� �����ϴ� ��

// Java���� �Ķ���͸� �ѱ�� ������ �������� ������ �ѱ�� �ƴ϶�
// �ּڰ��� �����ؼ� �ѱ�� ������ �̰Ŵ� Call By Value��� ���� ������ ����!

// �迭�� Heap ������ �ּڰ��� ���� ���·� �� �ȿ� �����͸� ����
// main���� �ҷ� �ö��� Heap�� ���·� �ּڰ��� �ҷ���
// �׷��Ƿ� main�Լ��� �ƴ� �ٸ� �Լ����� �ٸ� �����͸� �����ؼ�
// main �Լ��� ȣ���ϸ� �ּڰ� �ȿ� �ִ� �����ʹ� �ٲ� ���·� ���.

public class PMain5 {

	public static void test(int a, int[] b, int[] c) {
		System.out.println(b); 			// �ּڰ�
		System.out.println(c); 			// �ּڰ�
		System.out.println(a); 			// 10
		System.out.println(b[0]);		// 10
		System.out.println(c[0]);		// 10
		System.out.println("-----------------");

		a = 100;
		b[0] = 100;
		
		// ���� !
		// ����� ����ص� ���ο� ���� ������ ������
		// ���� �����ϴ� �� �ƴ�
		// c = { 100, 200 };
		
		// ���Խ� ( new int[] )
		c = new int[] { 100, 200 };
		
		System.out.println(b);			// �ּڰ�
		System.out.println(c);			// �ּڰ�
		System.out.println(a);			// 100
		System.out.println(b[0]);		// 100
		System.out.println(c[0]);		// 100
	}

	public static void main(String[] args) {
		int a = 10;
		int[] b = { 10, 20 };
		int[] c = { 10, 20 };
		System.out.println(b);			// �ּڰ�
		System.out.println(c);			// �ּڰ�
		System.out.println("------------");
		test(a, b, c);
		System.out.println("------------");
		System.out.println(a);			// 10
		System.out.println(c);
		System.out.println(b[0]);		// 10
		System.out.println(c[0]);		// 10
		
	}
}
