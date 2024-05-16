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
        <form action="./Cadastrar" method="post">
        <div id="cadastro">
        <div class="container">
        <div class="container-header">
            <h2>Cadastre-se</h2>
        </div>
        <div class="container-cadastro">
            <div class="container-user">
            <label for="nome">Nome</label>
            <input type="text" id="usuario" name="nome" class="form-control" autocomplete="off" required>
        </div>
        <div class="container-user">
            <label for="senha">Senha</label>
            <input type="password" id="password" name="senha" class="form-control"  autocomplete="off" required>
        </div>
        <div class="container-user">
            <label for="email">E-mail</label>
            <input type="text" id="email" name="email" class="form-control"  autocomplete="off">
        </div>
        <div class="container-user">
            <label for="cpf">Cpf</label>
            <input type="text" id="cpf" name="cpf" class="form-control"  autocomplete="off">
        </div>
        <div class="container-user">
            <label for="tel">Telefone</label>
            <input type="text" id="tel" name="telefone" class="form-control"  autocomplete="off">
        </div>

        </div>
        <div class="buttons">
            <button class="butt" id="confBtn" type="submit">Logar</button>
                    </div>
                </div>
            </form>
            </div>
        </main>
         <script src="./js/cadastro.js" type="text/javascript"></script>
    </body>
</html>
