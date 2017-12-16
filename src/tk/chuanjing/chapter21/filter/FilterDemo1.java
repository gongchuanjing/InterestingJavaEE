package tk.chuanjing.chapter21.filter;

import java.io.IOException;
import java.util.Enumeration;

import javax.servlet.Filter;
import javax.servlet.FilterChain;
import javax.servlet.FilterConfig;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;

/**
 * 过滤器入门：
 *  拦截从客户端向服务器发送的请求
 * 	过滤器的生命周期
 * 
 * @author ChuanJing
 */
public class FilterDemo1 implements Filter{

	public void init(FilterConfig filterConfig) throws ServletException {
		System.out.println("FilterDemo1过滤器创建了...");
		
		
		// FilterConfig的使用
		// 获得当前的Filter的名称
		String filterName = filterConfig.getFilterName();
		System.out.println(filterName);
		
		// 获得初始化参数
		String name = filterConfig.getInitParameter("name");
		String password = filterConfig.getInitParameter("password");
		System.out.println(name+"	"+password);
		
		// 获得所有的初始化参数的名称
		Enumeration<String> names = filterConfig.getInitParameterNames();
		while (names.hasMoreElements()) {
			String parameterName = (String) names.nextElement();
			String parameterValue = filterConfig.getInitParameter(parameterName);
			System.out.println(parameterName+"    "+parameterValue);
		}
	}

	public void doFilter(ServletRequest request, ServletResponse response,
			FilterChain chain) throws IOException, ServletException {
		
		System.out.println("FilterDemo1过滤器开始执行...");
		
		// 放行
		chain.doFilter(request, response);
		
		System.out.println("FilterDemo1执行结束...");
	}

	public void destroy() {
		System.out.println("FilterDemo1过滤器销毁了...");
	}

}
