package tk.chuanjing.chapter13.request;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * 使用request解决中文乱码的问题:
 */
public class RequestDemo02Servlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
//		String name = request.getParameter("name");
//		String ss = new String(name.getBytes("ISO-8859-1"),"UTF-8");
		
		String name = new String(request.getParameter("name").getBytes("ISO-8859-1"),"UTF-8");
		System.out.println("GET方式:"+name);
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.setCharacterEncoding("UTF-8");
		String name = request.getParameter("name");
		System.out.println("POST方式:"+name);
	}

}
