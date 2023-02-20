import java.util.Random;

public class Computer {
	Random r = new Random();
	int coin = 20;
	int zzal;
	String zzalOddEven;
	
	public int askUser(User u) {
		System.out.print("∏Ó ∞≥∑Œ Ω√¿€ ? (20∞≥ ¿Ã«œ) : ");
		int choice = u.choiceCoin();
		if (choice > coin) {
			System.out.println("ªﬂ∫Ú ! 20∞≥ ¿Ã«œ∑Œ §—.§—");
		} else if (choice <= 0) {
			System.out.println("ªﬂ∫Ú ! æ» ∞Ì∏£¥¬∞« æ¯¥Ÿ !");
		}
		return (choice > 0) && (choice <= coin) ? choice : askUser(u);
	}
	
	public void printCoin(User u) {
		System.out.printf("%d∞≥∑Œ Ω√¿€«œ∞⁄¥Ÿ !\n", u.selectcoin);
	}
	
	public int doZzalZzal(User u) {
		zzal = r.nextInt(u.selectcoin) + 1;
		return zzal;
	}
	
	public String getZzalOddEven() {
		if (zzal % 2 == 1) {
			zzalOddEven = "»¶";
			return zzalOddEven;
		} else {
			zzalOddEven = "¬¶";
			return zzalOddEven;
		}
	}
	
	public String getOddEven(User u) {
		System.out.print("»¶ / ¬¶ ? : ");
		String ans = u.choiceOddEven();
		if (!ans.equals("»¶") && !ans.equals("¬¶")) {
			System.out.println("ππ∂Û¥¬∞≈ø© ~ »¶ ~ ¬¶ ~");
		}
		return (ans.equals("»¶") || ans.equals("¬¶")) ? ans : getOddEven(u);
	}
	
	public String judgeOddEven(User u) {
//		if (zzalOddEven.equals(u.selectOddEven)) {
		if (u.selectOddEven.equals(zzalOddEven)) {
			System.out.printf("%d∞≥ !\n", zzal);
			return "¡§¥‰!";
		} else {
			System.out.printf("%d∞≥ ø¥¡ˆ∑’~ \n", zzal);
			return "∂Ø!";
		}
	}
	
}
