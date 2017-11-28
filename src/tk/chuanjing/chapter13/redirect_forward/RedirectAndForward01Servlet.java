package tk.chuanjing.chapter13.redirect_forward;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class RedirectAndForward01Servlet extends HttpServlet {

	private static final long serialVersionUID = 1L;

	public void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		// 重定向:
//		response.sendRedirect("/InterestingJavaEE/RedirectAndForward02Servlet");
		
		// 转发:
		request.setAttribute("name", "站分");
		request.getRequestDispatcher("/RedirectAndForward02Servlet").forward(request, response);
	}

	public void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		doGet(request, response);
	}

}
