import java.util.Scanner;

// 조건문 : 작성한 코드를 조건에 따라 코드의 실행 흐름을
//			다르게 동작하도록 제어하는 방법

// if 문 : 조건식의 결과가 true, false로 실행문을 결정

//if (조건 A) {
//	조건 A가 만족했을 때 이 부분을 실행
//} else if (조건 B) {
//	조건 A는 만족 X & 조건 B가 만족했을 때 이 부분을 실행
//} else if (조건 C) {
//	조건 A, B 만족 X & 조건 C가 만족했을 때 이 부분을 실행
//} else {
//	위에 맞는 조건이 하나도 없으면 이 부분을 실행
//}

public class CMain1 {

	public static int inputKoreanScore() {
		System.out.print("국어 점수를 입력하세요(0 ~ 100) : ");
		Scanner k = new Scanner(System.in);
		int koreanScore = k.nextInt();
		return (koreanScore >= 0 && koreanScore <= 100) ? koreanScore : inputKoreanScore();

	}

	public static void getKoreanScore(int koreanScore) {
		if (koreanScore >= 90) {
			System.out.println("성적 : 수");
		} else if (koreanScore >= 80 && koreanScore < 90) {
			System.out.println("성적 : 우");
		} else if (koreanScore >= 70 && koreanScore < 80) {
			System.out.println("성적 : 미");
		} else if (koreanScore >= 60 && koreanScore < 70) {
			System.out.println("성적 : 양");
		} else {
			System.out.println("성적 : 가");
		}

	}

	public static void main(String[] args) {
		int koreanScore = inputKoreanScore();
//		System.out.println(koreanScore);
		getKoreanScore(koreanScore);

//		String text = (koreanScore >= 50) ? "음..킹아 !" : "떽 !";
		if (koreanScore >= 50) {
			if (koreanScore < 60) {
				System.out.println("아..아쉽띄 !");
			}
			else {
				System.out.println("음..킹아 !");
			}
		} else {
			if (koreanScore < 30) {
			System.out.println("응 ~ 나가세연 ~");
			}
			else {
				System.out.println("떽 !");
			}
		}
	}
}
