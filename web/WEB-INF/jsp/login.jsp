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
        <link href="./style/login.css" rel="stylesheet" type="text/css"/>
        <title>Dv Skate Shop - Davi Rocha</title>
    </head>

    <body>
        <header>
            <img src="./assets/logo.png" alt=""/>
        </header>
        <main>
        <form action="logar" id="formulario" method="post">  
        <div id="login">
        <div class="container">
        <div class="container-header">
            <h2>Login</h2>
        </div>
        <div class="container-login">
            <div class="container-user">
            <label for="nome">Nome</label>
            <input type="text" id="usuario" class="form-control" name="nome" autocomplete="off" required>
        </div>
        <div class="container-user">
            <label for="password">Senha</label>
            <input type="password" id="password" class="form-control" name="senha" autocomplete="off" required>
        </div>

        </div>
        <div class="buttons">
            <button class="butt" type="submit">Login</button>
        <a href="./Cadastro" class="cadastrar">Não tem uma conta? Registre-se</a>
                    </div>
            </div>
        </div>
            </form>
        </main>
    </body>
    <script src="./js/login.js"></script>
</html>
