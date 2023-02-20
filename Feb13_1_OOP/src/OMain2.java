// Java : Perfect 객체지향언어 (구조가)
// Python : Hybrid 객체지향언어 (구조가)

// 실생활을 묘사하자 ! -> 보기가 쉬워질 것 -> 유지보수가 용이해짐 !


public class OMain2 {
	public static void main(String[] args) {
//		Bus bus = new Bus();
//		bus.num = 261;
//		bus.type = "현대";
//		bus.company = "고속버스";
//		bus.driverName = "김길동";
//		bus.startingPoint = "강남고속터미널";
		
//		System.out.printf("버스 번호 : %d\n", bus.num);
//		System.out.printf("버스 종류 : %s\n", bus.type);
//		System.out.printf("버스 회사 : %s\n", bus.company);
//		System.out.printf("기사님 성함 : %s\n", bus.driverName);
//		System.out.printf("버스 출발지 : %s\n", bus.startingPoint);
		
//		bus.printInfo();
//		bus.go();
		
		Phone ph = new Phone();
		ph.name = "IPhone 12 Pro";
		ph.brand = "Apple";
		ph.price = 1000000;
		ph.printInfo();
		ph.call();
		System.out.println("----------------------");
		Phone ph2 = ph;
		ph2.price = 1200000;
		ph2.printInfo();
		System.out.println("----------------------");
		ph.printInfo();
		System.out.println("----------------------");
		Phone ph3 = new Phone();
		ph3.printInfo();
		System.out.println("----------------------");
	}
}
