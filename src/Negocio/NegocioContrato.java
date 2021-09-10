/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Negocio;

import Datos.DatosCliente;
import Datos.DatosContrato;
import Datos.DatosTrabajador;

import java.util.ArrayList;
import java.util.Date;

/**
 *
 * @author asus
 */
public class NegocioContrato {
    public NegocioContrato() {
        
    }
    
    public Integer registrar(Integer cliente_id, Integer trabajador_id,Date fecha_inicio, Date fecha_fin, Integer periodo){
        DatosContrato datosContrato= new DatosContrato();
        datosContrato.setCliente_id(cliente_id);
        datosContrato.setTrabajador_id(trabajador_id);
        datosContrato.setFecha_fin(fecha_fin);
        datosContrato.setFecha_fin(fecha_fin);
        datosContrato.setPeriodo(periodo);
        return datosContrato.insertar();
    }
    
    public void editar(Integer id,Integer cliente_id, Integer trabajador_id,Date fecha_inicio, Date fecha_fin, Integer periodo){
        DatosContrato datosContrato= new DatosContrato();
        datosContrato= datosContrato.obtener(id);
        if(datosContrato.isEdicion()){
            datosContrato.setCliente_id(cliente_id);
            datosContrato.setTrabajador_id(trabajador_id);
            datosContrato.setFecha_fin(fecha_fin);
            datosContrato.setFecha_fin(fecha_fin);
            datosContrato.setPeriodo(periodo);
            datosContrato.editar();
        }
    }
    
    public void finalizarEdicion(Integer contrato_id){
        DatosContrato datosContrato= new DatosContrato();
        datosContrato=datosContrato.obtener(contrato_id);
        datosContrato.setEdicion(false);
        datosContrato.editar();
    }
    
    public void eliminar(Integer id){
        DatosContrato datosContrato = new DatosContrato();
        datosContrato = datosContrato.obtener(id);
        datosContrato.eliminar();
    }
    
    public DatosContrato obtenerContrato(Integer id){
        DatosContrato datosContrato = new DatosContrato();
        datosContrato = datosContrato.obtener(id);
        return datosContrato;
    }
    
    public ArrayList<DatosContrato> obtenerContratos(){
        DatosContrato datosContrato = new DatosContrato();
        ArrayList<DatosContrato> lista = datosContrato.obtener();
        return lista;
    }
    
    public String obtenerContratoHTML(int id){
        DatosContrato datosContrato = new DatosContrato();
        datosContrato = datosContrato.obtener(id);

        DatosTrabajador datosTrabajador = new DatosTrabajador();
        datosTrabajador = datosTrabajador.obtener(datosContrato.getTrabajador_id());

        DatosCliente datosCliente = new DatosCliente();
        datosCliente = datosCliente.obtener(datosContrato.getCliente_id());

        String html = "<h2>Ver Contrato: "+datosContrato.getId()+"</h2>\n" +
                "<div class=\"tecno_recuadro\">\n" +
                "    <label><b>Cliente</b> </label>\n" +
                "    <p class=\"tecno_input\">"+datosCliente.getNombre_empresa()+"</p>\n" +
                "    <label><b>Representante Firestill</b> </label>\n" +
                "    <p class=\"tecno_input\">"+datosTrabajador.getNombre()+ " " + datosTrabajador.getApellido() + "</p>\n" +
                "    <label><b>Fecha inicio</b> </label>\n" +
                "    <p class=\"tecno_input\">"+datosContrato.getFecha_inicio()+"</p>\n" +
                "    <label><b>Fecha fin</b> </label>\n" +
                "    <p class=\"tecno_input\">"+datosContrato.getFecha_fin()+"</p>\n" +
                "    <label><b>Periodo (Mes)</b> </label>\n" +
                "    <p class=\"tecno_input\">"+datosContrato.getPeriodo()+"</p>\n" +
                "</div>\n";

        String html2 = "";
        html2 = new NegocioSucursal().obtenerSucursalHTMLporContrato(id);
        return html + "\n<br>\n" +html2;
    }
    
    public String obtenerContratosHTML(){
        DatosContrato datosContrato = new DatosContrato();
        ArrayList<DatosContrato> lista= obtenerContratos();
        String html="";
        
        String contenido="";
        for (DatosContrato contrato : lista) {
            
             Integer id = contrato.getId() ;
             Date fecha_inicio= contrato.getFecha_inicio();
             Date fecha_fin =contrato.getFecha_fin();
             String estado=contrato.getEstado();
             boolean edicion=contrato.isEdicion();
             Integer periodo= contrato.getPeriodo();
             String documento=contrato.getDocumento();
             Integer cliente_id= contrato.getCliente_id();
             Integer trabajador_id= contrato.getTrabajador_id();
             
             DatosCliente cliente= new DatosCliente();
             String cliente_nombre= cliente.obtener(cliente_id).getNombre_empresa();
            
             String opciones= "";
             if(edicion==true){
                 opciones="<li>"+
                             "<a href=\"mailto:grupo13sc@tecnoweb.org.bo?subject= editarContrato:"+id+", "+cliente_id+", "+fecha_inicio+", "+fecha_fin+", "+periodo+"\">Editar </a>\n" +
                             "</li>"+
                             "<li>"+
                             "<a href=\"mailto:grupo13sc@tecnoweb.org.bo?subject= finalizarEdicionContrato:"+id+"\">Finalizar Edicion </a>\n" +
                             "</li>";
             }
            contenido+="<tr class=\"trDatosTecno\">\n" +
                       "<td class=\"tdcol1Tecno\">"+id+"</td>\n" +
                       "<td >"+cliente_nombre+"</td>\n" +
                       "<td >"+fecha_inicio+"</td>\n" +       
                       "<td >"+fecha_fin+"</td>\n" +
                       "<td >"+periodo+"</td>\n" +        
                       "<td >"+
                             "<li>"+
                             "<a href=\"mailto:grupo13sc@tecnoweb.org.bo?subject= mostrarContrato:"+id+"\">Mostrar </a>\n" +
                             "</li>"+
                             opciones +
                             "<li>"+
                             "<a href=\"mailto:grupo13sc@tecnoweb.org.bo?subject= eliminarContrato:"+id+"\">Eliminar </a>\n" +
                             "</li>"+
                       "</td>\n" +
                       "</tr>\n";
        }
        
        html="<h2>Contratos</h2>"+
             "<a href=\"mailto:grupo13sc@tecnoweb.org.bo?subject= registrarContrato: CLIENTE_ID, FECHA_INICIO, FECHA_FIN, PERIODO_ENTRE_REVISIONES\">Registrar Contrato</a><br>" +
            "<table class=\"tablaTecno\">\n" +
            "  <thead>\n" +
            "    <tr class=\"trCamposTecno\">\n" +
            "      <th >ID</th>\n"+
            "      <th class=\"thcolxTecno\">Cliente</th>\n" +     
            "      <th class=\"thcolxTecno\">Fecha Inicio</th>\n" +
            "      <th class=\"thcolxTecno\">Fecha Fin</th>\n" +
            "      <th class=\"thcolxTecno\">Periodo</th>\n" +   
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
