import java.util.Iterator;
import java.util.Scanner;

// ���� for�� >> for�� �ȿ� for �� >> ��ø for ��
//		for (int i = 1; i < 6; i++) {
//			System.out.printf("i�� : %d\n",i);
//			System.out.println("----------");
//			for (int j = 0; j < 6; j++) {
//				System.out.printf("j�� : %d\n",j);
//			}
//		}
//		System.out.println("----------");

public class RMain2 {

	public static void getgugu() {
		Scanner k = new Scanner(System.in);
		System.out.print("���ϰ� ���� �� : ");
		int dan = k.nextInt();
		if ((dan > 0) && (dan < 10)) {
			System.out.println();
			System.out.printf("<<<%d��>>>\n", dan);
			for (int i = 1; i < 10; i++) {
				System.out.printf("%d X %d = %d\n", dan, i, dan * i);
			}
		} else {
			getgugu();
		}
	}

	public static void main(String[] args) {

		System.out.println("�������� ���� ~~ !!");
//		for (int i = 2; i < 10; i++) {
//			System.out.printf("<<< %d �� >>>\n", i);
//			System.out.println("----------");
//			for (int j = 1; j < 10; j++) {
//				System.out.printf("%d X %d = %d\n", i, j, i * j);
//			}
//			System.out.println();
//		}

//		for (int i = 1; i < 10; i++) {
//			System.out.println();
//			for (int j = 2; j < 10; j++) {
//				System.out.printf("%d X %d = %d\t", j, i, i * j);
//			}
//		}

		getgugu();
		
	}
}
