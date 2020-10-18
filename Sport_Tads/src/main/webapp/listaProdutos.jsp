<%-- 
    Document   : listaProdutos
    Created on : 16/10/2020, 18:36:51
    Author     : Fernando
--%>

<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <%@include file="header.jsp" %>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Lista de Produtos</title>     
    </head>
    <body>
        <h1>Lista de Produtos</h1>
        <table class="table">
            <thead >
                <th>Código da filial </th>
                <th>Código do produto</th>
                <th>Nome</th>
                <th>Marca</th>
                <th>Categoria</th>
                <th>Valor</th>
                <th>Quantidade em estoque</th>
            </thead>
            <tbody> 
                <c:forEach var="produto" items="${listaProd}">
                    <tr>
                       
                        <td>${produto.codFilial}</td>
                        <td>${produto.codProduto}</td>
                        <td>${produto.nomeProduto}</td>
                        <td>${produto.marcaProduto}</td>
                        <td>${produto.categoriaProduto}</td>
                        <td>${produto.valorProduto}</td>
                        <td>${produto.quantidadeEmEstoque}</td>
                      
                        
                        <td><a href="AlterarCliente?cpf=">Alterar</a></td>
                        <td><a href="AlterarCliente?cpf=">Excluir</a></td>
                     
                    </tr>
                </c:forEach>
                
            </tbody>
            
        </table> 
        <a href="index.jsp">Voltar</a>
    </body>
</html>
