package test;

import java.io.IOException;

import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet("/test/ServletContextTestServ")
public class ServletContextTestServ extends HttpServlet {
	private static final long serialVersionUID = 1L;

	public ServletContextTestServ() {
		super();
	}
	//서블릿과 서버에 대한 정보를 가져옴. 
	protected void doGet(HttpServletRequest request, HttpServletResponse response)throws ServletException, IOException {
		ServletContext application = this.getServletContext();
		//
		response.setContentType("text/html; charset=UTF-8"); 
		response.getWriter()
			.append("서블릿 버전 : " + application.getMajorVersion()
								+ "." + application.getMinorVersion())
			.append("<br>서버정보 : " + application.getServerInfo())
			.append("<br>컨텍스트(=어플리케이션) 경로 : " + application.getContextPath())
			.append("<br>실제 경로 : " + application.getRealPath("/member/memberInsert.jsp"));
	
		
	}

}
