<%-- 
    Document   : cadastrarProduto
    Created on : 15/10/2020, 18:05:21
    Author     : Fernando
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <%@include file="header.jsp" %>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Cadastrar Produto</title>
    </head>
    <style>
        p {
            font-weight: bolder;
            font-size: 18px;
        }
    </style>
    <body>
        <%@include file="cabecalho.jsp" %>
        <div class="container">
            <h1 style="text-align: center; margin-top: 50px; margin-bottom: 50px">Cadastro de Produto</h1>
            <form action="IncluirProduto" method="POST">
                <div class="row">
                    <div class="form-group col-lg-6">
                        <p>Nome</p>
                        <input name="nome" class="form-control" required="true"/>
                    </div>
                    <div class="form-group col-lg-6">
                        <p>Marca</p>
                        <input name="marca" class="form-control" required="true"/>
                    </div>
                </div>
                <div class="row">
                    <div class="form-group col-lg-6">
                        <p>Categoria</p>
                        <input name="categoria" class="form-control" required="true"/>
                    </div>
                    <div class="form-group col-lg-6">
                        <p>Quantidade</p>
                        <input name="qtd" class="form-control" required="true"/>
                    </div>
                </div>
                <div class="row">
                    <div class="form-group col-lg-6">
                        <p>Valor</p>
                        <input name="valor" class="form-control" required="true"/>
                    </div>
                    <div class="form-group col-lg-6">
                        <p>Código da filial</p>
                        <input name="filial" class="form-control" required="true"/>
                    </div>
                </div>
                <button type="submit" style="float: right; width: 100px; margin-bottom: 30px; margin-top: 25px" class="btn btn-primary">Salvar</button>
            </form>
        </div>
    </body>
</html>