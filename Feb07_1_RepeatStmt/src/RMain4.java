import java.util.Scanner;

// continuel 
//		�����ݺ� ( ������ ) -> �� ���� ���� !

// break; 	(������) �ݺ��� ����
// return; 	(�������) �ݺ��� ����


public class RMain4 {
	
	
	
	public static void main(String[] args) {
		
//		for (int i = 0; i < 10; i++) {
//			if (i == 3) {
//				continue;
////				i++;
//			}
//			System.out.println(i);
//			System.out.println("�ȳ��ϼ���");
//			System.out.println("�ȳ��ϼ���");
//			System.out.println("�ȳ��ϼ���");
//			System.out.println("----------------");
//		}

		Scanner k = new Scanner(System.in);
//		String input = "";
//		while (input.equals("����") != true) {
//			System.out.print("���� �Է� : ");
//			input = k.next();
//			System.out.println("====================");
//			System.out.println(input);
//			System.out.println("====================");
//		}

		String input = null;
		while (true) {
			System.out.print("���� �Է� : ");
			input = k.next();
			System.out.println("====================");
			System.out.println(input);
			System.out.println("====================");
			if (input.equals("����")) {
				System.out.println("�ݺ��� �� !");
				break;
			}
		}
		
		
	}
}
