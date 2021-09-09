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

/**
 *
 * @author asus
 */
public class DatosDetalleIngresoProducto extends Tabla{
    
    private Integer id;
    private Integer ingreso_producto_id;
    private Integer producto_id;
    private Float costo;
    private Integer cantidad;
    private String deleted_at;
    
    public DatosDetalleIngresoProducto(){
        
        conexion= new ConexionPGDB();
        
    }

    public Integer getId() {
        return id;
    }

    public Integer getIngreso_producto_id() {
        return ingreso_producto_id;
    }

    public void setIngreso_producto_id(Integer ingreso_producto_id) {
        this.ingreso_producto_id = ingreso_producto_id;
    }

    public Integer getProducto_id() {
        return producto_id;
    }

    public void setProducto_id(Integer producto_id) {
        this.producto_id = producto_id;
    }

    public Float getCosto() {
        return costo;
    }

    public void setCosto(Float costo) {
        this.costo = costo;
    }

    public Integer getCantidad() {
        return cantidad;
    }

    public void setCantidad(Integer cantidad) {
        this.cantidad = cantidad;
    }

    public String getDeleted_at() {
        return deleted_at;
    }

    public void setDeleted_at(String deleted_at) {
        this.deleted_at = deleted_at;
    }
    
    

    @Override
    String getNombreTabla() {
        return " detalle_ingreso_producto ";
    }
    
    @Override
    String getSqlInsert() {
        String sql = "INSERT INTO "+getNombreTabla()+" ("
                + "ingreso_producto_id,"
                + "producto_id,"
                + "costo,"
                + "cantidad"
                + ")"
                + "VALUES("
                +getSQLString(this.ingreso_producto_id)+","
                +getSQLString(this.producto_id)+","
                +getSQLString(this.costo)+","
                +getSQLString(this.cantidad)+" "
                +") RETURNING ID;";
        return sql;
    }

    @Override
    String getSqlUpdate() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
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
                DatosDetalleIngresoProducto datosDetalleIngresoProducto = new DatosDetalleIngresoProducto();
                datosDetalleIngresoProducto.id=resultado.getInt("id");
                datosDetalleIngresoProducto.ingreso_producto_id=resultado.getInt("ingreso_producto_id");
                datosDetalleIngresoProducto.producto_id=resultado.getInt("producto_id");
                datosDetalleIngresoProducto.costo=resultado.getFloat("costo");
                datosDetalleIngresoProducto.cantidad=resultado.getInt("cantidad");
                datosDetalleIngresoProducto.deleted_at=resultado.getString("deleted_at");
                lista.add(datosDetalleIngresoProducto);
            }
        } catch (SQLException ex) {
            new Exception("error datos get lista detalle ingreso producto");
        }
        return lista;
    }
    
    
    public DatosDetalleIngresoProducto obtener(int id){
        return (DatosDetalleIngresoProducto)obtenerTupla(id);
    }
    
    public ArrayList<DatosDetalleIngresoProducto> obtener(){
        ArrayList<DatosDetalleIngresoProducto> lista=new ArrayList<DatosDetalleIngresoProducto>();
        for (Object object : obtenertLista()) {
            DatosDetalleIngresoProducto datosDetalleIngresoProducto= new DatosDetalleIngresoProducto();
            datosDetalleIngresoProducto= (DatosDetalleIngresoProducto) object;
            lista.add(datosDetalleIngresoProducto);
        }
        return lista;
    }
}
