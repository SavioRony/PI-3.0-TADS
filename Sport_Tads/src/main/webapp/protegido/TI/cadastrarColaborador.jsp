<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <%@include file="../../header.jsp" %>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Cadastrar Colaborador</title>
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
            <h1>Cadastro de Colaborador</h1>
            <form action=" <c:url value="/CadastrarColaborador"/>" method="POST">
                <div class="row">
                    <div class="form-group col-lg-8">
                        <p>Nome</p>
                        <input name="nome" onkeypress="return event.charCode >= 65 && event.charCode <= 90 || event.charCode >= 97 && event.charCode <= 122" class="form-control" required="true"/>
                    </div>
                    <div class="form-group col-lg-4">
                        <p>CPF</p>
                        <input name="cpf" onkeypress="return event.charCode >= 48 && event.charCode <= 57" class="form-control" required="true"/>
                    </div>
                </div>
                <br/>
                <div class="row">
                    <div class="form-group col-lg-6">
                        <p>Endereço</p>
                        <input name="endereco" class="form-control" required="true"/>
                    </div>
                    <div class="form-group col-lg-2">
                        <p>Número</p>
                        <input name="numero" onkeypress="return event.charCode >= 48 && event.charCode <= 57" class="form-control" required="true"/>
                    </div>
                    <div class="form-group col-lg-4">
                        <p>CEP</p>
                        <input name="cep" onkeypress="return event.charCode >= 48 && event.charCode <= 57" class="form-control" required="true"/>
                    </div>
                </div>
                <br/>
                <div class="row">
                    <div class="form-group col-lg-6">
                        <p>Cidade</p>
                        <input name="cidade" onkeypress="return event.charCode >= 65 && event.charCode <= 90 || event.charCode >= 97 && event.charCode <= 122" class="form-control" required="true"/>
                    </div>
                    <div class="form-group col-lg-6">
                        <p>Cargo</p>
                        <input name="cargo" onkeypress="return event.charCode >= 65 && event.charCode <= 90 || event.charCode >= 97 && event.charCode <= 122" class="form-control" required="true"/>
                    </div>
                </div>
                <br/>
                <div class="row">
                    <div class="form-group col-lg-6">
                        <p>Usuario</p>
                        <input name="usuario" class="form-control" required="true"/>
                    </div>
                    <div class="form-group col-lg-3">
                        <p>Senha</p>
                        <input type="password" name="senha" class="form-control" required="true"/>
                    </div>
                    <div class="form-group col-lg-3">
                        <p>Perfil</p>
                        <select name="perfil" class="browser-default custom-select" required="true">
                            <option value="" disabled selected>Selecione</option>
                            <option value="GLOBAL">Global</option>
                            <option value="REGIONAL">Regional</option>
                            <option value="VENDAS">Vendas</option>
                            <option value="TI">TI</option>
                            <option value="BACKOFFICE">BackOffice</option>
                        </select>
                    </div>
                </div>
                <br/>
                <input name="filial" type="hidden" value="${sessionScope.colaborador.codFilial}" class="form-control" required="true"/>
                <button type="submit" style="float: right; margin-bottom: 30px" class="btn btn-primary">Salvar</button>
            </form>
        </div>
    </body>
</html>