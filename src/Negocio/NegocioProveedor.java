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
        DatosProveedor datosProveedor = obtenerProveedor(id);
        String html = "<h2>Ver Proveedor: "+datosProveedor.getId()+"</h2>\n" +
                "<div class=\"tecno_recuadro\">\n" +
                "    <label><b>Nombre</b> </label>\n" +
                "    <p class=\"tecno_input\">"+datosProveedor.getNombre()+"</p>\n" +
                "    <label><b>NIT</b> </label>\n" +
                "    <p class=\"tecno_input\">"+datosProveedor.getNit()+"</p>\n" +
                "    <label><b>Email</b> </label>\n" +
                "    <p class=\"tecno_input\">"+datosProveedor.getEmail()+"</p>\n" +
                "    <label><b>Direccion</b> </label>\n" +
                "    <p class=\"tecno_input\">"+datosProveedor.getDireccion()+"</p>\n" +
                "    <label><b>Telefono</b> </label>\n" +
                "    <p class=\"tecno_input\">"+datosProveedor.getTelefono()+"</p>\n" +
                "    <label><b>Informacion</b> </label>\n" +
                "    <p class=\"tecno_input\">"+datosProveedor.getInformacion()+"</p> <br> \n" +

                "    <h3>Datos Bancarios</h3>\n" +
                "    <label><b>Titular</b> </label>\n" +
                "    <p class=\"tecno_input\">"+datosProveedor.getTitular()+"</p>\n" +
                "    <label><b>Banco</b> </label>\n" +
                "    <p class=\"tecno_input\">"+datosProveedor.getBanco()+"</p>\n" +
                "    <label><b>Sucursal</b> </label>\n" +
                "    <p class=\"tecno_input\">"+datosProveedor.getSucursal()+"</p>\n" +
                "    <label><b>Nro Cuenta</b> </label>\n" +
                "    <p class=\"tecno_input\">"+datosProveedor.getNro_cuenta()+"</p>\n" +
                "    <label><b>Moneda</b> </label>\n" +
                "    <p class=\"tecno_input\">"+datosProveedor.getMoneda()+"</p>\n" +
                "    <label><b>Tipo Identificacion</b> </label>\n" +
                "    <p class=\"tecno_input\">"+datosProveedor.getTipo_identificacion()+"</p>\n" +
                "    <label><b>Nro Identificaion</b> </label>\n" +
                "    <p class=\"tecno_input\">"+datosProveedor.getNro_identificacion()+"</p>\n" +
                "</div>\n";

        
        return html;
        
    }
    
    public String obtenerProveedoresHTML(){
        DatosProveedor datosProveedor = new DatosProveedor();
        ArrayList<DatosProveedor> lista= datosProveedor.obtener();
        String html="";
        
        String contenido="";
        for (DatosProveedor proveedor : lista) {
            Integer id= proveedor.getId();
            String nombre= proveedor.getNombre();
            String nit= proveedor.getNit();
            String email= proveedor.getEmail();
            String direccion=proveedor.getDireccion();
            String telefono=proveedor.getTelefono();
            String informacion=proveedor.getInformacion();
            String titular=proveedor.getTitular();
            String banco= proveedor.getBanco();
            String sucursal= proveedor.getSucursal();
            String nro_cuenta= proveedor.getNro_cuenta();
            String moneda= proveedor.getMoneda();
            String tipo_identificacion= proveedor.getTipo_identificacion();
            String nro_identificacion= proveedor.getNro_identificacion();
            
            contenido+="<tr class=\"trDatosTecno\">\n" +
                       "<td class=\"tdcol1Tecno\">"+id+"</td>\n" +
                       "<td >"+nombre+"</td>\n" +
                       "<td >"+telefono+"</td>\n" +       
                       "<td >"+email+"</td>\n" +      
                       "<td >"+
                             "<li>"+
                             "<a href=\"mailto:grupo13sc@tecnoweb.org.bo?subject= mostrarProveedor:"+id+"\">Mostrar </a>\n" +
                             "</li>"+
                             "<li>"+
                             "<a href=\"mailto:grupo13sc@tecnoweb.org.bo?subject= editarProveedor:"+id+", "+nombre+", "+nit+", "+email+", "+direccion+", "+telefono+", "+informacion+","+titular+", "+banco+", "+sucursal+", "+nro_cuenta+", "+moneda+", "+ tipo_identificacion+", "+nro_identificacion+"\">Editar </a>\n" +
                             "</li>"+
                             "<li>"+
                             "<a href=\"mailto:grupo13sc@tecnoweb.org.bo?subject= eliminarProveedor:"+id+"\">Eliminar </a>\n" +
                             "</li>"+
                       "</td>\n" +
                       "</tr>\n";
        }
        
        html="<h2>Proveedores</h2>"+
             "<a href=\"mailto:grupo13sc@tecnoweb.org.bo?subject= registrarProveedor: NOMBRE, NIT, EMAIL, DIRECCION, TELEFONO, INFORMACION, TITULAR, BANCO, SUCURSAL, NRO_CUENTA, MONEDA, TIPO_IDENTIFICACION, NRO_IDENTIFICACION\">Registrar Proveedor</a><br>" +
            "<table class=\"tablaTecno\">\n" +
            "  <thead>\n" +
            "    <tr class=\"trCamposTecno\">\n" +
            "      <th >ID</th>\n"+
            "      <th class=\"thcolxTecno\">Nombre</th>\n" +
            "      <th class=\"thcolxTecno\">Telefono</th>\n" +
            "      <th class=\"thcolxTecno\">Email</th>\n" +   
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
