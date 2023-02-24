package com.ddokkang.feb241.main;

import java.io.InputStream;
import java.net.URLEncoder;
import java.util.HashMap;
import java.util.Scanner;

import org.json.simple.JSONArray;
import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;

import com.ddokkang.http.client.DdokkangHttpClient;

// google - https://developers.kakao.com/ - 내 애플리케이션
// REST API 키 - 962c476d368e7ab9b964e93fa271060b
// 제품 - 지도/로컬 - 문서보기 - REST API - 키워드로 장소 검색하기 - parameter
// 지도 (우리나라)
// !3dxx - 37.5206868
// !4dxx - 127.1214941



public class LocSearchMain {
	public static void main(String[] args) {
		// 중심점 기준 반경 5km 이내에 검색한 키워드(입력)가 포함된 가게들을
		// 거리 기준으로 정렬 출력
		// 총 검색 결과 수
		
		// 현재 페이지 결과 수 
		// 주소
		// 전화번호
		// 상호명
		// 중심점과의 거리
		
		
		try {
			Scanner k = new Scanner(System.in);
			System.out.printf("키워드 : ");
			String keyword = k.next();
			keyword = URLEncoder.encode(keyword, "UTF-8");
//			System.out.println(keyword);
			
			String address = "https://dapi.kakao.com/v2/local/search/keyword.json";
			address += "?query=" + keyword;
			address += "&y=37.5206868";
			address	+= "&x=127.1214941";
			address += "&radius=5000";
			address += "&size=15";
			address += "&sort=distance";
//			System.out.println(address);
			
			HashMap<String, String> headers = new HashMap<String, String>();
			// 이 ~ 런 개 ~ 색
			headers.put("Authorization", "KakaoAK 962c476d368e7ab9b964e93fa271060b");
			InputStream is = DdokkangHttpClient.download(address, headers);
			String result = DdokkangHttpClient.convert(is, "UTF-8");
//			System.out.println(result);

			// 풀이 ver.
			JSONParser jp = new JSONParser();
			
			JSONObject jo = (JSONObject) jp.parse(result);
			
			// 총 검색 결과수
			JSONObject jo2 = (JSONObject) jo.get("meta");
			System.out.printf("총 검색 결과 수 : %s개\n", jo2.get("total_count"));
			// 현재 페이지 결과수
			System.out.printf("총 검색 결과 수 : %s개\n", jo2.get("pageable_count"));
			System.out.println("=============================================");
			// 주소
			// 전화번호
			// 상호명
			// 중심점과의 거리
			JSONArray ja = (JSONArray) jo.get("documents");
			JSONObject jo3 = null;
			for (int i = 0; i < ja.size(); i++) {
				jo3 = (JSONObject) ja.get(i);
				System.out.printf("주소 : %s\n", jo3.get("address_name"));
				System.out.printf("전화번호 : %s\n", jo3.get("phone"));
				System.out.printf("상호명 : %s\n", jo3.get("place_name"));
				System.out.printf("거리 : %s\n", jo3.get("distance"));
				System.out.println("=============================================");
			}
			
//////////////////////////////////////////////////////////////////////////////////////////
//			JSONParser jp = new JSONParser();
//			
//			JSONObject jo = (JSONObject) jp.parse(result);
//			
//			JSONArray ja = (JSONArray) jo.get("documents");
//			int count = 0;
//			for (count = 0; count < 15; count++) {
//				System.out.println(ja.get(i));
//			}
//			JSONObject doc = null;
//			int i = 0;
////			while (true) {
//				doc = (JSONObject) ja.get(i);
//				String name = (String) doc.get("address_name");
//				String phone = (String) doc.get("phone");
//				String placeName = (String) doc.get("place_name");
//				String distance = (String) doc.get("distance");
//				System.out.println(name);
//				System.out.println(phone);
//				System.out.println(placeName);
//				System.out.println(distance);
//				System.out.println("====================================");
//				i++;
//				
//				//				break;
//			}
			
		} catch (Exception e) {
			e.printStackTrace();
		}
		
	}
}
