/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Negocio;

import Datos.DatosCliente;
import java.util.ArrayList;

/**
 *
 * @author asus
 */
public class NegocioEmpleado {
    public NegocioEmpleado() {
        
    }
    
    public void registrar(String nombre, String apellido, String carnet, String telefono, String direccion, String area, String email){
        DatosEmpleado datosEmpleado = new DatosEmpleado();
        datosEmpleado.setNombre(nombre);
        datosEmpleado.setApellido(apellido);
        datosEmpleado.setCarnet(carnet);
        datosEmpleado.setTelefono(telefono);
        datosEmpleado.setDireccion(direccion);
        datosEmpleado.setArea(area);
        datosEmpleado.setEmail(email);
        datosEmpleado.insertar();
    }
    
    public void editar(Integer id,String nombre, String apellido, String carnet, String telefono, String direccion, String email){
        DatosEmpleado datosEmpleado = new DatosEmpleado();
        datosEmpleado= datosEmpleado.obtener(id);
        datosEmpleado.setNombre(nombre);
        datosEmpleado.setApellido(apellido);
        datosEmpleado.setCarnet(carnet);
        datosEmpleado.setTelefono(telefono);
        datosEmpleado.setDireccion(direccion);
        datosEmpleado.setEmail(email);
        datosEmpleado.editar();
    }
    
    public void cambiarArea(Integer id,String area){
        DatosEmpleado datosEmpleado = new DatosEmpleado();
        datosEmpleado= datosEmpleado.obtener(id);
        datosEmpleado.setArea(area);
        datosEmpleado.editar();
    }
    
    public void eliminar(Integer id){
        DatosEmpleado datosEmpleado = new DatosEmpleado();
        datosEmpleado = datosEmpleado.obtener(id);
        datosEmpleado.eliminar();
    }
    
    public DatosEmpleado obtenerEmpleado(Integer id){
        DatosEmpleado datosEmpleado = new DatosEmpleado();
        datosEmpleado = datosEmpleado.obtener(id);
        return datosEmpleado;
    }
    
    public DatosEmpleado obtenerEmpleado(String correo){
        DatosEmpleado datosEmpleado=new DatosEmpleado();
        return datosEmpleado.buscarPorCorreo(correo);
    }
    
    public ArrayList<DatosEmpleado> obtenerEmpleados(){
        DatosEmpleado datosEmpleado = new DatosEmpleado();
        ArrayList<DatosEmpleado> lista = datosEmpleado.obtener();
        return lista;
    }
    
    public String toHTML(DatosEmpleado empleado){
        String html="<table class=\"tablaTecno\">\n"
                    +"  <thead>\n"
                    +"    <tr class=\"trCamposTecno\">\n"
                    +"      <th >#</th>\n"
                    +"      <th>nombre</th>\n"
                    +"      <th>apellido</th>\n"
                    +"      <th>carnet</th>\n"
                    +"      <th>telefono</th>\n"
                    +"      <th>direccion</th>\n"
                    +"      <th>area</th>\n"
                    +"      <th>email</th>\n"
                    +"    </tr>\n"
                    +"  </thead>\n"
                    +"  <tbody>\n";
       
               html+="   <tr class='trDatosTecno'>"
                    +"      <td class='tdcol1Tecno'>"+empleado.getId()+"</td>"
                    +"      <td>"+empleado.getNombre()+"</td>"
                    +"      <td>"+empleado.getApellido()+"</td>"
                    +"      <td>"+empleado.getCarnet()+"</td>"
                    +"      <td>"+empleado.getTelefono()+"</td>"
                    +"      <td>"+empleado.getDireccion()+"</td>"
                    +"      <td>"+empleado.getArea()+"</td>"   
                    +"      <td>"+empleado.getEmail()+"</td>"
                    +"   </tr>"
                    +"  </tbody>\n"
                    +"</table>\n"; 

        return html;
    }
    
    
}
