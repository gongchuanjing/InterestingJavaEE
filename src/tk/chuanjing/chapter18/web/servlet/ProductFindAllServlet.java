package tk.chuanjing.chapter18.web.servlet;

import java.io.IOException;
import java.sql.SQLException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import tk.chuanjing.chapter18.domain.Product;
import tk.chuanjing.chapter18.service.ProductService;

/**
 * 查询所有商品的Servlet
 * 
 * 1、调用业务层
 * 2、页面跳转
 * @author ChuanJing
 *
 */
public class ProductFindAllServlet extends HttpServlet {

	private static final long serialVersionUID = 1L;

	public void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		
		try {
			ProductService productService = new ProductService();
			List<Product> productList = productService.findAll();
			
			request.setAttribute("productList", productList);
			request.getRequestDispatcher("/jsp/chapter18/product_list.jsp").forward(request, response);
			
		} catch (SQLException e) {
			e.printStackTrace();
			throw new RuntimeException();
		}
	}

	public void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		doGet(request, response);
	}

}
