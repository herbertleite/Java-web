<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Insert title here</title>
</head>
<body>
	<h1>BEM VINDO AO CURSO DE JSP</h1>
	<% out.print("Seu Sucesso Garantido"); %>
	
	<form action="receber-nome.jsp">
	<input type="text" id="nome" name="nome"> 
	<input type="submit" value="Enviar"/>
	</form>
	<%= request.getContextPath() %>
	<%= application.getInitParameter("estado")%>
	
</body>
</html>