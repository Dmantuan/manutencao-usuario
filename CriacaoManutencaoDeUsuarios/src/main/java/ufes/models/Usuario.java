package ufes.models;

import java.time.LocalDateTime;

public class Usuario {

    private Integer id;
    private String nome;
    private String senha;
    private String login;
    private LocalDateTime data;
    private Boolean admin;
    private Boolean autorizado;

    public Usuario(Integer id, String nome, String senha, String login, LocalDateTime data, Boolean admin, Boolean autorizado) {
        this.id = id;
        this.nome = nome;
        this.senha = senha;
        this.login = login;
        this.data = data;
        this.admin = admin;
        this.autorizado = autorizado;
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

    public LocalDateTime getData() {
        return data;
    }

    public Boolean getAdmin() {
        return admin;
    }

    public Boolean getAutorizado() {
        return autorizado;
    }
    
    @Override
    public String toString() {
        return this.nome;
    }
}
