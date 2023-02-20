import java.util.Random;
import java.util.Scanner;

// 랜덤한 숫자 뽑기

public class YMain2 {
	public static void main(String[] args) {
		Random r = new Random();
		Scanner s = new Scanner(System.in);
//		int i = r.nextInt();		// int 범위안에 있는 랜덤한 정수
//		int i2 = r.nextInt(5);		// 0 ~ 4 중 랜덤한 정수
//		int i3 = r.nextInt(5) + 1;	// 1 ~ 5 중 랜덤한 정수
//		
//		// - 1 ~ 5 중 랜덤한 정수
//		int i4 = (-1) * (r.nextInt(5) + 1);	 
//		
//		System.out.println(i);
//		System.out.println(i2);
//		System.out.println(i3);
//		System.out.println(i4);

		int coin = r.nextInt(10) + 1;
		System.out.printf("동전 개수 홀 ? 짝 ? : ");
		String inputOddEven = s.next();
		System.out.printf("동전 개수는 %d 개 입니다.\n", coin);
		String coinOddEven = coin % 2 == 0 ? "짝" : "홀";
		String test = inputOddEven.equals(coinOddEven) ? "정답입니다" : "틀렸습니다";
		System.out.println(test);

	}
}
