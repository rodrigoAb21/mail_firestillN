/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Negocio;

import Datos.DatosTrabajador;
import Utils.BCrypt;
import java.util.ArrayList;

/**
 *
 * @author asus
 */
public class NegocioTrabajador {
     public NegocioTrabajador() {
        
    }
    
    public Integer registrar(String nombre, String apellido, String carnet, String telefono, String direccion, String tipo, String email){
        DatosTrabajador datosTrabajador= new DatosTrabajador();
        datosTrabajador.setNombre(nombre);
        datosTrabajador.setApellido(apellido);
        datosTrabajador.setCarnet(carnet);
        datosTrabajador.setTelefono(telefono);
        datosTrabajador.setDireccion(direccion);
        datosTrabajador.setTipo(tipo);
        datosTrabajador.setEmail(email);
        String passEncriptada = BCrypt.hashpw(carnet, BCrypt.gensalt(12));
        datosTrabajador.setPassword(passEncriptada);
        return datosTrabajador.insertar();
    }
    
    public void eliminar(Integer id)throws Exception{
        DatosTrabajador datosTrabajador= new DatosTrabajador();
        datosTrabajador=datosTrabajador.obtener(id);
        if(datosTrabajador.getDeleted_at().contentEquals("null")){
            datosTrabajador.eliminar();
        }else{
            throw new Exception("ya fue eliminado");
        }
    }
    
    public DatosTrabajador obtenerTrabajador(int id){
        DatosTrabajador datosTrabajador = new DatosTrabajador();
        datosTrabajador= datosTrabajador.obtener(id);
        return datosTrabajador;
    }
    
    public DatosTrabajador obtenerTrabajador(String correo){
        DatosTrabajador datosTrabajador = new DatosTrabajador();
        datosTrabajador= datosTrabajador.obtenerXcorreo(correo);
        return datosTrabajador;
    }
    
    public ArrayList<DatosTrabajador> obtenerTrabajadores(){
        DatosTrabajador datosTrabajador = new DatosTrabajador();
        ArrayList<DatosTrabajador> lista = datosTrabajador.obtener();
        return lista;
    }
    
    public String obtenerTrabajadorHTML(Integer id){
        DatosTrabajador datosTrabajador = new DatosTrabajador();
        datosTrabajador= obtenerTrabajador(id);
        String html="";
        //COMPLETAARRRRRRRRRRRRRRRRRRRRRRRRRRRRRRRRRRRRRRRR
        return html;
    }
    
    public String obtenerTrabajadoresHTML(){
        DatosTrabajador datosTrabajador = new DatosTrabajador();
        ArrayList<DatosTrabajador> lista= obtenerTrabajadores();
        String html="";
        //COMPLETAARRRRRRRRRRRRRRRRRRRRRRRRRRRRRRRRRRRRRRRR
        return html;
    }
    
    public static void main(String[] args) {
     
        DatosTrabajador dt= new DatosTrabajador();
        dt = dt.obtenerXcorreo("admin@gmail.com");
        System.out.println(dt.getNombre()+"-"+dt.getApellido());
    }
}
