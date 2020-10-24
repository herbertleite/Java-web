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
	<form action="saida.jsp" method="post" >
	    <br/>
	    Nome:<br/>
		<input type="text" id="nome" name="nome"/>
		<br/>
		Ano:<br/>
		<input type="text" id="ano" name="ano" />
		<br/>
		Sexo:<br/>
		<input type="text" id="sexo" name="sexo" />
		<br/>
		Calcula:<br/>
		<input type="text" id="numero" name="numero" />
		<br/>
		<input type="submit"  value="testar" />
		<br/>
	</form>
	
	
	
	</body >	
</html>