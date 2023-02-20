import java.util.Random;

public class FMain2 {

//	static Random r = new Random();
//	static int ranInt = r.nextInt();

	public static void printRandomNum() {
		Random r = new Random();
		int ranInt = r.nextInt();
		System.out.println(ranInt);
	}

	public static int getRandomNum() {
		Random r = new Random();
		int ranInt = r.nextInt();
		return ranInt;
	}

	public static int getRandomNum(int a) {
		Random r = new Random();
		int ranInt = r.nextInt(a);
		return ranInt;
	}

	public static void printOddEven(int a) {
		String oddEven = (a % 2 == 0) ? "Â¦¼ö" : "È¦¼ö";
		System.out.printf("%d ´Â Â¦¼ö ? È¦¼ö ? : %s\n", a, oddEven);
	}

	public static String getBigger(int a, int b) {
		String bigger = (a > b) ? "¾Õ" : "µÚ";
		return bigger;
	}

	
	public static void main(String[] args) {
//		printRandomNum();
//		int ranNum = getRandomNum();
//		System.out.println(ranNum);
//
//		int down10Num = getRandomNum(10);
//		System.out.println(down10Num);

//		printOddEven(7);		
//		printOddEven(getRandomNum(10));
		
//		System.out.println(getBigger(4, 5));
		
		int down10Num1 = getRandomNum(10);
		int down10Num2= getRandomNum(10);
		String lunchMenu = down10Num1 > down10Num2 ? "ÃÊ¹ä" : "ÇÇÀÚ";
		System.out.println(lunchMenu);
		

	}
}
