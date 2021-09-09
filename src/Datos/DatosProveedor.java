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
public class DatosProveedor extends Tabla{
    
    private Integer id ;
    private String nombre;
    private String nit;
    private String email;
    private String direccion;
    private String telefono;
    private String informacion;
    private String titular;
    private String banco;
    private String sucursal;
    private String nro_cuenta;
    private String moneda;
    private String tipo_identificacion;
    private String nro_identificacion;
    
    private String deleted_at;
    
    public DatosProveedor(){
        
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

    public String getNit() {
        return nit;
    }

    public void setNit(String nit) {
        this.nit = nit;
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

    public String getTelefono() {
        return telefono;
    }

    public void setTelefono(String telefono) {
        this.telefono = telefono;
    }

    public String getInformacion() {
        return informacion;
    }

    public void setInformacion(String informacion) {
        this.informacion = informacion;
    }

    public String getTitular() {
        return titular;
    }

    public void setTitular(String titular) {
        this.titular = titular;
    }

    public String getBanco() {
        return banco;
    }

    public void setBanco(String banco) {
        this.banco = banco;
    }

    public String getSucursal() {
        return sucursal;
    }

    public void setSucursal(String sucursal) {
        this.sucursal = sucursal;
    }

    public String getNro_cuenta() {
        return nro_cuenta;
    }

    public void setNro_cuenta(String nro_cuenta) {
        this.nro_cuenta = nro_cuenta;
    }

    public String getMoneda() {
        return moneda;
    }

    public void setMoneda(String moneda) {
        this.moneda = moneda;
    }

    public String getTipo_identificacion() {
        return tipo_identificacion;
    }

    public void setTipo_identificacion(String tipo_identificacion) {
        this.tipo_identificacion = tipo_identificacion;
    }

    public String getNro_identificacion() {
        return nro_identificacion;
    }

    public void setNro_identificacion(String nro_identificacion) {
        this.nro_identificacion = nro_identificacion;
    }

    public String getDeleted_at() {
        return deleted_at;
    }

    public void setDeleted_at(String deleted_at) {
        this.deleted_at = deleted_at;
    }

    
    @Override
    String getNombreTabla() {
        return " proveedor ";
    }
    
    @Override
    String getSqlInsert() {
        String sql = "INSERT INTO "+getNombreTabla()+" ("
                + "nombre,"
                + "nit,"
                + "email,"
                + "direccion,"
                + "telefono,"
                + "informacion,"
                + "titular,"
                + "banco,"
                + "sucursal,"
                + "nro_cuenta,"
                + "moneda,"
                + "tipo_identificacion,"
                + "nro_identificacion"
                + ")"
                + "VALUES("
                +getSQLString(this.nombre)+","
                +getSQLString(this.nit)+","
                +getSQLString(this.email)+","
                +getSQLString(this.direccion)+","
                +getSQLString(this.telefono)+","
                +getSQLString(this.informacion)+","
                +getSQLString(this.titular)+","
                +getSQLString(this.banco)+","
                +getSQLString(this.sucursal)+","
                +getSQLString(this.nro_cuenta)+","
                +getSQLString(this.moneda)+","
                +getSQLString(this.tipo_identificacion)+","
                +getSQLString(this.nro_identificacion)
                +") RETURNING ID;";
        return sql;
    }
    
    @Override
     String getSqlUpdate() {
        String sql = "UPDATE "+getNombreTabla()+" SET "
                + "nombre="+getSQLString(this.nombre)+","
                + "nit="+getSQLString(this.nit)+","
                + "email="+getSQLString(this.email)+","
                + "direccion="+getSQLString(this.direccion)+","
                + "telefono="+getSQLString(this.telefono)+","
                + "informacion="+getSQLString(this.informacion)+","
                + "titular="+getSQLString(this.titular)+","
                + "banco="+getSQLString(this.banco)+","
                + "sucursal="+getSQLString(this.sucursal)+","
                + "nro_cuenta="+getSQLString(this.nro_cuenta)+","
                + "moneda="+getSQLString(this.moneda)+","
                + "tipo_identificacion="+getSQLString(this.tipo_identificacion)+","
                + "nro_identificacion="+getSQLString(this.nro_identificacion)
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
                DatosProveedor datosProveedor = new DatosProveedor();
                datosProveedor.id=resultado.getInt("id");
                datosProveedor.nombre=resultado.getString("nombre");
                datosProveedor.nit=resultado.getString("nit");
                datosProveedor.email=resultado.getString("email");
                datosProveedor.direccion=resultado.getString("direccion");
                datosProveedor.telefono=resultado.getString("telefono");
                datosProveedor.informacion=resultado.getString("informacion");
                datosProveedor.titular=resultado.getString("titular");
                datosProveedor.banco=resultado.getString("banco");
                datosProveedor.sucursal=resultado.getString("sucursal");
                datosProveedor.nro_cuenta=resultado.getString("nro_cuenta");
                datosProveedor.moneda=resultado.getString("moneda");
                datosProveedor.tipo_identificacion=resultado.getString("tipo_identificacion");
                datosProveedor.nro_identificacion=resultado.getString("nro_identificacion");
                datosProveedor.deleted_at=resultado.getString("deleted_at");
                lista.add(datosProveedor);
            }
        } catch (SQLException ex) {
            System.out.println("error getLista - proveedor");
        }
        return lista;
    }
    
    public DatosProveedor obtener(int id){
        return (DatosProveedor)obtenerTupla(id);
    }
    
    public ArrayList<DatosProveedor> obtener(){
        ArrayList<DatosProveedor> lista=new ArrayList<DatosProveedor>();
        for (Object object : obtenertLista()) {
            DatosProveedor datosProveedor= new DatosProveedor();
            datosProveedor= (DatosProveedor) object;
            lista.add(datosProveedor);
        }
        return lista;
    }    

}
