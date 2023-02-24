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

// Products - 검색 - 개발가이드 - 

// ID 		: SzMoSoYMTOFkqQlT2juo
// Secret 	: ONbb3_Wu8t

// https://search.naver.com/search.naver?where=nexearch&sm=top_sug.pre&fbm=1&acr=1&acq=%EC%B1%94%EC%8A%A4&qdt=0&ie=utf8&query=%EC%B1%94%EC%8A%A4

// 인터넷 주소 체계
//		프로토콜:// - 통신방식
//		컴퓨터의 주소/ (search.naver.com)
//		폴더명/폴더명/.../파일명
//		(**중요**) ? 다음에 나오는
//			변수명=값&변수명=값&변수명=값&...
//			=> 요청 파라미터 : 클라이언트가 서버에게 공개적으로 전달할 정보

//	인터넷 주소에는 한글, 특수문자 바로 들어가면 안됨 !
//		ex) ㅋ -> %2D (URL 인코딩)

public class NaverNewsMain {
	public static void main(String[] args) {
		try {
			// https://openapi.naver.com/v1/search/news.xml

			Scanner k = new Scanner(System.in);
			System.out.printf("검색어 : ");
			String search = k.next();
//			System.out.println(search);
			search = URLEncoder.encode(search, "UTF-8");
//			System.out.println(search);

			String address = "https://openapi.naver.com/v1/search/news.xml";
			address += "?query=" + search;

//			InputStream is = DdokkangHttpClient.download(address);
//			String result = DdokkangHttpClient.convert(is, "UTF-8");
//			System.out.println(result);

			// HttpsURLConnection 활용 -> 그 안에 있는 기능 활용 !

//			URL u = new URL(address);
//			HttpsURLConnection huc = (HttpsURLConnection) u.openConnection();
//			// 요청 헤더 
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

			// 검색어 -> 뉴스 결과
			// 뉴스의 title / description
			// 제목 : Naver Open API - news :: '주식' -> 안나오게
			// 내용 : Naver Search Result - 안나오게

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
							System.out.printf("제목 : %s\n", t);
						} else if (tagName.endsWith("description")) {
							t = xpp.getText();
							t = t.replace("<b>", "");
							t = t.replace("</b>", "");
							t = t.replace("&quot", "");
							t = t.replace("&apos", "");
							t = t.replace("&amp", "&");
							System.out.printf("내용 : %s\n", t);
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
