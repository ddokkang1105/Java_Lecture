
public class Coffee {
	String name;
	int price;
	
	public Coffee() {
		// TODO Auto-generated constructor stub
	}

	public Coffee(String name, int price) {
		super();
		this.name = name;
		this.price = price;
	}
	
	public void printInfo() {
		System.out.printf("�̸� : %s\n", this.name);
		System.out.printf("���� : �� %,d\n", this.price);
	}
	
}
