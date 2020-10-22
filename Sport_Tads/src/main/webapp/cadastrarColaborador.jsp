<%-- 
    Document   : cadastrarColaborador
    Created on : Out 16, 2020, 23:00:00 AM
    Author     : Hugo Souza Araujo
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <%@include file="header.jsp" %>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Cadastrar Colaborador</title>
    </head>
    <style>
        p {
            font-weight: bolder;
            font-size: 18px;
        }

    </style>
    <script>
        $(document).ready(function () {
            // $.notify("Colaborador salvo com sucesso", "success");
        });
    </script>
    <body>
        <%@include file="cabecalho.jsp" %>
        <div class="container">
            <h1 style="text-align: center; margin-top: 50px; margin-bottom: 50px">Cadastro de Colaborador</h1>
            <form action="CadastrarCliente" method="POST">
                <div class="row">
                    <div class="form-group col-lg-8">
                        <p>Nome Completo</p>
                        <input name="nome" class="form-control" required="true"/><br/>
                    </div>
                    <div class="form-group col-lg-4">
                        <p>CPF</p>
                        <input name="cpf" class="form-control" required="true"/><br/>
                    </div>
                </div>
                <div class="row">
                    <div class="form-group col-lg-6">
                        <p>Endereço</p>
                        <input name="endereco" class="form-control" required="true"/><br/>
                    </div>
                    <div class="form-group col-lg-2">
                        <p>Número</p>
                        <input name="numero" class="form-control" required="true"/><br/>
                    </div>
                    <div class="form-group col-lg-4">
                        <p>CEP</p>
                        <input name="cep" class="form-control" required="true"/><br/>
                    </div>
                </div>
                <div class="row">
                    <div class="form-group col-lg-4">
                        <p>Bairro</p>
                        <input name="bairro" class="form-control" required="true"/><br/>
                    </div>
                    <div class="form-group col-lg-4">
                        <p>Cargo</p>
                        <input name="cargo" class="form-control" required="true"/><br/>
                    </div>
                    <div class="form-group col-lg-4">
                        <p>Filial</p>
                        <input name="celular" class="form-control" required="true"/><br/>
                    </div>
                </div>
                <div class="row">
                    <div class="form-group col-lg-8">
                        <p>Email</p>
                        <input name="email" class="form-control" required="true"/><br/>
                    </div>
                    <div class="form-group col-lg-4">
                        <p>Senha</p>
                        <input name="senha" class="form-control" required="true"/><br/>
                    </div>
                </div>
                <button type="submit" style="float: right; width: 100px; margin-bottom: 30px" class="btn btn-primary"><strong>Salvar</strong></button>
            </form>
        </div>
    </body>
</html>
