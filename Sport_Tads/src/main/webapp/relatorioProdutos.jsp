<%-- 
    Document   : relatorioProdutos
    Created on : Out 22, 2020, 19:30
    Author     : Hugo Souza Araujo
--%>

<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <%@include file="header.jsp" %>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Relatório de Produtos</title>
    </head>
    <body>
        <%@include file="cabecalho.jsp" %>
        <div class="container">
            <h1 style="text-align: center; margin-top: 50px; margin-bottom: 50px">Top 10 Produtos mais vendidos</h1>
            
            <table class="table" >
                <thead class="thead-light">
                    <tr>
                        <th style="text-align: center">Código Produto</th>
                        <th style="text-align: center">Nome</th>
                        <th style="text-align: center">Marca</th>
                        <th style="text-align: center">Valor Unitário</th>
                        <th style="text-align: center">Quantidade</th>
                        <th style="text-align: center">Total</th>
                    </tr>
                </thead>
                <tbody>
                    <c:forEach var="produto" items="${listaProd}">
                    <tr class="table-light">
                       
                        <td scope="row" style="text-align: center">${produto.codProduto}</td>
                        <td style="text-align: center">${produto.nomeProduto}</td>
                        <td style="text-align: center">${produto.marcaProduto}</td>
                        <td style="text-align: center">R$ ${produto.valorProduto}</td>
                        <td style="text-align: center">${produto.quantidade}</td>
                        <td style="text-align: center">R$ ${produto.valorTotal}</td>
                        
                    </tr> 
                     </c:forEach>
                                  
                </tbody>
            </table>
            <a href="RelatorioProdutosMaisVendidos">
        </div>
    </body>
</html>
