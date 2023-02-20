
public class Judge {
	String[] rulebook = new String[] { " ", "가위", "바위", "보" };

	public void readRuleBook() {
		System.out.println("====================");
		for (int i = 1; i < rulebook.length; i++) {
			System.out.printf("%d. %s\n", i, rulebook[i]);
		}
		System.out.println("====================");
	}

	public int askAns(Maru m) {
		System.out.print("마루 뭐 낼래 ? : ");
		int maruAns = m.fire();
		if (!(maruAns >= 1 && maruAns <= 3)) {
			System.out.println("그렇게 하는거 아닌데...?");
		}
		return (maruAns >= 1 && maruAns <= 3) ? maruAns : askAns(m);
	}

	public int askAns(Sister s) {
		int sisAns = s.fire();
		return sisAns;

	}

	// 누가 뭐 냈는지
	public void printHand(int maruHand, int sisHand) {
		System.out.printf("마루는 %s\n", rulebook[maruHand]);
		System.out.printf("동생은 %s\n", rulebook[sisHand]);
	}

	// 판정
	public boolean judgeWin(int maruHand, int sisHand, Maru m) {
		int result = maruHand - sisHand;
		if (result == 0) {
			System.out.println("비겼다 !");
			m.draw++;
		} else if (result == -1 || result == 2) {
			System.out.println("동생이 이겼다 !");
		} else {
			System.out.println("마루가 이겼다 !");
			m.win++;
		}
		return (result == -1 || result == 2);
	}

	public void sayMaruWin(Maru m) {
		System.out.printf("마루는 %d번 비겼고, %d개의 간식을 얻을거야 !\n", m.draw, m.win);
	}

	public void start(Maru m, Sister s) {
		readRuleBook();
		int maruHand = 0;
		int sisHand = 0;
		while (true) {
			maruHand = askAns(m);
			sisHand = askAns(s);
			printHand(maruHand, sisHand);
			System.out.println("====================");
			if (judgeWin(maruHand, sisHand, m)) {
				sayMaruWin(m);
				break;
			}
		}
		System.out.println("====================");

	}
}
