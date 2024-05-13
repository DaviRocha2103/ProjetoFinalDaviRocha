<%-- 
    Document   : cadastroProdutos
    Created on : 06/05/2024, 14:46:17
    Author     : Senai
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html lang="pt-br">
<head>
    <meta charset="UTF-8">
    <title>Cadastro de Produto</title>
   
    <link href="./style/cadastroProduto.css" rel="stylesheet" type="text/css"/>
</head>
<body>
    <header>
        <div class="cabeçalho">
            <img src="./assets/logosemfundo.png" alt="">
        <div class="titulo">
            <h2>Cadastro De Produto</h2>
        </div>
    </div> 
        
    </header>
     <div id="cadastroProduto">
    <div class="container">
        <form action="cadastroProduto" method="POST" enctype="multipart/form-data">
            <div class="form-group">
                <label for="nome">Nome:</label>
                <input type="text" class="form-control" id="nome" name="nome" required>
            </div>
            <div class="form-group">
                <label for="categoria">Categoria:</label>
                <select class="form-control" id="categoria" name="categoria">
                    <option value="1">Camisetas</option>
                    <option value="2">Calças</option>
                    <option value="3">Tenis</option>
                    <option value="4">Shape</option>
                    <option value="5">Truck</option>
                    <option value="6">Rodas</option>    
                    <option value="7">Lixas</option>
                    <option value="8">Rolamentos</option>
                    <option value="5">Parafusos</option>
                </select>
            </div>
            <div class="form-group">
                <label for="valor">Valor:</label>
                <input type="number" step="0.01" class="form-control" id="valor" name="valor" required>
            </div>
            <div class="form-group">
                <label for="descricao">Descrição:</label>
                <textarea class="form-control" id="descricao" name="descricao" rows="3"></textarea>
            </div>
            <div class="form-group">
                <label for="imagem">Imagem do Produto:</label>
                <input type="file" class="form-control-file" id="imagem" name="imagem">
            </div>
            <div class="buttons">
            <button class="butt" type="submit" class="btn btn-primary">Cadastrar</button>
            </div>
        </form>
    </div>
     </div>
    <script src="https://ajax.googleapis.com/ajax/libs/jquery/3.5.1/jquery.min.js"></script>
    <script src="https://cdnjs.cloudflare.com/ajax/libs/popper.js/1.16.0/umd/popper.min.js"></script>
    <script src="https://maxcdn.bootstrapcdn.com/bootstrap/4.5.2/js/bootstrap.min.js"></script>
</body>
</html>


