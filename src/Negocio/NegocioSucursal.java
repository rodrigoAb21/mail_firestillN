/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Negocio;

import Datos.DatosCliente;
import Datos.DatosSucursal;
import java.util.ArrayList;

/**
 *
 * @author asus
 */
public class NegocioSucursal {
    public NegocioSucursal() {
        
    }
    
    public Integer registrar(Integer contrato_id, String nombre, String direccion){
        DatosSucursal datosSucursal=new DatosSucursal();
        datosSucursal.setNombre(nombre);
        datosSucursal.setDireccion(direccion);
        datosSucursal.setContrato_id(contrato_id);
        return datosSucursal.insertar();
    }
    
    public void editar(Integer id, Integer contrato_id, String nombre, String direccion){
        DatosSucursal datosSucursal=new DatosSucursal();
        datosSucursal= datosSucursal.obtener(id);
        datosSucursal.setNombre(nombre);
        datosSucursal.setDireccion(direccion);
        datosSucursal.setContrato_id(contrato_id);
        datosSucursal.editar();
    }
    
    public void eliminar(Integer id){
        DatosSucursal datosSucursal = new DatosSucursal();
        datosSucursal = datosSucursal.obtener(id);
        datosSucursal.eliminar();
    }
    
    public DatosSucursal obtenerSucursal(Integer id){
        DatosSucursal datosSucursal = new DatosSucursal();
        datosSucursal = datosSucursal.obtener(id);
        return datosSucursal;
    }
    
    public ArrayList<DatosSucursal> obtenerSucursales(){
        DatosSucursal datosSucursal = new DatosSucursal();
        ArrayList<DatosSucursal> lista = datosSucursal.obtener();
        return lista;
    }
    
    public String obtenerSucursalHTML(Integer id){
        String html= " ";
        return html;
    }
    
    public String obtenerSucursalesHTML(){
        DatosSucursal datosSucursal = new DatosSucursal();
        ArrayList<DatosSucursal> lista= obtenerSucursales();
        String html="";
        
        String contenido="";
        for (DatosSucursal sucursal : lista) {
            Integer id= sucursal.getId();
            String nombre= sucursal.getNombre();
            Integer contrato_id= sucursal.getContrato_id();
            String direccion=sucursal.getDireccion();
            
            contenido+="<tr class=\"trDatosTecno\">\n" +
                       "<td class=\"tdcol1Tecno\">"+id+"</td>\n" +
                       "<td >"+nombre+"</td>\n" +
                       "<td >"+contrato_id+"</td>\n" + 
                       "<td >"+direccion+"</td>\n" +
                       "<td >"+
                             "<li>"+
                             "<a href=\"mailto:grupo13sc@tecnoweb.org.bo?subject= mostrarSucursal:"+id+"\">Mostrar </a>\n" +
                             "</li>"+
                             "<li>"+
                             "<a href=\"mailto:grupo13sc@tecnoweb.org.bo?subject= editarSucursal:"+id+", "+contrato_id+", "+nombre+", "+direccion+"\">Editar </a>\n" +
                             "</li>"+
                             "<li>"+
                             "<a href=\"mailto:grupo13sc@tecnoweb.org.bo?subject= eliminarSucursal:"+id+"\">Eliminar </a>\n" +
                             "</li>"+
                       "</td>\n" +
                       "</tr>\n";
        }
        
        html="<h2>Sucursales</h2>"+
             "<a href=\"mailto:grupo13sc@tecnoweb.org.bo?subject= registrarSucursal:CONTRATO_ID, NOMBRE, DIRECCION  \">Registrar Sucursal</a><br>" +
             "<table class=\"tablaTecno\">\n" +
            "  <thead>\n" +
            "    <tr class=\"trCamposTecno\">\n" +
            "      <th >ID</th>\n"+
            "      <th class=\"thcolxTecno\">Nombre</th>\n" +
            "      <th class=\"thcolxTecno\">Contrato</th>\n" + 
            "      <th class=\"thcolxTecno\">Direccion</th>\n" + 
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
