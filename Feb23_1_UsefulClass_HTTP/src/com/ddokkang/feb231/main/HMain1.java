package com.ddokkang.feb231.main;

import java.io.BufferedReader;
import java.io.InputStream;
import java.io.InputStreamReader;

import org.apache.http.HttpEntity;
import org.apache.http.HttpResponse;
import org.apache.http.client.methods.HttpGet;
import org.apache.http.impl.client.DefaultHttpClient;

// ��� 
//		Socket��� - �ǽð���� (�� �����ʹ� ������� �������۰���)
//		HTTP��� - Ŭ���̾�Ʈ�� ��û�� �ϸ� ������ �� ��û�� �°� ���� !

// Java���� HTTP����� ���� HTTPClient ����� ��'��'�� -> ������ �߾�� �ߴµ�... ��_��
// �ٸ� �����ڰ� �����Ͽ� ������ �س��� ! ^&^
// ���� ����� ������ �� ���� ��...!

// ���� �˻� - "apache httpcomponents" - ���ʿ� Download - HttpClient 4.5.14 (GA) Binary .zip download 
// ����
// ������Ʈ ��Ŭ�� - Build Path - Configure Build Path - Libraries - Add External Jars - .zip/lib/ �ȿ� �ִ°� �ֱ�



public class HMain1 {
	public static void main(String[] args) {
		
		// ������ ����
		try {
			DefaultHttpClient dhc = new DefaultHttpClient();
			
			// ��û - GET(�⺻) or POST
			HttpGet hg = new HttpGet("https://www.google.com/");
			
			// ����
			HttpResponse hr = dhc.execute(hg);
			
			// ���� ����
			HttpEntity he = hr.getEntity();
			
			// �� ������ ������ �� �ִ� ���� !!
			InputStream is = he.getContent();
			InputStreamReader isr = new InputStreamReader(is, "UTF-8");
			BufferedReader br = new BufferedReader(isr);
			
			String line = null;
			while ((line = br.readLine()) != null) {
				System.out.println(line);
			}
			br.close();
		} catch (Exception e) {
			e.printStackTrace();
		}
		
		
		
		
	}
}
