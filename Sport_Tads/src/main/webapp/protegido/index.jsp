<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<html>
    <%@include file="../header.jsp" %>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <link rel="stylesheet" href="<c:url value="../css/estilo.css"/>">
        <title>Home SportTads</title>
    </head>
    <style>
        #logo{
            width: 350px;
            height: 125px;
        }
        li {
            font-size: 20px;
        }
    </style>
    <body>
        <%@include file="../cabecalho.jsp" %>
        <div class="container">
            <h3 style="margin-top: 20px; margin-bottom: 20px; text-align: center">Bem Vindo(a), ${sessionScope.colaborador.nome}!</h3>
            <h1 style="margin-top: 100px; margin-bottom: 100px; text-align: center">Sobre a SportTads</h1>
            <div class="row">
                <div class="form-group col-lg-6">
                    <ul>
                        <li>Fundada em 2009 pelos irmãos Antônio e Joana Tads</li>
                        <li>Empresa de Nacional de administração familiar</li>
                        <li>Sede localizada em São Paulo</li>
                        <li>Atuação no ramo esportivo</li>
                        <li>Ponto comercial de venda de produtos esportivos</li>
                    </ul>
                </div>
                <div class="form-group col-lg-6">
                    <center>
                        <img id="logo" src="..\img\lg.png">
                    </center>
                </div>
            </div>
        </div>
    </body>
</html>
