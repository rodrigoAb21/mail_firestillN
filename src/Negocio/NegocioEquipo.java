/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Negocio;

import Datos.DatosEquipo;
import Datos.DatosMarcaClasificacion;
import Datos.DatosTipoClasificacion;
import java.util.ArrayList;

/**
 *
 * @author asus
 */
public class NegocioEquipo {
    public NegocioEquipo() {
        
    }
    
    public Integer registrar(Integer sucursal_id, Integer tipo_clasificacion_id, Integer marca_clasificacion_id, String nro_serie, String descripcion, String unidad_medida, Integer ano_fabricacion, Float capacidad, String ubicacion){
        DatosEquipo datosEquipo = new DatosEquipo();
        datosEquipo.setSucursal_id(sucursal_id);
        datosEquipo.setTipo_clasificacion_id(tipo_clasificacion_id);
        datosEquipo.setMarca_clasificacion_id(marca_clasificacion_id);
        datosEquipo.setNro_serie(nro_serie);
        datosEquipo.setDescripcion(descripcion);
        datosEquipo.setUnidad_medida(unidad_medida);
        datosEquipo.setAno_fabricacion(ano_fabricacion);
        datosEquipo.setCapacidad(capacidad);
        datosEquipo.setUbicacion(ubicacion);
        return datosEquipo.insertar();
    }
    
    public void editar(Integer id,Integer sucursal_id, Integer tipo_clasificacion_id, Integer marca_clasificacion_id, String nro_serie, String descripcion, String unidad_medida, Integer ano_fabricacion, Float capacidad, String ubicacion){
        DatosEquipo datosEquipo = new DatosEquipo();
        datosEquipo= datosEquipo.obtener(id);
        datosEquipo.setSucursal_id(sucursal_id);
        datosEquipo.setTipo_clasificacion_id(tipo_clasificacion_id);
        datosEquipo.setMarca_clasificacion_id(marca_clasificacion_id);
        datosEquipo.setNro_serie(nro_serie);
        datosEquipo.setDescripcion(descripcion);
        datosEquipo.setUnidad_medida(unidad_medida);
        datosEquipo.setAno_fabricacion(ano_fabricacion);
        datosEquipo.setCapacidad(capacidad);
        datosEquipo.setUbicacion(ubicacion);
        datosEquipo.editar();
    }
    
    public void eliminar(Integer id)throws Exception{
        DatosEquipo datosEquipo = new DatosEquipo();
        datosEquipo = datosEquipo.obtener(id);
        if(datosEquipo.getDeleted_at().contentEquals("null")){
            datosEquipo.eliminar();
        }else{
            throw new Exception("ya fue eliminado");
        }
    }
    
    public DatosEquipo obtenerEquipo(Integer id){
        DatosEquipo datosEquipo = new DatosEquipo();
        datosEquipo = datosEquipo.obtener(id);
        return datosEquipo;
    }
    
