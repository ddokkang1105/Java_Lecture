import java.util.Scanner;

// ���ǹ� : �ۼ��� �ڵ带 ���ǿ� ���� �ڵ��� ���� �帧��
//			�ٸ��� �����ϵ��� �����ϴ� ���

// if �� : ���ǽ��� ����� true, false�� ���๮�� ����

//if (���� A) {
//	���� A�� �������� �� �� �κ��� ����
//} else if (���� B) {
//	���� A�� ���� X & ���� B�� �������� �� �� �κ��� ����
//} else if (���� C) {
//	���� A, B ���� X & ���� C�� �������� �� �� �κ��� ����
//} else {
//	���� �´� ������ �ϳ��� ������ �� �κ��� ����
//}

public class CMain1 {

	public static int inputKoreanScore() {
		System.out.print("���� ������ �Է��ϼ���(0 ~ 100) : ");
		Scanner k = new Scanner(System.in);
		int koreanScore = k.nextInt();
		return (koreanScore >= 0 && koreanScore <= 100) ? koreanScore : inputKoreanScore();

	}

	public static void getKoreanScore(int koreanScore) {
		if (koreanScore >= 90) {
			System.out.println("���� : ��");
		} else if (koreanScore >= 80 && koreanScore < 90) {
			System.out.println("���� : ��");
		} else if (koreanScore >= 70 && koreanScore < 80) {
			System.out.println("���� : ��");
		} else if (koreanScore >= 60 && koreanScore < 70) {
			System.out.println("���� : ��");
		} else {
			System.out.println("���� : ��");
		}

	}

	public static void main(String[] args) {
		int koreanScore = inputKoreanScore();
//		System.out.println(koreanScore);
		getKoreanScore(koreanScore);

//		String text = (koreanScore >= 50) ? "��..ŷ�� !" : "�� !";
		if (koreanScore >= 50) {
			if (koreanScore < 60) {
				System.out.println("��..�ƽ��� !");
			}
			else {
				System.out.println("��..ŷ�� !");
			}
		} else {
			if (koreanScore < 30) {
			System.out.println("�� ~ �������� ~");
			}
			else {
				System.out.println("�� !");
			}
		}
	}
}
