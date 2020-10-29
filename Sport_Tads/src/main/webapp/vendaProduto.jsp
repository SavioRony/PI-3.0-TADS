<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<%@include file="header.jsp" %>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>JSP Page</title>
    </head>
    <style>
        div h1{
            text-align: center;
            margin-bottom: 50px;
            margin-top: 50px;
        }
        table{
            text-align: center;
        }
    </style>
    <script type="text/javascript">
        function calcularValorTotal() {
            var quant = parseInt(document.getElementById('quantidade').value, 10);
            var valorUnit = parseFloat(document.getElementById('valorUnitario').value, 10);
            document.getElementById('subTotal').value = quant * valorUnit;
        }
    </script>
    <body>
        <%@include file="cabecalho.jsp" %>
        <div class="container">
            <h1>Número do pedido: ${codVenda} | Selecionar produto(s)</h1>
            <form action="VendaProduto" method="GET">
                <input type="hidden" name="codVenda" value="${codVenda}">
                <input type="hidden" name="codFilial" value="${codFilial}">
                <div class="form-group col-lg-4" style="float: right; margin-right: -10px">
                    <div class="input-group mb-3">
                        <input  name="codProduto" class="form-control" placeholder="Código do Produto" aria-describedby="button-addon2">
                        <div class="input-group-append">
                            <button class="btn btn-primary" type="submit" id="button-addon2">Buscar</button>
                        </div>
                    </div>
                </div>
            </form>
            <table id="tabelaProduto" class="table">
                <thead class="thead-light" >
                    <tr>
                        <th>ID Filial</th>
                        <th>ID Produto</th>
                        <th>Nome</th>
                        <th>Marca</th>
                        <th>Categoria</th>
                        <th>Valor</th>
                        <th>Quantidade em estoque</th>
                    </tr>
                </thead>
                <tbody>
                    <c:forEach var="produto" items="${listaProd}">              
                        <tr class="table-light">
                            <td>${produto.codFilial}</td>
                            <td>${produto.codProduto}</td>
                            <td>${produto.nomeProduto}</td>
                            <td>${produto.marcaProduto}</td>
                            <td>${produto.categoriaProduto}</td>
                            <td>${produto.valorProduto}</td>
                            <td>${produto.quantidadeEmEstoque}</td>  
                        </tr>                
                    </c:forEach>
                </tbody>
            </table>
            <br/>
            <div>
                <form action="VendaInserirProduto" method="POST" style="float:right">         
                    <c:forEach var="produto" items="${listaProd}">
                        <div>
                            <input type="hidden" name="codVenda" value="${codVenda}">
                            <input type="hidden" name="codFilial" value="${codFilial}">
                            <input type="hidden" name="codProduto" value="${produto.codProduto}">
                            <h6>Quantidade</h6>
                            <input style="width: 200px" class="form-control" id="quantidade" name="quantidade" value="1" type="text" onfocus="calcularValorTotal()"/> 
                            <input type="hidden" id="valorUnitario" value="${produto.valorProduto}" onblur="calcularValorTotal()" />
                            <h6>Sub-Total</h6>
                            <input style="width: 200px" class="form-control" id="subTotal" name="subTotal" type="text" readonly="true"/>                        
                        </div>        
                    </c:forEach>
                    <button type="submit" class="btn btn-primary" >Adicionar no Carrinho</button> 
                </form>
                <form action="VendaCarrinho" method="GET" style="float:left">         
                    <input type="hidden" name="codVenda" value="${codVenda}">
                    <input type="hidden" name="codFilial" value="${codFilial}">             
                    <button type="submit" class="btn btn-primary" >Ver Carrinho</button> 
                </form> 
            </div>
        </div>
    </body>
</html>
