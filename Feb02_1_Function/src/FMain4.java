import java.util.Random;
import java.util.Scanner;

public class FMain4 {

//	public static void playOddEven() {
//		Scanner k = new Scanner(System.in);
//		Random r = new Random();
//		
//		int coin = r.nextInt(10) + 1;
//		System.out.printf("���� ���� Ȧ ? ¦ ? : ");
//		String inputOddEven = k.next();
//		System.out.printf("���� ������ %d �� �Դϴ�.\n", coin);
//		String coinOddEven = coin % 2 == 0 ? "¦" : "Ȧ";
//	}
//
	public static String playCoinOddEven() {
		Scanner k = new Scanner(System.in);
		Random r = new Random();

		int coin = r.nextInt(10) + 1;
		System.out.printf("���� ���� Ȧ ? ¦ ? : ");
		String inputOddEven = k.next();
		System.out.printf("���� ������ %d �� �����ϴ�. ", coin);
		String coinResult = coin % 2 == 0 ? "¦" : "Ȧ";
		String answer = inputOddEven.equals(coinResult) ? "�����Դϴ�" : "Ʋ�Ƚ��ϴ�";
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
		System.out.printf("���� ���� Ȧ ? ¦ ? : ");
//		System.out.printf("���� ������ %d �� �����ϴ�. ", coinCount);

		return new Scanner(System.in).next();
	}

	public static String countOddEven(int coinCount) {
		String coinResult = coinCount % 2 == 0 ? "¦" : "Ȧ";
		return coinResult;
	}

	public static String showAnswer(String inputOddEven, String coinResult) {
		String answer = coinResult.equals(inputOddEven) ? "�����Դϴ�" : "Ʋ�Ƚ��ϴ�";
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
