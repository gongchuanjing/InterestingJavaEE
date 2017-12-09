package tk.chuanjing.chapter18.web.servlet;

import java.io.IOException;
import java.sql.SQLException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import tk.chuanjing.chapter18.domain.PageBean;
import tk.chuanjing.chapter18.service.ProductService;

/**
 * 分页查询商品的Servlet
 * @author ChuanJing
 *
 */
public class ProductFindByPageServlet extends HttpServlet {

	private static final long serialVersionUID = 1L;

	public void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		try {
			int currPage = Integer.parseInt(request.getParameter("currPage"));
			
			ProductService productService = new ProductService();
			PageBean pageBean = productService.findByPage(currPage);
			
			request.setAttribute("pageBean", pageBean);
			request.getRequestDispatcher("/jsp/chapter18/product_page.jsp").forward(request, response);
			
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
