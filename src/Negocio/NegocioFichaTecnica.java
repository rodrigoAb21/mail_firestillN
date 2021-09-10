/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Negocio;

import Datos.DatosFichaTecnica;
import Datos.DatosTrabajador;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.Date;

/**
 *
 * @author asus
 */
public class NegocioFichaTecnica {
    public NegocioFichaTecnica() {
        
    }
    
    public Integer registrar(Integer trabajador_id, Integer equipo_id,Float carga, String observacion,String resultado){
        DatosFichaTecnica datosFichaTecnica = new DatosFichaTecnica();
        datosFichaTecnica.setTrabajador_id(trabajador_id);
        datosFichaTecnica.setEquipo_id(equipo_id);
        datosFichaTecnica.setCarga(carga);
        datosFichaTecnica.setObservacion(observacion);
        datosFichaTecnica.setResultado(resultado);
        datosFichaTecnica.seteCanioPesca("Bueno");
        datosFichaTecnica.seteZuncho("Bueno");
        datosFichaTecnica.seteChasis("Bueno");
        datosFichaTecnica.seteRueda("Bueno");
        datosFichaTecnica.seteRosca("Bueno");
        datosFichaTecnica.seteManguera("Bueno");
        datosFichaTecnica.seteValvula("Bueno");
        datosFichaTecnica.seteTobera("Bueno");
        datosFichaTecnica.seteRobinete("Bueno");
        datosFichaTecnica.setePalanca("Bueno");
        datosFichaTecnica.seteManometro("Bueno");
        datosFichaTecnica.seteVastago("Bueno");
        datosFichaTecnica.seteDifusor("Bueno");
        datosFichaTecnica.seteDisco("Bueno");
        DateTimeFormatter dtf = DateTimeFormatter.ofPattern("yyyy/MM/dd");
        String fecha = dtf.format(LocalDateTime.now());
        Date fecha_hoy=new Date(fecha);
        datosFichaTecnica.setFecha(fecha_hoy);
        return datosFichaTecnica.insertar();
    }
    
    public void editar(Integer ficha_tecnica_id, Integer nro_parte){
        DatosFichaTecnica datosFichaTecnica= new DatosFichaTecnica();
        datosFichaTecnica = datosFichaTecnica.obtener(ficha_tecnica_id);
        if(nro_parte==1){
           datosFichaTecnica.seteCanioPesca("Malo");
        }
        if(nro_parte==2){
            datosFichaTecnica.seteZuncho("Malo");
        }
        if(nro_parte==3){
            datosFichaTecnica.seteChasis("Malo");
        }
        if(nro_parte==4){
            datosFichaTecnica.seteRueda("Malo");
        }
        if(nro_parte==5){
            datosFichaTecnica.seteRosca("Malo");
        }
        if(nro_parte==6){
            datosFichaTecnica.seteManguera("Malo");
        }
        if(nro_parte==7){
            datosFichaTecnica.seteValvula("Malo");
        }
        if(nro_parte==8){
            datosFichaTecnica.seteTobera("Malo");
        }
        if(nro_parte==9){
            datosFichaTecnica.seteRobinete("Malo");
        }
        if(nro_parte==10){
            datosFichaTecnica.setePalanca("Malo");
        }
        if(nro_parte==11){
            datosFichaTecnica.seteManometro("Malo");
        }
        if(nro_parte==12){
            datosFichaTecnica.seteVastago("Malo");
        }
        if(nro_parte==13){
            datosFichaTecnica.seteDifusor("Malo");
        }
        if(nro_parte==14){
            datosFichaTecnica.seteDisco("Malo");
        }
        datosFichaTecnica.editar();
    }
    
    public void eliminar(int id)throws Exception{
        DatosFichaTecnica datosFichaTecnica = new DatosFichaTecnica();
        datosFichaTecnica= datosFichaTecnica.obtener(id);
        if(datosFichaTecnica.getDeleted_at().contentEquals("null")){
            datosFichaTecnica.eliminar();
        }else{
            throw new Exception("ya fue eliminado");
        }
    }
    
    public DatosFichaTecnica obtenerFichaTecnica(int id){
        DatosFichaTecnica datosFichaTecnica = new DatosFichaTecnica();
        datosFichaTecnica= datosFichaTecnica.obtener(id);
        return datosFichaTecnica;
    }
    
    public ArrayList<DatosFichaTecnica> obtenerFichasTecnicas(){
        DatosFichaTecnica datosFichaTecnica = new DatosFichaTecnica();
        ArrayList<DatosFichaTecnica> lista = datosFichaTecnica.obtener();
        return lista;
    }
    
