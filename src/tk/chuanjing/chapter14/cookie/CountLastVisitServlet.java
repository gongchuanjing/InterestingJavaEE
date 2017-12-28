package tk.chuanjing.chapter14.cookie;

import java.io.IOException;
import java.sql.Date;

import javax.servlet.ServletException;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import tk.chuanjing.utils.CookieUtils;

/**
 * 
 * 获得浏览器中带过来的所有的Cookie信息,从数组中查找有没有指定名称的Cookie
 * 判断用户是否是第一次访问:(从数组中没有找到指定名称的Cookie)
 * 		如果是第一次:显示欢迎,记录当前访问的时间存入到Cookie中.
 * 		如果不是第一次:显示欢迎,上一次访问时间,同时记录当前访问的时间存入到Cookie中。
 * 
 * @author ChuanJing
 */
public class CountLastVisitServlet extends HttpServlet {

	private static final long serialVersionUID = 1L;

	public void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		
		response.setContentType("text/html;charset=UTF-8");
		
		int count = (Integer) getServletContext().getAttribute("count");
		
		// 获得浏览器带过来的所有的Cookie
		Cookie[] cookies = request.getCookies();
		
		// 从数组中查找指定名称的Cookie
		Cookie findCookie = CookieUtils.findCookie(cookies, "lastVisit");
		
		// 判断是否是第一次
		if (findCookie == null) {
			// 第一次访问
			response.getWriter().println("<h2>欢迎你，你是第" + count + "位访问者！</h2>");
			
		} else {
			// 不是第一次
			long time = Long.parseLong(findCookie.getValue());
			Date date = new Date(time);
			response.getWriter().println("<h2>欢迎你，你是第" + count + "位访问者！你上次访问是"+date.toLocaleString()+"</h2>");
		}
		
		// 创建一个Cookie对象
		Cookie currentCookie = new Cookie("lastVisit", System.currentTimeMillis()+"");
		
		// 设置Cookie的有效路径
//		currentCookie.setPath("/InterestingJavaEE");
		currentCookie.setPath(request.getContextPath());
		
		// 设置Cookie的有效时间
		currentCookie.setMaxAge(60 * 60);
		
		// 保存到浏览器端
		response.addCookie(currentCookie);
		
		response.getWriter().println("<h3><a href='/InterestingJavaEE/jsp/chapter14/cookie/product_list.jsp'>商品列表</a></h3>");
	}

	public void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		doGet(request, response);
	}

}
