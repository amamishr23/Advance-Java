<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@ taglib prefix = "c" uri = "http://java.sun.com/jsp/jstl/core" %>

<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Product List</title>
</head>
<body>
	<h1>Product List JSP page!!!</h1>
	<table border="1">
		<tr>
			<th>ID</th><th>Name</th><th>Price</th>
		</tr>
		<!--  dynamic content -->
		<c:forEach items="${products}" var="p">
			<tr>
				<td>${p.id}</td>
				<td>${p.name}</td>
				<td>${p.price}</td>
			</tr>
		</c:forEach>
	</table>
</body>
</html>