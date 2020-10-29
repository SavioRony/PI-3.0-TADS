<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <%@include file="header.jsp" %>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Alterar Produto</title>
    </head>
    <style>
        div h1{
            text-align: center;
            margin-bottom: 50px;
            margin-top: 50px;
        }
        p{
            font-weight: bolder;
            font-size: 18px;
        }
    </style>
    <body>
        <%@include file="cabecalho.jsp" %>
        <div class="container">
            <h1>Alterar Produto: ${prod.nomeProduto}</h1>
            <form action="AlterarProduto" method="POST">
                <div class="row">
                    <div class="form-group col-lg-3">
                        <p>ID Produto</p>
                        <input class="form-control" name="codProduto" value="${prod.codProduto}" readonly="true"/>
                    </div>
                    <div class="form-group col-lg-6">
                        <p>Nome</p>
                        <input class="form-control" name="nome" value="${prod.nomeProduto}"/>
                    </div>
                    <div class="form-group col-lg-3">
                        <p>Marca</p>
                        <input class="form-control" name="marca" value="${prod.marcaProduto}"/>
                    </div>
                </div>
                <br/>
                <div class="row">
                    <div class="form-group col-lg-4">
                        <p>Categoria</p>
                        <input class="form-control" name="categoria" value="${prod.categoriaProduto}"/>
                    </div>
                    <div class="form-group col-lg-2">
                        <p>ID Filial</p>
                        <input class="form-control" name="filial" value="${prod.codFilial}" readonly="true"/>
                    </div>
                    <div class="form-group col-lg-3">
                        <p>Valor</p>
                        <input class="form-control" name="valor" value="${prod.valorProduto}"/>
                    </div>
                    <div class="form-group col-lg-3">
                        <p>Quantidade</p>
                        <input class="form-control" name="qtd" value="${prod.quantidadeEmEstoque}"/>
                    </div>
                </div>
                <br/>
                <button class="btn btn-primary" type="submit" style="float: right">Salvar</button>
            </form>
        </div>
    </body>
</html>
