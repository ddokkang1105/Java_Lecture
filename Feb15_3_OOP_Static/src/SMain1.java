

// static ��� ���� !!
// - ��ü�� ��� �� �� �ִ� ����
//	=> Ŭ������.xxx �� ��� !
// - ��ü���� ����Ӽ�
// 	=> ��ü�� ������ ���� static ����� �ϳ��� !
// 	=> �޸� ����

// static final �������
//		=> �����Ұ� -> ���ȭ !! ( ���� �������� �ʰڴ� !! )
//		static final �ڷ��� ������(��� �빮��) = ����;

// static Method
//		�޸𸮰� ���� �� ! -> ��ư �� !
//		��ü�� ��� ��밡���ϴ� !!
//		static�� �ƴ� ����������� ���� �Ұ����ϴ�.. !!

// 1. ���� ������ �ҽ��� stack ������ ��
// 2. static ��� �������� static ������ ��ġ
// 3. JVM �� Smain.main(...); �� ȣ��
// 4. ����

// Static ������ �����ʹ� 
// ���α׷��� ���ۺ��� ���ᰡ �� ������ �޸𸮿� �����ְ� �ȴ� !
// ���к��ϰ� ���� ����ϴٺ��� �޸𸮰� �������� �� ���� !

public class SMain1 {
	public static void main(String[] args) {

		System.out.println(Snack.MANUFACTURER);
		
		Snack sn1 = new Snack();
		sn1.name = "��������";
		sn1.weight = 120.2;
		sn1.price = 5000;
		sn1.printInfo();
		
		Snack sn2 = new Snack();
		sn2.name = "����";
		sn2.weight = 115.5;
		sn2.price = 4900;
		sn2.printInfo();
		
//		sn2.manufacturer = sn2.manufacturer + " kim";
//		sn2.printInfo();
//		sn1.printInfo();
		
//		sn2.MANUFACTURER = "Just";

	Snack.printTest();
	
	}
}
