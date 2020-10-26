<%-- 
    Document   : vendaCarrinho
    Created on : 25/10/2020, 17:18:32
    Author     : savio
--%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <%@include file="header.jsp" %>
    <head>
        <script lang="text/javascript">

            function mostrarModalExclusao(idItem, codProduto, quantidade) {
                $("#idItem").val(idItem);
                $("#codProduto").val(codProduto);
                $("#quantidade").val(quantidade);
                $('#modalExclusao').modal('show');
            }

            function excluirItemVenda() {
                var idItem = $("#idItem").val();
                var codProduto = $("#codProduto").val();
                var quantidade = $("#quantidade").val();
                $.get("VendaExcluirItem?idItem=" + idItem + "&codProduto=" + codProduto + "&quantidade=" + quantidade, function (resposta) {
                    $('#modalExclusao').modal('hide')
                    if (resposta === "true") {
                        console.log("Excluído com sucesso!");
                    } else {
                        console.log("Erro ao excluir o produto");
                    }
                    window.location.reload();
                });
            }

            $(function () {

                var valorCalculado = 0;
                $(".valor-calculado").each(function () {
                    valorCalculado += parseFloat($(this).text());
                });
                document.getElementById('valorTotal').value = valorCalculado;

            });
        </script>

    </head>
    <body class="container">
        <h1>Numero do Pedido: ${codVenda}</h1><br>
        <h1 style="text-align: center">Carrinho</h1><br>
        <table class="table">
            <thead class="thead-light">
            <th style="text-align: center">ID Produto</th>
            <th style="text-align: center">Nome Produto</th>               
            <th style="text-align: center">Marca</th>
            <th style="text-align: center">Quantidade</th>
            <th style="text-align: center">Valor</th>
            <th style="text-align: center">Sub-Total</th>
            <th style="text-align: center">Excluir</th>
        </thead>
        <tbody> 
            <c:forEach var="itemVenda" items="${listaItemVenda}">              
                <tr class="table-light">
                    <td style="text-align: center">${itemVenda.codProduto}</td>
                    <td style="text-align: center">${itemVenda.nomeProduto}</td>
                    <td style="text-align: center">${itemVenda.marcaProduto}</td>
                    <td style="text-align: center">${itemVenda.quantidade}</td>
                    <td style="text-align: center">${itemVenda.valorProduto}</td>
                    <td class="valor-calculado" style="text-align: center">${itemVenda.subTotal}</td>
                    <td style="text-align: center">
                        <button class="btn btn-default" onclick="mostrarModalExclusao('${itemVenda.idItem}', '${itemVenda.codProduto}', '${itemVenda.quantidade}')">
                            <svg width="1em" height="1em" viewBox="0 0 16 16" class="bi bi-trash-fill" fill="currentColor" xmlns="w3.org/2000/svg">
                            <path fill-rule="evenodd" d="M2.5 1a1 1 0 0 0-1 1v1a1 1 0 0 0 1 1H3v9a2 2 0 0 0 2 2h6a2 2 0 0 0 2-2V4h.5a1 1 0 0 0 1-1V2a1 1 0 0 0-1-1H10a1 1 0 0 0-1-1H7a1 1 0 0 0-1 1H2.5zm3 4a.5.5 0 0 1 .5.5v7a.5.5 0 0 1-1 0v-7a.5.5 0 0 1 .5-.5zM8 5a.5.5 0 0 1 .5.5v7a.5.5 0 0 1-1 0v-7A.5.5 0 0 1 8 5zm3 .5a.5.5 0 0 0-1 0v7a.5.5 0 0 0 1 0v-7z"/>
                            </svg>
                        </button>
                    </td>
                </tr> 
            </c:forEach>     
        </tbody>

    </table>   
    <div class="modal fade" id="modalExclusao" tabindex="-1" aria-labelledby="exampleModalLabel" aria-hidden="true">
        <div class="modal-dialog">
            <div class="modal-content">
                <div class="modal-header">
                    <h5 class="modal-title" id="exampleModalLabel">Confirmar Exclusão</h5>
                    <button type="button" class="close" data-dismiss="modal" aria-label="Close">
                        <span aria-hidden="true">&times;</span>
                    </button>
                </div>
                <div class="modal-body">
                    Confirmar para retira o produto do carrinho?
                    <input id="idItem" hidden="true"/>
                    <input id="codProduto" hidden="true"/>
                    <input id="quantidade" hidden="true"/>

                </div>
                <div class="modal-footer">
                    <button type="button" class="btn btn-secondary" data-dismiss="modal">Cancelar</button>
                    <button type="button" class="btn btn-primary" onclick="excluirItemVenda()">Confirmar</button>
                </div>
            </div>
        </div>
    </div>
        <form action="VendaFinalizar" method="GET">  
            <h6>Valor Total</h6>
            <div class="form-inline">
                <input name="codVenda" value="${codVenda}" type="hidden"/>   
                <input style="width: 200px" name="valorTotal" class="form-control" id="valorTotal" readonly="true">
                <button type="submit" class="btn btn-secondary" style="float: right">Finalizar Compra</button>
            </div>
        </form>       
        </body>
</html>
