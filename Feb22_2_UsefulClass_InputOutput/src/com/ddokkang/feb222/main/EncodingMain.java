package com.ddokkang.feb222.main;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.io.UnsupportedEncodingException;

// Encoding : ������ ���³� ������ ��ȯ�ϴ� ó�����
// ��ǻ�� : ���ڱ�� ( ���Ⱑ �帣�ų�, �帣�� �ʰų� )
// '��' -> ������ �帧���� ǥ�� (�𸣽� ��ȣ) -> encoding

// Decoding : ���ڵ� �� ������ ��� ���� �� ������ ������ ���·� ��ȯ
// ������ �帧 -> '��' -> decoding

// encoding ����� ���� ������ ���� !
// Ŀ�� -A->(en) 1010 -A->(de) Ŀ��
// Ŀ�� -B-> 0101 -C-> ����ũ
// Ŀ�� -C-> 0001 -?-> ??!?!?!
// encoding - decoding ���� ���Ѿ� �� ^o^

// �� ���������� �ַ� : UTF-8(Unicode Transform Format)
// �ѱ��� Ÿ�� : EUC-KR
// MS���� : MS949

// ����ũ -UTF-8-> 1011 -MS949-> ????
// encoding - decoding ���� ���Ѿ� �� ^~^







public class EncodingMain {
	public static void main(String[] args) {
//		FileOutputStream fos = null;
//		try {
//			fos = new FileOutputStream("C:\\Users\\sdedu\\Desktop\\Java_Test\\encoding\\test.txt", true);
//		} catch (FileNotFoundException e) {
//			e.printStackTrace();
//		}
//		
//		OutputStreamWriter osw = null;
//		try {
//			osw = new OutputStreamWriter(fos, "UTF-8");
//		} catch (UnsupportedEncodingException e) {
//			e.printStackTrace();
//		}
//		
//		BufferedWriter bw = new BufferedWriter(osw);
//		try {
//			bw.write("asdasjflqkeqwe");
//			bw.append("\r\n");
//			bw.append("����˿���������" + "\r\n");
//			bw.append("ȣ��������������" + "\r\n");
//			bw.flush();
//		} catch (IOException e) {
//			e.printStackTrace();
//		}
//		
//		try {
//			bw.close();
//		} catch (IOException e) {
//			e.printStackTrace();
//		}
// -> �Է��� �� ���� �߰��� !		

		
		BufferedReader br = null;
		try {
			FileInputStream fis = new FileInputStream("C:\\Users\\sdedu\\Desktop\\Java_Test\\encoding\\test.txt");
			
			InputStreamReader isr = new InputStreamReader(fis, "UTF-8");
			
			br = new BufferedReader(isr);
			
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
