package br.com.gerenciadortasksjava.servlet;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import br.com.gerenciadortasksjava.dao.UsuarioDao;
import br.com.gerenciadortasksjava.model.UsuarioModel;

@WebServlet("/criarusuario")
public class UsuarioServlet extends HttpServlet {
    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String nome = request.getParameter("nome");
        String email = request.getParameter("email");
        String senha = request.getParameter("senha");

        UsuarioModel usuario = new UsuarioModel();
        usuario.setNome(nome);
        usuario.setEmail(email);
        usuario.setSenha(senha);

        UsuarioDao usuarioDao = new UsuarioDao();

        usuarioDao.criarUsuario(usuario);

        response.sendRedirect(request.getContextPath() + "/pages/jsp/login.jsp");
    }
}
