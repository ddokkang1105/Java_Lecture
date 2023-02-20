import java.util.Random;
import java.util.Scanner;

public class PMain7 {
	public static void main(String[] args) {
		Random r = new Random();
		Scanner k = new Scanner(System.in);
		
//		int ranInt = 0;
//		int[] ranArr = new int[10];
//		for (int i = 0; i < ranArr.length; i++) {
//			ranInt = r.nextInt(100) + 1;
//			ranArr[i] = ranInt;
//		}
//		for (int i : ranArr) {
//			System.out.print(i + " ");
//		}
//		System.out.println();
//		System.out.println("=============================");
		
//		int scaInt = 0;
//		int[] scaArr = new int[10];
//		for (int i = 0; i < scaArr.length; i++) {
//			scaInt = k.nextInt();
//			scaArr[i] = scaInt;
//		}
//		for (int i : scaArr) {
//			System.out.print(i + " ");
//		}
//		System.out.println();
//		System.out.println("=============================");
		
		int ranInt = 0;
		int maxInt = 0;
		int minInt = 0;
		
		int[] ranArr = new int[10];
		for (int i = 0; i < ranArr.length; i++) {
			ranInt = r.nextInt(100) + 1;
			ranArr[i] = ranInt;
		}
		for (int i : ranArr) {
			System.out.print(i + " ");
		}
		System.out.println();
		System.out.println("=============================");
		
		for (int i = 0; i < ranArr.length; i++) {
			if (i == 0) {
				maxInt = ranArr[0];
			}
			if (maxInt < ranArr[i]) {
				maxInt = ranArr[i];
			} 
		}
		for (int i = 0; i < ranArr.length; i++) {
			if (i == 0) {
				minInt = ranArr[0];
			}
			if (minInt > ranArr[i]) {
				minInt = ranArr[i];
			} 
		}
		System.out.println(maxInt);
		System.out.println(minInt);
	}
}
