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
 * 商品的模糊查询的Servlet
 * @author ChuanJing
 *
 */
public class ProductSearchServlet extends HttpServlet {

	private static final long serialVersionUID = 1L;

	public void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		request.setCharacterEncoding("UTF-8");
		
		try {
			String pname = request.getParameter("pname");
			
			ProductService productService = new ProductService();
			List<Product> productList = productService.search(pname);
			
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
