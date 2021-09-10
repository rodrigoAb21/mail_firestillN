/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Negocio;

import Datos.DatosDetalleNotaVenta;
import Datos.DatosNotaVenta;
import Datos.DatosProducto;

/**
 *
 * @author asus
 */
public class NegocioDetalleNotaVenta {
    public NegocioDetalleNotaVenta() {
        
    }
    
    public Integer registrar(Integer nota_venta_id, Integer producto_id, Integer cantidad){
        DatosDetalleNotaVenta datosDetalleNotaVenta= new DatosDetalleNotaVenta();
        datosDetalleNotaVenta.setNota_venta_id(nota_venta_id);
        datosDetalleNotaVenta.setProducto_id(producto_id);
        datosDetalleNotaVenta.setCantidad(cantidad);
        
        DatosProducto datosProducto= new DatosProducto();
        datosProducto= datosProducto.obtener(producto_id);
        datosDetalleNotaVenta.setPrecio(datosProducto.getPrecio());
        
        Integer id= datosDetalleNotaVenta.insertar();
        int cantidad_resultante= datosProducto.getCantidad()-cantidad;
        datosDetalleNotaVenta.setCantidad(cantidad_resultante);
        
        DatosNotaVenta nota_venta=new DatosNotaVenta();
        nota_venta= nota_venta.obtener(nota_venta_id);
        
        System.out.println("nota venta total: "+nota_venta.getTotal());
        System.out.println("precio producto: "+datosProducto.getPrecio());
        float total_resultante=nota_venta.getTotal()+datosProducto.getPrecio();
        nota_venta.setTotal(total_resultante);
        nota_venta.editar();
        
        return id;
    }
    
    public static void main(String[] args) {
        NegocioDetalleNotaVenta n= new NegocioDetalleNotaVenta();
        n.registrar(4,1,2);
    }
    
    
   
}
