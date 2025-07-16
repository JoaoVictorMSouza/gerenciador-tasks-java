package br.com.gerenciadortasksjava.servlet;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import br.com.gerenciadortasksjava.dao.TarefaDao;
import br.com.gerenciadortasksjava.model.TarefaModel;
import br.com.gerenciadortasksjava.model.UsuarioModel;

@WebServlet("/criartarefa")
public class CriarTarefaServlet extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        req.getRequestDispatcher("/pages/jsp/inserirtarefa.jsp").forward(req, resp);
    }

    @Override
    protected void doPost (HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String titulo = req.getParameter("titulo");
        String descricao = req.getParameter("descricao");
        Boolean concluida = false;

        UsuarioModel usuario = (UsuarioModel) req.getSession().getAttribute("usuariologado");

        if (usuario == null) {
            req.setAttribute("message", "Usuário não autenticado");
            req.getRequestDispatcher("/pages/jsp/login.jsp").forward(req, resp);
        }

        TarefaModel tarefa = new TarefaModel(titulo, descricao, concluida, usuario.getId());

        TarefaDao tarefaDao = new TarefaDao();
        tarefaDao.criarTarefa(tarefa);

        resp.sendRedirect(req.getContextPath() + "/tarefa");
    }
}
