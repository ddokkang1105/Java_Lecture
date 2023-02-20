
public class Phone {
	String name;
	String brand;
	int price;

	public void printInfo() {
		System.out.printf("¸ðµ¨¸í : %s\n", name);
		System.out.printf("Á¦Á¶»ç : %s\n", brand);
		System.out.printf("°¡°Ý : %d\n", price);
	}

	public void call() {
		System.out.println("¶ì¸µ ~ ");
	}
}
