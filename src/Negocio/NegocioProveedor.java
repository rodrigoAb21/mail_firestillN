/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Negocio;

import Datos.DatosProveedor;
import java.util.ArrayList;


public class NegocioProveedor {

    public NegocioProveedor() {
    }

    public int registrar(String nombre, String nit, String email, String direccion, String telefono, String informacion, String titular, String banco, String sucursal, String nro_cuenta, String moneda, String tipo_identificacion, String nro_identificacion) {
        DatosProveedor datosProveedor= new DatosProveedor();
        datosProveedor.setNombre(nombre);
        datosProveedor.setNit(nit);
        datosProveedor.setEmail(email);
        datosProveedor.setDireccion(direccion);
        datosProveedor.setTelefono(telefono);
        datosProveedor.setInformacion(informacion);
        datosProveedor.setTitular(titular);
        datosProveedor.setBanco(banco);
        datosProveedor.setSucursal(sucursal);
        datosProveedor.setNro_cuenta(nro_cuenta);
        datosProveedor.setMoneda(moneda);
        datosProveedor.setTipo_identificacion(tipo_identificacion);
        datosProveedor.setNro_identificacion(nro_identificacion);
        return datosProveedor.insertar();
    }
    
    public void editar(Integer id,String nombre, String nit, String email, String direccion, String telefono, String informacion, String titular, String banco, String sucursal, String nro_cuenta, String moneda, String tipo_identificacion, String nro_identificacion){
        DatosProveedor datosProveedor= new DatosProveedor();
        datosProveedor = datosProveedor.obtener(id);
        datosProveedor.setNombre(nombre);
        datosProveedor.setNit(nit);
        datosProveedor.setEmail(email);
        datosProveedor.setDireccion(direccion);
        datosProveedor.setTelefono(telefono);
        datosProveedor.setInformacion(informacion);
        datosProveedor.setTitular(titular);
        datosProveedor.setBanco(banco);
        datosProveedor.setSucursal(sucursal);
        datosProveedor.setNro_cuenta(nro_cuenta);
        datosProveedor.setMoneda(moneda);
        datosProveedor.setTipo_identificacion(tipo_identificacion);
        datosProveedor.setNro_identificacion(nro_identificacion);
        datosProveedor.editar();
    }
    
    public void eliminar (Integer id)throws Exception{
        DatosProveedor datosProveedor= new DatosProveedor();
        datosProveedor.obtener(id);
        if(datosProveedor.getDeleted_at().contentEquals("null")){
            datosProveedor.eliminar();
        }else{
            throw new Exception("ya fue eliminado");
        }
    }
    
    public DatosProveedor obtenerProveedor(int id){
        DatosProveedor datosProveedor = new DatosProveedor();
        datosProveedor= datosProveedor.obtener(id);
        return datosProveedor;
    }
    
    public ArrayList<DatosProveedor> obtenerProveedores(){
        DatosProveedor datosProveedor = new DatosProveedor();
        ArrayList<DatosProveedor> lista = datosProveedor.obtener();
        return lista;
    }
    
    public String obtenerProveedorHTML(int id){
        DatosProveedor datosProveedor= new DatosProveedor();
        datosProveedor = datosProveedor.obtener(id);
        String html="";
        html="";
        //faltaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaa
        
        return html;
        
    }
    
    public String obtenerProveedoresHTML(){
        DatosProveedor datosProveedor= new DatosProveedor();
        ArrayList<DatosProveedor> lista = datosProveedor.obtener();
        String html="";
        
        //faltaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaa
        
        return html;
        
    }
}
