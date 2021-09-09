/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Negocio;

import Datos.DatosCliente;
import Datos.DatosContrato;
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
    
    
    
    
}
