package dept;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class EmpInsertServ
 */
@WebServlet("/dept/empInsert")
public class EmpInsertServ extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#HttpServlet()
	 */
	public EmpInsertServ() {
		super();
		// TODO Auto-generated constructor stub
	}

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		ArrayList<DeptVO> deptList = new ArrayList<DeptVO>();
		DeptDAO dao = new DeptDAO();

		deptList = dao.selectAll(null);
		request.setAttribute("deptList", deptList);

		List<JobVO> jobList = JobDAO.getInstance().selectAll();
		request.setAttribute("jobList", jobList);

		List<EmpVO> mgrList = EmpDAO.getInstance().selectAll();
		request.setAttribute("mgrList", mgrList);

		request.getRequestDispatcher("employeeInsert.jsp").forward(request, response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		EmpVO empVO = new EmpVO();
		empVO.setEmployee_id(request.getParameter("employeeId"));
		empVO.setFirst_name(request.getParameter("firstName"));
		empVO.setLast_name(request.getParameter("lastName"));
		empVO.setEmail(request.getParameter("email"));
		empVO.setHire_date(request.getParameter("hireDate"));
		empVO.setDepartment_id(request.getParameter("deptId"));
		empVO.setJob_id(request.getParameter("jobId"));
		empVO.setManager_id("manager_id");

		EmpDAO dao = new EmpDAO();
		dao.insert(empVO);
		
		response.sendRedirect("empSelectAll");
	}

}