    public ArrayList<DatosEquipo> obtenerEquipos(){
        DatosEquipo datosEquipo = new DatosEquipo();
        ArrayList<DatosEquipo> lista = datosEquipo.obtener();
        return lista;
    }

    
    public String obtenerEquiposHTML(){
        DatosEquipo datosEquipo = new DatosEquipo();
        ArrayList<DatosEquipo> lista= obtenerEquipos();
        String html="";
        
        String contenido="";
        for (DatosEquipo equipo : lista) {
            Integer id= equipo.getId();
     String nro_serie= equipo.getNro_serie();
     String descripcion=equipo.getDescripcion();
     String unidad_medida=equipo.getUnidad_medida();
     Integer ano_fabricacion=equipo.getAno_fabricacion();
     Float capacidad= equipo.getCapacidad();
     String ubicacion= equipo.getUbicacion();
     Integer sucursal_id = equipo.getSucursal_id();
     Integer tipo_clasificacion_id= equipo.getTipo_clasificacion_id();
     Integer marca_clasificacion_id = equipo.getMarca_clasificacion_id();
            
     DatosTipoClasificacion tipo= new DatosTipoClasificacion();
     String tipo_nombre= tipo.obtener(tipo_clasificacion_id).getNombre();
     
     DatosMarcaClasificacion marca= new DatosMarcaClasificacion();
     String marca_nombre= marca.obtener(marca_clasificacion_id).getNombre();
     
            contenido+="<tr class=\"trDatosTecno\">\n" +
                       "<td class=\"tdcol1Tecno\">"+id+"</td>\n" +
                       "<td >"+nro_serie+"</td>\n" +
                       "<td >"+capacidad+"</td>\n" + 
                       "<td >"+tipo_nombre+"</td>\n" +
                       "<td >"+marca_nombre+"</td>\n" +
                       "<td >"+
                             "<li>"+
                             "<a href=\"mailto:grupo13sc@tecnoweb.org.bo?subject= mostrarEquipo:"+id+"\">Mostrar </a>\n" +
                             "</li>"+
                             "<li>"+
                             "<a href=\"mailto:grupo13sc@tecnoweb.org.bo?subject= editarEquipo:"+id+", "+sucursal_id+", "+tipo_clasificacion_id+", "+marca_clasificacion_id+", "+nro_serie+", "+descripcion+", "+unidad_medida+", "+ano_fabricacion+", "+capacidad+", "+ubicacion+"\">Editar </a>\n" +
                             "</li>"+
                             "<li>"+
                             "<a href=\"mailto:grupo13sc@tecnoweb.org.bo?subject= mostrarFichasTecnicas:"+id+"\">Mostrar Fichas Inspeccion</a>\n" +
                             "</li>"+
                             "<li>"+
                             "<a href=\"mailto:grupo13sc@tecnoweb.org.bo?subject= eliminarEquipo:"+id+"\">Eliminar </a>\n" +
                             "</li>"+
                       "</td>\n" +
                       "</tr>\n";
        }
        
        html="<h2>Equipos</h2>"+
             "<a href=\"mailto:grupo13sc@tecnoweb.org.bo?subject= registrarEquipo: SUCURSAL_ID, TIPO_CLASIFICACION_ID, MARCA_CLASIFICACION_ID, NRO_SERIE, DESCRIPCION, UNIDAD_MEDIDA, ANO_FABRICACION, CAPACIDAD, UBICACION\">Registrar Equipo</a><br>" +
             "<table class=\"tablaTecno\">\n" +
            "  <thead>\n" +
            "    <tr class=\"trCamposTecno\">\n" +
            "      <th >ID</th>\n"+
            "      <th class=\"thcolxTecno\">Nro de Serie</th>\n" +
            "      <th class=\"thcolxTecno\">Capacidad</th>\n" + 
            "      <th class=\"thcolxTecno\">Tipo</th>\n" + 
            "      <th class=\"thcolxTecno\">Marca</th>\n" + 
            "      <th class=\"thcolxTecno\">Opciones</th>\n" +                
            "    </tr>\n" +
            "  </thead>\n" +
            "  <tbody>\n" +    
                contenido+
            "  </tbody>\n" +
            "</table>";
        
        
        return html;
    }

    public String obtenerEquipoHTML(Integer id){
        DatosEquipo datosEquipo = obtenerEquipo(id);


        DatosTipoClasificacion tipo = new DatosTipoClasificacion();
        String tipo_nombre = tipo.obtener(datosEquipo.getTipo_clasificacion_id()).getNombre();

        DatosMarcaClasificacion marca = new DatosMarcaClasificacion();
        String marca_nombre = marca.obtener(datosEquipo.getMarca_clasificacion_id()).getNombre();


        String html = "<h2>Ver Equipo: "+datosEquipo.getId()+"</h2>\n" +
                "<div class=\"tecno_recuadro\">\n" +
                "    <label><b>Nro Serie</b> </label>\n" +
                "    <p class=\"tecno_input\">"+datosEquipo.getNro_serie()+"</p>\n" +
                "    <label><b>Año de fabricación</b> </label>\n" +
                "    <p class=\"tecno_input\">"+datosEquipo.getAno_fabricacion()+"</p>\n" +
                "    <label><b>Tipo</b> </label>\n" +
                "    <p class=\"tecno_input\">"+tipo_nombre+"</p>\n" +
                "    <label><b>Marca</b> </label>\n" +
                "    <p class=\"tecno_input\">"+marca_nombre+"</p>\n" +
                "    <label><b>Capacidad</b> </label>\n" +
                "    <p class=\"tecno_input\">"+datosEquipo.getCapacidad()+"</p>\n" +
                "    <label><b>U.Medida</b> </label>\n" +
                "    <p class=\"tecno_input\">"+datosEquipo.getUnidad_medida()+"</p>\n" +
                "    <label><b>Descripcion</b> </label>\n" +
                "    <p class=\"tecno_input\">"+datosEquipo.getDescripcion()+"</p>\n" +
                "    <label><b>Ubicacion</b> </label>\n" +
                "    <p class=\"tecno_input\">"+datosEquipo.getUbicacion()+"</p>\n" +
                "</div>\n";
        String html2 = "";
        html2 = new NegocioFichaTecnica().obtenerFichasTecnicasHTMLporEquipo(id);

        return html + "\n<br>\n" +html2;
    }

