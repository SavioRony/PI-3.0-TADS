<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Login</title>
    </head>
    <%@include file="header.jsp" %>
    <style>
        .container {
            width: 100vw;
            height: 100vh;
            display: flex;
            flex-direction: row;
            justify-content: center;
            align-items: center
        }
        .box {
            -webkit-box-shadow: -1px -1px 1px #C9C9C9, 1px 1px 1px #C9C9C9;
            width: 400px;
            height: 400px;
            background: #fff;
        }
        body {
            margin: 0px;
            background: #f8f9fa;
        }
        p{
            font-weight: bolder;
            font-size: 16px;
        }
        .row{
            justify-content: center;
        }
        button{
            text-align: center;
        }
    </style>
    <body>
        <div class="container">
            <div class="box">
                <br/>
                <div class="row">
                    <img id="logo-sporttads" src="img/lg.png">
                </div>
                <br/>
                <c:if test="${param.erro != null}">
                    <script>
                        $.notify("Usuário/Senha inválidos!", "error");
                    </script>
                </c:if>
                <form action="Login" method="POST">
                    <div class="row">
                        <div class="form-group col-lg-10">
                            <p>Usuário</p>
                            <input name="login" placeholder="Digite seu usuário..." class="form-control" required="true"/>
                        </div>
                    </div>
                    <div class="row">
                        <div class="form-group col-lg-10">
                            <p>Senha</p>
                            <input type="password" placeholder="Digite sua senha..." name="senha" class="form-control" required="true"/>
                        </div>
                    </div>
                    <br/>
                    <center>
                        <button type="submit" class="btn btn-primary">Fazer Login</button>
                    </center>
                </form>
            </div>
        </div>
    </body>
</html>