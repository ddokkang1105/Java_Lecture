import java.util.Random;

public class Judge {
	Random r = new Random();
	int right = r.nextInt(100) + 1;
	int myAns;

//	나 부르기
//	public Me callMe() {
//		System.out.println("");
//		System.out.println("");
//		return new Me();
//	}
	
	public void callMe(Me m, Friend f) {
		System.out.printf("심판 : %s야 나와 !!!\n", m.name);
		f.sayMe(m);
	}

	public void introduceGame(Me m) {
		System.out.println("================================");
		System.out.println("자 게임 설명할게 ~ ");
		System.out.println("1부터 100 숫자 UP DOWN 알지?");
		System.out.println("그거 할거야 ~ ");
		System.out.printf("%s 부터 시작 ~\n", m.name);
		System.out.println("================================");
	}

	public int applyToMe(Me m) {
		System.out.print("1부터 100 : ");
		myAns = m.sayAnswer();
		if (myAns < 1 || myAns > 100) {
			System.out.println("1부터 100까지라고 ~ ");
		}
		return (myAns >= 1 && myAns <= 100) ? myAns : applyToMe(m);
	}

	public int applyToFriend(Friend f) {
		int friendAns = f.sayAnswer(this);
		System.out.printf("1부터 100 : %d\n", friendAns);
		if (friendAns < 1 || friendAns > 100) {
			System.out.println("1부터 100까지라고 ~ ");
		}
		return (friendAns >= 1 && friendAns <= 100) ? friendAns : applyToFriend(f);

	}

	public String judgeOurNum(int ourAns) {
		if (ourAns > right) {
			return "Down";
		} else if (ourAns < right) {
			return "Up";
		} else {
			return "정답";
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
