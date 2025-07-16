package br.com.gerenciadortasksjava.servlet;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.*;

import br.com.gerenciadortasksjava.dao.TarefaDao;
import br.com.gerenciadortasksjava.model.TarefaModel;
import br.com.gerenciadortasksjava.model.UsuarioModel;

@WebServlet("/tarefa")
public class TarefaServlet extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        UsuarioModel usuario = (UsuarioModel) req.getSession().getAttribute("usuariologado");

        if (usuario == null) {
            req.setAttribute("message", "Usuário não autenticado");
            req.getRequestDispatcher("/pages/jsp/login.jsp").forward(req, resp);
        }

        TarefaDao tarefaDao = new TarefaDao();
        List<TarefaModel> tarefas = tarefaDao.consultarTerafaPeloIdUsuario(usuario);
        HttpSession session = req.getSession();
        session.setAttribute("listatarefa", tarefas);

        resp.sendRedirect(req.getContextPath() + "/pages/jsp/index.jsp"); // Redireciona para a página home após o login bem-sucedido
    }
}
