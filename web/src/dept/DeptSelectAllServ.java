package dept;

import java.io.IOException;
import java.util.ArrayList;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import common.Paging;

/**
 * Servlet implementation class DeptSelectAllServ
 */
@WebServlet("/dept/deptSelectAll")
public class DeptSelectAllServ extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public DeptSelectAllServ() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		//page btn value 주고 name=p 로 해서 넘겨야 할 듯.
		DeptDAO dao = new DeptDAO();
		
		//파라미터 받기
		String p = request.getParameter("p");
		String department_name = request.getParameter("department_name");
		//유효성 체크
		int page = 1;
		if(p != null) {
			page = Integer.parseInt(p);
		}
		Paging paging = new Paging();
		paging.setPageSize(3);
		paging.setPageUnit(5);
		paging.setPage(page);
		
		//vo 담기
		DeptVO dept = new DeptVO();
		dept.setFirst(paging.getFirst());
		dept.setLast(paging.getLast());
		dept.setDepartment_name(department_name);
		
		paging.setTotalRecord(dao.count(dept));
		
		//전체조회
		System.out.println("dept 전체 조회 실행");
		ArrayList<DeptVO> list = dao.selectAll(dept);
		request.setAttribute("list", list);
		request.setAttribute("paging", paging);
		request.getRequestDispatcher("deptSelectAll.jsp")
				.forward(request,  response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
