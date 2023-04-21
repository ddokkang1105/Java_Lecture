package com.ddokkang.apr122;

import java.text.DateFormat;
import java.util.Date;
import java.util.Locale;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.ddokkang.apr122.dog.Dog;

@Controller
public class HomeController {

	// Spring : Java에서 IoC로 DI해주는 Framework
	//		여태까지) 객체를 .java에서 만들기
	//		Spring) 객체를 외부파일(.xml)에 만들기 -> .java에서 불러서 사용하게끔
	
	// 제어의 역전 (Inversion of Control)은 일반적인 디자인 패턴 중 하나이고, 
	//		프로그램의 제어 흐름을 직접 제어하는 것이 아니라 외부에서 관리하는 것
	// 의존성 주입 (Dependency Injection)은 제어의 역전 패턴을 달성하는 방법 중 하나
	
	@RequestMapping(value = "/", method = RequestMethod.GET)
	public String home(Locale locale, Model model) {
		
		// 원래는 이렇게 객체를 만들었다면...
		Dog d = new Dog("개", 3);
		System.out.println(d.getName());
		System.out.println(d.getAge());
		
		return "home";
	}
	
}
