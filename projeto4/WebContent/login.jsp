<jsp:useBean id="calcula" class="br.com.projetojsp.bean.UsuarioBean"
	type="br.com.projetojsp.bean.UsuarioBean" scope="page" />

<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>

<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>

<%@ taglib prefix="myprefix" uri="WEB-INF/testetag.tld"%>

<!DOCTYPE html>
<html lang="en" dir="ltr">
<head>
<meta charset="utf-8">
<title></title>
<link rel="stylesheet" href="resources/css/style.css">
<link rel="stylesheet" href="resources/css/forButton.css">
</head>
<body>
	<div class="login-box">
		<form action="LoginServlet" method="post" class="login-form">
		<h1>Login: Admin Senha: Admin</h1>
			<div class="textbox">
				<i class="fas fa-user"></i> <input type="text"
					placeholder="Username" id="login" name="login" autocomplete="off" /><br>
			</div>


			<div class="textbox">
				<i class="fas fa-lock"></i> <input type="text"
					placeholder="Password" id="senha" name="senha" autocomplete="off"  /><br>
			</div>

			<input type="submit"  class="btn third" value="Sign in">
		</form>
	</div>

</body>
</html>
