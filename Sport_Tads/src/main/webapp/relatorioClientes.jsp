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
            <table class="table">
                <thead class="thead-light">
                    <tr>
                        <th>CPF</th>
                        <th>Nome</th>
                        <th>Quantidade de Vendas</th>
                        <th>Total</th>
                    </tr>
                </thead>
                <tbody>
                    <tr>
                        <td>47448617900</td>
                        <td>Arthur Gaspar da Silva Santos</td>
                        <td>100</td>
                        <td>R$ 25.325,19</td>
                    </tr>
                </tbody>
            </table>
        </div>
    </body>
</html>
