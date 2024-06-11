<%-- 
    Document   : produto
    Created on : 07/05/2024, 14:47:41
    Author     : Senai
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <link href="./style/pgProduto.css" rel="stylesheet" type="text/css"/>
        <title>${produto.nome}</title>
    </head>
    <body>
        <header>
        <jsp:include page="headerC.jsp"></jsp:include>
        </header>
        <div class="linha"></div>
        <div class="container">

            <div class="esquerda">
                <img src="${produto.imagem}" alt="">
            </div>

            <div class="direita">
                <h1>${produto.nome}</h1>
                <h2 class="prec">${produto.preco}</h2>
                <div class="tamQ">
                <h4>Tamanho</h4>
                <h3>Quantidade</h3>
            </div>
                <div class="Req">
                <select class="form-control" id="tamanho" name="tamanho">
                    <option value="1">P</option>
                    <option value="2">M</option>
                    <option value="3">G</option>
                    <option value="4">GG</option>
                    <option value="5">XG</option>
                </select>
                <input type="number" step="1" class="Qnt" id="quantidade" name="quantidade" required required onchange="forceStartsWithOne(this)">
                
                </div>
                <div class="bot">
                <button class="but" type="submit">Adicionar Ao Carrinho</button>
            </div>
                <div class="traco"></div>
                <h2 class="des">Descrição</h2>
            </div>
            
    </body>
    <script src="./js/inputnum.js"></script>
</html>
