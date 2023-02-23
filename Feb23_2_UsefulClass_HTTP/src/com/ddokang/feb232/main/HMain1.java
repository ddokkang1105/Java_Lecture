package com.ddokang.feb232.main;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.net.URL;

import javax.net.ssl.HttpsURLConnection;

import com.ddokkang.http.client.DdokkangHttpClient;

public class HMain1 {
	// 원하는 사이트 내용 콘솔창에 출력하기 !
	public static void main(String[] args) {
//		try {
//			String address = "https://www.yahoo.co.jp/";
//			URL u = new URL(address);
//
//			HttpsURLConnection huc = (HttpsURLConnection) u.openConnection();
//
//			InputStream is = huc.getInputStream();
//			InputStreamReader isr = new InputStreamReader(is, "UTF-8");
//			BufferedReader br = new BufferedReader(isr);
//
//			String line = null;
//			while ((line = br.readLine()) != null) {
//				System.out.println(line);
//			}
//		} catch (Exception e) {
//			e.printStackTrace();
//		}
		
		// 풀이
		InputStream is = null;
		try {
			is = DdokkangHttpClient.download("https://www.yahoo.co.jp/");
			String result = DdokkangHttpClient.convert(is, "UTF-8");
			System.out.println(result);
		} catch (Exception e) {
			e.printStackTrace();
		}
		try {
			is.close();
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
}
