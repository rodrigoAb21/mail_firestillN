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
public class DatosIngresoProducto extends Tabla{
    
    private Integer id;
    private Date fecha;
    private String nro_factura;
    private Float total;
    private Integer proveedor_id;
    private String deleted_at;
    
    public DatosIngresoProducto(){
        
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

    public String getNro_factura() {
        return nro_factura;
    }

    public void setNro_factura(String nro_factura) {
        this.nro_factura = nro_factura;
    }

    public Float getTotal() {
        return total;
    }

    public void setTotal(Float total) {
        this.total = total;
    }

    public Integer getProveedor_id() {
        return proveedor_id;
    }

    public void setProveedor_id(Integer proveedor_id) {
        this.proveedor_id = proveedor_id;
    }

    public String getDeleted_at() {
        return deleted_at;
    }

    public void setDeleted_at(String deleted_at) {
        this.deleted_at = deleted_at;
    }

    
    
    @Override
    String getNombreTabla() {
        return " ingreso_producto ";
    }

    @Override
    String getSqlInsert() {
        String sql = "INSERT INTO "+getNombreTabla()+" ("
                + "fecha,"
                + "nro_factura,"
                + "total"
                + ")"
                + "VALUES("
                +getSQLString(this.fecha)+","
                +getSQLString(this.nro_factura)+","
                +getSQLString(this.total)+" "
                +") RETURNING ID;";
        return sql;
    }

    @Override
    String getSqlUpdate() {
        return " ";
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
                DatosIngresoProducto datosIngresoProducto = new DatosIngresoProducto();
                datosIngresoProducto.id=resultado.getInt("id");
                datosIngresoProducto.fecha=resultado.getDate("fecha");
                datosIngresoProducto.nro_factura=resultado.getString("nro_factura");
                datosIngresoProducto.total=resultado.getFloat("total");
                datosIngresoProducto.deleted_at=resultado.getString("deleted_at");
                lista.add(datosIngresoProducto);
            }
        } catch (SQLException ex) {
            new Exception("error ingreso producto datos get lista");
        }
        return lista;
    }
    
    public DatosIngresoProducto obtener(int id){
        return (DatosIngresoProducto)obtenerTupla(id);
    }
    
    public ArrayList<DatosIngresoProducto> obtener(){
        ArrayList<DatosIngresoProducto> lista=new ArrayList<DatosIngresoProducto>();
        for (Object object : obtenertLista()) {
            DatosIngresoProducto datosIngresoProducto= new DatosIngresoProducto();
            datosIngresoProducto= (DatosIngresoProducto) object;
            lista.add(datosIngresoProducto);
        }
        return lista;
    }
    
}
