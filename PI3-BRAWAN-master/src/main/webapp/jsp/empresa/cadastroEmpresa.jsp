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
                    <div class="col-md-16 main-section">
                        <div class="modal-content">
                            <h1>Cadastrar Filial</h1>
                            <form action="${pageContext.request.contextPath}/CadastrarEmpresa" method="post">
                                <div class="form-group">
                                    <label for="empresa">Filial*</label>
                                    <input type="text" class="form-control" name="empresa" placeholder="Nome da Filial" id="empresa" required>
                                </div>

                                <div class="form-group">
                                    <label for="diretor">Diretor*</label>
                                    <input type="text" class="form-control" name="diretor" placeholder="Nome do diretor" id="diretor" required>
                                </div>

                                <div class="form-group">
                                    <label for="cnpj">CNPJ*</label>
                                    <input type="text" class="form-control" name="cnpj" id="cnpj" placeholder="Digite o CNPJ" maxlength="18" OnKeyPress="formatar('##.###.###/####-##', this)" required>
                                </div>
                                
                                <div class="form-group">
                                    <label for="cep">CEP*</label>
                                    <input type="text" class="form-control" name="cep" id="cep" placeholder="Digite o CEP"  maxlength="9" OnKeyPress="formatar('#####-###', this)" required>
                                </div>




                                <div class="form-group">
                                    <label for="endereco">Endereço*</label>
                                    <input type="text" class="form-control" name="endereco" id="endereco" placeholder="Ex: Rua antonio, Nº10" required>
                                </div>

                                <div class="form-group">
                                    <label for="bairro">Bairro*</label>
                                    <input type="text" class="form-control "name="bairro" id="bairro" placeholder="Ex: Conceição" required>

                                </div>

                                <div class="form-group">
                                    <label for="idEstado">Estado</label>
                                    <input type="text" class="form-control" name="idEstado" id="idEstado" placeholder="Estado">
                                </div>


                                <div class="form-group">
                                    <label for="cidade">Cidade*</label>
                                    <input type="text" class="form-control" name="cidade" id="cidade" placeholder="Ex: Barueri" required>

                                </div>

                                
                                <div class="form-group">
                                    <label for="telefone">Telefone*</label>
                                    <td><input type="text" class="form-control" name="telefone" id="telefone" placeholder="(DDD) XXXXX-XXXX" maxlength="13" OnKeyPress="formatar('##-#####-#####', this)"></td>
                                </div>

                                <div class="form-group">
                                    <label for="email">E-mail*</label>
                                    <input type="email" class="form-control" name="email" placeholder="email@outlook.com" >

                                </div>

                                <a href="${pageContext.request.contextPath}/jsp/home.jsp"><input type="button" class="btn btn-dark btn-lg" value="Voltar"></a>&nbsp;&nbsp;&nbsp;&nbsp;
                                <input type="reset" value="Limpar" class="btn btn-danger btn-lg">&nbsp;&nbsp;&nbsp;&nbsp;
                                <input type="submit" value="Salvar" class="btn btn-success btn-lg">

                                <br>
                                <br>
                            </form>
                        </div>
                    </div>

                </div>

            </div>
        </div>

        <script type="text/javascript">
            jQuery(function ($) {
                $("#cep").change(function () {
                    var cep_code = $(this).val();
                    if (cep_code.length <= 0)
                        return;
                    $.get("http://apps.widenet.com.br/busca-cep/api/cep.json", {code: cep_code},
                            function (result) {
                                if (result.status != 1) {
                                    alert(result.message || "Houve um erro desconhecido");
                                    return;
                                }
                                $("input#cep").val(result.code);
                                $("input#idEstado").val(result.state);
                                $("input#cidade").val(result.city);
                                $("input#bairro").val(result.district);
                                $("input#endereco").val(result.address);
                                $("input#idEstado").val(result.state);
                            });
                });
            });


            function somenteNumeros(num) {
                var er = /[^0-9.]/;
                er.lastIndex = 0;
                var campo = num;
                if (er.test(campo.value)) {
                    campo.value = "";
                }
            }


            function formatar(mascara, documento) {
                var i = documento.value.length;
                var saida = mascara.substring(0, 1);
                var texto = mascara.substring(i);

                if (texto.substring(0, 1) !== saida) {
                    documento.value += texto.substring(0, 1);
                }

            }
        </script>


    </body>
</html>