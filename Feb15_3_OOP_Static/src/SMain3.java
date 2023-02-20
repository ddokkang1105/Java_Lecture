
class Number {
	static int num = 0;
	int num2 = 0;
}

public class SMain3 {
	public static void main(String[] args) {
		Number number1 = new Number();
		Number number2 = new Number();
		
		number1.num++;
		number1.num2++;
		
		// static 은 공통속성이어서 값에 영향을 미친다.
		System.out.println(number1.num);		// 0 -> 1
		System.out.println(number1.num2);		// 1
		System.out.println(number2.num);		// 0 -> 1
		System.out.println(number2.num2);		// 0
	}
}
