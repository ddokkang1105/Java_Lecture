// extends : 상속
// Animal Class를 상속받겠다 !

// @XXX : Annotation => 어떤 기능을 자동으로 연결해준다 !
// override를 사용하려면...
//		상속받은 Class에서의 method명과 같아야 함!

// overloading
//		메소드를 만들 때 같은 기능이라면 메소드명을 같게 !
//		1. 파라미터의 자료형이 다르거나,
//		2. 파라미터의 개수가 달라야 함

// 아무데도 상속을 안 받으면 extends Object

public class IMain1 {
	public static void main(String[] args) {
		Cat merry = new Cat();
		merry.printInfo();
		System.out.println("=============================");
		
		Dog wal = new Dog("JinDotGae", 10, "GangNam Station");
		wal.printInfo();
		System.out.println("=============================");
		
		
		
		
	}
}
