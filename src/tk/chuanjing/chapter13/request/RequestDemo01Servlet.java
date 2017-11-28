package tk.chuanjing.chapter13.request;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * 使用request获得客户机的信息
 * @author ChuanJing
 *
 */
public class RequestDemo01Servlet extends HttpServlet {

	public void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		// 获得请求方式：
		String method = request.getMethod();
		System.out.println("请求方式:"+method);
		
		// 获得客户机的IP地址
		String ip = request.getRemoteAddr();
		System.out.println("IP地址:"+ip);
		
		// 获得用户的请求的路径
		String url = request.getRequestURL().toString();
		String uri = request.getRequestURI();
		System.out.println("获得请求的URL:"+url);
		System.out.println("获得请求的URI:"+uri);
		
		// 获得发布的工程名
		String contextPath = request.getContextPath();
		System.out.println("工程名:"+contextPath);
	}

	public void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		doGet(request, response);
	}

}
