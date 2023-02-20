
public class PMain3 {
	public static void main(String[] args) {
		// print
		// System.out.print("1asdf");
		// System.out.print("2asdf");

		// printf (Formatting - ���� ����)
		// System.out.println("%?", ��); �� ����

		// ���� (decimal)
		// %d : ���������Ͱ� ���� �ڸ� -> ��� ��� ���� !
		// %xd(x�� ����) : ���� �ڸ��� �������� ä������ ���
		// %0xd : 0���� ä���� x�ڸ��� ���ڷ� �������(��������)

		System.out.printf("%d\n", 1);
		System.out.printf("%3d\n", 1);
		System.out.printf("%010d\n", 1);

		// �Ǽ�(float)
		// %f : �Ǽ� �����Ͱ� ���� �ڸ�
		// %.xf : x��ŭ�� �Ҽ��� ������ �ڸ��� (�߸��� �κ��� �ݿø�ó��)
		// -> x�� �ڸ����� �Է°��� �ڸ������� Ŭ ���� �ڸ����� 0���� ä��

		System.out.printf("%f\n", 123.456789);
		System.out.printf("%.3f\n", 123.456789);
		System.out.printf("%.10f\n", 123.456789);

		// ���ڿ� (String)
		// %s : ���� �����Ͱ� ���� �ڸ�
		// ���� : �׳� �Է��ϸ� �ȴ�
		// ���� : "" ����Ͽ� �Է�

		System.out.printf("%s\n", 2314);
		System.out.printf("%s\n", "java");

		String a = "1234";
		String b = "1234";
		String c = a + b;
		System.out.println(c);

		System.out.println();
		System.out.printf("%4d%s-%02d%s-%02d%s\n", 2023, "��", 1, "��", 27, "��");
		System.out.printf("%s : %s\n", "����", "�߿�");
		System.out.printf("%s : %d%s\n", "���", -4,"��");
		//System.out.printf("%s : %.2f%s\n", "����", 50.24, "%");
		// %% : printf �Լ����� %�� ���ڷ� ��Ÿ���� ���� �� ���
		System.out.printf("%s : %.2f%%\n", "����", 50.24);


	}
}
