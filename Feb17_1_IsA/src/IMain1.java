// ������ (Java)
//		1. Ŭ������ �����ڰ� �ϳ��� ������
//		�ڹ� �����Ϸ��� �����ڸ� ������� !
//		2. ����Ŭ���� ��ü�� ����� (Pen)
//		���� Ŭ���� �⺻������(Product)��
//		�ڵ����� ȣ��

// super(�Ķ����)�� ���� �����ڸ� ���� ��
// �⺻�����ڰ� ������ �ʱ� ������
// �⺻�����ڸ� ����� �� ���� !!

// ���� Ŭ������ ���� Ŭ������ ��� ���� ��
// ������ ���� ���ϸ�...

public class IMain1 {
	public static void main(String[] args) {
//		Student s1 = new Student("Ku", 17, "NonHyunHigh", 1);
//		s1.printInfo();
//		Student s2 = new Student("Kim", 21, "NonHyunUni", 2);
//		s2.printInfo();
//		Army a1 = new Army("Ko", 22, "Army", "3rd");
//		a1.printInfo();
		
		System.out.println("---------------------------------");
		
		Pen p = new Pen();
		System.out.println("---------------------------------");
		Pen p2 = new Pen("Red");
		System.out.println("---------------------------------");
		Pen p3 = new Pen("Monami", 300, "Black");
		System.out.println("---------------------------------");
		
		Mask mask1 = new Mask("FashionMask", 1000);
	}
}
