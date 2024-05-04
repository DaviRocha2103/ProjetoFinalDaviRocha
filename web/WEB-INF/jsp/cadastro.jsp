<%-- 
    Document   : cadastro
    Created on : 30/04/2024, 14:41:23
    Author     : Senai
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <link href="./style/cadastro.css" rel="stylesheet" type="text/css"/>
        <title>Dv Skate Shop - Davi Rocha</title>
    </head>

    <body>
        <header>
            <img src="./assets/logo.png" alt=""/>
        </header>
        <main>
        <div id="cadastro">
        <form class="container">
        <div class="container-header">
            <h2>Cadastre-se</h2>
        </div>
        <div class="container-cadastro">
            <div class="container-user">
            <label for="usuario">Usuário</label>
            <input type="text" id="usuario" name="user" autocomplete="off">
        </div>
        <div class="container-user">
            <label for="password">Senha</label>
            <input type="password" id="password" name="passw" autocomplete="off">
        </div>
        <div class="container-user">
            <label for="email">E-mail</label>
            <input type="text" id="email" name="emai" autocomplete="off">
        </div>
        <div class="container-user">
            <label for="cpf">Cpf</label>
            <input type="text" id="cpf" name="cpf" autocomplete="off">
        </div>
        <div class="container-user">
            <label for="tel">Telefone</label>
            <input type="text" id="tel" name="tel" autocomplete="off">
        </div>

        </div>
        <div class="buttons">
        <a class="butt" href="#">Cadastrar</a>
                    </div>
                </form>
            </div>
    </body>
</html>
