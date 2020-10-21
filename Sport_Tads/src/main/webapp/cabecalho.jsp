<%-- 
    Document   : index
    Created on : Sep 25, 2020, 9:09:13 PM
    Author     : tscarton
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <link rel="stylesheet" href="https://stackpath.bootstrapcdn.com/bootstrap/4.5.2/css/bootstrap.min.css">
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
    </head>
    <style>
        #logo-sportstads{
            width: 300px;
            height: 100px;
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
                <img id="logo-sportstads" src="img\logo.jpeg">
            </div>
            <div id="links-menus">
                <ul class="navbar-nav">
                    <li class="nav-item dropdown" >
                        <a class="nav-link dropdown-toggle" href="#" id="navbardrop" data-toggle="dropdown">
                            Clientes
                        </a>
                        <div class="dropdown-menu">
                            <a class="dropdown-item" href="#">Cadastrar Cliente</a>
                            <a class="dropdown-item" href="#">Listar Clientes</a>
                        </div>
                    </li>
                    <li class="nav-item dropdown" >
                        <a class="nav-link dropdown-toggle" href="#" id="navbardrop" data-toggle="dropdown">
                            Colaboradores
                        </a>
                        <div class="dropdown-menu">
                            <a class="dropdown-item" href="cadastrarColaborador.jsp">Cadastrar Colaborador</a>
                            <a class="dropdown-item" href="listaColaboradores.jsp">Listar Colaboradores</a>
                        </div>
                    </li>
                    <li class="nav-item dropdown" >
                        <a class="nav-link dropdown-toggle" href="#" id="navbardrop" data-toggle="dropdown">
                            Filiais
                        </a>
                        <div class="dropdown-menu">
                            <a class="dropdown-item" href="#">Cadastrar Filial</a>
                            <a class="dropdown-item" href="#">Listar Filiais</a>
                        </div>
                    </li>
                    <li class="nav-item dropdown" >
                        <a class="nav-link dropdown-toggle" href="#" id="navbardrop" data-toggle="dropdown">
                            Produtos
                        </a>
                        <div class="dropdown-menu">
                            <a class="dropdown-item" href="#">Cadastrar Produto</a>
                            <a class="dropdown-item" href="#">Listar Produtos</a>
                        </div>
                    </li>
                    <li class="nav-item dropdown" >
                        <a class="nav-link dropdown-toggle" href="#" id="navbardrop" data-toggle="dropdown">
                            Vendas
                        </a>
                        <div class="dropdown-menu">
                            <a class="dropdown-item" href="#">Realizar Venda</a>
                            <a class="dropdown-item" href="#">Relatório por Filiais</a>
                            <a class="dropdown-item" href="#">Relatório por Categorias de Produtos</a>
                            <a class="dropdown-item" href="#">Relatório Por Cliente</a>
                        </div>
                    </li>
                </ul>
            </div>
        </nav>
    </body>
</html>