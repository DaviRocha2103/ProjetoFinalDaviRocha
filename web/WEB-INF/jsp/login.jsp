<%-- 
    Document   : login
    Created on : 30/04/2024, 14:41:16
    Author     : Senai
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <link href="./style/index.css" rel="stylesheet" type="text/css"/>
        <title>Dv Skate Shop - Davi Rocha</title>
    </head>

    <body>
        <header>
            <img src="./assets/logo.png" alt=""/>
        </header>
        <main>
        <div id="login">
        <form class="container">
        <div class="container-header">
            <h2>Login</h2>
        </div>
        <div class="container-login">
            <div class="container-user">
            <label for="nome">Nome</label>
            <input type="text" id="usuario" name="user" autocomplete="off">
        </div>
        <div class="container-user">
            <label for="password">Senha</label>
            <input type="password" id="password" name="passw" autocomplete="off">
        </div>

        </div>
        <div class="buttons">
        <a class="butt" href="./index">Login</a>
        <a href="./Cadastro" class="recuperar_senha">Não tem uma conta? Registre-se</a>
                    </div>
                </form>
            </div>
    </body>
    <script src="./js/login.js"></script>
</html>
