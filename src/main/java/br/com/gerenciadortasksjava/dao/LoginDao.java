package br.com.gerenciadortasksjava.dao;

import br.com.gerenciadortasksjava.model.LoginModel;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

public class LoginDao {
    public boolean verificarLogin(LoginModel login) {
        String SQL = "SELECT * FROM TB_USUARIO WHERE EMAIL = ?";

        try{
            Connection connection = DriverManager.getConnection("jdbc:h2:~/test", "sa", "sa");

            PreparedStatement preparedStatement = connection.prepareStatement(SQL);

            preparedStatement.setString( 1, login.getEmail());

            ResultSet resultSet = preparedStatement.executeQuery();

            while (resultSet.next()){
                String senha = resultSet.getString("SENHA");

                if(senha.equals(login.getSenha())){
                    return true;
                }
            }

            connection.close();

            return false;
        } catch (Exception e){
            System.out.println("Error:" + e.getMessage());
            return false;
        }
    }
}