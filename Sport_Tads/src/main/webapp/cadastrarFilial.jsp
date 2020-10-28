<%-- 
    Document   : cadastrarFilial
    Created on : 27/10/2020
    Author     : Rafael Souza Araujo
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <%@include file="header.jsp" %>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Cadastrar Filial</title>
    </head>
    <style>
        div h1{
            text-align: center;
            margin-bottom: 50px;
            margin-top: 50px;
        }
        p{
            font-weight: bolder;
            font-size: 18px;
        }
    </style>
    <body>
        <%@include file="cabecalho.jsp" %>
        <div class="container">
            <h1>Cadastro de Filial</h1>
            <form action="CadastrarCliente" method="POST">
                <div class="row">
                    <div class="form-group col-lg-6">
                        <p>Nome</p>
                        <input name="nome" class="form-control" required="true"/>
                    </div>
                    <div class="form-group col-lg-3">
                        <p>Estado</p>
                        <input  name="email" class="form-control" required="true"/>             
                    </div> 
                    <div class="form-group col-lg-3">
                        <p>Cidade</p>      
                        <input name="cpf" class="form-control cpf-mask" maxlength="11" required="true"/>    
                    </div>
                </div>
                </br>
                <button type="button" class="btn btn-primary" onclick="mostraCadastroCliente()" 
                        style="float:right">Salvar</button>
                <div class="modal fade" id="modalCadastro" tabindex="-1" role="dialog" aria-labelledby="exampleModalLabel" aria-hidden="true">
                    <div class="modal-dialog">
                        <div class="modal-content">
                            <div class="modal-header">
                                <h5 class="modal-title" id="ModalCadastroCliente">Confirmar Cadastro</h5>
                                <button type="button" class="close" data-dismiss="modal" aria-label="Close">
                                    <span aria-hidden="true">&times;</span>
                                </button>
                            </div>
                            <div class="modal-body">
                                <label id="nomeCliente">Confirmar Cadastro do cliente </label> ?
                            </div>
                            <div class="modal-footer">
                                <button type="button" class="btn btn-secondary" data-dismiss="modal">Cancelar</button>
                                <button type="submit" class="btn btn-primary" onclick="CadastrarCliente()">Confirmar</button>
                            </div>        
                        </div>
                    </div>
                </div>
            </form>
        </div>
    </body>
</html>