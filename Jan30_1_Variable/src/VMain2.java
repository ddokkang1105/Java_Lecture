
public class VMain2 {
	public static void main(String[] args) {

		String name = "�������";
		int price = 1000;
		int capacity = 80;
		String smell = "ü������";
		double germ = 99.9;
		boolean color = false;
		String company = "���̼�";
		boolean recycle = true;

		System.out.printf("�̸� : %s\n", name);
		System.out.printf("���� : %d��\n", price);
		System.out.printf("�뷮 : %dml\n",capacity);
		System.out.printf("���� : %s\n",smell);
		System.out.printf("��� : %.1f%%\n",germ);
		System.out.println(String.valueOf(color)+"��");
		System.out.println(Boolean.toString(color));
		
		if (color != false) {
			System.out.println(String.valueOf("����"));
			System.out.printf("�� : %s\n",String.valueOf("����"));
		}
		System.out.printf("ȸ�� : %s\n",company);
		System.out.printf("��Ȱ�� : %b\n",recycle);
	}
}
