
// String[] args : ???
//		-> �ܺο��� ���� �޾ƿ��� ���� ����ϴ� �Ķ����
//		   args ���ڿ��� �迭�� ����ϰڴ� !
//		   args�� �������̱� ������ �� args�� �ƴϾ ������
//		   �Ķ������ String[] args ��ü�� ������ �ȵȴ� !


public class AMain2 {
	public static void main(String[] args) throws InterruptedException {
		for (int i = 0; i < args.length; i++) {
			System.out.println(args[i]);
		}
		Thread.sleep(10000);
	}
}
