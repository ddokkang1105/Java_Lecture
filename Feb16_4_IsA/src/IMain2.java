
public class IMain2 {
	public static void main(String[] args) {
		Shop testShop = new Shop("MONG-DDANG PARA");
		testShop.printInfo();
		System.out.println("=================================");
		Product testProd = new Product("Shoes", 2000);
		testProd.printInfo();
		System.out.println("=================================");

		Shoes shoes1 = new Shoes("NIKE BASKETBALL SHOES", 219000, 280);
		shoes1.printInfo();
		System.out.println("=================================");
		Computer com1 = new Computer("SAMSUMG GAMING DESKTOP", 2999999, "Ryzen 5600X", 32, 1);
		com1.printInfo();
		System.out.println("=================================");
		Notebook notebook1 = new Notebook("SAMSUMG GAMING LAPTOP", 1999999, "Ryzen 5600", 16, 1, 965, 12);
		notebook1.printInfo();
		System.out.println("=================================");
		
	}
}
