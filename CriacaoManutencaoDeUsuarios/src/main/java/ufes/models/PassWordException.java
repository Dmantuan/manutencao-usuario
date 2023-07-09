package ufes.models;

import java.util.List;

public class PassWordException extends Exception {
    private final List<String> listaErros;
    
    public PassWordException(List<String> listaErros){
        this.listaErros = listaErros;
    }
    
    public List<String> getListaErros(){
        return listaErros;
    }
}
