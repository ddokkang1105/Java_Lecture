import java.util.Random;
import java.util.Scanner;

public class RMain1 {

	public static void main(String[] args) {
		Scanner k = new Scanner(System.in);
		Random r = new Random();

		int comInt = r.nextInt(100) + 1;
		// �Է��� ����
		int ansInt = 0;
		// �Է��� ���� ī��Ʈ
		int count = 0;
		int wrongCount = 0;

//		for (int i = 1; i > 0; i++) {
		for (int i = 1; true; i++) {
			System.out.print("1 ~ 100 ����� �ְھ�? ^o^ : ");
			ansInt = k.nextInt();
			if (ansInt > 0 && ansInt <= 100) {
				count = i - wrongCount;
				if (comInt == ansInt) {
					System.out.println();
					System.out.printf("�õ��� Ƚ�� : %d\n", count);
					break;
				} else if (comInt > ansInt) {
					System.out.println("UP !");
				} else {
					System.out.println("DOWN !");
				}
				System.out.println();
			} else {
				wrongCount = i;
				System.out.println("1���� 100������ϱ� ��.��");
				System.out.println();
			}

		}

	}
}
