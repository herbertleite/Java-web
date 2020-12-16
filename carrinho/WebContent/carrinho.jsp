<%-- 
    Document   : produtos
    Created on : Apr 28, 2016, 9:01:25 AM
    Author     : ngoncalves
--%>

<%@page import="java.text.NumberFormat"%>
<%@page import="java.util.List"%>
<%@page import="modelo.Produto"%>
<%@page import="modelo.Carrinho"%>
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
        <h1><a href=".">Carrinho de compras</a></h1>

        <br>

        <div id="conteudo">
            <table class="table table-striped">
                <thead>
                    <tr>
                        <th>#</th>
                        <th>Imagem</th>
                        <th style="width: 60%">Descrição</th>
                        <th>Abrir</th>
                        <th >Remover</th>
                        <th>Preço</th>
                    </tr>
                </thead>
                <tbody>
                    <%
                        double total = 0;
                        Carrinho carrinho = null;
                        if ((carrinho = (Carrinho) request.getSession().getAttribute("carrinho")) != null) {
                            NumberFormat formatadorPreco = NumberFormat.getCurrencyInstance();
                            int i =1;
                            for (Produto produto : carrinho.getProdutosNoCarrinho()) {
                                
                                total += produto.getPreco();
                    %>
                                <tr>
                                    <td><%=i++%></td>
                                    <td><img src="<%=produto.getImagem()%>" width="40"></td>
                                    <td><%=produto.getDescricao()%></td>
                                    <td><a href="consultarprodutoid?id=<%=produto.getId()%>">
                                            <span class="glyphicon glyphicon-new-window icone-botao"></span>
                                        </a>
                                    </td>
                                    <td>
                                        <a href="removerDoCarrinho?id=<%=produto.getId()%>">
                                            <span class="glyphicon glyphicon-remove icone-botao"></span>
                                        </a>
                                    </td>
                                    <td><%=formatadorPreco.format(produto.getPreco())%></td>
                                </tr>
                    <%      }
                    %>
                </tbody>
                <tfoot>
                    <tr><th colspan="5">Total</th><th><%=formatadorPreco.format(total)%></th></tr>
                    <% } %>
                </tfoot>
            </table>
                
            <div class="case-botoes"> 
                <a class="btn btn-default" href="index.jsp">
                            <span class="glyphicon glyphicon-shopping-cart icone-botao"></span> 
                            <span>&nbsp; Continuar comprando</span>
                </a>
                 
                <a class="btn btn-default">
                            <span class="glyphicon glyphicon-tag icone-botao"></span> 
                            <span>&nbsp; Finalizar compra</span>
                </a>
            </div>
        </div>
    </body>
</html>
