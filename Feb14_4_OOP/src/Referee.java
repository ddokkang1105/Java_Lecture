
public class Referee {
	int win;
	int draw;
	
	public void introduceGame() {
		System.out.println("재미있겠다 ~ 가위바위보 !!!");
		System.out.println("===================================");
		System.out.println("룰은 간단합니다.");
		System.out.println("가위바위보 끝 !");
	}
	
	public void beginRSP() {
		System.out.println("===================================");
		System.out.println("시작합니다 ~ ");
		System.out.println("가위바위보 !!!");
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
			System.out.print("1:가위 2:바위 3:보 :: ");
			b.showRSP();
			System.out.println("===================================");
			switch (b.broRSP) {
			case 1:
				broResult = "가위";
				break a;
			case 2:
				broResult = "바위";
				break a;
			case 3:
				broResult = "보";
				break a;
			default:
				System.out.println("다시");
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
				friResult = "가위";
				break a;
			case 2:
				friResult = "바위";
				break a;
			case 3:
				friResult = "보";
				break a;
			default:
				System.out.println("다시");
				break;
			}
			
		}
		return friResult;
	}

	public void showBroRSP(String broResult) {
		System.out.printf("동생이 낸 거 : %s\n", broResult);
	}
	
	public void showFriRSP(String FriResult) {
		System.out.printf("친구가 낸 거 : %s\n", FriResult);
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
			System.out.println("이겼다 !!");
			return true;
		} else if (judgment == 0) {
			System.out.println("===================================");
			System.out.println("졌다..");
			return false;
		} else {
			System.out.println("===================================");
			System.out.println("비겼다..?");
			return true;
		}
	}

	public void printResult(boolean result) {
		if (!result) {
			System.out.println("===================================");
			System.out.printf("한번 질 때까지 \"%d승\" \"%d무\" 입니다.", win, draw);
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
