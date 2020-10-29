<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<%@include file="header.jsp" %>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Venda Filial</title>
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
        <%@include file="cabecalho.jsp" %>
        <div class="container">
            <h1 style="text-align: center; margin-top: 50px; margin-bottom: 50px">Gerar Pedido</h1>
            <center>
                <div class="panel">
                    <form action="VendaPesquisarFilial" method="GET">
                        <h3 style="text-align: center; margin-bottom: 20px; margin-top: 20px">Filial</h3>
                        <div class="form-group col-lg-12" >
                            <div class="input-group mb-3">
                                <input name="codFilial" class="form-control" placeholder="Codigo Filial" aria-describedby="button-addon2">
                                <div class="input-group-append">
                                    <button class="btn btn-primary" type="submit" id="button-addon2">Buscar</button>
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
                        <br/>   
                        <button type="submit" class="btn btn-primary" style="float: right; margin-right: 15px">Avançar</button>
                    </form> 
                </div>
            </center>
        </div>
    </body>
</html>
