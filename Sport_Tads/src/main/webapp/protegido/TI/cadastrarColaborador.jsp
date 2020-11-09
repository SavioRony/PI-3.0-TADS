<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <%@include file="../../header.jsp" %>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Cadastrar Colaborador</title>
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
    <script>
        $(document).ready(function () {
            // $.notify("Colaborador salvo com sucesso", "success");
        });
    </script>
    <body>
        <%@include file="../../cabecalho.jsp" %>
        <div class="container">
            <h1>Cadastro de Colaborador</h1>
            <form action=" <c:url value="/CadastrarColaborador"/>" method="POST">
                <div class="row">
                    <div class="form-group col-lg-8">
                        <p>Nome</p>
                        <input name="nome" class="form-control" required="true"/>
                    </div>
                    <div class="form-group col-lg-4">
                        <p>CPF</p>
                        <input name="cpf" class="form-control" required="true"/>
                    </div>
                </div>
                <br/>
                <div class="row">
                    <div class="form-group col-lg-6">
                        <p>Endereço</p>
                        <input name="endereco" class="form-control" required="true"/>
                    </div>
                    <div class="form-group col-lg-2">
                        <p>Número</p>
                        <input name="numero" class="form-control" required="true"/>
                    </div>
                    <div class="form-group col-lg-4">
                        <p>CEP</p>
                        <input name="cep" class="form-control" required="true"/>
                    </div>
                </div>
                <br/>
                <div class="row">
                    <div class="form-group col-lg-4">
                        <p>Cidade</p>
                        <input name="cidade" class="form-control" required="true"/>
                    </div>
                    <div class="form-group col-lg-4">
                        <p>Cargo</p>
                        <input name="cargo" class="form-control" required="true"/>
                    </div>
                    <div class="form-group col-lg-4">
                        <p>Filial</p>
                        <input name="filial" class="form-control" required="true"/>
                    </div>
                </div>
                <br/>
                <div class="row">
                    <div class="form-group col-lg-8">
                        <p>Usuario</p>
                        <input name="usuario" class="form-control" required="true"/>
                    </div>
                    <div class="form-group col-lg-4">
                        <p>Senha</p>
                        <input name="senha" class="form-control" required="true"/>
                    </div>
                </div>
                <br/>
                <div class="row">
                    <label>Perfil:</label>
                    <select name="perfil">
                        <option value="Global">Global</option>
                        <option value="Regional">Regional</option>
                        <option value="Vendas">Vendas</option>
                        <option value="TI">TI</option>
                        <option value="Backoffice">BackOffice</option>
                    </select>
                </div>
                <br/>
                <button type="submit" style="float: right; margin-bottom: 30px" class="btn btn-primary">Salvar</button>
            </form>
        </div>
    </body>
</html>