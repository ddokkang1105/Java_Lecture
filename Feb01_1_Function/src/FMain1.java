
// �Լ�(Function)
//		�����ִ� ��ɵ��� ���
//		�ʿ�ÿ� ȣ���Ͽ� ���(����)

// ���α׷� ���� �� JVM�� main�� �ڵ����� ȣ��
// main���� �Լ��� ���� !

// public static returnType functionName(parameter, parameter, ...) {	
//		-function area-
// 		(return ??;)
// }

// returnType : ��ȯ�� ���� �ڷ���
// �Լ� ������ ���� �ϼ��� �ǰ� ����, main���� ��ȯ�� ������� ���� �ڷ���

// �Լ��� ��Ģ -> ������ ��Ģ�� �����ϴ�.
// ������ 	vs   �Լ���
// �������� ��罺����, �Լ����� ���罺����

// �Ķ���� (����, parameter) : �Լ��� �����ϴ� �� �ʿ��� ���
// �ʿ��� ������ŭ ����ϵ�, �ڷ����� ���缭 ����� �ؾ� �Ѵ� !

public class FMain1 {

	public static void printMyThink() {
		System.out.println("���� ������ �ϰ� �ִ°�?");
		System.out.println("���� ��������� �ƹ� ������ ����.");
		System.out.println("�� ������ ���� �ذ��ؾ� �ϴµ�..");

	}

	public static void printMyIntro() {
		System.out.println("�� �̸��� \"�趯��\" �Դϴ�.");
		System.out.println("�� �ڵ��� ��ȣ�� \"010-7381-1105\" �Դϴ�.");
		System.out.println("���� ��� ���� \"��⵵ ����\" �Դϴ�.");
	}

	public static void calculateAB(int a, int b) {
		System.out.printf("%d + %d = %d\n", a, b, a + b);
		System.out.printf("%d - %d = %d\n", a, b, a - b);
		System.out.printf("%d * %d = %d\n", a, b, a * b);
		System.out.printf("%d / %d = %.2f\n", a, b, (double) a / b);
	}

	public static void main(String[] args) {

//		System.out.println("���� ������ �ϰ� �ִ°�?");
//		System.out.println("���� ��������� �ƹ� ������ ����.");
//		System.out.println("�� ������ ���� �ذ��ؾ� �ϴµ�..");

//		printMyThink();
//		printMyIntro();
		calculateAB(3, 2);

	}
}
