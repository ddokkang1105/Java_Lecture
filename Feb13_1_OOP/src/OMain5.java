// ???
//		???
// Stack
//		변수를 만들때마다 아래에서부터 차곡차곡 쌓임
//		프로그램이 종료되면 알아서 다 정리
// Heap
//		컴퓨터가 적당하다고 판단한 위치에 만든다
//		자동정리 X ( 핸드폰 메모리 정리느낌으로 정리를 해야함... )

// Garbage Collection : Heap 영역 자동정리 시스템 (** 면접 **)
//		C나 C++에서는 가비지 컬렉션이 없어서 개발자가 수동으로 
//		메모리 할당 및 해제를 하나하나 해줬어야 했다.
//		Java는 JVM에 탑재되어 있는 가비지 컬렉터가
//		메모리 관리를 대행해주기 때문에...
//		개발자 입장에서는 관리, 메모리 누수 문제에 대해서 신경 안써도 되어서
//		오롯이 개발에만 집중할 수 있다는 장점 !
//		언제 발동 ? - 그 번지에 더이상 접근할 방법이 없어지면 발동 !
//		(객체의 정보가 사라지는 시점)
//		단점 : 직접 눈으로 볼 수 없음..
//		System.gc(); 라는 기능으로 정리할 수 있지만...
//			=> 호출해서 사용하는거 자체가 시스템 성능에 영향을 많이 줌 ( 절대 사용 X )

// 프로그램이 종료되면 Stack 영역이 날아가고
// 		=> Heap 영역에 접근을 못하게 되어서 가비지 컬렉션 발동 !




public class OMain5 {
	public static void main(String[] args) {
		Mask m1 = new Mask();
		
		m1.maskName = "KF94";
		m1.maskBuyPlace = "Coupang";
		m1.maskPrice = 3000;
		m1.printInfo();
		System.out.println("============================");

		Mask m2 = m1;
		m1 = null;
		System.out.println(m1);
		System.out.println(m2);
		m2 = null;
		
		System.out.println(m2);
	}
}
