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
                    <div class="col-md-16 main-section">
                        <div class="modal-content">
                            <h1>Editar Produto</h1>
                            <form action="${pageContext.request.contextPath}/ProdutoEditar02" method="post">
                                <c:forEach items="${produto}" var="pro">

                                    <div class="form-group col-md-3">
                                        <label for="cod">Cod.</label>
                                        <input type="text" class="form-control" value="${pro.getCodigo()}" name="cod" id="cod" readonly>
                                    </div>

                                    <div class="form-group">
                                        <label for="nome">Nome do produto*</label>
                                        <input type="text" class="form-control" name="nome" value="${pro.getNome()}" id="nome" placeholder="Digite nome do produto" required>
                                    </div>

                                    <div class="form-group">
                                        <label for="quantidade">Quantidade*</label>
                                        <input type="text" class="form-control" name="quantidade" value="${pro.getQuantidade()}" id="nome" placeholder="Quantidade do produto" onkeyup="somenteNumeros(this);" required>
                                    </div>

                                    <div class="form-group col-md-8">
                                        <label for="categoriaProduto">Categoria</label>
                                        <select name="categoriaProduto" id="categoriaProduto" class="form-control">
                                            <option value="${pro.getCategoria()}" selected><c:out value="${pro.getCategoria()}"/></option>
                                            <option  value="Camisa">Camisa</option>
                                            <option  value="Calça">Calça</option>
                                            <option  value="Roupa Intima">Roupa Intima</option>
                                            <option  value="Infantil">Infantil</option>
                                            <option  value="Acessórios">Acessórios</option>
                                        </select>

                                    </div>

                                    <div class="form-group col-md-8">
                                        <label for="marcaProduto">Marca</label>
                                        <select name="marcaProduto" id="marcaProduto" class="form-control">
                                            <option value="${pro.getMarca()}" selected=""><c:out value="${pro.getMarca()}"/></option>
                                            <option  value="Nike">Nike</option>
                                            <option  value="Adidas">Adidas</option>
                                            <option  value="Puma">Puma</option>
                                            <option  value="Asics">Asics</option>
                                            <option  value="Oakley">Oakley</option>
                                        </select>  

                                    </div>

                                    <div class="form-group col-md-8">
                                        <label for="tamanhoProduto">Tamanho</label>
                                        <select name="tamanhoProduto" id="tamanhoProduto" class="form-control">
                                            <option value="${pro.getTamanho()}" selected><c:out value="${pro.getTamanho()}"/></option>
                                            <option  value="P">P</option>
                                            <option  value="M">M</option>
                                            <option  value="G">G</option>
                                            <option  value="Unico">Unico</option>
                                        </select>
                                    </div>

                                    <div class="form-group">
                                        <label for="valor">Valor Unitario*</label>
                                        <input type="text" name="valor" value="${pro.getValorUnitario()}" id="valor" class="form-control" placeholder="Valor do produto" required>
                                    </div>

                                    <div class="form-group">
                                        <label for="comentario">Descrição</label>
                                        <textarea name="comentario" id="comentario" rows="5" cols="33" placeholder="Digite aqui o seu comentário.." class="form-control"><c:out value="${pro.getDescricao()}"/></textarea>
                                    </div>

                                    <a href="${pageContext.request.contextPath}/ConsultarProduto"><input type="button" class="btn btn-outline-dark btn-lg" value="Voltar"></a>
                                    <input type="reset" class="btn btn-outline-danger btn-lg" value="Limpar">
                                    <input type="submit" class="btn btn-outline-success btn-lg" value="Salvar">
                                    <br>
                                    <br>

                                </c:forEach>
                            </form>
                        </div>
                    </div>
                </div>
            </div>
        </div>

        <script type="text/javascript">

            function somenteNumeros(num) {
                var er = /[^0-9.]/;
                er.lastIndex = 0;
                var campo = num;
                if (er.test(campo.value)) {
                    campo.value = "";
                }
            }



        </script>
    </body>
</html>