<%-- 
    Document   : cadastrarProduto
    Created on : 15/10/2020, 18:05:21
    Author     : Fernando
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
   <%@include file="header.jsp" %>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Cadastrar Produto</title>
    </head>
    <body class="container">
        <h1>Cadastro de Produto</h1>
        <form action="IncluirProduto" method="POST">
            
            <p>Código da filial</p>
            <input name="filial" class="form-control" required="true"/><br/>
            
                       
            <p>Nome</p>
            <input name="nome" class="form-control" required="true"/><br/>
            
            <p>Marca</p>
            <input name="marca" class="form-control" required="true"/><br/>
            
            <p>Categoria</p>
            <input name="categoria" class="form-control" required="true"/><br/>
            <p>Valor</p>
            <input name="valor" class="form-control" required="true"/><br/>
            
            <p>Quantidade em estoque</p>
            <input name="qtd" class="form-control" required="true"/><br/>
            
            
            <button type="submit" class="btn btn-primary">Salvar</button>
            
        </form>
    </body>
</html>
