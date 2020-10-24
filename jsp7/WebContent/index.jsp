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
 <!-- redireciona para a pagina e passa o valor -->
	<jsp:forward page="receber-nome.jsp">
	<jsp:param value="site avançado" name="paramfoward"/>
	</jsp:forward>
	
	<myprefix:minhatag/>

</body>
</html>