    public String obtenerFichaTecnicaHTML(int id){
        DatosFichaTecnica datosFichaTecnica= obtenerFichaTecnica(id);
        DatosTrabajador datosTrabajador = new DatosTrabajador().obtener(datosFichaTecnica.getTrabajador_id());

        String html = "<h2>Ver Ficha Tecnica: "+datosFichaTecnica.getId()+"</h2>\n" +
                "<div class=\"tecno_recuadro\">\n" +
                "    <label><b>Fecha</b> </label>\n" +
                "    <p class=\"tecno_input\">"+datosFichaTecnica.getFecha()+"</p>\n" +
                "    <label><b>Responsable</b> </label>\n" +
                "    <p class=\"tecno_input\">"+datosTrabajador.getNombre() + " " + datosTrabajador.getApellido() +"</p>\n" +
                "    <label><b>Caño Pesca</b> </label>\n" +
                "    <p class=\"tecno_input\">"+datosFichaTecnica.geteCanioPesca()+"</p>\n" +
                "    <label><b>Zuncho</b> </label>\n" +
                "    <p class=\"tecno_input\">"+datosFichaTecnica.geteZuncho()+"</p>\n" +
                "    <label><b>Chasis</b> </label>\n" +
                "    <p class=\"tecno_input\">"+datosFichaTecnica.geteChasis()+"</p>\n" +
                "    <label><b>Rueda</b> </label>\n" +
                "    <p class=\"tecno_input\">"+datosFichaTecnica.geteRueda()+"</p>\n" +
                "    <label><b>Rosca</b> </label>\n" +
                "    <p class=\"tecno_input\">"+datosFichaTecnica.geteRosca()+"</p>\n" +
                "    <label><b>Manguera</b> </label>\n" +
                "    <p class=\"tecno_input\">"+datosFichaTecnica.geteManguera()+"</p>\n" +
                "    <label><b>Valvula</b> </label>\n" +
                "    <p class=\"tecno_input\">"+datosFichaTecnica.geteValvula()+"</p>\n" +
                "    <label><b>Tobera</b> </label>\n" +
                "    <p class=\"tecno_input\">"+datosFichaTecnica.geteTobera()+"</p>\n" +
                "    <label><b>Robinete</b> </label>\n" +
                "    <p class=\"tecno_input\">"+datosFichaTecnica.geteRobinete()+"</p>\n" +
                "    <label><b>Palanca</b> </label>\n" +
                "    <p class=\"tecno_input\">"+datosFichaTecnica.getePalanca()+"</p>\n" +
                "    <label><b>Manometro</b> </label>\n" +
                "    <p class=\"tecno_input\">"+datosFichaTecnica.geteManometro()+"</p>\n" +
                "    <label><b>Vastago</b> </label>\n" +
                "    <p class=\"tecno_input\">"+datosFichaTecnica.geteVastago()+"</p>\n" +
                "    <label><b>Difusor</b> </label>\n" +
                "    <p class=\"tecno_input\">"+datosFichaTecnica.geteDifusor()+"</p>\n" +
                "    <label><b>Disco</b> </label>\n" +
                "    <p class=\"tecno_input\">"+datosFichaTecnica.geteDisco()+"</p>\n" +
                "    <label><b>Carga</b> </label>\n" +
                "    <p class=\"tecno_input\">"+datosFichaTecnica.getCarga()+"</p>\n" +
                "    <label><b>Resultado</b> </label>\n" +
                "    <p class=\"tecno_input\">"+datosFichaTecnica.getResultado()+"</p>\n" +
                "    <label><b>Observacion</b> </label>\n" +
                "    <p class=\"tecno_input\">"+datosFichaTecnica.getObservacion()+"</p>\n" +
                "</div>\n";


        return html;
        
    }
    
