package com.ddokkang.feb221.main;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Locale;
import java.util.Scanner;
import java.util.StringTokenizer;

public class ExampleMain2 {
	public static void main(String[] args) {
//		Scanner k = new Scanner(System.in);
//		String s = null;
//		System.out.println("Name/Birthday(xxxx.xx.xx)/kor Score/Math Score/Eng Score : ");
//		s = k.next();
////		s = "지성/1981.03.30/90/95/85";
//		System.out.println(s);
//		
//		try {
//			StringTokenizer stn = new StringTokenizer(s, "/");
//			String name = stn.nextToken();
//			System.out.printf("Name : %s\n", name);
//			
//			String bd = stn.nextToken();
//			SimpleDateFormat sdf = new SimpleDateFormat("yyyy.MM.dd");
//			Date bdDate = sdf.parse(bd);
//			
//			SimpleDateFormat sdf2 = new SimpleDateFormat("yyyy/MM/dd E", Locale.ENGLISH);
//			String birthday = sdf2.format(bdDate);
//			System.out.printf("Birthday : %s\n", birthday);
//			
//			Date now = new Date();
//			SimpleDateFormat yrFmt = new SimpleDateFormat("yyyy");
//			String nowYr = yrFmt.format(now);
//			String bdYr = yrFmt.format(bdDate);
//			
//			int ny = Integer.parseInt(nowYr);
//			int bdy = Integer.parseInt(bdYr);
//			int age = ny - bdy + 1;
//			System.out.printf("Age : %d\n", age);
//			
//			int kor = Integer.parseInt(stn.nextToken());
//			System.out.printf("Korean Score : %d\n", kor);
//
//			int math = Integer.parseInt(stn.nextToken());
//			System.out.printf("Math Score : %d\n", math);
//			
//			int eng = Integer.parseInt(stn.nextToken());
//			System.out.printf("English Score : %d\n", eng);
//			
//			int sum = kor + math + eng;
//			System.out.printf("Total Score : %d\n", sum);
//			
//			double avg = (double) sum / 3;
//			System.out.printf("Average : %.2f\n", avg);
//			
//		} catch (ParseException e) {
//			e.printStackTrace();
//		}
		
		// 풀이
		Scanner k = new Scanner(System.in);
		System.out.println("Name/Birthday(xxxx.xx.xx)/kor Score/Math Score/Eng Score : ");
		String s = k.next();
		
		StringTokenizer st = new StringTokenizer(s, "/");
		System.out.printf("Name : %s\n", st.nextToken());
		
		try {
			String bd = st.nextToken();
			SimpleDateFormat sdf = new SimpleDateFormat("yyyy.MM.dd");
			Date birth = sdf.parse(bd);
			
			SimpleDateFormat sdf2 = new SimpleDateFormat("yyyy/MM/dd E", Locale.ENGLISH);
			String birthdayStr = sdf2.format(birth);
			System.out.printf("Birthday : %s\n", birthdayStr);

			SimpleDateFormat yearFmt = new SimpleDateFormat("yyyy");
			String nowYr = yearFmt.format(new Date());
			int ny = Integer.parseInt(nowYr);
			
			String birthdayYr = yearFmt.format(birth);
			int by = Integer.parseInt(birthdayYr);
			
			int age = ny - by + 1;
			System.out.printf("Age : %d\n", age);
			
			int kor = Integer.parseInt(st.nextToken());
			int math = Integer.parseInt(st.nextToken());
			int eng = Integer.parseInt(st.nextToken());
			
			System.out.printf("Korean Score : %d\n", kor);
			System.out.printf("Math Score : %d\n", math);
			System.out.printf("English Score : %d\n", eng);

			int sum = kor + math + eng;
			System.out.printf("Total Score : %d\n", sum);

			double avg = (double) sum / 3;
			System.out.printf("Average : %.2f\n", avg);
			
		} catch (Exception e) {
			e.printStackTrace();
		}
		
		
		
	}
}
