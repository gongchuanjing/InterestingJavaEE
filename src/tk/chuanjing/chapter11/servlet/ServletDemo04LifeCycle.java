package tk.chuanjing.chapter11.servlet;

import java.io.IOException;

import javax.servlet.Servlet;
import javax.servlet.ServletConfig;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;

/**
 * Servlet的生命周期
 * 
 * @author ChuanJing
 */
public class ServletDemo04LifeCycle implements Servlet{

	/**
	 * Servlet被构造的时候,init方法就会执行.
	 * 何时被创建的:客户第一次访问Servlet.
	 * Servlet被创建了几次.执行一次.说明Servlet是单例的.
	 */
	public void init(ServletConfig config) throws ServletException {
		System.out.println("ServletDemo4被创建了...");
	}
	
	/**
	 * 只要任何一次从客户端向服务器发送的请求，service方法就会执行
	 */
	public void service(ServletRequest req, ServletResponse res)
			throws ServletException, IOException {
		
		System.out.println("Servlet：====" + req.getParameter("name"));
		
		System.out.println("ServletDemo4中的service执行了...");
	}

	/**
	 * Servlet被销毁的时候,destroy方法就会执行.
	 * 何时被销毁的.
	 * 执行了几次.
	 */
	public void destroy() {
		System.out.println("ServletDemo4被销毁了...");
	}

	public ServletConfig getServletConfig() {
		return null;
	}

	public String getServletInfo() {
		return null;
	}
}
