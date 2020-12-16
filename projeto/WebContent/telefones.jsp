<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Cadastro de telefones</title>
<link rel="stylesheet" href="resources/css/cadastro.css">
</head>
<body>
	<a href="acessoliberado.jsp">Início</a>
	<a href="index.jsp">Sair</a>
	<h1>Cadastro de telefones</h1>
	<h3 style="color: red;">${msg}</h3>
	<form action="salvarTelefones" method="post" class="field-long"
		id="formUser" onsubmit="return validarCampos()">
		<ul class="form-style-1">
			<li>
				<table>
					<tr>
						<td>User:</td>
						<td><input type="text" readonly="readonly" id="id" name="id"
							class="field-long" value="${userEscolhido.id}"></td>
							
						<td><input type="text" readonly="readonly" id="nome"
							name="nome" class="field-long" value="${userEscolhido.nome}"></td>
					</tr>
					<tr>
						<td>Numero:</td>
						<td><input type="text" id="numero" name="numero"></td>
						<td><select id="tipo" name="tipo">
						<option>Casa</option>
						<option>Celular</option>
						</select></td>
					</tr>
					<tr>
						<td></td>
						<td><input type="submit" value="Salvar"> 
						
						</td>
					</tr>
				</table>
		</ul>

	</form>
	<div class="container">
		<h2>Usuários cadastrados</h2>
		<table class="responsive-table">
			<thead>
				<tr>
					<th scope="col">Código</th>
					<th scope="col">Número</th>
					<th scope="col">Tipo</th>
					<th scope="col">Excluir</th>
				</tr>
			</thead>
			<c:forEach items="${telefones}" var="fone">
				<tr>

					<td><c:out value="${fone.id}"></c:out></td>
					<td style="width: 150px"><c:out value="${fone.numero}"></c:out></td>
					<td><c:out value="${fone.tipo}"></c:out></td>
					<td><a href="salvarUsuario?acao=delete&user=${fone.id}"><img
							alt="Excluir" title="Excluir" src="resources/img/excluirJSP.png"
							width="20px" height="20px"></a></td>
				</tr>
			</c:forEach>
		</table>
	</div>
	<script type="text/javascript">
		function validarCampos() {
			if (document.getElementById("numero").value == '') {
				alert('Informe o Número');
				return false;
			}
			if (document.getElementById("tipo").value == '') {
				alert('Informe o tipo');
				return false;
			}
		}
		return true;}
	</script>
</body>
</html>