    public String obtenerEquiposHTMLporSucursal(Integer sucursal_id){
        DatosEquipo datosEquipo = new DatosEquipo();
        ArrayList<DatosEquipo> lista= obtenerEquipos();
        String html="";

        String contenido="";
        for (DatosEquipo equipo : lista) {
            if (sucursal_id == equipo.getSucursal_id()){
                Integer id= equipo.getId();
                String nro_serie= equipo.getNro_serie();
                String descripcion=equipo.getDescripcion();
                String unidad_medida=equipo.getUnidad_medida();
                Integer ano_fabricacion=equipo.getAno_fabricacion();
                Float capacidad= equipo.getCapacidad();
                String ubicacion= equipo.getUbicacion();
                Integer tipo_clasificacion_id= equipo.getTipo_clasificacion_id();
                Integer marca_clasificacion_id = equipo.getMarca_clasificacion_id();

                DatosTipoClasificacion tipo= new DatosTipoClasificacion();
                String tipo_nombre= tipo.obtener(tipo_clasificacion_id).getNombre();

                DatosMarcaClasificacion marca= new DatosMarcaClasificacion();
                String marca_nombre= marca.obtener(marca_clasificacion_id).getNombre();

                contenido+="<tr class=\"trDatosTecno\">\n" +
                        "<td class=\"tdcol1Tecno\">"+id+"</td>\n" +
                        "<td >"+nro_serie+"</td>\n" +
                        "<td >"+capacidad+"</td>\n" +
                        "<td >"+tipo_nombre+"</td>\n" +
                        "<td >"+marca_nombre+"</td>\n" +
                        "<td >"+
                        "<li>"+
                        "<a href=\"mailto:grupo13sc@tecnoweb.org.bo?subject= mostrarEquipo:"+id+"\">Mostrar </a>\n" +
                        "</li>"+
                        "<li>"+
                        "<a href=\"mailto:grupo13sc@tecnoweb.org.bo?subject= editarEquipo:"+id+", "+sucursal_id+", "+tipo_clasificacion_id+", "+marca_clasificacion_id+", "+nro_serie+", "+descripcion+", "+unidad_medida+", "+ano_fabricacion+", "+capacidad+", "+ubicacion+"\">Editar </a>\n" +
                        "</li>"+
                        "<li>"+
                        "<a href=\"mailto:grupo13sc@tecnoweb.org.bo?subject= mostrarFichasTecnicas:"+id+"\">Mostrar Fichas Inspeccion</a>\n" +
                        "</li>"+
                        "<li>"+
                        "<a href=\"mailto:grupo13sc@tecnoweb.org.bo?subject= eliminarEquipo:"+id+"\">Eliminar </a>\n" +
                        "</li>"+
                        "</td>\n" +
                        "</tr>\n";
            }
        }

        html="<h2>Equipos</h2>"+
                "<a href=\"mailto:grupo13sc@tecnoweb.org.bo?subject= registrarEquipo: SUCURSAL_ID, TIPO_CLASIFICACION_ID, MARCA_CLASIFICACION_ID, NRO_SERIE, DESCRIPCION, UNIDAD_MEDIDA, ANO_FABRICACION, CAPACIDAD, UBICACION\">Registrar Equipo</a><br>" +
                "<table class=\"tablaTecno\">\n" +
                "  <thead>\n" +
                "    <tr class=\"trCamposTecno\">\n" +
                "      <th >ID</th>\n"+
                "      <th class=\"thcolxTecno\">Nro de Serie</th>\n" +
                "      <th class=\"thcolxTecno\">Capacidad</th>\n" +
                "      <th class=\"thcolxTecno\">Tipo</th>\n" +
                "      <th class=\"thcolxTecno\">Marca</th>\n" +
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
        NegocioEquipo ne= new NegocioEquipo();
        ne.obtenerEquipos();
        for (DatosEquipo equipo : ne.obtenerEquipos()) {
            System.out.println("equipo: "+ equipo.getId());
        }
    }
}
