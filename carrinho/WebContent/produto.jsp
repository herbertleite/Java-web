<%@page import="java.text.NumberFormat"%>
<%@page import="modelo.Produto"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Quitanda</title>
        <link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.6/css/bootstrap.min.css" integrity="sha384-1q8mTJOASx8j1Au+a5WDVnPi2lkFfwwEAa8hDDdjZlpLegxhjVME1fgjWPGmkzs7" crossorigin="anonymous">
        <link rel="stylesheet" href="css/estilo.css">
    </head>
    <body>
        <h1><a href=".">Loja</a></h1><br>

        <%
            Produto p = (Produto) request.getAttribute("produto");
            NumberFormat formatadorPreco = NumberFormat.getCurrencyInstance();

            if (p != null) {
        %>

        <div id="case-produto">
            <table>
                <tr>
                    <td width="450">
                        <img src="<%=p.getImagem()%>" width="400">
                    </td>
                    <td>
                        <h2><%=p.getDescricao()%></h2>
                        <p class="preco"><%=formatadorPreco.format(p.getPreco())%></p><br>
                        
                        
                      <a class="btn btn-default" href="adicionarNoCarrinho?id=<%=p.getId()%>">
                            <span class="glyphicon glyphicon-tag icone-botao"></span> 
                            <span>&nbsp; Adicionar</span>
                        </a>
                 
                    </td>
                </tr>
            </table>

            <br><br><br>
            <%
                if (p.getEspecificacao() != null) {
            %>   
            <table class="table table-striped" style="width: 100%">
                <thead>
                    <tr>
                        <th colspan="2">Especificacoes</th>
                    </tr>
                </thead>
                <tr>
                    <td width="450">Marca</td><td width="250"><%=p.getEspecificacao().getMarca()%></td>
                </tr>
                <tr>
                    <td>Modelo</td><td><%=p.getEspecificacao().getModelo()%></td>
                </tr>
                <tr>
                    <td>Cor</td><td><%=p.getEspecificacao().getCor()%></td>
                </tr>
            </table>

            <%
                    }
                }
            %>
        </div>
        <br><br><br>
    </body>
</html>
