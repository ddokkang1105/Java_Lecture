import java.util.Scanner;

// �ݺ����� �̸� ���̱�
//		-> �ݺ��� �տ� (�̸� :) while () {}

public class RMain5 {

	public static void main(String[] args) {
		Scanner k = new Scanner(System.in);

//		String who = "";
//		while (who.equals("��") != true) {
//			System.out.print("���� : ");
//			who = k.next();
//			switch (who) {
//			case "�Ŵ���":
//				System.out.println("�ý��۰���");
//			case "����":
//				System.out.println("�л�����");
//			case "�л�":
//				System.out.println("�������� ����");
//				break;
//			default:
//				if (who.equals("��") != true) {
//					System.out.println("���� ~ ?");
//				}
//				break;
//				
//			}
//			System.out.println();
//		}
//		System.out.println("���α׷��� �����մϴ�.");

//		String who = null;
//		while (true) {
//			System.out.print("���� : ");
//			who = k.next();
//			if (who.equals("��")) {
//				break;
//			} else {
//				switch (who) {
//				case "�Ŵ���":
//					System.out.println("�ý��۰���");
//				case "����":
//					System.out.println("�л�����");
//				case "�л�":
//					System.out.println("�������� ����");
//					break;
//				default:
//					System.out.println("���� ~ ?");
//					break;
//				}
//			}
//			System.out.println();
//		}
//		System.out.println("���α׷��� �����մϴ�.");

//		String who = "";
//		role : while (who.equals("��") != true) {
//			System.out.print("���� : ");
//			who = k.next();
//			switch (who) {
//			case "�Ŵ���":
//				System.out.println("�ý��۰���");
//			case "����":
//				System.out.println("�л�����");
//			case "�л�":
//				System.out.println("�������� ����");
//				break;
//			case "��":
//				break role;
//			default:
//				System.out.println("���� ~ ?");
//				break;
//
//			}
//			System.out.println();
//		}
//		System.out.println("���α׷��� �����մϴ�.");
		
		bb : for (int i = 0; i < 3; i++) {
			aa : for (int j = 0; j < 3; j++) {
				for (int j2 = 0; j2 < 3; j2++) {
					System.out.printf("%d %d %d\n", i, j, j2);
					if (i == 1) {
						System.out.println("�ߴ� !");
						
						// break;			
						// 000 001 002 010 011 012 020 021 022
						// 100 110 120 200 210 220
						// break aa;
						// 000 001 002 010 011 012 020 021 022 
						// 100 200
						// break bb;		
						// 000 001 002 010 011 012 020 021 022
						// 100
						// Ʋ�� ����
						// if �� �ȿ� break; �� �ɸ��ٰ� �ؼ� 
						// �ƿ� ����Ǵ� ���� �ƴ϶�
						// if ���� ������ �°� �Ǹ� �ٽ� �����Ѵ�.
						
					}
				}
			}
		}
		bb : for (int i = 0; i < 3; i++) {
			aa : for (int j = 0; j < 3; j++) {
				for (int j2 = 0; j2 < 3; j2++) {
					System.out.printf("%d %d %d\n", i, j, j2);
					while (i == 1) {
						System.out.println("�ߴ� !");
						break;
					}
				}
			}
		}
		
		
		
		
	}
}
