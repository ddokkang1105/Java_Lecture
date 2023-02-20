import java.util.Random;

public class Friend {
	Random ai = new Random();
	int friRSP;
	
	public int showRSP() {
		friRSP = ai.nextInt(3) + 1; 
		return friRSP;
	}
	
	
}
