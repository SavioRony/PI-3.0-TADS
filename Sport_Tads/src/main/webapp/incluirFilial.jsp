<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <%@include file="header.jsp" %>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Cadastrar Filial</title>
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
            <h1>Cadastro de Filial</h1>
            <form action="CadastrarFilial" method="POST">
                <div class="row">
                    <div class="form-group col-lg-6">
                        <p>Nome da filial</p>
                        <input name="nomeFilial" class="form-control" required="true"/>
                    </div>
                    <div class="form-group col-lg-3">
                        <p>Estado (UF)</p>
                        <input name="estado" class="form-control" required="true"/>
                    </div>
                    <div class="form-group col-lg-3">
                        <p>Cidade</p>
                        <input name="cidade" class="form-control" required="true"/>
                    </div>
                </div>
                <br/>
                <button type="submit" style="float: right;" class="btn btn-primary">Salvar</button>
            </form>
        </div>
    </body>
</html>
