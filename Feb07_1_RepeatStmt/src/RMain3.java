import java.util.Random;

// 반복 횟수가 명확할 때 for 문 사용

// 반복 조건 (if문의 반복버전)
// while 문 : 조건을 먼저 검사
// 		조건이 참인 동안에 계속 반복해서 실행 부분을 실행
//		실행 부분에서 조건을 false로 만들어서 멈추도록 하거나
//		break; 명령어로 반복문을 종료시킬 수 있음
//		조건에 맞지 않으면 반복하던 작업 중지 !
//		무한대로 반복하고 싶을 때 while (true) 사용

// while : 반복 횟수를 정확히 알 수 없을때,
//			특별한 조건에 멈춰야 하는 경우에 사용 !

//	while ( 조건식 ) {
//		내용
//	}
// 조건이 만족하지 않으면 한번도 반복하지 않을 수 있음.

// do-while 문 : 실행부터 하고 조건을 나중에 검사 ( 별로 안씀 )
// 한번은 반복이 보장 O

//	int xx = r.nextInt(10) + 1;
//	do {
//		System.out.println(xx);
//		xx = r.nextInt(10) + 1;
//	} while (xx != 9);

public class RMain3 {
	public static void main(String[] args) {
		Random r = new Random();
		int ranInt = 0;

//		for (int i = 0; i < 5; i++) {
//			ranInt = r.nextInt(10) + 1;
//			System.out.println(ranInt);
//		}

//		int preRanInt = 0;
//		for (int i = 0; i < 5; i++) {
//			ranInt = r.nextInt(10) + 1;
//			if (ranInt != preRanInt) {
//				System.out.println(ranInt);
//				
//			} else {
//				i -= 1;
//			}
//			preRanInt = ranInt;
//		}

//		for (int i = 0; i < 5; i++) {
//			ranInt = r.nextInt(10) + 1;
//			System.out.println(ranInt);
//			if (ranInt == 9) {
//				break;
//			}
//		}

//		while (true) {
//			ranInt = r.nextInt(10) + 1;
//			System.out.println(ranInt);
//			if (ranInt == 9) {
//				break;
//			}
//			
//		}

//		int x = r.nextInt(10) + 1;
//		while (x != 9) {
//			System.out.println(x);
//			x = r.nextInt(10) + 1;
//
//		}

//		int n = 0;
//		int sum = 0;
//		while (sum < 100) {
//			// n += 1;
//			n++;
//			sum += n;
//		}
//		System.out.printf("n의 값 : %d\n", n);
//		System.out.printf("총 합 : %d\n", sum);

//		int n = 1;
//		int count = 1;
//		while (n < 1000) {
//			n = count * 15;
//			count++;
//		}
//		if (n > 1000) {
//			System.out.println(n - 15);
//		} else {
//			System.out.println(n);
//		}

		int n = 1000;
		while (n % 15 > 0) {
			n--;
			System.out.println(n);
		}
		System.out.printf("1000이하 정수 중에서 가장 큰 15의 배수: %d\n", n);

	}
}
