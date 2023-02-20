import java.util.Scanner;

public class User {
	Scanner mouth = new Scanner(System.in);
	
	// 객체의 속성 유의하기
	int selectcoin;
	String selectOddEven;
	// 다음에는 컴퓨터 class 안에서만 있게 하기

	public int choiceCoin() {
		return mouth.nextInt();
	}
	
	public String choiceOddEven() {
		return mouth.next();
	}
}
