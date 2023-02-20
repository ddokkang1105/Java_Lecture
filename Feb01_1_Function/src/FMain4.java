// 오버로딩 ( overloading ) 고오급 기수울
// 함수명을 똑같이, 하지만 파라미터만 다르게 !

// 같은 자료형을 써도, 파라미터의 갯수가 다르다면 오버로딩이 가능하다.
// 다른 자료형을 사용하면, 파라미터의 갯수가 같더라도 오버로딩이 가능하다.

// 오버로딩의 대표적인 예시
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
		System.out.println("우윽!");
	}

	public static void printReaction(char a) {
		System.out.println("왁악!");
	}
	
	public static void printReaction(double a) {
		System.out.println("으아아악 우끼끼!");
	}
	
	public static void printReaction() {
		System.out.println("팬...치...?");
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
