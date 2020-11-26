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
                    <div class="alert alert-danger" role="alert">
                        Usuário/Senha inválidos!
                    </div>
                </c:if>
                <form action="Login" method="POST">
                    <div class="row">
                        <div class="form-group col-lg-10">
                            <p>Login</p>
                            <input name="login" class="form-control" required="true"/>
                        </div>
                    </div>
                    <div class="row">
                        <div class="form-group col-lg-10">
                            <p>Senha</p>
                            <input type="password" name="senha" class="form-control" required="true"/>
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