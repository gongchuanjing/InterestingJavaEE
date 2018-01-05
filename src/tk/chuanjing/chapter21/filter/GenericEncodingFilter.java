package tk.chuanjing.chapter21.filter;

import java.io.IOException;
import java.io.UnsupportedEncodingException;

import javax.servlet.Filter;
import javax.servlet.FilterChain;
import javax.servlet.FilterConfig;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletRequestWrapper;

public class GenericEncodingFilter implements Filter {

	public void init(FilterConfig filterConfig) throws ServletException {
		
	}

	public void doFilter(ServletRequest request, ServletResponse response,
			FilterChain chain) throws IOException, ServletException {
		
//		System.out.println("过滤器ServletRequest：====" + request.getParameter("name"));
//		HttpServletRequest req = (HttpServletRequest) request;
//		System.out.println("过滤器HttpServletRequest：====" + req.getParameter("name"));
//		chain.doFilter(request, response);
		
		HttpServletRequest req = (HttpServletRequest) request;
		MyHttpServletRequestWrapper mhsr = new MyHttpServletRequestWrapper(req);
//		System.out.println("过滤器MyHttpServletRequestWrapper：====" + req.getParameter("name"));
		
		chain.doFilter(mhsr, response);
	}

	public void destroy() {
		
	}

}

/**
 * 增强request的装饰类，只增强了getParameter方法，不全，只是一个小Demo
 * 
 * @author ChuanJing
 */
class MyHttpServletRequestWrapper extends HttpServletRequestWrapper {

	private final HttpServletRequest request;

	public MyHttpServletRequestWrapper(HttpServletRequest request) {
		super(request);
		this.request = request;
	}

	@Override
	public String getParameter(String name) {
		// 根据请求方式不同,去处理
		// 获得请求方式
		String method = request.getMethod();
		if ("get".equalsIgnoreCase(method)) {
			String value = null;
			try {
				value = new String(request.getParameter(name).getBytes("ISO-8859-1"), "UTF-8");
			} catch (UnsupportedEncodingException e) {
				e.printStackTrace();
			}
			return value;
			
		} else if ("post".equalsIgnoreCase(method)) {
			try {
				request.setCharacterEncoding("UTF-8");
			} catch (UnsupportedEncodingException e) {
				e.printStackTrace();
			}
		}
		
		return super.getParameter(name);
	}
}