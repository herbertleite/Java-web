<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Insert title here</title>
</head>
<body>
	<%
		String nome = "Nome recebido " + request.getParameter("nome");
	out.print(nome);
	%>

	<%!int cont = 2;

	public int funcao(int n) {
		return n * 2;
	};%>
	<%=funcao(3)%>

	<%
		response.sendRedirect("http://www.google.com");
	%>

</body>
</html>