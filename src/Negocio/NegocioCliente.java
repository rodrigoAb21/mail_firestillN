/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Negocio;

import Datos.DatosCliente;
import java.util.ArrayList;

/**
 *
 * @author asus
 */
public class NegocioCliente {
    public NegocioCliente() {
        
    }
    
    public Integer registrar(String nombre_empresa,String  nit,String telefono_empresa,String email,String direccion,String nombre_encargado,String cargo_encargado,String email_encargado,String telefono_encargado){
        DatosCliente datosCliente = new DatosCliente();
        datosCliente.setNombre_empresa(nombre_empresa);
        datosCliente.setNit(nit);
        datosCliente.setTelefono_empresa(telefono_empresa);
        datosCliente.setEmail(email);
        datosCliente.setDireccion(direccion);
        datosCliente.setNombre_encargado(nombre_encargado);
        datosCliente.setCargo_encargado(cargo_encargado);
        datosCliente.setEmail_encargado(email_encargado);
        datosCliente.setTelefono_encargado(telefono_encargado);
        return datosCliente.insertar();
    }
    
    public void editar(Integer id, String nombre_empresa,String  nit,String telefono_empresa,String email,String direccion,String nombre_encargado,String cargo_encargado,String email_encargado,String telefono_encargado){
        DatosCliente datosCliente = new DatosCliente();
        datosCliente= datosCliente.obtener(id);
        datosCliente.setNombre_empresa(nombre_empresa);
        datosCliente.setNit(nit);
        datosCliente.setTelefono_empresa(telefono_empresa);
        datosCliente.setEmail(email);
        datosCliente.setDireccion(direccion);
        datosCliente.setNombre_encargado(nombre_encargado);
        datosCliente.setCargo_encargado(cargo_encargado);
        datosCliente.setEmail_encargado(email_encargado);
        datosCliente.setTelefono_encargado(telefono_encargado);
        datosCliente.editar();
    }
    
    public void eliminar(Integer id)throws Exception{
        DatosCliente datosCliente = new DatosCliente();
        datosCliente= datosCliente.obtener(id);
        if(datosCliente.getDeleted_at().contentEquals("null")){
            datosCliente.eliminar();
        }else{
            throw new Exception("ya fue eliminado");
        }
    }
    
    public DatosCliente obtenerCliente(int id){
        DatosCliente datosCliente = new DatosCliente();
        datosCliente= datosCliente.obtener(id);
        return datosCliente;
    }
    
    public ArrayList<DatosCliente> obtenerClientes(){
        DatosCliente datosCliente = new DatosCliente();
        ArrayList<DatosCliente> lista = datosCliente.obtener();
        return lista;
    }
    
    public String obtenerClienteHTML(int id){
        DatosCliente datosCliente= new DatosCliente();
        datosCliente = datosCliente.obtener(id);
        String html="";
        
        //faltaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaa
        
        return html;
        
    }
    
    public String obtenerClientesHTML(){
        DatosCliente datosCliente= new DatosCliente();
        ArrayList<DatosCliente> lista = datosCliente.obtener();
        String html="";
        
        String contenido="";
        for (DatosCliente cliente : lista) {
        //faltaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaa
        }
        
        return html;
        
    }
    
    
}
