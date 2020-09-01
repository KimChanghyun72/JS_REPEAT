package member;

import java.io.IOException;
import java.util.ArrayList;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import dept.DeptVO;

/**
 * Servlet implementation class MemberSelectAllServ
 */
@WebServlet("/member/memberSelectAll")
public class MemberSelectAllServ extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public MemberSelectAllServ() {
        super();
        // TODO Auto-generated constructor stub
    }
    
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {	
		//
//		request.getRequestDispatcher("memberAll.jsp")
//				.forward(request, response);
		
		//DB 조회
		MemberDAO dao = new MemberDAO();
		ArrayList<MemberVO> list = dao.selectAll(null);
		
		//결과 저장
		request.setAttribute("list", list);
		
		//뷰페이지로 포워드(이동)
		request.getRequestDispatcher("memberSelectAll.jsp")
				.forward(request,  response);
	}
	
	//등록처리
//	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {	
//		//파라미터를 VO에 담기
//		MemberVO member = new MemberVO();
//		member.setId(request.getParameter("id"));
//		member.setId(request.getParameter("password"));
//		member.setId(request.getParameter("job"));
//		member.setId(request.getParameter("reason"));
//		member.setId(request.getParameter("gender"));
//		member.setId(request.getParameter("mailsend"));
//		//DB 등록 처리
//		MemberDAO dao = new MemberDAO();
//		dao.insert(member);
//		//목록으로 이동
//		response.sendRedirect("memberSelectAll.do");
//	}

}
