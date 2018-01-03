<%@ page language="java" import="java.util.*" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>

<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
  <head>
    <title>商品列表带分页</title>
    
	<meta http-equiv="pragma" content="no-cache">
	<meta http-equiv="cache-control" content="no-cache">
	<meta http-equiv="expires" content="0">    
	<meta http-equiv="keywords" content="keyword1,keyword2,keyword3">
	<meta http-equiv="description" content="This is my page">
	<!--
	<link rel="stylesheet" type="text/css" href="styles.css">
	-->

	<script type="text/javascript" src="${ pageContext.request.contextPath }/js/jquery-1.11.3.min.js"></script>
	<script type="text/javascript">
		function addPage() {
			window.location.href = "${ pageContext.request.contextPath }/jsp/chapter18/addProduct.jsp";
		};
		
		function del(pid) {
			var isDel = window.confirm("确定删除？")
			if(isDel == true) {
				window.location.href = "${ pageContext.request.contextPath }/ProductDeleteServlet?pid="+pid;
			}
		};
		
		$(function() {
			$("#selectAll").click(function() {
				$("input[id='ids']").prop("checked", this.checked);
			});
		});
		
		function delAll(pid) {
			if(window.confirm("确定删除所有选中项？")) {
				document.getElementById("form1").submit();
			}
		};
		
		function search() {
			// 获得表单
			document.getElementById("form1").action = "${ pageContext.request.contextPath }/ProductSearchServlet";
			
			// 表单提交
			document.getElementById("form1").submit();
		};
	</script>
	
  </head>
  
  <body>
  	<div align="center">
	    <h1>商品列表</h1>
	    <form id="form1" action="${ pageContext.request.contextPath }/ProductDeleteAllServlet" method="post">
		    <table border="1" width="80%">
		    	<tr>
		    		<td colspan="8">
		    			名称：<input type="text" id="pname" name="pname" />
		    				  <input type="button" value="查询" onclick="search()"/>&nbsp;&nbsp;&nbsp;&nbsp;
		    				  <input type="button" value="添加" onclick="addPage()"/>&nbsp;&nbsp;&nbsp;&nbsp;
		    				  <input type="button" value="删除" onclick="delAll()"/>&nbsp;&nbsp;&nbsp;&nbsp;
		    		</td>
		    	</tr>
		    	
		    	<tr>
		    		<th>序号</th>
		    		<th><input type="checkbox" id="selectAll"/></th>
					<th>商品名称</th>
					<th>市场价格</th>
					<th>商城价格</th>
					<th>是否热门</th>
					<th>是否下架</th>
					<th>操作</th>
		    	</tr>
		    	
		    	<c:forEach var="p" items="${ pageBean.list }" varStatus="status">
		    		<tr>
		    			<td>${ status.count }</td>
		    			<th><input type="checkbox" id="ids" name="ids" value="${ p.pid }"/></th>
						<td>${ p.pname }</td>
						<td>${ p.market_price }</td>
						<td>${ p.shop_price }</td>
						<td>
							<c:if test="${ p.is_hot == 1 }">
								是
							</c:if>
							<c:if test="${ p.is_hot != 1 }">
								否
							</c:if>
						</td>
						<td>
							<c:if test="${ p.pflag == 1 }">
								已下架
							</c:if>
							<c:if test="${ p.pflag != 1 }">
								未下架
							</c:if>
						</td>
						<td><a href="${ pageContext.request.contextPath }/ProductEditServlet?pid=${ p.pid }">修改</a> | <a href="#" onclick="del('${p.pid}')">删除</a></td>
					</tr>
		    	</c:forEach>
		    	
		    	<tr>
		    		<td colspan="8" align="center">
		    			第${ pageBean.currPage }页，共${ pageBean.totalPage }页&nbsp;&nbsp;&nbsp;&nbsp;
		    			总记录数:${ pageBean.totalCount }&nbsp;&nbsp;&nbsp;&nbsp;
		    			每页显示的记录数:${ pageBean.pageSize }&nbsp;&nbsp;&nbsp;&nbsp;
		    			
		    			<!-- 处理 首页 和 上一页 -->
		    			<c:if test="${ pageBean.currPage != 1 }">
			    			<a href="${ pageContext.request.contextPath }/ProductFindByPageServlet?currPage=1">[首页]</a>&nbsp;&nbsp;
			    			<a href="${ pageContext.request.contextPath }/ProductFindByPageServlet?currPage=${ pageBean.currPage - 1 }">[上一页]</a>&nbsp;&nbsp;
		    			</c:if>
		    			
		    			<!-- 前五后四的写法
		    			<c:forEach var="i" begin="${pageBean.currPage-5 <= 1 ? 1 : pageBean.currPage-5}" end="${pageBean.currPage+4 >= pageBean.totalPage ? pageBean.totalPage : pageBean.currentPage+4}">
		    			-->
		    			<c:forEach var="i" begin="1" end="${ pageBean.totalPage }">
		    				<c:if test="${ pageBean.currPage != i }">
		    					<a href="${ pageContext.request.contextPath }/ProductFindByPageServlet?currPage=${ i }">${ i }</a>&nbsp;&nbsp;
		    				</c:if>
		    				<c:if test="${ pageBean.currPage == i }">
		    					${ i }&nbsp;&nbsp;
		    				</c:if>
		    			</c:forEach>
		    			
		    			<!-- 处理 尾页 和 下一页 -->
		    			<c:if test="${ pageBean.currPage != pageBean.totalPage }">
			    			<a href="${ pageContext.request.contextPath }/ProductFindByPageServlet?currPage=${ pageBean.currPage + 1 }">[下一页]</a>&nbsp;&nbsp;
			    			<a href="${ pageContext.request.contextPath }/ProductFindByPageServlet?currPage=${ pageBean.totalPage }">[尾页]</a>&nbsp;&nbsp;
		    			</c:if>
		    		</td>
		    	</tr>
		    	
		    </table>
		 </form>
	 </div>
  </body>
</html>
