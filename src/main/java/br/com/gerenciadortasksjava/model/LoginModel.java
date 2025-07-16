package br.com.gerenciadortasksjava.model;

public class LoginModel {
    private String email;
    private String senha;

    public LoginModel(String email, String senha) {
        this.email = email;
        this.senha = senha;
    }

    public String getEmail() {
        return email;
    }

    public String getSenha() {
        return senha;
    }
}
