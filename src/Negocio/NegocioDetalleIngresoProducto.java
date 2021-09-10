/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Negocio;

import Datos.DatosDetalleIngresoProducto;
import Datos.DatosIngresoProducto;
import Datos.DatosProducto;
import java.util.ArrayList;

/**
 *
 * @author asus
 */
public class NegocioDetalleIngresoProducto{
    public NegocioDetalleIngresoProducto() {
        
    }
    
    public Integer registrar(Integer ingreso_producto_id,Integer producto_id, Integer cantidad, Float costo){
        DatosDetalleIngresoProducto datosDetalleIngresoProducto = new DatosDetalleIngresoProducto();
        datosDetalleIngresoProducto.setProducto_id(producto_id);
        datosDetalleIngresoProducto.setIngreso_producto_id(ingreso_producto_id);
        datosDetalleIngresoProducto.setCantidad(cantidad);
        datosDetalleIngresoProducto.setCosto(costo);
        Integer id=datosDetalleIngresoProducto.insertar();
        
        DatosProducto datosProducto= new DatosProducto();
        datosProducto=datosProducto.obtener(producto_id);
        
        int cantidad_total=datosProducto.getCantidad()+ cantidad;
        datosProducto.setCantidad(cantidad_total);
        datosProducto.editar();
        
        DatosIngresoProducto ingresoProducto= new DatosIngresoProducto();
        ingresoProducto= ingresoProducto.obtener(ingreso_producto_id);
        float total_resultante= ingresoProducto.getTotal()+cantidad*costo;
        ingresoProducto.editar();
        
        return id;
    }
    
    public void eliminar(int id)throws Exception{
        DatosDetalleIngresoProducto datosDetalleIngresoProducto = new DatosDetalleIngresoProducto();
        datosDetalleIngresoProducto= datosDetalleIngresoProducto.obtener(id);
        if(datosDetalleIngresoProducto.getDeleted_at().contentEquals("null")){
            datosDetalleIngresoProducto.eliminar();
            
            int producto_id=datosDetalleIngresoProducto.getProducto_id();
            DatosProducto datosProducto= new DatosProducto();
            datosProducto=datosProducto.obtener(producto_id);
            int cantidad_total= datosProducto.getCantidad()-datosDetalleIngresoProducto.getCantidad();
            datosProducto.setCantidad(cantidad_total);
            datosProducto.editar();
            
        }else{
            throw new Exception("ya fue eliminado");
        }
    }
    
    public DatosDetalleIngresoProducto obtenerDetalleIngresoProducto(int id){
        DatosDetalleIngresoProducto datosDetalleIngresoProducto = new DatosDetalleIngresoProducto();
        datosDetalleIngresoProducto= datosDetalleIngresoProducto.obtener(id);
        return datosDetalleIngresoProducto;
    }
    
    public ArrayList<DatosDetalleIngresoProducto> obtenerDetallesIngresoProductos(){
        DatosDetalleIngresoProducto datosDetalleIngresoProducto = new DatosDetalleIngresoProducto();
        ArrayList<DatosDetalleIngresoProducto> lista = datosDetalleIngresoProducto.obtener();
        return lista;
    }
    
    public String obtenerDetalleIngresoProductoHTML(int id){
        
        return "";
        
    }
    
    public String obtenerDetallesIngresoProductosHTML(){
        return "";
    }

    public String obtenerDetallesIngresoProductosHTMLporIngreso(Integer id_ingreso){

        DatosDetalleIngresoProducto datosDetalleIngresoProducto = new DatosDetalleIngresoProducto();
        ArrayList<DatosDetalleIngresoProducto> lista= obtenerDetallesIngresoProductos();
        String html="";

        String contenido="";

        for (DatosDetalleIngresoProducto detalle : lista) {
            if (detalle.getIngreso_producto_id() == id_ingreso){
                Integer id= detalle.getId();
                Float costo = detalle.getCosto();
                Integer cantidad = detalle.getCantidad();

                DatosProducto datosProducto = new DatosProducto().obtener(detalle.getProducto_id());

                contenido+="<tr class=\"trDatosTecno\">\n" +
                        "<td class=\"tdcol1Tecno\">"+id+"</td>\n" +
                        "<td >"+datosProducto.getNombre()+"</td>\n" +
                        "<td >"+cantidad+"</td>\n" +
                        "<td >"+costo+"</td>\n" +
                        "</tr>\n";
            }
        }

        html="<h2>Detalle</h2>"+
                "<table class=\"tablaTecno\">\n" +
                "  <thead>\n" +
                "    <tr class=\"trCamposTecno\">\n" +
                "      <th >ID</th>\n"+
                "      <th class=\"thcolxTecno\">Producto</th>\n" +
                "      <th class=\"thcolxTecno\">Cantidad</th>\n" +
                "      <th class=\"thcolxTecno\">Costo U.</th>\n" +
                "    </tr>\n" +
                "  </thead>\n" +
                "  <tbody>\n" +
                contenido+
                "  </tbody>\n" +
                "</table>";
        return html;
    }
}
