package tk.chuanjing.chapter14.cookie;

import java.io.IOException;
import java.util.Arrays;
import java.util.LinkedList;

import javax.servlet.ServletException;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import tk.chuanjing.utils.CookieUtils;

/**
 * 记录用户的商品浏览记录的Servlet
 * 
 * * 接收商品id.
 * * 接收从客户端带过来的所有Cookie.
 * * 从Cookie的数组中查找指定名称的Cookie.
 * * 判断是否是第一次浏览商品:
 *     * 第一次浏览商品
 *        * 直接将商品的ID存入到Cookie.
 *        * 将Cookie回写到浏览器.
 *     * 不是第一次浏览商品 1-2
 *        * 判断当前的商品是否已经在浏览记录.
 *            * 已经存在: 2-1 移除当前元素，将当前元素添加到最开始.
 *            * 没在浏览记录中: 
 *                * 判断是否已经超过了最大长度:如果超过 2-1-3:删除最后一个 将当前元素添加到最前面.
 *                * 没有超过:直接将该元素添加到最前位置.
 *        * 将转换的id的值存入到Cookie,回写浏览器.
 */
public class ProductBrowseHistoryServlet extends HttpServlet {

	private static final long serialVersionUID = 1L;

	public void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		// 接收id
		String id = request.getParameter("id");
		
		// 获得所有的Cookie的信息
		Cookie[] cookies = request.getCookies();
		
		// 判断是否是第一次
		Cookie findCookie = CookieUtils.findCookie(cookies, "history");
		if (findCookie == null) {
			// 第一次浏览商品
			Cookie newCookie = new Cookie("history", id);
			newCookie.setPath(request.getContextPath());//newCookie.setPath("/InterestingJavaEE");
			newCookie.setMaxAge(60*60*24*7);
			response.addCookie(newCookie);
		} else {
			// 不是第一次浏览
			// 判断选择的商品是否已经在浏览记录中 2-1
			String historyId = findCookie.getValue();
			String[] historyIds = historyId.split("-");
			
			// 将数组变为集合
			LinkedList<String> historyList = new LinkedList<String>(Arrays.asList(historyIds));
			
			if (historyList.contains(id)) {
				// 之前浏览过该商品
				historyList.remove(id);// 1-2-3
				historyList.addFirst(id);
			} else {
				// 没有浏览过该商品
				if (historyList.size() >= 3) {
					// 超过3个
					historyList.removeLast();
					historyList.addFirst(id);
				} else {
					// 没到3个
					historyList.addFirst(id);
				}
			}
			
			// 将list中的元素取出,使用-连接上保存到Cookie,写回浏览器
			StringBuilder sb = new StringBuilder();
			for (String string : historyList) {
				sb.append(string).append("-");
			}
			String strHistoryIds = sb.toString().substring(0, sb.length()-1);
			System.out.println(strHistoryIds);
			
			// 存入到Cookie中
			Cookie newCookie = new Cookie("history", strHistoryIds);
			newCookie.setPath(request.getContextPath());
			newCookie.setMaxAge(60*60*24*7);
			response.addCookie(newCookie);
		}
		
		request.getRequestDispatcher("/html/chapter14/cookie/product_info.html").forward(request, response);
	}

	public void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		doGet(request, response);
	}

}
