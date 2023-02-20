
public class HMain1 {
	public static void main(String[] args) {
		Human h1 = new Human("Park", "Male", "010-1234-5678");
		h1.printInfo();
		System.out.println("===============================");
		Restaurant r1 = new Restaurant("GangNam PoCha", "NonHyunDong", "02-1222-3444", h1);
		r1.printInfo();
		System.out.println("===============================");
		
		Menu m1 = new Menu("Omelet", 15000, r1);
		m1.printInfo();
		System.out.println("===============================");
		Menu m2 = new Menu("Bulgogi", 25000, r1);
		m2.printInfo();
		System.out.println("===============================");
		Plate p1 = new Plate("Grill", 5000, m2);
		p1.printInfo();
		System.out.println("===============================");
		Market m = new Market("GarakMarket", "SongPaGu", p1);
		m.printInfo();
		System.out.println("===============================");
		Merchant merchant1 = new Merchant("Kim", m);
		merchant1.printInfo();
		System.out.println("===============================");
		System.out.println(merchant1.name);
		System.out.println("===============================");
		merchant1.market.printInfo();
		System.out.println("===============================");
		
		
		merchant1.market.grill.printInfo();
		System.out.println("===============================");
		System.out.println(merchant1.market.grill.price);
		System.out.println("===============================");
		merchant1.market.grill.menu.printInfo();
		System.out.println("===============================");
		System.out.println(merchant1.market.grill.menu.price);
		System.out.println("===============================");
		System.out.println(merchant1.market.grill.menu.r.number);
		System.out.println("===============================");
		System.out.println(merchant1.market.grill.menu.r.h.phoneNum);
		System.out.println("===============================");
		System.out.println(m1.r.h.phoneNum);
		System.out.println("===============================");
	}
}
