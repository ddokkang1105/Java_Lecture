import java.util.Scanner;

public class YMain1 {
	
	public static int getScore() {
		Scanner k = new Scanner(System.in);
		System.out.print("점수를 입력해주세요 : ");
		int score = k.nextInt();
		return (score >= 0 && score <= 100) ? score : getScore();
	}
	
//	public static void printScore(int score) {
//			System.out.println();
//			switch ((int)(score / 10)) {
//			case 10: case 9:
//				System.out.printf("%d점은 \"A\" 입니다.\n", score);
//				break;
//			case 8:
//				System.out.printf("%d점은 \"B\" 입니다.\n", score);
//				break;
//			case 7:
//				System.out.printf("%d점은 \"C\" 입니다.\n", score);
//				break;
//			case 6:
//				System.out.printf("%d점은 \"D\" 입니다.\n", score);
//				break;
//			default:
//				System.out.printf("%d점은 \"F\" 입니다.\n", score);
//				break;
//			}
//	}
	
	public static void printScore(int score) {
		System.out.println();
		String grade = "";
		switch ((int)(score / 10)) {
		case 10: case 9:
			grade = "A";
			break;
		case 8:
			grade = "B";
			break;
		case 7:
			grade = "C";
			break;
		case 6:
			grade = "D";
			break;
		default:
			grade = "E";
			break;
		}
		System.out.printf("%d점은 \"%s\" 입니다.\n", score, grade);
	}
	
	public static void main(String[] args) {
		int score = getScore();
		printScore(score);
	}
}
