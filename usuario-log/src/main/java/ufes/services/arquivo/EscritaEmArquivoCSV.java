package ufes.services.arquivo;

import com.opencsv.CSVWriter;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import javax.swing.JOptionPane;
import ufes.models.Log;

public class EscritaEmArquivoCSV implements IArquivo {

    private static EscritaEmArquivoCSV instancia;
    private final String filePath = "src/main/java/ufes/services/arquivo/LogCSV.csv";

    private File file;

    private EscritaEmArquivoCSV() {
        try {
            this.file = new File(filePath);
            if (!file.exists()) {
                file.createNewFile();
                escreverModelo();
            }
        } catch (IOException exIO) {
            JOptionPane.showMessageDialog(null, "Não foi possível ler o arquivo");
        }
    }

    public static EscritaEmArquivoCSV getInstancia() {
        if (instancia == null) {
            EscritaEmArquivoCSV.instancia = new EscritaEmArquivoCSV();
        }
        return EscritaEmArquivoCSV.instancia;
    }

    @Override
    public void escreverArquivo(Log log) {
        try (CSVWriter csvWriter = new CSVWriter(new FileWriter(file, true), ';', CSVWriter.NO_QUOTE_CHARACTER, CSVWriter.DEFAULT_ESCAPE_CHARACTER, CSVWriter.DEFAULT_LINE_END)) {
            String[] logArray = {
                log.getError() != null ? log.getError() : "",
                log.getOperacao(),
                log.getNome(),
                log.getData(),
                log.getHora(),
                log.getUser()
            };

            csvWriter.writeNext(logArray);
        } catch (IOException ioEx) {
            JOptionPane.showMessageDialog(null, ioEx);
        }
    }
    
    private void escreverModelo(){
        
        try (CSVWriter csvWriter = new CSVWriter(new FileWriter(file, true), ';', CSVWriter.NO_QUOTE_CHARACTER, CSVWriter.DEFAULT_ESCAPE_CHARACTER, CSVWriter.DEFAULT_LINE_END)) {
            String[] logArray = {
                "Error",
                "Operacao",
                "Nome",
                "Data",
                "Hora",
                "usuario"
            };

            csvWriter.writeNext(logArray);
        } catch (IOException ioEx) {
            JOptionPane.showMessageDialog(null, ioEx);
        }
    }
}
