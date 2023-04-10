package com.ddokkang.apr061.main;

import java.text.SimpleDateFormat;
import java.util.Date;

import javax.servlet.http.HttpServletRequest;

// 이걸 만들어주지 않으면 새로고침을 할 때마다 같은글이 추가로 생성됨
//		내가 쓴 글이 새로고침해도 그대로 있을수 있도록 하기 위해
public class TokenManager {
	
	public static void make(HttpServletRequest request) {
		Date now = new Date();
		SimpleDateFormat sdf = new SimpleDateFormat("hh:mm:ss:SS");
		request.setAttribute("generatedToken", sdf.format(now));
		
	}
}
