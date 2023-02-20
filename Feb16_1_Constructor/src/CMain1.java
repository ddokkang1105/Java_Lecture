// this 사용하는 이유
// 멤버변수 명과 파라미터 명이 서로 같을 수도 있기 때문에!!
// this 를 붙이면 무조건 멤버변수 !!
// 안 붙이면 가장 가까운 곳에 있는거 !!

// 생성자 ( Constructor )
//		객체가 만들어질 때 뭔가 작업을 했어야 했다 !
//		=> 생성자 만들기
//		리턴이 아예 없고, 메소드 명이 클래스 명과 같은 메소드
//		생성자를 만들지 않으면 
//			=> 자바 컴파일러가 기본 생성자를 만들어버림
//		생성자를 건드리면..
//			=> 자바 컴파일러가 기본 생성자를 안만들어쥼
//			=> 시스템이 자동으로 객체를 만들 때가 있는데
//				--> 기본 생성자를 씀 --> 에러 !

// 기본 생성자의 역할
// 객체의 값을 초기화하는데 목적!

// super(); 의 기능
//		: 상위에 있는 기본생성자 불러옴 !

public class CMain1 {
	public static void main(String[] args) {
		
		Shoes s1 = new Shoes();
		s1.name = "Air Jordan XXXVII LOW PF";
		s1.size = 280;
		s1.price = 209000;
		s1.printInfo();
		System.out.println("=============================");
		Shoes s2 = new Shoes();
		s2.name = "KD15 EP";
		s2.size = 280;
		s2.price = 179000;
		s2.printInfo();
		System.out.println("=============================");
		
		s2.test(s2.name);
		System.out.println("=============================");
		s2.test("same");
		System.out.println("=============================");
		
		// 생성자 오버로딩
		Shoes s3 = new Shoes("Shoes", 280, 100000);
		s3.printInfo();
		
		
	}
}
