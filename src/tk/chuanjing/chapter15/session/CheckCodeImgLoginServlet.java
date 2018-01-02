package tk.chuanjing.chapter15.session;

import java.io.IOException;
import java.sql.SQLException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import tk.chuanjing.chapter12.login.LoginService;
import tk.chuanjing.chapter12.login.User;

/**
 * 登录时需要验证码的Servlet
 * @author ChuanJing
 *
 */
public class CheckCodeImgLoginServlet extends HttpServlet {

	private static final long serialVersionUID = 1L;
	
	public void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		
		// 解决post乱码问题!!!
		request.setCharacterEncoding("UTF-8");
				
		// 解决向页面输出中文的乱码问题!!!
		response.setContentType("text/html;charset=UTF-8");
		
		try {
			// 校验验证码
			String code1 = request.getParameter("code");
			String code2 = (String) request.getSession().getAttribute("code");
			request.getSession().removeAttribute("code");
			if (code2 == null || !code2.equalsIgnoreCase(code1)) {
				// 转发：
				request.setAttribute("msg", "验证码错误！");
				request.getRequestDispatcher("jsp/chapter15/loginCheckCodeImg.jsp").forward(request, response);
				return;
			}
			
			// 1.接收表单提交的参数.
			String username = request.getParameter("username");
			String password = request.getParameter("password");
			
			// 2.封装到实体对象中.
			User user = new User();
			user.setUsername(username);
			user.setPassword(password);
	
			// 3.调用业务层处理数据.
			LoginService userService = new LoginService();
			User existUser = userService.login(user);
			
			// 4.根据处理结果显示信息(页面跳转).
			if (existUser != null) {
				// 登录成功
				response.sendRedirect("/InterestingJavaEE/index.jsp");
				
			} else {
				// 转发：
				request.setAttribute("msg", "账号或者密码不对！！！");
				request.getRequestDispatcher("jsp/chapter15/loginCheckCodeImg.jsp").forward(request, response);
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
