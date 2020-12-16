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


    </head>

    <body>

        <div class="container">
            <div class="d-flex justify-content-center">
                <div class="row">
                    <div class="col-md-16 main-section" >
                        <div class="modal-content">
                            <h1><u>Consultar Cliente</u></h1>

                            <c:forEach items="${cliente}" var="cli">


                                <p><h6>Nome:&nbsp;<c:out value="${cli.getNome()}"/></h6></p>
                                <p><h6>RG:&nbsp;<c:out value="${cli.getRg()}"/></h6></p>
                                <p><h6>CPF:&nbsp;<c:out value="${cli.getCpf()}"/></h6></p>
                                <p><h6>Sexo:&nbsp;<c:out value="${cli.getSexo()}"/></h6></p>
                                <p><h6>Telefone:&nbsp;<c:out value="${cli.getTelefone()}"/></h6></p>
                                <p><h6>E-mail:&nbsp;<c:out value="${cli.getEmail()}"/></h6></p>
                                <p><h6>Endereço:&nbsp;<c:out value="${cli.getEndereco()}"/></h6></p>
                                <p><h6>Bairro:&nbsp;<c:out value="${cli.getBairro()}"/></h6></p>
                                <p><h6>Cidade:&nbsp;<c:out value="${cli.getCidade()}"/></h6></p>
                                <p><h6>UF:&nbsp;<c:out value="${cli.getUf()}"/></h6></p>
                                <p><h6>CEP:&nbsp;<c:out value="${cli.getCep()}"/></h6></p>

                                <p>
                                    <a href="${pageContext.request.contextPath}/ConsultarCliente"><input type="button" class="btn btn-dark btn-lg" value="Voltar"></a>&nbsp;&nbsp;&nbsp;
                                    <a href="./ClienteEditar01?id=<c:out value='${cli.getId()}'/>"><input type="button" class="btn btn-success btn-lg" value="Editar"></a>&nbsp;&nbsp;&nbsp;
                                    <a href="./ClienteInativar?id=<c:out value='${cli.getId()}'/>"><input type="button" class="btn btn-danger btn-lg" value="Excluir"></a>

                                </p>
                            </c:forEach>
                        </div>
                    </div>
                </div>
            </div>
        </div>
    </body>
</html>