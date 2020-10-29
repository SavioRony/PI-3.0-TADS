<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <%@include file="header.jsp" %>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Relatório de Produtos</title>
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
            <h1>Top 10 Produtos mais vendidos</h1>
            <table class="table">
                <thead class="thead-light">
                    <tr>
                        <th>ID</th>
                        <th>Nome</th>
                        <th>Marca</th>
                        <th>Valor Unitário</th>
                        <th>Quantidade</th>
                        <th>Total</th>
                    </tr>
                </thead>
                <tbody>
                    <c:forEach var="produto" items="${listaProd}">
                        <tr class="table-light">                       
                            <td>${produto.codProduto}</td>
                            <td>${produto.nomeProduto}</td>
                            <td>${produto.marcaProduto}</td>
                            <td>R$ ${produto.valorProduto}</td>
                            <td>${produto.quantidade}</td>
                            <td>R$ ${produto.valorTotal}</td>                        
                        </tr> 
                    </c:forEach>                                  
                </tbody>
            </table>
        </div>
    </body>
</html>
