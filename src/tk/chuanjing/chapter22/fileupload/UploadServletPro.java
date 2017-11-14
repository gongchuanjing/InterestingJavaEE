package tk.chuanjing.chapter22.fileupload;

import java.io.File;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.commons.fileupload.FileItem;
import org.apache.commons.fileupload.FileUploadBase;
import org.apache.commons.fileupload.FileUploadException;
import org.apache.commons.fileupload.disk.DiskFileItemFactory;
import org.apache.commons.fileupload.servlet.ServletFileUpload;
import org.apache.commons.io.FilenameUtils;

/**
							解决文件上传的问题
1.乱码问题
  1.1普通文本域乱码
     String value=item.getString("UTF-8"); //解决中文乱码问题
  1.2 上传文件名乱码
     request.setCharacterEncoding("UTF-8");  //解决上传文件名称乱码
2.临时文件问题
	当上传的文件大于10kb服务器会缓存读取。但是上传完毕之后该缓存文件不会被清除。所以我们应该把它删除掉。
   item.delete();  //删除临时文件
   
   修改默认的临时目录：
    File tempDir=new File("d:\\temp");
    if(!tempDir.exists()){
    	tempDir.mkdirs();
    }
    diskFileItemFactory.setRepository(tempDir);  //设置缓存目录

3.文件重名问题
 	文件重命名的规则：
           系统的时间日期+系统纳秒级时间+“_”+原始文件名称(包含扩展名)
   
    Date today=new Date();
    SimpleDateFormat format=new SimpleDateFormat("yyyyMMdd");
    String dateString=format.format(today);
    fileName=dateString+System.nanoTime()+"_"+fileName;

4.同目录下文件过多问题
 	分目录存储就可以解决。在这里使用每天产生一个目录形式保存上传文件
    String uploadPath=getServletContext().getRealPath(File.separator+"upload"+File.separator+dateString);
5.目录安全问题
  	把上传文件存储在用户不能直接访问的目录：WEB-INF
     String uploadPath=getServletContext().getRealPath(File.separator+"WEB-INF"+File.separator+"upload"+File.separator+dateString);
6.限制单个文件大小
7.限制总文件的大小
8.限制文件上传类型问题
                判断文件的扩展名称就可以限制
 */
public class UploadServletPro extends HttpServlet {

	public void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		response.setContentType("text/html;charset=UTF-8");
		request.setCharacterEncoding("UTF-8");
		
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
			
			/*
			//设置缓存目录
			File repositoryFile = new File("e:"+File.separator+"temppppp");
			if(!repositoryFile.exists()) {
				repositoryFile.mkdirs();
			}
			dfif.setRepository(repositoryFile);
			*/
			
			// 5.创建上传解析器
			ServletFileUpload servletFileUpload = new ServletFileUpload(dfif);
			
			// 限制单个上传文件的大小 为3m
			servletFileUpload.setFileSizeMax(1024 * 1024 * 3);
			
			// 限制总文件的大小 为5m
			servletFileUpload.setSizeMax(1024 * 1024 * 5);
			
			// 6.使用上传解析器的parseRequest（request）把数据解析为文件项列表
			List<FileItem> items = null;
			try {
				items = servletFileUpload.parseRequest(request);
				
			}/* catch (FileUploadBase.FileSizeLimitExceededException e) {
				response.getWriter().print("限制单个上传文件的大小 为3m");
				return;
				
			} */catch (FileUploadBase.SizeLimitExceededException e) {
				System.out.println("限制总文件上传大小 为5m");
				response.getWriter().print("限制总文件上传大小 为5m");
				return;
				
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
						//String fieldValue = fileItem.getString();
						String fieldValue = fileItem.getString("UTF-8");
						System.out.println("普通字段："+ fieldName +"   "+fieldValue);
					
					} else {
						// 12.否则是文件域，就上传
						
						// 13.获取上传文件的名称
						String fileName = fileItem.getName();
						System.out.println("文件名称："+fileName);
						
						fileName=FilenameUtils.getName(fileName);//获取不包括路径的文件名称
						System.out.println("获取不包括路径的文件名称："+fileName);
						
						
						/*
						//限制文件上传类型问题方式一
		    		    //定义允许上传的文件的扩展名，保存在list中
						String[] allowType = {"jpeg", "png"};
						List<String> allowTypeList = Arrays.asList(allowType);
						
						//获取文件的扩展名称
						String extension = FilenameUtils.getExtension(fileName);
						
						//判断文件的扩展名称是否在允许上传文件列表中，否则不予上传
						if(!allowTypeList.contains(extension)) {
							System.out.println("不被允许的文件类型");
							response.getWriter().print("不被允许的文件类型");
		    		    	//item.delete();
		    		    	return;
						}
						*/
						
						//限制文件上传类型问题方式二
						String contentType = fileItem.getContentType();
						if(!contentType.startsWith("image/")){
							System.out.println("contentType  是  不被允许的文件类型");
							response.getWriter().print("不被允许的文件类型");
		    		    	//item.delete();
		    		    	return;
						}
						
						
						//文件重命名
						Date today = new Date();
						SimpleDateFormat format=new SimpleDateFormat("yyyyMMdd");
		    		    String dateString=format.format(today);
						fileName = dateString + System.nanoTime() + "_" + fileName;
						
						// 14.获取上传文件在服务器上的保存目录
						//String realPath = getServletContext().getRealPath("/fileUploadDir");
						String realPath = getServletContext().getRealPath(File.separator + "WEB-INF" + File.separator + "fileUploadDir" + File.separator + dateString);
						
						//以文件的真实目录创建文件
						File file = new File(realPath);
						
						//判断该文件目录是否存在，如果不存在就创建
						if (!file.exists()) {
							file.mkdirs();
						}
						System.out.println("绝对路径："+file.getAbsolutePath());
						
						// 15.上传就是文件的io操作
						/*
						InputStream is = fileItem.getInputStream();
						OutputStream os = new FileOutputStream(realPath +"/"+ fileName);
						
						int len = -1;
						byte[] b = new byte[1024];
						while( (len=is.read(b) ) != -1) {
							os.write(b, 0, len);
						}
						
						os.close();
						is.close();
						
						fileItem.delete();//删除临时文件
						*/
						
						// 顶替上面几行
						try {
							fileItem.write(new File(realPath +"/"+ fileName));
						} catch (Exception e) {
							e.printStackTrace();
						}
						
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
