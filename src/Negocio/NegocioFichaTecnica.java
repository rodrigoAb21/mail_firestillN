/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Negocio;

import Datos.DatosFichaTecnica;
import java.util.ArrayList;

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
    
    public DatosFichaTecnica obtenerTipoClasificacion(int id){
        DatosFichaTecnica datosFichaTecnica = new DatosFichaTecnica();
        datosFichaTecnica= datosFichaTecnica.obtener(id);
        return datosFichaTecnica;
    }
    
    public ArrayList<DatosFichaTecnica> obtenerTiposClasificacion(){
        DatosFichaTecnica datosFichaTecnica = new DatosFichaTecnica();
        ArrayList<DatosFichaTecnica> lista = datosFichaTecnica.obtener();
        return lista;
    }
    
    public String obtenerFichaTecnicaHTML(int id){
        DatosFichaTecnica datosFichaTecnica= new DatosFichaTecnica();
        datosFichaTecnica = datosFichaTecnica.obtener(id);
        String html="";
        
        //faltaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaa
        
        return html;
        
    }
    
    public String obtenerFichasTecnicasHTML(){
        DatosFichaTecnica datosFichaTecnica= new DatosFichaTecnica();
        ArrayList<DatosFichaTecnica> lista = datosFichaTecnica.obtener();
        String html="";
        
        String contenido="";
        for (DatosFichaTecnica tipoClasificacion : lista) {
        }
        
        return html;
        
    }
    
}
