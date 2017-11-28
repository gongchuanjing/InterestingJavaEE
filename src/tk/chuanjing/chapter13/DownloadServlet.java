package tk.chuanjing.chapter13;

import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.io.UnsupportedEncodingException;
import java.net.URLEncoder;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import sun.misc.BASE64Encoder;

/**
 * 文件下载的Servlet
 * @author ChuanJing
 *
 */
public class DownloadServlet extends HttpServlet {

	public void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		// 1.接收参数
//		String filename = request.getParameter("filename");
		String filename = new String(request.getParameter("filename").getBytes("ISO-8859-1"), "UTF-8");
		System.out.println(filename);
		
		// 2.完成文件下载:
		// 2.1设置Content-Type头
		response.setHeader("Content-Type", getServletContext().getMimeType(filename));
		
		// 2.3设置文件的InputStream
		InputStream is = getServletContext().getResourceAsStream("/download/"+filename);
		
		// 根据浏览器的类型处理中文文件的乱码问题
		String agent = request.getHeader("User-Agent");
		if (agent.contains("Firefox")) {
			filename = base64EncodeFileName(filename);
		} else {
			filename = URLEncoder.encode(filename, "UTF-8");
		}
		
		// 2.2设置Content-Disposition头
		response.setHeader("Content-Disposition", "attachment;filename="+filename);
		
		// 获得response的输出流:
		OutputStream os = response.getOutputStream();
		
		int len = -1;
		byte[] b = new byte[1024];
		while ((len = is.read(b)) != -1) {
			os.write(b, 0, len);
		}
		is.close();
		
//		request.getRequestDispatcher("/jsp/Demo1.jsp").forward(request, response);
//		response.sendRedirect("/InterestingJavaEE/jsp/Demo1.jsp");
	}
	
	public static String base64EncodeFileName(String fileName) {
		BASE64Encoder base64Encoder = new BASE64Encoder();
		try {
			return "=?UTF-8?B?"
					+ new String(base64Encoder.encode(fileName
							.getBytes("UTF-8"))) + "?=";
		} catch (UnsupportedEncodingException e) {
			e.printStackTrace();
			throw new RuntimeException(e);
		}
	}

	public void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		doGet(request, response);
	}

}
