<%-- 
    Document   : alterarFilial
    Created on : 28/10/2020, 16:29:29
    Author     : Fernando
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
     <%@include file="header.jsp" %>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Alterar filial</title>
    </head>
    <body>
         <%@include file="cabecalho.jsp" %>
         
         <div class="container">
             <center> <h1> Alteração da Filiail: ${filial.estado}</h1></center>
            <form action="AlterarFilial" method="POST">
                <div class="form-group col-lg-6">
                        <p>Código da filial</p>
                        <input name="codFilial" class="form-control" value="${filial.codFilial}" readonly="true" />
                    </div>
                <div class="row">
                    
                    <div class="form-group col-lg-6">
                        <p>Nome da filial</p>
                        <input name="nomeFilial" class="form-control" value="${filial.nomeFilial}" required="true"/>
                    </div>
                    <div class="form-group col-lg-6">
                        <p>Estado (UF)</p>
                        <input name="estado" class="form-control" value="${filial.estado}" required="true"/>
                    </div>
                </div>
                <div class="row">
                    <div class="form-group col-lg-6">
                        <p>Cidade</p>
                        <input name="cidade" class="form-control" value="${filial.cidade}" required="true"/>
                    </div>
                    <div class="form-group col-lg-6">
                        <p>Status</p>
                        <input name="status" class="form-control"  value="${filial.status}" required="true"/>
                    </div>
                </div>
               
                    
                <button type="submit" style="float: right; width: 100px; margin-bottom: 30px; margin-top: 25px" class="btn btn-primary">Salvar</button>
            </form>
        </div>
    </body> 
</html>
