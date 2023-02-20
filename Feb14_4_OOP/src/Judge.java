
public class Judge {
	String[] rulebook = new String[] { " ", "����", "����", "��" };

	public void readRuleBook() {
		System.out.println("====================");
		for (int i = 1; i < rulebook.length; i++) {
			System.out.printf("%d. %s\n", i, rulebook[i]);
		}
		System.out.println("====================");
	}

	public int askAns(Maru m) {
		System.out.print("���� �� ���� ? : ");
		int maruAns = m.fire();
		if (!(maruAns >= 1 && maruAns <= 3)) {
			System.out.println("�׷��� �ϴ°� �ƴѵ�...?");
		}
		return (maruAns >= 1 && maruAns <= 3) ? maruAns : askAns(m);
	}

	public int askAns(Sister s) {
		int sisAns = s.fire();
		return sisAns;

	}

	// ���� �� �´���
	public void printHand(int maruHand, int sisHand) {
		System.out.printf("����� %s\n", rulebook[maruHand]);
		System.out.printf("������ %s\n", rulebook[sisHand]);
	}

	// ����
	public boolean judgeWin(int maruHand, int sisHand, Maru m) {
		int result = maruHand - sisHand;
		if (result == 0) {
			System.out.println("���� !");
			m.draw++;
		} else if (result == -1 || result == 2) {
			System.out.println("������ �̰�� !");
		} else {
			System.out.println("���簡 �̰�� !");
			m.win++;
		}
		return (result == -1 || result == 2);
	}

	public void sayMaruWin(Maru m) {
		System.out.printf("����� %d�� ����, %d���� ������ �����ž� !\n", m.draw, m.win);
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
