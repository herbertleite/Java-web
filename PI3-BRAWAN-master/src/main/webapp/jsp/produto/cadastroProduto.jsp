<%@page contentType="text/html" pageEncoding="UTF-8"%>
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
    <c:if test="${msgSucess != null}">
        <div class="alert alert-success" role="alert">
            ${msgSucess}
            <button type="button" class="close" data-dismiss="alert" aria-label="Close">
                <span aria-hidden="true">&times;</span>
            </button>
        </div>
    </c:if>
            
    <div class="container">
        <div class="d-flex justify-content-center">
            <div class="row">
                <div class="col-md-16 main-section" >
                    <div class="modal-content">
                        <h1>Cadastrar Produto</h1>
                        <form action="${pageContext.request.contextPath}/CadastrarProduto" method="post">

                            <div class="form-group">
                                <label for="codigo">Cod. Produto*</label>
                                <input type="text" class="form-control" name="codigo" id="codigo" placeholder="Insira o código do produto" onkeyup="somenteNumeros(this);" required>
                            </div>

                            <div class="form-group">
                                <label for="nome">Nome do produto*</label>
                                <input type="text" class="form-control" name="nome" id="nome" placeholder="Digite nome do produto" required>
                            </div>

                            <div class="form-group">
                                <label for="quantidade">Quantidade*</label>
                                <input type="text" class="form-control" name="quantidade" id="nome" placeholder="Quantidade do produto" onkeyup="somenteNumeros(this);" required>
                            </div>

                            <div class="form-group col-md-8">
                                <label for="categoriaProduto">Categoria</label>
                                <select name="categoriaProduto" id="categoriaProduto" class="form-control">
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
                                    <option  value="P">P</option>
                                    <option  value="M">M</option>
                                     <option  value="G">G</option>
                                      <option  value="Unico">Unico</option>
                                </select>
                            </div>

                            <div class="form-group">
                                <label for="valor">Valor Unitario*</label>
                                <input type="text" name="valor" id="valor" class="form-control" placeholder="Valor do produto" required>
                            </div>

                            <div class="form-group">
                                <label for="comentario">Descrição</label>
                                <textarea name="comentario" id="comentario" rows="5" cols="33" placeholder="Digite aqui o seu comentário.." class="form-control"></textarea>
                            </div>
                            &nbsp;&nbsp;
                            <a href="${pageContext.request.contextPath}/jsp/home.jsp"><input type="button" class="btn btn-dark btn-lg" value="Voltar"></a>&nbsp;&nbsp;&nbsp;&nbsp;
                            <input type="reset" class="btn btn-danger btn-lg" value="Limpar">&nbsp;&nbsp;&nbsp;&nbsp;
                            <input type="submit" class="btn btn-success btn-lg" value="Salvar">

                            <br>
                            <br>


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