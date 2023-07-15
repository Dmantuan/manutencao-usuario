package ufes.services.arquivo;

import com.opencsv.CSVWriter;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import javax.swing.JOptionPane;

public class EscritaEmArquivoCSV implements IArquivo {
    private static EscritaEmArquivoCSV instancia;
    private final String filePath = "src/main/java/ufes/services/arquivo/LogCSV.csv";

    private File file;

    private EscritaEmArquivoCSV() {
        try {
            this.file = new File(filePath);
            if (!file.exists()) {
                file.createNewFile();
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
    public void escreverArquivo(String log) {
        try {
            FileWriter fw = new FileWriter(file, true);
            CSVWriter csvWriter = new CSVWriter(fw);

            csvWriter.writeNext(new String[]{log});

            csvWriter.close();
        } catch (IOException ioEx) {
            JOptionPane.showMessageDialog(null, ioEx);
        }
    }
}
