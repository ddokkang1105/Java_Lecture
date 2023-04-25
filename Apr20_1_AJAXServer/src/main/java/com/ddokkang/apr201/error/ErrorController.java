package com.ddokkang.apr201.error;

import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
public class ErrorController {

	@Autowired
	private ErrorDAO eDAO;
	
	@RequestMapping(value = "/error.get", method = RequestMethod.GET)
	public String getError(HttpServletRequest req) {
		
		return "index";
	}
	
	@RequestMapping(value = "/error.getXML", method = RequestMethod.GET,
			produces = "application/xml; charset=UTF-8")
	public @ResponseBody Errors getErrorXML(HttpServletRequest req) {
		return eDAO.getErrorXML(req);
	}
	
	@RequestMapping(value = "/error.getJSON", method = RequestMethod.GET,
			produces = "application/json; charset=UTF-8")
	public @ResponseBody Errors getErrorJSON(HttpServletRequest req, HttpServletResponse res) {
		// 이 사이트 외부에서 AJAX가 가능하게 하려면...
		// 응답 파라미터를 추가하고(HttpServletResponse)
		// 코드를 헤더를 추가
		res.addHeader("Access-Control-Allow-Origin", "*"); // 모두가 접근할 수 있다
		return eDAO.getJSON(req);
	}
	
	@RequestMapping(value = "/error.searchJSON", method = RequestMethod.GET,
			produces = "application/json; charset=UTF-8")
	public @ResponseBody Errors searchJSON(Error e, HttpServletRequest req) {
		return eDAO.searchJSON(e, req);
	}
	
}
