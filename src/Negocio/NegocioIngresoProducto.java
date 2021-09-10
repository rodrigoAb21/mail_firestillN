/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Negocio;

import Datos.DatosDetalleIngresoProducto;
import Datos.DatosIngresoProducto;
import Datos.DatosProveedor;
import Datos.DatosTipoClasificacion;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.Date;

/**
 *
 * @author asus
 */
public class NegocioIngresoProducto {
    
    public NegocioIngresoProducto() {
        
    }
    
    public Integer registrar(Integer proveedor_id, String nro_factura){
        DateTimeFormatter dtf = DateTimeFormatter.ofPattern("yyyy/MM/dd");
        String fecha = dtf.format(LocalDateTime.now());
        Date fecha_hoy=new Date(fecha);
        
        DatosIngresoProducto datosIngresoProducto = new DatosIngresoProducto();
        datosIngresoProducto.setFecha(fecha_hoy);
        datosIngresoProducto.setProveedor_id(proveedor_id);
        datosIngresoProducto.setNro_factura(nro_factura);
        float total=0;
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
        DatosIngresoProducto datosIngresoProducto = obtenerIngresoProducto(id);
        DatosProveedor datosProveedor = new DatosProveedor().obtener(datosIngresoProducto.getProveedor_id());

        String html = "<h2>Ver Ingreso de Producto: "+datosIngresoProducto.getId()+"</h2>\n" +
                "<div class=\"tecno_recuadro\">\n" +
                "    <label><b>Fecha</b> </label>\n" +
                "    <p class=\"tecno_input\">"+datosIngresoProducto.getFecha()+"</p>\n" +
                "    <label><b>Nro Factura</b> </label>\n" +
                "    <p class=\"tecno_input\">"+datosIngresoProducto.getNro_factura()+"</p>\n" +
                "    <label><b>Proveedor</b> </label>\n" +
                "    <p class=\"tecno_input\">"+datosProveedor.getNombre()+"</p>\n" +
                "    <label><b>Total Bs</b> </label>\n" +
                "    <p class=\"tecno_input\">"+datosIngresoProducto.getTotal()+"</p>\n" +
                "</div>\n";

        String html2 = new NegocioDetalleIngresoProducto().obtenerDetallesIngresoProductosHTMLporIngreso(id);

        return html + "\n<br>\n" +html2;
    }
    
    public String obtenerIngresosProductosHTML(){
        ArrayList<DatosIngresoProducto> lista = obtenerIngresosProductos();
        String html = "";
        String contenido="";
        for (DatosIngresoProducto ingresoProducto : lista){
            Integer id = ingresoProducto.getId();
            Date fecha = ingresoProducto.getFecha();
            String nro_factura = ingresoProducto.getNro_factura();
            Float total = ingresoProducto.getTotal();
            Integer proveedor_id = ingresoProducto.getProveedor_id();

            DatosProveedor datosProveedor = new DatosProveedor().obtener(proveedor_id);

            contenido+="<tr class=\"trDatosTecno\">\n" +
                    "<td class=\"tdcol1Tecno\">"+id+"</td>\n" +
                    "<td >"+fecha+"</td>\n" +
                    "<td >"+nro_factura+"</td>\n" +
                    "<td >"+datosProveedor.getNombre()+"</td>\n" +
                    "<td >"+total+"</td>\n" +
                    "<td >"+
                    "<li>"+
                    "<a href=\"mailto:grupo13sc@tecnoweb.org.bo?subject= eliminaringresoproducto:"+ingresoProducto.getId()+"\">Eliminar </a>\n" +
                    "</li>"+
                    "</td>\n" +
                    "</tr>\n";

        }
        html="<h2>Ingresos de Productos</h2>" +
                "<table class=\"tablaTecno\">\n" +
                "  <thead>\n" +
                "    <tr class=\"trCamposTecno\">\n" +
                "      <th >ID</th>\n"+
                "      <th class=\"thcolxTecno\">Fecha</th>\n" +
                "      <th class=\"thcolxTecno\">Nro Factura</th>\n" +
                "      <th class=\"thcolxTecno\">Proveedor</th>\n" +
                "      <th class=\"thcolxTecno\">Total Bs</th>\n" +
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
