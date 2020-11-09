<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <%@include file="../../header.jsp" %>
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
    <script>
        $(function () {
            var valorCalculado = 0;
            $(".valor-calculado").each(function () {
                valorCalculado += parseFloat($(this).text());
            });
            document.getElementById('valorTotal').value = valorCalculado;
        });
    </script>
    <body>
        <%@include file="../../cabecalho.jsp" %>
        <div class="container">
            <h1>Vendas por Cliente</h1>
            <form action="RelatorioCliente">
                <div class="form-group col-lg-4" style="float: right; margin-right: -10px">
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
                        <th>ID Venda</th>
                        <th>Data da compra</th>
                        <th>Nome Cliente</th>
                        <th>Nome Produto</th>
                        <th>Quantidade</th>
                        <th>Valor Produto</th>
                        <th>Sub-Total</th>
                    </tr>
                </thead>
                <tbody>
                    <c:forEach var="relatorioCliente" items="${listaClientes}">              
                        <tr class="table-light">
                            <td>${relatorioCliente.codVenda}</td>
                            <td>${relatorioCliente.dataVenda}</td>
                            <td>${relatorioCliente.nomeCliente}</td>
                            <td>${relatorioCliente.nomeProduto}</td>
                            <td>${relatorioCliente.quantidade}</td>
                            <td>${relatorioCliente.valorProduto}</td>
                            <td class="valor-calculado">${relatorioCliente.subTotal}</td>
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
