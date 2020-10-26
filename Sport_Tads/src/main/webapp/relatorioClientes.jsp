<%-- 
    Document   : relatorioFiliais
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
    <body>
        <%@include file="cabecalho.jsp" %>
        <div class="container">
            <h1 style="text-align: center; margin-top: 50px; margin-bottom: 50px">Vendas por Cliente</h1>
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
                        <th style="text-align: center">Código Venda</th>
                        <th style="text-align: center">Data da compra</th>
                        <th style="text-align: center">CPF Cliente</th>
                        <th style="text-align: center">Nome Cliente</th>
                        <th style="text-align: center">Código Produto</th>
                        <th style="text-align: center">Nome Produto</th>
                        <th style="text-align: center">Quantidade</th>
                        <th style="text-align: center">Valor Produto</th>
                        <th style="text-align: center">Sub-Total</th>
                        <th style="text-align: center">Valor Total</th>                       
                    </tr>
                </thead>
                <tbody>
                 <c:forEach var="relatorioCliente" items="${listaClientes}">              
                        <tr class="table-light">
                            <th scope="row" style="text-align: center">${relatorioCliente.codVenda}</th>
                            <td style="text-align: center">${relatorioCliente.dataVenda}</td>
                            <td style="text-align: center">${relatorioCliente.cpfCliente}</td>
                            <td style="text-align: center">${relatorioCliente.nomeCliente}</td>
                            <td style="text-align: center">${relatorioCliente.codProduto}</td>
                            <td style="text-align: center">${relatorioCliente.nomeProduto}</td>
                            <td style="text-align: center">${relatorioCliente.quantidade}</td>
                            <td style="text-align: center">${relatorioCliente.valorProduto}</td>
                            <td style="text-align: center">${relatorioCliente.subTotal}</td>
                            <td style="text-align: center">${relatorioCliente.valorTotal}</td>               
                        </tr>
                    </c:forEach>
                </tbody>
            </table>
        </div>
    </body>
</html>