    public String obtenerFichasTecnicasHTML(){
        DatosFichaTecnica datosFichaTecnica = new DatosFichaTecnica();
        ArrayList<DatosFichaTecnica> lista= obtenerFichasTecnicas();
        String html="";
        
        String contenido="";
        for (DatosFichaTecnica ficha_tecnica : lista) {
            Integer id= ficha_tecnica.getId();
            Date fecha=ficha_tecnica.getFecha();
            Float carga=ficha_tecnica.getCarga();
            String observacion=ficha_tecnica.getObservacion();
            String resultado=ficha_tecnica.getResultado();
            Integer equipo_id=ficha_tecnica.getEquipo_id();
            Integer trabajador_id=ficha_tecnica.getTrabajador_id();

            DatosTrabajador datosTrabajador = new DatosTrabajador().obtener(ficha_tecnica.getTrabajador_id());


            contenido+="<tr class=\"trDatosTecno\">\n" +
                    "<td class=\"tdcol1Tecno\">"+id+"</td>\n" +
                    "<td class=\"tdcol1Tecno\">"+fecha+"</td>\n" +
                    "<td class=\"tdcol1Tecno\">"+equipo_id+"</td>\n" +
                    "<td class=\"tdcol1Tecno\">"+datosTrabajador.getNombre() + " " + datosTrabajador.getApellido() +"</td>\n" +
                    "<td class=\"tdcol1Tecno\">"+resultado+"</td>\n" +
                    "<td >"+
                    "<li>"+
                    "<a href=\"mailto:grupo13sc@tecnoweb.org.bo?subject= mostrarFichaInspeccion:"+id+"\">Mostrar </a>\n" +
                    "</li>"+
                    "<li>"+
                    "<a href=\"mailto:grupo13sc@tecnoweb.org.bo?subject= eliminarFichaInspeccion:"+id+"\">Eliminar </a>\n" +
                    "</li>"+
                    "</td>\n" +
                    "</tr>\n";
        }
        
        html="<h2>Fichas de inspeccion</h2>"+
             "<a href=\"mailto:grupo13sc@tecnoweb.org.bo?subject= registrarFichaInspeccion: EQUIPO_ID, CARGA, OBSERVACION, RESULTADO\">Registrar Ficha Inspeccion</a><br>" +
             "<table class=\"tablaTecno\">\n" +
            "  <thead>\n" +
            "    <tr class=\"trCamposTecno\">\n" +
            "      <th >ID</th>\n"+
            "      <th class=\"thcolxTecno\">Fecha</th>\n" +
            "      <th class=\"thcolxTecno\">Equipo</th>\n" +
            "      <th class=\"thcolxTecno\">Inspector</th>\n" +
            "      <th class=\"thcolxTecno\">Resultado</th>\n" + 
            "      <th class=\"thcolxTecno\">Opciones</th>\n" +                
            "    </tr>\n" +
            "  </thead>\n" +
            "  <tbody>\n" +    
                contenido+
            "  </tbody>\n" +
            "</table>";
        
        
        return html;
    }
    
    public String obtenerListaPartesHTML(){
        String html="<h2>Partes de extintor</h2>"+
            "<table class=\"tablaTecno\">\n" +
            "  <thead>\n" +
            "    <tr class=\"trCamposTecno\">\n" +
            "      <th >ID</th>\n"+
            "      <th class=\"thcolxTecno\">Nombre</th>\n" +                
            "    </tr>\n" +
            "  </thead>\n" +
            "  <tbody>\n" +    
                "<tr class=\"trDatosTecno\">\n" +
                       "<td class=\"tdcol1Tecno\">1</td>\n" +
                       "<td class=\"tdcol1Tecno\">CañoPesca</td>\n" +
                "</tr>\n"+
                "<tr class=\"trDatosTecno\">\n" +
                       "<td class=\"tdcol1Tecno\">2</td>\n" +
                       "<td class=\"tdcol1Tecno\">Zuncho</td>\n" +
                "</tr>\n"+
                "<tr class=\"trDatosTecno\">\n" +
                       "<td class=\"tdcol1Tecno\">3</td>\n" +
                       "<td class=\"tdcol1Tecno\">Chasis</td>\n" +
                "</tr>\n"+
                "<tr class=\"trDatosTecno\">\n" +
                       "<td class=\"tdcol1Tecno\">4</td>\n" +
                       "<td class=\"tdcol1Tecno\">Rueda</td>\n" +
                "</tr>\n"+
                "<tr class=\"trDatosTecno\">\n" +
                       "<td class=\"tdcol1Tecno\">5</td>\n" +
                       "<td class=\"tdcol1Tecno\">Rosca</td>\n" +
                "</tr>\n"+
                "<tr class=\"trDatosTecno\">\n" +
                       "<td class=\"tdcol1Tecno\">6</td>\n" +
                       "<td class=\"tdcol1Tecno\">Manguera</td>\n" +
                "</tr>\n"+
                "<tr class=\"trDatosTecno\">\n" +
                       "<td class=\"tdcol1Tecno\">7</td>\n" +
                       "<td class=\"tdcol1Tecno\">Valvula</td>\n" +
                "</tr>\n"+
                "<tr class=\"trDatosTecno\">\n" +
                       "<td class=\"tdcol1Tecno\">8</td>\n" +
                       "<td class=\"tdcol1Tecno\">Tobera</td>\n" +
                "</tr>\n"+
                "<tr class=\"trDatosTecno\">\n" +
                       "<td class=\"tdcol1Tecno\">9</td>\n" +
                       "<td class=\"tdcol1Tecno\">Robinete</td>\n" +
                "</tr>\n"+
                "<tr class=\"trDatosTecno\">\n" +
                       "<td class=\"tdcol1Tecno\">10</td>\n" +
                       "<td class=\"tdcol1Tecno\">Palanca</td>\n" +
                "</tr>\n"+
                "<tr class=\"trDatosTecno\">\n" +
                       "<td class=\"tdcol1Tecno\">11</td>\n" +
                       "<td class=\"tdcol1Tecno\">Manometro</td>\n" +
                "</tr>\n"+
                "<tr class=\"trDatosTecno\">\n" +
                       "<td class=\"tdcol1Tecno\">12</td>\n" +
                       "<td class=\"tdcol1Tecno\">Vastago</td>\n" +
                "</tr>\n"+
                "<tr class=\"trDatosTecno\">\n" +
                       "<td class=\"tdcol1Tecno\">13</td>\n" +
                       "<td class=\"tdcol1Tecno\">Difusor</td>\n" +
                "</tr>\n"+
                "<tr class=\"trDatosTecno\">\n" +
                       "<td class=\"tdcol1Tecno\">14</td>\n" +
                       "<td class=\"tdcol1Tecno\">Disco</td>\n" +
                "</tr>\n"+
            "  </tbody>\n" +
            "</table>";
        
        
        return html;
    }

