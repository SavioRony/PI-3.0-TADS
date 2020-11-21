<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <%@include file="../../header.jsp" %>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Vendas</title>
        <script lang="text/javascript">
            function deletaProdutoCarrinho(i) {
                $.get("VendaRemoveProdutoCarrinho?linha=" + i, function () {
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
        </script>
    </head>
    <style>
        body {
            background: #eeeeee;
        }
        .panel {
            display: inline-block;
            background: #ffffff;
            box-shadow:0px 0px 5px 5px #C9C9C9;
            -webkit-box-shadow:2px 2px 5px 5x #C9C9C9;
            -moz-box-shadow:2px 2px 5px 5px #C9C9C9;
            margin: 10px;
            padding: 25px;
            width: 100%;
        }
    </style>
    <body>
        <%@include file="../../cabecalho.jsp" %>
        <div class="container">
            <h1 style="text-align: center; margin-top: 50px; margin-bottom: 50px">Vendas</h1>
            <h5><b>Vendedor:</b> ${sessionScope.colaborador.nome} </h5>
            <h5><b>Filial:</b> ${sessionScope.colaborador.codFilial} </h5>
            
            <div class="row">
                <div class="form-group col-lg-6">
                    <div class="panel panel1">
                        <h3 style="text-align: center">Cliente</h3>
                        <div class="row">
                            <form action="BuscarCliente" method="GET">
                                <div class="form-group col-lg-10">
                                    <div class="input-group mb-8">
                                        <input type="text" id="cpf" class="form-control" placeholder="CPF" aria-describedby="button-addon2">
                                        <div class="input-group-append">
                                            <button class="btn btn-primary" type="button" id="button-addon2" onclick="BuscarCliente()">Buscar</button>
                                        </div>
                                    </div>
                                </div>
                            </form>
                        </div>
                        <div>
                            <p><b>CPF:</b> ${sessionScope.cliente.cpf}</p>
                            <p><b>Nome:</b> ${sessionScope.cliente.nome}</p>
                            <p><b>Email:</b> ${sessionScope.cliente.email}</p>
                            <p><b>Celular:</b> ${sessionScope.cliente.celular}</p>
                            </br>
                        </div>
                    </div>
                </div>
                <div class="form-group col-lg-6">
                    <div class="panel panel1">
                        <h3 style="text-align: center">Produto</h3>
                        <div class="row">
                                <div class="form-group col-lg-10">
                                    <div class="input-group mb-8">
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
                        <h3 style="text-align: center; margin-top: 20px; margin-bottom: 20px"><b>Valor Total: R$ </b>${valorTotal} </h3>
                    </div>
                    <a href="index.jsp"/>Voltar</a>
                    <form action="FinalizarVenda" method="POST">  
                        <button type="submit" style="float: right; width: 100px; margin-bottom: 30px" class="btn btn-primary">Finalizar</button>
                    </form>    
                </div>
            </div>
        </div>
    </div>
</body>
</html>