package com.ddokkang.apr061.main;

import java.text.SimpleDateFormat;
import java.util.Date;

import javax.servlet.http.HttpServletRequest;

// �������⼭ ��¥�� ���� �ٷ� �� �ֱ� ������ main�� ��ġ�س���
public class DataManager {

	// <select> �����κп��� �ظ��� �ٲ��� ���� �޾ƿ��� !
	public static void getCurYear(HttpServletRequest request) {
		Date now = new Date();
		SimpleDateFormat sdf = new SimpleDateFormat("yyyy");
		String curYear = sdf.format(now);
		request.setAttribute("cy", curYear);
	}
	
}
