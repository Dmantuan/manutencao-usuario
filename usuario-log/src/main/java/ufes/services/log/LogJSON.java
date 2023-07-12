package ufes.services.log;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import ufes.models.Log;
import ufes.services.arquivo.EscritaEmArquivoJSON;
import ufes.services.arquivo.GerenciadorEscritaArquivo;

public class LogJSON implements ILog{
    
    private Gson gson;
    private EscritaEmArquivoJSON arquivo;
    
    public LogJSON(){
        this.gson  = new GsonBuilder().setPrettyPrinting().create();
        this.arquivo = EscritaEmArquivoJSON.getInstancia();
    }
    
    @Override
    public void salvarLog(Log log){
        GerenciadorEscritaArquivo.escrever(arquivo, this.gson.toJson(log));
        System.out.println(this.gson.toJson(log));
    }
}
