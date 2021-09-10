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
public class DatosEquipo extends Tabla{
    
    private Integer id ;
    private String nro_serie;
    private String descripcion;
    private String unidad_medida;
    private Integer ano_fabricacion;
    private Float capacidad;
    private String ubicacion;
    private Integer sucursal_id ;
    private Integer tipo_clasificacion_id;
    private Integer marca_clasificacion_id;
    private String deleted_at;
    
    
    public DatosEquipo(){
        
        conexion= new ConexionPGDB();
        
    }

    public Integer getId() {
        return id;
    }

    public String getNro_serie() {
        return nro_serie;
    }

    public void setNro_serie(String nro_serie) {
        this.nro_serie = nro_serie;
    }

    public String getDescripcion() {
        return descripcion;
    }

    public void setDescripcion(String descripcion) {
        this.descripcion = descripcion;
    }

    public String getUnidad_medida() {
        return unidad_medida;
    }

    public void setUnidad_medida(String unidad_medida) {
        this.unidad_medida = unidad_medida;
    }

    public Integer getAno_fabricacion() {
        return ano_fabricacion;
    }

    public void setAno_fabricacion(Integer ano_fabricacion) {
        this.ano_fabricacion = ano_fabricacion;
    }

    public Float getCapacidad() {
        return capacidad;
    }

    public void setCapacidad(Float capacidad) {
        this.capacidad = capacidad;
    }

    public String getUbicacion() {
        return ubicacion;
    }

    public void setUbicacion(String ubicacion) {
        this.ubicacion = ubicacion;
    }

    public Integer getSucursal_id() {
        return sucursal_id;
    }

    public void setSucursal_id(Integer sucursal_id) {
        this.sucursal_id = sucursal_id;
    }

    public Integer getTipo_clasificacion_id() {
        return tipo_clasificacion_id;
    }

    public void setTipo_clasificacion_id(Integer tipo_clasificacion_id) {
        this.tipo_clasificacion_id = tipo_clasificacion_id;
    }

    public Integer getMarca_clasificacion_id() {
        return marca_clasificacion_id;
    }

    public void setMarca_clasificacion_id(Integer marca_clasificacion_id) {
        this.marca_clasificacion_id = marca_clasificacion_id;
    }

    public String getDeleted_at() {
        return deleted_at;
    }

    public void setDeleted_at(String deleted_at) {
        this.deleted_at = deleted_at;
    }

    
    
    @Override
    String getNombreTabla() {
        return " equipo ";
    }
    
    @Override
    String getSqlInsert() {
        String sql = "INSERT INTO "+getNombreTabla()+" ("
                + "nro_serie,"
                + "descripcion,"
                + "unidad_medida,"
                + "ano_fabricacion,"
                + "capacidad,"
                + "ubicacion,"
                + "sucursal_id,"
                + "tipo_clasificacion_id,"
                + "marca_clasificacion_id"
                + ")"
                + "VALUES("
                +getSQLString(this.nro_serie)+","
                +getSQLString(this.descripcion)+","
                +getSQLString(this.unidad_medida)+","
                +getSQLString(this.ano_fabricacion)+","
                +getSQLString(this.capacidad)+","
                +getSQLString(this.ubicacion)+","
                +getSQLString(this.sucursal_id)+","
                +getSQLString(this.tipo_clasificacion_id)+","
                +getSQLString(this.marca_clasificacion_id)
                +");";
        return sql;
    }
    
    @Override
    String getSqlUpdate() {
        String sql = "UPDATE "+getNombreTabla()+" SET "
                + "nro_serie="+getSQLString(this.nro_serie)+","
                + "descripcion="+getSQLString(this.descripcion)+","
                + "unidad_medida="+getSQLString(this.unidad_medida)+","
                + "ano_fabricacion="+getSQLString(this.ano_fabricacion)+","
                + "capacidad="+getSQLString(this.capacidad)+","
                + "ubicacion="+getSQLString(this.ubicacion)+","
                + "sucursal_id="+getSQLString(this.sucursal_id)+","
                + "tipo_clasificacion_id="+getSQLString(this.tipo_clasificacion_id)+","
                + "marca_clasificacion_id="+getSQLString(this.marca_clasificacion_id)+" "
                + "where id="+ this.id+";";
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
                DatosEquipo equipo = new DatosEquipo();
                equipo.id=resultado.getInt("id");
                equipo.nro_serie=resultado.getString("nro_serie");
                equipo.descripcion=resultado.getString("descripcion");
                equipo.unidad_medida=resultado.getString("unidad_medida");
                equipo.ano_fabricacion=resultado.getInt("ano_fabricacion");
                equipo.capacidad= resultado.getFloat("capacidad");
                equipo.sucursal_id=resultado.getInt("sucursal_id");
                equipo.tipo_clasificacion_id=resultado.getInt("tipo_clasificacion_id");
                equipo.marca_clasificacion_id=resultado.getInt("marca_clasificacion_id");
                equipo.deleted_at= resultado.getString("deleted_at");
                lista.add(equipo);
                        }
        } catch (SQLException ex) {
            new Exception("error get lista datos equpo");
        }
        return lista;
    }
    
    public DatosEquipo obtener(Integer id){
        return (DatosEquipo)obtenerTupla(id);
    }
    
    public ArrayList<DatosEquipo> obtener(){
        ArrayList<DatosEquipo> lista=new ArrayList<DatosEquipo>();
        for (Object object : obtenertLista()) {
            DatosEquipo equipo= new DatosEquipo();
            equipo= (DatosEquipo) object;
            lista.add(equipo);
        }
        return lista;
    }
   
}