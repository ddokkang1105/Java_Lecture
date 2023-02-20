
public class Referee {
	int win;
	int draw;
	
	public void introduceGame() {
		System.out.println("����ְڴ� ~ ���������� !!!");
		System.out.println("===================================");
		System.out.println("���� �����մϴ�.");
		System.out.println("���������� �� !");
	}
	
	public void beginRSP() {
		System.out.println("===================================");
		System.out.println("�����մϴ� ~ ");
		System.out.println("���������� !!!");
	}
	
	public void printTimer() throws InterruptedException {
		System.out.print(".");
		Thread.sleep(1000);
		System.out.print(" .");
		Thread.sleep(1000);
		System.out.print(" .\n");
		Thread.sleep(1000);
	}
	
	public String convertRSP(Brother b) {
		String broResult = null;
		a : while (true) {
			System.out.println("===================================");
			System.out.print("1:���� 2:���� 3:�� :: ");
			b.showRSP();
			System.out.println("===================================");
			switch (b.broRSP) {
			case 1:
				broResult = "����";
				break a;
			case 2:
				broResult = "����";
				break a;
			case 3:
				broResult = "��";
				break a;
			default:
				System.out.println("�ٽ�");
				break;
			}
			
		}
		return broResult;
	}
	
	public String convertRSP(Friend f) {
		String friResult = null;
		a : while (true) {
			f.showRSP();
			switch (f.friRSP) {
			case 1:
				friResult = "����";
				break a;
			case 2:
				friResult = "����";
				break a;
			case 3:
				friResult = "��";
				break a;
			default:
				System.out.println("�ٽ�");
				break;
			}
			
		}
		return friResult;
	}

	public void showBroRSP(String broResult) {
		System.out.printf("������ �� �� : %s\n", broResult);
	}
	
	public void showFriRSP(String FriResult) {
		System.out.printf("ģ���� �� �� : %s\n", FriResult);
	}
	
	public int judgeRSP(Brother b, Friend f) {
		int judgment = b.broRSP - f.friRSP;
		switch (judgment) {
		case -2:
		case 1:
			judgment = 1;
			break;
		case 2:
		case -1:
			judgment = 0;
			break;

		default:
			judgment = 3;
			break;
		}
		return judgment;
	}
	
	public boolean getRSPResult(int judgment) {
		if (judgment == 1) {
			win++;
			System.out.println("===================================");
			System.out.println("�̰�� !!");
			return true;
		} else if (judgment == 0) {
			System.out.println("===================================");
			System.out.println("����..");
			return false;
		} else {
			System.out.println("===================================");
			System.out.println("����..?");
			return true;
		}
	}

	public void printResult(boolean result) {
		if (!result) {
			System.out.println("===================================");
			System.out.printf("�ѹ� �� ������ \"%d��\" \"%d��\" �Դϴ�.", win, draw);
		}
	}
	
	public void start(Brother b, Friend f) throws InterruptedException {
		int judgment = 0;
		boolean result = true;
		
		introduceGame();
		while (result) {
			beginRSP();
			printTimer();
			String broResult = convertRSP(b);
			showBroRSP(broResult);
			String FriResult = convertRSP(f);
			showFriRSP(FriResult);
			printTimer();
			judgment = judgeRSP(b, f);
			result = getRSPResult(judgment);
			printResult(result);
			
		}
	}
	
	
}
