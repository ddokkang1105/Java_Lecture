import java.util.Scanner;

public class YMain2 {

	public static int getInt() {
		System.out.print("������ �Է��� �ּ��� : ");
		return new Scanner(System.in).nextInt();
	}

	public static void f1(int inputNum) {
		String zeroPM = "";
		if (inputNum == 0) {
			zeroPM = "0";
		} else if (inputNum > 0) {
			zeroPM = "���";
		} else {
			zeroPM = "����";
		}
		System.out.printf("�Է��Ͻ� ���� \"%s\" �Դϴ�.\n", zeroPM);
	}

	public static void f2(int inputNum) {
		if (inputNum % 12 == 0) {
			System.out.printf("�Է��Ͻ� �� %d�� 12�� ����Դϴ�.\n", inputNum);
		} else if (inputNum % 3 == 0) {
			System.out.printf("�Է��Ͻ� �� %d�� 3�� ����Դϴ�.\n", inputNum);
		} else if (inputNum % 4 == 0) {
			System.out.printf("�Է��Ͻ� �� %d�� 4�� ����Դϴ�.\n", inputNum);
		} else {
			System.out.println("���� !!!!");
		}
	}

	public static void main(String[] args) {
		int inputNum = getInt();
		f1(inputNum);
		f2(inputNum);
	}
}
