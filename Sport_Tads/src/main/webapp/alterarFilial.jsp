<%-- 
    Document   : alterarFilial
    Created on : 27/10/2020
    Author     : Rafael Souza Araujo
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <%@include file="header.jsp" %>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Alterar Filial</title> 
    </head>
    <style>
        p {
            font-weight: bolder;
            font-size: 18px;
        }
    </style>
    <body>
        <%@include file="cabecalho.jsp" %>
        <div class="container">
            <h1 style="text-align: center; margin-bottom: 50px; margin-top: 50px">Alteração de Filial: ${cliente.nome}</h1>
            <form action="AlterarCliente" method="POST">
                <div class="row">     
                    <div class="form-group col-lg-6">
                        <p>Nome</p>
                        <input name="nome" class="form-control" value="${cliente.nome}" required="true"/>
                    </div>
                    <div class="form-group col-lg-3">
                        <p>Estado</p>
                        <input  name="email" class="form-control" value="${cliente.email}" required="true"/>                
                    </div> 
                    <div class="form-group col-lg-3">                        
                        <p>Cidade</p>      
                        <input name="cpf" class="form-control" value="${cliente.cpf}" required="true"/>    
                    </div>
                </div>
                <br/>
                <button type="submit" class="btn btn-primary" style="float: right">Salvar</button>            
            </form>             
        </div>
    </body>
</html>
