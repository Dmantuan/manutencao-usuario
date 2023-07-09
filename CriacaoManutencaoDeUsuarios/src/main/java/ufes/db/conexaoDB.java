package ufes.db;

import java.sql.Connection;
import java.sql.DriverManager;

public class conexaoDB {

    private String url;
    private Connection connection;
    private static conexaoDB instancia;
    
    private conexaoDB(){
        url ="jdbc:sqlite:src/main/java/ufes/db/sqlite.db";
        
        try {
            
            connection = DriverManager.getConnection(url);
            
            System.out.println("conecao realizada com sucesso");
        } catch (Exception e) {
            e.printStackTrace();
        }
        
    }
    
    public static conexaoDB getInstancia(){
        if(conexaoDB.instancia == null){
            conexaoDB.instancia = new conexaoDB();
        }
        
        return conexaoDB.instancia;
    }
    
    public Connection getConnection(){
        return this.connection;
    }
}
