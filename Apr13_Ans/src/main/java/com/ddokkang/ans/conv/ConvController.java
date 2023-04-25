package com.ddokkang.ans.conv;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

@Controller
public class ConvController {
	
	@Autowired
	private ConvDAO cDAO;
	
	
	@RequestMapping(value = "/convert.do", method = RequestMethod.GET)
	public String convertNum(ConvResult cr, HttpServletRequest request) {
		
		cDAO.convert(cr, request);
		return "output";
	}
	

}
