import java.util.Random;
import java.util.Scanner;

// ������ ���� �̱�

public class YMain2 {
	public static void main(String[] args) {
		Random r = new Random();
		Scanner s = new Scanner(System.in);
//		int i = r.nextInt();		// int �����ȿ� �ִ� ������ ����
//		int i2 = r.nextInt(5);		// 0 ~ 4 �� ������ ����
//		int i3 = r.nextInt(5) + 1;	// 1 ~ 5 �� ������ ����
//		
//		// - 1 ~ 5 �� ������ ����
//		int i4 = (-1) * (r.nextInt(5) + 1);	 
//		
//		System.out.println(i);
//		System.out.println(i2);
//		System.out.println(i3);
//		System.out.println(i4);

		int coin = r.nextInt(10) + 1;
		System.out.printf("���� ���� Ȧ ? ¦ ? : ");
		String inputOddEven = s.next();
		System.out.printf("���� ������ %d �� �Դϴ�.\n", coin);
		String coinOddEven = coin % 2 == 0 ? "¦" : "Ȧ";
		String test = inputOddEven.equals(coinOddEven) ? "�����Դϴ�" : "Ʋ�Ƚ��ϴ�";
		System.out.println(test);

	}
}
