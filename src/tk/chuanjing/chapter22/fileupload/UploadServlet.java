package tk.chuanjing.chapter22.fileupload;

import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.commons.fileupload.FileItem;
import org.apache.commons.fileupload.FileUploadException;
import org.apache.commons.fileupload.disk.DiskFileItemFactory;
import org.apache.commons.fileupload.servlet.ServletFileUpload;

public class UploadServlet extends HttpServlet {

	public void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		response.setContentType("text/html;charset=UTF-8");
		
		// 1.判断是否是multipart/form-data格式的数据
		boolean isMultipart = ServletFileUpload.isMultipartContent(request);
		
		// 2.如果不是就显示提示信息，结束上传操作
		if (!isMultipart) {
			response.getWriter().print("不是上传类型");
			return;
			
		} else {
			// 3.否则，进行下面的处理
		
			// 4.创建磁盘文件项工厂
			DiskFileItemFactory dfif = new DiskFileItemFactory();
			
			// 5.创建上传解析器
			ServletFileUpload servletFileUpload = new ServletFileUpload(dfif);
			
			// 6.使用上传解析器的parseRequest（request）把数据解析为文件项列表
			List<FileItem> items = null;
			try {
				items = servletFileUpload.parseRequest(request);
			} catch (FileUploadException e) {
				e.printStackTrace();
			}
			
			// 7.判断文件项列表是否为null
			if (items == null || items.size() == 0) {
				// 8.如果为null给出提示，结束上传
				response.getWriter().print("没有东西！！！");
				return;
			} else {
				// 9.否则遍历文件项列表
				for (FileItem fileItem : items) {
					// 10.判断是否是普通表单
					if(fileItem.isFormField()) {
						// 11.如果是普通表单就取得普通表单字段的名称和值
						
						//获取普通表单元素的name的值
						String fieldName = fileItem.getFieldName();
						
						//获取普通表单元素的value的值
						String fieldValue = fileItem.getString();
						System.out.println("普通字段："+ fieldName +"   "+fieldValue);
					
					} else {
						// 12.否则是文件域，就上传
						
						// 13.获取上传文件的名称
						String fileName = fileItem.getName();
						System.out.println("文件名称："+fileName);
						
						// 14.获取上传文件在服务器上的保存目录
						String realPath = getServletContext().getRealPath("/fileUploadDir");
						
						//以文件的真实目录创建文件
						File file = new File(realPath);
						
						//判断该文件目录是否存在，如果不存在就创建
						if (!file.exists()) {
							file.mkdirs();
						}
						System.out.println("绝对路径："+file.getAbsolutePath());
						
						// 15.上传就是文件的io操作
						InputStream is = fileItem.getInputStream();
						OutputStream os = new FileOutputStream(realPath +"/"+ fileName);
						
						int len = -1;
						byte[] b = new byte[1024];
						while( (len=is.read(b) ) != -1) {
							os.write(b, 0, len);
						}
						
						os.close();
						is.close();
					}
				}
			}
		}
	}

	public void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		doGet(request, response);
	}

}
