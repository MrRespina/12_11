package com.ji.springP001.Member;

import java.io.File;
import java.io.IOException;
import java.net.URLDecoder;
import java.net.URLEncoder;
import java.util.List;

import javax.servlet.http.HttpServletRequest;

import org.apache.ibatis.session.SqlSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.oreilly.servlet.MultipartRequest;
import com.oreilly.servlet.multipart.DefaultFileRenamePolicy;

@Service
public class MemberDAO {

	@Autowired
	private SqlSession ss;

	public boolean loginCheck(HttpServletRequest req) {

		Member m = (Member) req.getSession().getAttribute("loginCheck");

		if (m == null) {
			req.setAttribute("log", "login/default.jsp");
			return false;
		} else {
			req.setAttribute("log", "login/checked.jsp");
			return true;
		}

	}

	public void loginMember(Member m, HttpServletRequest req) {

		try {

			List<Member> mm = ss.getMapper(memberMapper.class).searchMember(m);
			if (mm.size() != 0) {

				if (mm.get(0).getM_id().equals(m.getM_id())) {

					if (mm.get(0).getM_pw().equals(m.getM_pw())) {

						req.getSession().setAttribute("loginCheck", mm.get(0));
						req.getSession().setMaxInactiveInterval(600);
						req.setAttribute("member", mm);
						req.setAttribute("result", "로그인 성공");

					} else {
						req.setAttribute("result", "로그인 실패(PW불일치)");
					}
				} else {
					req.setAttribute("result", "로그인 실패(ID불일치)");
				}
			} else {
				req.setAttribute("result", "로그인 실패(ID없음)");
			}

		} catch (Exception e) {
			e.printStackTrace();
			req.setAttribute("member", null);
			req.setAttribute("result", "DB 오류!");
		}

	}

	public void logOutMember(HttpServletRequest req) {

		req.getSession().setAttribute("loginCheck", null);

	}

	public void insertMember(HttpServletRequest req) throws IOException {

		String path = req.getSession().getServletContext().getRealPath("resources/img");
		MultipartRequest mr = new MultipartRequest(req, path, 10 * 1024 * 1024, "utf-8", new DefaultFileRenamePolicy());
		// 10MB 까지!

		Member mem = new Member();
		mem.setM_id(mr.getParameter("inputId"));
		mem.setM_pw(mr.getParameter("inputPw"));
		mem.setM_name(mr.getParameter("inputName"));

		String post = mr.getParameter("inputPost");
		String addr = mr.getParameter("inputAddr");
		String detail = mr.getParameter("inputDetailAddr");
		String realAddr = post + "," + addr + "," + detail;

		mem.setM_addr(realAddr);

		String b_photo = mr.getFilesystemName("inputFile");
		String a_photo = URLEncoder.encode(b_photo, "UTF-8").replace("+", " ");

		mem.setM_photo(a_photo);
		mem.setM_class(Integer.parseInt(mr.getParameter("inputClass")));

		// DB id 대조를 위해 불러온 Mapper. 밑에서 isEmpty로 중복 ID 검사
		memberMapper mm = ss.getMapper(memberMapper.class);

		if (mm.searchMember(mem).isEmpty()) {

			mm.regMember(mem);
			req.setAttribute("result", "회원가입 성공!");

		} else {

			// 중복 아이디일시 저장한 이미지 삭제
			String pt = URLDecoder.decode(mem.getM_photo(), "UTF-8");
			new File(path + "/" + pt).delete();
			req.setAttribute("result", "이미 존재하는 아이디!");

		}

	}

	public void getAddr(HttpServletRequest req) {

		// memberUpdate 테이블 호출시 주소를 , 로 구분하여 나눠서 채워넣어준다.
		Member m = (Member) req.getSession().getAttribute("loginCheck");
		String addr = m.getM_addr();
		String[] result = addr.split(",");

		req.setAttribute("post", result[0]);
		req.setAttribute("addr", result[1]);
		req.setAttribute("detail", result[2]);

	}

	public void updateMember(HttpServletRequest req) {

		try {

			String path = req.getSession().getServletContext().getRealPath("resources/img");
			MultipartRequest mr = new MultipartRequest(req, path, 10 * 1024 * 1024, "utf-8",
					new DefaultFileRenamePolicy());

			Member mem = new Member();
			mem.setM_id(mr.getParameter("updateId"));
			mem.setM_pw(mr.getParameter("updatePw"));
			mem.setM_name(mr.getParameter("updateName"));

			String addr = mr.getParameter("post") + "," + mr.getParameter("addr") + "," + mr.getParameter("detail");

			mem.setM_addr(addr);

			Member m = (Member) req.getSession().getAttribute("loginCheck");
			String oldPhoto = m.getM_photo();
			String newPhoto = mr.getFilesystemName("updateF");
			memberMapper mm = ss.getMapper(memberMapper.class);

			try {

				if (newPhoto == null || newPhoto.isEmpty()) {
					mem.setM_photo(oldPhoto);
				} else if (oldPhoto.equals(newPhoto)) {
					mem.setM_photo(oldPhoto);
				} else {
					// newPhoto가 들어온 경우에만 예전 사진을 지워준다! (예외처리는 JS에서)
					mem.setM_photo(newPhoto);
					oldPhoto = URLDecoder.decode(oldPhoto, "UTF-8");
					new File(path + "/" + oldPhoto).delete();			
				}
					try {
						mm.updateMember(mem);
						// 성공?
						req.getSession().setAttribute("loginCheck", mem);
						req.setAttribute("result", "정보 수정 성공!");
					} catch (Exception e) {
						// 만약에 새 파일 추가 실패 시, 예전 사진 다시 추가
						oldPhoto = URLEncoder.encode(m.getM_photo(), "UTF-8");
						new File(path + "/" + oldPhoto.replace("+", " "));
						req.setAttribute("result", "에러/프사 변경 실패");
					}
			} catch (Exception e) {
				// UPDATE 실패 시 > 예전 사진 다시 추가
				e.printStackTrace();
				oldPhoto = URLEncoder.encode(m.getM_photo(), "UTF-8");
				new File(path + "/" + oldPhoto.replace("+", " "));
				req.setAttribute("result", "에러/DB UPDATE 오류");
			}
		} catch (Exception e) {
			e.printStackTrace();
			req.setAttribute("result", "에러/DAO 에러");
		}

	}

	public void deleteMember(HttpServletRequest req) {

		Member m = (Member) req.getSession().getAttribute("loginCheck");
		memberMapper mm = ss.getMapper(memberMapper.class);

		try {

			mm.leaveMember(m);

			try {
				// 회원 탈퇴시 정해진 곳에 저장되어있는 사진도 같이 삭제해야함.
				String oldPhoto = m.getM_photo();
				String path = req.getSession().getServletContext().getRealPath("resources/img");
				oldPhoto = URLDecoder.decode(oldPhoto, "UTF-8");
				new File(path + "/" + oldPhoto).delete();
				req.getSession().setAttribute("loginCheck", null);
				req.setAttribute("result", "탈퇴 성공");
			} catch (Exception e) {
				req.setAttribute("result", "오류/프로필 사진이 없습니다");
			}

		} catch (Exception e) {
			req.setAttribute("result", "오류/DB 삭제 실패");
		}

	}

}
