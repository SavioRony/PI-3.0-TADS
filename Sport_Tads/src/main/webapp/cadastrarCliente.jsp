<%-- 
    Document   : cadastrarCliente
    Created on : Sep 18, 2020, 15:30:59 PM
    Author     : savio
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <%@include file="header.jsp" %>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <link rel="stylesheet" href="css/estilo.css">
        <title>Cadastrar Cliente</title>

        <script lang="text/javascript">
            
            function mostraCadastroCliente() {
                $('#modalCadastro').modal('show');
            }
            function CadastrarCliente() {
                $.get("CadastrarCliente", function () {
                    $('#modalCadastro').modal('hide');
                    $.notify("Cliente Cadastrado com sucesso","success");
                    window.location.reload();
                });
            }
        </script>
        

    </head>
    <body class="container">
        <form action="CadastrarCliente" method="POST">
        <div id="area">
            <center> <h1>Cadastro de Clientes</h1> </center></br></br>
            
                <div class="row">
                    <div class="form-group col-lg-11">
                        <b><p>Nome</p></b>
                        <input name="nome" class="form-control" placeholder="Nome Completo" required="true"/><br/>
                    </div>   

                    <div class="form-group col-lg-4">
                        <b><p>Email</p></b>
                        <input  name="email" class="form-control" placeholder="exemplo@exemplo.com.br" required="true"/><br/>                
                    </div> 

                    <div class="form-group col-lg-3">
                        <b><p>CPF</p><b>       
                        <input name="cpf" class="form-control cpf-mask" placeholder="000.000.000-00" maxlength="11" required="true"/><br/>    
                    </div>

                    <div class="form-group col-lg-10">
                        <b><p>Celular</p></b>
                        <input name="celular" class="form-control cel-sp-mask" placeholder="(00)00000-0000" required="true"/><br/>
                    </div>
                </div>
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
    </body>
</html>
