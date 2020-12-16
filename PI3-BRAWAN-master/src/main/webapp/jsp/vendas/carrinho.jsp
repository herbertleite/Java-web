<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
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


        <script type="text/javascript" src="js/jquery.mask.min.js"/></script>


</head>
<body>

    <c:if test="${msgErroRepetido != null}">
        <div class="alert alert-danger" role="alert">
            ${msgErroRepetido}
            <button type="button" class="close" data-dismiss="alert" aria-label="Close">
                <span aria-hidden="true">&times;</span>
            </button>
        </div>
    </c:if>

    <c:if test="${msgErroEstoque != null}">
        <div class="alert alert-danger" role="alert">
            ${msgErroEstoque}
            <button type="button" class="close" data-dismiss="alert" aria-label="Close">
                <span aria-hidden="true">&times;</span>
            </button>
        </div>
    </c:if>

    <c:if test="${msgErroCliente != null}">
        <div class="alert alert-danger" role="alert">
            ${msgErroCliente}
            <button type="button" class="close" data-dismiss="alert" aria-label="Close">
                <span aria-hidden="true">&times;</span>
            </button>
        </div>
    </c:if>

    <c:if test="${msgErroProduto != null}">
        <div class="alert alert-danger" role="alert">
            ${msgErroProduto}
            <button type="button" class="close" data-dismiss="alert" aria-label="Close">
                <span aria-hidden="true">&times;</span>
            </button>
        </div>
    </c:if>

    <c:if test="${MsgVazio != null}">
        <div class="alert alert-danger" role="alert">
            ${MsgVazio}
            <button type="button" class="close" data-dismiss="alert" aria-label="Close">
                <span aria-hidden="true">&times;</span>
            </button>
        </div>
    </c:if>

    <c:if test="${MsgSucesso != null}">
        <div class="alert alert-success" role="alert">
            ${MsgSucesso}
            <button type="button" class="close" data-dismiss="alert" aria-label="Close">
                <span aria-hidden="true">&times;</span>
            </button>
        </div>
    </c:if>


    <div class="container main-section" id="row">
        <div class="modal-content">
            <form  action="${pageContext.request.contextPath}/venda01" method="post">
                <div class="col-md-3">



                    <h1><u>Carrinho</u></h1>

                    <label>CPF Cliente*</label> 
                    <input type="text" class="form-control" name="cpfCliente" value="${cpf}" maxlength="14" OnKeyPress="formatar('###.###.###/##', this)" required>

                    <label>Cod. Produto</label> 
                    <input type="text" class="form-control" name="CodProduto" onkeyup="somenteNumeros(this);" required>

                </div>

                <div class="col-md-2">
                    <label>Quantidade</label>
                    <input type="text" class="form-control" name="Quantidade" maxlength="3"  onkeyup="somenteNumeros(this);" required>
                </div>

                <div class="col-md-3">
                    <br><input type="submit" value="ADD" class="btn btn-outline-primary">

                </div>

            </form><br>


            <div class="table-responsive">
                <table class="table">
                    <thead class="thead-dark">
                        <tr>

                            <th>Código</th>
                            <th>Produto</th>
                            <th>Quantidade</th>
                            <th>Valor Unitário</th>
                            <th>Valor Total</th>
                            <th></th>

                        </tr>
                    </thead>
                    <tbody>


                        <c:set var="total" value="" />
                        <c:forEach items="${lista}" var="lista">

                            <tr>
                                <td><c:out value="${lista.getCodigoProd()}"/></td>
                                <td><c:out value="${lista.getNome()}"/></td>
                                <td><c:out value="${lista.getQuantidade()}"/></td>
                                <td>R$: <c:out value="${lista.getValorUnitario()}"/></td>
                                <td>R$: <c:out value="${lista.getValorTotalItem()}"/></td>
                                <c:set var="total" value="${total + lista.getValorTotalItem()}" />      
                                <td class="text-right">

                                    <a href="${pageContext.request.contextPath}/VendaExcluir?id=<c:out value='${lista.getId()}'/>"><input type="button" class="btn btn-danger" value="Excluir" ></a>
                                <!--    <a href="${pageContext.request.contextPath}/VendaExcluir?cod=<c:out value='${lista.getCodigoProd()}'/>"><button  class="btn btn-danger"><i class="fas fa-trash"></i></button></a> -->

                                </td>
                            </tr>

                        </c:forEach>
                    </tbody>
                </table>

                <br>
                <h4>VALOR TOTAL DA COMPRA: R$ <c:out value="${total}"/></h4>
                <br>

                <a href="${pageContext.request.contextPath}/jsp/home.jsp"><input type="button" class="btn btn-outline-dark btn-lg" value="Voltar"></a>
                <a href="${pageContext.request.contextPath}/venda02"><input type="button" class="btn btn-success btn-lg" value="Finalizar Pedido" ></a>

                <br>
                <br>



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