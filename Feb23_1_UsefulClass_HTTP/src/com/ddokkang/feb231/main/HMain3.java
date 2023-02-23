package com.ddokkang.feb231.main;

import java.io.InputStream;

import com.ddokkang.http.client.DdokkangHttpClient;

public class HMain3 {
	public static void main(String[] args) {
		try {
			InputStream is = DdokkangHttpClient.download("https://www.naver.com");
			
			String result = DdokkangHttpClient.convert(is, "UTF-8");
			System.out.println(result);
		} catch (Exception e) {
			e.printStackTrace();
		}
		
		
		
		
		
		
		
		
		
	}
}
