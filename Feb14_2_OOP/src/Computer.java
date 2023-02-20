import java.util.Random;

public class Computer {
	Random r = new Random();
	int coin = 20;
	int zzal;
	String zzalOddEven;
	
	public int askUser(User u) {
		System.out.print("�� ���� ���� ? (20�� ����) : ");
		int choice = u.choiceCoin();
		if (choice > coin) {
			System.out.println("�ߺ� ! 20�� ���Ϸ� ��.��");
		} else if (choice <= 0) {
			System.out.println("�ߺ� ! �� ���°� ���� !");
		}
		return (choice > 0) && (choice <= coin) ? choice : askUser(u);
	}
	
	public void printCoin(User u) {
		System.out.printf("%d���� �����ϰڴ� !\n", u.selectcoin);
	}
	
	public int doZzalZzal(User u) {
		zzal = r.nextInt(u.selectcoin) + 1;
		return zzal;
	}
	
	public String getZzalOddEven() {
		if (zzal % 2 == 1) {
			zzalOddEven = "Ȧ";
			return zzalOddEven;
		} else {
			zzalOddEven = "¦";
			return zzalOddEven;
		}
	}
	
	public String getOddEven(User u) {
		System.out.print("Ȧ / ¦ ? : ");
		String ans = u.choiceOddEven();
		if (!ans.equals("Ȧ") && !ans.equals("¦")) {
			System.out.println("����°ſ� ~ Ȧ ~ ¦ ~");
		}
		return (ans.equals("Ȧ") || ans.equals("¦")) ? ans : getOddEven(u);
	}
	
	public String judgeOddEven(User u) {
//		if (zzalOddEven.equals(u.selectOddEven)) {
		if (u.selectOddEven.equals(zzalOddEven)) {
			System.out.printf("%d�� !\n", zzal);
			return "����!";
		} else {
			System.out.printf("%d�� ������~ \n", zzal);
			return "��!";
		}
	}
	
}
