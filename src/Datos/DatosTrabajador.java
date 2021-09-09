/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Datos;

import Utils.BCrypt;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;

/**
 *
 * @author asus
 */
public class DatosTrabajador extends Tabla{
    
    private Integer id ;
    private String nombre;
    private String apellido;
    private String carnet;
    private String telefono;
    private String direccion;
    private String tipo;
    private String email;
    private String password;
    private String deleted_at;
    
    public DatosTrabajador(){
        
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

    public String getApellido() {
        return apellido;
    }

    public void setApellido(String apellido) {
        this.apellido = apellido;
    }

    public String getCarnet() {
        return carnet;
    }

    public void setCarnet(String carnet) {
        this.carnet = carnet;
    }

    public String getTelefono() {
        return telefono;
    }

    public void setTelefono(String telefono) {
        this.telefono = telefono;
    }

    public String getDireccion() {
        return direccion;
    }

    public void setDireccion(String direccion) {
        this.direccion = direccion;
    }

    public String getTipo() {
        return tipo;
    }

    public void setTipo(String tipo) {
        this.tipo = tipo;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getDeleted_at() {
        return deleted_at;
    }

    public void setDeleted_at(String deleted_at) {
        this.deleted_at = deleted_at;
    }
    
    @Override
    String getNombreTabla() {
        return " trabajador ";
    }
    
    @Override
    String getSqlInsert() {
        
        String sql = "INSERT INTO "+getNombreTabla()+" ("
                + "nombre,"
                + "apellido,"
                + "carnet,"
                + "telefono,"
                + "direccion,"
                + "tipo,"
                + "email,"
                + "password"
                + ")"
                + "VALUES("
                +getSQLString(this.nombre)+","
                +getSQLString(this.apellido)+","
                +getSQLString(this.carnet)+","
                +getSQLString(this.telefono)+","
                +getSQLString(this.direccion)+","
                +getSQLString(this.tipo)+","
                +getSQLString(this.email)+","
                +getSQLString(this.password)
                +") RETURNING ID;";
        System.out.println("SQL:::::::::::::::::::::"+sql);
        return sql;
    }
    
    @Override
     String getSqlUpdate() {
        String sql = "UPDATE "+getNombreTabla()+" SET "
                + "nombre="+getSQLString(this.nombre)+","
                + "apellido="+getSQLString(this.apellido)+","
                + "carnet="+getSQLString(this.carnet)+","
                + "telefono="+getSQLString(this.telefono)+","
                + "direccion="+getSQLString(this.direccion)+","
                + "email="+getSQLString(this.email)+","
                + "password="+getSQLString(this.password)+" "
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
                DatosTrabajador trabajador = new DatosTrabajador();
                trabajador.id=resultado.getInt("id");
                trabajador.nombre=resultado.getString("nombre");
                trabajador.apellido=resultado.getString("apellido");
                trabajador.tipo=resultado.getString("tipo");
                trabajador.carnet=resultado.getString("carnet");
                trabajador.telefono=resultado.getString("telefono");
                trabajador.direccion=resultado.getString("direccion");
                trabajador.email=resultado.getString("email");
                trabajador.password=resultado.getString("password");
                trabajador.deleted_at=resultado.getString("deleted_at");
                lista.add(trabajador);
            }
        } catch (SQLException ex) {
            System.out.println("error en getlista-trabajador");
        }
        return lista;
    }
    
    public DatosTrabajador obtener(int id){
        return (DatosTrabajador)obtenerTupla(id);
    }
    
    public DatosTrabajador obtenerXcorreo(String correo){
        ArrayList<Object> listaObj = obtener("where  email ="+getSQLString(correo)+ " and deleted_at is null ");
        if(listaObj.isEmpty()==true){
            System.out.println("estaba vacio");
            return null;
        }
        
        return  (DatosTrabajador) listaObj.get(0);
    }
    
    public ArrayList<DatosTrabajador> obtener(){
        ArrayList<DatosTrabajador> lista=new ArrayList<DatosTrabajador>();
        for (Object object : obtenertLista()) {
            DatosTrabajador datosTrabajador = new DatosTrabajador();
            datosTrabajador = (DatosTrabajador) object;
            lista.add(datosTrabajador);
        }
        return lista;
    }
   
    public static void main(String[] args) {
        DatosTrabajador dt= new DatosTrabajador();
        dt= dt.obtenerXcorreo("alejandra@gmail.com");
        System.out.println(dt.getApellido());
    }
    
}
