<%@page import="tk.chuanjing.chapter12.login.User"%>
<%@page import="java.util.Map"%>
<%@page import="java.util.HashMap"%>
<%@page import="java.util.List"%>
<%@page import="java.util.ArrayList"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
</head>
<body>
<h1>EL的功能一:获取数据</h1>

<h3>存取是普通的单值数据</h3>
<%
	//pageContext.setAttribute("name", "pValue");
	//request.setAttribute("name", "rValue");
	//session.setAttribute("name", "sValue");
	application.setAttribute("name", "aValue");
%>
<%=pageContext.getAttribute("name") %> <!-- 如果没找到 返回null -->
<%=request.getAttribute("name") %>
<%=session.getAttribute("name") %>
<%=application.getAttribute("name") %>
<hr/>
${ pageScope.name } <!-- 返回的是"" -->
${ requestScope.name }
${ sessionScope.name }
${ applicationScope.name }
<hr/>
${ name } <!-- 类似findAttribute("name") 先从page域中查找,没找到去request域中查询,没有找到去session域中找，没有找到就去application域中找 -->

<h3>获取数组的数据</h3>
<%
	String[] arrs = {"李旭华","李冠希","杨凤","杨如花"};
	pageContext.setAttribute("arrs", arrs);
%>
${ arrs[0] }
${ arrs[1] }
${ arrs[2] }
${ arrs[3] }

<h3>获取List集合的数据</h3>
<%
	List<String> list = new ArrayList<String>();
	list.add("李芙蓉");
	list.add("杨芙蓉");
	list.add("王凤");
	pageContext.setAttribute("list", list);
%>
${ list[0] }
${ list[1] }
${ list[2] }

<h3>获取Map集合的数据</h3>
<%
	Map<String,String> map = new HashMap<String,String>();
	map.put("aaa","李旭华");
	map.put("bbb","杨久君");
	map.put("ccc","李芮");
	map.put("ddd.eee","李凤");
	pageContext.setAttribute("map", map);
%>
${ map.aaa }
${ map.bbb }
${ map.ccc }
${ map["ddd.eee"] }

<h3>获取对象的数据</h3>
<%
	User user = new User();
	user.setId(2);
	user.setUsername("111");
	user.setPassword("222");
	pageContext.setAttribute("user", user);
%>
${ user.id }
${ user.username }
${ user.password }

<h3>获取对象的集合的数据</h3>
<%
	User user1 = new User(1,"aaa","123","aaa","123","aaa", 23, "123");
	User user2 = new User(2,"bbb","123","aaa","123","aaa", 23, "123");
	User user3 = new User(3,"ccc","123","aaa","123","aaa", 23, "123");
	
	List<User> userList = new ArrayList<User>();
	userList.add(user1);
	userList.add(user2);
	userList.add(user3);
	
	pageContext.setAttribute("userList", userList);
%>
${ userList[0].id } - ${ userList[0].username } - ${ userList[0].password }<br/>
${ userList[1].id } - ${ userList[1].username } - ${ userList[1].password }<br/>
${ userList[2].id } - ${ userList[2].username } - ${ userList[2].password }<br/>

</body>
</html>