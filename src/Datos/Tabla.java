/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Datos;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;

/**
 *
 * @author asus
 */
public abstract class Tabla {

    ConexionPGDB conexion;

    abstract String getNombreTabla();

    abstract String getSqlInsert();

    abstract String getSqlUpdate();

    abstract String getSqlDelete();
    
    abstract ArrayList<Object> getlista(ResultSet resultado);

    public Integer insertar() {
        Integer key=null;
        conexion.abrirConexion();
        String sql = getSqlInsert();
        System.out.println(sql);
        System.out.println("sql tabla::::"+sql);
        Statement stmt;
        try {
            stmt = conexion.conexion().createStatement();
            ResultSet rs = stmt.executeQuery(sql);
            rs.next();
            key= rs.getInt(1);
            System.out.println("id:::::::"+key);       
            stmt.close();
            conexion.cerrarConexion();
            
        } catch (SQLException ex) {
            System.out.println(ex);
        }
        return key;
    }

    public void editar() {
        ejecutar(getSqlUpdate());
    }

    public void eliminar() {
        ejecutar(getSqlDelete());
    }
    
    protected Object obtenerTupla(int id){
        String condicion= " where id = "+id;
        ArrayList<Object> lista=obtener(condicion);
        if(lista.isEmpty()==true){
            return null;
        }
        return lista.get(0);
    }
    
    protected ArrayList<Object> obtenertLista(){
        return obtener(" where deleted_at is null ");
    }

    void ejecutar(String sql_operacion) {
        conexion.abrirConexion();
        String sql = sql_operacion;
        Statement stmt;
        try {
            stmt = conexion.conexion().createStatement();
            stmt.executeUpdate(sql);
            stmt.close();
            conexion.cerrarConexion();
            
        } catch (SQLException ex) {
            System.out.println(ex);
        }
    }
    
    
    protected ArrayList<Object> obtener(String condicion){
        ArrayList<Object> lista=new ArrayList<>();
        conexion.abrirConexion();
        String sql = "SELECT * FROM " + getNombreTabla() + " " + condicion + " order by id asc;";
        System.out.println(sql);
        Statement stmt;
        try {
            stmt = conexion.conexion().createStatement();
            ResultSet resultado = stmt.executeQuery(sql);
            //stmt.close();
            conexion.cerrarConexion();

            lista = getlista(resultado);

        } catch (SQLException ex) {
            System.out.println(ex);
            System.out.println("clase tabla error - metodo obtener");
        }
       return lista;
    }
    
    protected String getSQLString(Date fecha){
        String texto=" null ";
        if(fecha!=null){
            SimpleDateFormat formato = new SimpleDateFormat("dd-MM-yyyy"); 
            texto = " '"+formato.format(fecha)+"' ";
        }
        return texto;
    }
    
    protected String getSQLString(Integer entero){
        String texto=" null ";
        if(entero!=null){
            texto= " "+entero+" ";
        }
        return texto;
    }
    
    protected String getSQLString(Float flotante){
        String texto=" null ";
        if(flotante!=null){
            texto= " "+flotante+" ";
        }
        return texto;
    }
    
    protected String getSQLString(String cadena){
        String texto= " null ";
        if(cadena!=null){
            texto= " '"+cadena+"' ";
        }
        return texto;
    }
    
    protected String getSQLString(Boolean booleano){
        String texto=" null ";
        if(booleano!=null){
            texto=" '"+booleano+"' ";
        }
        return texto;
    }

    protected static String parseDataString(String name, String value) {
        return (value != null) ? String.format("%s = '%s'", name, value.trim()) : String.format("%s = null", name);
    }

    public static String parseDataInteger(String name, Integer value) {
        return (value != null) ? String.format("%s = '%d'", name, value) : String.format("%s = null", name);
    }

    public static String parseDataFloat(String name, Float value) {
        return (value != null) ? String.format("%s = '%f'", name, value) : String.format("%s = null", name);
    }

    public static String parseDataBoolean(String name, boolean value) {
        return String.format("%s = ", name) + value;
    }

    public static String parseDataString(String value) {
        return (value != null) ? String.format("'%s'", value.trim()) : null;
    }

    public static String parseDataInteger(Integer value) {
        return (value != null) ? String.format("'%d'", value) : "null";
    }

    public static String parseDataFloat(Float value) {
        return (value != null) ? String.format("'%f'", value) : "null";
    }

}
