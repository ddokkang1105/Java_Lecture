
public class PMain3 {
	public static void main(String[] args) {
		// print
		// System.out.print("1asdf");
		// System.out.print("2asdf");

		// printf (Formatting - 형식 지정)
		// System.out.println("%?", 값); 의 형태

		// 정수 (decimal)
		// %d : 정수데이터가 들어올 자리 -> 모든 언어 공통 !
		// %xd(x는 숫자) : 숫자 자리가 띄워쓰기로 채워져서 출력
		// %0xd : 0으로 채워서 x자리의 숫자로 만들어줌(숫자포함)

		System.out.printf("%d\n", 1);
		System.out.printf("%3d\n", 1);
		System.out.printf("%010d\n", 1);

		// 실수(float)
		// %f : 실수 데이터가 들어올 자리
		// %.xf : x만큼의 소수점 이하의 자릿수 (잘리는 부분은 반올림처리)
		// -> x의 자릿수가 입력값의 자릿수보다 클 때는 자릿수를 0으로 채움

		System.out.printf("%f\n", 123.456789);
		System.out.printf("%.3f\n", 123.456789);
		System.out.printf("%.10f\n", 123.456789);

		// 문자열 (String)
		// %s : 글자 데이터가 들어올 자리
		// 숫자 : 그냥 입력하면 된다
		// 글자 : "" 사용하여 입력

		System.out.printf("%s\n", 2314);
		System.out.printf("%s\n", "java");

		String a = "1234";
		String b = "1234";
		String c = a + b;
		System.out.println(c);

		System.out.println();
		System.out.printf("%4d%s-%02d%s-%02d%s\n", 2023, "년", 1, "월", 27, "일");
		System.out.printf("%s : %s\n", "날씨", "추움");
		System.out.printf("%s : %d%s\n", "기온", -4,"도");
		//System.out.printf("%s : %.2f%s\n", "습도", 50.24, "%");
		// %% : printf 함수에서 %를 문자로 나타내고 싶을 때 사용
		System.out.printf("%s : %.2f%%\n", "습도", 50.24);


	}
}
