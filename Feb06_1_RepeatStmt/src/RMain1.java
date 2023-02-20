import java.util.Random;

//for (변수초기화; 조건식; 값의 증감) {
// 1. 변수초기화
// 2. 조건식이 맞으면(참)
// 3. 내용 실행
// 4. 값의 증감
// 5. 다시 조건 비교
// 6. 내용 실행 
// 7. 갑의 증감
// 8. 조건 비교 후 안 맞으면(거짓)
// 9. 반복문 종료
//}

// 반복문 안에서 변수를 새로 만드는 것은 자제하는게 좋음 !
// 반복문 밖에서 변수 하나를 만들어서 가져다 쓰는게 조금 더 효율적이다. 
// 		-> ( 지역변수 )

public class RMain1 {

	public static void main(String[] args) {

//		for (int i = 0; i < 52; i++) {
//			System.out.println("우앙~굳");
//		}

//		for (int i = 0; i < 3; i++) {
//		}

// 		System.out.println(i);

//		for (int i = 0; i < 5; i = i + 1) {
//			
//			System.out.printf("%d\n", i);
//		}

//		for (int i = 5; i > 0; i--) {
//			System.out.printf("%d\n", i);
//			
//		}
//		for (int i = 0; (i <= 21) &&(i % 2 == 1); i = i + 1) {
//			System.out.printf("%d\n", i);
//		}

//		for (int i = 1; i <= 21; i += 2) {
//			System.out.printf("%d\n", i);
//			
//		}

//		for (int i = 0; i < 5; i++) {
//			Random r = new Random();
//			int randomInt = r.nextInt(10) + 1;
//			System.out.println(randomInt);
//		}

//		for (int i = 0; i < 5; i++) {
//			Random r = new Random();
//			System.out.println(r.nextInt(10) + 1);
//		}

//		for (int i = 0; i < 5; i++) {
//			Random r = new Random();
//			int randomInt = r.nextInt(10) + 1;
//			int difInt = r.nextInt(10) + 1;
//			if (randomInt == difInt) {
//				
//			} else {
//				System.out.println(randomInt);
//			}
//			
//		}

//		Random r = new Random();
//		int x = 0;

//		for (int i = 0; i < 5; i++) {
//			x = r.nextInt(10) + 1;
//			System.out.println(x);
//		}
//		for (int i = 1; i <= 10; i++) {
//			x = i;
//			sum = sum + x;
//			System.out.println(sum);
//		}
//		System.out.println();

//		for (int i = 1; i <= 10; i++) {
//			sum += i;
//		}
//		System.out.println(sum);

//		int mul = 1;
//		for (int i = 1; i <= 7; i++) {
//			mul *= i;
//		}
//		System.out.println(mul);

//		int y = 0;
//		int z = 0;
//		int yz = 0;
//		for (int i = 1; i < 51; i++) {
//			if (i % 3 == 0) {
//				y += i;
//			}
//		}
//		for (int i = 1; i < 51; i++) {
//			if (i % 5 == 0) {
//				z += i;
//			}
//		}
//		for (int i = 1; i < 51; i++) {
//			if (i % 15 == 0) {
//				yz += i;
//			}
//		}
//		System.out.println(y + z - yz);

		int x = 0;
		for (int i = 1; i <= 50; i++) {
			if ((i % 3 == 0) || (i % 5 == 0)) {
				x += i;
			}
		}
		System.out.println(x);
	}
}
