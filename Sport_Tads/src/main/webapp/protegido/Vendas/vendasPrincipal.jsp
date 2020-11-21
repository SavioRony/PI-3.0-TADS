<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>

<!DOCTYPE html>
<html>
    <%@include file="../../header.jsp" %>

    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Realizar Vendas</title>


        <script lang="text/javascript">

            
            function adicionarClienteNaSessao() {
                
                var cpf = document.getElementById("cpf").value;
                $.get("/BuscarClientePrincipal?cpf="+ cpf , function() {
                    location.reload();
                });
            }



        </script>
    </head>
    <style>
        body {
            background: #eeeeee;
        }
        .panel {
            display: inline-block;
            background: #ffffff;
            /*            min-height: 100px;*/
            /*            height: 100px;*/
            box-shadow:0px 0px 5px 5px #C9C9C9;
            -webkit-box-shadow:2px 2px 5px 5x #C9C9C9;
            -moz-box-shadow:2px 2px 5px 5px #C9C9C9;
            margin: 10px;
            padding: 25px;
            width: 100%;
        }
        /*     .panel1 {
               min-width: 100px;
               width: 100px;
           }
           .panel2 {
               min-width: 245px;
               width: 245px;
           }*/
    </style>
    <body>
        <%@include file="../../cabecalho.jsp" %>
        <div class="container">
            <h1 style="text-align: center; margin-top: 50px; margin-bottom: 50px">Vendas</h1>
            <div class="row">
                <div class="form-group col-lg-6">
                    <div class="panel panel1">
                        <h3 style="text-align: center">Dados Vendedor</h3>
                        <div class="row">

                        </div>
                        <div>
                            <p>Nome: ${sessionScope.colaborador.nome} </p>
                            <p>CPF: ${sessionScope.colaborador.cpf}</p>
                            <p>Código Filial: ${sessionScope.colaborador.codFilial} </p>
                            <p>&nbsp</p>
                        </div>
                    </div>
                </div>
                <div class="form-group col-lg-6">
                    <div class="panel panel1">
                        <h3 style="text-align: center">Selecionar Cliente</h3>
                        <div class="row">

                            <div class="form-group col-lg-10">
                                <div class="input-group mb-8">
                                    <input type="text" id="cpf" class="form-control" placeholder="CPF Cliente" >
                                    <div class="input-group-append">
                                        <button type="button" class="btn btn-primary" onclick="adicionarClienteNaSessao()">Buscar</button>

                                    </div>
                                </div>
                            </div>

                        </div>
                        <div>
                            <p>Nome: ${sessionScope.cliente.nome}</p>
                            <p>CPF: ${sessionScope.cliente.cpf}</p>
                            <p>Telefone: ${sessionScope.cliente.celular}</p>
                            <p>E-mail: ${sessionScope.cliente.email}</p>
                        </div>
                    </div>
                </div>

            </div>
            <div class="row">
                <div class="form-group col-lg-12">
                    <div class="panel">
                        <h3 style="text-align: center">Carrinho</h3>
                        <form action="buscarCliente">
                            <div class="form-group col-lg-4" style="float: right">
                                <div class="input-group mb-3">
                                    <input name="codigoProduto" class="form-control" placeholder="Código Produto" aria-describedby="button-addon2">
                                    <div class="input-group-append">
                                        <button class="btn btn-primary" type="submit" id="button-addon2">Buscar</button>
                                    </div>
                                </div>
                            </div>
                        </form>
                        <table class="table">
                            <thead class="thead-light">
                                <tr>
                                    <th>Produto</th>
                                    <th>Quantidade</th>
                                    <th>Valor Unitário</th>
                                    <th>Total</th>
                                    <th style="text-align: center">Ações</th>
                                </tr>
                            </thead>
                            <tbody>
                                <tr>
                                    <td>Bola</td>
                                    <td>10</td>
                                    <td>R$ 50,00</td>
                                    <td>R$ 500,00</td>
                                    <td class="actions">
                                        <button class="btn btn-default">
                                            <svg width="1em" height="1em" viewBox="0 0 16 16" class="bi bi-pencil-fill" fill="currentColor" xmlns="http://www.w3.org/2000/svg">
                                            <path fill-rule="evenodd" d="M12.854.146a.5.5 0 0 0-.707 0L10.5 1.793 14.207 5.5l1.647-1.646a.5.5 0 0 0 0-.708l-3-3zm.646 6.061L9.793 2.5 3.293 9H3.5a.5.5 0 0 1 .5.5v.5h.5a.5.5 0 0 1 .5.5v.5h.5a.5.5 0 0 1 .5.5v.5h.5a.5.5 0 0 1 .5.5v.207l6.5-6.5zm-7.468 7.468A.5.5 0 0 1 6 13.5V13h-.5a.5.5 0 0 1-.5-.5V12h-.5a.5.5 0 0 1-.5-.5V11h-.5a.5.5 0 0 1-.5-.5V10h-.5a.499.499 0 0 1-.175-.032l-.179.178a.5.5 0 0 0-.11.168l-2 5a.5.5 0 0 0 .65.65l5-2a.5.5 0 0 0 .168-.11l.178-.178z"/>
                                            </svg>
                                        </button>
                                        <button class="btn btn-default">
                                            <svg width="1em" height="1em" viewBox="0 0 16 16" class="bi bi-trash-fill" fill="currentColor" xmlns="http://www.w3.org/2000/svg">
                                            <path fill-rule="evenodd" d="M2.5 1a1 1 0 0 0-1 1v1a1 1 0 0 0 1 1H3v9a2 2 0 0 0 2 2h6a2 2 0 0 0 2-2V4h.5a1 1 0 0 0 1-1V2a1 1 0 0 0-1-1H10a1 1 0 0 0-1-1H7a1 1 0 0 0-1 1H2.5zm3 4a.5.5 0 0 1 .5.5v7a.5.5 0 0 1-1 0v-7a.5.5 0 0 1 .5-.5zM8 5a.5.5 0 0 1 .5.5v7a.5.5 0 0 1-1 0v-7A.5.5 0 0 1 8 5zm3 .5a.5.5 0 0 0-1 0v7a.5.5 0 0 0 1 0v-7z"/>
                                            </svg>
                                        </button>
                                    </td>
                                </tr>
                            </tbody>
                        </table>
                        <button type="submit" style="float: right; width: 100px; margin-bottom: 30px" class="btn btn-primary">Salvar</button>
                    </div>
                </div>
            </div>
        </div>
    </div>
</body>
</html>