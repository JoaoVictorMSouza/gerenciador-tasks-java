package br.com.gerenciadortasksjava.servlet;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpServlet;

import br.com.gerenciadortasksjava.dao.TarefaDao;
import br.com.gerenciadortasksjava.model.TarefaModel;
import br.com.gerenciadortasksjava.model.UsuarioModel;

@WebServlet("/concluirtarefa")
public class ConcluirTarefaServlet extends HttpServlet {
    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        int id = Integer.parseInt(req.getParameter("id"));
        Boolean concluida = req.getParameter("concluida").equals("1");

        UsuarioModel usuario = (UsuarioModel) req.getSession().getAttribute("usuariologado");

        if (usuario == null) {
            req.setAttribute("message", "Usuário não autenticado");
            req.getRequestDispatcher("/pages/jsp/login.jsp").forward(req, resp);
        }

        TarefaDao tarefaDao = new TarefaDao();

        TarefaModel tarefa = tarefaDao.consultarTarefaPeloIdeIdUsuario(id, usuario.getId());

        if (tarefa == null) {
            req.setAttribute("message", "Tarefa não encontrada");
            req.getRequestDispatcher("/pages/jsp/index.jsp").forward(req, resp);
        }

        tarefa.setConcluida(concluida);

        tarefaDao.concluirTarefa(tarefa);

        resp.sendRedirect(req.getContextPath() + "/tarefa");
    }

}
