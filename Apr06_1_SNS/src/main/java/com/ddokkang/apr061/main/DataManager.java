package com.ddokkang.apr061.main;

import java.text.SimpleDateFormat;
import java.util.Date;

import javax.servlet.http.HttpServletRequest;

// 여기저기서 날짜를 많이 다룰 수 있기 때문에 main에 배치해놨음
public class DataManager {

	// <select> 연도부분에서 해마다 바꾸지 말고 받아오자 !
	public static void getCurYear(HttpServletRequest request) {
		Date now = new Date();
		SimpleDateFormat sdf = new SimpleDateFormat("yyyy");
		String curYear = sdf.format(now);
		request.setAttribute("cy", curYear);
	}
	
}
