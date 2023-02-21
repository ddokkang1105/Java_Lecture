package com.ddokkang.feb212.main;

import java.util.Scanner;
import java.util.StringTokenizer;

public class TextMain2 {
	public static void main(String[] args) {
		Scanner k = new Scanner(System.in);
		String input = null;
		
		System.out.printf("문자/숫자/ 상관없이 : ");
		input = k.next();
		System.out.println(input);
		
//		String[] inputAr = new String[input.length()];
//		inputAr = input.split("/");

		String[] inputAr = input.split("/");
		
		int changenum = 0;
		int count = 0;
		int sum = 0;
		double average = 0;
		
		for (int i = 0; i < inputAr.length; i++) {
			try {
				changenum = Integer.parseInt(inputAr[i]);
				sum += changenum;
				count++;
			} catch (Exception e) {
//				e.printStackTrace();
//				continue;
			}
		}
		average = (double) sum / count;
		System.out.println(sum);
		System.out.println(average);

		// 풀이 ver.
//		System.out.printf("입력(a/b/1/2/...) : ");
//		String s = k.next();
//		System.out.println(s);
//		
//		StringTokenizer st = new StringTokenizer(s, "/");
//		
//		int n = 0;
//		int sum = 0;
//		int count = 0;
//		
//		while (st.hasMoreTokens()) {
//			try {
//				n = Integer.parseInt(st.nextToken());
//				sum += n;
//				count++;
//			} catch (Exception e) {
//				
//			}
//		}
//		
//		System.out.printf("총합 : %d\n", sum);
//		System.out.printf("평균 : %.2f\n", (double) sum / count);
		
	}
}
