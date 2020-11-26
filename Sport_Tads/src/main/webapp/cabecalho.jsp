<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <link rel="stylesheet" href="https://stackpath.bootstrapcdn.com/bootstrap/4.5.2/css/bootstrap.min.css">
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
    </head>
    <style>
        #logo-sporttads{
            width: 200px;
            height: 80px;
        }
        #links-menus{
            margin-left: 30px;
            font-size: 22px;
        }
        li {
            margin-left: 10px;
            margin-right: 10px;
        }
    </style>
    <body>
        <nav class="navbar navbar-expand-sm bg-light navbar-light">
            <div>
                <a href="<c:url value="/protegido/index.jsp"/>">
                    <img id="logo-sporttads" src="img/lg.png">
                </a>
            </div>
            <div id="links-menus">
                <ul class="navbar-nav">
                    <c:if test="${sessionScope.colaborador.vendas || sessionScope.colaborador.regional}">
                        <li class="nav-item dropdown" >
                            <a class="nav-link dropdown-toggle" href="#" id="navbardrop" data-toggle="dropdown">
                                Clientes
                            </a>
                            <div class="dropdown-menu">
                                <a class="dropdown-item" href="<c:url value="/protegido/Vendas/cadastrarCliente.jsp"/>">Cadastrar Cliente</a>
                                <a class="dropdown-item" href="<c:url value="/ListarClientes"/>">Listar Clientes</a>
                            </div>
                        </li>
                    </c:if>
                    <c:if test="${sessionScope.colaborador.ti}">    
                        <li class="nav-item dropdown" >
                            <a class="nav-link dropdown-toggle" href="#" id="navbardrop" data-toggle="dropdown">
                                Colaboradores
                            </a>
                            <div class="dropdown-menu">
                                <a class="dropdown-item" href="<c:url value="/protegido/TI/cadastrarColaborador.jsp"/>">Cadastrar Colaborador</a>
                                <a class="dropdown-item" href="<c:url value="/ListarColaboradores"/>">Listar Colaboradores</a>
                            </div>
                        </li>
                    </c:if>
                    <c:if test="${sessionScope.colaborador.global}"> 
                        <li class="nav-item dropdown" >
                            <a class="nav-link dropdown-toggle" href="#" id="navbardro" data-toggle="dropdown">
                                Filiais
                            </a>
                            <div class="dropdown-menu">
                                <a class="dropdown-item" href="<c:url value="/protegido/Global/cadastrarFilial.jsp"/>">Cadastrar Filial</a>
                                <a class="dropdown-item" href="<c:url value="/ListarFiliais"/>">Listar Filiais</a>
                            </div>
                        </li>
                    </c:if>
                    <c:if test="${sessionScope.colaborador.backoffice || sessionScope.colaborador.regional}"> 
                        <li class="nav-item dropdown" >
                            <a class="nav-link dropdown-toggle" href="#" id="navbardrop" data-toggle="dropdown">
                                Produtos
                            </a>
                            <div class="dropdown-menu">
                                <a class="dropdown-item" href="<c:url value="/protegido/Backoffice/cadastrarProduto.jsp"/>">Cadastrar Produto</a>
                                <a class="dropdown-item" href="<c:url value="/ListaProdutos"/>">Listar Produtos</a>
                            </div>
                        </li>
                    </c:if>
                    <c:if test="${sessionScope.colaborador.vendas}"> 
                        <li class="nav-item dropdown" >
                            <a class="nav-link dropdown-toggle" href="#" id="navbardrop" data-toggle="dropdown">
                                Vendas
                            </a>
                            <div class="dropdown-menu">
                                <a class="dropdown-item" href="<c:url value="/protegido/Vendas/vendaCliente.jsp"/>">Realizar Venda</a>
                            </div>
                        </li>
                    </c:if>
                    <c:if test="${sessionScope.colaborador.global}">
                        <li class="nav-item dropdown" >
                            <a class="nav-link dropdown-toggle" href="#" id="navbardrop" data-toggle="dropdown">
                                Relatórios
                            </a>
                            <div class="dropdown-menu">
                                <a class="dropdown-item" href="<c:url value="/protegido/Global/relatorioConsolidadoVendasPorFilial.jsp"/>">Relatório Consolidado de Vendas Por Filial</a>
                                <a class="dropdown-item" href="<c:url value="/protegido/Global/relatorioVendasGlobal.jsp"/>">Relatório de Vendas Por Filial</a>
                            </div>
                        </li>
                    </c:if>
                    <c:if test="${sessionScope.colaborador.regional}">
                        <li class="nav-item dropdown" >
                            <a class="nav-link dropdown-toggle" href="#" id="navbardrop" data-toggle="dropdown">
                                Relatórios
                            </a>
                            <div class="dropdown-menu">
                                <a class="dropdown-item" href="<c:url value="/protegido/Vendas/vendaCliente.jsp"/>">Realizar Venda</a>
                                <a class="dropdown-item" href="<c:url value="/protegido/Regional/relatorioVendasRegional.jsp"/>">Relatório de Vendas Regional</a>
                                <a class="dropdown-item" href="<c:url value="/protegido/Regional/relatorioVendasCategoriaProduto.jsp"/>">Relatório de Vendas Por Categoria de Produtos</a>
                                <a class="dropdown-item" href="<c:url value="/protegido/Regional/relatorioVendasCliente.jsp"/>">Relatório de Vendas Por Cliente</a>
                            </div>
                        </li>
                    </c:if>                        
                    <li class="nav-item dropdown" >
                        <a class="nav-link dropdown-toggle" href="#" id="navbardrop" data-toggle="dropdown">
                            Conta 
                        </a>
                        <div class="dropdown-menu">
                            <a class="dropdown-item" href="<c:url value="/Logout"/>">Sair</a>
                        </div>
                    </li>
                </ul>
            </div>
        </nav>
    </body>
</html>