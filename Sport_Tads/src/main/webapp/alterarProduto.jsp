<%-- 
    Document   : alterarProduto
    Created on : 18/10/2020, 21:35:49
    Author     : Fernando
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <%@include file="header.jsp" %>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Alterar Produto</title>
    </head>
    <body class="container">
        <h1>Alteração de Cadastro:${produto.nomeProduto} </h1>
        <form action="AlterarProduto" method="POST">
            
            
            <p>Código da filial</p>
            <input class="form-control" name="filial" value="${prod.codFilial}"/><br/>
            
            <p>Código do produto</p>
            <input class="form-control" name="codProduto" value="${prod.codProduto}" readonly="true"/><br/>
            
            <p>Nome</p>
            <input class="form-control" name="nome" value="${prod.nomeProduto}"/><br/>
            
            <p>Marca</p>
            <input class="form-control" name="marca" value="${prod.marcaProduto}"/><br/>
            
            <p>Categoria</p>
            <input class="form-control" name="categoria" value="${prod.categoriaProduto}"/><br/>
            
            <p>Valor</p>
            <input class="form-control" name="valor" value="${prod.valorProduto}"/><br/>
            
            <p>Quantidade em estoque</p>
            <input class="form-control" name="qtd" value="${prod.quantidadeEmEstoque}"/><br/>
            
            
            <button class="btn btn-primary" type="submit" >Salvar Alteração</button>
    </body>
</html>
