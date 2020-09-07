package com.dev.controller;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.dev.model.MemberDAO;
import com.dev.model.MemberVO;

public class MemberDeleteController implements Controller {

	@Override
	public void execute(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		//파라미터 변수에 저장
				String id = request.getParameter("id");
				
				//유효성 체크
				if(id==null||id=="") {
					request.setAttribute("error", "아이디를 입력하세요.");
					request.setAttribute("errorCode", 1);
					//search페이지로 포워드
					request.getRequestDispatcher("/member/memberDelete.jsp").forward(request, response);
					return;
				}
				//vo에 담기
				MemberVO member = new MemberVO();
				member.setId(id);
				
				//서비스
				int r = MemberDAO.getInstance().delete(member);
				request.setAttribute("result", r);
				request.getRequestDispatcher("/member/memberDeleteOutput.jsp").forward(request, response);
				//조회결과를 저장 후에 결과 페이지로 포워드.
				
	}

}
