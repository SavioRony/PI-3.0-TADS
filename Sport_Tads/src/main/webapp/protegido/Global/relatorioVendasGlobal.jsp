<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <%@include file="../../header.jsp" %>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Relatório de Vendas Por Filial</title>
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
            <h1>Relatório de Vendas Por Filial</h1>
            <form action="<c:url value="/RelatorioVendasGlobal"/>" method="GET">
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
                        <p>Código Filial</p>
                        <input type="text" name="codFilial" class="form-control" required="true"/>
                    </div>
                    <div class="form-group col-lg-3">
                        <p>&nbsp;</p>
                        <button type="submit" class="btn btn-primary">Pesquisar</button>
                    </div>
                </div>
                </br>
            </form>
            <table class="table">
                <thead class="thead-light">
                    <tr>
                        <th>ID</th>
                        <th>Data Venda</th>
                        <th>CPF Cliente</th>
                        <th>ID Vendedor</th>
                        <th>Nome Vendedor</th>
                        <th>ID Produto</th>
                        <th>Qtd.</th>
                        <th>Total</th>
                    </tr>
                </thead>
                <tbody>
                    <c:forEach var="relatorioGlobal" items="${vendas}">              
                        <tr class="table-light">
                            <td>${relatorioGlobal.codVenda}</td>
                            <td>${relatorioGlobal.dataVenda}</td>
                            <td>${relatorioGlobal.cpfCliente}</td>
                            <td>${relatorioGlobal.codVendedor}</td>
                            <td>${relatorioGlobal.nomeCliente}</td>
                            <td>${relatorioGlobal.codProduto}</td>
                            <td>${relatorioGlobal.quantidade}</td>
                            <td>${relatorioGlobal.valorTotal}</td>
                        </tr>
                    </c:forEach>
                </tbody>
            </table>
            <br/>
            <div class="form-inline" style="float:right">
                <h6>Total: &nbsp</h6>
                <input style="width: 200px; text-align: center" name="valorTotal" 
                       class="form-control" value="R$ " id="valorTotal" readonly="true">
            </div>
        </div>
    </body>
</html>