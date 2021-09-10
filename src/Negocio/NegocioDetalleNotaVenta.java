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
        System.out.println("nota venta: "+nota_venta.getId()+" " );
        System.out.println("nota venta total: "+nota_venta.getTotal().toString());
        System.out.println("precio producto: "+datosProducto.getPrecio().toString());
        float total_resultante=nota_venta.getTotal()+(datosProducto.getPrecio()*cantidad);
        nota_venta.setTotal(total_resultante);
        System.out.println("total resultante: "+total_resultante);
        nota_venta.editar();
        
        return id;
    }
    
    public void eliminar(Integer id){
        DatosDetalleNotaVenta detalle= new DatosDetalleNotaVenta();
        detalle = detalle.obtener(id);
        
        DatosProducto producto= new DatosProducto();
        int cantidad_resultante=producto.getCantidad()+detalle.getCantidad();
        producto.setCantidad(cantidad_resultante);
        producto.editar();
        
        detalle.eliminar();
    }
    
    public static void main(String[] args) {
        NegocioDetalleNotaVenta n= new NegocioDetalleNotaVenta();
        n.registrar(4,1,2);
    }
    
    
   
}
