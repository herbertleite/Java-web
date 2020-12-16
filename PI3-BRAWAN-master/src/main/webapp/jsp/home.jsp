<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html lang="pt-br">
    <head>
        <meta charset="utf-8">

        <link rel="stylesheet" type="text/css" href="${pageContext.request.contextPath}/css/home.css">

        <!--Bootstrap 4 -->
        <link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/4.3.1/css/bootstrap.min.css">

        <script src="https://ajax.googleapis.com/ajax/libs/jquery/3.3.1/jquery.min.js"></script>

        <script src="https://cdnjs.cloudflare.com/ajax/libs/popper.js/1.14.7/umd/popper.min.js"></script>

        <script src="https://maxcdn.bootstrapcdn.com/bootstrap/4.3.1/js/bootstrap.min.js"></script>
    </head>
    <body>
        <nav class="navbar navbar-expand-lg navbar-light fixed-top">
            <div class="container">
                <a class="navbar-brand" href="#">Brawan</a>
                <button class="navbar-toggler" type="button" data-toggle="collapse" data-target="#navbarSupportedContent" aria-controls="navbarSupportedContent" aria-expanded="false" aria-label="Toggle navigation">
                    <span class="navbar-toggler-icon"></span>
                </button>

                <div class="collapse navbar-collapse" id="navbarSupportedContent">
                    <ul class="navbar-nav ml-auto">
                      

                        <li class="nav-item dropdown">
                            <a class="nav-link dropdown-toggle" href="#" id="navbarDropdown" role="button" data-toggle="dropdown" aria-haspopup="true" aria-expanded="false">
                                Cliente
                            </a>
                            <div class="dropdown-menu" aria-labelledby="navbarDropdown">
                                <a class="dropdown-item" href="${pageContext.request.contextPath}/jsp/cliente/cadastroCliente.jsp">Cadastrar</a>
                                <a class="dropdown-item" href="${pageContext.request.contextPath}/ConsultarCliente">Consultar</a>
                                
                            </div>
                        </li>

                        <li class="nav-item dropdown">
                            <a class="nav-link dropdown-toggle" href="#" id="navbarDropdown" role="button" data-toggle="dropdown" aria-haspopup="true" aria-expanded="false">
                                Produto
                            </a>
                            <div class="dropdown-menu" aria-labelledby="navbarDropdown">
                                <a class="dropdown-item" href="${pageContext.request.contextPath}/jsp/produto/cadastroProduto.jsp">Cadastrar</a>
                                <a class="dropdown-item" href="${pageContext.request.contextPath}/ConsultarProduto">Consultar</a>
                                
                            </div>
                        </li>

                        <li class="nav-item dropdown">
                            <a class="nav-link dropdown-toggle" href="#" id="navbarDropdown" role="button" data-toggle="dropdown" aria-haspopup="true" aria-expanded="false">
                                Filial
                            </a>
                            <div class="dropdown-menu" aria-labelledby="navbarDropdown">
                                <a class="dropdown-item" href="${pageContext.request.contextPath}/jsp/empresa/cadastroEmpresa.jsp">Cadastrar</a>
                                <a class="dropdown-item" href="${pageContext.request.contextPath}/ConsultarEmpresa">Consultar</a>

                               
                            </div>
                        </li>
                        <li class="nav-item dropdown">
                            <a class="nav-link dropdown-toggle" href="#" id="navbarDropdown" role="button" data-toggle="dropdown" aria-haspopup="true" aria-expanded="false">
                                Funcionario
                            </a>
                            <div class="dropdown-menu" aria-labelledby="navbarDropdown">
                                <a class="dropdown-item" href="${pageContext.request.contextPath}/Funcionario">Cadastrar</a>
                                <a class="dropdown-item" href="${pageContext.request.contextPath}/FuncionarioConsult">Consultar</a>

                                
                            </div>
                        </li>
                        
                         <li class="nav-item dropdown">
                            <a class="nav-link dropdown-toggle" href="#" id="navbarDropdown" role="button" data-toggle="dropdown" aria-haspopup="true" aria-expanded="false">
                                Serviços
                            </a>
                            <div class="dropdown-menu" aria-labelledby="navbarDropdown">
                                
                               
                                <a class="dropdown-item" href="${pageContext.request.contextPath}/jsp/vendas/carrinho.jsp">Venda</a>
                                 <a class="dropdown-item" href="${pageContext.request.contextPath}/RelatorioInicio">Relatório</a>
                                
                                
                            </div>
                        </li>
                        <li class="nav-item dropdown">
                            
                            
                            <a href="${pageContext.request.contextPath}/Logout" class="btn btn-outline-light btn-sm">Logout</a>
                     <!--       <a class="dropdown-item" href="${pageContext.request.contextPath}/Logout">Logout</a>-->
                            
                        </li>

                    </ul>
                </div>
            </div>
        </nav>

        <div id="carouselExampleIndicators" class="carousel slide" data-ride="carousel">
            <ol class="carousel-indicators">
                <li data-target="#carouselExampleIndicators" data-slide-to="0" class="active"></li>
                <li data-target="#carouselExampleIndicators" data-slide-to="1"></li>
                <li data-target="#carouselExampleIndicators" data-slide-to="2"></li>
            </ol>
            <div class="carousel-inner">
                <div class="carousel-item active">
                    <img class="d-block w-100" src="${pageContext.request.contextPath}/img/background-nav.jpg" alt="First slide">
                    <div class="carousel-caption d-none d-md-block">
                        <h5>Monte seu estilo conosco</h5>
                        <p>Um look criativo e bem montado pode fazer mágica</p>
                    </div>
                </div>
                <div class="carousel-item">
                    <img class="d-block w-100" src="${pageContext.request.contextPath}/img/background-nav2.jpg" alt="Second slide">
                    <div class="carousel-caption d-none d-md-block">
                        <h5>Estar na moda é estar apaixonada por sí mesma</h5>
                    </div>
                </div>
                <div class="carousel-item">
                    <img class="d-block w-100" src="${pageContext.request.contextPath}/img/background-nav3.jpg" alt="Third slide">
                    <div class="carousel-caption d-none d-md-block">
                        <h5>A moda sai de moda</h5>
                        <p>O estilo jamais!</p>
                    </div>
                </div>
            </div>
            <a class="carousel-control-prev" href="#carouselExampleIndicators" role="button" data-slide="prev">
                <span class="carousel-control-prev-icon" aria-hidden="true"></span>
                <span class="sr-only">Previous</span>
            </a>
            <a class="carousel-control-next" href="#carouselExampleIndicators" role="button" data-slide="next">
                <span class="carousel-control-next-icon" aria-hidden="true"></span>
                <span class="sr-only">Next</span>
            </a>
        </div>



    </body>
</html>