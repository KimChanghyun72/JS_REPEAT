package com.dev.controller.member;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.dev.common.Controller;
import com.dev.dao.MemberDAO;
import com.dev.model.MemberVO;

public class MemberSelectAllController implements Controller {

	@Override
	public void execute(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		List<MemberVO> list = (List<MemberVO>)MemberDAO.getInstance().selectAll(null);
		
		request.setAttribute("memList", list);
		
		System.out.println();
		request.getRequestDispatcher("/member/memberUpdate.jsp").forward(request, response);
		
	}

}
