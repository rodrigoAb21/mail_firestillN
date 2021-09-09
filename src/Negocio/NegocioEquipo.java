/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Negocio;

import Datos.DatosEquipo;
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
    
    public String obtenerEquipoHTML(Integer id){
        String html= " ";
        return html;
    }
    
    public String obtenerEquiposHTML(){
        String html= " ";
        return html;
    }
    
    
}
