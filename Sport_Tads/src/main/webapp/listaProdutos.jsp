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
                      
                        
                        <td><a href="AlterarProduto?codProduto=${produto.codProduto}">Alterar</a></td>
                       <td><button type="button" class="btn btn-primary" onclick="mostrarModalExclusao(${produto.codProduto},
                                   '${produto.nomeProduto}')">Excluir</button></td>
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
    </body>
</html>
