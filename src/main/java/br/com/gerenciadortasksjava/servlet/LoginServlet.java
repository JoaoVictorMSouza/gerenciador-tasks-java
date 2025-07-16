package br.com.gerenciadortasksjava.servlet;

import br.com.gerenciadortasksjava.dao.LoginDao;
import br.com.gerenciadortasksjava.dao.UsuarioDao;
import br.com.gerenciadortasksjava.model.LoginModel;
import br.com.gerenciadortasksjava.model.UsuarioModel;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;

@WebServlet("/login")
public class LoginServlet extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        req.getRequestDispatcher("/pages/jsp/login.jsp").forward(req, resp);
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

        String email = req.getParameter("email");
        String senha = req.getParameter("senha");

        LoginModel login = new LoginModel(email, senha);

        boolean usuarioValido = new LoginDao().verificarLogin(login);

        if(usuarioValido){
            UsuarioModel usuario = new UsuarioDao().consultarUsuarioPeloEmail(email);

            if (usuario != null && usuario.getId() > 0) {
                HttpSession session = req.getSession();
                session.setAttribute("usuariologado", usuario);
            }

            resp.sendRedirect(req.getContextPath() + "/tarefa");
        } else {
            req.setAttribute("message", "Ops! Parece que o seu nome de usuário ou senha estão incorretos. Por favor, verifique e tente novamente!");

            req.getRequestDispatcher("/pages/jsp/login.jsp").forward(req, resp); // Fica na página de login com uma mensagem de erro
        }
    }
}