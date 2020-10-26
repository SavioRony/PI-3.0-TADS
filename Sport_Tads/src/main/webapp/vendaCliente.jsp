<%-- 
    Document   : telaVendas
    Created on : 20/10/2020, 17:34:54
    Author     : Fernando
--%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<%@include file="header.jsp" %>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title style="text-align: center">Gerar Pedido</title>

    </head>
    <body class="container">

        <h1 style="text-align: center">Gerar Pedido</h1>
        <form action="VendaPesquisarCliente" method="GET">
            <h3>Cliente</h3>
            <div class="form-group col-lg-4" >
                <div class="input-group mb-3">
                    <input name="cpf" class="form-control" placeholder="CPF Cliente" aria-describedby="button-addon2">
                    <div class="input-group-append">
                        <button class="btn btn-secondary" type="submit" id="button-addon2">Buscar</button>
                    </div>
                </div>
            </div>   
            <c:forEach var="cliente" items="${listaCliente}"> 
                <b>CPF: </b>${cliente.cpf}<br>
                <b>Nome: </b>${cliente.nome}<br>
            </c:forEach>
            
        </form>
        <form action="VendaPesquisarCliente" method="POST">
             <c:forEach var="cliente" items="${listaCliente}"> 
                 <input type="hidden" name="cpf" value="${cliente.cpf}">
            </c:forEach>
            <button type="submit" class="btn btn-primary">Avança</button>
        </form>    
    </body>
</html>