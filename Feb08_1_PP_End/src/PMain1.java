import java.util.Scanner;

public class PMain1 {

	public static void main(String[] args) {

		Scanner k = new Scanner(System.in);
		int inputNum = 0;

		while (true) {
			System.out.print("���ڸ� �Է��ϼ��� : ");
			inputNum = k.nextInt();
			if (inputNum == 0) {
				System.out.println("�����մϴ�.");
				break;
			} else {
				System.out.printf("%d�� ����� : ", inputNum);
				for (int divisor = 1; divisor <= inputNum; divisor++) {
					if (inputNum % divisor == 0) {
						System.out.print(divisor);
						if (inputNum == divisor) {
							System.out.println();
							break;
						} else {
							System.out.print(", ");
						}
					}
				}
				System.out.println();
			}
		}

	}
}
