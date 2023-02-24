package com.ddokkang.feb241.main;

import java.io.InputStream;
import java.util.Scanner;

import org.json.simple.JSONArray;
import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;

import com.ddokkang.http.client.DdokkangHttpClient;


// google - openweathermap - https://openweathermap.org/ - API - API documentation 
// Current weather data - Built-in API request by city name

// json viewer - JSON VIEWER - ũ�� �ͽ��ټ�

// AJAX - JavaScript���� XML �Ľ�
//		=> XML ���� �Ⱦ���
//		=> JavaScipt�� ģȭ�� ���°� ������ ?

// JSON ( JavaScript Object Notation )
//		DB�� �ִ� �����͸� JavaScript ���·� ǥ���� ��
//		XML���ٵ� ��~~~�� ����

// Java �迭 : { 1, 2, 3 }
// JS �迭 : [ 1, 2, 3 ] 

// Java ��ü : Dog d = new Dog();
//				 d.setName("��");
//				 d.setAge(10);

// JS ��ü : { name : "��", age : 3 }

// google - mvnrepository - JSON.simple - 1.1.1 - View All - json-simple-1.1.1.jar

public class WeatherMain {
	public static void main(String[] args) {
		// https://api.openweathermap.org/data/2.5/weather?q={city name}&appid={5e6d6e938c64cabcecd3e680a2352ee1}
		// �����µ� + �ѱ���� ���
		// ���� �̸��� �Է� (����)
		
		try {
			Scanner k = new Scanner(System.in);
			System.out.printf("City : ");
			String city = k.next();
//			System.out.println(city);
			
			String address = "https://api.openweathermap.org/data/2.5/weather";
			address += "?q=" + city;
			address += "&appid=5e6d6e938c64cabcecd3e680a2352ee1";
			address += "&units=metric";
			address += "&lang=kr";
			
			InputStream is = DdokkangHttpClient.download(address);
			String str = DdokkangHttpClient.convert(is, "UTF-8");
//			System.out.println(str);
//////////////////////////////////////////////////////////////////////////////////////////////////
			JSONParser jp = new JSONParser();	// �Ľ��Ϸ��� ��ü�� �ϳ� �ʿ� !
			
			// [] : �迭
//			JSONArray ja = (JSONArray) jp.parse(str);
//			System.out.println(ja);

			// {} : ��ü
			JSONObject jo = (JSONObject) jp.parse(str);
//			System.out.println(jo);
			
			// �����̸� ����
			JSONObject sys = (JSONObject) jo.get("sys");
			String country = (String) sys.get("country");
			System.out.printf("Country : %s\n", country);
			
			// ���� �̸�
			String name = (String) jo.get("name");
			System.out.printf("City Name : %s\n", name);
			
			// description
//			JSONArray weather = (JSONArray) jo.get("weather");
//			System.out.println(weather);
//			String description = (String) weather.get("description");
//			System.out.printf("Description : %s\n", description);
			
			// Ǯ��
			JSONArray ja2 = (JSONArray) jo.get("weather");
			JSONObject jo2 = (JSONObject) ja2.get(0);
			String description = (String) jo2.get("description");
			System.out.printf("Description : %s\n", description);
			
			
			// ���, ü���µ�, �������, �ְ���, ���, ����
			JSONObject main = (JSONObject) jo.get("main");
//			System.out.println(main);
			double temp = (Double) main.get("temp");
			double fl = (Double) main.get("feels_like");
			double tempMin = (Double) main.get("temp_min");
			double tempMax = (Double) main.get("temp_max");
			long humidity = (long) main.get("humidity");
			System.out.printf("Temperature : %.2f\n", temp);
			System.out.printf("Feels like Temp : %.2f\n", fl);
			System.out.printf("Max Temp : %.2f\n", tempMax);
			System.out.printf("Min Temp : %.2f\n", tempMin);
			System.out.printf("Humidity : %d\n", humidity);
			
			
		} catch (Exception e) {
			e.printStackTrace();
		}
		
		
		
	}
}
