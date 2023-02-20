import java.util.Iterator;
import java.util.Random;
import java.util.Scanner;

public class PMain4 {

	public static void printStart() {
		System.out.println("===============================");
		System.out.println("로또 프로그램을 실행합니다 !!");
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
			// 숫자 겹치는 상황
			for (int j = lotto.length - (7 - i); j >= 0; j--) {
				if (lotto[j] == lotto[i]) {
					i--;
					break;
				}

			}

		}

		// 풀이
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
			System.out.println("숫자를 잘못 입력했습니다.");
		}
		return (num >= 1 && num <= 45) ? num : getLotto1();
	}

	public static int[] getLottos() {
		int[] myAnswer = new int[6];
		for (int i = 0; i < myAnswer.length; i++) {
			System.out.printf("%d번째 숫자 입력 : ", i + 1);
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
			System.out.printf("%d번째 번호를 입력하세요 : ", i + 1);
			myLotto[i] = k.nextInt();
			// 중복되는 숫자 없애는 코드

		}
		System.out.println("===============================");
		return myLotto;
	}

	public static void printMyLotto(int[] myLotto) {
		System.out.println("입력하신 로또 번호");
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
					System.out.printf("맞춘 거 : %d\n", myLotto[i]);
				}
			}
		}
		System.out.println("===============================");
		return count;
	}

	public static void getResult(int count) {
		switch (count) {
		case 6:
			System.out.printf("%d 개 !! : 1등 !!!\n", count);
			System.out.println("===============================");
			break;
		case 5:
			System.out.printf("%d 개 !! : 2등 !!!\n", count);
			System.out.println("===============================");
			break;
		case 4:
			System.out.printf("%d 개 !! : 3등 !!!\n", count);
			System.out.println("===============================");
			break;

		default:
			System.out.printf("%d 개 !! : 꽝 !!!\n", count);
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
