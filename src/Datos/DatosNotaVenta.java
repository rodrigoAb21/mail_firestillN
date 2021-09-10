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
public class DatosNotaVenta extends Tabla{
    
    private Integer id;
    private Date fecha;
    private String tipo;
    private Float total;
    private Integer cliente_id;
    private Integer trabajador_id;
    private String deleted_at;

    public DatosNotaVenta(){
        
        conexion= new ConexionPGDB();
        
    }
    
    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Date getFecha() {
        return fecha;
    }

    public void setFecha(Date fecha) {
        this.fecha = fecha;
    }

    public String getTipo() {
        return tipo;
    }

    public void setTipo(String tipo) {
        this.tipo = tipo;
    }

    public Float getTotal() {
        return total;
    }

    public void setTotal(Float total) {
        this.total = total;
    }

    public Integer getCliente_id() {
        return cliente_id;
    }

    public void setCliente_id(Integer cliente_id) {
        this.cliente_id = cliente_id;
    }

    public Integer getTrabajador_id() {
        return trabajador_id;
    }

    public void setTrabajador_id(Integer trabajador_id) {
        this.trabajador_id = trabajador_id;
    }

    public String getDeleted_at() {
        return deleted_at;
    }

    public void setDeleted_at(String deleted_at) {
        this.deleted_at = deleted_at;
    }
    
    
    @Override
    String getNombreTabla() {
        return " nota_venta ";
    }

    @Override
    String getSqlInsert() {
        String sql = "INSERT INTO "+getNombreTabla()+" ("
                + "fecha,"
                + "total,"
                + "cliente_id,"
                + "trabajador_id"
                + ")"
                + "VALUES("
                +getSQLString(this.fecha)+","
                +getSQLString(this.total)+","
                +getSQLString(this.cliente_id)+","
                +getSQLString(this.trabajador_id)
                +") RETURNING ID;";
        return sql;
    }

    @Override
    String getSqlUpdate() {
        String sql = "UPDATE "+getNombreTabla()+" SET "
                + "total="+getSQLString(this.total)
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
                DatosNotaVenta datosNotaVenta = new DatosNotaVenta();
                datosNotaVenta.id=resultado.getInt("id");
                datosNotaVenta.cliente_id=resultado.getInt("cliente_id");
                datosNotaVenta.trabajador_id=resultado.getInt("trabajador_id");
                datosNotaVenta.fecha=resultado.getDate("fecha");
                datosNotaVenta.total=resultado.getFloat("total");
                datosNotaVenta.deleted_at=resultado.getString("deleted_at");
                lista.add(datosNotaVenta);
            }
        } catch (SQLException ex) {
            new Exception("error tipo clasificacion datos get lista");
        }
        return lista;
    }
    
    public DatosNotaVenta obtener(int id){
        return (DatosNotaVenta)obtenerTupla(id);
    }
    
    public ArrayList<DatosNotaVenta> obtener(){
        ArrayList<DatosNotaVenta> lista=new ArrayList<DatosNotaVenta>();
        for (Object object : obtenertLista()) {
            DatosNotaVenta datosNotaVenta= new DatosNotaVenta();
            datosNotaVenta= (DatosNotaVenta) object;
            lista.add(datosNotaVenta);
        }
        return lista;
    }
    
}
