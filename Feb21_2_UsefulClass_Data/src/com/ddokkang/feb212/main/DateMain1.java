package com.ddokkang.feb212.main;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Locale;

// ***중요***
// Date.java : 아~~~~~주 옛날(1900년대) 만들어진 Class
//			Y2K에 관심이 없던 시절
//			현재 실정에 맞지 않음
//			1900년대 당시에 용량이 적었기 때문에 연도끝에 2자리만...
//			1970년대 이전의 컴퓨터 : 속도가 음청 느리고, 장치의 용량이 적었다.
//			데이터의 양을 아끼기 위해서 연도처리 4byte가 아닌 2byte로 할당
//			문제가 생김 !
//			1900년, 2000년 끝의 두자리가 00으로 인식해서 통일됨 !
//			-> 구분이 불가능해졌다 ! -> 컴퓨터의 오작동 가능성이 높아질 것이라 추측,,,!
//			근데 별일 없었음 ㅋ

// Date : 날짜 / 시간 

// 기본생성 -> 현재 시간 / 날짜
// import java.util.Date;
// 연도 -> 현재년도 - 1900
// System.out.println(now.getYear() + 1900);
// 월 -> 0 : January
// System.out.println(now.getMonth() + 1);
// 일
// System.out.println(now.getDate());
// 요일 -> 0 : Sunday
// System.out.println(now.getDay());
// String[] day = { "일", "월", "화", "수", "목", "금", "토" };
// System.out.println(day[now.getDay()]);

// deprecated
//		세월이 흐르고, 컴퓨터도 발전 -> 옛날에 만들어 놓은걸 못쓰겠음...
//		프로그래밍 언어도 없데이트가 되어야 하는데...
//		없애서나 / 기능을 수정할 계획이 생겨버림
//		현재 자바버전에서는 OK ! / 다음 버전에는 없어져도 불만가지지 말거라 ~

// Date - 형식지정 -> String
// SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd E a hh:mm", Locale.CANADA);
// String s1 = sdf.format(now);
// System.out.println(s1);


// 특정 시간 날짜
// Date d2 = new Date(2023, 2, 14);

// String - 형식 지정 -> Date
//		try {
//			String s2 = "2000-02-14";
//			SimpleDateFormat sdf2 = new SimpleDateFormat("yyyy-MM-dd");
//			Date d3 = sdf2.parse(s2);
//			System.out.println(d3);
//		} catch (Exception e) {
//			e.printStackTrace();
//		}
//		System.out.println("============================");

// Calender / Local~~~
// 잘 안 쓸수도...?

public class DateMain1 {
	public static void main(String[] args) {
//		Date now = new Date();
//		System.out.println(now);
//		
//		System.out.println(now.getYear() + 1900);
//		System.out.println(now.getMonth() + 1);
//		System.out.println(now.getDate());
////		System.out.println(now.getDay());
//		String[] day = { "일", "월", "화", "수", "목", "금", "토" };
//		System.out.println(day[now.getDay()]);
//		System.out.println("============================");
//		
//		SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd E a hh:mm");
//		
//		String s1 = sdf.format(now);
//		System.out.println(s1);
//		System.out.println("============================");
//		
////		Date d2 = new Date(2023, 2, 14);
//		Date d2 = new Date(123, 2, 14);
//		System.out.println(d2);
//		System.out.println("============================");
//		
//		try {
//			String s2 = "2000-02-14";
//			SimpleDateFormat sdf2 = new SimpleDateFormat("yyyy-MM-dd");
//			Date d3 = sdf2.parse(s2);
//			System.out.println(d3);
//		} catch (Exception e) {
//			e.printStackTrace();
//		}
//		System.out.println("============================");
		
		try {
			String s3 = "2013/02/21";
			SimpleDateFormat sdf3 = new SimpleDateFormat("yyyy/MM/dd");
			Date d4 = sdf3.parse(s3);
//			d4.setMonth(1);
//			System.out.println(d4);
//			System.out.println(day[d4.getDay()]);
//			System.out.printf("10년 전 오늘 날짜의 요일 : %s\n", day[d4.getDay()]);
			
			SimpleDateFormat sdf4 = new SimpleDateFormat("E");
			String dayy = sdf4.format(d4);
			System.out.printf("10년 전 오늘 날짜의 요일 : %s\n", dayy);
		} catch (Exception e) {
			e.printStackTrace();
		}
		System.out.println("============================");
		
		
		
	}
}
