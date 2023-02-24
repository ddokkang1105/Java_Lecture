package com.ddokkang.feb241.main;

import java.io.InputStream;
import java.net.URL;
import java.net.URLEncoder;
import java.util.HashMap;
import java.util.Scanner;

import javax.net.ssl.HttpsURLConnection;

import org.xmlpull.v1.XmlPullParser;
import org.xmlpull.v1.XmlPullParserFactory;

import com.ddokkang.http.client.DdokkangHttpClient;

// https://developers.naver.com/main/	

// Products - �˻� - ���߰��̵� - 

// ID 		: SzMoSoYMTOFkqQlT2juo
// Secret 	: ONbb3_Wu8t

// https://search.naver.com/search.naver?where=nexearch&sm=top_sug.pre&fbm=1&acr=1&acq=%EC%B1%94%EC%8A%A4&qdt=0&ie=utf8&query=%EC%B1%94%EC%8A%A4

// ���ͳ� �ּ� ü��
//		��������:// - ��Ź��
//		��ǻ���� �ּ�/ (search.naver.com)
//		������/������/.../���ϸ�
//		(**�߿�**) ? ������ ������
//			������=��&������=��&������=��&...
//			=> ��û �Ķ���� : Ŭ���̾�Ʈ�� �������� ���������� ������ ����

//	���ͳ� �ּҿ��� �ѱ�, Ư������ �ٷ� ���� �ȵ� !
//		ex) �� -> %2D (URL ���ڵ�)

public class NaverNewsMain {
	public static void main(String[] args) {
		try {
			// https://openapi.naver.com/v1/search/news.xml

			Scanner k = new Scanner(System.in);
			System.out.printf("�˻��� : ");
			String search = k.next();
//			System.out.println(search);
			search = URLEncoder.encode(search, "UTF-8");
//			System.out.println(search);

			String address = "https://openapi.naver.com/v1/search/news.xml";
			address += "?query=" + search;

//			InputStream is = DdokkangHttpClient.download(address);
//			String result = DdokkangHttpClient.convert(is, "UTF-8");
//			System.out.println(result);

			// HttpsURLConnection Ȱ�� -> �� �ȿ� �ִ� ��� Ȱ�� !

//			URL u = new URL(address);
//			HttpsURLConnection huc = (HttpsURLConnection) u.openConnection();
//			// ��û ��� 
//			huc.addRequestProperty("X-Naver-Client-Id", "949yNWHd2cRfhbsBhRry");
//			huc.addRequestProperty("X-Naver-Client-Secret", "FQL35F8GBp");
//			InputStream is = huc.getInputStream();
//			
//			String result = DdokkangHttpClient.convert(is, "UTF-8");
//			System.out.println(result);
			/////////////////////////////////////////////////////////////////////////
			HashMap<String, String> headers = new HashMap<String, String>();
			headers.put("X-Naver-Client-Id", "949yNWHd2cRfhbsBhRry");
			headers.put("X-Naver-Client-Secret", "FQL35F8GBp");
			InputStream is = DdokkangHttpClient.download(address, headers);
//			String result = DdokkangHttpClient.convert(is, "UTF-8");
//			System.out.println(result);

			// �˻��� -> ���� ���
			// ������ title / description
			// ���� : Naver Open API - news :: '�ֽ�' -> �ȳ�����
			// ���� : Naver Search Result - �ȳ�����

			XmlPullParserFactory xppf = XmlPullParserFactory.newInstance();
			XmlPullParser xpp = xppf.newPullParser();
			xpp.setInput(is, "UTF-8");

			int type = xpp.getEventType();
			String tagName = null;

			String t = null;
			boolean data = false;
			
			while (type != XmlPullParser.END_DOCUMENT) {
				if (type == XmlPullParser.START_TAG) {
					tagName = xpp.getName();
					if (tagName.equals("item")) {
						data = true;
					}
				} else if (type == XmlPullParser.TEXT) {
					if (data) {
						if (tagName.equals("title")) {
							t = xpp.getText();
							t = t.replace("<b>", "");
							t = t.replace("</b>", "");
							t = t.replace("&quot", "");
							t = t.replace("&apos", "");
							t = t.replace("&amp", "&");
							System.out.printf("���� : %s\n", t);
						} else if (tagName.endsWith("description")) {
							t = xpp.getText();
							t = t.replace("<b>", "");
							t = t.replace("</b>", "");
							t = t.replace("&quot", "");
							t = t.replace("&apos", "");
							t = t.replace("&amp", "&");
							System.out.printf("���� : %s\n", t);
							System.out.println("====================================================");
						}
					}
				} else if (type == XmlPullParser.END_TAG) {
					tagName = "";
				}
				xpp.next();
				type = xpp.getEventType();
			}

		} catch (Exception e) {
			e.printStackTrace();
		}

	}
}
