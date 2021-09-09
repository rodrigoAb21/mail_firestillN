/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Datos;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author asus
 */
public class DatosCategoria extends Tabla{
    
    private Integer id ;
    private String nombre;
    private String deleted_at;
    
    public DatosCategoria(){
        
        conexion= new ConexionPGDB();
        
    }

    public Integer getId() {
        return id;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getDeleted_at() {
        return deleted_at;
    }

    public void setDeleted_at(String deleted_at) {
        this.deleted_at = deleted_at;
    }
    
    
    
    @Override
    String getNombreTabla() {
        return " categoria ";
    }
    
    @Override
    String getSqlInsert() {
        String sql = "INSERT INTO "+getNombreTabla()+" ("
                + "nombre"
                + ")"
                + "VALUES("
                +getSQLString(this.nombre)
                +") RETURNING ID;";
        return sql;
    }
    
    @Override
     String getSqlUpdate() {
        String sql = "UPDATE "+getNombreTabla()+" SET "
                + "nombre="+getSQLString(this.nombre)
                + "where id="+ getSQLString(this.id)+";";
        return sql;
    }

    @Override
    String getSqlDelete() {
        DateTimeFormatter dtf = DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss");
        String fechaHora=" '"+dtf.format(LocalDateTime.now()).toString()+"' ";
        
       String sql = "UPDATE "+getNombreTabla()+" SET "
                + "deleted_at ="+fechaHora
                + "where id="+getSQLString(this.id)+";";
       return sql;
    }
    
    @Override
     ArrayList<Object> getlista(ResultSet resultado) {
        ArrayList<Object> lista= new ArrayList<Object>();
        try {
            while(resultado.next()){
                DatosCategoria datosCategoria = new DatosCategoria();
                datosCategoria.id=resultado.getInt("id");
                datosCategoria.nombre=resultado.getString("nombre");
                datosCategoria.deleted_at=resultado.getString("deleted_at");
                lista.add(datosCategoria);
            }
        } catch (SQLException ex) {
            new Exception("");
        }
        return lista;
    }
        
    public DatosCategoria obtener(int id){
        return (DatosCategoria)obtenerTupla(id);
    }
    
    public ArrayList<DatosCategoria> obtener(){
        ArrayList<DatosCategoria> lista=new ArrayList<DatosCategoria>();
        for (Object object : obtenertLista()) {
            DatosCategoria datosCategoria= new DatosCategoria();
            datosCategoria= (DatosCategoria) object;
            lista.add(datosCategoria);
        }
        return lista;
    }

    
   
}
