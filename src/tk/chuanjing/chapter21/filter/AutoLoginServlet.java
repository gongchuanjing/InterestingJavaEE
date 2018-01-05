package tk.chuanjing.chapter21.filter;

import java.io.IOException;
import java.net.URLEncoder;
import java.sql.SQLException;

import javax.servlet.ServletException;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import tk.chuanjing.chapter12.login.LoginService;
import tk.chuanjing.chapter12.login.User;

/**
 * 自动登录的Servlet
 * @author ChuanJing
 *
 */
public class AutoLoginServlet extends HttpServlet {

	private static final long serialVersionUID = 1L;
	
	public void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		
		// 解决post乱码问题!!!
		request.setCharacterEncoding("UTF-8");
				
		// 解决向页面输出中文的乱码问题!!!
		response.setContentType("text/html;charset=UTF-8");
		
		try {
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
				
				// Session记录已经登录的用户
				request.getSession().setAttribute("existUser", existUser);

				// 自动登录
				String autoLogin = request.getParameter("autoLogin");
				if ("true".equals(autoLogin)) {
					// 自动登录的复选框已经勾选
					
					String autoLoginNow = existUser.getUsername()+"#"+existUser.getPassword();
					// Cookie c = new Cookie("autoLogin", autoLoginNow);
					
					// Cookie中不能存中文，如果有中文需要使用URLEncoder.encode来编码，然后在取出的地方解码
					String autoLoginNowEncode = URLEncoder.encode(autoLoginNow, "UTF-8");
					
					Cookie c = new Cookie("autoLogin", autoLoginNowEncode);
//					c.setPath("/InterestingJavaEE");
					c.setPath(request.getContextPath());
					c.setMaxAge(60 * 60 * 24 * 7);
					response.addCookie(c);
				}
				
				response.sendRedirect("/InterestingJavaEE/index.jsp");
				
			} else {
				response.getWriter().println("登陆失败失败失败！");
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
