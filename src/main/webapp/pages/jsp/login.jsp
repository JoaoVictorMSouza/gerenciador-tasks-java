<!DOCTYPE html>
<html lang="pt-br">

<%@ page contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>

<head>
  <meta charset="UTF-8">
  <meta name="viewport" content="width=device-width, initial-scale=1.0">
  <title>Login</title>

  <!-- Link para o Bootstrap 5.3 via CDN -->
  <link href="https://cdn.jsdelivr.net/npm/bootstrap@5.3.0-alpha1/dist/css/bootstrap.min.css" rel="stylesheet">
</head>

<body>

  <section class="vh-100" style="background-color: #FDFAE7;">
    <div class="container py-5 h-100">
      <div class="row d-flex justify-content-center align-items-center h-100">
        <div class="col-12 col-md-8 col-lg-6 col-xl-5">
          <div class="card shadow-2-strong" style="border-radius: 1rem;">
            <form action="/login" method="post" class="card-body p-4 text-center">

              <h3 class="mb-5">Login</h3>

              <div class="form-floating mb-3">
                <input type="email" class="form-control" id="email" name="email" placeholder="name@example.com">
                <label for="email">Email</label>
              </div>

              <div class="form-floating mb-3">
                <input type="password" class="form-control" id="senha" name="senha" placeholder="Senha">
                <label for="senha">Senha</label>
              </div>

              <button data-mdb-button-init data-mdb-ripple-init class="btn btn-primary btn-lg btn-block" type="submit">
                Login
              </button>

              <div>
                <p class="mb-0 mt-3">
                  Não tem uma conta? 
                  <a href="/pages/jsp/cadastro.jsp" class="text-black-50 fw-bold">Cadastre-se</a>
                </p>
              </div>
              
              <c:if test="${not empty requestScope.message}">
                <span>${requestScope.message}</span>
              </c:if>

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