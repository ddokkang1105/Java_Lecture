
public class Plate {
	String own;
	int price;
	Menu menu;
	
	public Plate() {
		// TODO Auto-generated constructor stub
	}

	public Plate(String own, int price, Menu menu) {
		super();
		this.own = own;
		this.price = price;
		this.menu = menu;
	}
	
	public void printInfo() {
		System.out.printf("NAME : %s\n", this.own);
		System.out.printf("PRICE : £Ü %,d\n", this.price);
	}
}
