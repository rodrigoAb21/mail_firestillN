/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Negocio;

import Datos.DatosTipoClasificacion;
import java.util.ArrayList;

/**
 *
 * @author asus
 */
public class NegocioTipoClasificacion {
    public NegocioTipoClasificacion() {
        
    }
    
    public Integer registrar(String nombre){
        DatosTipoClasificacion datosTipoClasificacion = new DatosTipoClasificacion();
        datosTipoClasificacion.setNombre(nombre);
        return datosTipoClasificacion.insertar();
    }
    
    public void editar(int id, String nombre){
        DatosTipoClasificacion datosTipoClasificacion = new DatosTipoClasificacion();
        datosTipoClasificacion= datosTipoClasificacion.obtener(id);
        datosTipoClasificacion.setNombre(nombre);
        datosTipoClasificacion.editar();
    }
    
    public void eliminar(int id)throws Exception{
        DatosTipoClasificacion datosTipoClasificacion = new DatosTipoClasificacion();
        datosTipoClasificacion= datosTipoClasificacion.obtener(id);
        if(datosTipoClasificacion.getDeleted_at().contentEquals("null")){
            datosTipoClasificacion.eliminar();
        }else{
            throw new Exception("ya fue eliminado");
        }
    }
    
    public DatosTipoClasificacion obtenerTipoClasificacion(int id){
        DatosTipoClasificacion datosTipoClasificacion = new DatosTipoClasificacion();
        datosTipoClasificacion= datosTipoClasificacion.obtener(id);
        return datosTipoClasificacion;
    }
    
    public ArrayList<DatosTipoClasificacion> obtenerTiposClasificacion(){
        DatosTipoClasificacion datosTipoClasificacion = new DatosTipoClasificacion();
        ArrayList<DatosTipoClasificacion> lista = datosTipoClasificacion.obtener();
        return lista;
    }
    
    public String obtenerTipoClasificacionHTML(int id){
        DatosTipoClasificacion datosTipoClasificacion = obtenerTipoClasificacion(id);
        String html = "<h2>Ver Tipo de clasificacion: "+datosTipoClasificacion.getId()+"</h2>\n" +
                "<div class=\"tecno_recuadro\">\n" +
                "    <label><b>Nombre</b> </label>\n" +
                "    <p class=\"tecno_input\">"+datosTipoClasificacion.getNombre()+"</p>\n" +
                "</div>\n";


        return html;
        
    }
    
    public String obtenerTiposClasificacionHTML(){
        DatosTipoClasificacion datosTipoClasificacion = new DatosTipoClasificacion();
        ArrayList<DatosTipoClasificacion> lista= obtenerTiposClasificacion();
        String html="";
        
        String contenido="";
        for (DatosTipoClasificacion tipoClasificacion : lista) {
            Integer id= tipoClasificacion.getId();
            String nombre= tipoClasificacion.getNombre();
            
            contenido+="<tr class=\"trDatosTecno\">\n" +
                       "<td class=\"tdcol1Tecno\">"+id+"</td>\n" +
                       "<td >"+nombre+"</td>\n" +       
                       "<td >"+
                             "<li>"+
                             "<a href=\"mailto:grupo13sc@tecnoweb.org.bo?subject= mostrarTipoClasificacion: "+id+"\">Mostrar </a>\n" +
                             "</li>"+
                             "<li>"+
                             "<a href=\"mailto:grupo13sc@tecnoweb.org.bo?subject= editarTipoClasificacion: "+id+", "+nombre+"\">Editar </a>\n" +
                             "</li>"+
                             "<li>"+
                             "<a href=\"mailto:grupo13sc@tecnoweb.org.bo?subject= eliminarTipoClasificacion: "+id+"\">Eliminar </a>\n" +
                             "</li>"+
                       "</td>\n" +
                       "</tr>\n";
        }
        
        html="<h2>Clasificacion de extintores</h2>"+
             "<a href=\"mailto:grupo13sc@tecnoweb.org.bo?subject= registrarTipoClasificacion: NOMBRE\">Registrar Tipo Clasificacion</a><br>" +
            "<table class=\"tablaTecno\">\n" +
            "  <thead>\n" +
            "    <tr class=\"trCamposTecno\">\n" +
            "      <th >ID</th>\n"+
            "      <th class=\"thcolxTecno\">Nombre</th>\n" +
            "      <th class=\"thcolxTecno\">Apellido</th>\n" +
            "      <th class=\"thcolxTecno\">Tipo</th>\n" +
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
    
    
    public static void main(String[] args) {
        
            NegocioTipoClasificacion n= new NegocioTipoClasificacion();
            n.editar(50, "dasdsad");
        
        
    }
    
}
