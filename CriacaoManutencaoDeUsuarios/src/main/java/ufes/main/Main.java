package ufes.main;

import ufes.db.conexaoDB;

public class Main {

    public static void main(String[] args) {
        try {
            conexaoDB.getInstancia();
        } catch(Exception e){
            System.out.println("Deu ruim");
        }
    }
}
