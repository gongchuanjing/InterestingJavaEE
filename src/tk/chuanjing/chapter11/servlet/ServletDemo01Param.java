package tk.chuanjing.chapter11.servlet;

import java.io.IOException;
import java.util.Arrays;
import java.util.Map;
import java.util.Set;

import javax.servlet.Servlet;
import javax.servlet.ServletConfig;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;

/**
 * 接收参数的演示
 * @author ChuanJing
 *
 */
public class ServletDemo01Param implements Servlet{

	public void service(ServletRequest req, ServletResponse res)
			throws ServletException, IOException {

		req.setCharacterEncoding("UTF-8");
		res.setContentType("text/html;charset=UTF-8");
		
		// 接收参数:
		String name = req.getParameter("name");
		String age = req.getParameter("age");
		String sex = req.getParameter("sex");
		String city = req.getParameter("city");
		String[] hobby = req.getParameterValues("hobby");
		String info = req.getParameter("info");
		
		System.out.println(name);
		System.out.println(age);
		System.out.println(sex);
		System.out.println(city);
		System.out.println(Arrays.toString(hobby));
		System.out.println(info);
		
		System.out.println("-------下面是getParameterMap--------");
		
		Map<String, String[]> map = req.getParameterMap();
		Set<String> keySet = map.keySet();
		for (String key : keySet) {
			System.out.println(key + " : " + Arrays.toString(map.get(key)));
		}
		
		res.setCharacterEncoding("UTF-8");
		res.getWriter().println("<font color='red' size='7'>提交成功！</font>");
	}
	
	public void init(ServletConfig config) throws ServletException {
	}

	public ServletConfig getServletConfig() {
		return null;
	}

	public String getServletInfo() {
		return null;
	}

	public void destroy() {
	}

}
