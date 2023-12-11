package com.ji.springP001.Member;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

@Controller
public class MemberController {
	
	@Autowired
	private MemberDAO mDAO;
	
	@RequestMapping(value = "/member.login", method = RequestMethod.POST)
	public String login(Member m,HttpServletRequest req) throws Exception {

		mDAO.loginMember(m, req);
		if(mDAO.loginCheck(req)) {		
			
			req.setAttribute("content", "mainPage/home.jsp");			
		}else {		
			req.setAttribute("content", "mainPage/home.jsp");			
		}
		return "index";
		
	}
	
	@RequestMapping(value = "/member.logout", method = RequestMethod.GET)
	public String logout(Member m,HttpServletRequest req) throws Exception {

		if(mDAO.loginCheck(req)) {	
			mDAO.logOutMember(req);		
			mDAO.loginCheck(req);
			req.setAttribute("result", "로그아웃 성공!");
			req.setAttribute("content", "mainPage/home.jsp");			
		}else {	
			req.setAttribute("result", "새로고침!");
			req.setAttribute("content", "mainPage/home.jsp");			
		}
		return "index";
		
	}
	
	@RequestMapping(value = "/member.signup", method = RequestMethod.GET)
	public String goSign(HttpServletRequest req) throws Exception {

		if(mDAO.loginCheck(req)) {	
			req.setAttribute("result", "이미 로그인 되어있습니다.");
			req.setAttribute("content", "mainPage/home.jsp");			
		}else {	
			req.setAttribute("result", "회원가입");
			req.setAttribute("content", "login/reg.jsp");			
		}
		return "index";
		
	}
	
	@RequestMapping(value = "/member.signup.reg", method = RequestMethod.POST)
	public String regMember(HttpServletRequest req) throws Exception {

		if(mDAO.loginCheck(req)) {	
			req.setAttribute("result", "로그인 만료!");
			req.setAttribute("content", "mainPage/home.jsp");			
		}else {	
			mDAO.insertMember(req);
			req.setAttribute("content", "mainPage/home.jsp");			
		}
		return "index";
		
	}
	
	@RequestMapping(value = "/member.info", method = RequestMethod.GET)
	public String goUpdate(HttpServletRequest req) throws Exception {

		if(mDAO.loginCheck(req)) {	
			mDAO.getAddr(req);
			req.setAttribute("result", "회원수정/삭제");
			req.setAttribute("content", "login/memberUpdate.jsp");			
		}else {
			req.setAttribute("result", "로그인 만료!");
			req.setAttribute("content", "mainPage/home.jsp");
		}
		return "index";
		
	}
	
	@RequestMapping(value = "/member.update", method = RequestMethod.POST)
	public String updateMember(HttpServletRequest req) throws Exception {

		if(mDAO.loginCheck(req)) {
			mDAO.updateMember(req);
			mDAO.loginCheck(req);
			req.setAttribute("content", "mainPage/home.jsp");			
		}else {
			req.setAttribute("result", "로그인 만료!");
			req.setAttribute("content", "mainPage/home.jsp");
		}
		return "index";
		
	}
	
	@RequestMapping(value = "/member.leave", method = RequestMethod.GET)
	public String leaveMember(HttpServletRequest req) throws Exception {

		if(mDAO.loginCheck(req)) {		
			mDAO.deleteMember(req);
			mDAO.loginCheck(req);
			req.setAttribute("content", "mainPage/home.jsp");			
		}else {
			req.setAttribute("result", "로그인 만료!");
			req.setAttribute("content", "mainPage/home.jsp");
		}
		return "index";
		
	}

}
