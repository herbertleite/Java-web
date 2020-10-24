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
	<h2>cabecalho</h2>
	<br />
	<jsp:getProperty property="nome" name="calcula" />
	<br />
	<jsp:getProperty property="ano" name="calcula" />
	<br />
	<jsp:getProperty property="sexo" name="calcula" />
	<br />
	<jsp:getProperty property="numero" name="calcula" />

	
</body>
</html>