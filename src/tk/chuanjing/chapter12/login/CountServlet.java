package tk.chuanjing.chapter12.login;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * 记录访问次数的Servlet
 * 
 * @author ChuanJing
 */
public class CountServlet extends HttpServlet {

	public void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		
		response.setContentType("text/html;charset=UTF-8");
		
		int count = (Integer) getServletContext().getAttribute("count");
		response.getWriter().println("<h2>欢迎你，你是第" + count + "位访问者！</h2>");
	}

	public void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		doGet(request, response);
	}

}
