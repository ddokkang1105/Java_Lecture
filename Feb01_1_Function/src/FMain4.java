// �����ε� ( overloading ) ����� �����
// �Լ����� �Ȱ���, ������ �Ķ���͸� �ٸ��� !

// ���� �ڷ����� �ᵵ, �Ķ������ ������ �ٸ��ٸ� �����ε��� �����ϴ�.
// �ٸ� �ڷ����� ����ϸ�, �Ķ������ ������ ������ �����ε��� �����ϴ�.

// �����ε��� ��ǥ���� ����
// System.out.println();


public class FMain4 {

//	public static void addIntXY(int x, int y) {
//		int result = x + y;
//		System.out.printf("%d + %d = %d\n", x, y, result);
//	}
//
//	public static void addIntXYZ(int x, int y, int z) {
//		int result = x + y + z;
//		System.out.printf("%d + %d + %d = %d\n", x, y, z, result);
//	}
//
//	public static void addDoubleXYZ(double x, double y, double z) {
//		double result = x + y + z;
//		System.out.printf("%.3f + %.3f + %.3f = %.3f\n", x, y, z, result);
//	}
	
	public static void printAdd(int x, int y) {
		int result = x + y;
		System.out.printf("%d + %d = %d\n", x, y, result);
	}
	public static void printAdd(int x, int y, int z) {
		int result = x + y + z;
		System.out.printf("%d + %d + %d = %d\n", x, y, z, result);
	}
	public static void printAdd(double x, double y, double z) {
		double result = x + y + z;
		System.out.printf("%.2f + %.2f + %.2f = %.2f\n", x, y, z, result);
	}

	public static void printReaction(int a) {
		System.out.println("����!");
	}

	public static void printReaction(char a) {
		System.out.println("�ξ�!");
	}
	
	public static void printReaction(double a) {
		System.out.println("���ƾƾ� �쳢��!");
	}
	
	public static void printReaction() {
		System.out.println("��...ġ...?");
	}
	
	public static void main(String[] args) {
//		printAdd(2, 3);
//		printAdd(2, 3, 4);
//		printAdd(2.0, 3.0, 4.0);

		printReaction(1);
		printReaction('1');
		printReaction(1.0);
		printReaction();
	}
}
