<%@page import="java.text.DecimalFormat"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <%@include file="../../header.jsp" %>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Vendas</title>
    </head>
    <style>
        body {
            background: #eeeeee;
        }
        .panel {
            display: inline-block;
            background: #ffffff;
            -webkit-box-shadow: -1px -1px 1px #C9C9C9, 1px 1px 1px #C9C9C9;
            margin: 10px;
            padding: 25px;
            width: 100%;
        }
        h5{
            margin-left: 10px;
        }
        .panel1{
            height: 360px;
        }
        h3{
            padding: 10px;
            text-align: center;
        }
        table{
            text-align: center;
        }
    </style>
    <script lang="text/javascript">
        function deletaProdutoCarrinho(i) {
            $.get("VendaRemoverProdutoCarrinho?linha=" + i, function () {
                location.reload();
            });
        }

        function BuscarProduto() {
            var id = document.getElementById("idProduto").value;
            $.get("VendaPesquisaProduto?idProduto=" + id, function () {
                location.reload();
            });
        }

        function BuscarCliente() {
            var cpf = document.getElementById("cpf").value;
            $.get("VendaPesquisarCliente?cpf=" + cpf, function () {
                location.reload();
            });
        }

        function AdicionarProduto() {
            var quant = document.getElementById("quantidade").value;
            $.get("VendaAdicionarProdutoCarrinho?quantidade=" + quant, function () {
                location.reload();
            });
        }
        $(document).ready(function () {
            var valor = $("#input-valor-total").val() === "" ? "0.00" : parseFloat($("#input-valor-total").val()).toFixed(2);
            $("#h3-total").html("Valor Total: R$ " + valor).text();
        });
    </script>
    <body>
        <%@include file="../../cabecalho.jsp" %>
        <h1 style="text-align: center; margin-top: 50px; margin-bottom: 50px">Vendas</h1>
        <div class="container">
            <h5><b>Vendedor(a):</b> ${sessionScope.colaborador.nome} </h5>
            <h5><b>Filial:</b> ${sessionScope.colaborador.codFilial} </h5>
            <div class="row">
                <div class="form-group col-lg-6">
                    <div class="panel panel1">
                        <h3>Cliente</h3>
                        <div class="row" style="flex-flow: row-reverse">
                            <div class="form-group col-lg-8">
                                <div class="input-group mb-6">
                                    <input type="text" id="cpf" class="form-control" placeholder="CPF (000.000.000-00)" aria-describedby="button-addon2">
                                    <div class="input-group-append">
                                        <button class="btn btn-primary" type="button" id="button-addon2" onclick="BuscarCliente()">Buscar</button>
                                    </div>
                                </div>
                            </div>
                        </div>
                        <br/>
                        <div>
                            <p><b>CPF:</b> ${sessionScope.cliente.cpf}</p>
                            <p><b>Nome:</b> ${sessionScope.cliente.nome}</p>
                            <p><b>Email:</b> ${sessionScope.cliente.email}</p>
                            <p><b>Celular:</b> ${sessionScope.cliente.celular}</p>
                        </div>
                    </div>
                </div>
                <div class="form-group col-lg-6">
                    <div class="panel panel1">
                        <h3>Produto</h3>
                        <div class="row" style="flex-flow: row-reverse">
                            <div class="form-group col-lg-6">
                                <div class="input-group mb-6">
                                    <input name="idProduto" id="idProduto" type="text" class="form-control" placeholder="ID Produto" aria-describedby="button-addon2">
                                    <div class="input-group-append">
                                        <button class="btn btn-primary" type="button" id="button-addon2" onclick="BuscarProduto()">Buscar</button>
                                    </div>
                                </div>
                            </div>
                        </div>
                        <div>
                            <p><b>Código Produto:</b> ${sessionScope.produto.codProduto}</p>
                            <p><b>Nome do Produto:</b> ${sessionScope.produto.nomeProduto} </p>
                            <p><b>Preço:</b> R$ ${sessionScope.produto.valorProduto}</p>
                            <p><b>Quantidade em estoque:</b> ${sessionScope.produto.quantidadeEmEstoque}</p>
                        </div>
                        <input type="hidden" id="qtd-estoque" value="${sessionScope.produto.quantidadeEmEstoque}"/>
                        <div class="row" style="flex-flow: row-reverse">
                            <div class="form-group col-lg-6" style="float: right">
                                <div class="input-group mb-10">
                                    <input id="quantidade" type="text" name="quantidade" class="form-control" placeholder="Quantidade" aria-describedby="button-addon2">
                                    <div class="input-group-append">
                                        <button type="button" class="btn btn-primary" onclick="AdicionarProduto()">Adicionar</button>
                                    </div>
                                </div>
                            </div>
                        </div>
                    </div>
                </div>  
            </div>
            <div class="row">
                <div class="form-group col-lg-12">
                    <div class="panel">
                        <h3 style="text-align: center">Carrinho</h3>
                        <table class="table" id="myTable">
                            <thead class="thead-light">
                                <tr>
                                    <th>ID</th>
                                    <th>Produto</th>
                                    <th>Marca</th>
                                    <th>Valor Unitário</th>
                                    <th>Quantidade</th>
                                    <th>Sub-Total</th>
                                    <th style="text-align: center">Ações</th>
                                </tr>
                            </thead>
                            <tbody>
                                <c:forEach var="produto" items="${sessionScope.listaCarrinho}" >
                                    <tr>    
                                        <td>${produto.codProduto}</td>
                                        <td>${produto.nomeProduto}</td>
                                        <td>${produto.marcaProduto}</td>
                                        <td>${produto.valorProduto}</td>
                                        <td>${produto.quantidade}</td>
                                        <td>${produto.subTotal}</td>
                                        <td class="actions" >
                                            <button type="submit" onclick="deletaProdutoCarrinho(this.parentNode.parentNode.rowIndex)" class="btn btn-default">
                                                <svg width="1em" height="1em" viewBox="0 0 16 16" class="bi bi-trash-fill" fill="currentColor" xmlns="http://www.w3.org/2000/svg">
                                                <path fill-rule="evenodd" d="M2.5 1a1 1 0 0 0-1 1v1a1 1 0 0 0 1 1H3v9a2 2 0 0 0 2 2h6a2 2 0 0 0 2-2V4h.5a1 1 0 0 0 1-1V2a1 1 0 0 0-1-1H10a1 1 0 0 0-1-1H7a1 1 0 0 0-1 1H2.5zm3 4a.5.5 0 0 1 .5.5v7a.5.5 0 0 1-1 0v-7a.5.5 0 0 1 .5-.5zM8 5a.5.5 0 0 1 .5.5v7a.5.5 0 0 1-1 0v-7A.5.5 0 0 1 8 5zm3 .5a.5.5 0 0 0-1 0v7a.5.5 0 0 0 1 0v-7z"/>
                                                </svg>
                                            </button>
                                        </td>
                                    </tr>
                                </c:forEach>
                            </tbody>
                        </table>
                        <h3 id="h3-total" style="text-align: center; margin-top: 20px; margin-bottom: 20px"></h3>
                        <input type="hidden" id="input-valor-total" value="${valorTotal}"/>
                    </div>
                    <form action="FinalizarVenda" method="POST">
                        <br/>
                        <button type="submit" style="float: right; width: 100px; margin-right: -15px" class="btn btn-primary">Finalizar</button>
                    </form>
                </div>
            </div>
        </div>
    </body>
</html>