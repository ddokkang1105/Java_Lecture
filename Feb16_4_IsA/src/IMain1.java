// extends : ���
// Animal Class�� ��ӹްڴ� !

// @XXX : Annotation => � ����� �ڵ����� �������ش� !
// override�� ����Ϸ���...
//		��ӹ��� Class������ method��� ���ƾ� ��!

// overloading
//		�޼ҵ带 ���� �� ���� ����̶�� �޼ҵ���� ���� !
//		1. �Ķ������ �ڷ����� �ٸ��ų�,
//		2. �Ķ������ ������ �޶�� ��

// �ƹ����� ����� �� ������ extends Object

public class IMain1 {
	public static void main(String[] args) {
		Cat merry = new Cat();
		merry.printInfo();
		System.out.println("=============================");
		
		Dog wal = new Dog("JinDotGae", 10, "GangNam Station");
		wal.printInfo();
		System.out.println("=============================");
		
		
		
		
	}
}
