package test;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class CookieAdd
 */
@WebServlet("/text/CookieAdd")
public class CookieAdd extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		response.setContentType("UTF-8");
		//쿠키객체 생성
		Cookie cookie = new Cookie("id", "홍길동");
		cookie.setPath("/");
		//쿠키 유효시간 설정
		cookie.setMaxAge(60*60*24*7);
		
		//쿠키저장
		response.addCookie(cookie);
		
		
		//쿠키객체 생성
				Cookie cookie2 = new Cookie("popupYn", "yes");
				cookie2.setPath("/");
				//쿠키 유효시간 설정
				cookie2.setMaxAge(60*60*24*7);
				
				//쿠키저장
				response.addCookie(cookie2);
				
				response.sendRedirect("cookieSelect.jsp");
	}


}
