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
        <link href="./style/header.css" rel="stylesheet" type="text/css"/>
        <script src="https://kit.fontawesome.com/6fbfeb6bdb.js" crossorigin="anonymous"></script>
    </head>
    <body>
        <header>
        
            <div class="pesquisa">
                <input type="text" class="search-txt" placeholder="Pesquisar">
                <a href="./index" class="searchbtn">
                <i class="fa-solid fa-magnifying-glass" style="color: #ffffff;"></i>
                </a>
            </div>
            <div >
                <img id="logo" src="./assets/logo.png" alt=""/>
            </div>
            <div class="barra">
                <i  class="fa-solid fa-bars" style="color: #000000;"></i>
            </div>
            <div class="container container-categorias">
                    <c:forEach items="${categorias}" var="categoria" >
                        <div class="categoria">
                            <a href="./buscarPodutos?cat=${categoria.idCategoria}&busca=">${categoria.nome}</a>
                        </div>
                    </c:forEach>
                </div>
        </header>
    </body>
</html>
