package tk.chuanjing.chapter13.response;

import java.io.IOException;
import java.io.UnsupportedEncodingException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * 向页面做出响应的Servlet
 * @author ChuanJing
 *
 */
public class OutPutAndWriterServlet extends HttpServlet {

	public void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

//		test1(response);
		test2(response);
	}

	/**
	 * 使用字符流输出中文:
	 * * 有没有乱码？为什么？
	 *     * 一定会乱码.response使用的字符流有缓冲区的.
	 *     * response的字符流的缓冲区的默认的编码是ISO-8859-1.编码根本不支持中文.
	 * * 解决:
	 * 	   * 设置response的字符流的缓冲区的编码.
	 *     * 设置浏览器默认打开的时候采用的字符集编码.
	 * @param response
	 * @throws IOException
	 */
	private void test2(HttpServletResponse response) throws IOException {
		// 设置浏览器默认打开的时候采用的字符集编码
		//response.setHeader("Content-Type", "text/html;charset=UTF-8");
		
		// 设置response的字符流的缓冲区的编码
		//response.setCharacterEncoding("UTF-8");
		
		// 这一句顶替上面两句
		response.setContentType("text/html;charset=UTF-8");
		
		response.getWriter().println("你好！");
	}

	/**
	 * 使用字节流输出中文:
	 * * 有没有乱码?为什么?
	 *    * 不一定. 
	 *    * 解决:
	 *       * 设置中文转成字节数组取出的时候的编码
	 *       * 设置浏览器默认打开的时候编码
	 * @param response
	 * @throws UnsupportedEncodingException 
	 * @throws IOException
	 */
	private void test1(HttpServletResponse response) throws UnsupportedEncodingException, IOException {
		// 设置浏览器默认打开的时候采用的字符集编码
		response.setHeader("Content-Type", "text/html;charset=UTF-8");
		
		// 设置中文转成字节数组的时候取出的编码
		response.getOutputStream().write("你好".getBytes("UTF-8"));
	}

	public void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		doGet(request, response);
	}

}
