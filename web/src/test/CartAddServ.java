package test;

import java.io.IOException;
import java.util.ArrayList;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import javax.websocket.Session;

/**
 * Servlet implementation class CartAddServ
 */
@WebServlet("/text/cartAdd")
public class CartAddServ extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
	int cnt = 0;
    /**
     * @see HttpServlet#HttpServlet()
     */
    public CartAddServ() {
        super();
        // TODO Auto-generated constructor stub
    }
    
    //상품조회
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		req.getRequestDispatcher("goodsList.jsp").forward(req, resp);
	}
	
	
	//장바구니등록
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.setCharacterEncoding("UTF-8");
		
		//세션에서 장바구니 목록 조회
		ArrayList<String> cartList = (ArrayList<String>)request.getSession()
								.getAttribute("cartList");
		
		//cartList 가 null이면 String[] 을 초기화하고 세션에 추가.
		if(cartList == null) {
			cartList = new ArrayList<String>();
			request.getSession().setAttribute("cartList", cartList);
		}
			
		//선택한 상품(parameter)을 cartList에 추가. : getParameter
		cartList.add(request.getParameter("goods"));
		
		//상품 조회  페이지로 이동
			response.sendRedirect("cartAdd");
	}


}
