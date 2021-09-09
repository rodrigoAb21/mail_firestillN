/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Negocio;

import Datos.DatosTrabajador;
import Utils.BCrypt;
import java.util.ArrayList;

/**
 *
 * @author asus
 */
public class NegocioTrabajador {
     public NegocioTrabajador() {
        
    }
    
    public Integer registrar(String nombre, String apellido, String carnet, String telefono, String direccion, String tipo, String email){
        DatosTrabajador datosTrabajador= new DatosTrabajador();
        datosTrabajador.setNombre(nombre);
        datosTrabajador.setApellido(apellido);
        datosTrabajador.setCarnet(carnet);
        datosTrabajador.setTelefono(telefono);
        datosTrabajador.setDireccion(direccion);
        datosTrabajador.setTipo(tipo);
        datosTrabajador.setEmail(email);
        String passEncriptada = BCrypt.hashpw(carnet, BCrypt.gensalt(12));
        datosTrabajador.setPassword(passEncriptada);
        return datosTrabajador.insertar();
    }
    
    public void editar(Integer id,String nombre, String apellido, String direccion, String carnet, String telefono,String email,String contrasenia){
        DatosTrabajador datosTrabajador= new DatosTrabajador();
        datosTrabajador=datosTrabajador.obtener(id);
        datosTrabajador.setNombre(nombre);
        datosTrabajador.setApellido(apellido);
        datosTrabajador.setDireccion(direccion);
        datosTrabajador.setCarnet(carnet);
        datosTrabajador.setTelefono(telefono);
        datosTrabajador.setEmail(email);
        String passEncriptada = BCrypt.hashpw(contrasenia, BCrypt.gensalt(12));
        datosTrabajador.setPassword(passEncriptada);
        datosTrabajador.editar();
    }
    
    public void eliminar(Integer id)throws Exception{
        DatosTrabajador datosTrabajador= new DatosTrabajador();
        datosTrabajador=datosTrabajador.obtener(id);
        if(datosTrabajador.getDeleted_at().contentEquals("null")){
            datosTrabajador.eliminar();
        }else{
            throw new Exception("ya fue eliminado");
        }
    }
    
    public DatosTrabajador obtenerTrabajador(int id){
        DatosTrabajador datosTrabajador = new DatosTrabajador();
        datosTrabajador= datosTrabajador.obtener(id);
        return datosTrabajador;
    }
    
    public DatosTrabajador obtenerTrabajador(String correo){
        DatosTrabajador datosTrabajador = new DatosTrabajador();
        datosTrabajador= datosTrabajador.obtenerXcorreo(correo);
        return datosTrabajador;
    }
    
    public ArrayList<DatosTrabajador> obtenerTrabajadores(){
        DatosTrabajador datosTrabajador = new DatosTrabajador();
        ArrayList<DatosTrabajador> lista = datosTrabajador.obtener();
        return lista;
    }
    
    public String obtenerTrabajadorHTML(Integer id){
        DatosTrabajador datosTrabajador = new DatosTrabajador();
        datosTrabajador= obtenerTrabajador(id);
        String html="";
        //COMPLETAARRRRRRRRRRRRRRRRRRRRRRRRRRRRRRRRRRRRRRRR
        return html;
    }
    
    public String obtenerTrabajadoresHTML(){
        DatosTrabajador datosTrabajador = new DatosTrabajador();
        ArrayList<DatosTrabajador> lista= obtenerTrabajadores();
        String html="";
        
        String contenido="";
        for (DatosTrabajador trabajador : lista) {
            Integer id= trabajador.getId();
            String nombre= trabajador.getNombre();
            String apellido= trabajador.getApellido();
            String carnet= trabajador.getCarnet();
            String telefono=trabajador.getTelefono();
            String direccion=trabajador.getDireccion();
            String tipo= trabajador.getTipo();
            String email= trabajador.getEmail();
            
            contenido+="<tr class=\"trDatosTecno\">\n" +
                       "<td class=\"tdcol1Tecno\">"+id+"</td>\n" +
                       "<td >"+nombre+"</td>\n" +
                       "<td >"+apellido+"</td>\n" +       
                       "<td >"+tipo+"</td>\n" +
                       "<td >"+telefono+"</td>\n" +        
                       "<td >"+
                             "<li>"+
                             "<a href=\"mailto:grupo13sc@tecnoweb.org.bo?subject= mostrarTrabajador:"+id+"\">Mostrar </a>\n" +
                             "</li>"+
                             "<a href=\"mailto:grupo13sc@tecnoweb.org.bo?subject= editarTrabajador:"+id+", "+nombre+", "+apellido+", "+direccion+", "+carnet+", "+telefono+", "+email+","+"NUEVA CONTRASEÑA"+"\">Editar </a>\n" +
                             "</li>"+
                             "<li>"+
                             "<a href=\"mailto:grupo13sc@tecnoweb.org.bo?subject= eliminarTrabajador:"+id+"\">Eliminar </a>\n" +
                             "</li>"+
                       "</td>\n" +
                       "</tr>\n";
        }
        
        html="<h2>Trabajadores</h2>"+
             "<a href=\"mailto:grupo13sc@tecnoweb.org.bo?subject= registrarTrabajadorAdmin:NOMBRE, APELLIDO, CARNET, TELEFONO, DIRECCION, EMAIL\">Registrar Administrador</a><br>" +
             "<a href=\"mailto:grupo13sc@tecnoweb.org.bo?subject= registrarTrabajadorVentas:NOMBRE, APELLIDO, CARNET, TELEFONO, DIRECCION, EMAIL\">Registrar empleado de Ventas</a><br>" +
             "<a href=\"mailto:grupo13sc@tecnoweb.org.bo?subject= registrarTrabajadorMantenimiento:NOMBRE, APELLIDO, CARNET, TELEFONO,DIRECCION, EMAIL\">Registrar empleado de Mantenimiento</a><br>" + 
            "<table class=\"tablaTecno\">\n" +
            "  <thead>\n" +
            "    <tr class=\"trCamposTecno\">\n" +
            "      <th >ID</th>\n"+
            "      <th class=\"thcolxTecno\">Nombre</th>\n" +
            "      <th class=\"thcolxTecno\">Apellido</th>\n" +
            "      <th class=\"thcolxTecno\">Tipo</th>\n" +
            "      <th class=\"thcolxTecno\">Telefono</th>\n" +    
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
