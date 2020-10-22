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
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8"> ,<!-- testes -->
        <title>Lista de Produtos</title>   
        
         <script lang="text/javascript">
            
            function mostrarModalExclusao(cProduto,nProduto){
                $("#codProduto").val(cProduto);
                $("#nomeProduto").html(nProduto);
                $('#modalExclusao').modal('show');
            }
            
            function excluirProduto() {
                var codProduto = $("#codProduto").val();
                $.get( "ExcluirProduto?codProduto="+codProduto, function( resposta ) {
                    $('#modalExclusao').modal('hide')
                    if (resposta === "true") {
                        console.log("Excluído com sucesso!");
                    } else {
                        console.log("Erro ao excluir o produto");
                    }
                    window.location.reload();
                });
            }
        </script> 
    </head>
    <body class="container">
        <h1 style="text-align: center" >  Lista de Produtos</h1><br>
        <table class="table">
            <thead class="thead-light" >
                <th style="text-align: center">Código da filial </th>
                <th style="text-align: center">Código do produto</th>
                <th style="text-align: center">Nome</th>
                <th style="text-align: center">Marca</th>
                <th style="text-align: center">Categoria</th>
                <th style="text-align: center">Valor</th>
                <th style="text-align: center">Quantidade</th>
                <th style="text-align: center">Ações</th>
            </thead>
            <tbody> 
                <c:forEach var="produto" items="${listaProd}">
                    <tr>
                       
                        <td style="text-align: center">${produto.codFilial}</td>
                        <td style="text-align: center">${produto.codProduto}</td>
                        <td style="text-align: center">${produto.nomeProduto}</td>
                        <td style="text-align: center">${produto.marcaProduto}</td>
                        <td style="text-align: center">${produto.categoriaProduto}</td>
                        <td style="text-align: center">${produto.valorProduto}</td>
                        <td style="text-align: center">${produto.quantidadeEmEstoque}</td>
                      
                        
                       
                        
                        <td style="text-align: center"><a href="AlterarProduto?codProduto=${produto.codProduto}"><button class="btn btn-default">
                            <svg width="1em" height="1em" viewBox="0 0 16 16" class="bi bi-pencil-fill" fill="currentColor" xmlns="w3.org/2000/svg">
                            <path fill-rule="evenodd" d="M12.854.146a.5.5 0 0 0-.707 0L10.5 1.793 14.207 5.5l1.647-1.646a.5.5 0 0 0 0-.708l-3-3zm.646 6.061L9.793 2.5 3.293 9H3.5a.5.5 0 0 1 .5.5v.5h.5a.5.5 0 0 1 .5.5v.5h.5a.5.5 0 0 1 .5.5v.5h.5a.5.5 0 0 1 .5.5v.207l6.5-6.5zm-7.468 7.468A.5.5 0 0 1 6 13.5V13h-.5a.5.5 0 0 1-.5-.5V12h-.5a.5.5 0 0 1-.5-.5V11h-.5a.5.5 0 0 1-.5-.5V10h-.5a.499.499 0 0 1-.175-.032l-.179.178a.5.5 0 0 0-.11.168l-2 5a.5.5 0 0 0 .65.65l5-2a.5.5 0 0 0 .168-.11l.178-.178z"/>
                            </svg>
                        </button></a>
                        <button class="btn btn-default" onclick="mostrarModalExclusao(${produto.codProduto},'${produto.nomeProduto}')">
                            <svg width="1em" height="1em" viewBox="0 0 16 16" class="bi bi-trash-fill" fill="currentColor" xmlns="w3.org/2000/svg">
                            <path fill-rule="evenodd" d="M2.5 1a1 1 0 0 0-1 1v1a1 1 0 0 0 1 1H3v9a2 2 0 0 0 2 2h6a2 2 0 0 0 2-2V4h.5a1 1 0 0 0 1-1V2a1 1 0 0 0-1-1H10a1 1 0 0 0-1-1H7a1 1 0 0 0-1 1H2.5zm3 4a.5.5 0 0 1 .5.5v7a.5.5 0 0 1-1 0v-7a.5.5 0 0 1 .5-.5zM8 5a.5.5 0 0 1 .5.5v7a.5.5 0 0 1-1 0v-7A.5.5 0 0 1 8 5zm3 .5a.5.5 0 0 0-1 0v7a.5.5 0 0 0 1 0v-7z"/>
                            </svg>
                        </button></td>
                        
                        
                        
                    </tr>
                </c:forEach>
                
            </tbody>
            
        </table> 
        <div class="modal fade" id="modalExclusao" tabindex="-1" aria-labelledby="exampleModalLabel" aria-hidden="true">
            <div class="modal-dialog">
              <div class="modal-content">
                <div class="modal-header">
                  <h5 class="modal-title" id="exampleModalLabel">Confirmar Exclusão do produto?</h5>
                  <button type="button" class="close" data-dismiss="modal" aria-label="Close">
                    <span aria-hidden="true">&times;</span>
                  </button>
                </div>
                <div class="modal-body">
                    Confirmar exclusão do produto  <label id="nomeProduto"></label> ?
                    <input id="codProduto" hidden="true" />
                 
                </div>
                <div class="modal-footer">
                  <button type="button" class="btn btn-secondary" data-dismiss="modal">Cancelar</button>
                  <button type="button" class="btn btn-primary" onclick="excluirProduto()">Confirmar</button>
                </div>
              </div>
            </div>
          </div>
        <br>
        <a href="index.jsp">Voltar</a>
        <a href="cadastrarProduto.jsp" ><button type="button" class="btn btn-primary" style="float: right">Cadastrar Produto  </button></a>
    </body>
</html>

