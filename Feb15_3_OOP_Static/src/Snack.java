
public class Snack {
	String name;
	double weight;
	int price;
//	static String manufacturer = "Justin";
	static final String MANUFACTURER = "Justin";
	
	public void printInfo() {
		System.out.printf("�̸� : %s\n", this.name);
		System.out.printf("�߷� : %.1fg\n", weight);
		System.out.printf("���� : %,d��\n", this.price);
		System.out.printf("������ : %s\n", MANUFACTURER);
		System.out.println("==============================");
	}
	
	public static void printTest() {
		System.out.println(MANUFACTURER);
		// name�� static�� �ƴ� ����������� ���� X
//		System.out.println(name);
		System.out.println("JMT ~ ");
		System.out.println("==============================");
	}
}
