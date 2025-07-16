package br.com.gerenciadortasksjava.dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

import br.com.gerenciadortasksjava.model.TarefaModel;
import br.com.gerenciadortasksjava.model.UsuarioModel;

public class TarefaDao {
    public List<TarefaModel> consultarTerafaPeloIdUsuario(UsuarioModel usuarioModel) {
        String comandoSql = "SELECT * FROM TB_TAREFA WHERE ID_USUARIO = ?";

        try {
            Connection connection = DriverManager.getConnection("jdbc:h2:~/test", "sa", "sa");

            PreparedStatement preparedStatement = connection.prepareStatement(comandoSql);

            preparedStatement.setInt( 1, usuarioModel.getId());


            ResultSet resultSet = preparedStatement.executeQuery();
            ArrayList<TarefaModel> listaTarefa = new ArrayList<TarefaModel>();


            while (resultSet.next()){
                int idTarefa = resultSet.getInt("ID_TAREFA");
                String titulo = resultSet.getString("TITULO");
                String descricao = resultSet.getString("DESCRICAO");
                Boolean concluida = resultSet.getBoolean("CONCLUIDA");
                int idUsuario = resultSet.getInt("ID_USUARIO");

                TarefaModel tarefa = new TarefaModel(idTarefa, titulo, descricao, concluida, idUsuario);

                listaTarefa.add(tarefa);
            }

            return listaTarefa;
        } catch (Exception e){
            System.out.println("Error ao consultar tarefas - " + e.getMessage());
            return null;
        }
    }

    public void concluirTarefa(TarefaModel tarefa) {
        String comandoSql = "UPDATE TB_TAREFA SET CONCLUIDA = ? WHERE ID_TAREFA = ? AND ID_USUARIO = ?";

        try {
            Connection connection = DriverManager.getConnection("jdbc:h2:~/test", "sa", "sa");

            PreparedStatement preparedStatement = connection.prepareStatement(comandoSql);

            preparedStatement.setBoolean(1, tarefa.isConcluida());
            preparedStatement.setInt(2, tarefa.getId());
            preparedStatement.setInt(3, tarefa.getIdUsuario());

            preparedStatement.execute();

            connection.close();
        } catch (Exception e) {
            System.out.println("Erro ao concluir tarefa - " + e.getMessage());
        }
    }

    public void criarTarefa(TarefaModel tarefa) {
        String comandoSql = "INSERT INTO TB_TAREFA (TITULO, DESCRICAO, CONCLUIDA, ID_USUARIO) VALUES (?, ?, ?, ?)";

        try {
            Connection connection = DriverManager.getConnection("jdbc:h2:~/test", "sa", "sa");

            PreparedStatement preparedStatement = connection.prepareStatement(comandoSql);

            preparedStatement.setString(1, tarefa.getTitulo());
            preparedStatement.setString(2, tarefa.getDescricao());
            preparedStatement.setBoolean(3, tarefa.isConcluida());
            preparedStatement.setInt(4, tarefa.getIdUsuario());

            preparedStatement.execute();

            connection.close();
        } catch (Exception e) {
            System.out.println("Erro ao criar tarefa - " + e.getMessage());
        }
    }

    public void excluirtarefa(TarefaModel tarefa) {
        String comandoSql = "DELETE FROM TB_TAREFA WHERE ID_TAREFA = ? AND ID_USUARIO = ?";

        try {
            Connection connection = DriverManager.getConnection("jdbc:h2:~/test", "sa", "sa");

            PreparedStatement preparedStatement = connection.prepareStatement(comandoSql);

            preparedStatement.setInt(1, tarefa.getId());
            preparedStatement.setInt(2, tarefa.getIdUsuario());

            preparedStatement.execute();

            connection.close();
        } catch (Exception e) {
            System.out.println("Erro ao excluir tarefa - " + e.getMessage());
        }
    }

    public TarefaModel consultarTarefaPeloIdeIdUsuario(int id, int idUsuario) {
        String comandoSql = "SELECT * FROM TB_TAREFA WHERE ID_TAREFA = ? AND ID_USUARIO = ?";

        try {
            Connection connection = DriverManager.getConnection("jdbc:h2:~/test", "sa", "sa");

            PreparedStatement preparedStatement = connection.prepareStatement(comandoSql);

            preparedStatement.setInt(1, id);
            preparedStatement.setInt(2, idUsuario);

            ResultSet resultSet = preparedStatement.executeQuery();

            if (resultSet.next()) {
                int idTarefa = resultSet.getInt("ID_TAREFA");
                String titulo = resultSet.getString("TITULO");
                String descricao = resultSet.getString("DESCRICAO");
                Boolean concluida = resultSet.getBoolean("CONCLUIDA");
                int idUsuarioTarefa = resultSet.getInt("ID_USUARIO");

                TarefaModel tarefa = new TarefaModel(idTarefa, titulo, descricao, concluida, idUsuarioTarefa);

                return tarefa;
            } else {
                return null;
            }
        } catch (Exception e) {
            System.out.println("Erro ao consultar tarefa - " + e.getMessage());
            return null;
        }
    }
}
