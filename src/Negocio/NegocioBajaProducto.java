/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Negocio;

import Datos.DatosBajaProducto;
import Datos.DatosProducto;
import java.util.ArrayList;
import java.util.Date;

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
        DatosProducto datosProducto = new DatosProducto();
        datosProducto = datosProducto.obtener(datosBajaProducto.getProducto_id());
        String html = "<h2>Ver Baja: "+datosBajaProducto.getId()+"</h2>\n" +
                "<div class=\"tecno_recuadro\">\n" +
                "    <label><b>Producto</b> </label>\n" +
                "    <p class=\"tecno_input\">"+datosProducto.getNombre()+"</p>\n" +
                "    <label><b>Fecha</b> </label>\n" +
                "    <p class=\"tecno_input\">"+datosBajaProducto.getFecha()+"</p>\n" +
                "    <label><b>Cantidad</b> </label>\n" +
                "    <p class=\"tecno_input\">"+datosBajaProducto.getCantidad()+"</p>\n" +
                "    <label><b>Motivo</b> </label>\n" +
                "    <p class=\"tecno_input\">"+datosBajaProducto.getMotivo()+"</p>\n" +
                "</div>\n";
        
        return html;
        
    }
    
    public String obtenerBajaProductosHTML(){
        DatosBajaProducto datosBajaProducto = new DatosBajaProducto();
        ArrayList<DatosBajaProducto> lista= obtenerBajasProducto();
        String html="";
        
        String contenido="";
        for (DatosBajaProducto bajaProducto : lista) {
                Integer id =bajaProducto.getId();
                Date fecha =bajaProducto.getFecha();
                String motivo =bajaProducto.getMotivo();
                Integer cantidad =bajaProducto.getCantidad(); 
                Integer producto_id =bajaProducto.getProducto_id();
                
                DatosProducto producto= new DatosProducto();
                String producto_nombre= producto.obtener(producto_id).getNombre();
                
            
            contenido+="<tr class=\"trDatosTecno\">\n" +
                       "<td class=\"tdcol1Tecno\">"+id+"</td>\n" +
                       "<td >"+producto_nombre+"</td>\n" +
                       "<td >"+cantidad+"</td>\n" +       
                       "<td >"+fecha+"</td>\n" +
                       "<td >"+motivo+"</td>\n" +        
                       "<td >"+
                             "<li>"+
                             "<a href=\"mailto:grupo13sc@tecnoweb.org.bo?subject= mostrarBajaProducto:"+id+"\">Mostrar </a>\n" +
                             "</li>"+
                             "<li>"+
                             "<a href=\"mailto:grupo13sc@tecnoweb.org.bo?subject= eliminarBajaProducto:"+id+"\">Eliminar </a>\n" +
                             "</li>"+
                       "</td>\n" +
                       "</tr>\n";
        }
        
        html="<h2>Baja de productos</h2>"+
             "<a href=\"mailto:grupo13sc@tecnoweb.org.bo?subject= registrarBajaProducto: PRODUCTO_ID, CANTIDAD, MOTIVO\">Registrar Baja Producto</a><br>" + 
            "<table class=\"tablaTecno\">\n" +
            "  <thead>\n" +
            "    <tr class=\"trCamposTecno\">\n" +
            "      <th >ID</th>\n"+
            "      <th class=\"thcolxTecno\">Producto</th>\n" +
            "      <th class=\"thcolxTecno\">Cantidad</th>\n" +
            "      <th class=\"thcolxTecno\">Fecha</th>\n" +
            "      <th class=\"thcolxTecno\">Motivo</th>\n" +    
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
