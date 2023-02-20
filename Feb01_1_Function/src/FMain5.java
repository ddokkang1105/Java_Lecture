import java.util.Scanner;

// 함수를 정의하는 이유

// 가독성
// 오류 발견 용이
// 역할 분리
// 재사용

// main 함수에 코드를 최대한 짧게 구성하기 위해서
// 기능들을 묶어서 함수라는 걸로 사용 !
//		=> 기능을 나눠서 효율적으로 사용 !

// 함수 종류
// 인자 X, 리턴 X
// 인자 X, 리턴 O
// 인자 O, 리턴 X
// 인자 O, 리턴 O

public class FMain5 {
	
	static Scanner k = new Scanner(System.in);
	
	public static void makeErrand() {
		System.out.println("아들 ~");
		System.out.println("돈 줄테니까");
		System.out.println("슈퍼가서");
		System.out.println("라면이랑");
		System.out.println("참치캔 사고");
		System.out.println("남은 돈은");
		System.out.println("가져와~~");
		System.out.println("------------------------------------");
	}

	public static int earnMoney() {
//		Scanner k = new Scanner(System.in);
		System.out.print("돈 주세요 어머니 : ");
		int money = k.nextInt();
		System.out.printf("어머니께서 돈을 주셨다 ! : %,d원\n", money);
		System.out.println("------------------------------------");
		return money;
		
	}
	
	public static int doErrand(int money) {
		int ramen = 3200;
		int tuna = 2170;
		int snack = 1500;

		int result = money - (ramen + tuna + snack);
		System.out.printf("심부름하면 %d원이 남네..ㅎㅎ", result);
		System.out.println("------------------------------------");
		return result;
		
	}
	
	public static int calculate(int money) {
		int ramen = 3200;
		int tuna = 2170;
		int snack = 1500;
		int bbingddang = 3000;
		
		int restMoney = money - (ramen + tuna + snack + bbingddang);
		return restMoney;
		
	}

	public static void main(String[] args) {
		makeErrand();
		int money = earnMoney();
		doErrand(money);
		int restMoney = calculate(money);
		System.out.println(restMoney);
	}
}
