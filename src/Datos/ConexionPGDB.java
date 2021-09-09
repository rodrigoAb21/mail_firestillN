/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Datos;

/**
 *
 * @author asus
 */
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.*;

public class ConexionPGDB {
    private Connection conexion;
    private String host;
    private String db_name;
    private String user;
    private String password;
    private String puerto;

    public ConexionPGDB() {
        /*
       this.conexion = null;
       this.host = "localhost";
       this.db_name = "mail_firestill";
       this.user = "postgres";
       this.password = "postgres";
       this.puerto = "5432";
        */
        this.conexion = null;
       this.host = "localhost";
       this.db_name = "firestill";
       this.user = "postgres";
       this.password = "postgres";
       this.puerto = "5432";
    }
    
    public Connection conexion(){
        return this.conexion;
    }
    
    public void abrirConexion(){
        String url_db = "jdbc:postgresql://" + host + ":"+puerto+"/" + db_name;
        try {
            Class.forName("org.postgresql.Driver");
            conexion = DriverManager.getConnection(url_db, user, password);
        } catch (ClassNotFoundException | SQLException e) {
            System.out.println("error");
        }
    }
    
   
    public void cerrarConexion(){
        try {
            this.conexion.close();
        } catch (SQLException e) {
            System.out.println("Error: " + e.getMessage());
        }
    }
    
}
