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
import tk.chuanjing.chapter18.utils.UUIDUtils;

/**
 * 	    添加商品的Servlet
   		 * 接收参数:
		 * 封装数据:
		 * 调用业务层:
		 * 页面跳转:
 * 
 * @author ChuanJing
 *
 */
public class ProductAddServlet extends HttpServlet {

	private static final long serialVersionUID = 1L;

	public void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		request.setCharacterEncoding("UTF-8");
		
		try{
			// 判断是否是重复提交
			String token1 = (String) request.getSession().getAttribute("token");
			String token2 = request.getParameter("token");
			// 清空session中的令牌
			request.getSession().removeAttribute("token");
			if (!token2.equals(token1)) {
				request.setAttribute("msg", "你已经提交过一次相同的数据了，不要重复提交！");
				request.getRequestDispatcher("/jsp/chapter18/msg.jsp").forward(request, response);
				return;
			}
			
			Map<String, String[]> map = request.getParameterMap();
			
			Product product = new Product();
			BeanUtils.populate(product, map);
			product.setPdate(new Date());
			product.setPid(UUIDUtils.getUUID());
			
			ProductService productService = new ProductService();
			productService.save(product);
			
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
