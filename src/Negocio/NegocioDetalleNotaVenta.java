/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Negocio;

import Datos.DatosDetalleNotaVenta;
import Datos.DatosNotaVenta;
import Datos.DatosProducto;

import java.util.ArrayList;

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

    public DatosDetalleNotaVenta obtenerDetalleNotaVenta(int id){
        DatosDetalleNotaVenta datosDetalleNotaVenta = new DatosDetalleNotaVenta();
        datosDetalleNotaVenta= datosDetalleNotaVenta.obtener(id);
        return datosDetalleNotaVenta;
    }

    public ArrayList<DatosDetalleNotaVenta> obtenerDetallesNotaVenta(){
        DatosDetalleNotaVenta datosDetalleNotaVenta = new DatosDetalleNotaVenta();
        ArrayList<DatosDetalleNotaVenta> lista = datosDetalleNotaVenta.obtener();
        return lista;
    }


    public String obtenerDetallesIngresoProductosHTMLporNotaVenta(Integer venta_id) {
        DatosDetalleNotaVenta datosDetalleNotaVenta = new DatosDetalleNotaVenta();
        ArrayList<DatosDetalleNotaVenta> lista= obtenerDetallesNotaVenta();
        String html="";

        String contenido="";

        for (DatosDetalleNotaVenta detalle : lista) {
            if (detalle.getNota_venta_id() == venta_id){
                Integer id= detalle.getId();
                Float precio = detalle.getPrecio();
                Integer cantidad = detalle.getCantidad();

                DatosProducto datosProducto = new DatosProducto().obtener(detalle.getProducto_id());

                contenido+="<tr class=\"trDatosTecno\">\n" +
                        "<td class=\"tdcol1Tecno\">"+id+"</td>\n" +
                        "<td >"+datosProducto.getNombre()+"</td>\n" +
                        "<td >"+cantidad+"</td>\n" +
                        "<td >"+precio+"</td>\n" +
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
                "      <th class=\"thcolxTecno\">Precio U.</th>\n" +
                "    </tr>\n" +
                "  </thead>\n" +
                "  <tbody>\n" +
                contenido+
                "  </tbody>\n" +
                "</table>";
        return html;
    }
}
