<%-- 
    Document   : produtocadastrar
    Created on : Apr 28, 2016, 9:01:37 AM
    Author     : ngonvalves
--%>
<%@page import="modelo.Produto"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <%
            Produto produto = (Produto) request.getAttribute("produto");
            String action = "alterarproduto";
            String titulo = "Editar Produto ";
            
            if (produto == null) {
                produto = new Produto("");
                action = "cadastrarproduto";
                titulo = "Novo Produto";
            }
        %>
        
        
        
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title><%=titulo%></title>
        <link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.6/css/bootstrap.min.css" integrity="sha384-1q8mTJOASx8j1Au+a5WDVnPi2lkFfwwEAa8hDDdjZlpLegxhjVME1fgjWPGmkzs7" crossorigin="anonymous">
        <link rel="stylesheet" href="css/estilo.css">
    </head>
    <body>
        <h1><%=titulo%></h1>
        
        <div id="conteudo">
            <form action="<%=action%>" method="post" enctype="multipart/form-data">
            
            <input type="text" name="id" id="id" value="<%=produto.getId()%>" hidden><br>
            
            <label for="descricao">Descrição</label>
            <input type="text" name="descricao" id="descricao" required value="<%=produto.getDescricao()%>"><br>
            
            <label for="descricao">Preco</label>
            <input type="text" name="preco" id="preco" required value="<%=produto.getPreco()%>"><br>
            
            <label for="descricao">Marca</label>
            <input type="text" name="marca" id="marca" value="<%=produto.getEspecificacao().getMarca()%>"><br>
            
            <label for="descricao">Cor</label>
            <input type="text" name="cor" id="cor" value="<%=produto.getEspecificacao().getCor()%>"><br>
            
            <label for="descricao">Modelo</label>
            <input type="text" name="modelo" id="modelo" value="<%=produto.getEspecificacao().getModelo()%>"><br>
            
            <% if (produto.getImagem() == null) { %>
            <label for="imagem">Imagem</label>
            <input type="file" name="imagem" id="imagem"><br><br>
            <% } %>
            
            <div class="case-botoes"> 
                <button class="btn btn-default" type="reset">
                            <span class="glyphicon glyphicon-erase icone-botao"></span> 
                            <span>&nbsp; Apagar</span>
                </button>
                <a class="btn btn-default" href=".">
                            <span class="glyphicon glyphicon-remove icone-botao"></span> 
                            <span>&nbsp; Cancelar</span>
                </a>
                <button class="btn btn-default" type="submit" >
                            <span class="glyphicon glyphicon-floppy-disk icone-botao"></span> 
                            <span>&nbsp; Salvar</span>      
                </button>
                
               
            </div>
            
            
        </form>
        </div>
    </body>
</html>
