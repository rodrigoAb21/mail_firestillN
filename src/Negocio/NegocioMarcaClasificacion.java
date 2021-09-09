/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Negocio;

import Datos.DatosMarcaClasificacion;
import java.util.ArrayList;

/**
 *
 * @author asus
 */
public class NegocioMarcaClasificacion {
    public NegocioMarcaClasificacion() {
        
    }
    
    public Integer registrar(String nombre){
        DatosMarcaClasificacion datosMarcaClasificacion = new DatosMarcaClasificacion();
        datosMarcaClasificacion.setNombre(nombre);
        return datosMarcaClasificacion.insertar();
    }
    
    public void editar(Integer id, String nombre){
        DatosMarcaClasificacion datosMarcaClasificacion = new DatosMarcaClasificacion();
        datosMarcaClasificacion= datosMarcaClasificacion.obtener(id);
        datosMarcaClasificacion.setNombre(nombre);
        datosMarcaClasificacion.editar();
    }
    
    public void eliminar(Integer id)throws Exception{
        DatosMarcaClasificacion datosMarcaClasificacion = new DatosMarcaClasificacion();
        datosMarcaClasificacion= datosMarcaClasificacion.obtener(id);
        if(datosMarcaClasificacion.getDeleted_at().contentEquals("null")){
            datosMarcaClasificacion.eliminar();
        }else{
            throw new Exception("ya fue eliminado");
        }
    }
    
    public DatosMarcaClasificacion obtenerMarcaClasificacion(Integer id){
        DatosMarcaClasificacion datosMarcaClasificacion = new DatosMarcaClasificacion();
        datosMarcaClasificacion= datosMarcaClasificacion.obtener(id);
        return datosMarcaClasificacion;
    }
    
    public ArrayList<DatosMarcaClasificacion> obtenerMarcasClasificacion(){
        DatosMarcaClasificacion datosMarcaClasificacion = new DatosMarcaClasificacion();
        ArrayList<DatosMarcaClasificacion> lista = datosMarcaClasificacion.obtener();
        return lista;
    }
    
    public String obtenerMarcaClasificacionHTML(int id){
        DatosMarcaClasificacion datosMarcaClasificacion= new DatosMarcaClasificacion();
        datosMarcaClasificacion = datosMarcaClasificacion.obtener(id);
        String html="";
        html="<table class=\"tablaTecno\">\n" +
             "  <thead>\n" +
             "    <tr class=\"trCamposTecno\">\n" +
             "      <th >ID</th>\n"+
             "      <th class=\"thcolxTecno\">Nombre</th>\n" +
             "    </tr>\n" +
             "  </thead>\n" +
             "  <tbody>\n" +    
             "    <tr class=\"trDatosTecno\">\n" +
             "      <td class=\"tdcol1Tecno\">"+datosMarcaClasificacion.getId()+"</td>\n" +
             "      <td >"+datosMarcaClasificacion.getNombre()+"</td>\n" +
             "    </tr>\n" +
             "  </tbody>\n" +
             "</table>";
        
        return html;
        
    }
    
    public String obtenerMarcasClasificacionHTML(){
        DatosMarcaClasificacion datosMarcaClasificacion= new DatosMarcaClasificacion();
        ArrayList<DatosMarcaClasificacion> lista = datosMarcaClasificacion.obtener();
        String html="";
        
        String contenido="";
        for (DatosMarcaClasificacion marcaClasificacion : lista) {
            contenido+="<tr class=\"trDatosTecno\">\n" +
                       "<td class=\"tdcol1Tecno\">"+marcaClasificacion.getId()+"</td>\n" +
                       "<td >"+marcaClasificacion.getNombre()+"</td>\n" +
                       "<td >"+
                             "<li>"+
                             "<a href=\"mailto:grupo13sc@tecnoweb.org.bo?subject= editarMarcaClasificacion:"+marcaClasificacion.getId()+", "+marcaClasificacion.getNombre()+"\">Editar </a>\n" +
                             "</li>"+
                             "<li>"+
                             "<a href=\"mailto:grupo13sc@tecnoweb.org.bo?subject= eliminarMarcaClasificacion:"+marcaClasificacion.getId()+"\">Eliminar </a>\n" +
                             "</li>"+
                       "</td>\n" +
                       "</tr>\n";
        }
        
        html="<table class=\"tablaTecno\">\n" +
            "  <thead>\n" +
            "    <tr class=\"trCamposTecno\">\n" +
            "      <th >ID</th>\n"+
            "      <th class=\"thcolxTecno\">Nombre</th>\n" +
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
