import java.util.Iterator;

// ** �����ε� !! ** : �ſ�ſ�ſ�ſ�ſ�ſ�ſ�ſ� �߿�!!!!!!!


public class PMain3 {

	public static void printSum(int x, int y) {
		System.out.printf("%d + %d = %d\n", x, y, x + y);
	}

	public static void printSum(int x, int y, int z) {
		System.out.printf("%d + %d + %d = %d\n", x, y, z, x + y + z);
	}

//	public static void printMul(int[] arr) {
//		int mul = 1; 
//		for (int i = 0; i < arr.length; i++) {
//			mul *= arr[i];
//		}
//		System.out.printf("%d", mul);
//	}
	
	// �Ķ������ ���� ������
	public static void printMul(int...n) {
		int mul = 1; 
		for (int i = 0; i < n.length; i++) {
			mul *= n[i]; 
		}
		System.out.println(mul);

	}
	
	public static void main(String[] args) {
//		printSum(12, 2);
//		printSum(12, 123, 123);
	
		int[] arr = {3, 4, 5};
		printMul(2,3,4,5,6,7);

	}
}
