package br.com.gerenciadortasksjava.servlet;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.*;
import java.io.IOException;

@WebServlet("/logout")
public class LogoutServlet extends HttpServlet {

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        req.getSession().removeAttribute("usuarioLogado");

        req.getSession().invalidate();

        resp.sendRedirect(req.getContextPath() + "/pages/jsp/login.jsp");
    }
}