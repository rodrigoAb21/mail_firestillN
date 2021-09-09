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
public class DatosCliente extends Tabla{
    
    Integer id ;
    private String nombre_empresa;
    private String nit;
    private String telefono_empresa;
    private String email;
    private String direccion;
    private String nombre_encargado;
    private String cargo_encargado;
    private String email_encargado;
    private String telefono_encargado;
    private String deleted_at;
    
    
    public DatosCliente(){
        conexion= new ConexionPGDB();
    }

    public Integer getId() {
        return id;
    }

    public String getNombre_empresa() {
        return nombre_empresa;
    }

    public void setNombre_empresa(String nombre_empresa) {
        this.nombre_empresa = nombre_empresa;
    }

    public String getNit() {
        return nit;
    }

    public void setNit(String nit) {
        this.nit = nit;
    }

    public String getTelefono_empresa() {
        return telefono_empresa;
    }

    public void setTelefono_empresa(String telefono_empresa) {
        this.telefono_empresa = telefono_empresa;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getDireccion() {
        return direccion;
    }

    public void setDireccion(String direccion) {
        this.direccion = direccion;
    }

    public String getNombre_encargado() {
        return nombre_encargado;
    }

    public void setNombre_encargado(String nombre_encargado) {
        this.nombre_encargado = nombre_encargado;
    }

    public String getCargo_encargado() {
        return cargo_encargado;
    }

    public void setCargo_encargado(String cargo_encargado) {
        this.cargo_encargado = cargo_encargado;
    }

    public String getEmail_encargado() {
        return email_encargado;
    }

    public void setEmail_encargado(String email_encargado) {
        this.email_encargado = email_encargado;
    }

    public String getTelefono_encargado() {
        return telefono_encargado;
    }

    public void setTelefono_encargado(String telefono_encargado) {
        this.telefono_encargado = telefono_encargado;
    }

    public String getDeleted_at() {
        return deleted_at;
    }

    public void setDeleted_at(String deleted_at) {
        this.deleted_at = deleted_at;
    }

    

    @Override
    String getNombreTabla() {
        return " cliente ";
    }
    
    @Override
    String getSqlInsert() {
        String sql = "INSERT INTO "+getNombreTabla()+" ("
                + "nombre_empresa,"
                + "nit,"
                + "telefono_empresa,"
                + "email,"
                + "direccion,"
                + "nombre_encargado,"
                + "cargo_encargado,"
                + "email_encargado,"
                + "telefono_encargado"
                + ")"
                + "VALUES("
                +getSQLString(this.nombre_empresa)+","
                +getSQLString(this.nit)+","
                +getSQLString(this.telefono_empresa)+","
                +getSQLString(this.email)+","
                +getSQLString(this.direccion)+","
                +getSQLString(this.nombre_encargado)+","
                +getSQLString(this.cargo_encargado)+","
                +getSQLString(this.email_encargado)+","
                +getSQLString(this.telefono_encargado)
                +");";
        return sql;
    }
    
    @Override
    String getSqlUpdate() {
        String sql = "UPDATE "+getNombreTabla()+" SET "
                + "nombre_empresa="+getSQLString(this.nombre_empresa)+","
                + "nit="+getSQLString(this.nit)+","
                + "telefono_empresa="+getSQLString(this.telefono_empresa)+","
                + "email="+getSQLString(this.email)+","
                + "direccion="+getSQLString(this.direccion)+","
                + "nombre_encargado="+getSQLString(this.nombre_encargado)+","
                + "cargo_encargado="+getSQLString(this.cargo_encargado)+","
                + "email_encargado="+getSQLString(this.email_encargado)+","
                + "telefono_encargado="+getSQLString(this.telefono_encargado)+" "
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
        ArrayList<Object> clientes= new ArrayList<Object>();
        try {
            while(resultado.next()){
                DatosCliente cliente = new DatosCliente();
                cliente.id=resultado.getInt("id");
                cliente.nombre_empresa=resultado.getString("nombre_empresa");
                cliente.nit=resultado.getString("nit");
                cliente.telefono_empresa=resultado.getString("telefono_empresa");
                cliente.email=resultado.getString("email");
                cliente.direccion=resultado.getString("direccion");
                cliente.nombre_encargado=resultado.getString("nombre_encargado");
                cliente.cargo_encargado=resultado.getString("cargo_encargado");
                cliente.email_encargado=resultado.getString("email_encargado");
                cliente.telefono_encargado=resultado.getString("telefono_encargado");
                cliente.deleted_at=resultado.getString("deleted_at");
                clientes.add(cliente);
                        }
        } catch (SQLException ex) {
            new Exception("");
        }
        return clientes;
    }
    
    public DatosCliente obtener(int id){
        return (DatosCliente)obtenerTupla(id);
    }
    
    public ArrayList<DatosCliente> obtener(){
        ArrayList<DatosCliente> lista=new ArrayList<DatosCliente>();
        for (Object object : obtenertLista()) {
            DatosCliente datosCliente= new DatosCliente();
            datosCliente= (DatosCliente) object;
            lista.add(datosCliente);
        }
        return lista;
    }
   
}