<%@ page language="java" import="java.util.*" 
	contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/functions" prefix="fn" %>

<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
  <head>
    <title>JSTL</title>
	<meta http-equiv="pragma" content="no-cache">
	<meta http-equiv="cache-control" content="no-cache">
	<meta http-equiv="expires" content="0">    
	<meta http-equiv="keywords" content="keyword1,keyword2,keyword3">
	<meta http-equiv="description" content="This is my page">
  </head>
  
  <body>
    <c:set var="n1" value="10" scope="page"></c:set>
    <c:set var="n2" value="20" scope="page"></c:set>
    <c:if test="${ n1 < n2 }">
    	是的，n1小于n2
    </c:if>
    
    <c:if test="${ n1 < n2 }" var="flag" scope="page">
    	是的，n1小于n2
    </c:if>
    <c:if test="${ n1 >= n2 }">
		n1 大于等于 n2
	</c:if>
    <c:if test="flag">
    	是的，n1小于n2
    </c:if>
    
    
    
    <h1>JSTL的常用的标签一</h1>
    <c:set var="i" value="张三" scope="page"></c:set>
    ${ i }
    <c:out value="${ i }" default="李四"></c:out>
    <c:out value="<h2>标题二</h2>" escapeXml="false"></c:out>
    
    
    <h1>JSTL常用标签:forEach</h1>
    <%
    	String[] arrs = {"aaa","bbb","ccc"};
    	pageContext.setAttribute("arrs", arrs);
    	
    	List<String> list = new ArrayList<String>();
    	list.add("zzz");
    	list.add("yyy");
    	list.add("xxx");
    	pageContext.setAttribute("list", list);
    	
    	Map<String,String> map = new HashMap<String,String>();
    	map.put("aaa","李旭华");
    	map.put("bbb","李冠希");
    	map.put("ccc","董阳阳");
    	pageContext.setAttribute("map", map);
    %>
    
    <h3>遍历数组</h3>
    <c:forEach var="i" items="${ arrs }">
    	${ i }
    </c:forEach>
    
    
    <h3>遍历List集合</h3>
    <c:forEach var="i" items="${ list }">
    	${ i }
    </c:forEach>
    
    
    <h3>遍历Map集合</h3>
    <c:forEach var="en" items="${ map }">
    	${ en.key } - ${ en.value }
    </c:forEach>
    
    
    <h3>遍历从1到10,每次间隔2</h3>
    <c:forEach var="i" begin="1" end="10" step="2">
    	${ i }
    </c:forEach>
    
    
    <h3>遍历从100到300</h3>
    <c:forEach var="i" begin="100" end="300" step="5" varStatus="sta">
    	<c:if test="${ sta.count % 3 == 0 }">
    		<font color="red">${ i }</font>
    	</c:if>
    	
    	<c:if test="${ sta.count % 3 != 0 }">
    		<font color="green">${ i }</font>
    	</c:if>
    </c:forEach>
    
    
    <h1>JSTL提供的EL的函数库</h1>
    ${ fn:contains("Hello Word","Hello") }
    ${ fn:length("HelloWord") }
    ${ fn:toLowerCase("ABCDE") }
    ${ fn:split("a-c-d-d","-") }
    
    <c:forEach var="i" items='${ fn:split("a-c-d-d","-") }'>
    	${ i }
    </c:forEach>
    
  </body>
</html>
