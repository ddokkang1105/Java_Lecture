package com.ddokang.feb232.main;

import java.io.InputStream;

import org.xmlpull.v1.XmlPullParser;
import org.xmlpull.v1.XmlPullParserFactory;

import com.ddokkang.http.client.DdokkangHttpClient;

public class WeatherMain {
	
	// ���û - Ȩ������ �Ʒ��� - RSS - ���ϴ� ����
	
	// http://www.kma.go.kr/wid/queryDFSRSS.jsp?zone=5011025000
	
	// �ð�
	// �µ�
	// ����
	// �ٶ� ���� 
	// �ܼ� ���
	public static void main(String[] args) {
		String address = "http://www.kma.go.kr/wid/queryDFSRSS.jsp?zone=5011025000";

		try {
			InputStream is = DdokkangHttpClient.download(address);
			
			XmlPullParserFactory xppf = XmlPullParserFactory.newInstance();
			XmlPullParser xpp = xppf.newPullParser();
			xpp.setInput(is, "UTF-8");
			
			int type = xpp.getEventType();
			String tagName = null;
			while (type != XmlPullParser.END_DOCUMENT) {
				if (type == XmlPullParser.START_TAG) {
					tagName = xpp.getName();
				} else if (type == XmlPullParser.TEXT) {
					if (tagName.equals("hour")) {
						System.out.printf("%s H, ", xpp.getText());
					} else if (tagName.equals("temp")) {
						System.out.printf("%s��C, ", xpp.getText());
					} else if (tagName.equals("wfEn")) {
						System.out.printf("%s, ", xpp.getText());
					} else if (tagName.equals("wdEn")) {
						System.out.printf("%s\n", xpp.getText());
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
