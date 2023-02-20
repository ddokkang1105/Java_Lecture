import java.util.Random;

public class Judge {
	Random r = new Random();
	int right = r.nextInt(100) + 1;
	int myAns;

//	�� �θ���
//	public Me callMe() {
//		System.out.println("");
//		System.out.println("");
//		return new Me();
//	}
	
	public void callMe(Me m, Friend f) {
		System.out.printf("���� : %s�� ���� !!!\n", m.name);
		f.sayMe(m);
	}

	public void introduceGame(Me m) {
		System.out.println("================================");
		System.out.println("�� ���� �����Ұ� ~ ");
		System.out.println("1���� 100 ���� UP DOWN ����?");
		System.out.println("�װ� �Ұž� ~ ");
		System.out.printf("%s ���� ���� ~\n", m.name);
		System.out.println("================================");
	}

	public int applyToMe(Me m) {
		System.out.print("1���� 100 : ");
		myAns = m.sayAnswer();
		if (myAns < 1 || myAns > 100) {
			System.out.println("1���� 100������� ~ ");
		}
		return (myAns >= 1 && myAns <= 100) ? myAns : applyToMe(m);
	}

	public int applyToFriend(Friend f) {
		int friendAns = f.sayAnswer(this);
		System.out.printf("1���� 100 : %d\n", friendAns);
		if (friendAns < 1 || friendAns > 100) {
			System.out.println("1���� 100������� ~ ");
		}
		return (friendAns >= 1 && friendAns <= 100) ? friendAns : applyToFriend(f);

	}

	public String judgeOurNum(int ourAns) {
		if (ourAns > right) {
			return "Down";
		} else if (ourAns < right) {
			return "Up";
		} else {
			return "����";
		}
	}

	public void printOurAnswer(String ourJAns) {
		System.out.printf("%s !\n", ourJAns);
	}

	public void start(Me m, Friend f) {
		int ans = 0;
		String jAns = null;
		callMe(m, f);
		introduceGame(m);
		while (true) {
			ans = applyToMe(m);
			jAns = judgeOurNum(ans);
			printOurAnswer(jAns);
			if (ans == right) {
				break;
			}
			ans = applyToFriend(f);
			jAns = judgeOurNum(ans);
			printOurAnswer(jAns);
			if (ans == right) {
				break;
			}
		}
	}
}
