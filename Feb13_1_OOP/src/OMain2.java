// Java : Perfect ��ü������ (������)
// Python : Hybrid ��ü������ (������)

// �ǻ�Ȱ�� �������� ! -> ���Ⱑ ������ �� -> ���������� �������� !


public class OMain2 {
	public static void main(String[] args) {
//		Bus bus = new Bus();
//		bus.num = 261;
//		bus.type = "����";
//		bus.company = "��ӹ���";
//		bus.driverName = "��浿";
//		bus.startingPoint = "��������͹̳�";
		
//		System.out.printf("���� ��ȣ : %d\n", bus.num);
//		System.out.printf("���� ���� : %s\n", bus.type);
//		System.out.printf("���� ȸ�� : %s\n", bus.company);
//		System.out.printf("���� ���� : %s\n", bus.driverName);
//		System.out.printf("���� ����� : %s\n", bus.startingPoint);
		
//		bus.printInfo();
//		bus.go();
		
		Phone ph = new Phone();
		ph.name = "IPhone 12 Pro";
		ph.brand = "Apple";
		ph.price = 1000000;
		ph.printInfo();
		ph.call();
		System.out.println("----------------------");
		Phone ph2 = ph;
		ph2.price = 1200000;
		ph2.printInfo();
		System.out.println("----------------------");
		ph.printInfo();
		System.out.println("----------------------");
		Phone ph3 = new Phone();
		ph3.printInfo();
		System.out.println("----------------------");
	}
}
