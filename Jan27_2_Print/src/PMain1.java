
public class PMain1 {
	// main Ctrl + sapcebar
	public static void main(String[] args) {
		// syso Ctrl + spacebar
		System.out.println(1234);
		System.out.println(1234);
		System.out.println(1234);
		System.out.println(1234);
		System.out.println(1234);

		// Print의 형태
		// 1. println : console 창에 글자를 출력하고, 줄 바꿈(괄호 안에 값을 안 넣었을 때)
		// 2. print : console 창에 글자를 출력하지만 줄 바꿈 X
		// 3. printf : console 창에 형식을 지정해서 글자를 출력

		System.out.println("println : 글자 출력 + 줄바꿈 기능");
		System.out.print("print : 글자 출력");
		System.out.println();
		System.out.printf("printf : 이거는 이따가 자세히 볼게요 !");
		System.out.println();

		System.out.println("2 + 4 / 2 의 값은? " + (2 + 4 / 2));

		int x = 2 + 4 / 2;
		System.out.println("2 + 4 / 2 의 값은? " + x);

		double a = 0.2;
		double b = 0.3;
		double c;
		c = a + b;
		System.out.println("0.2 + 0.3 = " + c);

	}
}
