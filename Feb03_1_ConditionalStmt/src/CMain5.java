import java.util.Scanner;

public class CMain5 {
	
	
	
	public static void main(String[] args) {
		Scanner k = new Scanner(System.in);
		System.out.print("����� ����� �����Դϱ�? : ");
		String job = k.next();
		
		switch (job) {
		case "DBA":
			System.out.println("��������");
			System.out.println("��� / ����");
			System.out.println("��ɾ�� CRUD");
			System.out.println("����Ȱ��");
			break;
		case "DBP":
			System.out.println("��ɾ�� CRUD");
			System.out.println("����Ȱ��");
			break;
		case "DBU":
			System.out.println("����Ȱ��");
			break;
		
		default:
			System.out.println("�׷��Ŵ� ������ ~ ");
			break;
		}
	}

}
