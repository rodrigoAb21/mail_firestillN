/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Negocio;

import Datos.*;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.Date;

/**
 *
 * @author asus
 */
public class NegocioNotaVenta {
     public NegocioNotaVenta() {
    }
    
    public Integer registrar(Integer trabajador_id,Integer cliente_id){
        DatosNotaVenta datosNotaVenta = new DatosNotaVenta();
        datosNotaVenta.setCliente_id(cliente_id);
        datosNotaVenta.setTrabajador_id(trabajador_id);
        
        DateTimeFormatter dtf = DateTimeFormatter.ofPattern("yyyy/MM/dd");
        String fecha = dtf.format(LocalDateTime.now());
        Date fecha_hoy=new Date(fecha);
        datosNotaVenta.setFecha(fecha_hoy);
        float total=0;
        datosNotaVenta.setTotal(total);
        return datosNotaVenta.insertar();
    }
    
    public void eliminar(Integer id)throws Exception{
        DatosNotaVenta datosNotaVenta= new DatosNotaVenta();
        datosNotaVenta=datosNotaVenta.obtener(id);
        if(datosNotaVenta.getDeleted_at().contentEquals("null")){
            
            
            DatosDetalleNotaVenta detalle= new DatosDetalleNotaVenta();
            ArrayList<DatosDetalleNotaVenta> lista= detalle.obtener();
            for (DatosDetalleNotaVenta detalleNotaVenta : lista) {
                if(detalleNotaVenta.getNota_venta_id()==id){
                    NegocioDetalleNotaVenta n= new NegocioDetalleNotaVenta();
                    n.eliminar(detalleNotaVenta.getId());
                }
            }
            
            datosNotaVenta.eliminar();
        }else{
            throw new Exception("ya fue eliminado");
        }
    }

    public DatosNotaVenta obtenerNotaVenta(int id){
        DatosNotaVenta datosNotaVenta = new DatosNotaVenta();
        datosNotaVenta= datosNotaVenta.obtener(id);
        return datosNotaVenta;
    }

    public ArrayList<DatosNotaVenta> obtenerNotasventa(){
        DatosNotaVenta datosNotaVenta = new DatosNotaVenta();
        ArrayList<DatosNotaVenta> lista = datosNotaVenta.obtener();
        return lista;
    }


    public String obtenerNotaVentaHTML(Integer id) {
        DatosNotaVenta datosNotaVenta = obtenerNotaVenta(id);
        DatosCliente datosCliente = new DatosCliente().obtener(datosNotaVenta.getCliente_id());
        DatosTrabajador datosTrabajador = new DatosTrabajador().obtener(datosNotaVenta.getTrabajador_id());

        String html = "<h2>Ver Ingreso de Producto: "+datosNotaVenta.getId()+"</h2>\n" +
                "<div class=\"tecno_recuadro\">\n" +
                "    <label><b>Fecha</b> </label>\n" +
                "    <p class=\"tecno_input\">"+datosNotaVenta.getFecha()+"</p>\n" +
                "    <label><b>Trabajador</b> </label>\n" +
                "    <p class=\"tecno_input\">"+datosTrabajador.getNombre()+ " " + datosTrabajador.getApellido() + "</p>\n" +
                "    <label><b>Cliente</b> </label>\n" +
                "    <p class=\"tecno_input\">"+datosCliente.getNombre_empresa()+"</p>\n" +
                "    <label><b>Total Bs</b> </label>\n" +
                "    <p class=\"tecno_input\">"+datosNotaVenta.getTotal()+"</p>\n" +
                "</div>\n";

        String html2 = new NegocioDetalleNotaVenta().obtenerDetallesIngresoProductosHTMLporNotaVenta(id);

        return html + "\n<br>\n" +html2;

    }

    public String obtenerNotasVentaHTML() {
        ArrayList<DatosNotaVenta> lista = obtenerNotasventa();
        String html = "";
        String contenido="";
        for (DatosNotaVenta ingresoProducto : lista){
            Integer id = ingresoProducto.getId();
            Date fecha = ingresoProducto.getFecha();
            Float total = ingresoProducto.getTotal();
            Integer trabajador_id = ingresoProducto.getTrabajador_id();
            Integer cliente_id = ingresoProducto.getCliente_id();

            DatosTrabajador datosTrabajador = new DatosTrabajador().obtener(trabajador_id);
            DatosCliente datosCliente = new DatosCliente().obtener(cliente_id);

            contenido+="<tr class=\"trDatosTecno\">\n" +
                    "<td class=\"tdcol1Tecno\">"+id+"</td>\n" +
                    "<td >"+fecha+"</td>\n" +
                    "<td >"+datosTrabajador.getNombre()+ " " + datosTrabajador.getApellido() +"</td>\n" +
                    "<td >"+datosCliente.getNombre_empresa()+"</td>\n" +
                    "<td >"+total+"</td>\n" +
                    "</tr>\n";

        }
        html="<h2>Notas de Venta</h2>" +
                "<a href=\"mailto:grupo13sc@tecnoweb.org.bo?subject= registrarVenta: CLIENTE_ID, PRODUCTO_ID, CANTIDAD, PRODUCTO_ID, CANTIDAD,...\">Registrar Venta</a><br>" + 
                "<table class=\"tablaTecno\">\n" +
                "  <thead>\n" +
                "    <tr class=\"trCamposTecno\">\n" +
                "      <th >ID</th>\n"+
                "      <th class=\"thcolxTecno\">Fecha</th>\n" +
                "      <th class=\"thcolxTecno\">Trabajador</th>\n" +
                "      <th class=\"thcolxTecno\">Cliente</th>\n" +
                "      <th class=\"thcolxTecno\">Total Bs</th>\n" +
                "    </tr>\n" +
                "  </thead>\n" +
                "  <tbody>\n" +
                contenido+
                "  </tbody>\n" +
                "</table>";

        return html;
    }
}
