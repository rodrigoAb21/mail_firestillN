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
public class DatosDetalleNotaVenta extends Tabla{
    
    private Integer id;
    private Integer nota_venta_id;
    private Integer producto_id;
    private Integer cantidad;
    private Float precio;
    private String deleted_at;
    
    public DatosDetalleNotaVenta(){
        
        conexion= new ConexionPGDB();
        
    }

    public Integer getId() {
        return id;
    }

    public Integer getNota_venta_id() {
        return nota_venta_id;
    }

    public void setNota_venta_id(Integer nota_venta_id) {
        this.nota_venta_id = nota_venta_id;
    }

    public Integer getProducto_id() {
        return producto_id;
    }

    public void setProducto_id(Integer producto_id) {
        this.producto_id = producto_id;
    }

    public Integer getCantidad() {
        return cantidad;
    }

    public void setCantidad(Integer cantidad) {
        this.cantidad = cantidad;
    }

    public Float getPrecio() {
        return precio;
    }

    public void setPrecio(Float precio) {
        this.precio = precio;
    }

    public String getDeleted_at() {
        return deleted_at;
    }

    public void setDeleted_at(String deleted_at) {
        this.deleted_at = deleted_at;
    }

    

    
    @Override
    String getNombreTabla() {
        return " detalle_nota_venta ";
    }    

    @Override
    String getSqlInsert() {
        String sql = "INSERT INTO "+getNombreTabla()+" ("
                + "nota_venta_id,"
                + "producto_id,"
                + "cantidad,"
                + "precio"
                + ")"
                + "VALUES("
                +getSQLString(this.nota_venta_id)+","
                +getSQLString(this.producto_id)+","
                +getSQLString(this.cantidad)+","
                +getSQLString(this.precio)+" "
                +") RETURNING ID;";
        return sql;
    }

    @Override
    String getSqlUpdate() {
        return "";
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
                DatosDetalleNotaVenta datosDetalleNotaVenta = new DatosDetalleNotaVenta();
                datosDetalleNotaVenta.id=resultado.getInt("id");
                datosDetalleNotaVenta.nota_venta_id=resultado.getInt("nota_venta_id");
                datosDetalleNotaVenta.producto_id=resultado.getInt("producto_id");
                datosDetalleNotaVenta.cantidad=resultado.getInt("cantidad");
                datosDetalleNotaVenta.precio=resultado.getFloat("precio");
                datosDetalleNotaVenta.deleted_at=resultado.getString("deleted_at");
                lista.add(datosDetalleNotaVenta);
            }
        } catch (SQLException ex) {
            new Exception("error detalle nota venta datos get lista");
        }
        return lista;
    }
    
    public DatosDetalleNotaVenta obtener(int id){
        return (DatosDetalleNotaVenta)obtenerTupla(id);
    }
    
    public ArrayList<DatosDetalleNotaVenta> obtener(){
        ArrayList<DatosDetalleNotaVenta> lista=new ArrayList<DatosDetalleNotaVenta>();
        for (Object object : obtenertLista()) {
            DatosDetalleNotaVenta datosDetalleNotaVenta= new DatosDetalleNotaVenta();
            datosDetalleNotaVenta= (DatosDetalleNotaVenta) object;
            lista.add(datosDetalleNotaVenta);
        }
        return lista;
    }
    
}
