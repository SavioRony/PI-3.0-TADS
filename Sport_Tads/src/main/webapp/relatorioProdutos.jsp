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
                        <th>Código Produto</th>
                        <th>Nome</th>
                        <th>Marca</th>
                        <th>Valor Unitário</th>
                        <th>Quantidade</th>
                        <th>Total</th>
                    </tr>
                </thead>
                <tbody>
                    <tr>
                        <td>123456</td>
                        <td>Bola de Futebol</td>
                        <td>Nike</td>
                        <td>R$ 82,99</td>
                        <td>25</td>
                        <td>R$ 2.074,75</td>
                    </tr>
                </tbody>
            </table>
        </div>
    </body>
</html>
