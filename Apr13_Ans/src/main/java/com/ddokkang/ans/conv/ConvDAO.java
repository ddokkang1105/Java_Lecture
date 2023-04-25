package com.ddokkang.ans.conv;

import javax.servlet.http.HttpServletRequest;

import org.springframework.stereotype.Service;

@Service
public class ConvDAO {
	
	public void convert(ConvResult cr, HttpServletRequest request) {
		double x = cr.getX();
		int s_conv = cr.getS_conv();
		request.setAttribute("x", x);
		request.setAttribute("s_conv", s_conv);
		System.out.println(x);
		System.out.println(s_conv);
		
		double result = 0;
		switch (s_conv) {
		case 1:
			result = x * 0.39;
			break;
		case 2:
			result = x * 0.3;
			break;
		case 3:
			result = x * 1.8 + 32;
			break;
		case 4:
			result = x * 1.61;
			break;
		}
		request.setAttribute("r", result);
		System.out.println(result);
		
	}
}
