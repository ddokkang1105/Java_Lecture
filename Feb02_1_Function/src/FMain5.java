import java.util.Random;
import java.util.Scanner;

public class FMain5 {
	
	public static int setCoin() {
		return new Random().nextInt(20) + 1;
	}
	
	public static int askCoin() {
		System.out.print("몇 개 있게요 ~ ? (1 ~ 20) : ");
		return new Scanner(System.in).nextInt();
	}
	
	public static void showCoin(int setCoin) {
		System.out.printf("%d 개 였네요 ~~ ^_^\n", setCoin);
	}
	
	public static void printResult(int setCoin, int askCoin) {
		String result = (setCoin == askCoin) ? "맞았어요 !" : "땡 !";
		System.out.println(result);
	}
	
	
	
	public static void main(String[] args) {
		int setCoin = setCoin();
		int askCoin = askCoin();
		showCoin(setCoin);
		printResult(setCoin, askCoin);
	}
}
