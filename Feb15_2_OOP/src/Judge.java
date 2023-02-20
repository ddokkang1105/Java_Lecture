
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
	public void printHand(int maruLeftHand,int maruRightHand, int sisLeftHand, int sisRightHand) {
		System.out.printf("����� \"%s\", \"%s\"\n", rulebook[maruLeftHand], rulebook[maruRightHand]);
		System.out.printf("������ \"%s\", \"%s\"\n", rulebook[sisLeftHand], rulebook[sisRightHand]);
	}

	public int askHand(int maruLeftHand,int maruRightHand, Maru m) {
		System.out.print("�� ���� ? : ");
		int choice = m.fire();
		if (!(choice == maruLeftHand || choice == maruRightHand)) {
			System.out.println("�ٽ� !");
		}
		return (choice == maruLeftHand || choice == maruRightHand) ? choice : askHand(maruLeftHand, maruRightHand, m);
	}
	
	public int askHand(int sisLeftHand,int sisRightHand, Sister s) {
		int choice = s.fire();
		return (choice == sisLeftHand || choice == sisRightHand) ? choice : askHand(sisLeftHand, sisRightHand, s);
	}
	
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
		int maruLeftHand = 0;
		int maruRightHand = 0;
		int sisLeftHand = 0;
		int sisRightHand = 0;
		int maruHand = 0;
		int sisHand = 0;
		while (true) {
			maruLeftHand = askAns(m);
			maruRightHand = askAns(m);
			sisLeftHand = askAns(s);
			a : while (true) {
				sisRightHand = askAns(s);
				if (sisRightHand != sisLeftHand) {
					break a;
				}
			}
			System.out.println("====================");
			printHand(maruLeftHand, maruRightHand, sisLeftHand, sisRightHand);
			System.out.println("====================");
			maruHand = askHand(maruLeftHand, maruRightHand, m);
			sisHand = askHand(sisLeftHand, sisRightHand, s);
			System.out.println("====================");
			printHand(maruHand, sisHand);
			System.out.println("====================");
			if (judgeWin(maruHand, sisHand, m)) {
				sayMaruWin(m);
				break;
			}
			System.out.println("====================");
		}

	}
}
