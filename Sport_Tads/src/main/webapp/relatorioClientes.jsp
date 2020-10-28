<%-- 
    Document   : relatorioClientes
    Created on : Out 22, 2020, 20:00
    Author     : Hugo Souza Araujo
--%>

<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <%@include file="header.jsp" %>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Relatório por Cliente</title>
    </head>
    <style>
        div h1{
            text-align: center;
            margin-bottom: 50px;
            margin-top: 50px;
        }
        table{
            text-align: center;
        }
    </style>
    <body>
        <%@include file="cabecalho.jsp" %>
        <div class="container">
            <h1>Vendas por Cliente</h1>
            <form action="RelatorioCliente">
                <div class="form-group col-lg-4" style="float: right">
                    <div class="input-group mb-3">
                        <input name="cpf" class="form-control" placeholder="CPF Cliente" aria-describedby="button-addon2">
                        <div class="input-group-append">
                            <button class="btn btn-primary" type="submit" id="button-addon2">Buscar</button>
                        </div>
                    </div>
                </div>
            </form>
            <table class="table">
                <thead class="thead-light">
                    <tr>
                        <th>Código Venda</th>
                        <th>Data da compra</th>
                        <th>CPF Cliente</th>
                        <th>Nome Cliente</th>
                        <th>Código Produto</th>
                        <th>Nome Produto</th>
                        <th>Quantidade</th>
                        <th>Valor Produto</th>
                        <th>Sub-Total</th>
                        <th>Valor Total</th>                       
                    </tr>
                </thead>
                <tbody>
                    <c:forEach var="relatorioCliente" items="${listaClientes}">              
                        <tr class="table-light">
                            <td>${relatorioCliente.codVenda}</td>
                            <td">${relatorioCliente.dataVenda}</td>
                            <td>${relatorioCliente.cpfCliente}</td>
                            <td>${relatorioCliente.nomeCliente}</td>
                            <td>${relatorioCliente.codProduto}</td>
                            <td>${relatorioCliente.nomeProduto}</td>
                            <td>${relatorioCliente.quantidade}</td>
                            <td>${relatorioCliente.valorProduto}</td>
                            <td>${relatorioCliente.subTotal}</td>
                            <td>${relatorioCliente.valorTotal}</td>               
                        </tr>
                    </c:forEach>
                </tbody>
            </table>
        </div>
    </body>
</html>
