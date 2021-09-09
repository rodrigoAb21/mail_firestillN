/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
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
public class DatosMarcaClasificacion extends Tabla{
    
    private Integer id ;
    private String nombre;
    private String deleted_at;
    
    public DatosMarcaClasificacion(){
        
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
        return " marca_clasificacion ";
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
                DatosMarcaClasificacion marca_Clasificacion = new DatosMarcaClasificacion();
                marca_Clasificacion.id=resultado.getInt("id");
                marca_Clasificacion.nombre=resultado.getString("nombre");
                marca_Clasificacion.deleted_at=resultado.getString("deleted_at");
                lista.add(marca_Clasificacion);
            }
        } catch (SQLException ex) {
            new Exception("");
        }
        return lista;
    }
    
    public DatosMarcaClasificacion obtener(int id){
        return (DatosMarcaClasificacion)obtenerTupla(id);
    }
    
    public ArrayList<DatosMarcaClasificacion> obtener(){
        ArrayList<DatosMarcaClasificacion> lista=new ArrayList<DatosMarcaClasificacion>();
        for (Object object : obtenertLista()) {
            DatosMarcaClasificacion datosMarcaClasificacion= new DatosMarcaClasificacion();
            datosMarcaClasificacion= (DatosMarcaClasificacion) object;
            lista.add(datosMarcaClasificacion);
        }
        return lista;
    }
   
}