<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <%@include file="../../header.jsp" %>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <link rel="stylesheet" href="css/estilo.css">
        <title>Cadastrar Cliente</title>
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
    <body>
        <%@include file="../../cabecalho.jsp" %>
        <div class="container">
            <h1>Cadastro de Cliente</h1>
            
            <form action="<c:url value="/CadastrarCliente"/>" method="POST">
                <div id="area">
                    <div class="row">
                        <div class="form-group col-lg-12">
                            <p>Nome</p>
                            <input name="nome" onkeypress="return event.charCode >= 65 && event.charCode <= 90 || event.charCode >= 97 && event.charCode <= 122 || event.charCode == 32" class="form-control" placeholder="Nome Completo" required="true"/>
                        </div>
                    </div>
                    <br/>
                    <div class="row">
                        <div class="form-group col-lg-4">
                            <p>Email</p>
                            <input  name="email" class="form-control" placeholder="exemplo@exemplo.com.br" required="true"/>               
                        </div> 
                        <div class="form-group col-lg-4">
                            <p>CPF</p>      
                            <input name="cpf" onkeypress="return event.charCode >= 48 && event.charCode <= 57" class="form-control cpf-mask" placeholder="000.000.000-00" maxlength="11" required="true"/>    
                        </div>
                        <div class="form-group col-lg-4">
                            <p>Celular</p>
                            <input name="celular" onkeypress="return event.charCode >= 48 && event.charCode <= 57" class="form-control cel-sp-mask" placeholder="(00)00000-0000" maxlength="11" required="true"/>
                        </div>
                    </div>
                    <br/>
                    <button type="button" class="btn btn-primary" onclick="mostraCadastroCliente()" 
                            style="float:right; width: 100px; margin-bottom: 30px">Salvar</button>
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
                                <label id="nomeCliente">Confirmar Cadastro do cliente?</label>
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
