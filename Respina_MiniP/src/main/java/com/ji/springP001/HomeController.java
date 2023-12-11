package com.ji.springP001;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.ji.springP001.Member.MemberDAO;

@Controller
public class HomeController {
	
	@Autowired
	private MemberDAO mDAO;
	
	@RequestMapping(value = "/", method = RequestMethod.GET)
	public String home(HttpServletRequest req) throws Exception {

		if(mDAO.loginCheck(req)) {
			
			req.setAttribute("result", "Hello World!");
			req.setAttribute("content", "mainPage/home.jsp");
		}else {
			req.setAttribute("result", "Hello World!");
			req.setAttribute("content", "mainPage/home.jsp");
		}
	
		return "index";
		
	}
	
}
