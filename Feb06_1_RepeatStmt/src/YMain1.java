import java.util.Scanner;

public class YMain1 {
	
	public static int getScore() {
		Scanner k = new Scanner(System.in);
		System.out.print("������ �Է����ּ��� : ");
		int score = k.nextInt();
		return (score >= 0 && score <= 100) ? score : getScore();
	}
	
//	public static void printScore(int score) {
//			System.out.println();
//			switch ((int)(score / 10)) {
//			case 10: case 9:
//				System.out.printf("%d���� \"A\" �Դϴ�.\n", score);
//				break;
//			case 8:
//				System.out.printf("%d���� \"B\" �Դϴ�.\n", score);
//				break;
//			case 7:
//				System.out.printf("%d���� \"C\" �Դϴ�.\n", score);
//				break;
//			case 6:
//				System.out.printf("%d���� \"D\" �Դϴ�.\n", score);
//				break;
//			default:
//				System.out.printf("%d���� \"F\" �Դϴ�.\n", score);
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
		System.out.printf("%d���� \"%s\" �Դϴ�.\n", score, grade);
	}
	
	public static void main(String[] args) {
		int score = getScore();
		printScore(score);
	}
}
