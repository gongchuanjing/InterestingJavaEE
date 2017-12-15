package tk.chuanjing.chapter19.ajax.search_word;

import java.io.IOException;
import java.sql.SQLException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * JQ仿百度提示的Servlet
 * @author ChuanJing
 *
 */
public class SearchWordServlet extends HttpServlet {

	private static final long serialVersionUID = 1L;

	public void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		request.setCharacterEncoding("UTF-8");
		response.setContentType("text/html;charset=UTF-8");
		
		try {
			String word = request.getParameter("word");
			
			SearchWordService ss = new SearchWordService();
			List<SearchWord> list = ss.search(word);
			
			request.setAttribute("list", list);
			request.getRequestDispatcher("/jsp/chapter19/searchWordInfo.jsp").forward(request, response);
			
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
