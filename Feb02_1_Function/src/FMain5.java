import java.util.Random;
import java.util.Scanner;

public class FMain5 {
	
	public static int setCoin() {
		return new Random().nextInt(20) + 1;
	}
	
	public static int askCoin() {
		System.out.print("�� �� �ְԿ� ~ ? (1 ~ 20) : ");
		return new Scanner(System.in).nextInt();
	}
	
	public static void showCoin(int setCoin) {
		System.out.printf("%d �� ���׿� ~~ ^_^\n", setCoin);
	}
	
	public static void printResult(int setCoin, int askCoin) {
		String result = (setCoin == askCoin) ? "�¾Ҿ�� !" : "�� !";
		System.out.println(result);
	}
	
	
	
	public static void main(String[] args) {
		int setCoin = setCoin();
		int askCoin = askCoin();
		showCoin(setCoin);
		printResult(setCoin, askCoin);
	}
}
