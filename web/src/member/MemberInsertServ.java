package member;

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
@WebServlet("/member/memberInsert")
public class MemberInsertServ extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public MemberInsertServ() {
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
		
		MemberVO memberVO = new MemberVO();
//		memberVO.setId(request.getParameter("id"));//( Integer.parseInt(request.getParameter("department_id")) );
//		memberVO.setPassword(request.getParameter("password"));//setDepartment_name( request.getParameter("department_name"));
//		memberVO.setJob(request.getParameter("job"));
//		memberVO.setReason(request.getParameter("reason"));
//		memberVO.setGender(request.getParameter("gender"));
//		memberVO.setMailsend(request.getParameter("mailsend"));

		try {
			BeanUtils.copyProperties(memberVO, request.getParameterMap());
		} catch (IllegalAccessException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (InvocationTargetException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		System.out.println("==============================map==============================");
		Map<String, String[]> map = request.getParameterMap();
		System.out.println(map);
		System.out.println("id= " + map.get("id")[0]);
		
		System.out.println("=============================names============================");
		Enumeration<String> pnames = request.getParameterNames();
		while(pnames.hasMoreElements()) {
			System.out.println(pnames.nextElement());
		}
		//checkbox
		System.out.println("==============================values===============================");
		String strHobby = "";
		String[] hobby = request.getParameterValues("hobby");
		System.out.println(Arrays.toString(hobby)); //[ski, read, ... ] 이걸 바로 memberVO에 넣어줄수도 있음.
		if(hobby !=null) {
			for(String temp : hobby) {
				strHobby += temp + "/";
			}
		}
		memberVO.setHobby(strHobby);
		
		//DB 등록 처리
		MemberDAO dao = new MemberDAO();
		dao.insert(memberVO);
		
		//전체조회. 차후 생성 예정.
		response.sendRedirect("memberSelectAll");
	}

}
