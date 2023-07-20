package ufes.services.arquivo;

import ufes.models.Log;

public class GerenciadorEscritaArquivo {
    
    public static void escrever(IArquivo tipoArquivo, Log log){
        tipoArquivo.escreverArquivo(log);
    }
}
