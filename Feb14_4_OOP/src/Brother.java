import java.util.Scanner;

public class Brother {
	Scanner hand = new Scanner(System.in);
	int broRSP;

	public int showRSP() {
		broRSP = hand.nextInt();
		return broRSP;
	}
}