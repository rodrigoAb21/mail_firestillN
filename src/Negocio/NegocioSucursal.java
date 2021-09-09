/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Negocio;

import Datos.DatosCliente;
import Datos.DatosSucursal;
import java.util.ArrayList;

/**
 *
 * @author asus
 */
public class NegocioSucursal {
    public NegocioSucursal() {
        
    }
    
    public Integer registrar(Integer contrato_id, String nombre, String direccion){
        DatosSucursal datosSucursal=new DatosSucursal();
        datosSucursal.setNombre(nombre);
        datosSucursal.setDireccion(direccion);
        datosSucursal.setContrato_id(contrato_id);
        return datosSucursal.insertar();
    }
    
    public void editar(Integer id, Integer contrato_id, String nombre, String direccion){
        DatosSucursal datosSucursal=new DatosSucursal();
        datosSucursal= datosSucursal.obtener(id);
        datosSucursal.setNombre(nombre);
        datosSucursal.setDireccion(direccion);
        datosSucursal.setContrato_id(contrato_id);
        datosSucursal.editar();
    }
    
    public void eliminar(Integer id){
        DatosSucursal datosSucursal = new DatosSucursal();
        datosSucursal = datosSucursal.obtener(id);
        datosSucursal.eliminar();
    }
    
    public DatosSucursal obtenerSucursal(Integer id){
        DatosSucursal datosSucursal = new DatosSucursal();
        datosSucursal = datosSucursal.obtener(id);
        return datosSucursal;
    }
    
    public ArrayList<DatosSucursal> obtenerSucursales(){
        DatosSucursal datosSucursal = new DatosSucursal();
        ArrayList<DatosSucursal> lista = datosSucursal.obtener();
        return lista;
    }
    
    
    
    
    
}
