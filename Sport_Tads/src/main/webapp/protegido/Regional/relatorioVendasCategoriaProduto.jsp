<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <%@include file="../../header.jsp" %>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Relatório de Vendas Por Categoria de Produtos</title>
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
            <h1>Relatório de Vendas Por Categoria de Produtos</h1>
            <form action="<c:url value="/RelatorioVendasCategoriaProduto"/>" method="GET">
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
                        <p>Categoria</p>
                        <select name="categoria"class="browser-default custom-select" required="true">
                            <option value="" disabled selected>Selecione</option>
                            <option value="Basquete">Basquete</option>
                            <option value="Futebol">Futebol</option>
                        </select>
                    </div>
                    <div class="form-group col-lg-3">
                        <p>&nbsp;</p>
                        <button type="submit" class="btn btn-primary">Pesquisar</button>
                    </div> 
                </div>
                <input type="hidden" name="codFilial" value="${sessionScope.colaborador.codFilial}"/>
                </br>
            </form>
            <table class="table">
                <thead class="thead-light">
                    <tr>
                        <th>ID</th>
                        <th>Nome</th>
                        <th>Marca</th>
                        <th>Categoria</th>
                        <th>Valor Unitário</th>
                        <th>Quantidade</th>
                        <th>Data Venda</th>
                        <th>Total</th>
                    </tr>
                </thead>
                <tbody>
                    <c:forEach var="produto" items="${listaProd}">
                        <tr class="table-light">                       
                            <td>${produto.codProduto}</td>
                            <td>${produto.nomeProduto}</td>
                            <td>${produto.marcaProduto}</td>
                            <td>${produto.categoriaProduto}</td>
                            <td>R$ ${produto.valorProduto}</td>
                            <td>${produto.quantidade}</td>
                            <td>${produto.dataVenda}</td>
                            <td>R$ ${produto.valorTotal}</td>                        
                        </tr> 
                    </c:forEach>                                  
                </tbody>
            </table>
        </div>
    </body>
</html>