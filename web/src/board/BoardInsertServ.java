package board;

import java.io.File;
import java.io.IOException;
import java.io.UnsupportedEncodingException;
import java.lang.reflect.InvocationTargetException;
import java.util.Arrays;
import java.util.Enumeration;
import java.util.Map;

import javax.servlet.ServletException;
import javax.servlet.annotation.MultipartConfig;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.Part;

import org.apache.commons.beanutils.BeanUtils;


import dept.DeptVO;

/**
 * Servlet implementation class MemberInsertServ
 */
//파라미터 스트림 값을 바운드리(구분기호)로 잘라서 part배열로 만들어줌.
@MultipartConfig( location = "c:/upload" ,
				  maxRequestSize = 1024*1024*10)
@WebServlet("/board/boardInsert.do")
public class BoardInsertServ extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public BoardInsertServ() {
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
		
		BoardVO boardVO = new BoardVO();

		try {
			BeanUtils.copyProperties(boardVO, request.getParameterMap());
		} catch (IllegalAccessException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (InvocationTargetException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		//첨부파일 처리
		Part part = request.getPart("filename");
		String fileName = getFileName(part);//Long.toString(System.currentTimeMillis());
		String path = request.getServletContext().getRealPath("/images"); //"c:/upload";
		System.out.println(path);
		//if(fileName != null && !fileName.isEmpty()) {
		//파일명 중복체크
			File renameFile = FileRenamePolicy.rename(new File(path, fileName));
			part.write(renameFile.getName());
			boardVO.setFilename(path+"/" + renameFile.getName());
		//}
		
		//DB 등록 처리
		BoardDAO dao = new BoardDAO();
		dao.insert(boardVO);
		
		//전체조회. 차후 생성 예정.
		response.sendRedirect("boardSelectAll");
	}
	
	private String getFileName(Part part) throws UnsupportedEncodingException {
		for (String cd : part.getHeader("Content-Disposition").split(";")) {
		if (cd.trim().startsWith("filename")) {
		return cd.substring(cd.indexOf('=') + 1).trim()
		.replace("\"", "");
		}
		}
		return null;
		}
}
