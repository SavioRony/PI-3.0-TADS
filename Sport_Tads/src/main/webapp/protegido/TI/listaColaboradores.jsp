<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <%@include file="../../header.jsp" %>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Lista de Colaboradores</title>
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
    <script lang="text/javascript">
        function mostrarModalExclusao(cpf, nome) {
            $("#nomeColaborador").html(nome);
            $("#cpfColaborador").val(cpf);
            $('#modalExclusao').modal('show');
        }

        function excluirCliente() {
            var cpf = $("#cpfColaborador").val();
            $.get("ExcluirColaborador?cpf=" + cpf, function (resposta) {
                $('#modalExclusao').modal('hide')
                window.location.reload();
            });
        }
    </script>
    <body>
        <%@include file="../../cabecalho.jsp" %>
        <div class="container">
            <h1>Lista de Colaboradores</h1>
            <table class="table">
                <thead class="thead-light">
                    <tr>
                        <th>CPF</th>
                        <th>Nome</th>
                        <th>Usuario</th>
                        <th>Cidade</th>
                        <th>Filial</th>
                        <th>Ações</th>
                    </tr>
                </thead>
                <tbody>
                    <c:forEach var="colaborador" items="${listaColaboradores}">
                        <tr class="table-light">
                            <td>${colaborador.cpf}</td>
                            <td>${colaborador.nome}</td>
                            <td>${colaborador.usuario}</td>
                            <td>${colaborador.cidade}</td>
                            <td>${colaborador.codFilial}</td>
                            <td class="actions">
                                <a href="<c:url value="/AlterarColaborador?cpf=${colaborador.cpf}"/>">
                                    <button class="btn btn-default">
                                        <svg width="1em" height="1em" viewBox="0 0 16 16" class="bi bi-pencil-fill" fill="currentColor" xmlns="http://www.w3.org/2000/svg">
                                        <path fill-rule="evenodd" d="M12.854.146a.5.5 0 0 0-.707 0L10.5 1.793 14.207 5.5l1.647-1.646a.5.5 0 0 0 0-.708l-3-3zm.646 6.061L9.793 2.5 3.293 9H3.5a.5.5 0 0 1 .5.5v.5h.5a.5.5 0 0 1 .5.5v.5h.5a.5.5 0 0 1 .5.5v.5h.5a.5.5 0 0 1 .5.5v.207l6.5-6.5zm-7.468 7.468A.5.5 0 0 1 6 13.5V13h-.5a.5.5 0 0 1-.5-.5V12h-.5a.5.5 0 0 1-.5-.5V11h-.5a.5.5 0 0 1-.5-.5V10h-.5a.499.499 0 0 1-.175-.032l-.179.178a.5.5 0 0 0-.11.168l-2 5a.5.5 0 0 0 .65.65l5-2a.5.5 0 0 0 .168-.11l.178-.178z"/>
                                        </svg>
                                    </button>
                                </a>
                                <button class="btn btn-default" onclick="mostrarModalExclusao(${colaborador.cpf}, '${colaborador.nome}')">
                                    <svg width="1em" height="1em" viewBox="0 0 16 16" class="bi bi-trash-fill" fill="currentColor" xmlns="http://www.w3.org/2000/svg">
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
                            Confirmar exclusão do colaborador:  <label id="nomeColaborador"></label>?
                            <input id="cpfColaborador" hidden="true" />
                        </div>
                        <div class="modal-footer">
                            <button type="button" class="btn btn-secondary" data-dismiss="modal">Cancelar</button>
                            <button type="button" class="btn btn-primary" onclick="excluirCliente()">Confirmar</button>
                        </div>
                    </div>
                </div>
            </div>
            <br/>
            <div>
                <a href="protegido/TI/cadastrarColaborador.jsp"><button type="button" class="btn btn-primary" id="btn-novo-colaborador" style="float: right">Novo Colaborador</button></a>
            </div>
        </div>
    </body>
</html>