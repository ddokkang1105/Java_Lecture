import java.util.Scanner;

public class User {
	Scanner mouth = new Scanner(System.in);
	
	// ��ü�� �Ӽ� �����ϱ�
	int selectcoin;
	String selectOddEven;
	// �������� ��ǻ�� class �ȿ����� �ְ� �ϱ�

	public int choiceCoin() {
		return mouth.nextInt();
	}
	
	public String choiceOddEven() {
		return mouth.next();
	}
}
