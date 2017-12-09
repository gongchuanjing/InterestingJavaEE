package tk.chuanjing.chapter18.web.servlet;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import tk.chuanjing.chapter18.service.ProductService;

/**
 * 商品删除的SErvlet
 * @author ChuanJing
 *
 *		 * 接收id
		 * 调用业务层
		 * 页面跳转
 */
public class ProductDeleteServlet extends HttpServlet {

	private static final long serialVersionUID = 1L;

	public void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		
		request.setCharacterEncoding("UTF-8");

		try{
			String pid = request.getParameter("pid");
			ProductService productService = new ProductService();
			productService.delete(pid);
		} catch (Exception e) {
			e.printStackTrace();
			throw new RuntimeException();
		}
		
		request.getRequestDispatcher("/ProductFindAllServlet").forward(request, response);
	}

	public void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		doGet(request, response);
	}

}
