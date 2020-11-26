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
            <h1>Relatório Consolidado de Vendas Por Filial</h1>
            <form action="<c:url value="/RelatorioConsolidadoVendasPorFilial"/>" method="GET">
                <div class="row">
                    <div class="form-group col-lg-3">
                        <p>Data inicial</p>
                        <input type="date" name="dataInicio" class="form-control" required="true"/>
                    </div>
                    <div class="form-group col-lg-3">
                        <p>Data final</p>
                        <input type="date" name="dataFinal" class="form-control" required="true"/>             
                    </div>
                    <div class="form-group col-lg-3">
                        <p>&nbsp;</p>
                        <button type="submit" class="btn btn-primary">Salvar</button>
                    </div> 
                </div>
                </br>
            </form>
            <table class="table">
                <thead class="thead-light">
                    <tr>
                        <th>ID Filial</th>
                        <th>Nome</th>
                        <th>Data Venda</th>
                        <th>Quantidade</th>
                        <th>Total</th>
                        <th>Percentual</th>                        
                    </tr>
                </thead>
                <tbody>
                    <c:forEach var="filial" items="${listaFiliais}">
                        <tr class="table-light">
                            <td>${filial.codFilial}</td>
                            <td>${filial.nomeFilial}</td>
                            <td>${filial.dataVenda}</td>
                            <td>${filial.quantidade}</td>
                            <td>R$ ${filial.subTotal}</td>
                            <td>${filial.percentual}%</td>
                        </tr>
                    </c:forEach>
                </tbody>
            </table>
                <h3><b>Total:</b> R$ ${totalFaturado} </h3> 
        </div>
    </body>
</html>