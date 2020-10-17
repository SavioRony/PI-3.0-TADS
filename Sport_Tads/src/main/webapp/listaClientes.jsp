

<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <%@include file="header.jsp" %>
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
    <body class="container">
        <h1>Cliente</h1>
        <table class="table">
            <thead>
            <th>CPF</th>
            <th>Nome</th>
            <th>Email</th>               
            <th>Celular</th>
        </thead>
        <tbody> 
            <c:forEach var="cliente" items="${listaClientes}">
                <tr>
                    <td width="50">${cliente.cpf}</td>
                    <td width="300">${cliente.nome}</td>
                    <td width="100">${cliente.email}</td>
                    <td width="50">${cliente.celular}</td>
                    <td width="20"><a href="AlterarCliente?cpf=${cliente.cpf}">Alterar</a></td>
                    <td width="20"><button type="button" class="btn btn-primary" onclick="mostrarModalExclusao(${cliente.cpf}, '${cliente.nome}')">Excluir</button></td>
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
                    <input id="cpfCliente" hidden="true" />

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
