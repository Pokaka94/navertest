package com.example.demo;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;

@Controller
public class HelloController {
@RequestMapping("/helloboot")
public ModelAndView helloboot() {
	ModelAndView mv = null; //new ModelAndView();
	mv.addObject("model", "스프링부트를 시작합니다");
	mv.setViewName("hello");
	return mv;
}

@RequestMapping("/helloajax")
@ResponseBody
public String helloajax() {
	return "{\"model\" :  \"스프링부트(ajax)를 시작합니다\"}";
}

}

/*  <context:componen.. 
 *	<beans:bean class="org.springframework.web.servlet.view.InternalResourceViewResolver">
		<beans:property name="prefix" value="/WEB-INF/views/" />
		<beans:property name="suffix" value=".jsp" />
	</beans:bean>
	
	 run as-run on server - 서버 시작 - mvc 
 * 
 * */
