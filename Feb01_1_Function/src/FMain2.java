
public class FMain2 {

	public static void test(int b) {
		int a = 123;
		System.out.println(b);
		System.out.println(a + b);

	}

	public static void main(String[] args) {
		// ���� ����(local variable)
		//		: �Լ� ������ ���� ����
		//		�� �Լ� �ȿ����� ��� ���� !
		int a = 10;
		int b = 20;
		int c = 30;

		test(c);				// 30 , 153
		System.out.println(b);	// 20
		
	}
}
