package ufes.models;

public class Usuario {

    private Integer id;
    private String nome;
    private String senha;
    private String login;

    public Usuario(Integer id, String nome, String senha, String login) {
        this.id = id;
        this.nome = nome;
        this.senha = senha;
        this.login = login;
    }

    public Usuario(String nome, String senha, String login) {
        this.nome = nome;
        this.senha = senha;
        this.login = login;
    }

    public Integer getId() {
        return id;
    }

    public String getNome() {
        return nome;
    }

    public String getSenha() {
        return senha;
    }

    public String getLogin() {
        return login;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public void setSenha(String senha) {
        this.senha = senha;
    }

    public void setLogin(String login) {
        this.login = login;
    }

    @Override
    public String toString() {
        return this.nome;
    }
}
