package com.dev.controller.member;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.dev.common.Controller;
import com.dev.dao.MemberDAO;
import com.dev.model.MemberVO;

public class MemberDeleteController implements Controller {

	@Override
	public void execute(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		//파라미터 변수에 저장
				String id = request.getParameter("id");
				
				//유효성 체크
				
				//vo에 담기
				MemberVO member = new MemberVO();
				member.setId(id);
				
				//서비스로직
				int r = MemberDAO.getInstance().delete(member);
				
				//결과 저장
				request.setAttribute("result", r);
				
				//뷰 페이지로 이동
				request.getRequestDispatcher("/member/memberDeleteOutput.jsp")
						.forward(request, response);
				//조회결과를 저장 후에 결과 페이지로 포워드.
				
	}

}
