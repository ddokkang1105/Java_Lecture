package com.ddokkang.http.client;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.URL;

import javax.net.ssl.HttpsURLConnection;

public class DdokkangHttpClient {
	// ������ ��û�ؼ� �ٿ�ޱ�
	public static InputStream download(String address) throws IOException {
		URL u = new URL(address);
		// �Է¹��� ���� http / https ���� �𸣴ϱ� �����ϱ�
		if (address.startsWith("https")) {
			HttpsURLConnection huc = (HttpsURLConnection) u.openConnection();
			return huc.getInputStream();
		} else {
			HttpURLConnection huc = (HttpURLConnection) u.openConnection();
			return huc.getInputStream();
		}
		
	}
	
	// �ٿ������ String ���� �ٲٱ�
	public static String convert(InputStream is, String charset) throws IOException {
		InputStreamReader isr = new InputStreamReader(is, charset);
		BufferedReader br = new BufferedReader(isr);
		
		String line = null;
		StringBuffer sb = new StringBuffer();
		
		while ((line = br.readLine()) != null) {
			sb.append(line);
		}
		return sb.toString();
	}
	
	
}
