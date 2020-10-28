<%-- 
    Document   : incluirFilial
    Created on : 27/10/2020, 23:21:32
    Author     : Fernando
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
     <%@include file="header.jsp" %>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Incluir Filial</title>
    </head>
    <body>
         <%@include file="cabecalho.jsp" %>
         <div class="container">
            <h1 style="text-align: center; margin-top: 50px; margin-bottom: 50px">Cadastro de Filiais</h1>
            <form action="CadastrarFilial" method="POST">
                <div class="row">
                    <div class="form-group col-lg-6">
                        <p>Nome da filial</p>
                        <input name="nomeFilial" class="form-control" required="true"/>
                    </div>
                    <div class="form-group col-lg-6">
                        <p>Estado (UF)</p>
                        <input name="estado" class="form-control" required="true"/>
                    </div>
                </div>
                <div class="row">
                    <div class="form-group col-lg-6">
                        <p>Cidade</p>
                        <input name="cidade" class="form-control" required="true"/>
                    </div>
                    <div class="form-group col-lg-6">
                        <p>Status</p>
                        <input name="status" class="form-control" required="true"/>
                    </div>
                </div>
               
                <button type="submit" style="float: right; width: 100px; margin-bottom: 30px; margin-top: 25px" class="btn btn-primary">Salvar</button>
            </form>
        </div>
    </body>
</html>
