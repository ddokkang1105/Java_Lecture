
// ����������
// 1. �����ι� ���� ? => ���� / ���� / ģ��
//		=> �� ���� �� �ڸ��� ����
//		=> �������״� ����� ����
//		1 ���� / 2 ���� / 3 ��
// 2. �� ��ü�� �Ӽ� ? �ൿ ?
// 3. �� �� �� ���ȿ� �� �� / �� �� �ߴ���? -> ���� vs ģ�� , user vs com
// 


public class OMain1 {
	public static void main(String[] args) throws InterruptedException {
		
		Judge j = new Judge();
		Maru m = new Maru();
		Sister s = new Sister();
		
		j.start(m, s);
		
	}
}


