package com.ddokkang.feb212.main;

import java.util.StringTokenizer;

// 네트워크를 통해서 데이터를 받아오면 : 글자형태
// 네트워크를 통해서 데이터를 전달할 때 : 글자형태
// 한글처리가 까다로워 질 수 있음 !

// 외우지말고 찾아보기 !! (자동완성에 있는 기능, 설명 읽어보면서 !!)

// charAt() : 특정 위치에 있는 글자를 뽑아낼 때
//		System.out.println(s2.charAt(2));
// startsWith() : 시작하는 단어가 맞는지 아닌지 확인할 때 (true / false)
//		System.out.println(s2.startsWith("곧"));
// contains() : 찾는 단어가 있는지 (true / false)
//		System.out.println(s2.contains("너무"));
// replace() : 특정한 글자를 다른 글자로 바꿀 때 
//		System.out.println(s2.replace("휴강", "3월"));
// substring() : 원하는 위치의 글자를 뽑을 때 (시작위치, 끝위치 - 1)
//		System.out.println(s2.subSequence(2, 5));

// String 객체를 생성하는데 형식을 잡아서...
// printf와 유사하다
//		String s3 = String.format("무게 : %.2fkg", 123.4123);
//		System.out.println(s3);

// String 글자 추가
//		String s1 = "kk";
//		s1 = new String(s1 + "zz");
//		System.out.println(s1);

// String을 대량으로 추가
//		StringBuffer sb = new StringBuffer(s1);
//		sb.append("wow");
//		sb.append("what?");
//		sb.append("oh god !");
//		System.out.println(sb);
// String Type 으로 변경하기
//		String s4 = sb.toString();
//		System.out.println(s4);

// String 분리
//		String s5 = "kim,lee,park,choi";
// 1. split
// 골라서 쓸 수 있음
//		String[] s5Ar = s5.split(",");

// 2. StringTokenizer
// 순서대로 나옴
//		StringTokenizer st = new StringTokenizer(s5, ",");
//		System.out.println(st.nextToken());
//		System.out.println(st.nextToken());
//		System.out.println(st.nextToken());
//		System.out.println(st.nextToken());
// while 문 활용하여 출력
//		while (st.hasMoreTokens()) {
//			System.out.println(st.nextToken());
//		}
// 속도적인 면 : StringTokenizer
// data속에서 변수가 많다면 : split

public class TextMain1 {
	public static void main(String[] args) {
		// 정식 X -> 약식 !
//		String s1 = "으아아아ㅏ아아";
//		
//		String s2 = new String("곧 휴강 !!!!! 너무 신나 ~~");
//		System.out.println(s2.charAt(2));
//		System.out.println(s2.length());
//		System.out.println(s2.startsWith("곧"));
//		System.out.println(s2.contains("너무"));
//		System.out.println(s2.replace("휴강", "3월"));
//		System.out.println(s2.subSequence(2, 7));
//		System.out.println(s2.substring(2, 7));
//		
//		String s3 = String.format("무게 : %.2fkg", 123.4123);
//		System.out.println(s3);

//		String s1 = "kk";
//		s1 = new String(s1 + "zz");
//		System.out.println(s1);

//		StringBuffer sb = new StringBuffer(s1);
//		sb.append("wow");
//		sb.append("what?");
//		sb.append("oh god !");
//		System.out.println(sb);
//		
//		String s4 = sb.toString();
//		System.out.println(s4);
//		
		String s5 = "kim,lee,park,choi";
//		
//		String[] s5Ar = s5.split(",");

		StringTokenizer st = new StringTokenizer(s5, ",");
//		System.out.println(st.nextToken());
//		System.out.println(st.nextToken());
//		System.out.println(st.nextToken());
//		System.out.println(st.nextToken());
//		while (st.hasMoreTokens()) {
//			System.out.println(st.nextToken());
//		}

	}
}
