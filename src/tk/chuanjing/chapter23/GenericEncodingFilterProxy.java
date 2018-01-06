package tk.chuanjing.chapter23;

import java.io.IOException;
import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;
import java.lang.reflect.Proxy;

import javax.servlet.Filter;
import javax.servlet.FilterChain;
import javax.servlet.FilterConfig;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.http.HttpServletRequest;

/**
 * 动态代理增强  request
 * @author ChuanJing
 *
 */
public class GenericEncodingFilterProxy implements Filter {

	public void init(FilterConfig filterConfig) throws ServletException {
	}

	public void doFilter(ServletRequest request, ServletResponse response,
			FilterChain chain) throws IOException, ServletException {

		final HttpServletRequest req = (HttpServletRequest) request;
		
		// 增强 req
		HttpServletRequest requestProxy = (HttpServletRequest) Proxy.newProxyInstance(
				req.getClass().getClassLoader(),
				req.getClass().getInterfaces(),
				new InvocationHandler() {
//					@Override
					public Object invoke(Object proxy, Method method, Object[] args) throws Throwable {
						if ("getParameter".equals(method.getName())) {
							
							String requestType = req.getMethod();
							if("get".equalsIgnoreCase(requestType)) {
								String value = (String) method.invoke(req, args);
								value = new String(value.getBytes("ISO-8859-1"), "UTF-8");
								return value;
								
							} else if ("post".equalsIgnoreCase(requestType)) {
								req.setCharacterEncoding("UTF-8");
							}
						}
						
						return method.invoke(req, args);
					}
				});
		
		chain.doFilter(requestProxy, response);
	}

	public void destroy() {
	}

}
