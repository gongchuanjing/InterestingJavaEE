package tk.chuanjing.chapter13;

import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.util.Enumeration;
import java.util.Properties;

import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * 读取WEB工程文件的Servlet
 * @author ChuanJing
 *
 */
public class ServletContextDemo extends HttpServlet {

	private static final long serialVersionUID = 1L;

	public void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

//		test1();
//		test2();
		test3();
		test4();
	}
	
	public void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		doGet(request, response);
	}
	
	/**
	 * 获得文件的MIME的类型
	 */
	private void test4() {
		ServletContext servletContext = getServletContext();
		String mimeType = servletContext.getMimeType("1.html");
		System.out.println(mimeType);
	}
	
	/**
	 * 读取全局初始化参数
	 */
	private void test3() {
		ServletContext servletContext = getServletContext();
		
		String username = servletContext.getInitParameter("username");
		String password = servletContext.getInitParameter("password");
		System.out.println(username+"-----"+password);
		
		Enumeration<String> names = servletContext.getInitParameterNames();
		while (names.hasMoreElements()) {
			String name = (String) names.nextElement();
			String value = servletContext.getInitParameter(name);
			System.out.println(name+"....."+value);
		}
	}
	
	/**
	 * 使用ServletContext中的getRealPath读取
	 * @throws IOException
	 */
	private void test2() throws IOException {
		// 获得该文件的磁盘绝对路径
		String realPath = getServletContext().getRealPath("/WEB-INF/classes/db.properties");
		System.out.println("要读取文件的据对路径：" + realPath);
		
		InputStream is = new FileInputStream(realPath);
		Properties p = new Properties();
		p.load(is);
		
		String driverClass = p.getProperty("driverClass");
		String url = p.getProperty("url");
		String username = p.getProperty("username");
		String password = p.getProperty("password");
		
		System.out.println(driverClass);
		System.out.println(url);
		System.out.println(username);
		System.out.println(password);
	}

	/**
	 * 使用ServletContext中的getResourceAsStream读取
	 * @throws IOException
	 */
	private void test1() throws IOException {
		InputStream is = getServletContext().getResourceAsStream("/WEB-INF/classes/db.properties");
		Properties p = new Properties();
		p.load(is);
		
		String driverClass = p.getProperty("driverClass");
		String url = p.getProperty("url");
		String username = p.getProperty("username");
		String password = p.getProperty("password");
		
		System.out.println(driverClass);
		System.out.println(url);
		System.out.println(username);
		System.out.println(password);
	}

}
