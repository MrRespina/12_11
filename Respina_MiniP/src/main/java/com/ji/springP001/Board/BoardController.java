package com.ji.springP001.Board;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.ji.springP001.Member.MemberDAO;

@Controller
public class BoardController {

	@Autowired
	private BoardDAO bDAO;

	@Autowired
	private MemberDAO mDAO;

	@RequestMapping(value = "/board.go", method = RequestMethod.GET)
	public String home(HttpServletRequest req) throws Exception {

		// 전체 게시글에서 페이지를 넘기는 것과, 내 게시글에서 페이지를 넘기는 것을 구분하기 위해 만듬.	
		mDAO.loginCheck(req);
		req.setAttribute("boardVal", "all");	
		if (req.getParameter("p") == null) {

			bDAO.getAllBoard(1, req);
			req.setAttribute("result", "게시판 페이지");
			req.setAttribute("content", "board/boardMain.jsp");

		} else {

			bDAO.getAllBoard(Integer.parseInt(req.getParameter("p")), req);
			req.setAttribute("result", "게시판 페이지");
			req.setAttribute("content", "board/boardMain.jsp");

		}

		return "index";

	}

	@RequestMapping(value = "/board.getmyBoard", method = RequestMethod.GET)
	public String getMyBoard(HttpServletRequest req) throws Exception {
		
		if(mDAO.loginCheck(req)) {
			
			if (req.getParameter("p") == null) {
		
				req.setAttribute("boardVal", "my");
				bDAO.getMyBoard(1, req);
				req.setAttribute("result", "내 글 보기");
				req.setAttribute("content", "board/boardMain.jsp");
				
			} else {

				req.setAttribute("boardVal", "my");
				bDAO.getMyBoard(Integer.parseInt(req.getParameter("p")), req);
				req.setAttribute("result", "내 글 보기");
				req.setAttribute("content", "board/boardMain.jsp");

			}
			
		} else {
			
			req.setAttribute("boardVal", "all");
			bDAO.getAllBoard(1, req);
			req.setAttribute("result", "로그인 만료됨!");
			req.setAttribute("content", "board/boardMain.jsp");
			
		}

		return "index";

	}

	@RequestMapping(value = "/board.writeBoard", method = RequestMethod.GET)
	public String writeBoard(HttpServletRequest req) throws Exception {

		if (mDAO.loginCheck(req)) {
			bDAO.insertBoard(req);
			
			req.setAttribute("boardVal", "all");
			bDAO.getAllBoard(1, req);
			req.setAttribute("content", "board/boardMain.jsp");
		} else {
			req.setAttribute("result", "로그인 만료됨!");
			req.setAttribute("content", "mainPage/home.jsp");
		}

		return "index";

	}
	
	@RequestMapping(value = "/board.boardInfo", method = RequestMethod.GET)
	public String boardInfo(HttpServletRequest req) throws Exception {

		if (mDAO.loginCheck(req)) {
			
			req.setAttribute("b_no", req.getParameter("b_no"));
			req.setAttribute("b_owner", req.getParameter("b_owner"));
			req.setAttribute("b_text", req.getParameter("b_text"));
			req.setAttribute("result", "보드 상세정보");
			req.setAttribute("content", "board/boardInfo.jsp");
			
		} else {
			
			req.setAttribute("result", "로그인 만료됨!");
			req.setAttribute("content", "mainPage/home.jsp");
			
		}

		return "index";

	}

}
