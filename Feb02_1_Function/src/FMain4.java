import java.util.Random;
import java.util.Scanner;

public class FMain4 {

//	public static void playOddEven() {
//		Scanner k = new Scanner(System.in);
//		Random r = new Random();
//		
//		int coin = r.nextInt(10) + 1;
//		System.out.printf("동전 개수 홀 ? 짝 ? : ");
//		String inputOddEven = k.next();
//		System.out.printf("동전 개수는 %d 개 입니다.\n", coin);
//		String coinOddEven = coin % 2 == 0 ? "짝" : "홀";
//	}
//
	public static String playCoinOddEven() {
		Scanner k = new Scanner(System.in);
		Random r = new Random();

		int coin = r.nextInt(10) + 1;
		System.out.printf("동전 개수 홀 ? 짝 ? : ");
		String inputOddEven = k.next();
		System.out.printf("동전 개수는 %d 개 였습니다. ", coin);
		String coinResult = coin % 2 == 0 ? "짝" : "홀";
		String answer = inputOddEven.equals(coinResult) ? "정답입니다" : "틀렸습니다";
		System.out.println(answer);

		return coinResult;
	}

	public static int randomCoinCount() {
//		Random r = new Random();
//		int coinCount = r.nextInt(10) + 1;
//		return coinCount;

		return new Random().nextInt(10) + 1;
	}

	public static String inputCoinCount(int coinCount) {
		System.out.printf("동전 개수 홀 ? 짝 ? : ");
//		System.out.printf("동전 개수는 %d 개 였습니다. ", coinCount);

		return new Scanner(System.in).next();
	}

	public static String countOddEven(int coinCount) {
		String coinResult = coinCount % 2 == 0 ? "짝" : "홀";
		return coinResult;
	}

	public static String showAnswer(String inputOddEven, String coinResult) {
		String answer = coinResult.equals(inputOddEven) ? "정답입니다" : "틀렸습니다";
		return answer;
	}

	public static void main(String[] args) {
//		String result = playCoinOddEven();
//		System.out.println(result);

		int coinCount = randomCoinCount();
		String inputCoin = inputCoinCount(coinCount);
		String count = countOddEven(coinCount);
		String answer = showAnswer(inputCoin, count);
		System.out.println(answer);

	}
}
