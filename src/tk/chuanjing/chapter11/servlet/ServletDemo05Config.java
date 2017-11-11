package tk.chuanjing.chapter11.servlet;

import java.io.IOException;
import java.util.Enumeration;

import javax.servlet.ServletConfig;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * ServletConfig   ServletContext  对象的使用
 * 
 * @author ChuanJing
 */
public class ServletDemo05Config extends HttpServlet {

	private static final long serialVersionUID = 1L;

	public void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		ServletConfig servletConfig = getServletConfig();
		
		System.out.println(servletConfig.getServletName());
		
		// servletConfig获取 每个servlet自己的初始化参数
		String username = servletConfig.getInitParameter("username");
		String password = servletConfig.getInitParameter("password");
		System.out.println(username + "-----" + password);
		
		Enumeration enumeration = servletConfig.getInitParameterNames();
		while (enumeration.hasMoreElements()) {
			String name = (String) enumeration.nextElement();
			String value = servletConfig.getInitParameter(name);
			System.out.println(name + "~~~~~" + value);
		}
		
		
		// ServletContext获取 web.xml 的初始化参数
		System.out.println("------------------------------------------------");
		String name = getServletContext().getInitParameter("username");
		String pwd = getServletContext().getInitParameter("password");
		System.out.println(name);
		System.out.println(pwd);
	}

	public void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		doGet(request, response);
	}

}
