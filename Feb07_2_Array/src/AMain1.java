import java.util.Iterator;

// �迭 ( Array ) " [ ] "
// ���� 1 : ������ n

// �迭 : ���� Ÿ���� ���� ������ �ϳ��� �������� �ٷ�� ��
//		�迭 �� ������ �����͸� '���'��� �θ�
//		�� ��Ҹ��� �ٿ��� �Ϸù�ȣ�� �ִµ�
//		�� ��Ҹ� �����ϴµ� ���
//			=> �ε��� ( index ) : ������ 0���� !!

// �迭 ����
//		�ڷ���[] ������; // �迭 ����
//		������ = new �ڷ���[�迭�� ���� ����]; // �迭 ����
// 		�ڷ���[] ������ = new �ڷ���[�迭�� ���� ����];

// for ������ .length : �迭�� ��Ұ� �� ������ �˷���

// �迭 ����� ���
// 1.
// int[] eng = new int[3];
// eng[0] = 100;
// eng[1] = 70;
// eng[2] = 50;

// 2.
// int[] math = new int[] { 10, 60, 30 };
// for (int i = 0; i < math.length; i++) {
// 	System.out.println(math[i]);
// }

// 3.
// int[] kor = { 20, 40, 60 };

// Part 1 : �������� ���α׷���
// 		-> ������� �ڵ� �� ¥�� ��� �� ���� ! - �̰�������
// Part 2 : ��ü���� ���α׷���
//		-> ����������
// Part 3 : ��Ÿ ���.. �ܺ� ���̺귯��.. 

// ���� �ø��ǾƵ� ���� / ���� 

public class AMain1 {
	public static void main(String[] args) {

//		int[] eng = new int[3];
//		eng[0] = 100;
//		eng[1] = 70;
//		eng[2] = 50;

//		for (int i = 0; i < eng.length; i++) {
//			System.out.println(eng[i]);
//		}

//		int[] math = new int[] { 10, 60, 30 };
//		for (int i = 0; i < math.length; i++) {
//			System.out.println(math[i]);
//		}

//		int[] kor = { 20, 40, 60 };
//		for (int i = 0; i < kor.length; i++) {
//			System.out.println(kor[i]);
//		}

		int[][] score = { { 50, 30 }, { 30, 50 }, { 100, 80 } };
		System.out.println(score[0][0]);

	}
}
