
<!DOCTYPE html>
<html lang="pt-br">

<%@ page contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>

<head>
  <meta charset="UTF-8">
  <meta name="viewport" content="width=device-width, initial-scale=1.0">
  <title>Home</title>

  <!-- Link para o Bootstrap 5.3 via CDN -->
  <link href="https://cdn.jsdelivr.net/npm/bootstrap@5.3.0-alpha1/dist/css/bootstrap.min.css" rel="stylesheet">
</head>

<body>
    <%@ include file="../../../pages/jsp/shared/header.jsp" %>

    <section class="vh-100">
        <div class="container py-5 h-100">
            <a href="/criartarefa" class="btn btn-success">Adicionar tarefa</a>
            <table class="table">
                <thead>
                    <tr>
                        <th>#</th>
                        <th>Nome</th>
                        <th>Descrição</th>
                        <th>Concluída</th>
                        <th></th>
                        <th></th>

                    </tr>
                </thead>
                <tbody>
                    <c:forEach var="tarefa" items="${listatarefa}">
                        <tr class="align-middle">
                            <td>${tarefa.id}</td>
                            <td>${tarefa.titulo}</td>
                            <td>${tarefa.descricao}</td>
                            <td>
                                <c:if test="${tarefa.concluida}">
                                    <span>Sim</span>
                                </c:if>
                                <c:if test="${not tarefa.concluida}">
                                    <span>Não</span>
                                </c:if>
                            </td>
                            <td>
                                <c:if test="${not tarefa.concluida}">
                                    <form action="/concluirtarefa" method="post">
                                        <input type="hidden" name="id" value="${tarefa.id}">
                                        <input type="hidden" name="concluida" value="1">
                                        <button type="submit" class="btn btn-primary">Concluir</button>
                                    </form>
                                </c:if>
                                <c:if test="${tarefa.concluida}">
                                    <form action="/concluirtarefa" method="post">
                                        <input type="hidden" name="id" value="${tarefa.id}">
                                        <input type="hidden" name="concluida" value="0">
                                        <button type="submit" class="btn btn-primary">Voltar tarefa</button>
                                    </form>
                                </c:if>
                            </td>
                            <td>
                                <form action="/excluirtarefa" method="post">
                                    <input type="hidden" name="id" value="${tarefa.id}">
                                    <button type="submit" class="btn btn-danger">Excluir</button>
                                </form>
                            </td>
                        </tr>
                    </c:forEach>

                </tbody>
            </table>
        </div>
    </section>

  <!-- Scripts do Bootstrap 5.3 -->
  <script src="https://cdn.jsdelivr.net/npm/@popperjs/core@2.11.6/dist/umd/popper.min.js"></script>
  <script src="https://cdn.jsdelivr.net/npm/bootstrap@5.3.0-alpha1/dist/js/bootstrap.bundle.min.js"></script>

</body>

</html>