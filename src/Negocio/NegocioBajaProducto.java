/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Negocio;

import Datos.DatosBajaProducto;
import Datos.DatosProducto;
import java.util.ArrayList;

/**
 *
 * @author asus
 */
public class NegocioBajaProducto {
    
    public NegocioBajaProducto() {
        
    }
   
    public Integer registrar(Integer producto_id,Integer cantidad, String motivo){
        DatosBajaProducto datosBajaProducto = new DatosBajaProducto();
        //falta ponser la fechaaaaa
        datosBajaProducto.setProducto_id(producto_id);
        datosBajaProducto.setCantidad(cantidad);
        datosBajaProducto.setMotivo(motivo);
        DatosProducto datosProducto = new DatosProducto();
        datosProducto=datosProducto.obtener(producto_id);
        int cantidad_resultante= datosProducto.getCantidad()-cantidad;
        datosProducto.setCantidad(cantidad_resultante);
        datosProducto.editar();
        
        return datosProducto.insertar();
    }
    
    public void eliminar(int id)throws Exception{
        DatosBajaProducto datosBajaProducto = new DatosBajaProducto();
        datosBajaProducto= datosBajaProducto.obtener(id);
        if(datosBajaProducto.getDeleted_at().contentEquals("null")){
            DatosProducto datosProducto= new DatosProducto();
            datosProducto=datosProducto.obtener(datosBajaProducto.getProducto_id());
            int cantidad_resultante= datosProducto.getCantidad()+datosBajaProducto.getCantidad();
            datosProducto.setCantidad(cantidad_resultante);
            
            datosBajaProducto.eliminar();
            datosProducto.editar();
        }else{
            throw new Exception("ya fue eliminado");
        }
    }
    
    public DatosBajaProducto obtener(int id){
        DatosBajaProducto datosBajaProducto = new DatosBajaProducto();
        datosBajaProducto= datosBajaProducto.obtener(id);
        return datosBajaProducto;
    }
    
    public ArrayList<DatosBajaProducto> obtenerBajasProducto(){
        DatosBajaProducto datosBajaProducto = new DatosBajaProducto();
        ArrayList<DatosBajaProducto> lista = datosBajaProducto.obtener();
        return lista;
    }
    
    public String obtenerBajaProductoHTML(int id){
        DatosBajaProducto datosBajaProducto= new DatosBajaProducto();
        datosBajaProducto = datosBajaProducto.obtener(id);
        String html="";
        html=" ";
        
        return html;
        
    }
    
    public String obtenerBajaProductosHTML(){
        DatosBajaProducto datosBajaProducto= new DatosBajaProducto();
        ArrayList<DatosBajaProducto> lista = datosBajaProducto.obtener();
        String html="";
        
        String contenido="";
        for (DatosBajaProducto tipoClasificacion : lista) {
            
        }       
        return html;
    }
    
    
    public static void main(String[] args) {
        
            NegocioTipoClasificacion n= new NegocioTipoClasificacion();
            n.editar(50, "dasdsad");
        
        
    }
}
