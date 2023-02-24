package com.ddokkang.feb241.main;

import java.io.InputStream;
import java.net.URLEncoder;
import java.util.HashMap;
import java.util.Scanner;

import org.json.simple.JSONArray;
import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;

import com.ddokkang.http.client.DdokkangHttpClient;

// google - https://developers.kakao.com/ - �� ���ø����̼�
// REST API Ű - 962c476d368e7ab9b964e93fa271060b
// ��ǰ - ����/���� - �������� - REST API - Ű����� ��� �˻��ϱ� - parameter
// ���� (�츮����)
// !3dxx - 37.5206868
// !4dxx - 127.1214941



public class LocSearchMain {
	public static void main(String[] args) {
		// �߽��� ���� �ݰ� 5km �̳��� �˻��� Ű����(�Է�)�� ���Ե� ���Ե���
		// �Ÿ� �������� ���� ���
		// �� �˻� ��� ��
		
		// ���� ������ ��� �� 
		// �ּ�
		// ��ȭ��ȣ
		// ��ȣ��
		// �߽������� �Ÿ�
		
		
		try {
			Scanner k = new Scanner(System.in);
			System.out.printf("Ű���� : ");
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
			// �� ~ �� �� ~ ��
			headers.put("Authorization", "KakaoAK 962c476d368e7ab9b964e93fa271060b");
			InputStream is = DdokkangHttpClient.download(address, headers);
			String result = DdokkangHttpClient.convert(is, "UTF-8");
//			System.out.println(result);

			// Ǯ�� ver.
			JSONParser jp = new JSONParser();
			
			JSONObject jo = (JSONObject) jp.parse(result);
			
			// �� �˻� �����
			JSONObject jo2 = (JSONObject) jo.get("meta");
			System.out.printf("�� �˻� ��� �� : %s��\n", jo2.get("total_count"));
			// ���� ������ �����
			System.out.printf("�� �˻� ��� �� : %s��\n", jo2.get("pageable_count"));
			System.out.println("=============================================");
			// �ּ�
			// ��ȭ��ȣ
			// ��ȣ��
			// �߽������� �Ÿ�
			JSONArray ja = (JSONArray) jo.get("documents");
			JSONObject jo3 = null;
			for (int i = 0; i < ja.size(); i++) {
				jo3 = (JSONObject) ja.get(i);
				System.out.printf("�ּ� : %s\n", jo3.get("address_name"));
				System.out.printf("��ȭ��ȣ : %s\n", jo3.get("phone"));
				System.out.printf("��ȣ�� : %s\n", jo3.get("place_name"));
				System.out.printf("�Ÿ� : %s\n", jo3.get("distance"));
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
