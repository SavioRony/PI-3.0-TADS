<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <%@include file="../../header.jsp" %>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <link rel="stylesheet" href="css/estilo.css">
        <title>Alterar Cliente</title> 
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
        <%@include file="../../cabecalho.jsp" %>
        <div class="container">
            <h1>Alteração de Cadastro: ${cliente.nome}</h1>
            <form action="AlterarCliente" method="POST">
                <div class="row">     
                    <div class="form-group col-lg-8">
                        <p>Nome</p>
                        <input name="nome" onkeypress="return event.charCode >= 65 && event.charCode <= 90 || event.charCode >= 97 && event.charCode <= 122" class="form-control" value="${cliente.nome}" required="true"/>
                    </div>
                    <div class="form-group col-lg-4">
                        <p>CPF</p>      
                        <input onkeypress="return event.charCode >= 48 && event.charCode <= 57" name="cpf" class="form-control" value="${cliente.cpf}" readonly="true"/>    
                    </div>
                </div>
                <br/>
                <div class="row">
                    <div class="form-group col-lg-6">
                        <p>Email</p>
                        <input  name="email" class="form-control" value="${cliente.email}" required="true"/>                
                    </div> 
                    <div class="form-group col-lg-6">
                        <p>Celular</p>
                        <input name="celular" onkeypress="return event.charCode >= 48 && event.charCode <= 57" class="form-control" value="${cliente.celular}" required="true"/>
                    </div>
                </div>
                <br/>
                <button type="submit" class="btn btn-primary" style="float: right">Salvar</button>            
            </form>             
        </div>
    </body>
</html>
