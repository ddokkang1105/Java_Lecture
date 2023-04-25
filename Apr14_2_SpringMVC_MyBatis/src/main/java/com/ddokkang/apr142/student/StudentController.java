package com.ddokkang.apr142.student;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

@Controller
public class StudentController {
	
	@Autowired
	private StudentDAO sDAO;
	
	@RequestMapping(value = "/student.reg", method = RequestMethod.GET)
	public String reqStudent(Student s, HttpServletRequest request) {
		sDAO.reqStudent(s, request);
		sDAO.getAllStudent(request);
		return "index";
	}
}
