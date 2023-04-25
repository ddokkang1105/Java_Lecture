package com.ddokkang.apr203.weather;

import java.io.BufferedReader;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.URL;

import javax.servlet.http.HttpServletRequest;

import org.springframework.stereotype.Service;

@Service
public class WeatherDAO {

	// 기상청 XML 다운(파싱)받아와서 -> String 한 덩어리로 뭉쳐서 그대로 리턴 !
	// http://www.kma.go.kr/wid/queryDFSRSS.jsp?zone=1150060300
//	public XmlPullParser getAllWeather() {
//		try {
//			String address = "http://www.kma.go.kr/wid/queryDFSRSS.jsp?zone=1150060300";
//			
//			InputStream is = DdokkangHttpClient.download(address);
//
//			XmlPullParserFactory xppf = XmlPullParserFactory.newInstance();
//			XmlPullParser xpp = xppf.newPullParser();
//			xpp.setInput(is, "UTF-8");
//			System.out.println(is);
//			System.out.println(xppf);
//			System.out.println(xpp);
//			
//			return xpp;
//		} catch (Exception e) {
//			e.printStackTrace();
//			return null;
//		}
//	}
	
	public String getKoreaWeather(HttpServletRequest req) {
		try {
			URL u = new URL("http://www.kma.go.kr/wid/queryDFSRSS.jsp?zone=1150060300");
			
			HttpURLConnection huc = (HttpURLConnection) u.openConnection();
			InputStream is = huc.getInputStream();
			
			BufferedReader br = new BufferedReader(new InputStreamReader(is, "UTF-8"));
			
			// 나오는 하나하나를 한 덩어리로 뭉치기
			StringBuffer sb = new StringBuffer();
			
			String line = null;
			while ((line = br.readLine()) != null) {
				sb.append(line.replace("\r\n", ""));
			}
			
			// 다운받아온 데이터를 한 덩어리로 뭉쳤고, 엔터키 처리 없앰
			return sb.toString();
		} catch (Exception e) {
			e.printStackTrace();
			return null;
		}
		
	}
	
}
