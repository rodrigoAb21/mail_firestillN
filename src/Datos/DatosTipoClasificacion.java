/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Datos;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.text.SimpleDateFormat;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.Date;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author asus
 */
public class DatosTipoClasificacion extends Tabla{
    
    private Integer id ;
    private String nombre;
    private String deleted_at;
    
    public DatosTipoClasificacion(){
        
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
        return " tipo_clasificacion ";
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
                DatosTipoClasificacion tipo_Clasificacion = new DatosTipoClasificacion();
                tipo_Clasificacion.id=resultado.getInt("id");
                tipo_Clasificacion.nombre=resultado.getString("nombre");
                tipo_Clasificacion.deleted_at=resultado.getString("deleted_at");
                lista.add(tipo_Clasificacion);
            }
        } catch (SQLException ex) {
            new Exception("error tipo clasificacion datos get lista");
        }
        return lista;
    }
    
    public DatosTipoClasificacion obtener(int id){
        return (DatosTipoClasificacion)obtenerTupla(id);
    }
    
    public ArrayList<DatosTipoClasificacion> obtener(){
        ArrayList<DatosTipoClasificacion> lista=new ArrayList<DatosTipoClasificacion>();
        for (Object object : obtenertLista()) {
            DatosTipoClasificacion datosTipoClasificacion= new DatosTipoClasificacion();
            datosTipoClasificacion= (DatosTipoClasificacion) object;
            lista.add(datosTipoClasificacion);
        }
        return lista;
    }
   
    public static void main(String[] args) {
        DatosTipoClasificacion dt= new DatosTipoClasificacion();
        dt=dt.obtener(8);
        dt.eliminar();
    }
}