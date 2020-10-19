<%-- 
    Document   : alterarCliente
    Created on : Oct 2, 2020, 7:59:00 PM
    Author     : tscarton
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <%@include file="header.jsp" %>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
         <link rel="stylesheet" href="css/estilo.css">
        <title>Alterar Cliente</title> 
    </head>
    <body class="container">
            <div>
                <center><h1>Alteração de Cadastro: ${cliente.nome}</h1></center></br></br>
                <form action="AlterarCliente" method="POST">
                    <div class="row">     
                        <div class="form-group col-lg-11">
                            <b><p>Nome</p></b>
                            <input name="nome" class="form-control" value="${cliente.nome}" required="true"/><br/>
                        </div>   
                        <div class="form-group col-lg-4">
                            <b><p>Email</p></b>
                            <input  name="email" class="form-control" value="${cliente.email}" required="true"/><br/>                
                        </div> 
                        <div class="form-group col-lg-3">
                            <b><p>CPF</p><b>       
                            <input name="cpf" class="form-control" value="${cliente.cpf}" readonly="true"/><br/>    
                        </div>
                        <div class="form-group col-lg-10">
                            <b><p>Celular</p></b>
                            <input name="celular" class="form-control" value="${cliente.celular}" required="true"/><br/>
                        </div>
                    </div>
                    <button type="submit" class="btn btn-primary">Enviar</button>            
                
            </div>
            </form>             
                        
    </body>
</html>
