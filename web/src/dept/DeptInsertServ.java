package dept;

import java.io.IOException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import member.MemberVO;


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
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
    	//지역정보
    	ArrayList<HashMap<String, String>> locationList = LocationDAO.getInstance().selectAll();
    	
    	request.setAttribute("locationList", locationList);
    	//사원(매니저) 정보
    	
    	List<EmpVO> mgrList = EmpDAO.getInstance().selectAll();
    	
    	request.setAttribute("mgrList", mgrList);
    	
    	
    	request.getRequestDispatcher("deptInsertForm.jsp")
		.forward(request, response);
    }
	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	
	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.setCharacterEncoding("UTF-8");
//		
//		DeptVO deptVO = new DeptVO();
//		deptVO.setDepartment_id( Integer.parseInt(request.getParameter("department_id")) );
//		deptVO.setDepartment_name( request.getParameter("department_name"));
//		dao.insert(deptVO);
		DeptVO deptVO = new DeptVO();
		
		System.out.println("dept �벑濡� �떎�뻾");
		//1.�뙆�씪誘명꽣瑜� VO�뿉 �떞湲�
		deptVO.setDepartment_id( Integer.parseInt(request.getParameter("department_id")) );
		deptVO.setDepartment_name( request.getParameter("department_name"));
		System.out.println(Integer.parseInt("위치번호" + request.getParameter("location_id")));
		System.out.println(Integer.parseInt("매니저번호" + request.getParameter("employee_id")));
		deptVO.setLocation_id(Integer.parseInt(request.getParameter("location_id")));
		deptVO.setManager_id(Integer.parseInt(request.getParameter("employee_id")));
		
		//2.�벑濡� 泥섎━
		DeptDAO dao = new DeptDAO();
		dao.insert(deptVO);
		
		//3.寃곌낵泥섎━(�깮�왂)
		
		//�쟾泥� 議고쉶 �꽌釉붾┸ �샇異�.
		response.sendRedirect("deptSelectAll");
		
	}

}
