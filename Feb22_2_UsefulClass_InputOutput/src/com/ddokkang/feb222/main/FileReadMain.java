package com.ddokkang.feb222.main;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;

public class FileReadMain {
	public static void main(String[] args) {
		// Window�� ��ο� ��ҹ��� ���� ����
		// Linux�� ��ҹ��� ������
		
		// fr���� br�� ���� ����
		// ������ �͵� �߿��� �ϳ��� ������ �� ó��
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
