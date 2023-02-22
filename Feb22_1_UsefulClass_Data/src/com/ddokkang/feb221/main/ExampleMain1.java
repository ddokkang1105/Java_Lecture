package com.ddokkang.feb221.main;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Scanner;

public class ExampleMain1 {
	public static void main(String[] args) {
//		Scanner k = new Scanner(System.in);
//		String thing = null;
//		
//		System.out.println("이름/생년월일(xxxx.xx.xx)/국어점수/수학점수/영어점수 : ");
//		thing = k.next();
////		thing = "지성/1981.03.30/90/95/85";
//		System.out.println("===============================");
//		System.out.println(thing);
//		System.out.println("===============================");
//		
////		String[] thingArr = new String[thing.length()];
////		thingArr = thing.split("/");
//		String[] thingArr = thing.split("/");
//		
//		try {
//			SimpleDateFormat birthFormat = new SimpleDateFormat("yyyy.MM.dd");
//			Date birthParse = birthFormat.parse(thingArr[1]);
//
//			SimpleDateFormat dayFormat = new SimpleDateFormat("E");
//			String dayy = dayFormat.format(birthParse);
//			System.out.printf("생일 : %s %s요일\n", thingArr[1].replace(".", "/"), dayy);
//			System.out.println("===============================");
//			
//			SimpleDateFormat yearFormat = new SimpleDateFormat("yyyy");
//			String yearr = yearFormat.format(birthParse);
//			int yearToInt = Integer.parseInt(yearr);
//			System.out.println("나이 : " + (2023 - yearToInt) + "세");
//			System.out.println("===============================");
//		} catch (ParseException e) {
////			e.printStackTrace();
//		}
//		
//		int count = 0;
//		int score = 0;
//		int sum = 0;
//		for (int i = 2; i < thingArr.length; i++) {
//			score = Integer.parseInt(thingArr[i]);
//			sum += score;
//			count++;
//		}
//		System.out.printf("총점 : %d\n", sum);
//		System.out.printf("평균 : %.2f\n", (double) sum / count);
//		
		// 풀이
		Scanner k = new Scanner(System.in);
		System.out.println("이름/생년월일(xxxx.xx.xx)/국어점수/수학점수/영어점수 : ");
		String s = k.next();
//		System.out.println(s);
		
		String[] sData = s.split("/");
		String name = sData[0];
		System.out.printf("Name : %s\n", name);
		
		try {
			String bd = sData[1];
			SimpleDateFormat sdf = new SimpleDateFormat("yyyy.MM.dd");
			Date birthday = sdf.parse(bd);
			
			SimpleDateFormat sdf2 = new SimpleDateFormat("yyyy/MM/dd E");
			String birthdayStr = sdf2.format(birthday);
			System.out.println(birthdayStr);
			
			Date now = new Date();
			SimpleDateFormat yrFmt = new SimpleDateFormat("yyyy");
			String nowYr = yrFmt.format(now);
			String birthdayYr = yrFmt.format(birthday);
			
			int ny = Integer.parseInt(nowYr);
			int by = Integer.parseInt(birthdayYr);
			int age = ny - by + 1;
			System.out.println(age);
			
			int kor = Integer.parseInt(sData[2]);
			int math = Integer.parseInt(sData[3]);
			int eng = Integer.parseInt(sData[4]);
			
			System.out.println(kor);
			System.out.println(math);
			System.out.println(eng);
			
			int sum = kor + math + eng;
			System.err.println(sum);
			
			double avg = (double) sum / 3;
			System.out.println(avg);
			
		} catch (Exception e) {
			e.printStackTrace();
		}
		
		
		
		
		
	}
}
