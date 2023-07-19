package ufes.models;

import java.time.LocalDateTime;

public class Log {
    
    private final String error;
    private final String operacao;
    private final String nome;
    private final String user;
    private final String data;
    private final String hora;
    
    public Log(String nome, String user, String operacao){
        LocalDateTime dataAux = LocalDateTime.now();
        this.user = user;
        this.nome = nome;
        this.hora = String.valueOf(dataAux.getHour())+":"+String.valueOf(dataAux.getMinute())+":"+String.valueOf((dataAux.getSecond()));
        this.data = dataAux.getDayOfMonth()+"/"+dataAux.getMonth().toString()+"/"+dataAux.getYear();
        this.operacao = operacao;
        this.error = null; // ver isso aki
    }
    
    public Log(String nome, String user, String operacao, String error){
        LocalDateTime dataAux = LocalDateTime.now();
        this.user = user;
        this.nome = nome;
        this.hora = String.valueOf(dataAux.getHour())+":"+String.valueOf(dataAux.getMinute())+":"+String.valueOf((dataAux.getSecond()));
        this.data = dataAux.getDayOfMonth()+"/"+dataAux.getMonth().toString()+"/"+dataAux.getYear();
        this.operacao = operacao ;
        this.error = error;
    }

    public String getData() {
        return data;
    }

    public String getHora() {
        return hora;
    }

    public String getOperacao() {
        return operacao;
    }

    public String getUser() {
        return user;
    }

    public String getError() {
        return error;
    }

    public String getNome() {
        return nome;
    }
    
    
}
