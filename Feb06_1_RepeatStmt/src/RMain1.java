import java.util.Random;

//for (�����ʱ�ȭ; ���ǽ�; ���� ����) {
// 1. �����ʱ�ȭ
// 2. ���ǽ��� ������(��)
// 3. ���� ����
// 4. ���� ����
// 5. �ٽ� ���� ��
// 6. ���� ���� 
// 7. ���� ����
// 8. ���� �� �� �� ������(����)
// 9. �ݺ��� ����
//}

// �ݺ��� �ȿ��� ������ ���� ����� ���� �����ϴ°� ���� !
// �ݺ��� �ۿ��� ���� �ϳ��� ���� ������ ���°� ���� �� ȿ�����̴�. 
// 		-> ( �������� )

public class RMain1 {

	public static void main(String[] args) {

//		for (int i = 0; i < 52; i++) {
//			System.out.println("���~��");
//		}

//		for (int i = 0; i < 3; i++) {
//		}

// 		System.out.println(i);

//		for (int i = 0; i < 5; i = i + 1) {
//			
//			System.out.printf("%d\n", i);
//		}

//		for (int i = 5; i > 0; i--) {
//			System.out.printf("%d\n", i);
//			
//		}
//		for (int i = 0; (i <= 21) &&(i % 2 == 1); i = i + 1) {
//			System.out.printf("%d\n", i);
//		}

//		for (int i = 1; i <= 21; i += 2) {
//			System.out.printf("%d\n", i);
//			
//		}

//		for (int i = 0; i < 5; i++) {
//			Random r = new Random();
//			int randomInt = r.nextInt(10) + 1;
//			System.out.println(randomInt);
//		}

//		for (int i = 0; i < 5; i++) {
//			Random r = new Random();
//			System.out.println(r.nextInt(10) + 1);
//		}

//		for (int i = 0; i < 5; i++) {
//			Random r = new Random();
//			int randomInt = r.nextInt(10) + 1;
//			int difInt = r.nextInt(10) + 1;
//			if (randomInt == difInt) {
//				
//			} else {
//				System.out.println(randomInt);
//			}
//			
//		}

//		Random r = new Random();
//		int x = 0;

//		for (int i = 0; i < 5; i++) {
//			x = r.nextInt(10) + 1;
//			System.out.println(x);
//		}
//		for (int i = 1; i <= 10; i++) {
//			x = i;
//			sum = sum + x;
//			System.out.println(sum);
//		}
//		System.out.println();

//		for (int i = 1; i <= 10; i++) {
//			sum += i;
//		}
//		System.out.println(sum);

//		int mul = 1;
//		for (int i = 1; i <= 7; i++) {
//			mul *= i;
//		}
//		System.out.println(mul);

//		int y = 0;
//		int z = 0;
//		int yz = 0;
//		for (int i = 1; i < 51; i++) {
//			if (i % 3 == 0) {
//				y += i;
//			}
//		}
//		for (int i = 1; i < 51; i++) {
//			if (i % 5 == 0) {
//				z += i;
//			}
//		}
//		for (int i = 1; i < 51; i++) {
//			if (i % 15 == 0) {
//				yz += i;
//			}
//		}
//		System.out.println(y + z - yz);

		int x = 0;
		for (int i = 1; i <= 50; i++) {
			if ((i % 3 == 0) || (i % 5 == 0)) {
				x += i;
			}
		}
		System.out.println(x);
	}
}
