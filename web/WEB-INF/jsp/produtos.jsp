<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Produtos</title>
    </head>
    <body>
        <header>
        <jsp:include page="header.jsp"></jsp:include>
        </header>
        <main>
            <c:forEach items="${produtos}" var="produto">
                <div class="card" style="width: 18rem;">
                    <img src="${produto.imagem}" alt="${produto.nome}">
                    <div class="card-body">
                      <h5 class="card-title">${produto.nome}</h5>
                      <p class="card-text">${produto.descricao}</p>
                      <p class="card-text">${produto.preco}</p>
                      <p class="card-text">${produto.quantidade}</p>
                      <a href="#" class="btn btn-primary">Comprar</a>
                    </div>
                  </div>
            </c:forEach>

        </main>
    </body>
</html>
