// OOP
//		static - 공오오ㅗㅇ오오급 !
//		생성자
//		객체간의 관계
//			A has a B : 사람 has a 핸드폰 ( 포함관계 )
//			A is a B : 개 is a 동물 ( 상속관계 )



public class HMain1 {
	public static void main(String[] args) {
		
		Candy c1 = new Candy("Sunkist Lemon", "Lemon");
		c1.printInfo();
		System.out.println("==============================");
		Company co1 = new Company("HaeTae", "YongSan", 150);
		c1.printInfo();
		System.out.println("==============================");
//		lemon.printCompany(haetae);
		c1.brand = co1;
		c1.brand.printInfo();
		System.out.println("==============================");
		Company co2 = new Company("SamSung", "Suwon", 300);
		co2.printInfo();
		System.out.println("==============================");
		Computer com1 = new Computer("i7 - 1234", 32, 500, co2);
		com1.printInfo();
		System.out.println("==============================");
		
		
		
		
	}
}
