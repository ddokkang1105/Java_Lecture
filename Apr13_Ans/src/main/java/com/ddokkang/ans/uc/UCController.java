package com.ddokkang.ans.uc;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

@Controller
public class UCController {
	
	@Autowired
	private UCDAO ucd;
	
	@RequestMapping(value = "/unit.convert", method = RequestMethod.GET)
	public String unitConvert(UCResult ur, HttpServletRequest request) {
		
		ucd.convert(ur, request);
		return "output";
	}
}
