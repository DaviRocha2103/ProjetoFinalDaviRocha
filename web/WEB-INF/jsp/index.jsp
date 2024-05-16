<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN"
    "http://www.w3.org/TR/html4/loose.dtd">

<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <link href="./style/index.css" rel="stylesheet" type="text/css"/>
        <link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/4.5.2/css/bootstrap.min.css">
        <title>Dv Skate Shop - Davi Rocha</title>
    </head>

    <body>
            <jsp:include page="header.jsp"></jsp:include>
            <div class="container">
        <h1 class="my-4">Listagem de Produtos</h1>
        <div class="row">
            <c:forEach var="produto" items="${produtos}">
                <div class="col-md-4 mb-3">
                    <div class="card card-custom">
                        <div class="card-body">
                            <div class="imagemProduto">
                                <img src="data:image/jpg;base64,${produto.imagemBase64}" alt="${produto.nome}">
                            </div>
                            <h5 class="card-title">${produto.nome}</h5>
                            <p class="card-text">Valor: R$ ${produto.preco}</p>
                        </div>
                    </div>
                </div>
            </c:forEach>
        </div>
    </div>
    </body>
    
</html>
    

