package tk.chuanjing.chapter19.ajax;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * AJAX的入门的Servlet，演示get和post
 * @author ChuanJing
 *
 */
public class AjaxGetPostDemoServlet extends HttpServlet {

	private static final long serialVersionUID = 1L;

	public void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		response.setContentType("text/html;charset=UTF-8");
		request.setCharacterEncoding("UTF-8");
		
		String name = new String(request.getParameter("name").getBytes("ISO-8859-1"), "UTF-8");
		String pass = request.getParameter("pass");
		
		System.out.println(name);
		System.out.println(pass);
		
		response.getWriter().print(name+"              "+pass);
	}

	public void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
//		doGet(request, response);
		
		response.setContentType("text/html;charset=UTF-8");
		request.setCharacterEncoding("UTF-8");
		
		String name = request.getParameter("name");
		String pass = request.getParameter("pass");
		
		System.out.println(name);
		System.out.println(pass);
		
		response.getWriter().print(name+"              "+pass);
	}

}
