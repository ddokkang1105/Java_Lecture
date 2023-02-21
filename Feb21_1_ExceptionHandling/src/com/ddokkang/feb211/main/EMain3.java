package com.ddokkang.feb211.main;

import java.io.FileReader;
import java.util.Scanner;

import com.ddokkang.feb211.caltool.PriceOfGram;

// Java
//		예외처리가 강제
// Python
//		처리하기 싫으면 안해도 됨

// txt파일을 받아와서 뭔가 할건데.. 만약에 !
// 이 텍스트 파일을 지웠거나, 없으면 어떻게 될까 ?
// try {
//	FileReader fr = new FileReader("E:/Test/adaf.txt");
// 	System.out.println(fr.read());
// } catch (Exception e) {
// 	e.printStackTrace();
// }

public class EMain3 {
	public static void main(String[] args) {
//		try {
//			FileReader fr = new FileReader("E:/Test/adaf.txt");
//			System.out.println(fr.read());
//		} catch (Exception e) {
////			e.printStackTrace();
//		}
		Scanner k = new Scanner(System.in);
		int price = 0;
		int gram = 0;
		System.out.print("Price : ");
		price = k.nextInt();
		System.out.print("Gram : ");
		gram = k.nextInt();
		PriceOfGram pog = new PriceOfGram(price, gram);
//		pog.calculate();
		try {
			int result = pog.divide2();
			System.out.printf("Price per Gram : %d\n", result);
		} catch (Exception e) {
			e.printStackTrace();
		}
		k.close();
		
	}
}
