package board;

import java.io.IOException;
import java.lang.reflect.InvocationTargetException;
import java.util.Arrays;
import java.util.Enumeration;
import java.util.Map;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.commons.beanutils.BeanUtils;

import dept.DeptVO;

/**
 * Servlet implementation class MemberInsertServ
 */
@WebServlet("/board/boardInsert")
public class BoardInsertServ extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public BoardInsertServ() {
        super();
        // TODO Auto-generated constructor stub
    }

    //등록 페이지로 이동
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.getRequestDispatcher("memberInsert.jsp")
				.forward(request, response);
	}

	//등록 처리
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.setCharacterEncoding("UTF-8");
		
		BoardVO boardVO = new BoardVO();

		try {
			BeanUtils.copyProperties(boardVO, request.getParameterMap());
		} catch (IllegalAccessException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (InvocationTargetException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		//DB 등록 처리
		BoardDAO dao = new BoardDAO();
		dao.insert(boardVO);
		
		//전체조회. 차후 생성 예정.
		response.sendRedirect("boardSelectAll");
	}

}
