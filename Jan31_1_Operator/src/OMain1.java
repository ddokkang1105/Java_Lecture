import java.util.Scanner;

public class OMain1 {
	public static void main(String[] args) {
		// =
		// -> ���Կ�����, ������ ���� ������ �� ���
		// A = B
		// -> B �� A �� �־��
		//

		Scanner k = new Scanner(System.in);

		System.out.print("X : ");
		int x = k.nextInt();

		System.out.print("Y : ");
		int y = k.nextInt();

		System.out.printf("X + Y = %d\n", x + y);
		System.out.printf("X - Y = %d\n", x - y);
		System.out.printf("X * Y = %d\n", x * y);
		System.out.printf("X / Y = %.2f\n", (double) x / y);

		int reminder = x % y;
		System.out.println(reminder);

		// x = 10, y = 4
		System.out.printf("X : %d\n", x); // 10
		System.out.printf("Y : %d\n", y); // 4
		int x1 = x;
		x = y;
		y = x1;
		System.out.printf("X : %d\n", x); // 4
		System.out.printf("Y : %d\n", y); // 10
		
		x += 2;
		// x = x + 2;
		System.out.println(x);
		
		x -= 2;
		// x = x - 2;
		System.out.println(x);
		
		x *= 2;
		// x = x * 2;
		System.out.println(x);
		
		x /= 2;
		// x = x / 2;
		System.out.println(x);
		
		x %= 2;
		// x = x % 2;
		System.out.println(x);
		
		
		
	}
}
