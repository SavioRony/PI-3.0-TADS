<%-- 
    Document   : vendasPasso2
    Created on : 24/10/2020, 20:22:54
    Author     : Fernando
--%>

<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<%@include file="header.jsp" %>
<script type="text/javascript">
    function calcularValorTotal(){
       var quant = parseInt(document.getElementById('quantidade').value, 10);
        var valorUnit = parseFloat(document.getElementById('valorUnitario').value, 10);
        document.getElementById('subTotal').value = quant * valorUnit;
}

</script>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>JSP Page</title>
    </head>
    <body class="container">
        <h2>Número do pedido: ${codVenda} </h2>
        
        <h2  style="text-align: center">Selecionar produto</h2>

        <form action="VendaProduto" class="form-inline" method="GET">

            <div class="form-group col-lg-4" style="float: right">
                <h5>Código do produto<h5>
                <div class="input-group mb-3">
                            
                    <input type="hidden" name="codVenda" value="${codVenda}"><br> 
                    <input type="hidden" name="codFilial" value="${codFilial}"><br>
                    <input  name="codProduto" class="form-control" placeholder="Código do Produto" aria-describedby="button-addon2">
                    
                    <div class="input-group-append">
                        <button class="btn btn-secondary" type="submit" id="button-addon2">Pesquisar</button>
                    </div>
                </div>
                    
            </div>

            <table id="tabelaProduto" class="table">
                <thead class="thead-light" >
                    <th style="text-align: center">Código da filial</th>
                    <th style="text-align: center">Código do produto</th>
                    <th style="text-align: center">Nome</th>
                    <th style="text-align: center">Marca</th>
                    <th style="text-align: center">Categoria</th>
                    <th style="text-align: center">Valor</th>
                    <th style="text-align: center">Quantidade em estoque</th><br/>
                </thead>
                               
                <c:forEach var="produto" items="${listaProd}">              
                    <tr class="table-light">
                        <td style="text-align: center">${produto.codFilial}</td>
                        <td style="text-align: center">${produto.codProduto}</td>
                        <td style="text-align: center">${produto.nomeProduto}</td>
                        <td style="text-align: center">${produto.marcaProduto}</td>
                        <td style="text-align: center">${produto.categoriaProduto}</td>
                        <td style="text-align: center">${produto.valorProduto}</td>
                        <td style="text-align: center">${produto.quantidadeEmEstoque}</td>  
                    </tr>                
                </c:forEach>
            </table>
        </form>
        <form action="VendaInserirProduto" method="POST">         
            <c:forEach var="produto" items="${listaProd}">
                    <div>
                        <input type="hidden" name="codVenda" value="${codVenda}">
                        <input type="hidden" name="codFilial" value="${codFilial}"><br>
                        <input type="hidden" name="codProduto" value="${produto.codProduto}">
                        <h6>Quantidade</h6>
                        <input style="width: 200px" class="form-control" id="quantidade" name="quantidade" value="1" type="text" onfocus="calcularValorTotal()"/> 
                        <input type="hidden" id="valorUnitario" value="${produto.valorProduto}" onblur="calcularValorTotal()" />
                        <h6>Sub-Total</h6>
                        <input style="width: 200px" class="form-control" id="subTotal" name="subTotal" type="text" readonly="true"/><br><br>                        
                    </div>        
            </c:forEach>
            <button type="submit" class="btn btn-primary" >Adicionar no Carrinho</button> 
        </form>
                    
       <form action="VendaCarrinho" method="GET">         
           <input type="hidden" name="codVenda" value="${codVenda}">
            <input type="hidden" name="codFilial" value="${codFilial}"><br>              
            <button type="submit" class="btn btn-primary" >Ver Carrinho</button> 
        </form>            
    </body>
</html>
