package tk.chuanjing.chapter18.web.servlet;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import tk.chuanjing.chapter18.domain.Product;
import tk.chuanjing.chapter18.service.ProductService;

/**
 * 商品的编辑的Servlet
 * @author ChuanJing
 *
 *		 * 接收数据:
		 * 调用业务层处理数据:
		 * 页面跳转
 */
public class ProductEditServlet extends HttpServlet {

	private static final long serialVersionUID = 1L;

	public void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		request.setCharacterEncoding("UTF-8");
		
		try{
			String pid = request.getParameter("pid");
			ProductService productService = new ProductService();
			Product product = productService.findById(pid);
			
			request.setAttribute("product", product);
			request.getRequestDispatcher("/jsp/chapter18/editProduct.jsp").forward(request, response);
		} catch (Exception e) {
			e.printStackTrace();
			throw new RuntimeException();
		}
	}

	public void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		doGet(request, response);
	}

}
