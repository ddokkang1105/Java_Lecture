import java.util.Scanner;

// swich-case 

// swich �� : �� ������ Ư���� ���̳� ���ڿ��� ��
//	break; �� �̿��Ͽ� �� ������ �����ϸ� switch�� �����ϵ���

//switch (���� or ��) {
//case �� A:
//	���� or ���� ���� A�� �� �� �κ��� ����
//	break;
//case �� B:
//	���� or ���� ���� B�� �� �� �κ��� ����
//	break;
//	
//default:
//	A ���� B ���� �ƴ� �� �� �κ��� ����
//	break;
//}


public class CMain3 {
	
	public static void inputNum(int input) {
		switch (input) {
		case 1:
			System.out.println("����");
			break;
		case 2:
			System.out.println("����");
			break;
		case 3:
			System.out.println("�Ф�");
			break;
		default:
			System.out.println("����...");
			break;
		}
		
	}
	
	public static void main(String[] args) {
		Scanner k = new Scanner(System.in);
		System.out.printf("������ �Է��ϼ��� : ");
		int input = k.nextInt();
		inputNum(input);
//		switch (input) {
//		case 1:
//			System.out.println("����");
//			break;
//		case 2:
//			System.out.println("����");
//			break;
//		case 3:
//			System.out.println("�Ф�");
//			break;
//		default:
//			System.out.println("����...");
//			break;
//		}
		
	}
}
