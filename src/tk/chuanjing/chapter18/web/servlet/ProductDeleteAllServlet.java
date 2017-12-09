package tk.chuanjing.chapter18.web.servlet;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import tk.chuanjing.chapter18.service.ProductService;

/**
 * 删除多个商品的Servlet
 * @author ChuanJing
 *
 */
public class ProductDeleteAllServlet extends HttpServlet {

	private static final long serialVersionUID = 1L;

	public void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		request.setCharacterEncoding("UTF-8");

		// 接收数组
		String[] ids = request.getParameterValues("ids");
		if (ids == null || ids.length == 0) {
			request.setAttribute("msg", "你没有选中任何删除项！");
			request.getRequestDispatcher("/jsp/chapter18/msg.jsp").forward(request, response);
			return;
		}
		
		// 调用业务层
		ProductService productService = new ProductService();
		productService.deleteAll(ids);
		
		// 页面跳转
		request.getRequestDispatcher("/ProductFindAllServlet").forward(request, response);
	}

	public void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		doGet(request, response);
	}

}
