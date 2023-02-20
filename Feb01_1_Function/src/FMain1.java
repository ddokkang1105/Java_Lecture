
// 함수(Function)
//		관련있는 기능들을 묶어서
//		필요시에 호출하여 사용(용이)

// 프로그램 실행 시 JVM이 main을 자동으로 호출
// main또한 함수의 일종 !

// public static returnType functionName(parameter, parameter, ...) {	
//		-function area-
// 		(return ??;)
// }

// returnType : 반환될 값의 자료형
// 함수 내에서 식이 완성이 되고 나서, main으로 반환할 결과값에 대한 자료형

// 함수명 규칙 -> 변수명 규칙과 유사하다.
// 변수명 	vs   함수명
// 변수명은 명사스럽게, 함수명은 동사스럽게

// 파라미터 (인자, parameter) : 함수를 실행하는 데 필요한 재료
// 필요한 갯수만큼 사용하되, 자료형에 맞춰서 사용을 해야 한다 !

public class FMain1 {

	public static void printMyThink() {
		System.out.println("무슨 생각을 하고 있는가?");
		System.out.println("게임 생각말고는 아무 생각이 없다.");
		System.out.println("얼른 집가서 오류 해결해야 하는데..");

	}

	public static void printMyIntro() {
		System.out.println("제 이름은 \"김땡땡\" 입니다.");
		System.out.println("제 핸드폰 번호는 \"010-7381-1105\" 입니다.");
		System.out.println("제가 사는 곳은 \"경기도 여주\" 입니다.");
	}

	public static void calculateAB(int a, int b) {
		System.out.printf("%d + %d = %d\n", a, b, a + b);
		System.out.printf("%d - %d = %d\n", a, b, a - b);
		System.out.printf("%d * %d = %d\n", a, b, a * b);
		System.out.printf("%d / %d = %.2f\n", a, b, (double) a / b);
	}

	public static void main(String[] args) {

//		System.out.println("무슨 생각을 하고 있는가?");
//		System.out.println("게임 생각말고는 아무 생각이 없다.");
//		System.out.println("얼른 집가서 오류 해결해야 하는데..");

//		printMyThink();
//		printMyIntro();
		calculateAB(3, 2);

	}
}
