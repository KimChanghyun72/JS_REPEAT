package dept;

import java.awt.List;
import java.io.IOException;
import java.util.ArrayList;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class EmpUpdateServ
 */
@WebServlet("/dept/empUpdate.do")
public class EmpUpdateServ extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public EmpUpdateServ() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		//사번으로 단건조회
		System.out.println(request);
		EmpVO empVO = new EmpVO();
		String employee_id = request.getParameter("employee_id");
		empVO.setEmployee_id(employee_id);
		
		EmpDAO dao = new EmpDAO();
		EmpVO emp = dao.selectOne(empVO);
		
		//jobList조회
		JobDAO jobDAO = new JobDAO();
		ArrayList<JobVO> jobList = (ArrayList<JobVO>)jobDAO.selectAll();
		//departmentList조회
		DeptDAO deptDAO = new DeptDAO();
		ArrayList<DeptVO> deptList = (ArrayList<DeptVO>)deptDAO.selectAll(null);
		//사원리스트
		
		//request에 저장
		request.setAttribute("emp", emp);
		request.setAttribute("jobList", jobList);
		request.setAttribute("deptList", deptList);
		
		request.getRequestDispatcher("empUpdate.jsp").forward(request, response);
	
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

		System.out.println("post in empUpdateServ start");
		EmpVO empVO = new EmpVO();
		
		empVO.setJob_id(request.getParameter("jobList"));
		empVO.setEmail(request.getParameter("email"));
		empVO.setHire_date(request.getParameter("hireDate"));
		empVO.setLast_name(request.getParameter("lastName"));
		empVO.setEmployee_id(request.getParameter("employee_id"));
		
		EmpDAO dao = new EmpDAO();
		
		dao.update(empVO);
		
		response.sendRedirect("empSelectAll");
	}

}
