package ufes.models;

import java.time.LocalDateTime;

public class Log {
    private final String data;
    private final String hora;
    private final String operacao;
    
    public Log(String operacao){
        LocalDateTime dataAux = LocalDateTime.now();
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
    
    @Override
    public String toString(){
        return this.data +";"+ this.hora +";"+this.operacao;
    }
}
