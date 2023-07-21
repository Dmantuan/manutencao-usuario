package ufes.db;

import java.io.File;
import java.sql.Connection;
import java.sql.DriverManager;
import javax.swing.JOptionPane;

public class ConexaoDB {
    
    File currentDir = new File(System.getProperty("user.dir"));
    File parentDir = currentDir.getParentFile();
    String parentDirectory = parentDir.getAbsolutePath();
    private final String url = "jdbc:sqlite:" + parentDirectory + "/CriacaoManutencaoDeUsuarios/src/main/java/ufes/db/sqlite.db";
    private Connection connection;
    private static ConexaoDB instancia;

    private ConexaoDB() {
        
        try {

            connection = DriverManager.getConnection(url);

        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, "Nao foi possivel conectar com o banco de dados");
        }

    }

    public static ConexaoDB getInstancia() {
        if (ConexaoDB.instancia == null) {
            ConexaoDB.instancia = new ConexaoDB();
        }

        return ConexaoDB.instancia;
    }

    public Connection getConnection() {
        return this.connection;
    }
}
