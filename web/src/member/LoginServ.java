package member;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;


@WebServlet({"/member/login", "/member/logout"})
public class LoginServ extends HttpServlet {

	//logout
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		req.getSession().invalidate();//무효화
		resp.sendRedirect("../index.jsp");
	}
	
	//login
	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		//1.파라미터를 vo에 담기
		MemberVO memberVO = new MemberVO();
		memberVO.setId(req.getParameter("id"));
		memberVO.setPassword(req.getParameter("password"));
		
		//2. 서비스 처리(DB 등록 조회)
		MemberVO resultVO = MemberDAO.getInstance().selectOne(memberVO);
		
		//3.결과 저장
		String page = "";
		if(resultVO == null) { //id가 없음
			req.setAttribute("errorMsg", "해당 아이디가 없습니다.");
			page = "login.jsp";
		}else {
			if(memberVO.getPassword().equals(resultVO.getPassword())) { //로그인성공
				req.getSession().setAttribute("login", resultVO);
				req.getSession().setAttribute("id", resultVO.getId());
				page = "../index.jsp";
			} else { //패스워드 불일치
				req.setAttribute("errorMsg", "패스워드 불일치");
				page = "login.jsp";
			}
		}
		//4. 뷰페이지 이동(redirect, forward) 또는 뷰페이지 출력
		req.getRequestDispatcher(page).forward(req, resp);
		
	}
	
	
}
