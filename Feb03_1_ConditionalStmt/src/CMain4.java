import java.util.Scanner;

// switch-case (ex: ���� ����)


public class CMain4 {
	
	
	
	public static void main(String[] args) {
		Scanner k = new Scanner(System.in);
		System.out.print("����� ����� �����Դϱ�? : ");
		String classes = k.next();
		
		switch (classes) {
		case "�̺�":
			System.out.println("��ġ, �����, �Ʒ�, ��");
			break;
		case "�Ϻ�":
			System.out.println("�����, �Ʒ�, ��");
			break;
		case "��":
			System.out.println("�Ʒ�, ��");
			break;
		case "����":
			System.out.println("��");
			break;
		
		default:
			System.out.println("�� ����?");
			break;
		}
	}
}
