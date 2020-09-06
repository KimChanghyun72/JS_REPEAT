package member;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import dept.DeptDAO;
import dept.DeptVO;

/**
 * Servlet implementation class MemberSelectServ
 */
@WebServlet("/member/memberSelect")
public class MemberSelectServ extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public MemberSelectServ() {
        super();
        // TODO Auto-generated constructor stub
    }

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		MemberVO paramVO = new MemberVO();
		String id = request.getParameter("id");
		paramVO.setId(id);
		System.out.println(paramVO.getId());
		//단건조회
		MemberDAO dao = new MemberDAO();
		MemberVO member = dao.selectOne(paramVO);
		//조회결과 request 저장
		request.setAttribute("member", member);
		//view페이지로 이동(forward)
		request.getRequestDispatcher("memberSelect.jsp")
		.forward(request, response);
	
	}

}
