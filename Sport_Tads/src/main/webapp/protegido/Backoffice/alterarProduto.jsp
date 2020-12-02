<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <%@include file="../../header.jsp" %>
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
        <%@include file="../../cabecalho.jsp" %>
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
                    <div class="form-group col-lg-6">
                        <p>Categoria</p>
                        <select name="categoria"class="browser-default custom-select" required="true">
                            <option value="${prod.categoriaProduto}" disabled selected>Selecione</option>
                            <option value="Aquaticos">Aquaticos</option>
                            <option value="Basquete">Basquete</option>
                            <option value="Fitness">Fitness</option>
                            <option value="Futebol">Futebol</option>
                            <option value="Marciais">Marciais</option>
                            <option value="Volei">Volei</option>
                        </select>
                    </div>
                    <div class="form-group col-lg-3">
                        <p>Valor</p>
                        <input class="form-control" name="valor" onkeypress="return event.charCode >= 48 && event.charCode <= 57 || event.charCode == 46" value="${prod.valorProduto}"/>
                    </div>
                    <div class="form-group col-lg-3">
                        <p>Quantidade</p>
                        <input class="form-control" name="qtd" onkeypress="return event.charCode >= 48 && event.charCode <= 57" value="${prod.quantidadeEmEstoque}"/>
                    </div>
                </div>
                    <input type="hidden" class="form-control" name="filial" value="${prod.codFilial}" readonly="true"/>
                <br/>
                <button class="btn btn-primary" type="submit" style="float: right">Salvar</button>
            </form>
        </div>
    </body>
</html>
