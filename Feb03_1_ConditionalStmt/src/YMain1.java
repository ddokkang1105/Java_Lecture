import java.util.Scanner;

public class YMain1 {
	
	public static int getless3() {
		Scanner k = new Scanner(System.in);
		System.out.print("값을 입력하세요: ");
		int input = k.nextInt();
		return (input < 3) ? input : getless3();
	}
	
	public static int getOdd() {
		Scanner k = new Scanner(System.in);
		System.out.print("값을 입력하세요: ");
		int input = k.nextInt();
		return (input % 2 == 1) ? input : getOdd();
	}

	public static int get0To100() {
		Scanner k = new Scanner(System.in);
		System.out.print("값을 입력하세요: ");
		int input = k.nextInt();
		return (input >= 0 && input <= 100) ? input : get0To100();
	}
	
	public static void main(String[] args) {
		int num1 = getOdd();
		System.out.println(num1);
		System.out.println("===============");
		int num2 = get0To100();
		System.out.println(num2);
	}
}
