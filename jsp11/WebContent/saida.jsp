<jsp:useBean id="calcula" class="bean.BeanCursoJsp"
	type="bean.BeanCursoJsp" scope="page" />


<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>

<!DOCTYPE html>
<head>
<meta charset="UTF-8">
<title>beans jsp</title>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1" />
</head>
<html>

<body>
	<jsp:setProperty property="*" name="calcula" />
	<h2>Saida</h2>
 	Nome: ${param.nome}
 	<br />
 	Ano: ${param.ano}
	
</body>
</html>