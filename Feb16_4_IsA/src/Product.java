
public class Product extends Shop {
	int price;
	
	public Product() {
		// TODO Auto-generated constructor stub
	}

	public Product(String name, int price) {
		super(name);
		this.price = price;
	}
	
	@Override
	public void printInfo() {
		// TODO Auto-generated method stub
		super.printInfo();
		System.out.printf("PRICE : £Ü %,d\n", price);
	}
}
