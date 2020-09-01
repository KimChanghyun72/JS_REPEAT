package board;

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
@WebServlet("/board/boardSelect")
public class BoardSelectServ extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public BoardSelectServ() {
        super();
        // TODO Auto-generated constructor stub
    }

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		BoardVO paramVO = new BoardVO();
		int no = Integer.parseInt(request.getParameter("no"));
		
		paramVO.setNo(no);
		//단건조회
		BoardDAO dao = new BoardDAO();
		BoardVO board = dao.selectOne(paramVO);
		//조회결과 request 저장
		request.setAttribute("board", board);
		//view페이지로 이동(forward)
		request.getRequestDispatcher("boardSelect.jsp")
		.forward(request, response);
	
	}

}
