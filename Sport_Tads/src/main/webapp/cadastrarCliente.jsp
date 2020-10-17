<%-- 
    Document   : cadastrarCliente
    Created on : Sep 25, 2020, 9:26:59 PM
    Author     : tscarton
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <%@include file="header.jsp" %>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <link rel="stylesheet" href="css/cliente.css">
        <title>Cadastrar Cliente</title>

        <script lang="text/javascript">
            function mostraCadastroCliente() {
                $('#modalCadastro').modal('show');
            }
            function CadastrarCliente() {
                $.get("CadastrarCliente", function () {
                    $('#modalCadastro').modal('hide');
                    window.location.reload();
                });
            }
        </script>    

    </head>
    <body class="container">

        <h1>Cadastro</h1>
        <div id="area">
            <form action="CadastrarCliente" method="POST">
                <div id="nomeCliente">
                    <p>Nome</p>
                    <input name="nome" class="form-control" required="true"/><br/>
                </div>   

                <div id="inputEmail">
                    <p>Email</p>
                    <input  name="email" class="form-control" required="true"/><br/>                
                </div> 

                <div id="inputCpf">
                    <p>CPF</p>
                    <input name="cpf" class="form-control" required="true"/><br/>
                </div>

                <div id="inputCelular">
                    <p>Celular</p>
                    <input name="celular" class="form-control" required="true"/><br/>
                </div>
                <div id="btnEnviar">
                    <button type="button" class="btn btn-primary" onclick="mostraCadastroCliente()">Enviar</button>
                </div>

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
