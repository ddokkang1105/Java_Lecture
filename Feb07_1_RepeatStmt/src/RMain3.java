import java.util.Random;

// �ݺ� Ƚ���� ��Ȯ�� �� for �� ���

// �ݺ� ���� (if���� �ݺ�����)
// while �� : ������ ���� �˻�
// 		������ ���� ���ȿ� ��� �ݺ��ؼ� ���� �κ��� ����
//		���� �κп��� ������ false�� ���� ���ߵ��� �ϰų�
//		break; ��ɾ�� �ݺ����� �����ų �� ����
//		���ǿ� ���� ������ �ݺ��ϴ� �۾� ���� !
//		���Ѵ�� �ݺ��ϰ� ���� �� while (true) ���

// while : �ݺ� Ƚ���� ��Ȯ�� �� �� ������,
//			Ư���� ���ǿ� ����� �ϴ� ��쿡 ��� !

//	while ( ���ǽ� ) {
//		����
//	}
// ������ �������� ������ �ѹ��� �ݺ����� ���� �� ����.

// do-while �� : ������� �ϰ� ������ ���߿� �˻� ( ���� �Ⱦ� )
// �ѹ��� �ݺ��� ���� O

//	int xx = r.nextInt(10) + 1;
//	do {
//		System.out.println(xx);
//		xx = r.nextInt(10) + 1;
//	} while (xx != 9);

public class RMain3 {
	public static void main(String[] args) {
		Random r = new Random();
		int ranInt = 0;

//		for (int i = 0; i < 5; i++) {
//			ranInt = r.nextInt(10) + 1;
//			System.out.println(ranInt);
//		}

//		int preRanInt = 0;
//		for (int i = 0; i < 5; i++) {
//			ranInt = r.nextInt(10) + 1;
//			if (ranInt != preRanInt) {
//				System.out.println(ranInt);
//				
//			} else {
//				i -= 1;
//			}
//			preRanInt = ranInt;
//		}

//		for (int i = 0; i < 5; i++) {
//			ranInt = r.nextInt(10) + 1;
//			System.out.println(ranInt);
//			if (ranInt == 9) {
//				break;
//			}
//		}

//		while (true) {
//			ranInt = r.nextInt(10) + 1;
//			System.out.println(ranInt);
//			if (ranInt == 9) {
//				break;
//			}
//			
//		}

//		int x = r.nextInt(10) + 1;
//		while (x != 9) {
//			System.out.println(x);
//			x = r.nextInt(10) + 1;
//
//		}

//		int n = 0;
//		int sum = 0;
//		while (sum < 100) {
//			// n += 1;
//			n++;
//			sum += n;
//		}
//		System.out.printf("n�� �� : %d\n", n);
//		System.out.printf("�� �� : %d\n", sum);

//		int n = 1;
//		int count = 1;
//		while (n < 1000) {
//			n = count * 15;
//			count++;
//		}
//		if (n > 1000) {
//			System.out.println(n - 15);
//		} else {
//			System.out.println(n);
//		}

		int n = 1000;
		while (n % 15 > 0) {
			n--;
			System.out.println(n);
		}
		System.out.printf("1000���� ���� �߿��� ���� ū 15�� ���: %d\n", n);

	}
}
