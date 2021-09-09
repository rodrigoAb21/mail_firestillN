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
public class DatosSucursal extends Tabla{
    
    private Integer id ;
    private String nombre;
    private String direccion;
    private int contrato_id;
    private String deleted_at;
    
    
    public DatosSucursal(){
        conexion= new ConexionPGDB();
        
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getDireccion() {
        return direccion;
    }

    public void setDireccion(String direccion) {
        this.direccion = direccion;
    }

    public int getContrato_id() {
        return contrato_id;
    }

    public void setContrato_id(int contrato_id) {
        this.contrato_id = contrato_id;
    }

    public String getDeleted_at() {
        return deleted_at;
    }

    public void setDeleted_at(String deleted_at) {
        this.deleted_at = deleted_at;
    }
    
    @Override
    String getNombreTabla() {
        return " sucursal ";
    }
    
    @Override
    String getSqlInsert() {
        String sql = "INSERT INTO "+getNombreTabla()+" ("
                + "nombre,"
                + "direccion,"
                + "contrato_id"
                + ")"
                + "VALUES("
                +getSQLString(this.nombre)+","
                +getSQLString(this.direccion)+","
                +getSQLString(this.contrato_id)
                +");";
        return sql;
    }
    
    @Override
    String getSqlUpdate() {
        String sql = "UPDATE "+getNombreTabla()+" SET "
                + "nombre="+getSQLString(this.nombre)+","
                + "direccion="+getSQLString(this.direccion)+","
                + "contrato_id="+getSQLString(this.contrato_id)
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
                DatosSucursal sucursal = new DatosSucursal();
                sucursal.id=resultado.getInt("id");
                sucursal.nombre=resultado.getString("nombre");
                sucursal.direccion=resultado.getString("direccion");
                sucursal.contrato_id=resultado.getInt("contrato_id");
                sucursal.deleted_at=resultado.getString("deleted_at");
                lista.add(sucursal);
                        }
        } catch (SQLException ex) {
            new Exception("error en get lista Sucursal");
        }
        return lista;
    }
    
    public DatosSucursal obtener(Integer id){
        return (DatosSucursal)obtenerTupla(id);
    }
    
    public ArrayList<DatosSucursal> obtener(){
        ArrayList<DatosSucursal> lista=new ArrayList<DatosSucursal>();
        for (Object object : obtenertLista()) {
            DatosSucursal datosSucursal= new DatosSucursal();
            datosSucursal= (DatosSucursal) object;
            lista.add(datosSucursal);
        }
        return lista;
    }
    
    public ArrayList<DatosSucursal> obtenerXcontrato(Integer contrato_id){
        ArrayList<DatosSucursal> lista=new ArrayList<DatosSucursal>();
        for (Object object : obtener("where contrato_id="+contrato_id)) {
            DatosSucursal datosSucursal= new DatosSucursal();
            datosSucursal= (DatosSucursal) object;
            lista.add(datosSucursal);
        }
        return lista;
    }
    
    
   
}