

<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <%@include file="header.jsp"%>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <link rel="stylesheet" href="css/cliente.css">
        <title>Cliente</title>
        <script lang="text/javascript">

            function mostrarModalExclusao(cpf, nome) {
                $("#nomeCliente").html(nome);
                $("#cpfCliente").val(cpf);
                $('#modalExclusao').modal('show');
            }

            function excluirCliente() {
                var cpf = $("#cpfCliente").val();
                $.get("ExcluirCliente?cpf=" + cpf, function () {
                    $('#modalExclusao').modal('hide')
                    window.location.reload();
                });
            }
        </script>

    </head>
    <body>
 
        <h1>Cliente</h1>
            <form action="buscarCliente">
                    <div class="form-group col-lg-4">
                        <div class="input-group mb-3">
                            <input name="cpf" class="form-control" placeholder="CPF Cliente" aria-describedby="button-addon2">
                            <div class="input-group-append">
                                <button class="btn btn-primary" type="submit" id="button-addon2">Buscar</button>
                            </div>
                        </div>
                    </div>
            </form>
        <table class="table">
            <thead>
            <th scope="col">CPF</th>
            <th scope="col">Nome</th>
            <th scope="col">Email</th>               
            <th scope="col">Celular</th>
        </thead>
        <tbody> 
            <c:forEach var="cliente" items="${listaClientes}">              
                <tr>
                    <th scope="row">${cliente.cpf}</th>
                    <td>${cliente.nome}</td>
                    <td>${cliente.email}</td>
                    <td>${cliente.celular}</td>
                    <td><a href="AlterarCliente?cpf=${cliente.cpf}">Alterar</a></td>
                    <td><button type="button" class="btn btn-primary" onclick="mostrarModalExclusao(${cliente.cpf}, '${cliente.nome}')">Excluir</button></td>
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
                    Confirmar exclusão do cliente  <label id="nomeCliente"></label> ?
                    <input id="cpfCliente" hidden="true"/>

                </div>
                <div class="modal-footer">
                    <button type="button" class="btn btn-secondary" data-dismiss="modal">Cancelar</button>
                    <button type="button" class="btn btn-primary" onclick="excluirCliente()">Confirmar</button>
                </div>
            </div>
        </div>
    </div>
    <br/>
    <a href="index.jsp">Voltar</a>
    <a href="cadastrarCliente.jsp"><button type="button" class="btn btn-primary" id="botaoCadastrar" >Cadastrar Clientes</button></a>
</body>
</html> 
