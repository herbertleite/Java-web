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


                            <h1><u>Consultar Produto</u></h1>

                            <c:forEach items="${produto}" var="pro">
                                <p><h6>Código:&nbsp;<c:out value="${pro.getCodigo()}"/></h6></p>
                                <p><h6>Nome:&nbsp;<c:out value="${pro.getNome()}"/></h6></p>
                                <p><h6>Quantidade:&nbsp;<c:out value="${pro.getQuantidade()}"/></h6></p>
                                <p><h6>Categoria:&nbsp;<c:out value="${pro.getCategoria()}"/></h6></p>
                                <p><h6>Marca:&nbsp;<c:out value="${pro.getMarca()}"/></h6></p>
                                <p><h6>Tamanho:&nbsp;<c:out value="${pro.getTamanho()}"/></h6></p>
                                <p><h6>Valor:&nbsp;<c:out value="${pro.getValorUnitario()}"/></h6></p>
                                <p><h6>Descrição:&nbsp;<c:out value="${pro.getDescricao()}"/></h6></p>
                                <p>       
                                    &nbsp;&nbsp;&nbsp;
                                    <a href="${pageContext.request.contextPath}/ConsultarProduto"><input type="button" class="btn btn-dark btn-lg" value="Voltar"></a>&nbsp;&nbsp;&nbsp;
                                    <a href="${pageContext.request.contextPath}/ProdutoEditar01?cod=<c:out value='${pro.getCodigo()}'/>"><input type="button" class="btn btn-success btn-lg" value="Editar"></a>&nbsp;&nbsp;&nbsp;
                                    <a href="${pageContext.request.contextPath}/ProdutoInativar?cod=<c:out value='${pro.getCodigo()}'/>"><input type="button" class="btn btn-danger btn-lg" value="Excluir"></a>

                                </p>
                            </c:forEach>




                        </div>
                    </div>
                </div>
            </div>
        </div>
    </body>
</html>