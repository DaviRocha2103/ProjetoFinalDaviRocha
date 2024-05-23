<%-- 
    Document   : header
    Created on : 13/05/2024, 15:01:01
    Author     : Senai
--%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>header</title>
        <link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/4.5.2/css/bootstrap.min.css">
        <link href="./style/header.css" rel="stylesheet" type="text/css"/>
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
           
            <div >
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
            <div class="container container-categorias">
                    <c:forEach items="${categorias}" var="categoria" >
                        <div class="categoria">
                            <a href="./buscarProdutos?cat=${categoria.idCategoria}&busca=">${categoria.nome}</a>
                        </div>
                    </c:forEach>
                </div>
        </header>
    </body>
    <script src="https://kit.fontawesome.com/ffe7fbbd06.js" crossorigin="anonymous"></script>
    <script src="https://ajax.googleapis.com/ajax/libs/jquery/3.5.1/jquery.min.js"></script>
    <script src="https://cdnjs.cloudflare.com/ajax/libs/popper.js/1.16.0/umd/popper.min.js"></script>
    <script src="https://maxcdn.bootstrapcdn.com/bootstrap/4.5.2/js/bootstrap.min.js"></script>
</html>
