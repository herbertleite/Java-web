<jsp:useBean id="calcula" class="br.com.projetojsp.bean.UsuarioBean"
	type="br.com.projetojsp.bean.UsuarioBean" scope="page" />

<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>

<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
	<a href="index.jsp"><img alt="Sair" title="Sair"
		src="resources/img/exit.png" width="30px" height="30px"> </a>
	<div style="padding-top: 10%;">

		<h1 style="text-align: center;">Bem-vindo de volta ${meuNome}!</h1>

		<center>
			<table>
				<tr>
					<td><a href="salvarUsuario?acao=listarTodos"> <img
							src="resources/img/user.png" alt="Cadastrar Usuário"
							title="Cadastrar Usuário" width="100px" height="100px">
					</a></td>
					<td><a href="salvarProduto?acao=listartodos"><img
							width="100px" height="100px" title="Cadastro de Produto"
							alt="Cadastro de Produto" src="resources/img/prod.png"> </a></td>

				</tr>
				<tr>
					<td>Cad. Usuários</td>
					<td>Cad. Produtos</td>
				</tr>
			</table>
		</center>
	</div>
</body>
</html>