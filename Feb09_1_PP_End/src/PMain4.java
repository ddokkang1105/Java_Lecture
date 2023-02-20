import java.util.Iterator;
import java.util.Random;
import java.util.Scanner;

public class PMain4 {

	public static void printStart() {
		System.out.println("===============================");
		System.out.println("�ζ� ���α׷��� �����մϴ� !!");
		System.out.println("===============================");
	}

	public static int[] getLotto() {
		Random r = new Random();
		int lottoNum = 0;
		int[] lotto = new int[6];
//		int[] lotto = {0,0,0,0,0,0};

		for (int i = 0; i < lotto.length; i++) {
			lottoNum = r.nextInt(45) + 1;
			lotto[i] = lottoNum;
			// ���� ��ġ�� ��Ȳ
			for (int j = lotto.length - (7 - i); j >= 0; j--) {
				if (lotto[j] == lotto[i]) {
					i--;
					break;
				}

			}

		}

		// Ǯ��
//		for (int i = 0; i < lotto.length; i++) {
//			lottoNum = r.nextInt(45) + 1;
//			
//			for (int j = 0; j < i; j++) {
//				if (lotto[j] == lotto[i]) {
//					i--;
//					break;
//				}
//				
//			}
//		}

		return lotto;
	}

	public static void printLotto(int[] lotto) {
		for (int i = 0; i < lotto.length; i++) {
			System.out.print(lotto[i] + " ");

		}
		System.out.println();
		System.out.println("===============================");
	}

	public static int getLotto1() {
		Scanner k = new Scanner(System.in);
		int num = k.nextInt();
		if (num < 0 || num > 45) {
			System.out.println("���ڸ� �߸� �Է��߽��ϴ�.");
		}
		return (num >= 1 && num <= 45) ? num : getLotto1();
	}

	public static int[] getLottos() {
		int[] myAnswer = new int[6];
		for (int i = 0; i < myAnswer.length; i++) {
			System.out.printf("%d��° ���� �Է� : ", i + 1);
			myAnswer[i] = getLotto1();
		}
		return myAnswer;
	}

	public static int[] getMyLotto() {
		Scanner k = new Scanner(System.in);
		int myLottoNum = 0;
		int[] myLotto = new int[6];
		System.out.println("===============================");
		for (int i = 0; i < myLotto.length; i++) {
			System.out.printf("%d��° ��ȣ�� �Է��ϼ��� : ", i + 1);
			myLotto[i] = k.nextInt();
			// �ߺ��Ǵ� ���� ���ִ� �ڵ�

		}
		System.out.println("===============================");
		return myLotto;
	}

	public static void printMyLotto(int[] myLotto) {
		System.out.println("�Է��Ͻ� �ζ� ��ȣ");
		System.out.println("===============================");
		for (int i = 0; i < myLotto.length; i++) {
			System.out.print(myLotto[i] + " ");
		}
		System.out.println();
		System.out.println("===============================");
	}

	public static int compareLotto(int[] lotto, int[] myLotto) {
		int count = 0;
		for (int i = 0; i < myLotto.length; i++) {
			for (int j = 0; j < lotto.length; j++) {
				if (myLotto[i] == lotto[j]) {
					count++;
					System.out.printf("���� �� : %d\n", myLotto[i]);
				}
			}
		}
		System.out.println("===============================");
		return count;
	}

	public static void getResult(int count) {
		switch (count) {
		case 6:
			System.out.printf("%d �� !! : 1�� !!!\n", count);
			System.out.println("===============================");
			break;
		case 5:
			System.out.printf("%d �� !! : 2�� !!!\n", count);
			System.out.println("===============================");
			break;
		case 4:
			System.out.printf("%d �� !! : 3�� !!!\n", count);
			System.out.println("===============================");
			break;

		default:
			System.out.printf("%d �� !! : �� !!!\n", count);
			System.out.println("===============================");
			break;
		}
	}

	public static void main(String[] args) {
//		printStart();
//		int[] lotto = getLotto();
//		printLotto(lotto);
//		int[] myLotto = getMyLotto();
//		printMyLotto(myLotto);
//		int count = compareLotto(lotto, myLotto);
//		getResult(count);
//		
		int[] myAnswer = getLottos();
		for (int i : myAnswer) {
			System.out.print(myAnswer[i] + " ");
		}

	}
}
