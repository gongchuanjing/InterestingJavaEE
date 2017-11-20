<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>

<table>
	    <c:forEach var="w" items="${ list }">
	    	<tr>
	    		<td>${ w.word }</td>
	    	</tr>
	    </c:forEach>
</table>