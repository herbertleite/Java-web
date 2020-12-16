<%-- 
    Document   : produtos
    Created on : Apr 28, 2016, 9:01:25 AM
    Author     : ngoncalves
--%>

<%@page import="java.text.NumberFormat"%>
<%@page import="java.util.List"%>
<%@page import="modelo.Produto"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Gerenciar Produtos</title>
        <link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.6/css/bootstrap.min.css" integrity="sha384-1q8mTJOASx8j1Au+a5WDVnPi2lkFfwwEAa8hDDdjZlpLegxhjVME1fgjWPGmkzs7" crossorigin="anonymous">
        <link rel="stylesheet" href="css/estilo.css">
    </head>
    <body>
        <h1>Produtos</h1>

        <br>

        <div id="conteudo">
            <table class="table table-striped">
                <thead>
                    <tr>
                        <th>Cod</th>
                        <th>Descrição</th>
                        <th>Preço</th>
                        <th style="width: 10%">Abrir</th>
                        <th style="width: 10%">Editar</th>
                        <th style="width: 10%">Apagar</th>
                    </tr>
                </thead>
                <tbody>
                    <%
                        List<Produto> listaProdutos = null;
                        if ((listaProdutos = (List<Produto>) request.getAttribute("listaProdutos")) != null) {
                            NumberFormat formatadorPreco = NumberFormat.getCurrencyInstance();
                            for (Produto produto : listaProdutos) {
                    %>
                                <tr>
                                    <td><%=produto.getId()%></td>
                                    <td><%=produto.getDescricao()%></td>
                                    <td><%=formatadorPreco.format(produto.getPreco())%></td>
                                    <td><a href="consultarprodutoid?id=<%=produto.getId()%>"><span class="glyphicon glyphicon-new-window icone-botao"></span></a></td>
                                    <td><a href="alterarproduto?id=<%=produto.getId()%>"><span class="glyphicon glyphicon-edit icone-botao"></span></a></td>
                                    <td>
                                        <a href="excluirproduto?id=<%=produto.getId()%>" onclick="return confirm('Tem certeza de que deseja excluir o produto <%=produto.getDescricao()%>?')">
                                            <span class="glyphicon glyphicon-remove icone-botao"></span></a></td>
                                </tr>
                    <%      }
                        }
                    %>
                </tbody>
            </table>

            <br>   
            <a class="btn btn-default" href="produtocadastro.jsp">Novo</a>
        </div>
    </body>
</html>
