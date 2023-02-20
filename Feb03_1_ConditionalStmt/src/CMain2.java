import java.util.Scanner;

public class CMain2 {
	
	public static int inputInt() {
		Scanner k = new Scanner(System.in);
		int input = k.nextInt();
		int result = 0;
		if (input > 3) {
			if (input > 5) {
				result = 20;
				return result;
			}
			result = 10;
		} else {
			
		}
		return result;
	}
	
	public static void main(String[] args) {
		int result = inputInt();
		System.out.println(result);
	}
}
