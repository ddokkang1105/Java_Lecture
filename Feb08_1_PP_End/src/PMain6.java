import java.util.Arrays;
import java.util.Scanner;

// Bubble Sort
// 	: ������ �� ����� ���� ���ؼ�
//	  ���ؿ� �����ϸ� ������ ���� ��ȯ�ϴ� ���� ���

// ��������, ��������, ���...

public class PMain6 {

	public static int[] setIntArray() {
		Scanner k = new Scanner(System.in);
		int[] arr = new int[5];
		for (int i = 0; i < arr.length; i++) {
			System.out.printf("%d ��° ���� �Է��ϼ��� : ", i + 1);
			arr[i] = k.nextInt();
		}
		System.out.println();
		System.out.println("====================");
		return arr;
	}

	public static void printArray(int[] arr) {
		for (int i = 0; i < arr.length; i++) {
			System.out.print(arr[i]);
			System.out.print(" ");
		}
		System.out.println();
	}

	public static void sortArray(int[] arr) {
		int set = 0;
		int bowl = 0;

		a: while (true) {

			for (int i = 0; i < arr.length; i++) {
				if (arr[0] < arr[1]) {
					break a;
				}
				set = arr[0];
				System.out.printf("%d ��\n", i + 1);
				for (int j = 1; j < arr.length; j++) {
					if (set > arr[j]) {
						bowl = arr[j];
						arr[j] = set;
						arr[j - 1] = bowl;
					}
				}
				printArray(arr);
				System.out.printf("���ĵ� �� : %d\n", set);
				System.out.println("====================");
			}
		}
	}

	public static void getResult(int[] num) {
		int b = 0;
		for (int turn = 1; turn < num.length; turn++) {
			for (int i = 0; i < num.length - 1; i++) {
				// num.length - 1 :
				// length ���� �״�� ����ϸ� ������ �߻��� !
				
				if (num[i] > num[i + 1]) {
					b = num[i];
					num[i] = num[i + 1];
					num[i + 1] = b;

				}
				System.out.println(num[i] + " ");
				System.out.printf("���ĵ� �� : %d\n", i);
				System.out.println("====================");

			}
			System.out.println(num[4]);
		}
	}

//		for (int i = 0; i < arr.length; i++) {
//			set = arr[i];
//			for (int j = 1; j < 5; j++) {
//				if (set > arr[j]) {
//					bowl = arr[j];
//					arr[j] = set;
//					arr[j-1] = bowl;
//					printArray(arr);
//				} else {
//					break;
//				}
//				
//			}
//		}
//	}

	public static void main(String[] args) {
		int[] arr = setIntArray();
		System.out.println("<< �Է��� �� >>");
		printArray(arr);
		System.out.println("====================");
		sortArray(arr);
		System.out.println("<< ������ �� >>");
		printArray(arr);

		Arrays.sort(arr);
		for (int i : arr) {
			System.out.print(i + " ");
			
		}
		
	}
}
