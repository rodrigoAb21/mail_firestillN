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
public class DatosProducto extends Tabla{
    private Integer id ;
    private String nombre;
    private String foto;
    private String descripcion;
    private Float precio;
    private Integer cantidad;
    private int categoria_id;
    private String deleted_at;
    
    public DatosProducto(){
        
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

    public String getFoto() {
        return foto;
    }

    public void setFoto(String foto) {
        this.foto = foto;
    }

    public String getDescripcion() {
        return descripcion;
    }

    public void setDescripcion(String descripcion) {
        this.descripcion = descripcion;
    }

    public Float getPrecio() {
        return precio;
    }

    public void setPrecio(Float precio) {
        this.precio = precio;
    }

    public Integer getCantidad() {
        return cantidad;
    }

    public void setCantidad(Integer cantidad) {
        this.cantidad = cantidad;
    }

    public int getCategoria_id() {
        return categoria_id;
    }

    public void setCategoria_id(int categoria_id) {
        this.categoria_id = categoria_id;
    }

    public String getDeleted_at() {
        return deleted_at;
    }

    public void setDeleted_at(String deleted_at) {
        this.deleted_at = deleted_at;
    }
    
    
    
    @Override
    String getNombreTabla() {
        return " producto ";
    }
    
    @Override
    String getSqlInsert() {
        String sql = "INSERT INTO "+getNombreTabla()+" ("
                + "nombre,"
                + "foto,"
                + "descripcion,"
                + "precio,"
                + "cantidad,"
                + "categoria_id"
                + ")"
                + "VALUES("
                +getSQLString(this.nombre)+","
                +getSQLString(this.foto)+","
                +getSQLString(this.descripcion)+","
                +getSQLString(this.precio)+","
                +getSQLString(this.cantidad)+","
                +getSQLString(this.categoria_id)+" "
                +") RETURNING ID;";
        return sql;
    }
    
    @Override
     String getSqlUpdate() {
        String sql = "UPDATE "+getNombreTabla()+" SET "
                + "nombre="+getSQLString(this.nombre)+","
                + "descripcion="+getSQLString(this.descripcion)+","
                + "precio="+getSQLString(this.precio)+","
                + "cantidad="+getSQLString(this.cantidad)+","
                + "categoria_id="+getSQLString(this.categoria_id)+" "
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
                DatosProducto datosProducto = new DatosProducto();
                datosProducto.id=resultado.getInt("id");
                datosProducto.nombre=resultado.getString("nombre");
                datosProducto.descripcion=resultado.getString("descripcion");
                datosProducto.precio=resultado.getFloat("precio");
                datosProducto.cantidad=resultado.getInt("cantidad");
                datosProducto.categoria_id=resultado.getInt("categoria_id");
                datosProducto.deleted_at=resultado.getString("deleted_at");
                lista.add(datosProducto);
            }
        } catch (SQLException ex) {
            System.out.println("error getlista producto");
        }
        return lista;
    }
    
    public DatosProducto obtener(int id){
        return (DatosProducto)obtenerTupla(id);
    }
    
    public ArrayList<DatosProducto> obtener(){
        ArrayList<DatosProducto> lista=new ArrayList<DatosProducto>();
        for (Object object : obtenertLista()) {
            DatosProducto datosProducto= new DatosProducto();
            datosProducto= (DatosProducto) object;
            lista.add(datosProducto);
        }
        return lista;
    }
   
    public static void main(String[] args) {
        DatosTipoClasificacion dt= new DatosTipoClasificacion();
        dt=dt.obtener(8);
        dt.eliminar();
    }

    
}
