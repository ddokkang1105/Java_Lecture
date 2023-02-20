

// static 멤버 변수 !!
// - 객체가 없어도 쓸 수 있는 정보
//	=> 클래스명.xxx 로 사용 !
// - 객체들의 공통속성
// 	=> 객체를 여러개 찍어내도 static 멤버는 하나만 !
// 	=> 메모리 절약

// static final 멤버변수
//		=> 수정불가 -> 상수화 !! ( 값을 변경하지 않겠다 !! )
//		static final 자료형 변수명(모두 대문자) = 내용;

// static Method
//		메모리가 절약 됨 ! -> 암튼 됨 !
//		객체가 없어도 사용가능하다 !!
//		static이 아닌 멤버변수에는 접근 불가능하다.. !!

// 1. 기계어 상태의 소스가 stack 영역에 깔림
// 2. static 멤버 변수들이 static 영역에 배치
// 3. JVM 이 Smain.main(...); 을 호출
// 4. 실행

// Static 영역의 데이터는 
// 프로그램의 시작부터 종료가 될 때까지 메모리에 남아있게 된다 !
// 무분별하게 많이 사용하다보면 메모리가 부족해질 수 있음 !

public class SMain1 {
	public static void main(String[] args) {

		System.out.println(Snack.MANUFACTURER);
		
		Snack sn1 = new Snack();
		sn1.name = "초코파이";
		sn1.weight = 120.2;
		sn1.price = 5000;
		sn1.printInfo();
		
		Snack sn2 = new Snack();
		sn2.name = "몽쉘";
		sn2.weight = 115.5;
		sn2.price = 4900;
		sn2.printInfo();
		
//		sn2.manufacturer = sn2.manufacturer + " kim";
//		sn2.printInfo();
//		sn1.printInfo();
		
//		sn2.MANUFACTURER = "Just";

	Snack.printTest();
	
	}
}
