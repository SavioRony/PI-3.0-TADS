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
        p{
            font-weight: bolder;
            font-size: 18px;
        }
        div .row{
            justify-content: flex-end;
            margin-right: auto;
        }
        #btn-pesquisar{
            margin-left: 15px;
        }
    </style>
    <script>
        $(document).ready(function () {

            $("#btn-pesquisar").click(function () {
                var dataInicial = $("input[name='dataInicio']").val();
                var dataFinal = $("input[name='dataFinal']").val();
                var dataAtual = moment().format("YYYY-MM-DD");

                if (dataInicial > dataAtual || dataFinal > dataAtual) {
                    $.notify("Data inicial e final não podem ser superior a Data atual!", "error");
                    return false;
                }
                if (dataInicial > dataFinal) {
                    $.notify("Data final não pode ser inferior a Data inicial!", "error");
                    return false;
                }
                return true;
            });
        });
    </script>
    <body>
        <%@include file="../../cabecalho.jsp" %>
        <div class="container">
            <h1>Relatório Consolidado de Vendas Por Filial</h1>
            <form action="<c:url value="/RelatorioConsolidadoVendasPorFilial"/>" method="GET" onsubmit="$(\"#btn-pesquisar\").click()">
                <div class="row">
                    <div class="form-group col-lg-3">
                        <p>Data inicial</p>
                        <input type="date" name="dataInicio" class="form-control" required="true"/>
                    </div>
                    <div class="form-group col-lg-3">
                        <p>Data final</p>
                        <input type="date" name="dataFinal" class="form-control" required="true"/>             
                    </div>
                    <div class="form-group">
                        <p>&nbsp;</p>
                        <button type="submit" id="btn-pesquisar" class="btn btn-primary">Pesquisar</button>
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
                            <td>R$ ${filial.valorTotal}</td>
                            <td>${filial.percentual}%</td>
                        </tr>
                    </c:forEach>
                </tbody>
            </table>
            <br/>
            <h3 style="float: right">Total: R$ ${totalFaturado} </h3> 
        </div>
    </body>
</html>