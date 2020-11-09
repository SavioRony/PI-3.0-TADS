<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<%@include file="../../header.jsp" %>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title style="text-align: center">Gerar Pedido</title>
    </head>
    <style>
        body {
            background: #eeeeee;
        }
        .panel {
            background: #ffffff;
            width: 400px;
            height: 270px;
            box-shadow:0px 0px 2px 2px #C9C9C9;
            margin: 10px;
            padding: 10px;
            text-align: initial;
        }
        b{
            margin-left: 15px;
            padding: 5px;
        }
    </style>
    <body>
        <%@include file="../../cabecalho.jsp" %>
        <div class="container">
            <h1 style="text-align: center; margin-top: 50px; margin-bottom: 50px">Gerar Pedido</h1>
            <center>
                <div class="panel">
                    <form action="<c:url value="/VendaPesquisarCliente"/>" method="GET">
                        <h3 style="text-align: center; margin-bottom: 20px; margin-top: 20px">Cliente</h3>
                        <div class="form-group col-lg-12" >
                            <div class="input-group mb-3">
                                <input name="cpf" class="form-control" placeholder="CPF Cliente" aria-describedby="button-addon2">
                                <div class="input-group-append">
                                    <button class="btn btn-primary" type="submit" id="button-addon2">Buscar</button>
                                </div>
                            </div>
                        </div>   
                        <c:forEach var="cliente" items="${listaCliente}"> 
                            <b>CPF: </b>${cliente.cpf}<br>
                            <b>Nome: </b>${cliente.nome}<br>
                        </c:forEach>
                    </form>
                    <br/>
                    <form action="VendaPesquisarCliente" method="POST">
                        <c:forEach var="cliente" items="${listaCliente}"> 
                            <input type="hidden" name="cpf" value="${cliente.cpf}">
                        </c:forEach>
                        <button type="submit" class="btn btn-primary" style="float: right; margin-right: 15px">Avançar</button>
                    </form> 
                </div>
            </center>
        </div>
    </body>
</html>