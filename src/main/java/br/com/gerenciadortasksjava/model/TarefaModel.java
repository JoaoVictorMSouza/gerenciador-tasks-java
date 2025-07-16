package br.com.gerenciadortasksjava.model;

public class TarefaModel {
    private int id;
    private String titulo;
    private String descricao;
    private Boolean concluida;
    private int idUsuario;

    public int getId() {
        return id;
    }
    public void setId(int id) {
        this.id = id;
    }

    public String getTitulo() {
        return titulo;
    }
    public void setTitulo(String titulo) {
        this.titulo = titulo;
    }

    public String getDescricao() {
        return descricao;
    }
    public void setDescricao(String descricao) {
        this.descricao = descricao;
    }

    public boolean isConcluida() {
        return concluida;
    }
    public void setConcluida(boolean concluida) {
        this.concluida = concluida;
    }

    public int getIdUsuario() {
        return idUsuario;
    }
    public void setIdUsuario(int idUsuario) {
        this.idUsuario = idUsuario;
    }

    public TarefaModel(int id, String titulo, String descricao, Boolean concluida, int idUsuario) {
        this.id = id;
        this.titulo = titulo;
        this.descricao = descricao;
        this.concluida = concluida;
        this.idUsuario = idUsuario;
    }

    public TarefaModel(String titulo, String descricao, Boolean concluida, int idUsuario) {
        this.titulo = titulo;
        this.descricao = descricao;
        this.concluida = concluida;
        this.idUsuario = idUsuario;
    }
}
