<jsp:useBean id="calcula" class="beans.BeanJsp" type="beans.BeanJsp" scope="page"></jsp:useBean>

<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
	
	<%@taglib prefix ="myprefix" uri="WEB-INF/testetag.tld" %>
	
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Insert title here</title>
</head>
<body>

 <h1>Index</h1>
	<%= calcula.calcula(50) %>
</body>
</html>