    public String obtenerFichasTecnicasHTMLporEquipo(int equipo_id){
        DatosFichaTecnica datosFichaTecnica = new DatosFichaTecnica();
        ArrayList<DatosFichaTecnica> lista= obtenerFichasTecnicas();
        String html="";

        String contenido="";
        for (DatosFichaTecnica ficha_tecnica : lista) {
            if (equipo_id == ficha_tecnica.getEquipo_id()){
                Integer id= ficha_tecnica.getId();
                Date fecha=ficha_tecnica.getFecha();
                Float carga=ficha_tecnica.getCarga();
                String observacion=ficha_tecnica.getObservacion();
                String resultado=ficha_tecnica.getResultado();
                DatosTrabajador datosTrabajador = new DatosTrabajador().obtener(ficha_tecnica.getTrabajador_id());


                contenido+="<tr class=\"trDatosTecno\">\n" +
                        "<td class=\"tdcol1Tecno\">"+id+"</td>\n" +
                        "<td class=\"tdcol1Tecno\">"+fecha+"</td>\n" +
                        "<td class=\"tdcol1Tecno\">"+datosTrabajador.getNombre() + " " + datosTrabajador.getApellido() +"</td>\n" +
                        "<td class=\"tdcol1Tecno\">"+resultado+"</td>\n" +
                        "<td >"+
                        "<li>"+
                        "<a href=\"mailto:grupo13sc@tecnoweb.org.bo?subject= mostrarFichaInspeccion:"+id+"\">Mostrar </a>\n" +
                        "</li>"+
                        "<li>"+
                        "<a href=\"mailto:grupo13sc@tecnoweb.org.bo?subject= eliminarFichaInspeccion:"+id+"\">Eliminar </a>\n" +
                        "</li>"+
                        "</td>\n" +
                        "</tr>\n";
            }
        }

        html="<h2>Fichas de inspeccion</h2>"+
                "<a href=\"mailto:grupo13sc@tecnoweb.org.bo?subject= registrarFichaInspeccion: EQUIPO_ID, CARGA, OBSERVACION, RESULTADO\">Registrar Ficha Inspeccion</a><br>" +
                "<table class=\"tablaTecno\">\n" +
                "  <thead>\n" +
                "    <tr class=\"trCamposTecno\">\n" +
                "      <th >ID</th>\n"+
                "      <th class=\"thcolxTecno\">Fecha</th>\n" +
                "      <th class=\"thcolxTecno\">Inspector</th>\n" +
                "      <th class=\"thcolxTecno\">Resultado</th>\n" +
                "      <th class=\"thcolxTecno\">Opciones</th>\n" +
                "    </tr>\n" +
                "  </thead>\n" +
                "  <tbody>\n" +
                contenido+
                "  </tbody>\n" +
                "</table>";


        return html;
    }
    
    public static void main(String[] args) {
        DateTimeFormatter dtf = DateTimeFormatter.ofPattern("yyyy/MM/dd");
        String fecha = dtf.format(LocalDateTime.now());
        Date fecha_hoy=new Date(fecha);
        System.out.println(fecha_hoy);
    }
}
