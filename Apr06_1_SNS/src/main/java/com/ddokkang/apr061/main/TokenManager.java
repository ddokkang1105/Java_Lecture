package com.ddokkang.apr061.main;

import java.text.SimpleDateFormat;
import java.util.Date;

import javax.servlet.http.HttpServletRequest;

// �̰� ��������� ������ ���ΰ�ħ�� �� ������ �������� �߰��� ������
//		���� �� ���� ���ΰ�ħ�ص� �״�� ������ �ֵ��� �ϱ� ����
public class TokenManager {
	
	public static void make(HttpServletRequest request) {
		Date now = new Date();
		SimpleDateFormat sdf = new SimpleDateFormat("hh:mm:ss:SS");
		request.setAttribute("generatedToken", sdf.format(now));
		
	}
}
