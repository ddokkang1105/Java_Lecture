import java.util.Random;

public class Friend {
	Random r = new Random();
	
	public void sayMe(Me m) {
		System.out.printf("ģ�� : %s�� ������ ~ \n", m.name);
	}
	
	public int sayAnswer(Judge j) {
		if (j.myAns > j.right) {
			return r.nextInt(j.myAns) + 1;
		} else {
			return j.myAns + (r.nextInt(100 - j.myAns) + 1);
		}
	}
}
