<%@ page language="java" import="java.util.*" pageEncoding="utf-8"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<base href="<%=basePath%>">
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
</head>
<body>
<table border="1">
	<tr>
		<th>id</th>
		<th>name</th>
		<th>password</th>
		<th>salt</th>
		<th>empId</th>
	</tr>
	<c:forEach items="${userAll}" var="item">
		<tr>
			<td>${item.id}</td>
			<td>${item.username}</td>
			<td>${item.password}</td>
			<td>${item.salt}</td>
			<td>${item.empId}</td>
		</tr>
	</c:forEach>
</table>
</body>
</html>