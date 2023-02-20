import java.util.Scanner;

public class PMain2 {

	public static int getPrice() {
		Scanner k = new Scanner(System.in);
		System.out.print("구매한 물건의 가격 : ");
		return k.nextInt();
	}

	public static int payPrice(int price) {
		Scanner k = new Scanner(System.in);
		System.out.print("낸 돈 : ");
		int money = k.nextInt();
		if (money < price) {
			System.out.println("돈이 부족합니다. 다시 내주세요.");
		}
		return (money >= price) ? money : payPrice(price);
	}

	public static int getChange(int price, int money) {
		return money - price;
	}

	public static void printResult(int price, int money, int change) {
		System.out.println("======================");
		System.out.printf("물건 가격 : %d원\n", price);
		System.out.printf("낸 돈 : %d원\n", money);
		System.out.printf("거스름돈 : %d원\n", change);
		System.out.println("======================");
	}

	public static void printChange(int change) {
		// 첫번째 방법
//		int[] currency = { 50000, 10000, 5000, 1000, 500, 100, 50, 10 };
//		for (int i = 0; i < currency.length; i++) {
//			if (change >= currency[i]) {
//				System.out.printf("%d원 : %d개\n", currency[i], (change / currency[i]));
//				change %= currency[i];
//			}
//		}
		
		// 두번째 방법
		int currency2 = 100000;
		while (true) {
			currency2 /= 2;
			if (change >= currency2) {
				System.out.printf("%d원 : %d개\n", currency2, (change / currency2));
				change %= currency2;
			}
			
			currency2 /= 5;
			if (change >= currency2) {
				System.out.printf("%d원 : %d개\n", currency2, (change / currency2));
				change %= currency2;
			}
			
			if (currency2 == 10) {
				break;
			}
		}
	}

	public static void doProgram() {
		int price = getPrice();
		int money = payPrice(price);
		int change = getChange(price, money);
		printResult(price, money, change);
		printChange(change);
	}

	public static void main(String[] args) {
		doProgram();

	}
}
