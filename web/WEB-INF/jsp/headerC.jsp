<%-- 
    Document   : headerC
    Created on : 05/06/2024, 14:00:21
    Author     : Senai
--%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>header</title>
        <link href="./style/headerC.css" rel="stylesheet" type="text/css"/>
        <script src="https://kit.fontawesome.com/6fbfeb6bdb.js" crossorigin="anonymous"></script>
    </head>
    <body>
        <header>
            
            <div class="pesquisa">
                <form action="buscarProdutos" method="get">
                <input type="text" class="search-txt" placeholder="Pesquisar">
                <button class="searchbtn"><i class="fa-solid fa-magnifying-glass" style="color: #ffffff;" id="ico"></i></button>
                </a>
                 </form>
            </div>
           
            <div class="logo">
                <img id="logo" src="./assets/logo.png" alt=""/>
            </div>
            <div class="barra">
                <i  class="fa-solid fa-bars" style="color: #000000;"></i>
            </div>
            <div class="user">
                <i class="fa-solid fa-user" style="color: #000000;"></i>
                </div>
            <div class="cart">
                <i class="fa-solid fa-cart-shopping" style="color: #000000;"></i>
            </div>
            <div class="container-categorias">
                    <c:forEach items="${categorias}" var="categoria" >
                        <div class="categoria">
                            <a href="./buscarProdutos?cat=${categoria.idCategoria}&busca=">${categoria.nome}</a>
                        </div>
                    </c:forEach>
                </div>
        </header>
    </body>
</html>
