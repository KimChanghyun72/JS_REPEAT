package dept;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;


/**
 * Servlet implementation class DeptInsertServ
 */
@WebServlet("/dept/deptInsert")
public class DeptInsertServ extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public DeptInsertServ() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
DeptDAO dao = new DeptDAO();
		
		DeptVO deptVO = new DeptVO();
		deptVO.setDepartment_id( Integer.parseInt(request.getParameter("department_id")) );
		deptVO.setDepartment_name( request.getParameter("department_name"));
		dao.insert(deptVO);
		
		//전체 조회 서블릿 호출.
		response.sendRedirect("deptSelectAll");
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		DeptDAO dao = new DeptDAO();
		
		DeptVO deptVO = new DeptVO();
		deptVO.setDepartment_id( Integer.parseInt(request.getParameter("department_id")) );
		deptVO.setDepartment_name( request.getParameter("department_name"));
		dao.insert(deptVO);
		
	}

}
