import java.util.Scanner;

// **String 비교**
// String은 Heap에 주솟값을 남기기 때문에
// 주솟값이 아닌 주솟값에 있는 데이터 값을 비교하기 위해서는
// (변수값).equals 를 사용하면 된다.

// Shift 연산자 찾아보기 !!

// Shift 연산자 : 다중 선택
// ( 십진수 << 정수 )의 형태
// 		<< : 앞에 있는 수(십진수)를 2진수로 바꾸고,
//			 뒤에 있는 수(정수)만큼 왼쪽으로 밀어라.
//			 비어있는(오른쪽) 칸 수를 0으로 채우고,
//			 2진수를 다시 10진수로 바꿔라.

// Ex>
// 24시간	1 << 0	:	1
// 와이파이	1 << 1	: 	2
// 흡연실	1 << 2	:	4
// 주차장	1 << 3	:	8

// A 매장 : 2 	-> 와이파이
// B 매장 : 8 	-> 주차장
// C 매장 : 13 	-> 24시간, 흡연실, 주차장
// D 매장 : 6 	-> 와이파이, 흡연실

// 연산자
//		단항 연산자 : a++; a--; !a
//		이항 연산자 : a + b, a > b
//		삼항 연산자 :
//					조건을 따져서 값을 대입할 때 사용
//					if문으로 대체가 가능하지만, 문법이 길어짐
//		(형태)		조건식 ? 조건을 만족할 때 쓸 값 : 조건불성립시 쓸 값

// 

public class OMain4 {
	public static void main(String[] args) {
		Scanner k = new Scanner(System.in);

		System.out.print("이름을 입력해주세요 : ");
		String name = k.next();

//		boolean check = name.equals("홍길동");
//		System.out.printf("이름이 홍길동입니까? : %s\n", name);
//		System.out.printf("이름이 홍길동입니까? : %b\n", check);

//		System.out.println(150 << 6);

		System.out.print("나이를 입력하세요: ");
		int age = k.nextInt();
		String result = age >= 20 ? "안녕하세요" : "NAGA !";
// 		System.out.println(result);
		
		
		result = ((age % 2 == 0) || name.equals("홍길동")) ? "1강의장" : "2강의장"; 
		System.out.println(result);
	}
}
