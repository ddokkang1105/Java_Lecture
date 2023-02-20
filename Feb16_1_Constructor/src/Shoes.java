
public class Shoes {
	static final String BRAND = "NIKE";
	String name;
	int size;
	int price;
	
	public Shoes() {
		
	}
	
	// 생성자 오버로딩
	public Shoes(String name, int size, int price) {
		super();
		this.name = name;
		this.size = size;
		this.price = price;
	}



	public void printInfo() {
		System.out.printf("Shoes Name : %s\n", this.name);
		System.out.printf("Size : %d mm\n", this.size);
		System.out.printf("Price : ￦ %,d\n", this.price);
		System.out.printf("Brand : %s\n", BRAND);
	}
	
	public void test(String name) {
		System.out.println(name);
		System.out.println(this.name);
	}
	
}
