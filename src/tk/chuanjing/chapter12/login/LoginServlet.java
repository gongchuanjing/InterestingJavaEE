package tk.chuanjing.chapter12.login;

import java.io.IOException;
import java.sql.SQLException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * 登陆的Servlet
 * @author ChuanJing
 *
 */
public class LoginServlet extends HttpServlet {

	private static final long serialVersionUID = 1L;
	
	@Override
	public void init() throws ServletException {
		// 初始化一个变量count的值为0.
		int count = 0;
		
		// 将这个值存入到ServletContext中.
		getServletContext().setAttribute("count", count);
	}

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
				
				// 记录次数
				int count = (Integer) getServletContext().getAttribute("count");
				count++;
				getServletContext().setAttribute("count", count);
				
				/*
				登陆成功，5秒后跳转
				response.getWriter().println("<font size='7' color='red'>登陆成功,5秒后跳转！<font>");
				response.setHeader("Refresh", "5;url=/InterestingJavaEE/index.jsp");
				*/
				
				// 重定向，到成功的页面，然后5秒后跳转到首页，在成功页面有JS控制读秒效果
//				response.setStatus(302);
//				response.setHeader("Location", "/InterestingJavaEE/html/chapter12/login/loginSuc.html");
				response.sendRedirect("/InterestingJavaEE/html/chapter12/login/loginSuc.html");//顶上面两句
				
			} else {
				// 登录失败
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
