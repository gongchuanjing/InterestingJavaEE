<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"
	contentType="text/html; charset=UTF-8"
%>

<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
  <head>
    <title>My JSP starting page</title>
    
	<meta http-equiv="pragma" content="no-cache">
	<meta http-equiv="cache-control" content="no-cache">
	<meta http-equiv="expires" content="0">    
	<meta http-equiv="keywords" content="keyword1,keyword2,keyword3">
	<meta http-equiv="description" content="This is my page">
	<!--
	<link rel="stylesheet" type="text/css" href="styles.css">
	-->

  </head>
  
  <body>
    <%
    	pageContext.setAttribute("name", "张三");
    
    	String[] arr = {"哈哈","嘿嘿","嘻嘻"};
    	pageContext.setAttribute("arr", arr);
    	
    	Map<String,String> map = new HashMap();
    	map.put("aaa", "111");
    	map.put("bbb", "222");
    	map.put("ccc.ddd", "333");
    	pageContext.setAttribute("m", map);
    	
    	pageContext.setAttribute("n1", "10");
    	pageContext.setAttribute("n2", "20");
    	
    %>
    
    ${ name }
    ${ pageScope.name }	<br/>
    
    ${ arr[0] }
    ${ arr[1] }
    ${arr[2]}			<br/>
    
    ${ m.aaa }
    ${ m.bbb }
    ${ m["ccc.ddd"] }	<br/>
    
    ${ n1 < n2 }		<br/>
    ${ n1 + n2 }		<br/>
    ${ n1 < n2 ? "是的" : "NO" }<br/>
    
    
    
    <!-- 
		pageScope,requestScope,sessionScope,applicationScope - 获取JSP中域中的数据
		param,paramValues 	- 接收参数.
		header,headerValues - 获取请求头信息
		initParam			- 获取全局初始化参数
		cookie				- WEB开发中cookie
		pageContext			- WEB开发中的pageContext.
	 -->
    <h3>接收请求的参数</h3>
    <!-- http://127.0.0.1:8080/InterestingJavaEE/jsp/day16_demo2-el/day16demo.jsp?name=张三&pwd=123&hobby=nanqiu&hobby=足球 -->
    <%= new String(request.getParameter("name").getBytes("ISO-8859-1"), "UTF-8") %>
    <%= request.getParameter("pwd") %>
    <%= Arrays.toString(request.getParameterValues("hobby")) %>
    <hr/>
    
    ${ param.name }
    <!-- ${ new String(param.name.getBytes("ISO-8859-1"), "UTF-8") } -->
    ${ param.pwd }
    ${ paramValues.hobby }
    ${ paramValues.hobby[0] }
    ${ paramValues.hobby[1] }
    
    <h3>获取请求头</h3>
    <%=request.getHeader("User-Agent") %>	<br/>
    ${ header["User-Agent"] }
    
    <h3>获取全局初始化参数</h3>
    ${ initParam.username }
    
    <h3>获取Cookie中的值</h3>
	${ cookie.history.value }
	
	
	
  </body>
</html>
