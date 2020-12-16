<%@taglib prefix="sql" uri="http://java.sun.com/jsp/jstl/sql"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>

<!DOCTYPE html>
<html lang="pt-br">
    <head>


        <meta charset="utf-8"> 

        <link rel="stylesheet" type="text/css" href="${pageContext.request.contextPath}/css/form.css">

        <link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/4.3.1/css/bootstrap.min.css">

        <script src="https://ajax.googleapis.com/ajax/libs/jquery/3.3.1/jquery.min.js"></script>

        <script src="https://cdnjs.cloudflare.com/ajax/libs/popper.js/1.14.7/umd/popper.min.js"></script>

        <script src="https://maxcdn.bootstrapcdn.com/bootstrap/4.3.1/js/bootstrap.min.js"></script>

        <link rel="stylesheet" href="https://use.fontawesome.com/releases/v5.8.1/css/all.css" integrity="sha384-50oBUHEmvpQ+1lW4y57PTFmhCaXp0ML5d60M1M7uH2+nqUivzIebhndOJK28anvf" crossorigin="anonymous">

    </head>

    <body>

        <div class="container">
            <div class="d-flex justify-content-center">
                <div class="row">
                    <div class="col-md-16 main-section" >
                        <div class="modal-content">
                            <h1><u>Consultar Funcionario</u></h1>

                            <c:forEach items="${funcionario}" var="fun">

                                <p><h6>Nome:&nbsp;<c:out value="${fun.getNome()}"/></h6></p>
                                <p><h6> CPF:&nbsp;<c:out value="${fun.getCpf()}"/></h6></p>
                                <p><h6> Telefone:&nbsp;<c:out value="${fun.getTelefone()}"/></h6></p>
                                <p><h6> E-mail:&nbsp;<c:out value="${fun.getEmail()}"/></h6></p>
                                <p><h6> Endereço:&nbsp;<c:out value="${fun.getEndereco()}"/></h6></p>
                                <p><h6> Sexo:&nbsp;<c:out value="${fun.getSexo()}"/></h6></p>
                                <p><h6> UF:&nbsp;<c:out value="${fun.getUf()}"/></h6></p>
                                <p><h6> Cargo:&nbsp;<c:out value="${fun.getCargo()}"/></h6></p>
                                <p><h6> Empresa:&nbsp;<c:out value="${fun.getEmpresa()}"/></h6></p>
                                <p><h6> Usuario:&nbsp;<c:out value="${fun.getLogin()}"/></h6></p>
                                <p><h6> Senha:&nbsp;<c:out value="${fun.getSenha()}"/></h6></p>




                                <p>
                                    &nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;
                                     <a href="${pageContext.request.contextPath}/FuncionarioConsult"><input type="button" class="btn btn-dark btn-lg" value="Voltar"></a>&nbsp;&nbsp;&nbsp;

                                    <a href="${pageContext.request.contextPath}/FuncionarioEditar01?id=<c:out value='${fun.getId()}'/>"><input type="button" class="btn btn-success btn-lg" value="Editar "></a>&nbsp;&nbsp;&nbsp;
                                    <a href="${pageContext.request.contextPath}/FuncionarioInativar?id=<c:out value='${fun.getId()}'/>"><input type="button" class="btn btn-danger btn-lg" value="Excluir"></a>
                                </p>
                                
                            </c:forEach>
                        </div>
                    </div>
                </div>
            </div>
        </div>

    </body>
</html>