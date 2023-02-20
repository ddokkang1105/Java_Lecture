import java.util.Iterator;

// 배열 ( Array ) " [ ] "
// 변수 1 : 데이터 n

// 배열 : 같은 타입의 여러 변수를 하나의 묶음으로 다루는 것
//		배열 속 각각의 데이터를 '요소'라고 부름
//		이 요소마다 붙여진 일련번호가 있는데
//		각 요소를 구별하는데 사용
//			=> 인덱스 ( index ) : 시작은 0부터 !!

// 배열 생성
//		자료형[] 변수명; // 배열 선언
//		변수명 = new 자료형[배열의 길이 갯수]; // 배열 생성
// 		자료형[] 변수명 = new 자료형[배열의 길이 갯수];

// for 문에서 .length : 배열의 요소가 몇 개인지 알려줌

// 배열 만드는 방법
// 1.
// int[] eng = new int[3];
// eng[0] = 100;
// eng[1] = 70;
// eng[2] = 50;

// 2.
// int[] math = new int[] { 10, 60, 30 };
// for (int i = 0; i < math.length; i++) {
// 	System.out.println(math[i]);
// }

// 3.
// int[] kor = { 20, 40, 60 };

// Part 1 : 절차지향 프로그래밍
// 		-> 순서대로 코드 잘 짜서 결과 잘 내기 ! - 이과스러움
// Part 2 : 객체지향 프로그래밍
//		-> 문과스러움
// Part 3 : 기타 등등.. 외부 라이브러리.. 

// 정보 올림피아드 문제 / 백준 

public class AMain1 {
	public static void main(String[] args) {

//		int[] eng = new int[3];
//		eng[0] = 100;
//		eng[1] = 70;
//		eng[2] = 50;

//		for (int i = 0; i < eng.length; i++) {
//			System.out.println(eng[i]);
//		}

//		int[] math = new int[] { 10, 60, 30 };
//		for (int i = 0; i < math.length; i++) {
//			System.out.println(math[i]);
//		}

//		int[] kor = { 20, 40, 60 };
//		for (int i = 0; i < kor.length; i++) {
//			System.out.println(kor[i]);
//		}

		int[][] score = { { 50, 30 }, { 30, 50 }, { 100, 80 } };
		System.out.println(score[0][0]);

	}
}
