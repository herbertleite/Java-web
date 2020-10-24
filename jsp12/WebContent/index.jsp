<jsp:useBean id="calcula" class="bean.BeanCursoJsp" type="bean.BeanCursoJsp" scope="page"/>


<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>

<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>beans jsp</title>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1" />
</head>

	<body >
	<h1> Index</h1>
	<% session.setAttribute("user", "javaavancado"); %>
	<a href="saida.jsp">Ir Para Pagina Saida</a>
	
	
	</body >	
</html>