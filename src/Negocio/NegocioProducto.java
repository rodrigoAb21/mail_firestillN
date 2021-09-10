/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Negocio;

import Datos.DatosCategoria;
import Datos.DatosProducto;
import java.util.ArrayList;

/**
 *
 * @author asus
 */
public class NegocioProducto {
     public NegocioProducto() {
        
    }
    
    public Integer registrar( Integer categoria_id, String nombre, String descripcion, Float precio){
        DatosProducto datosProducto = new DatosProducto();
        datosProducto.setNombre(nombre);
        datosProducto.setDescripcion(descripcion);
        datosProducto.setPrecio(precio);
        datosProducto.setCantidad(0);
        return datosProducto.insertar();
    }
    
    public void editar(int id, Integer categoria_id, String nombre, String descripcion, Float precio, Integer cantidad){
        DatosProducto datosProducto = new DatosProducto();
        datosProducto= datosProducto.obtener(id);
        datosProducto.setCategoria_id(categoria_id);
        datosProducto.setNombre(nombre);
        datosProducto.setDescripcion(descripcion);
        datosProducto.setPrecio(precio);
        datosProducto.setCantidad(cantidad);
        datosProducto.editar();
    }
    
    public void editar2(int id, Integer categoria_id,String nombre, Float precio, String descripcion){
        DatosProducto datosProducto = new DatosProducto();
        datosProducto= datosProducto.obtener(id);
        datosProducto.setCategoria_id(categoria_id);
        datosProducto.setNombre(nombre);
        datosProducto.setDescripcion(descripcion);
        datosProducto.setPrecio(precio);
        datosProducto.editar();
    }
    
    public void eliminar(int id)throws Exception{
        DatosProducto datosProducto = new DatosProducto();
        datosProducto= datosProducto.obtener(id);
        if(datosProducto.getDeleted_at().contentEquals("null")){
            datosProducto.eliminar();
        }else{
            throw new Exception("ya fue eliminado");
        }
    }
    
    public DatosProducto obtenerProducto(int id){
        DatosProducto datosProducto = new DatosProducto();
        datosProducto= datosProducto.obtener(id);
        return datosProducto;
    }
    
    public ArrayList<DatosProducto> obtenerProductos(){
        DatosProducto datosProducto = new DatosProducto();
        ArrayList<DatosProducto> lista = datosProducto.obtener();
        return lista;
    }
    
    public String obtenerProductoHTML(int id){
        DatosProducto datosProducto= new DatosProducto();
        datosProducto = datosProducto.obtener(id);
        String html="";
        
        //faltaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaa
        
        return html;
        
    }
    
    public String obtenerProductosHTML(){
        DatosProducto datosProducto = new DatosProducto();
        ArrayList<DatosProducto> lista= obtenerProductos();
        String html="";
        
        String contenido="";
        for (DatosProducto producto : lista) {
             Integer id = producto.getId();
            String nombre=producto.getNombre();
            String descripcion=producto.getDescripcion();
            Float precio=producto.getPrecio();
            Integer cantidad =producto.getCantidad();
            int categoria_id=producto.getCategoria_id();
            
            DatosCategoria datosCategoria= new DatosCategoria();
            String categoria_nombre= datosCategoria.obtener(categoria_id).getNombre();
            
            contenido+="<tr class=\"trDatosTecno\">\n" +
                       "<td class=\"tdcol1Tecno\">"+id+"</td>\n" +
                       "<td >"+nombre+"</td>\n" +
                       "<td >"+categoria_nombre+"</td>\n" +       
                       "<td >"+cantidad+"</td>\n" +    
                       "<td >"+
                             "<li>"+
                             "<a href=\"mailto:grupo13sc@tecnoweb.org.bo?subject= mostrarProducto:"+id+"\">Mostrar </a>\n" +
                             "</li>"+
                             "<a href=\"mailto:grupo13sc@tecnoweb.org.bo?subject= editarProducto:"+id+", "+categoria_id+", "+nombre+", "+precio+", "+descripcion+"\">Editar </a>\n" +
                             "</li>"+
                             "<li>"+
                             "<a href=\"mailto:grupo13sc@tecnoweb.org.bo?subject= eliminarProducto:"+id+"\">Eliminar </a>\n" +
                             "</li>"+
                       "</td>\n" +
                       "</tr>\n";
        }
        
        html="<h2>Productos</h2>"+
             "<a href=\"mailto:grupo13sc@tecnoweb.org.bo?subject= registrarProducto: CATEGORIA_ID, NOMBRE, DESCRIPCION, PRECIO\">Registrar Administrador</a><br>" +
            
            "<table class=\"tablaTecno\">\n" +
            "  <thead>\n" +
            "    <tr class=\"trCamposTecno\">\n" +
            "      <th >ID</th>\n"+
            "      <th class=\"thcolxTecno\">Nombre</th>\n" +
            "      <th class=\"thcolxTecno\">Categoria</th>\n" +
            "      <th class=\"thcolxTecno\">Cantidad</th>\n" +  
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
