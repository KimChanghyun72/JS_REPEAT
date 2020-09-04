package common;

import java.io.IOException;

import javax.servlet.Filter;
import javax.servlet.FilterChain;
import javax.servlet.FilterConfig;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.annotation.WebFilter;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
@WebFilter(filterName = "second")//, urlPatterns = "/dept/*"
public class SecondFilter implements Filter {

	public void destroy() {
		// TODO Auto-generated method stub
		
	}

	public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain)
			throws IOException, ServletException {
		System.out.println("second filter 실행");
		//로그인 여부
		String uri=((HttpServletRequest)request).getRequestURI();
		//if(uri.indexOf("login")<0) {
			HttpSession session = ((HttpServletRequest)request).getSession();
			//String contextPath = ((HttpServletRequest)request).getContextPath();
			if( session.getAttribute("id")==null ) {
				((HttpServletResponse)response).sendRedirect("/web/member/login.jsp");
			//}
			//return;
		}
		//chain.doFilter(request, response);
		System.out.println("second filter 실행 종료");
	}

	public void init(FilterConfig filterConfig) throws ServletException {
		// TODO Auto-generated method stub
		
	}
	
}
