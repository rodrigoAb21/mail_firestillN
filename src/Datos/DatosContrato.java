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
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author asus
 */
public class DatosContrato extends Tabla{
    
    private Integer id ;
    private Date fecha_inicio;
    private Date fecha_fin;
    private String estado;
    private boolean edicion;
    private Integer periodo;
    private String documento;
    private Integer cliente_id;
    private Integer trabajador_id;
    private String deleted_at;
    
    public DatosContrato(){
        conexion= new ConexionPGDB();
    }

    public Integer getId() {
        return id;
    }

    public Date getFecha_inicio() {
        return fecha_inicio;
    }

    public void setFecha_inicio(Date fecha_inicio) {
        this.fecha_inicio = fecha_inicio;
    }

    public Date getFecha_fin() {
        return fecha_fin;
    }

    public void setFecha_fin(Date fecha_fin) {
        this.fecha_fin = fecha_fin;
    }

    public String getEstado() {
        return estado;
    }

    public void setEstado(String estado) {
        this.estado = estado;
    }

    public boolean isEdicion() {
        return edicion;
    }

    public void setEdicion(boolean edicion) {
        this.edicion = edicion;
    }

    public Integer getPeriodo() {
        return periodo;
    }

    public void setPeriodo(Integer periodo) {
        this.periodo = periodo;
    }

    public String getDocumento() {
        return documento;
    }

    public void setDocumento(String documento) {
        this.documento = documento;
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
        return " contrato ";
    }
    
    @Override
    String getSqlInsert() {
        String sql = "INSERT INTO "+getNombreTabla()+" ("
                + "fecha_inicio,"
                + "fecha_fin,"
                + "periodo,"
                + "cliente_id,"
                + "empleado_id)"
                + "VALUES("
                +getSQLString(this.fecha_inicio)+","
                +getSQLString(this.fecha_fin)+","
                +getSQLString(this.cliente_id)+","
                +getSQLString(this.trabajador_id)
                +");";
        return sql;
    }
    
    @Override
    String getSqlUpdate() {
        String sql = "UPDATE "+getNombreTabla()+" SET "
                + "fecha_inicio = "+getSQLString(this.fecha_inicio)+","
                + "fecha_fin = "+getSQLString(this.fecha_fin)+","
                + "periodo = "+getSQLString(this.periodo)+","
                + "cliente_id = "+getSQLString(this.cliente_id)+","
                + "trabajador_id = "+getSQLString(this.trabajador_id)
                + "where id = "+getSQLString(this.id)+";";
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
                DatosContrato contrato = new DatosContrato();
                contrato.id=resultado.getInt("id");
                contrato.fecha_inicio=resultado.getDate("fecha_inicio");
                contrato.fecha_fin=resultado.getDate("fecha_fin");
                contrato.documento= resultado.getString("documento");
                contrato.periodo=resultado.getInt("periodo");
                contrato.estado=resultado.getString("estado");
                contrato.edicion=resultado.getBoolean("edicion");
                contrato.cliente_id=resultado.getInt("cliente_id");
                contrato.trabajador_id=resultado.getInt("trabajador_id");
                contrato.deleted_at= resultado.getString("deleted_at");
                lista.add(contrato);
            }
        } catch (SQLException ex) {
            new Exception();
        }
        return lista;
    }
    
    public DatosContrato obtener(int id){
        return (DatosContrato)obtenerTupla(id);
    }
    
    public ArrayList<DatosContrato> obtener(){
        ArrayList<DatosContrato> lista=new ArrayList<DatosContrato>();
        for (Object object : obtenertLista()) {
            DatosContrato datosContrato= new DatosContrato();
            datosContrato= (DatosContrato) object;
            lista.add(datosContrato);
        }
        return lista;
    }
   
}