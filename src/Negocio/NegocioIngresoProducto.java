/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Negocio;

import Datos.DatosDetalleIngresoProducto;
import Datos.DatosIngresoProducto;
import Datos.DatosTipoClasificacion;
import java.util.ArrayList;

/**
 *
 * @author asus
 */
public class NegocioIngresoProducto {
    
    public NegocioIngresoProducto() {
        
    }
    
    public Integer registrar(String nro_factura,Float total){
        DatosIngresoProducto datosIngresoProducto = new DatosIngresoProducto();
        datosIngresoProducto.setNro_factura(nro_factura);
        datosIngresoProducto.setTotal(total);
        return datosIngresoProducto.insertar();
    }
    
    public void eliminar(Integer id)throws Exception{
        DatosIngresoProducto datosIngresoProducto = new DatosIngresoProducto();
        datosIngresoProducto= datosIngresoProducto.obtener(id);
        if(datosIngresoProducto.getDeleted_at().contentEquals("null")){
            datosIngresoProducto.eliminar();
            
            NegocioDetalleIngresoProducto n_detalleIngreso= new NegocioDetalleIngresoProducto();
            for (DatosDetalleIngresoProducto detalle : n_detalleIngreso.obtenerDetallesIngresoProductos()) {
                if(detalle.getIngreso_producto_id()== id){
                    NegocioDetalleIngresoProducto neg= new NegocioDetalleIngresoProducto();
                    neg.eliminar(detalle.getId());
                }
            }
            
        }else{
            throw new Exception("ya fue eliminado");
        }
    }
    
    public DatosIngresoProducto obtenerIngresoProducto(int id){
        DatosIngresoProducto datosIngresoProducto = new DatosIngresoProducto();
        datosIngresoProducto= datosIngresoProducto.obtener(id);
        return datosIngresoProducto;
    }
    
    public ArrayList<DatosIngresoProducto> obtenerIngresosProductos(){
        DatosIngresoProducto datosIngresoProducto = new DatosIngresoProducto();
        ArrayList<DatosIngresoProducto> lista = datosIngresoProducto.obtener();
        return lista;
    }
    
    public String obtenerIngresoProductoHTML(int id){
        return "";
    }
    
    public String obtenerIngresosProductosHTML(){
        return "";
    }
    
}
