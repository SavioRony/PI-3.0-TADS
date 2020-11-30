<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <%@include file="../../header.jsp" %>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Cadastrar Produto</title>
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
            <h1>Cadastro de Produto</h1>
            <form action="<c:url value="/IncluirProduto"/>" method="POST">
                <div class="row">
                    <div class="form-group col-lg-6">
                        <p>Nome</p>
                        <input onkeypress="return event.charCode >= 65 && event.charCode <= 90 || event.charCode >= 97 && event.charCode <= 122" name="nome" class="form-control" required="true"/>
                    </div>
                    <div class="form-group col-lg-6">
                        <p>Marca</p>
                        <input name="marca" class="form-control" required="true"/>
                    </div>
                </div>
                <br/>
                <div class="row">
                    <div class="form-group col-lg-4">
                        <p>Categoria</p>
                        <select name="categoria"class="browser-default custom-select" required="true">
                            <option value="" disabled selected>Selecione</option>
                            <option value="Aquaticos">Aquaticos</option>
                            <option value="Basquete">Basquete</option>
                            <option value="Fitness">Fitness</option>
                            <option value="Futebol">Futebol</option>
                            <option value="Marciais">Marciais</option>
                            <option value="Volei">Volei</option>
                        </select>
                    </div>
                    <div class="form-group col-lg-4">
                        <p>Quantidade</p>
                        <input name="qtd" class="form-control" required="true"/>
                    </div>
                    <div class="form-group col-lg-4">
                        <p>Valor</p>
                        <input name="valor" class="form-control" required="true"/>
                    </div>
                    <input name="filial" type="hidden" value="${sessionScope.colaborador.codFilial}"/>
                </div>
                <br/>
                <button type="submit" style="float: right" class="btn btn-primary">Salvar</button>
            </form>
        </div>
    </body>
</html>