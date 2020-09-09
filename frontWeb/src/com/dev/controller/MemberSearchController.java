package com.dev.controller;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpUtils;

import com.dev.model.MemberDAO;
import com.dev.model.MemberVO;

public class MemberSearchController implements Controller {

	@Override
	public void execute(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		//job에 따라서 포워드 페이지를 지정.
		String path = "memberSearch.jsp";
		String job = request.getParameter("job");
		if(job.equals("delete")) {
			path = "memberDelete.jsp";
		} else if (job.equals("update")) {
			path = "memberUpdate.jsp";
		}
		//파라미터 변수에 저장
		String id = request.getParameter("id");
		
		//유효성 체크
		if(id==null||id=="") {
			request.setAttribute("error", "아이디를 입력하세요.");
			request.setAttribute("errorCode", 1);
			//search페이지로 포워드
			request.getRequestDispatcher("/member/" + path).forward(request, response);//아디 없으면 입력한곳으로 돌아감
			return;
		}
		
		//vo에 담기
		MemberVO member = new MemberVO();
		member.setId(id);
		
		//서비스
		member = MemberDAO.getInstance().selectOne(member);
		if(id!=member.getId()) {
			request.setAttribute("error", "DB에 아이디가 없습니다.");
			request.setAttribute("errorCode", 1);
		}
		
		request.setAttribute("member", member);
		if(job.equals("search")) {
			request.getRequestDispatcher("/member/memberSearchOutput.jsp").forward(request, response);
		}else {
			request.getRequestDispatcher("/member/" + path).forward(request, response);
		}
		//조회결과를 저장 후에 결과 페이지로 포워드.
		
	}

}
