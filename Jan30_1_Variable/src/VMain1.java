
public class VMain1 {
	public static void main(String[] args) {
		// ��ǻ���� ��ġ !
		// CPU / RAM / HDD / GPU
		
		// CPU : ������ġ(Intel, AMD)
		// HDD(SSD) : ���� ���·� �����ϴ� ��ġ
		//		-> ���������� ����
		// RAM : ���� ���·� �����ϴ� ��ġ
		//		-> �ӽ������� ����
		// GPU : �׷���ó�� or (CPU + HDD + RAM)
		
		// �����͸� �ӽú��� -> RAM�� ������ ���� !
		// �����͸� �������� -> HDD�� ���Ϸ� ���� !
		
		// ���� -> �����͸� �����ϴ� ����(�׸�)
		// �� �����ϳ�? ���߿� �� �� �θ�����
		
		// ������ ���������� RAM�� ������ Ȯ��
		// ���� ���� �Ŀ� ������ ���� �־ �ʱ�ȭ��Ų��.
		//		-> �ʱ�ȭ ��Ű�� ������ ������ ���� �������
		
		// ������ ��Ģ
		//		1. ���ڷ� �����ϸ� ���� !
		//		2. Ư������, ���� -> ���� !
		//		3. ����� -> ���� !
		
		// �ڹ� ��ȭ
		//		4. �ٸ� ����� ���� �� �� �ְ� ������ ����
		//		5. ������(_ or �빮��)
		//		6. �ѱ� X
		
		// Bit : �����͸� ��Ÿ���� �ּ� ����(������)
		// 8 Bit = 1 Byte
		// 8 Bit �� �� ���� ��ȣ��Ʈ
		//		-> 0 : ��� / 1 : ����
		// 8 Bit �� ���� : 2^(8-1)
		//		-> -1 �� ��ȣ��Ʈ�� �� ��
		
		// �⺻��
		//		����
		//			byte : -128 ~ 127
		//			short : �� -3�� ~ 3��
		//			int : �� -21�� ~ 21��
		//			long : int�� ����� ���� 
		
		//		�Ǽ�
		//			float : �ٸ� ���� �ַ� 
		//			double : Java���� �ַ�
		
		//		����
		//			char : �� ����
		
		//		��
		//			boolean : True / False
		
		//		����
		//			void : '������' (���߿�)
		
		//		������
		//			�⺻���� �ƴ� �͵��� ���� ������ !!
		//			���ڿ�
		//				String : ���ڿ�
		
		//	char vs String
		//	char : �� ����, ' ' ���
		//	String : ���ڿ�, " " ���
		
		// double�� int ���� �ִ°� ���� !
		// �а� ���� 9�� 9.0���ε� ǥ�� ����
		
		// Python ������ �ڷ����� �˾Ƽ� �������ش�.
		// Java ������ Python������ ���� �ٸ� �ڷ������� �����Ͽ��� ��
		// �� ū �ڷ������� �ڵ����� ��ȯ�ȴ�.
		
		// ???
		
		// Stack
		// ���α׷��� ����Ǹ� �ڵ����� ����
		// �ؿ������� �������� ���̴� ���� <�⺻��>
		
		// Heap
		// 	���α׷��� ����Ǿ ������ ��������
		//		-> �������� �������� �������־�� �ߴ�
		//	��ǻ�Ͱ� �����ϴٰ� �Ǵ��ϴ� ��� ��ġ�� ������ (�ּڰ�)
		
		// String pool
		// https://2jinishappy.tistory.com/293
		
		// Garbage Collection (�߿� �ܾ�)
		// Heap ������ �ڵ����� �������ִ� �ý��� !
		
		CharString();
		
		int intNum = 9;
		double doubleNum = 9;
		System.out.println(intNum + doubleNum);
		
		byte c = (byte) 0b11111111;
		System.out.println(c);
		System.out.println(Math.pow(2, 50));
	}
	public static void CharString() {
		int intFloor = 5;
		char charFloor = '��';
		
		String stringFinger = "�հ���";
		int intFinger = 10;
		
		System.out.printf("%01d%c\n",intFloor,charFloor);
		System.out.printf("%s�� %02d��\n",stringFinger,intFinger);
		System.out.println();
		
	}
}
