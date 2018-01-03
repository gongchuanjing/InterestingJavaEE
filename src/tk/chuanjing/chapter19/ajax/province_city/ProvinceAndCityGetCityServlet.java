package tk.chuanjing.chapter19.ajax.province_city;

import java.io.IOException;
import java.sql.SQLException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import net.sf.json.JSONArray;
import net.sf.json.JsonConfig;

/**
 * 根据省份的ID查询市的信息 的Servlet
 * @author ChuanJing
 *
 */
public class ProvinceAndCityGetCityServlet extends HttpServlet {

	private static final long serialVersionUID = 1L;

	public void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		response.setContentType("text/html;charset=UTF-8");
		
		try {
			String pid = request.getParameter("pid");
			ProvinceAndCityService ps = new ProvinceAndCityService();
			List<City> list = ps.findCityByPid(pid);
			
			/*    使用XML
			// 将List集合生成XML:
			XStream xStream = new XStream();
			
			// 修改标签名
			xStream.alias("city", City.class);
			
			// 将类中属性作为 标签的属性
			//xStream.useAttributeFor(City.class, "cid");
			//xStream.useAttributeFor(City.class, "cname");
			//xStream.useAttributeFor(City.class, "pid");
			
			String xml = xStream.toXML(list);
			
			response.getWriter().println(xml);
			*/
			
			// 使用JSON
			// 将LIst集合转成JSON
			JsonConfig config = new JsonConfig();
			config.setExcludes(new String[]{"pid"});//不要pid
			
			JSONArray jsonArray = JSONArray.fromObject(list, config);
			// JSONObject.fromObject(object)
			
			System.out.println(jsonArray.toString());
			response.getWriter().println(jsonArray.toString());
			
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
