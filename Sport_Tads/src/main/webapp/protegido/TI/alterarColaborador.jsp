<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <%@include file="../../header.jsp" %>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Alterar Colaborador</title>
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
        <%@include file="../../cabecalho.jsp"%>
        <div class="container">
            <h1>Editar dados do colaborador: ${colaborador.nome}</h1>

            <form action="<c:url value="/AlterarColaborador"/>" method="POST">
                <div class="row">
                    <div class="form-group col-lg-8">
                        <p>Nome Completo</p>
                        <input name="nome" class="form-control" value="${colaborador.nome}" required="true"/>
                    </div>
                    <div class="form-group col-lg-4">
                        <p>CPF</p>
                        <input name="cpf" class="form-control" value="${colaborador.cpf}" readonly="true"/>
                    </div>
                </div>
                <br/>
                <div class="row">
                    <div class="form-group col-lg-6">
                        <p>Endereço</p>
                        <input name="endereco" class="form-control" value="${colaborador.endereco}" required="true"/>
                    </div>
                    <div class="form-group col-lg-2">
                        <p>Número</p>
                        <input name="numero" class="form-control" value="${colaborador.numero}" required="true"/>
                    </div>
                    <div class="form-group col-lg-4">
                        <p>CEP</p>
                        <input name="cep" class="form-control" value="${colaborador.cep}" required="true"/>
                    </div>
                </div>
                <br/>
                <div class="row">
                    <div class="form-group col-lg-4">
                        <p>Cidade</p>
                        <input name="cidade" class="form-control" value="${colaborador.cidade}" required="true"/>
                    </div>
                    <div class="form-group col-lg-4">
                        <p>Cargo</p>
                        <input name="cargo" class="form-control" value="${colaborador.cargo}" required="true"/>
                    </div>
                    <div class="form-group col-lg-4">
                        <p>Filial</p>
                        <input name="filial" class="form-control" value="${colaborador.codFilial}" required="true"/>
                    </div>
                </div>
                <br/>
                <div class="row">
                    <div class="form-group col-lg-6">
                        <p>Usuario</p>
                        <input name="usuario" class="form-control" value="${colaborador.usuario}" readonly="true"/>
                    </div>
                    <div class="form-group col-lg-3">
                        <p>Senha</p>
                        <input type="password" name="senha" class="form-control" value="${colaborador.senha}" required="true"/>
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
                <button type="submit" style="float: right; margin-bottom: 30px" class="btn btn-primary">Salvar</button>
            </form>
        </div>
    </body>
</html>
