<!DOCTYPE html>
<html lang="pt-br">

    <%@ page contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
    <%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>

    <head>
        <!-- Link para o Bootstrap 5.3 via CDN -->
        <link href="https://cdn.jsdelivr.net/npm/bootstrap@5.3.0-alpha1/dist/css/bootstrap.min.css"
            rel="stylesheet">
        <link rel="stylesheet" href="../../../styles/header.css">
    </head>

    <body>
        <header class="d-flex flex-wrap justify-content-center py-3 mb-4 border-bottom px-5"
            style="background-color: #FDFAE7;">
            <a href="/pages/jsp/index.jsp" class="me-md-auto">
                <img src="/assets/logo.png" alt="Logo" height="65">
            </a>

            <ul class="nav nav-pills">
                <li class="nav-item align-content-center text-center" id="username" style="cursor: pointer;">
                    <c:if test="${not empty usuariologado}">
                        <strong>${usuariologado.nome}</strong> 
                    </c:if>
                    <div class="options-header">
                        <a href="/logout" class="btn btn-secondary">Sair</a>
                    </div>
                </li>
            </ul>
        </header>

        <!-- Scripts do Bootstrap 5.3 -->
        <script src="https://cdn.jsdelivr.net/npm/@popperjs/core@2.11.6/dist/umd/popper.min.js"></script>
        <script src="https://cdn.jsdelivr.net/npm/bootstrap@5.3.0-alpha1/dist/js/bootstrap.bundle.min.js"></script>
    </body>

</html>