/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Negocio;

import Datos.DatosFichaMantenimiento;
import java.util.ArrayList;
import java.util.Date;

/**
 *
 * @author asus
 */
public class NegocioFichaMantenimiento {
    public NegocioFichaMantenimiento() {
        
    }
    
    public void registrar( Integer equipo_id, Integer empleado_id,Date fecha, String descripcion){
        DatosFichaMantenimiento datosFichaTecnica = new DatosFichaMantenimiento();
        datosFichaTecnica.setEquipo_id(equipo_id);
        datosFichaTecnica.setEmpleado_id(empleado_id);
        datosFichaTecnica.setFecha(fecha);
        datosFichaTecnica.setDescripcion(descripcion);
        datosFichaTecnica.insertar();
    }
    
    public void editar( Integer equipo_id, Integer empleado_id,Integer id, Date fecha, String descripcion){
        DatosFichaMantenimiento datosFichaTecnica = new DatosFichaMantenimiento();
        datosFichaTecnica=datosFichaTecnica.obtener(id);
        datosFichaTecnica.setFecha(fecha);
        datosFichaTecnica.setDescripcion(descripcion);
        datosFichaTecnica.setEquipo_id(equipo_id);
        datosFichaTecnica.setEmpleado_id(empleado_id);
        datosFichaTecnica.editar();
    }
    
    public void eliminar(Integer id){
        DatosFichaMantenimiento datosFichaTecnica = new DatosFichaMantenimiento();
        datosFichaTecnica=datosFichaTecnica.obtener(id);
        datosFichaTecnica.eliminar();
    }
    
    public DatosFichaMantenimiento obtenerFichaMantenimiento(Integer id){
        DatosFichaMantenimiento datosFichaTecnica = new DatosFichaMantenimiento();
        datosFichaTecnica = datosFichaTecnica.obtener(id);
        return datosFichaTecnica;
    }
    
    public ArrayList<DatosFichaMantenimiento> obtenerFichasMantenimiento(){
        DatosFichaMantenimiento datosFichaTecnica = new DatosFichaMantenimiento();
        ArrayList<DatosFichaMantenimiento> lista = datosFichaTecnica.obtener();
        return lista;
    }
    
    
    
    
}
