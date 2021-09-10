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
        DatosCliente datosCliente = obtenerCliente(id);
        String html = "<h2>Ver Cliente: "+datosCliente.getId()+"</h2>\n" +
                "<div class=\"tecno_recuadro\">\n" +
                "    <label><b>Nombre</b> </label>\n" +
                "    <p class=\"tecno_input\">"+datosCliente.getNombre_empresa()+"</p>\n" +
                "    <label><b>NIT/CI</b> </label>\n" +
                "    <p class=\"tecno_input\">"+datosCliente.getNit()+"</p>\n" +
                "    <label><b>Email</b> </label>\n" +
                "    <p class=\"tecno_input\">"+datosCliente.getEmail()+"</p>\n" +
                "    <label><b>Direccion</b> </label>\n" +
                "    <p class=\"tecno_input\">"+datosCliente.getDireccion()+"</p>\n" +
                "    <label><b>Telefono</b> </label>\n" +
                "    <p class=\"tecno_input\">"+datosCliente.getTelefono_empresa()+"</p>\n" +

                "    <h3>Datos del Encargado</h3>\n" +
                "    <label><b>Nombre</b> </label>\n" +
                "    <p class=\"tecno_input\">"+datosCliente.getNombre_encargado()+"</p>\n" +
                "    <label><b>Email</b> </label>\n" +
                "    <p class=\"tecno_input\">"+datosCliente.getEmail_encargado()+"</p>\n" +
                "    <label><b>Cargo</b> </label>\n" +
                "    <p class=\"tecno_input\">"+datosCliente.getCargo_encargado()+"</p>\n" +
                "    <label><b>Telefono</b> </label>\n" +
                "    <p class=\"tecno_input\">"+datosCliente.getTelefono_encargado()+"</p>\n" +
                "</div>\n";
        
        return html;
        
    }
    
    public String obtenerClientesHTML(){
        DatosCliente datosCliente = new DatosCliente();
        ArrayList<DatosCliente> lista= obtenerClientes();
        String html="";
        
        String contenido="";
        for (DatosCliente cliente : lista) {
            Integer id = cliente.getId();
            String nombre_empresa=cliente.getNombre_empresa();
            String nit=cliente.getNit();
            String telefono_empresa=cliente.getTelefono_empresa();
            String email=cliente.getEmail();
            String direccion=cliente.getDireccion();
            String nombre_encargado=cliente.getNombre_encargado();
            String cargo_encargado=cliente.getCargo_encargado();
            String email_encargado= cliente.getEmail_encargado();
            String telefono_encargado= cliente.getTelefono_encargado();
            
            contenido+="<tr class=\"trDatosTecno\">\n" +
                       "<td class=\"tdcol1Tecno\">"+id+"</td>\n" +
                       "<td >"+nombre_empresa+"</td>\n" +
                       "<td >"+nit+"</td>\n" +       
                       "<td >"+telefono_empresa+"</td>\n" + 
                       "<td >"+
                             "<li>"+
                             "<a href=\"mailto:grupo13sc@tecnoweb.org.bo?subject= mostrarCliente:"+id+"\">Mostrar </a>\n" +
                             "</li>"+
                             "<li>"+
                             "<a href=\"mailto:grupo13sc@tecnoweb.org.bo?subject= editarCliente:"+id+", "+nombre_empresa+", "+nit+", "+telefono_empresa+", "+email+", "+direccion+", "+nombre_encargado+","+cargo_encargado+", "+email_encargado+", "+telefono_encargado+"\">Editar </a>\n" +
                             "</li>"+
                             "<li>"+
                             "<a href=\"mailto:grupo13sc@tecnoweb.org.bo?subject= eliminarCliente:"+id+"\">Eliminar </a>\n" +
                             "</li>"+
                       "</td>\n" +
                       "</tr>\n";
        }
        
        html="<h2>Trabajadores</h2>"+
             "<a href=\"mailto:grupo13sc@tecnoweb.org.bo?subject= registrarCliente: NOMBRE_EMPRESA, NIT, TELEFONO_EMPRESA, EMAIL, DIRECCION, NOMBRE_ENCARGADO, CARGO_ENCARGADO, EMAIL_ENCARGADO, TELEFONO_ENCARGADO\">Registrar Cliente</a><br>" + 
            "<table class=\"tablaTecno\">\n" +
            "  <thead>\n" +
            "    <tr class=\"trCamposTecno\">\n" +
            "      <th >ID</th>\n"+
            "      <th class=\"thcolxTecno\">Nombre</th>\n" +
            "      <th class=\"thcolxTecno\">CI/Nit</th>\n" +
            "      <th class=\"thcolxTecno\">Telefono</th>\n" + 
            "      <th class=\"thcolxTecno\">Opciones</th>\n" +                
            "    </tr>\n" +
            "  </thead>\n" +
            "  <tbody>\n" +    
                contenido+
            "  </tbody>\n" +
            "</table>";
        
        
        return html;
    }
    
    
}
