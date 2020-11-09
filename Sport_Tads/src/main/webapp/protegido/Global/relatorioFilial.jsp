<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <%@include file="../../header.jsp" %>
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
        <%@include file="../../cabecalho.jsp" %>
        <div class="container">
            <h1>Faturamento por Filial</h1>
            <table class="table">
                <thead class="thead-light">
                    <tr>
                        <th>ID Filial</th>
                        <th>Nome</th>
                        <th>Quantidade de Vendas</th>
                        <th>Total Faturado</th>
                    </tr>
                </thead>
                
                
         
                
                
                
                
<!--     
         Relatório de venda por filial -> Pesquisar por período de datas 
         e permitir selecionar a filial. Campos: código da venda , nome 
         do cliente, cpf do cliente,  data da venda e valor total da venda.

-->                
                
                
                
                
                
                
                
                <tbody>
                    <c:forEach var="filial" items="${listaFiliais}">
                        <tr class="table-light">
                            <td>${filial.codFilial}</td>
                            <td>${filial.nomeFilial}</td>
                            <td>${filial.quantidade}</td>
                            <td>R$ ${filial.totalFaturado}</td>
                        </tr>
                    </c:forEach>
                </tbody>
            </table>
        </div>
    </body>
</html>
