package tk.chuanjing.chapter14.cookie;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * 清除浏览记录
 * @author ChuanJing
 */
public class ProductBrowseHistoryClearServlet extends HttpServlet {

	private static final long serialVersionUID = 1L;

	public void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		Cookie newCookie = new Cookie("history", null);
		newCookie.setPath(request.getContextPath());
		newCookie.setMaxAge(0);
		response.addCookie(newCookie);
		
		response.sendRedirect(request.getContextPath()+"/jsp/chapter14/cookie/product_list.jsp");
	}

	public void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		doGet(request, response);
	}

}
