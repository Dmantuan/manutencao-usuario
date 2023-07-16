package ufes.db;

import java.io.File;
import java.sql.Connection;
import java.sql.DriverManager;

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

            System.out.println("conecao realizada com sucesso");
        } catch (Exception e) {
            e.printStackTrace();
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
