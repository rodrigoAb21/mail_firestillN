/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Negocio;

import Datos.DatosProducto;
import java.util.ArrayList;

/**
 *
 * @author asus
 */
public class NegocioProducto {
     public NegocioProducto() {
        
    }
    
    public Integer registrar( Integer categoria_id, String nombre, String descripcion, Float precio, Integer cantidad){
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
        DatosProducto datosProducto= new DatosProducto();
        ArrayList<DatosProducto> lista = datosProducto.obtener();
        String html="";
        
        String contenido="";
        for (DatosProducto producto : lista) {
            //faltaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaa
        }
        
        
        return html;
        
    }
    
}
