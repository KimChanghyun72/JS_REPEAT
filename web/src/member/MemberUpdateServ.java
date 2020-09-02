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

/**
 * Servlet implementation class MemberUpdateServ
 */
@WebServlet("/member/memberUpdate")
public class MemberUpdateServ extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    public MemberUpdateServ() {
        super();
    }
    //수정페이지로 이동
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.getRequestDispatcher("memberUpdate.jsp").forward(request, response);
	
	}
	//수정 처리
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
request.setCharacterEncoding("UTF-8");
		
		MemberVO memberVO = new MemberVO();

		try {
			BeanUtils.copyProperties(memberVO, request.getParameterMap());
		} catch (IllegalAccessException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (InvocationTargetException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		//DB 등록 처리
		MemberDAO dao = new MemberDAO();
		dao.update(memberVO);
		
		//전체조회. 차후 생성 예정.
		response.sendRedirect("memberSelectAll");
		
	}

}
