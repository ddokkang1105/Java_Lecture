import java.util.Random;

// 함수명
//		-> 무슨 기능을 하는지 알 수 있게, 동사같은 작명, 낙타체 or 뱀체

// 파라미터
// 		-> 함수를 호출하는 쪽(main)에서 해당 함수쪽으로 데이터를 보낼 때

// 리턴타임
//		-> 해당 함수에서 작업한 결과를 호출한 쪽(main)으로 보낼 때

public class FMain6 {

	public static int makeRandomInt() {
		return new Random().nextInt();
	}

	public static void sumInt(int randInt1, int randInt2) {
		System.out.println(randInt1 + randInt2);
	}

	public static void main(String[] args) {
		int randInt1 = makeRandomInt();
		int randInt2 = makeRandomInt();
		System.out.println(randInt1);
		System.out.println(randInt2);
		
		sumInt(randInt1, randInt2);
	}
}
