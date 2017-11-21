package tk.chuanjing.chapter16.model;

import java.io.IOException;
import java.util.Map;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import tk.chuanjing.chapter17.introspector.MyBeanUtils;

public class Model2Servlet extends HttpServlet {

	public void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		/*
		// 接收数据
		String username = request.getParameter("username");
		String password = request.getParameter("password");
		// 封装数据
		UserDay16 u = new UserDay16();
		u.setUsername(username);
		u.setPassword(password);
		*/
		
		Map<String, String[]> map = request.getParameterMap();
		UserChapter16 u = new UserChapter16();
		try {
//			BeanUtils.populate(u, map);
			MyBeanUtils.populate(u, map);
		} catch (Exception e) {
			e.printStackTrace();
		}
		
		System.out.println(u.getUsername());
		System.out.println(u.getPassword());
		
		// 调用另一个类处理数据:
		// 页面跳转到JSP:
	}

	public void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		doGet(request, response);
	}

}
