package com.ddokkang.ans.uc;

import java.util.HashMap;

import javax.servlet.http.HttpServletRequest;

import org.springframework.stereotype.Service;

@Service
public class UCDAO {
	
	// spring - appServlet - servlet-context 에 추가 !
	private HashMap<String, String> unit;
	
	public void setUnit(HashMap<String, String> unit) {
		this.unit = unit;
	}

	public void convert(UCResult ur, HttpServletRequest request) {
		double n1 = ur.getN1();
		String what = request.getParameter("what");	// select -> name
		
		double n2 = n1 * 1.61;
		if (what.equals("l")) {
			n2 = n1 * 0.39;
		} else if (what.equals("d")) {
			n2 = n1 * 0.3;
		} else if (what.equals("t")) {
			n2 = n1 * 1.8 + 32;
		}
		
		n2 = Double.parseDouble(String.format("%.3f", n2));
		
		// 단위들은 어떻게 받아올 것인가 ?
		System.out.println(unit);
		System.out.println(unit.get(what));
		
		String[] u = unit.get(what).split(",");
		
//		String[] unitAll = unit.get("all").split(",");
//		for (String s : unitAll) {
//			System.out.println(s);
//		}
		
		ur.setN2(n2);
		ur.setU1(u[0]);
		ur.setU2(u[1]);
		
		request.setAttribute("ur", ur);
	}
	
}
