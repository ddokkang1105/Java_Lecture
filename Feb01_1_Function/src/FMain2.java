
public class FMain2 {

	public static void test(int b) {
		int a = 123;
		System.out.println(b);
		System.out.println(a + b);

	}

	public static void main(String[] args) {
		// 지역 변수(local variable)
		//		: 함수 내에서 만든 변수
		//		그 함수 안에서만 사용 가능 !
		int a = 10;
		int b = 20;
		int c = 30;

		test(c);				// 30 , 153
		System.out.println(b);	// 20
		
	}
}
