package com.ddokkang.feb211.main;

import java.io.FileReader;
import java.util.Scanner;

import com.ddokkang.feb211.caltool.PriceOfGram;

// Java
//		����ó���� ����
// Python
//		ó���ϱ� ������ ���ص� ��

// txt������ �޾ƿͼ� ���� �Ұǵ�.. ���࿡ !
// �� �ؽ�Ʈ ������ �����ų�, ������ ��� �ɱ� ?
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
