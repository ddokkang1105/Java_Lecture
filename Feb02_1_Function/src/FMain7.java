import java.util.Scanner;

// ����� ȣ�� (recursive call)
//		�Լ� �ӿ��� �ڱ� �ڽ��� �� ȣ�� => �ݺ�

// ������� �׽�Ʈ�� �� ���� �ִ� !

//	public static int addToInt(int input) {
//		int answer = (input == 1) ? 1 : (input + addToInt(input - 1));
//		return answer;
//	}


public class FMain7 {

//	public static int addToInt(int input) {
//		
//		return (input * (input + 1)) / 2;
//	}

//	public static void addToInt() {
//		Scanner k = new Scanner(System.in);
//		System.out.print("���� �Է��ϼ��� : ");
//		int inputInt = k.nextInt();
//		int sumInputInt = (inputInt * (inputInt + 1)) / 2;
//		System.out.printf("1���� %d������ ���� : \"%d\" �Դϴ�."
//				, inputInt, sumInputInt);
//	}

//	public static int addToInt(int input) {
//		int answer = (input == 1) ? 1 : (input + addToInt(input - 1));
//		return answer;
//	}
	
	public static int mulToInt(int input) {
		int answer = (input == 1) ? 1 : (input * mulToInt(input - 1));
		return answer;
	}
	
	public static int addAgainInt(int input) {
		int answer = (input < 3) ? 1 : (addAgainInt(input - 1) + addAgainInt(input - 2));
		return 0;
	}
	
	public static void main(String[] args) {
		int i1 = mulToInt(6);
		System.out.println(i1);
		int i2 = mulToInt(10);
		System.out.println(i2);
		int i3 = mulToInt(4);
		System.out.println(i3);
	
	}
}
