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
        <title>Relatório de Filiais</title>
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
            <h1>Faturamento/Vendas Mensal por Filial</h1>
            <table class="table">
                <thead class="thead-light">
                    <tr>
                        <th>Código Filial</th>
                        <th>Nome</th>
                        <th>Quantidade de Vendas</th>
                        <th>Total Faturado</th>
                    </tr>
                </thead>
                <tbody>
                    <tr>
                        <td>147258</td>
                        <td>Filial Dubai</td>
                        <td>550</td>
                        <td>R$ 125.458,05</td>
                    </tr>
                </tbody>
            </table>
        </div>
    </body>
</html>
