package tk.chuanjing.chapter19.ajax.province_city;

import java.io.IOException;
import java.sql.SQLException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * 响应XML数据的JQ的案例:查询所有的省份信息显示到注册页面
 * @author ChuanJing
 *
 */
public class ProvinceAndCityGetProvinceServlet extends HttpServlet {
	
	private static final long serialVersionUID = 1L;

	public void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		// 查询所有的省份的信息
		try {
			ProvinceAndCityService ps = new ProvinceAndCityService();
			List<Province> list = ps.findAllProvince();
			
			request.setAttribute("list", list);
			request.getRequestDispatcher("/jsp/chapter19/checkUserNameJquery.jsp").forward(request, response);
			
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
