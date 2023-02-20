// 생성자 (Java)
//		1. 클래스에 생성자가 하나도 없으면
//		자바 컴파일러가 생성자를 만들어줌 !
//		2. 하위클래스 객체를 만들면 (Pen)
//		상위 클래스 기본생성자(Product)를
//		자동으로 호출

// super(파라미터)를 가진 생성자를 생성 시
// 기본생성자가 생기지 않기 때문에
// 기본생성자를 사용할 수 없다 !!

// 하위 클래스가 상위 클래스를 상속 받을 때
// 변수를 설정 안하면...

public class IMain1 {
	public static void main(String[] args) {
//		Student s1 = new Student("Ku", 17, "NonHyunHigh", 1);
//		s1.printInfo();
//		Student s2 = new Student("Kim", 21, "NonHyunUni", 2);
//		s2.printInfo();
//		Army a1 = new Army("Ko", 22, "Army", "3rd");
//		a1.printInfo();
		
		System.out.println("---------------------------------");
		
		Pen p = new Pen();
		System.out.println("---------------------------------");
		Pen p2 = new Pen("Red");
		System.out.println("---------------------------------");
		Pen p3 = new Pen("Monami", 300, "Black");
		System.out.println("---------------------------------");
		
		Mask mask1 = new Mask("FashionMask", 1000);
	}
}
