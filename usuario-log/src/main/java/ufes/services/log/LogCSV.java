package ufes.services.log;

import ufes.models.Log;
import ufes.services.arquivo.EscritaEmArquivoCSV;
import ufes.services.arquivo.GerenciadorEscritaArquivo;

public class LogCSV implements ILog {

    private EscritaEmArquivoCSV arquivo;

    public LogCSV() {
        this.arquivo = EscritaEmArquivoCSV.getInstancia();
    }

    @Override
    public void salvarLog(Log log) {
        String logData = log.getNome() + " | " + log.getData() + " | " + log.getHora() + " | " + log.getOperacao();
        GerenciadorEscritaArquivo.escrever(arquivo, logData);
        System.out.println(String.join(",", logData));
    }
}
