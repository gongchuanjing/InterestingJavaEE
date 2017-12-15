package tk.chuanjing.chapter19.ajax.check_username;

import java.io.IOException;
import java.sql.SQLException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class CheckUserNameServletJquery extends HttpServlet {

	private static final long serialVersionUID = 1L;

	public void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		request.setCharacterEncoding("UTF-8");
		response.setContentType("text/html;charset=UTF-8");
		
		String name = request.getParameter("name");
		
		try {
			CheckUserNameService us = new CheckUserNameService();
			CheckUserNameBean user = us.findByUsername(name);
			
			// 判断
			if (user==null) {
				// 用户名可以使用
//				response.getWriter().print("<font color='green'>用户名可用</font>");
				response.getWriter().print("1");
			} else {
				// 用户名已经被占用
				response.getWriter().print("2");
//				response.getWriter().print("<font color='red'>用户名不不不可用</font>");
			}
			
		} catch (SQLException e) {
			e.printStackTrace();
			throw new RuntimeException();
		}
		
		
	}

	public void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		doGet(request, response);
	}

}
