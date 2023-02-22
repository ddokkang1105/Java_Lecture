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

// Encoding : 정보의 형태나 형식을 변환하는 처리방식
// 컴퓨터 : 전자기계 ( 전기가 흐르거나, 흐르지 않거나 )
// 'ㅋ' -> 전기의 흐름으로 표현 (모르스 부호) -> encoding

// Decoding : 인코딩 된 데이터 통신 전송 및 파일을 원래의 상태로 변환
// 전기의 흐름 -> 'ㅋ' -> decoding

// encoding 방식은 여러 종류가 있음 !
// 커피 -A->(en) 1010 -A->(de) 커피
// 커피 -B-> 0101 -C-> 쉐이크
// 커피 -C-> 0001 -?-> ??!?!?!
// encoding - decoding 통일 시켜야 함 ^o^

// 전 세계적으로 주력 : UTF-8(Unicode Transform Format)
// 한국만 타겟 : EUC-KR
// MS전용 : MS949

// 마스크 -UTF-8-> 1011 -MS949-> ????
// encoding - decoding 통일 시켜야 함 ^~^







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
//			bw.append("우오옹오오오오오" + "\r\n");
//			bw.append("호에에에에에에엥" + "\r\n");
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
// -> 입력할 때 마다 추가됨 !		

		
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
