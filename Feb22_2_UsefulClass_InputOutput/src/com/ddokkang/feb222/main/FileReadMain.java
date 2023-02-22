package com.ddokkang.feb222.main;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;

public class FileReadMain {
	public static void main(String[] args) {
		// Window는 경로에 대소문자 구별 안함
		// Linux는 대소문자 구별함
		
		// fr위에 br을 덮은 상태
		// 연관된 것들 중에서 하나만 닫으면 다 처리
		BufferedReader br = null;
		try {
			
			FileReader fr = new FileReader("C:\\Users\\sdedu\\Desktop\\Java_Test\\filewrite\\test.txt");
			br = new BufferedReader(fr);
			
			String line = null;
			while ((line = br.readLine()) != null) {
				System.out.println(line);
			}
			
		} catch (Exception e) {
			e.printStackTrace();
		}
		
		try {
			br.close();
		} catch (IOException e) {
			e.printStackTrace();
		}
		
		
		
		
		
		
		
	}
}
