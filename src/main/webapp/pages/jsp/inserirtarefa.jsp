<!DOCTYPE html>
<html lang="pt-br">

<%@ page contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>

<head>
  <meta charset="UTF-8">
  <meta name="viewport" content="width=device-width, initial-scale=1.0">
  <title>Cadastrar tarefa</title>

  <!-- Link para o Bootstrap 5.3 via CDN -->
  <link href="https://cdn.jsdelivr.net/npm/bootstrap@5.3.0-alpha1/dist/css/bootstrap.min.css" rel="stylesheet">
</head>

<body>

  <section class="vh-100" style="background-color: #FDFAE7;">
    <div class="container py-5 h-100">
      <div class="row d-flex justify-content-center align-items-center h-100">
        <div class="col-12 col-md-8 col-lg-6 col-xl-5">
          <div class="card shadow-2-strong" style="border-radius: 1rem;">
            <form action="/criartarefa" method="post" class="card-body p-4 text-center">

                <h3 class="mb-5">Cadastrar tarefa</h3>

                <div class="form-floating mb-3">
                    <input type="text" class="form-control" id="titulo" name="titulo" placeholder="Título">
                    <label for="titulo">Título</label>
                </div>

                <div class="form-floating mb-3">
                    <input type="text" class="form-control" id="descricao" name="descricao" placeholder="Descrição">
                    <label for="descricao">Descrição</label>
                </div>

                <c:if test="${usuariologado != null}">
                    <input type="hidden" name="idusuario" value="${usuariologado.id}">
                </c:if>

              <div class="d-flex justify-content-between">
                <a href="/tarefa" class="btn btn-primary btn-lg btn-block">Voltar</a>

                <button class="btn btn-success btn-lg btn-block" type="submit">
                  Cadastrar tarefa
                </button>
              </div>

            </form>
          </div>
        </div>
      </div>
    </div>
  </section>

  <!-- Scripts do Bootstrap 5.3 -->
  <script src="https://cdn.jsdelivr.net/npm/@popperjs/core@2.11.6/dist/umd/popper.min.js"></script>
  <script src="https://cdn.jsdelivr.net/npm/bootstrap@5.3.0-alpha1/dist/js/bootstrap.bundle.min.js"></script>

</body>

</html>