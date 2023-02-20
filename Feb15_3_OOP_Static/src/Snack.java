
public class Snack {
	String name;
	double weight;
	int price;
//	static String manufacturer = "Justin";
	static final String MANUFACTURER = "Justin";
	
	public void printInfo() {
		System.out.printf("이름 : %s\n", this.name);
		System.out.printf("중량 : %.1fg\n", weight);
		System.out.printf("가격 : %,d원\n", this.price);
		System.out.printf("생산자 : %s\n", MANUFACTURER);
		System.out.println("==============================");
	}
	
	public static void printTest() {
		System.out.println(MANUFACTURER);
		// name이 static이 아닌 멤버변수여서 접근 X
//		System.out.println(name);
		System.out.println("JMT ~ ");
		System.out.println("==============================");
	}
}
