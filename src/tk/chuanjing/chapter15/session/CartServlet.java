package tk.chuanjing.chapter15.session;

import java.io.IOException;
import java.util.LinkedHashMap;
import java.util.Map;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * 购物车的Servlet
 * 
 * @author ChuanJing
 */
public class CartServlet extends HttpServlet {

	private static final long serialVersionUID = 1L;

	public void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		// 接收商品名称
		String name = new String(request.getParameter("name").getBytes("ISO-8859-1"), "UTF-8");
		
		// 创建Map集合用于保存购物信息.Map<String,Integer> Map的key是商品的名称 value是购买的数量.
		Map<String, Integer> map = (Map<String, Integer>) request.getSession().getAttribute("cart");
		if (map == null) {
			map = new LinkedHashMap<String, Integer>();
		}
		
		// 判断购物车中是否已经买了该商品
		if (map.containsKey(name)) {
			// map中已经有该商品:如果购物车中已经有该商品: 获得到Map中该商品的数量+1。 存回到Map集合中.
			Integer count = map.get(name);
			count++;
			map.put(name, count);
		} else {
			// map中没有该商品.如果购物车中没有改商品: 将商品添加到Map集合中 数量1.
			map.put(name, 1);
		}
		
		// * 将Map集合保存到session中.
		request.getSession().setAttribute("cart", map);

		response.setContentType("text/html;charset=UTF-8");
		response.getWriter().print("<h3><a href='/InterestingJavaEE/jsp/chapter15/product_list.jsp'>继续浏览</a> | <a href='/InterestingJavaEE/jsp/chapter15/cart.jsp'>去购物车</a></h3>");
	}

	public void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		doGet(request, response);
	}

}