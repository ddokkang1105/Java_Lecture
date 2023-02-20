

public class Game {
	public void strat(Computer c, User u) {
		u.selectcoin = c.askUser(u); 
		c.printCoin(u);
		c.doZzalZzal(u);
		c.getZzalOddEven();
		u.selectOddEven = c.getOddEven(u);
		System.out.println(c.judgeOddEven(u));
		
	}
}
