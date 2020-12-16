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

        <link rel="stylesheet" href="https://use.fontawesome.com/releases/v5.8.1/css/all.css" integrity="sha384-50oBUHEmvpQ+1lW4y57PTFmhCaXp0ML5d60M1M7uH2+nqUivzIebhndOJK28anvf" crossorigin="anonymous">

    </head>

    <body>

        <c:if test="${msgErroData != null}">
            <div class="alert alert-danger" role="alert">
                ${msgErroData}
                <button type="button" class="close" data-dismiss="alert" aria-label="Close">
                    <span aria-hidden="true">&times;</span>
                </button>
            </div>
        </c:if>

        <div class="container" id="row">
            <div class="modal-content">
                <div class="table-responsive">



                    <form action="${pageContext.request.contextPath}/Relatorio" method="post">

                        <h1><u>Relatorio</u></h1><br>


                        <div class="col-md-5">
                            <label>De:&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;
                                &nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;
                                &nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;
                                &nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;
                                &nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;Até:</label>

                            <div class="input-group">
                                <input type="date" name="dataInicio" class="form-control" required>&nbsp;&nbsp;&nbsp;&nbsp;
                                <input type="date" name="dataFinal" class="form-control" required>
                            </div>

                        </div>



                        <div class="form-group  col-md-4">
                            <br><label for="empresa">Empresa*</label>
                            <div class="input-group">
                                <select name="empresa" id="empresa" class="form-control">  
                                    <c:forEach items="${empresa}" var="emp"> 
                                        <option value="${emp.getEmpresa()}">${emp.getEmpresa()}</option>  
                                    </c:forEach>  
                                </select>
                                <span class="input-group-btn">
                                    <button type="submit" class="btn btn-outline-dark"><i class="fas fa-search"></i></button>
                                </span>

                            </div>

                        </div>

                    </form>



                    <br><table class="table table-hover">

                        <thead class="thead-dark">
                            <tr>

                                <th>Cod.</th>
                                <th>Cliente</th>
                                <th>Funcionario</th>
                                <th>Empresa</th>
                                <th>Qtd. Total</th>
                                <th>Data</th>
                                <th>Valor Total</th>
                                <th></th>

                            </tr>
                        </thead>

                        <tbody>
                            <c:forEach items="${relatorio}" var="relatorio">

                                <tr>
                                    <td><c:out value="${relatorio.getCodigo()}"/></td>
                                    <td><c:out value="${relatorio.getCliente()}"/></td>
                                    <td><c:out value="${relatorio.getCaixa()}"/></td>
                                    <td><c:out value="${relatorio.getEmpresa()}"/></td>
                                    <td><c:out value="${relatorio.getQtdComprado()}"/></td>
                                    <td><c:out value="${relatorio.getDataCompra()}"/></td>
                                    <td><c:out value="${relatorio.getTotFaturado()}"/></td>
                                </tr>
                            </c:forEach>
                        </tbody>

                    </table>

                </div>

                <a href="${pageContext.request.contextPath}/jsp/home.jsp"><input type="button" class="btn btn-dark btn-lg" value="Voltar"></a>

                <br>
            </div>
        </div>
    </body>
</html>