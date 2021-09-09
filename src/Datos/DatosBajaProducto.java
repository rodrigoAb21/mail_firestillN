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
import java.util.Date;

/**
 *
 * @author asus
 */
public class DatosBajaProducto extends Tabla{
    
    private Integer id ;
    private Date fecha;
    private String motivo;
    private Integer cantidad; 
    private Integer producto_id;
    private String deleted_at;
    
    public DatosBajaProducto(){
        
        conexion= new ConexionPGDB();
        
    }

    public Integer getId() {
        return id;
    }

    public Date getFecha() {
        return fecha;
    }

    public void setFecha(Date fecha) {
        this.fecha = fecha;
    }

    public String getMotivo() {
        return motivo;
    }

    public void setMotivo(String motivo) {
        this.motivo = motivo;
    }

    public Integer getCantidad() {
        return cantidad;
    }

    public void setCantidad(Integer cantidad) {
        this.cantidad = cantidad;
    }

    public Integer getProducto_id() {
        return producto_id;
    }

    public void setProducto_id(Integer producto_id) {
        this.producto_id = producto_id;
    }

    public String getDeleted_at() {
        return deleted_at;
    }

    public void setDeleted_at(String deleted_at) {
        this.deleted_at = deleted_at;
    }

    

    
    
    @Override
    String getNombreTabla() {
        return " baja_producto ";
    }
    
    @Override
    String getSqlInsert() {
        String sql = "INSERT INTO "+getNombreTabla()+" ("
                + "fecha,"
                + "motivo,"
                + "cantidad,"
                + "producto_id"
                + ")"
                + "VALUES("
                +getSQLString(this.fecha)+","
                +getSQLString(this.motivo)+","
                +getSQLString(this.cantidad)+","
                +getSQLString(this.producto_id)+" "
                +") RETURNING ID;";
        return sql;
    }
    
    @Override
     String getSqlUpdate() {
        String sql = "";
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
                DatosBajaProducto datosBajaProducto = new DatosBajaProducto();
                datosBajaProducto.id=resultado.getInt("id");
                datosBajaProducto.fecha=resultado.getDate("fecha");
                datosBajaProducto.motivo=resultado.getString("motivo");
                datosBajaProducto.cantidad=resultado.getInt("cantidad");
                datosBajaProducto.producto_id=resultado.getInt("producto_id");
                datosBajaProducto.deleted_at=resultado.getString("deleted_at");
                lista.add(datosBajaProducto);
            }
        } catch (SQLException ex) {
            System.out.println("error get lista baja producto");
        }
        return lista;
    }
    
    public DatosBajaProducto obtener(int id){
        return (DatosBajaProducto)obtenerTupla(id);
    }
    
    public ArrayList<DatosBajaProducto> obtener(){
        ArrayList<DatosBajaProducto> lista=new ArrayList<DatosBajaProducto>();
        for (Object object : obtenertLista()) {
            DatosBajaProducto datosBajaProducto= new DatosBajaProducto();
            datosBajaProducto= (DatosBajaProducto) object;
            lista.add(datosBajaProducto);
        }
        return lista;
    }

   
}
