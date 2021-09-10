/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Negocio;

import Datos.DatosCategoria;
import java.util.ArrayList;

/**
 *
 * @author asus
 */
public class NegocioCategoria {
    public NegocioCategoria() {
    }
    
    public Integer registrar(String nombre){
        DatosCategoria datosCategoria = new DatosCategoria();
        datosCategoria.setNombre(nombre);
        return datosCategoria.insertar();
    }
    
    public void editar(int id, String nombre){
        DatosCategoria datosCategoria = new DatosCategoria();
        datosCategoria= datosCategoria.obtener(id);
        datosCategoria.setNombre(nombre);
        datosCategoria.editar();
    }
    
    public void eliminar(int id)throws Exception{
        DatosCategoria datosCategoria = new DatosCategoria();
        datosCategoria= datosCategoria.obtener(id);
        if(datosCategoria.getDeleted_at().contentEquals("null")){
            datosCategoria.eliminar();
        }else{
            throw new Exception("ya fue eliminado");
        }
        
    }
    
    public DatosCategoria obtenerCategoria(int id){
        DatosCategoria datosCategoria = new DatosCategoria();
        datosCategoria= datosCategoria.obtener(id);
        return datosCategoria;
    }
    
    public ArrayList<DatosCategoria> obtenerCategorias(){
        DatosCategoria datosCategoria = new DatosCategoria();
        ArrayList<DatosCategoria> lista = datosCategoria.obtener();
        return lista;
    }
    
    public String obtenerCategoriaHTML(int id){
        DatosCategoria datosCategoria = obtenerCategoria(id);
        String html = "<h2>Ver Categoria: "+datosCategoria.getId()+"</h2>\n" +
                "<div class=\"tecno_recuadro\">\n" +
                "    <label><b>Nombre</b> </label>\n" +
                "    <p class=\"tecno_input\">"+datosCategoria.getNombre()+"</p>\n" +
                "</div>\n";

        
        return html;
        
    }
    
    public String obtenerCategoriasHTML(){
        DatosCategoria datosCategoria= new DatosCategoria();
        ArrayList<DatosCategoria> lista = datosCategoria.obtener();
        String html="";
        
        String contenido="";
        for (DatosCategoria categoria : lista) {
            contenido+="<tr class=\"trDatosTecno\">\n" +
                       "<td class=\"tdcol1Tecno\">"+categoria.getId()+"</td>\n" +
                       "<td >"+categoria.getNombre()+"</td>\n" +
                       "<td >"+
                             "<li>"+
                             "<a href=\"mailto:grupo13sc@tecnoweb.org.bo?subject= editarCategoria:"+categoria.getId()+", "+categoria.getNombre()+"\">Editar </a>\n" +
                             "</li>"+
                             "<li>"+
                             "<a href=\"mailto:grupo13sc@tecnoweb.org.bo?subject= eliminarCategoria:"+categoria.getId()+"\">Eliminar </a>\n" +
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
