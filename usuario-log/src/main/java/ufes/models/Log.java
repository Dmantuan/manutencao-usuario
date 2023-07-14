package ufes.models;

import java.time.LocalDateTime;

public class Log {
    
    private final String nome;
    private final String data;
    private final String hora;
    private final String operacao;
    
    public Log(String nome, String operacao){
        LocalDateTime dataAux = LocalDateTime.now();
        this.nome = nome;
        this.hora = String.valueOf(dataAux.getHour())+":"+String.valueOf(dataAux.getMinute())+":"+String.valueOf((dataAux.getSecond()));
        this.data = dataAux.getDayOfMonth()+"/"+dataAux.getMonth().toString()+"/"+dataAux.getYear();
        this.operacao = operacao;
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

    public String getNome() {
        return nome;
    }
    
    @Override
    public String toString(){
        return this.data +";"+ this.hora +";"+this.operacao;
    }
}
