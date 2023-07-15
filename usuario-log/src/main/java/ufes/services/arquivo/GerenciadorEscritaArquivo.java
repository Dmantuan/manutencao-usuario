package ufes.services.arquivo;

public class GerenciadorEscritaArquivo {
    
    public static void escrever(IArquivo tipoArquivo, String log){
        tipoArquivo.escreverArquivo(log);
    }
    
}
