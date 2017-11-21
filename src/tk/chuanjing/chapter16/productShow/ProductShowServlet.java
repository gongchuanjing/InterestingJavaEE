package tk.chuanjing.chapter16.productShow;

import java.io.IOException;
import java.sql.SQLException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * 商品管理的Servlet
 * @author ChuanJing
 * 
 * 调用业务层处理数据:
 * 显示到页面
 *
 */
public class ProductShowServlet extends HttpServlet {

	private static final long serialVersionUID = 1L;

	public void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		try {
			// 调用业务层
			ProductShowService ps = new ProductShowService();
			List<ProductShow> list = ps.findAll();
			
			request.setAttribute("list", list);
			request.getRequestDispatcher("/jsp/chapter16/productShow.jsp").forward(request, response);
			
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}

	public void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		doGet(request, response);
	}

}
