// 면접 질문 ... @0@ ~!
// Call By Value, Call By Reference
// 어떻게 답이 도출되었는지 설명할 수 있어야 한다.

// Call By Value
// : 변수의 '값'을 복사해서 함수의 파라미터 값으로 사용하는 것

// Call By Reference
// : 변수를 참조하는 주솟값(번지값)을 파라미터로 전달하는 것

// Java에서 파라미터를 넘기는 과정에 직접적인 참조를 넘긴게 아니라
// 주솟값을 복사해서 넘기기 때문에 이거는 Call By Value라고 보는 입장이 많음!

// 배열은 Heap 영역에 주솟값을 가진 형태로 그 안에 데이터를 저장
// main에서 불러 올때는 Heap의 형태로 주솟값을 불러옴
// 그러므로 main함수가 아닌 다른 함수에서 다른 데이터를 저장해서
// main 함수로 호출하면 주솟값 안에 있는 데이터는 바뀐 상태로 출력.

public class PMain5 {

	public static void test(int a, int[] b, int[] c) {
		System.out.println(b); 			// 주솟값
		System.out.println(c); 			// 주솟값
		System.out.println(a); 			// 10
		System.out.println(b[0]);		// 10
		System.out.println(c[0]);		// 10
		System.out.println("-----------------");

		a = 100;
		b[0] = 100;
		
		// 에러 !
		// 약식을 사용해도 새로운 수를 만들어내는 것이지
		// 값을 변경하는 건 아님
		// c = { 100, 200 };
		
		// 정규식 ( new int[] )
		c = new int[] { 100, 200 };
		
		System.out.println(b);			// 주솟값
		System.out.println(c);			// 주솟값
		System.out.println(a);			// 100
		System.out.println(b[0]);		// 100
		System.out.println(c[0]);		// 100
	}

	public static void main(String[] args) {
		int a = 10;
		int[] b = { 10, 20 };
		int[] c = { 10, 20 };
		System.out.println(b);			// 주솟값
		System.out.println(c);			// 주솟값
		System.out.println("------------");
		test(a, b, c);
		System.out.println("------------");
		System.out.println(a);			// 10
		System.out.println(c);
		System.out.println(b[0]);		// 10
		System.out.println(c[0]);		// 10
		
	}
}
