import java.util.Scanner;

public class YMain2 {

	public static int getInt() {
		System.out.print("정수를 입력해 주세요 : ");
		return new Scanner(System.in).nextInt();
	}

	public static void f1(int inputNum) {
		String zeroPM = "";
		if (inputNum == 0) {
			zeroPM = "0";
		} else if (inputNum > 0) {
			zeroPM = "양수";
		} else {
			zeroPM = "음수";
		}
		System.out.printf("입력하신 값은 \"%s\" 입니다.\n", zeroPM);
	}

	public static void f2(int inputNum) {
		if (inputNum % 12 == 0) {
			System.out.printf("입력하신 값 %d는 12의 배수입니다.\n", inputNum);
		} else if (inputNum % 3 == 0) {
			System.out.printf("입력하신 값 %d는 3의 배수입니다.\n", inputNum);
		} else if (inputNum % 4 == 0) {
			System.out.printf("입력하신 값 %d는 4의 배수입니다.\n", inputNum);
		} else {
			System.out.println("몰라 !!!!");
		}
	}

	public static void main(String[] args) {
		int inputNum = getInt();
		f1(inputNum);
		f2(inputNum);
	}
}
