import java.util.Scanner;

public class YMain2 {
	public static void main(String[] args) {
		Scanner k = new Scanner(System.in);

		System.out.printf("국어 점수 : ");
		int korScore = k.nextInt();

		System.out.printf("수학 점수 : ");
		int mathScore = k.nextInt();

		System.out.printf("영어 점수 : ");
		int engScore = k.nextInt();

		int totalScore = korScore + mathScore + engScore;
		double averageScore = totalScore / 3;

		System.out.println();
		System.out.println("*****************************");
		System.out.println("입력이 완료되었습니다.");
		System.out.println("*****************************");
		System.out.printf("국어 점수는 %d점 입니다.\n", korScore);
		System.out.printf("수학 점수는 %d점 입니다.\n", mathScore);
		System.out.printf("영어 점수는 %d점 입니다.\n", engScore);
		System.out.println("*****************************");
		System.out.printf("총 점수는 %d점 입니다.\n", totalScore);
		System.out.printf("평균 점수는 %.1f점 입니다.\n", averageScore);
		System.out.println("*****************************");
		

	}
}
