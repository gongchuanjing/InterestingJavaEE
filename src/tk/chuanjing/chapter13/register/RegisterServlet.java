package tk.chuanjing.chapter13.register;

import java.io.IOException;
import java.sql.SQLException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import tk.chuanjing.chapter12.login.User;

public class RegisterServlet extends HttpServlet {

	private static final long serialVersionUID = 1L;

	public void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		// 解决post请求乱码
		request.setCharacterEncoding("UTF-8");
		
		// 告诉浏览器，我服务器给你响应的是文本（text/html）类型的结果，并且你要用UTF-8模式来解析
		response.setContentType("text/html;charset=UTF-8");
		
		try {
			// 1.接收参数
			String username = request.getParameter("username");
			String password = request.getParameter("password");
			String nickname = request.getParameter("nickname");
			String email = request.getParameter("email");
			String sex = request.getParameter("sex");
			String telephone = request.getParameter("telephone");
			String ageStr = request.getParameter("age");
			int age = 0;
			if (ageStr != null && !ageStr.equals("")) {
				age = Integer.parseInt(ageStr);
			}
			
			// 2.封装数据
			User user = new User(null, username, password, nickname, email, sex, age, telephone);
			
			// 3.调用业务层处理数据
			RegisterService userService = new RegisterService();
			boolean suc = userService.regist(user);
			
			// 4.页面跳转
			if (suc) {
				response.sendRedirect(request.getContextPath() + "/html/chapter12/login/login.html");
			} else {
				response.getWriter().print("注册失败！！！");
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}

	public void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		doGet(request, response);
	}

}
