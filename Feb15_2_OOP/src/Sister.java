import java.util.Random;

public class Sister {
	Random brain = new Random();
	
	public int fire() {
		return brain.nextInt(3) + 1;
	}
}
