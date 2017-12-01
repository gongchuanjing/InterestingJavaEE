package tk.chuanjing.chapter17.transaction;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * 转账	练习事务
 * @author ChuanJing
 *
 */
public class AccountServlet extends HttpServlet {

	public void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		request.setCharacterEncoding("UTF-8");
		response.setContentType("text/html;charset=UTF-8");
		
		// 接收参数
		String from = request.getParameter("from");
		String to = request.getParameter("to");
		double money = Double.parseDouble(request.getParameter("money"));
		
		// 处理数据
		AccountService as = new AccountService();
		boolean suc = as.account(from, to, money);
		
		if (suc) {
			response.getWriter().print("转账成功！");
		} else {
			response.getWriter().print("转账失败失败失败！");
		}
	}

	public void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		doGet(request, response);
	}
}
