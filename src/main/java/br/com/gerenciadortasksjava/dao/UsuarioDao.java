package br.com.gerenciadortasksjava.dao;

import br.com.gerenciadortasksjava.model.UsuarioModel;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

public class UsuarioDao {
    public void criarUsuario(UsuarioModel usuario) {
        String comandoSql = "INSERT INTO TB_USUARIO (NOME, EMAIL, SENHA) VALUES (?, ?, ?)";

        try {
            Connection connection = DriverManager.getConnection("jdbc:h2:~/test", "sa","sa");

            PreparedStatement preparedStatement = connection.prepareStatement(comandoSql);

            preparedStatement.setString(1, usuario.getNome());
            preparedStatement.setString(2, usuario.getEmail());
            preparedStatement.setString(3, usuario.getSenha());

            preparedStatement.execute();

            connection.close();
        } catch (Exception e) {
            System.out.println("Erro ao inserir usuario - " + e.getMessage());
        }
    }

    public void excluirUsuario(UsuarioModel usuario) {
        String comandoSql = "DELETE FROM TB_USUARIO WHERE ID_USUARIO = ?";

        try{
            Connection connection = DriverManager.getConnection("jdbc:h2:~/test", "sa", "sa");

            PreparedStatement preparedStatement = connection.prepareStatement(comandoSql);

            preparedStatement.setInt( 1, usuario.getId());

            preparedStatement.execute();

            connection.close();
        } catch (Exception e){
            System.out.println("Error ao excluir usuario - " + e.getMessage());
        }
    }

    public UsuarioModel consultarUsuarioPeloEmail(String email) {
        String comandoSql = "SELECT * FROM TB_USUARIO WHERE EMAIL = ?";

        try{
            Connection connection = DriverManager.getConnection("jdbc:h2:~/test", "sa", "sa");

            PreparedStatement preparedStatement = connection.prepareStatement(comandoSql);

            preparedStatement.setString( 1, email);

            ResultSet resultSet = preparedStatement.executeQuery();

            System.out.println("Sucesso!");

            while (resultSet.next()){
                int id = resultSet.getInt("ID_USUARIO");
                String nome = resultSet.getString("NOME");
                return new UsuarioModel(id, nome);
            }

            connection.close();

            return null;
        } catch (Exception e){
            System.out.println("Error ao consultar usuario -" + e.getMessage());
            return null;
        }
    }
}
