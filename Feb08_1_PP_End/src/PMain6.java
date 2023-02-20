import java.util.Arrays;
import java.util.Scanner;

// Bubble Sort
// 	: 인접한 두 요소의 값을 비교해서
//	  기준에 만족하면 서로의 값을 교환하는 정렬 방법

// 선택정렬, 삽입정렬, 등등...

public class PMain6 {

	public static int[] setIntArray() {
		Scanner k = new Scanner(System.in);
		int[] arr = new int[5];
		for (int i = 0; i < arr.length; i++) {
			System.out.printf("%d 번째 값을 입력하세요 : ", i + 1);
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
				System.out.printf("%d 턴\n", i + 1);
				for (int j = 1; j < arr.length; j++) {
					if (set > arr[j]) {
						bowl = arr[j];
						arr[j] = set;
						arr[j - 1] = bowl;
					}
				}
				printArray(arr);
				System.out.printf("정렬된 값 : %d\n", set);
				System.out.println("====================");
			}
		}
	}

	public static void getResult(int[] num) {
		int b = 0;
		for (int turn = 1; turn < num.length; turn++) {
			for (int i = 0; i < num.length - 1; i++) {
				// num.length - 1 :
				// length 길이 그대로 사용하면 에러가 발생함 !
				
				if (num[i] > num[i + 1]) {
					b = num[i];
					num[i] = num[i + 1];
					num[i + 1] = b;

				}
				System.out.println(num[i] + " ");
				System.out.printf("정렬된 값 : %d\n", i);
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
		System.out.println("<< 입력한 값 >>");
		printArray(arr);
		System.out.println("====================");
		sortArray(arr);
		System.out.println("<< 정렬한 값 >>");
		printArray(arr);

		Arrays.sort(arr);
		for (int i : arr) {
			System.out.print(i + " ");
			
		}
		
	}
}
