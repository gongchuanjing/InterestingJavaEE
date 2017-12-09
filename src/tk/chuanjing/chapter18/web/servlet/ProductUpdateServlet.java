package tk.chuanjing.chapter18.web.servlet;

import java.io.IOException;
import java.util.Date;
import java.util.Map;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.commons.beanutils.BeanUtils;

import tk.chuanjing.chapter18.domain.Product;
import tk.chuanjing.chapter18.service.ProductService;

/**
 * 修改商品的Servlet
 * @author ChuanJing
 *
 */
public class ProductUpdateServlet extends HttpServlet {

	private static final long serialVersionUID = 1L;

	public void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		request.setCharacterEncoding("UTF-8");
		
		try{
			Map<String, String[]> map = request.getParameterMap();
			
			Product product = new Product();
			BeanUtils.populate(product, map);
			product.setPdate(new Date());
			
			ProductService productService = new ProductService();
			productService.update(product);
			
			request.getRequestDispatcher("/ProductFindAllServlet").forward(request, response);
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
