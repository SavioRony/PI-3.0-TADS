<%-- 
    Document   : vendaFilial
    Created on : 25/10/2020, 12:27:21
    Author     : savio
--%>

<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<%@include file="header.jsp" %>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Venda Filial</title>
    </head>
    <body class="container">

        <h1 style="text-align: center">Gerar Pedido</h1>
        <form action="VendaPesquisarFilial" method="GET">
            <h3>Filial</h3>
            <div class="form-group col-lg-4" >
                <div class="input-group mb-3">
                    <input name="codFilial" class="form-control" placeholder="Codigo Filial" aria-describedby="button-addon2">
                    <div class="input-group-append">
                        <button class="btn btn-secondary" type="submit" id="button-addon2">Buscar</button>
                    </div>
                </div>
            </div>
            <input type="hidden" name="cpf" value="${cpf}"> 
            <c:forEach var="filial" items="${listaFilial}"> 
                <b>CPF: </b>${filial.codFilial}<br>
                <b>Nome: </b>${filial.nomeFilial}<br>
            </c:forEach>
        </form>
        
        <form action="VendaGerarPedido" method="POST">
                <input type="hidden" name="cpf" value="${cpf}">             
            <c:forEach var="filial" items="${listaFilial}"> 
                <input type="hidden" name="filial" value="${filial.codFilial}">
            </c:forEach>
            <button type="submit" class="btn btn-primary">Avança</button>
        </form> 

    </body>
</html>
