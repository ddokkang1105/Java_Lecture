
public class Menu {
	String name;
	int price;
	Restaurant r;
	
	public Menu() {
		// TODO Auto-generated constructor stub
	}

	public Menu(String name, int price, Restaurant r) {
		super();
		this.name = name;
		this.price = price;
		this.r = r;
	}

	public void printInfo() {
		System.out.printf("NAME : %s\n", this.name);
		System.out.printf("PRICE : £Ü %,d\n", this.price);
		r.printInfo();
	}
}
