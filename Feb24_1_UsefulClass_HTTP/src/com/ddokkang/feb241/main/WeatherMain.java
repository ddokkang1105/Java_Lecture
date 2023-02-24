package com.ddokkang.feb241.main;

import java.io.InputStream;
import java.util.Scanner;

import org.json.simple.JSONArray;
import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;

import com.ddokkang.http.client.DdokkangHttpClient;


// google - openweathermap - https://openweathermap.org/ - API - API documentation 
// Current weather data - Built-in API request by city name

// json viewer - JSON VIEWER - 크롬 익스텐션

// AJAX - JavaScript에서 XML 파싱
//		=> XML 많이 안쓰임
//		=> JavaScipt에 친화된 형태가 없을까 ?

// JSON ( JavaScript Object Notation )
//		DB에 있는 데이터를 JavaScript 형태로 표현한 것
//		XML보다도 훨~~~씬 좋음

// Java 배열 : { 1, 2, 3 }
// JS 배열 : [ 1, 2, 3 ] 

// Java 객체 : Dog d = new Dog();
//				 d.setName("개");
//				 d.setAge(10);

// JS 객체 : { name : "개", age : 3 }

// google - mvnrepository - JSON.simple - 1.1.1 - View All - json-simple-1.1.1.jar

public class WeatherMain {
	public static void main(String[] args) {
		// https://api.openweathermap.org/data/2.5/weather?q={city name}&appid={5e6d6e938c64cabcecd3e680a2352ee1}
		// 섭씨온도 + 한국어로 출력
		// 도시 이름은 입력 (영어)
		
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
			JSONParser jp = new JSONParser();	// 파싱하려면 객체가 하나 필요 !
			
			// [] : 배열
//			JSONArray ja = (JSONArray) jp.parse(str);
//			System.out.println(ja);

			// {} : 객체
			JSONObject jo = (JSONObject) jp.parse(str);
//			System.out.println(jo);
			
			// 나라이름 접근
			JSONObject sys = (JSONObject) jo.get("sys");
			String country = (String) sys.get("country");
			System.out.printf("Country : %s\n", country);
			
			// 도시 이름
			String name = (String) jo.get("name");
			System.out.printf("City Name : %s\n", name);
			
			// description
//			JSONArray weather = (JSONArray) jo.get("weather");
//			System.out.println(weather);
//			String description = (String) weather.get("description");
//			System.out.printf("Description : %s\n", description);
			
			// 풀이
			JSONArray ja2 = (JSONArray) jo.get("weather");
			JSONObject jo2 = (JSONObject) ja2.get(0);
			String description = (String) jo2.get("description");
			System.out.printf("Description : %s\n", description);
			
			
			// 기온, 체감온도, 최저기온, 최고기온, 기압, 습도
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
