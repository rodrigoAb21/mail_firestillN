/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Utils;

import Comunicacion.ClienteSMTP;
import Datos.DatosCliente;
import Datos.DatosProducto;
import Datos.DatosTrabajador;
import Datos.Prueba;
import Negocio.NegocioBajaProducto;
import Negocio.NegocioCategoria;
import Negocio.NegocioCliente;
import Negocio.NegocioConfig;
import Negocio.NegocioContrato;
import Negocio.NegocioDetalleIngresoProducto;
import Negocio.NegocioDetalleNotaVenta;
import Negocio.NegocioEquipo;
import Negocio.NegocioFichaTecnica;
import Negocio.NegocioIngresoProducto;
import Negocio.NegocioMarcaClasificacion;
import Negocio.NegocioNotaVenta;
import Negocio.NegocioProducto;
import Negocio.NegocioProveedor;
import Negocio.NegocioSucursal;
import Negocio.NegocioTipoClasificacion;
import Negocio.NegocioTrabajador;
import java.io.IOException;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import presentacion.templetes.Templates;

/**
 *
 * @author asus
 */
public class ComandoFirestill {
    
    private DatosTrabajador ejecutor;
    private String correo;

    public void ejecutarComando(String email, String comando) {
        NegocioTrabajador negocioTrabajador= new NegocioTrabajador();
        ejecutor = negocioTrabajador.obtenerTrabajador(email);
        correo= ejecutor.getEmail();
        try {
            String s[] = comando.split(":");
            s[0] = s[0].toLowerCase().trim();
            System.out.println(s[0]);
            switch ((s.length == 1 || (s.length == 2 && !s[0].contains("listar") && !s[0].contains("reporte")) ? s[0] : "")) {
                    
                    //AYUDA
                    case "ayuda":
                    ayuda();
                    break;
                
                    // Tipo Clasificacion
                    case "registrartipoclasificacion":
                    registrarTipoClasificacion(s[1]);
                    break;
                    
                    case "editartipoclasificacion":
                    editarTipoClasificacion(s[1]);
                    break;
                    
                    case "eliminarrtipoclasificacion":
                    eliminarTipoClasificacion(s[1]);
                    break;
                    
                    case "mostrartipoclasificacion":
                    mostrarTipoClasificacion(s[1]);
                    break;
                    
                    case "listartiposclasificacion":
                    listarTiposClasificacion();
                    break;
                    
                    
                    //Marca Clasificacion
                    case "registrarmarcaclasificacion":
                    registrarMarcaClasificacion(s[1]);
                    break;
                    
                    case "editarmarcaclasificacion":
                    editarMarcaClasificacion(s[1]);
                    break;
                    
                    case "eliminarrmarcaclasificacion":
                    eliminarMarcaClasificacion(s[1]);
                    break;
                    
                    case "mostrarmarcaclasificacion":
                    mostrarMarcaClasificacion(s[1]);
                    break;
                    
                    case "listarmarcasclasificacion":
                    listarMarcasClasificacion();
                    break;
                    
                    
                    //Categoria
                    case "registrarcategoria":
                    registrarCategoria(s[1]);
                    break;
                    
                    case "editarcategoria":
                    editarCategoria(s[1]);
                    break;
                    
                    case "eliminarcategoria":
                    eliminarCategoria(s[1]);
                    break;
                    
                    case "mostrarcategoria":
                    mostrarCategoria(s[1]);
                    break;
                    
                    case "listarcategorias":
                    listarCategorias();
                    break;
                    
                    //Trabajador
                    case "registrartrabajadoradmin":
                    registrarTrabajador(s[1], "Administrador");
                    break;
                    
                    case "registrartrabajadorventas":
                    registrarTrabajador(s[1], "Venta");
                    break;
                    
                    case "registrartrabajadortecnico":
                    registrarTrabajador(s[1], "Tecnico");
                    break;
                    
                    case "editartrabajador":
                    editarTrabajador(s[1]);
                    break;
                    
                    case "eliminartrabajador":
                    eliminarTrabajador(s[1]);
                    break;
                    
                    case "mostrartrabajador":
                    mostrarTrabajador(s[1]);
                    break;
                    
                    case "listartrabajadores":
                    listarTrabajadores();
                    break;
                    
                    //Proveedor
                    case "registrarproveedor":
                    registrarProveedor(s[1]);
                    break;
                    
                    case "editarproveedor":
                    editarProveedor(s[1]);
                    break;
                    
                    case "eliminarproveedor":
                    eliminarProveedor(s[1]);
                    break;
                    
                    case "mostrarproveedor":
                    mostrarProveedor(s[1]);
                    break;
                    
                    case "listarproveedores":
                    listarProveedores();
                    break;
                    
                    //Cliente
                    case "registrarcliente":
                    registrarCliente(s[1]);
                    break;
                    
                    case "editarcliente":
                    editarCliente(s[1]);
                    break;
                    
                    case "eliminarcliente":
                    eliminarCliente(s[1]);
                    break;
                    
                    case "mostrarcliente":
                    mostrarCliente(s[1]);
                    break;
                    
                    case "listarclientes":
                    listarClientes();
                    break;
                    
                    //PRODUCTO
                    case "registrarproducto":
                    registrarproducto(s[1]);
                    break;
                    
                    case "editarproducto":
                    editarProducto(s[1]);
                    break;
                    
                    case "eliminarproducto":
                    eliminarProducto(s[1]);
                    break;
                    
                    case "mostrarproducto":
                    mostrarProducto(s[1]);
                    break;
                    
                    case "listarproductos":
                    listarProductos();
                    break;
                    
                    //BAJA PRODUCTO
                    case "registrarbajaproducto":
                    registrarbajaproducto(s[1]);
                    break;
                    
                    case "eliminarbajaproducto":
                    eliminarBajaProducto(s[1]);
                    break;
                    
                    case "mostrarbajaproducto":
                    mostrarBajaProducto(s[1]);
                    break;
                    
                    case "listarbajaproductos":
                    listarBajaProductos();
                    break;
                    
                    //CONTRATO
                    case "registrarcontrato":
                    registrarContrato(s[1]);
                    break;
                    
                    case "editarcontrato":
                    editarContrato(s[1]);
                    break;
                    
                    case "finalizaredicioncontrato":
                    finalizarEdicion(s[1]);
                    break;
                    
                    case "eliminarcontrato":
                    eliminarContrato(s[1]);
                    break;
                    
                    case "mostrarcontrato":
                    mostrarContrato(s[1]);
                    break;
                    
                    case "listarcontratos":
                    listarContratos();
                    break;
                    
                    //SUCURSAL
                    case "registrarsucursal":
                    registrarSucursal(s[1]);
                    break;
                    
                    case "editarsucursal":
                    editarSucursal(s[1]);
                    break;
                    
                    case "eliminarsucursal":
                    eliminarSucursal(s[1]);
                    break;
                    
                    case "mostrarsucursal":
                    mostrarSucursal(s[1]);
                    break;
                    
                    case "listarsucursales":
                    listarSucursales();
                    break;
                    
                    //Equipo
                    case "registrarequipo":
                    registrarEquipo(s[1]);
                    break;
                    
                    case "editarequipo":
                    editarEquipo(s[1]);
                    break;
                    
                    case "eliminarequipo":
                    eliminarEquipo(s[1]);
                    break;
                    
                    case "mostrarequipo":
                    mostrarEquipo(s[1]);
                    break;
                    
                    case "listarequipos":
                    listarEquipos();
                    
                    //Ficha tecnica
                    case "registrarfichainspeccion":
                    registrarFichaTecnica(s[1]);
                    break;
                    
                    case "eliminarfichainspeccion":
                    eliminarFichaTecnica(s[1]);
                    break;
                    
                    case "mostrarfichainspeccion":
                    mostrarFichaTecnica(s[1]);
                    break;
                    
                    case "listarfichasinspeccion":
                    listarFichasTecnicas();
                    break;
                    
                    case "listarpartes":
                    listarPartes();    
                    
                    //Ingreso producto
                    case "registraringresoproducto":
                    registrarIngresoProducto(s[1]);
                    break;
                    
                    case "eliminaringresoproducto":
                    eliminarIngresoProducto(s[1]);
                    break;
                    
                    case "mostrarIngresoProducto":
                    mostrarIngresoProducto(s[1]);
                    break;
                    
                    case "listaringresosproductos":
                    listarIngresosProductos();
                    break;
                    
                    //Detalle ingreso productos
                    
                    
                    //Nota venta
                    case "registrarnotaventa":
                    registrarNotaVenta(s[1]);
                    break;
                    
                    case "anularnotaventa":
                    anularNotaVenta(s[1]);    
                    
                    case "mostrarnotaventa":
                    mostrarNotaVenta(s[1]);
                    break;
                    
                    case "listarnotasventa":
                    listarNotasVenta();
                    break;
                    
                    //Detalle nota venta
                    
                    //Servicio
                    
                    //Reportes
                    
                    default:
                        System.out.println("comando no reconocido");
                    break;
                    
            }
        } catch (Exception e) {
            System.out.println("Error de Comando");
        }
    }
    
    public void ayuda(){
        ClienteSMTP mensajero= new ClienteSMTP();
        Templates t= new Templates();
        mensajero.enviarMensaje(correo, "COMANDOS FIRESTILL",t.ayudaHTML());
    }
    //Tipo Clasificacion
    public void registrarTipoClasificacion(String data){
        String[] values = data.split(",");
        try {
            String nombre = getString_NOT_NULL(values[0]);
            NegocioTipoClasificacion negocioTipoClasificacion= new NegocioTipoClasificacion();
            Integer id = negocioTipoClasificacion.registrar(nombre);
            ClienteSMTP mensajero= new ClienteSMTP();
            mensajero.enviarMensaje(correo, "","El tipo de clasificacion fue registrado exitosamente.");
        } catch (Exception e) {
            System.out.println("Error al catch de firestill");
            ClienteSMTP mensajero= new ClienteSMTP();
            mensajero.enviarMensaje(correo, "","Verifique los datos enviados.");
        }
    }
    
    public void editarTipoClasificacion(String data){
        String[] values = data.split(",");
        try {
            Integer id= getInteger_NOT_NULL(values[0]);
            String nombre = getString_NOT_NULL(values[1]);
            NegocioTipoClasificacion negocioTipoClasificacion= new NegocioTipoClasificacion();
            negocioTipoClasificacion.editar(id, nombre);
            ClienteSMTP mensajero= new ClienteSMTP();
            mensajero.enviarMensaje(correo, "","El tipo de clasificacion fue editado exitosamente.");
        } catch (Exception e) {
            System.out.println("Error al catch de firestill");
            ClienteSMTP mensajero= new ClienteSMTP();
            mensajero.enviarMensaje(correo, "","Verifique los datos enviados.");
        }
    }
    
    public void eliminarTipoClasificacion(String data){
        String[] values = data.split(",");
        try {
            Integer id= getInteger_NOT_NULL(values[0]);
            NegocioTipoClasificacion negocioTipoClasificacion= new NegocioTipoClasificacion();
            negocioTipoClasificacion.eliminar(id);
            ClienteSMTP mensajero= new ClienteSMTP();
            mensajero.enviarMensaje(correo, "","El tipo de clasificacion fue eliminado.");
        } catch (Exception e) {
            System.out.println("Error al catch de firestill");
            ClienteSMTP mensajero= new ClienteSMTP();
            mensajero.enviarMensaje(correo, "","Verifique los datos enviados.");
        }
    }
    
    public void mostrarTipoClasificacion(String data){
        String[] values = data.split(",");
        try {
            Integer id= getInteger_NOT_NULL(values[0]);
            NegocioTipoClasificacion negocioTipoClasificacion= new NegocioTipoClasificacion();
            String html=negocioTipoClasificacion.obtenerTipoClasificacionHTML(id);
            Templates t= new Templates();
            ClienteSMTP mensajero= new ClienteSMTP();
            mensajero.enviarMensaje(correo, "",t.generarMostrarHTML(html));
        } catch (Exception e) {
            System.out.println("Error al catch de firestill");
            ClienteSMTP mensajero= new ClienteSMTP();
            mensajero.enviarMensaje(correo, "","Verifique los datos enviados.");
        }
    }
    
    public void listarTiposClasificacion(){
        try {
            NegocioTipoClasificacion negocioTipoClasificacion= new NegocioTipoClasificacion();
            String html=negocioTipoClasificacion.obtenerTiposClasificacionHTML();
            Templates t= new Templates();
            ClienteSMTP mensajero= new ClienteSMTP();
            mensajero.enviarMensaje(correo, "",t.generarHTML(html));
        } catch (Exception e) {
            System.out.println("Error al catch de firestill");
            ClienteSMTP mensajero= new ClienteSMTP();
            mensajero.enviarMensaje(correo, "","Verifique los datos enviados.");
        }
    }
    
    
    // Marca Clasificacion
    public void registrarMarcaClasificacion(String data){
        String[] values = data.split(",");
        try {
            String nombre = getString_NOT_NULL(values[0]);
            NegocioMarcaClasificacion negocioMarcaClasificacion= new NegocioMarcaClasificacion();
            Integer id = negocioMarcaClasificacion.registrar(nombre);
            ClienteSMTP mensajero= new ClienteSMTP();
            mensajero.enviarMensaje(correo, "","La marca de clasificacion fue registrada exitosamente.");
        } catch (Exception e) {
            System.out.println("Error al catch de firestill");
            ClienteSMTP mensajero= new ClienteSMTP();
            mensajero.enviarMensaje(correo, "","Verifique los datos enviados.");
        }
    }
    
    public void editarMarcaClasificacion(String data){
        String[] values = data.split(",");
        try {
            Integer id= getInteger_NOT_NULL(values[0]);
            String nombre = getString_NOT_NULL(values[1]);
            NegocioMarcaClasificacion negocioMarcaClasificacion= new NegocioMarcaClasificacion();
            negocioMarcaClasificacion.editar(id, nombre);
            ClienteSMTP mensajero= new ClienteSMTP();
            mensajero.enviarMensaje(correo, "","La marca de clasificacion fue editada exitosamente.");
        } catch (Exception e) {
            System.out.println("Error al catch de firestill");
            ClienteSMTP mensajero= new ClienteSMTP();
            mensajero.enviarMensaje(correo, "","Verifique los datos enviados.");
        }
    }
    
    public void eliminarMarcaClasificacion(String data){
        String[] values = data.split(",");
        try {
            Integer id= getInteger_NOT_NULL(values[0]);
            NegocioMarcaClasificacion negocioMarcaClasificacion= new NegocioMarcaClasificacion();
            negocioMarcaClasificacion.eliminar(id);
            ClienteSMTP mensajero= new ClienteSMTP();
            mensajero.enviarMensaje(correo, "","La marca de clasificacion fue eliminado.");
        } catch (Exception e) {
            System.out.println("Error al catch de firestill");
            ClienteSMTP mensajero= new ClienteSMTP();
            mensajero.enviarMensaje(correo, "","Verifique los datos enviados.");
        }
    }
    
    public void mostrarMarcaClasificacion(String data){
        String[] values = data.split(",");
        try {
            Integer id= getInteger_NOT_NULL(values[0]);
            NegocioMarcaClasificacion negocioMarcaClasificacion= new NegocioMarcaClasificacion();
            String html=negocioMarcaClasificacion.obtenerMarcaClasificacionHTML(id);
            Templates t= new Templates();
            ClienteSMTP mensajero= new ClienteSMTP();
            mensajero.enviarMensaje(correo, "",t.generarMostrarHTML(html));
        } catch (Exception e) {
            System.out.println("Error al catch de firestill");
            ClienteSMTP mensajero= new ClienteSMTP();
            mensajero.enviarMensaje(correo, "","Verifique los datos enviados.");
        }
    }
    
    public void listarMarcasClasificacion(){
        try {
            NegocioMarcaClasificacion negocioMarcaClasificacion= new NegocioMarcaClasificacion();
            String html=negocioMarcaClasificacion.obtenerMarcasClasificacionHTML();
            Templates t= new Templates();
            ClienteSMTP mensajero= new ClienteSMTP();
            mensajero.enviarMensaje(correo, "",t.generarHTML(html));
        } catch (Exception e) {
            System.out.println("Error al catch de firestill");
            ClienteSMTP mensajero= new ClienteSMTP();
            mensajero.enviarMensaje(correo, "","Verifique los datos enviados.");
        }
    }
    
    // Categoria
    public void registrarCategoria(String data){
        String[] values = data.split(",");
        try {
            String nombre = getString_NOT_NULL(values[0]);
            NegocioCategoria negocioCategoria= new NegocioCategoria();
            Integer id = negocioCategoria.registrar(nombre);
            ClienteSMTP mensajero= new ClienteSMTP();
            mensajero.enviarMensaje(correo, "","La categoria fue registrada exitosamente.");
        } catch (Exception e) {
            System.out.println("Error al catch de firestill");
            ClienteSMTP mensajero= new ClienteSMTP();
            mensajero.enviarMensaje(correo, "","Verifique los datos enviados.");
        }
    }
    
    public void editarCategoria(String data){
        String[] values = data.split(",");
        try {
            Integer id= getInteger_NOT_NULL(values[0]);
            String nombre = getString_NOT_NULL(values[1]);
            NegocioCategoria negocioCategoria= new NegocioCategoria();
            negocioCategoria.editar(id, nombre);
            ClienteSMTP mensajero= new ClienteSMTP();
            mensajero.enviarMensaje(correo, "","La categoria fue editada exitosamente.");
        } catch (Exception e) {
            System.out.println("Error al catch de firestill");
            ClienteSMTP mensajero= new ClienteSMTP();
            mensajero.enviarMensaje(correo, "","Verifique los datos enviados.");
        }
    }
    
    public void eliminarCategoria(String data){
        String[] values = data.split(",");
        try {
            Integer id= getInteger_NOT_NULL(values[0]);
            NegocioCategoria negocioCategoria= new NegocioCategoria();
            negocioCategoria.eliminar(id);
            ClienteSMTP mensajero= new ClienteSMTP();
            mensajero.enviarMensaje(correo, "","La categoria fue eliminado.");
        } catch (Exception e) {
            System.out.println("Error al catch de firestill");
            ClienteSMTP mensajero= new ClienteSMTP();
            mensajero.enviarMensaje(correo, "","Verifique los datos enviados.");
        }
    }
    
    public void mostrarCategoria(String data){
        String[] values = data.split(",");
        try {
            Integer id= getInteger_NOT_NULL(values[0]);
            NegocioCategoria negociocategoria= new NegocioCategoria();
            String html=negociocategoria.obtenerCategoriaHTML(id);
            Templates t= new Templates();
            ClienteSMTP mensajero= new ClienteSMTP();
            mensajero.enviarMensaje(correo, "",t.generarMostrarHTML(html));
        } catch (Exception e) {
            System.out.println("Error al catch de firestill");
            ClienteSMTP mensajero= new ClienteSMTP();
            mensajero.enviarMensaje(correo, "","Verifique los datos enviados.");
        }
    }
    
    public void listarCategorias(){
        try {
            NegocioCategoria negocioCategoria= new NegocioCategoria();
            String html=negocioCategoria.obtenerCategoriasHTML();
            Templates t= new Templates();
            ClienteSMTP mensajero= new ClienteSMTP();
            mensajero.enviarMensaje(correo, "",t.generarHTML(html));
        } catch (Exception e) {
            System.out.println("Error al catch de firestill");
            ClienteSMTP mensajero= new ClienteSMTP();
            mensajero.enviarMensaje(correo, "","Verifique los datos enviados.");
        }
    }
    
    
    // Trabajador
    public void registrarTrabajador(String data,String tipo){
        String[] values = data.split(",");
        try {
            String nombre = getString_NOT_NULL(values[0]);
            System.out.println("nombre: "+nombre);
            String apellido = getString_NOT_NULL(values[1]);
            System.out.println("apellido: "+apellido);
            String carnet = getCarnet_NOT_NULL(values[2]);
            System.out.println("carnet: "+carnet);
            String telefono = getNroTelefono(values[3]);
            System.out.println("telefono: "+telefono);
            String direccion = getString(values[4]);
            System.out.println("direccion: "+direccion);
            String email = getString_NOT_NULL(values[5]);  
            System.out.println("email: "+email);
            
            NegocioTrabajador negocioTrabajador= new NegocioTrabajador();
            Integer id = negocioTrabajador.registrar(nombre, apellido, carnet, telefono, direccion, tipo, email);
            NegocioConfig negocioConfig= new NegocioConfig();
            negocioConfig.registrar(id);
            ClienteSMTP mensajero= new ClienteSMTP();
            mensajero.enviarMensaje(correo, "","Trabajador registrado exitosamente.");
        } catch (Exception e) {
            System.out.println("Error al catch de firestill");
            ClienteSMTP mensajero= new ClienteSMTP();
            mensajero.enviarMensaje(correo, "","Verifique los datos enviados.");
        }
    }
    
    public void editarTrabajador(String data){
        String[] values = data.split(",");
        try {
            Integer id= getInteger_NOT_NULL(values[0]);
            String nombre = getString_NOT_NULL(values[0]);
            String apellido = getString_NOT_NULL(values[1]);
            String carnet = getCarnet_NOT_NULL(values[2]);
            String telefono = getNroTelefono(values[3]);
            String direccion = getString(values[4]);
            String email = getString_NOT_NULL(values[5]);  
            String contrasenia = getString_NOT_NULL(values[6]);
            NegocioTrabajador negocioTrabajador= new NegocioTrabajador();
            negocioTrabajador.editar(id, nombre, apellido, direccion, carnet, telefono, email, contrasenia);
            ClienteSMTP mensajero= new ClienteSMTP();
            mensajero.enviarMensaje(correo, "","El trabajador fue editado exitosamente.");
        } catch (Exception e) {
            System.out.println("Error al catch de firestill");
            ClienteSMTP mensajero= new ClienteSMTP();
            mensajero.enviarMensaje(correo, "","Verifique los datos enviados.");
        }
    }
    
    public void cambiarContrasenia(){
        
    }
    
    public void cambiarArea(){
        
    }
    
    public void eliminarTrabajador(String data){
        String[] values = data.split(",");
        try {
            Integer id= getInteger_NOT_NULL(values[0]);
            NegocioTrabajador negocioTrabajador= new NegocioTrabajador();
            negocioTrabajador.eliminar(id);
            ClienteSMTP mensajero= new ClienteSMTP();
            mensajero.enviarMensaje(correo, "","El empleado fue eliminado.");
        } catch (Exception e) {
            System.out.println("Error al catch de firestill");
            ClienteSMTP mensajero= new ClienteSMTP();
            mensajero.enviarMensaje(correo, "","Verifique los datos enviados.");
        }
    }
    
    
    public void mostrarTrabajador(String data){
        String[] values = data.split(",");
        try {
            Integer id= getInteger_NOT_NULL(values[0]);
            NegocioTrabajador negocioTrabajador= new NegocioTrabajador();
            String html=negocioTrabajador.obtenerTrabajadorHTML(id);
            Templates t= new Templates();
            ClienteSMTP mensajero= new ClienteSMTP();
            mensajero.enviarMensaje(correo, "",t.generarMostrarHTML(html));
        } catch (Exception e) {
            System.out.println("Error al catch de firestill");
            ClienteSMTP mensajero= new ClienteSMTP();
            mensajero.enviarMensaje(correo, "mostrar_trabajador-error","Verifique los datos enviados.");
        }
    }
    
    public void listarTrabajadores(){
        try {
            NegocioTrabajador negocioTrabajador= new NegocioTrabajador();
            String html=negocioTrabajador.obtenerTrabajadoresHTML();
            Templates t= new Templates();
            ClienteSMTP mensajero= new ClienteSMTP();
            mensajero.enviarMensaje(correo, "",t.generarHTML(html));
        } catch (Exception e) {
            System.out.println("Error al catch de firestill");
            ClienteSMTP mensajero= new ClienteSMTP();
            mensajero.enviarMensaje(correo, "","Verifique los datos enviados.");
        }
    }
    
    
    
    //Proveedor
    public void registrarProveedor(String data){
        String[] values = data.split(",");
        try {
            String nombre = getString_NOT_NULL(values[0]);
            String nit = getString(values[1]);
            String email = getString(values[2]);
            String direccion = getString_NOT_NULL(values[3]);
            String telefono = getNroTelefono_NOT_NULL(values[4]);
            String informacion = getString(values[5]);
            String titular = getString(values[6]);
            String banco = getString(values[7]);
            String sucursal = getString(values[8]);
            String nro_cuenta = getString(values[9]);
            String moneda = getString(values[10]);
            String tipo_identificacion = getString(values[11]);
            String nro_identificacion = getString(values[12]);
            NegocioProveedor negocioProveedor= new NegocioProveedor();
            Integer id = negocioProveedor.registrar(nombre, nit, email, direccion, telefono, informacion, titular, banco, sucursal, nro_cuenta, moneda, tipo_identificacion, nro_identificacion);
            ClienteSMTP mensajero= new ClienteSMTP();
            mensajero.enviarMensaje(correo, "","El proveedor fue registrado exitosamente.");
        } catch (Exception e) {
            System.out.println("Error al catch de firestill");
            ClienteSMTP mensajero= new ClienteSMTP();
            mensajero.enviarMensaje(correo, "","Verifique los datos enviados.");
        }
    }
    
    public void editarProveedor(String data){
        String[] values = data.split(",");
        try {
            Integer id= getInteger_NOT_NULL(values[0]);
            String nombre = getString_NOT_NULL(values[1]);
            String nit = getString(values[2]);
            String email = getString(values[3]);
            String direccion = getString_NOT_NULL(values[4]);
            String telefono = getNroTelefono_NOT_NULL(values[5]);
            String informacion = getString(values[6]);
            String titular = getString(values[7]);
            String banco = getString(values[8]);
            String sucursal = getString(values[9]);
            String nro_cuenta = getString(values[10]);
            String moneda = getString(values[11]);
            String tipo_identificacion = getString(values[12]);
            String nro_identificacion = getString(values[13]);
            NegocioProveedor negocioProveedor= new NegocioProveedor();
            negocioProveedor.editar(id, nombre, nit, email, direccion, telefono, informacion, titular, banco, sucursal, nro_cuenta, moneda, tipo_identificacion, nro_identificacion);
            ClienteSMTP mensajero= new ClienteSMTP();
            mensajero.enviarMensaje(correo, "","El proveedor fue editado exitosamente.");
        } catch (Exception e) {
            System.out.println("Error al catch de firestill");
            ClienteSMTP mensajero= new ClienteSMTP();
            mensajero.enviarMensaje(correo, "","Verifique los datos enviados.");
        }
    }
    
    public void eliminarProveedor(String data){
        String[] values = data.split(",");
        try {
            Integer id= getInteger_NOT_NULL(values[0]);
            NegocioProveedor negocioProveedor= new NegocioProveedor();
            negocioProveedor.eliminar(id);
            ClienteSMTP mensajero= new ClienteSMTP();
            mensajero.enviarMensaje(correo, "","El proveedor fue eliminado.");
        } catch (Exception e) {
            System.out.println("Error al catch de firestill");
            ClienteSMTP mensajero= new ClienteSMTP();
            mensajero.enviarMensaje(correo, "","Verifique los datos enviados.");
        }
    }
    
    public void mostrarProveedor(String data){
        String[] values = data.split(",");
        try {
            Integer id= getInteger_NOT_NULL(values[0]);
            NegocioProveedor negocioProveedor= new NegocioProveedor();
            String html=negocioProveedor.obtenerProveedorHTML(id);
            Templates t= new Templates();
            ClienteSMTP mensajero= new ClienteSMTP();
            mensajero.enviarMensaje(correo, "",t.generarMostrarHTML(html));
        } catch (Exception e) {
            System.out.println("Error al catch de firestill");
            ClienteSMTP mensajero= new ClienteSMTP();
            mensajero.enviarMensaje(correo, "","Verifique los datos enviados.");
        }
    }
    
    public void listarProveedores(){
        try {
            NegocioProveedor negocioProveedor= new NegocioProveedor();
            String html=negocioProveedor.obtenerProveedoresHTML();
            Templates t= new Templates();
            ClienteSMTP mensajero= new ClienteSMTP();
            mensajero.enviarMensaje(correo, "",t.generarHTML(html));
        } catch (Exception e) {
            System.out.println("Error al catch de firestill");
            ClienteSMTP mensajero= new ClienteSMTP();
            mensajero.enviarMensaje(correo, "","Verifique los datos enviados.");
        }
    }
    
    
    //Cliente
    public void registrarCliente(String data){
        String[] values = data.split(",");
        try {
            String nombre_empresa = getString_NOT_NULL(values[0]);
            String nit = getString(values[1]);
            String telefono_empresa = getNroTelefono(values[2]);
            String email = getString(values[3]);
            String direccion = getString(values[4]);
            String nombre_encargado = getString(values[5]);
            String cargo_encargado = getString(values[6]);
            String email_encargado = getString(values[7]);
            String telefono_encargado = getNroTelefono(values[8]);
            NegocioCliente negocioCliente= new NegocioCliente();
            Integer id = negocioCliente.registrar(nombre_empresa, nit, telefono_empresa,email,direccion,nombre_encargado,cargo_encargado,email_encargado,telefono_encargado);
            ClienteSMTP mensajero= new ClienteSMTP();
            mensajero.enviarMensaje(correo, "","El cliente fue registrado exitosamente.");
        } catch (Exception e) {
            System.out.println("Error al catch de firestill");
            ClienteSMTP mensajero= new ClienteSMTP();
            mensajero.enviarMensaje(correo, "","Verifique los datos enviados.");
        }
    }
    
    public void editarCliente(String data){
        String[] values = data.split(",");
        try {
            Integer id= getInteger_NOT_NULL(values[0]);
            String nombre_empresa = getString_NOT_NULL(values[1]);
            String nit = getString(values[2]);
            String telefono_empresa = getNroTelefono(values[3]);
            String email = getString(values[4]);
            String direccion = getString(values[5]);
            String nombre_encargado = getString(values[6]);
            String cargo_encargado = getString(values[7]);
            String email_encargado = getString(values[8]);
            String telefono_encargado = getNroTelefono(values[9]);
            NegocioCliente negocioCliente= new NegocioCliente();
            negocioCliente.editar(id,nombre_empresa, nit, telefono_empresa,email,direccion,nombre_encargado,cargo_encargado,email_encargado,telefono_encargado);
            ClienteSMTP mensajero= new ClienteSMTP();
            mensajero.enviarMensaje(correo, "","El cliente fue editado exitosamente.");
        } catch (Exception e) {
            System.out.println("Error al catch de firestill");
            ClienteSMTP mensajero= new ClienteSMTP();
            mensajero.enviarMensaje(correo, "","Verifique los datos enviados.");
        }
    }
    
    public void eliminarCliente(String data){
        String[] values = data.split(",");
        try {
            Integer id= getInteger_NOT_NULL(values[0]);
            NegocioCliente negocioCliente= new NegocioCliente();
            negocioCliente.eliminar(id);
            ClienteSMTP mensajero= new ClienteSMTP();
            mensajero.enviarMensaje(correo, "","El cliente fue eliminado.");
        } catch (Exception e) {
            System.out.println("Error al catch de firestill");
            ClienteSMTP mensajero= new ClienteSMTP();
            mensajero.enviarMensaje(correo, "","Verifique los datos enviados.");
        }
    }
    
    public void mostrarCliente(String data){
        String[] values = data.split(",");
        try {
            Integer id= getInteger_NOT_NULL(values[0]);
            NegocioCliente negocioCliente= new NegocioCliente();
            String html=negocioCliente.obtenerClienteHTML(id);
            Templates t= new Templates();
            ClienteSMTP mensajero= new ClienteSMTP();
            mensajero.enviarMensaje(correo, "",t.generarMostrarHTML(html));
        } catch (Exception e) {
            System.out.println("Error al catch de firestill");
            ClienteSMTP mensajero= new ClienteSMTP();
            mensajero.enviarMensaje(correo, "","Verifique los datos enviados.");
        }
    }
    
    public void listarClientes(){
        try {
            NegocioCliente negocioCliente= new NegocioCliente();
            String html=negocioCliente.obtenerClientesHTML();
            Templates t= new Templates();
            ClienteSMTP mensajero= new ClienteSMTP();
            mensajero.enviarMensaje(correo, "",t.generarHTML(html));
        } catch (Exception e) {
            System.out.println("Error al catch de firestill");
            ClienteSMTP mensajero= new ClienteSMTP();
            mensajero.enviarMensaje(correo, "","Verifique los datos enviados.");
        }
    }
 
    // 7 PRODUCTO

    private void registrarproducto(String data) {
        String[] values = data.split(",");
        try {
            Integer categoria_id = getInteger_NOT_NULL(values[0]);
            String nombre = getString_NOT_NULL(values[1]);
            String descripcion = getString(values[2]);
            Float precio = getFloat_NOT_NULL(values[3]);
            NegocioProducto negocioProducto= new NegocioProducto();
            Integer id = negocioProducto.registrar(categoria_id, nombre, descripcion, precio);
            ClienteSMTP mensajero= new ClienteSMTP();
            mensajero.enviarMensaje(correo, "","El producto fue registrado exitosamente.");
        } catch (Exception e) {
            System.out.println("Error al catch de firestill");
            ClienteSMTP mensajero= new ClienteSMTP();
            mensajero.enviarMensaje(correo, "","Verifique los datos enviados.");
        }
    }

    private void editarProducto(String data) {
        String[] values = data.split(",");
        try {
            Integer id= getInteger_NOT_NULL(values[0]);
            Integer categoria_id = getInteger_NOT_NULL(values[1]);
            String nombre = getString_NOT_NULL(values[2]);
            Float precio = getFloat_NOT_NULL(values[3]);
            String descripcion = getString(values[4]);
            NegocioProducto negocioProducto= new NegocioProducto();
            negocioProducto.editar2(id,categoria_id,nombre, precio,descripcion);
            ClienteSMTP mensajero= new ClienteSMTP();
            mensajero.enviarMensaje(correo, "","El producto fue editado exitosamente.");
        } catch (Exception e) {
            System.out.println("Error al catch de firestill");
            ClienteSMTP mensajero= new ClienteSMTP();
            mensajero.enviarMensaje(correo, "","Verifique los datos enviados.");
        }
    }

    private void eliminarProducto(String data) {
        String[] values = data.split(",");
        try {
            Integer id= getInteger_NOT_NULL(values[0]);
            NegocioProducto negocioProducto= new NegocioProducto();
            negocioProducto.eliminar(id);
            ClienteSMTP mensajero= new ClienteSMTP();
            mensajero.enviarMensaje(correo, "","El producto fue eliminado.");
        } catch (Exception e) {
            System.out.println("Error al catch de firestill");
            ClienteSMTP mensajero= new ClienteSMTP();
            mensajero.enviarMensaje(correo, "","Verifique los datos enviados.");
        }
    }    

    private void mostrarProducto(String data) {
        String[] values = data.split(",");
        try {
            Integer id= getInteger_NOT_NULL(values[0]);
            NegocioProducto negocioProducto= new NegocioProducto();
            String html=negocioProducto.obtenerProductoHTML(id);
            Templates t= new Templates();
            ClienteSMTP mensajero= new ClienteSMTP();
            mensajero.enviarMensaje(correo, "",t.generarMostrarHTML(html));
        } catch (Exception e) {
            System.out.println("Error al catch de firestill");
            ClienteSMTP mensajero= new ClienteSMTP();
            mensajero.enviarMensaje(correo, "","Verifique los datos enviados.");
        }
    }

    private void listarProductos() {
        try {
            NegocioProducto negocioProducto= new NegocioProducto();
            String html=negocioProducto.obtenerProductosHTML();
            Templates t= new Templates();
            ClienteSMTP mensajero= new ClienteSMTP();
            mensajero.enviarMensaje(correo, "",t.generarHTML(html));
        } catch (Exception e) {
            System.out.println("Error al catch de firestill");
            ClienteSMTP mensajero= new ClienteSMTP();
            mensajero.enviarMensaje(correo, "","Verifique los datos enviados.");
        }
    }

    
    
    // 8 Baja Producto
    
    private void registrarbajaproducto(String data) {
        String[] values = data.split(",");
        try {
            Integer producto_id = getInteger_NOT_NULL(values[0]);
            Integer cantidad = getInteger_NOT_NULL(values[1]);
            String motivo = getString_NOT_NULL(values[2]);
            NegocioBajaProducto negocioBajaProducto= new NegocioBajaProducto();
            Integer id = negocioBajaProducto.registrar(producto_id,cantidad,motivo);
            ClienteSMTP mensajero= new ClienteSMTP();
            mensajero.enviarMensaje(correo, "","La baja de producto fue registrada exitosamente.");
        } catch (Exception e) {
            System.out.println("Error al catch de firestill");
            ClienteSMTP mensajero= new ClienteSMTP();
            mensajero.enviarMensaje(correo, "","Verifique los datos enviados.");
        }
    }

    private void eliminarBajaProducto(String data) {
        String[] values = data.split(",");
        try {
            Integer id= getInteger_NOT_NULL(values[0]);
            NegocioBajaProducto negocioBajaProducto= new NegocioBajaProducto();
            negocioBajaProducto.eliminar(id);
            ClienteSMTP mensajero= new ClienteSMTP();
            mensajero.enviarMensaje(correo, "","La baja de producto fue eliminada.");
        } catch (Exception e) {
            System.out.println("Error al catch de firestill");
            ClienteSMTP mensajero= new ClienteSMTP();
            mensajero.enviarMensaje(correo, "","Verifique los datos enviados.");
        }
    }    

    private void mostrarBajaProducto(String data) {
        String[] values = data.split(",");
        try {
            Integer id= getInteger_NOT_NULL(values[0]);
            NegocioBajaProducto negocioBajaProducto= new NegocioBajaProducto();
            String html=negocioBajaProducto.obtenerBajaProductoHTML(id);
            Templates t= new Templates();
            ClienteSMTP mensajero= new ClienteSMTP();
            mensajero.enviarMensaje(correo, "",t.generarMostrarHTML(html));
        } catch (Exception e) {
            System.out.println("Error al catch de firestill");
            ClienteSMTP mensajero= new ClienteSMTP();
            mensajero.enviarMensaje(correo, "","Verifique los datos enviados.");
        }
    }

    private void listarBajaProductos() {
        try {
            NegocioBajaProducto negocioBajaProducto= new NegocioBajaProducto();
            String html=negocioBajaProducto.obtenerBajaProductosHTML();
            Templates t= new Templates();
            ClienteSMTP mensajero= new ClienteSMTP();
            mensajero.enviarMensaje(correo, "",t.generarHTML(html));
        } catch (Exception e) {
            System.out.println("Error al catch de firestill");
            ClienteSMTP mensajero= new ClienteSMTP();
            mensajero.enviarMensaje(correo, "","Verifique los datos enviados.");
        }
    }

    
    // 9 Contrato
    
    private void registrarContrato(String data) {
        String[] values = data.split(",");
        try {
            Integer cliente_id = getInteger_NOT_NULL(values[0]);
            Date fecha_inicio = getDate_NOT_NULL(values[1]);
            Date fecha_fin = getDate_NOT_NULL(values[2]);
            Integer periodo = getInteger_NOT_NULL(values[3]);
            NegocioContrato negocioContrato= new NegocioContrato();
            Integer id = negocioContrato.registrar(cliente_id, ejecutor.getId(), fecha_inicio, fecha_fin, periodo);
            ClienteSMTP mensajero= new ClienteSMTP();
            mensajero.enviarMensaje(correo, "","El contrato fue registrado exitosamente.");
        } catch (Exception e) {
            System.out.println("Error al catch de firestill");
            ClienteSMTP mensajero= new ClienteSMTP();
            mensajero.enviarMensaje(correo, "","Verifique los datos enviados.");
        }
    }

    private void editarContrato(String data) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    private void finalizarEdicion(String data){
        String[] values = data.split(",");
        try {
            Integer id= getInteger_NOT_NULL(values[0]);
            NegocioContrato negocioContrato= new NegocioContrato();
            negocioContrato.finalizarEdicion(id);
            ClienteSMTP mensajero= new ClienteSMTP();
            mensajero.enviarMensaje(correo, "","El periodo de edicion del contrato fue finalizado.");
        } catch (Exception e) {
            System.out.println("Error al catch de firestill");
            ClienteSMTP mensajero= new ClienteSMTP();
            mensajero.enviarMensaje(correo, "","Verifique los datos enviados.");
        }
    }
    
    private void eliminarContrato(String data) {
        String[] values = data.split(",");
        try {
            Integer id= getInteger_NOT_NULL(values[0]);
            NegocioContrato negocioContrato= new NegocioContrato();
            negocioContrato.eliminar(id);
            ClienteSMTP mensajero= new ClienteSMTP();
            mensajero.enviarMensaje(correo, "","El contrato fue eliminado.");
        } catch (Exception e) {
            System.out.println("Error al catch de firestill");
            ClienteSMTP mensajero= new ClienteSMTP();
            mensajero.enviarMensaje(correo, "","Verifique los datos enviados.");
        }
    }    

    private void mostrarContrato(String data) {
        String[] values = data.split(",");
        try {
            Integer id= getInteger_NOT_NULL(values[0]);
            NegocioContrato negocioContrato= new NegocioContrato();
            String html=negocioContrato.obtenerContratoHTML(id);
            Templates t= new Templates();
            ClienteSMTP mensajero= new ClienteSMTP();
            mensajero.enviarMensaje(correo, "",t.generarMostrarHTML(html));
        } catch (Exception e) {
            System.out.println("Error al catch de firestill");
            ClienteSMTP mensajero= new ClienteSMTP();
            mensajero.enviarMensaje(correo, "","Verifique los datos enviados.");
        }
    }
    
    private void listarContratos() {
        try {
            NegocioContrato negocioContrato= new NegocioContrato();
            String html=negocioContrato.obtenerContratosHTML();
            Templates t= new Templates();
            ClienteSMTP mensajero= new ClienteSMTP();
            mensajero.enviarMensaje(correo, "",t.generarHTML(html));
        } catch (Exception e) {
            System.out.println("Error al catch de firestill");
            ClienteSMTP mensajero= new ClienteSMTP();
            mensajero.enviarMensaje(correo, "","Verifique los datos enviados.");
        }
    }

    
    // 10 Sucursal
    
    private void registrarSucursal(String data) {
        String[] values = data.split(",");
        try {
            Integer contrato_id = getInteger_NOT_NULL(values[0]);
            String nombre = getString_NOT_NULL(values[1]);
            String direccion = getString_NOT_NULL(values[2]);
            NegocioSucursal negocioSucursal= new NegocioSucursal();
            Integer id = negocioSucursal.registrar(contrato_id,nombre, direccion );
            ClienteSMTP mensajero= new ClienteSMTP();
            mensajero.enviarMensaje(correo, "","La sucursal fue registrada exitosamente.");
        } catch (Exception e) {
            System.out.println("Error al catch de firestill");
            ClienteSMTP mensajero= new ClienteSMTP();
            mensajero.enviarMensaje(correo, "","Verifique los datos enviados.");
        }
    }

    private void editarSucursal(String data) {
        String[] values = data.split(",");
        try {
            Integer id= getInteger_NOT_NULL(values[0]);
            Integer contrato_id= getInteger_NOT_NULL(values[1]);
            String nombre = getString_NOT_NULL(values[2]);
            String direccion = getString_NOT_NULL(values[3]);
            NegocioSucursal negocioSucursal= new NegocioSucursal();
            negocioSucursal.editar(id,contrato_id,nombre,direccion);
            ClienteSMTP mensajero= new ClienteSMTP();
            mensajero.enviarMensaje(correo, "","La sucursal fue editada exitosamente.");
        } catch (Exception e) {
            System.out.println("Error al catch de firestill");
            ClienteSMTP mensajero= new ClienteSMTP();
            mensajero.enviarMensaje(correo, "","Verifique los datos enviados.");
        }
    }

    private void eliminarSucursal(String data) {
        String[] values = data.split(",");
        try {
            Integer id= getInteger_NOT_NULL(values[0]);
            NegocioSucursal negocioSucursal= new NegocioSucursal();
            negocioSucursal.eliminar(id);
            ClienteSMTP mensajero= new ClienteSMTP();
            mensajero.enviarMensaje(correo, "","La sucursal fue eliminada.");
        } catch (Exception e) {
            System.out.println("Error al catch de firestill");
            ClienteSMTP mensajero= new ClienteSMTP();
            mensajero.enviarMensaje(correo, "","Verifique los datos enviados.");
        }
    } 

    private void mostrarSucursal(String data) {
        String[] values = data.split(",");
        try {
            Integer id= getInteger_NOT_NULL(values[0]);
            NegocioSucursal negocioSucursal= new NegocioSucursal();
            String html=negocioSucursal.obtenerSucursalHTML(id);
            Templates t= new Templates();
            ClienteSMTP mensajero= new ClienteSMTP();
            mensajero.enviarMensaje(correo, "",t.generarMostrarHTML(html));
        } catch (Exception e) {
            System.out.println("Error al catch de firestill");
            ClienteSMTP mensajero= new ClienteSMTP();
            mensajero.enviarMensaje(correo, "","Verifique los datos enviados.");
        }
    }

    private void listarSucursales() {
        try {
            NegocioSucursal negocioSucursal= new NegocioSucursal();
            String html=negocioSucursal.obtenerSucursalesHTML();
            Templates t= new Templates();
            ClienteSMTP mensajero= new ClienteSMTP();
            mensajero.enviarMensaje(correo, "",t.generarHTML(html));
        } catch (Exception e) {
            System.out.println("Error al catch de firestill");
            ClienteSMTP mensajero= new ClienteSMTP();
            mensajero.enviarMensaje(correo, "","Verifique los datos enviados.");
        }
    }
    
    // 11 Equipo

    private void registrarEquipo(String data) {
        String[] values = data.split(",");
        try {
            Integer sucursal_id = getInteger_NOT_NULL(values[0]);
            Integer tipo_clasificacion_id = getInteger_NOT_NULL(values[1]);
            Integer marca_clasificacion_id = getInteger_NOT_NULL(values[2]);
            String nro_serie = getString_NOT_NULL(values[3]);
            String descripcion = getString(values[4]);
            String unidad_medida = getString(values[5]);
            Integer ano_fabricacion= getInteger_NOT_NULL(values[6]);
            Float capacidad= getFloat_NOT_NULL(values[7]);
            String ubicacion= getString_NOT_NULL(values[8]);
            NegocioEquipo negocioEquipo= new NegocioEquipo();
            Integer id = negocioEquipo.registrar(sucursal_id, tipo_clasificacion_id, marca_clasificacion_id, nro_serie, descripcion, unidad_medida, ano_fabricacion, capacidad, ubicacion);
            ClienteSMTP mensajero= new ClienteSMTP();
            mensajero.enviarMensaje(correo, "","El equipo fue registrado exitosamente.");
        } catch (Exception e) {
            System.out.println("Error al catch de firestill");
            ClienteSMTP mensajero= new ClienteSMTP();
            mensajero.enviarMensaje(correo, "","Verifique los datos enviados.");
        }
    }

    private void editarEquipo(String data) {
        String[] values = data.split(",");
        try {
            Integer id= getInteger_NOT_NULL(values[0]);
            Integer sucursal_id = getInteger_NOT_NULL(values[1]);
            Integer tipo_clasificacion_id = getInteger_NOT_NULL(values[2]);
            Integer marca_clasificacion_id = getInteger_NOT_NULL(values[3]);
            String nro_serie = getString_NOT_NULL(values[4]);
            String descripcion = getString(values[5]);
            String unidad_medida = getString(values[6]);
            Integer ano_fabricacion= getInteger_NOT_NULL(values[7]);
            Float capacidad= getFloat_NOT_NULL(values[8]);
            String ubicacion= getString_NOT_NULL(values[9]);
            NegocioEquipo negocioEquipo= new NegocioEquipo();
            negocioEquipo.editar(id, sucursal_id, tipo_clasificacion_id, marca_clasificacion_id, nro_serie, descripcion, unidad_medida, ano_fabricacion, capacidad, ubicacion);
            ClienteSMTP mensajero= new ClienteSMTP();
            mensajero.enviarMensaje(correo, "","El equipo fue editado exitosamente.");
        } catch (Exception e) {
            System.out.println("Error al catch de firestill");
            ClienteSMTP mensajero= new ClienteSMTP();
            mensajero.enviarMensaje(correo, "","Verifique los datos enviados.");
        }
    }

    private void eliminarEquipo(String data) {
        String[] values = data.split(",");
        try {
            Integer id= getInteger_NOT_NULL(values[0]);
            NegocioEquipo negocioEquipo= new NegocioEquipo();
            negocioEquipo.eliminar(id);
            ClienteSMTP mensajero= new ClienteSMTP();
            mensajero.enviarMensaje(correo, "","El equipo fue eliminado.");
        } catch (Exception e) {
            System.out.println("Error al catch de firestill");
            ClienteSMTP mensajero= new ClienteSMTP();
            mensajero.enviarMensaje(correo, "","Verifique los datos enviados.");
        }
    } 

    private void mostrarEquipo(String data) {
        String[] values = data.split(",");
        try {
            Integer id= getInteger_NOT_NULL(values[0]);
            NegocioEquipo negocioEquipo= new NegocioEquipo();
            String html=negocioEquipo.obtenerEquipoHTML(id);
            Templates t= new Templates();
            ClienteSMTP mensajero= new ClienteSMTP();
            mensajero.enviarMensaje(correo, "",t.generarMostrarHTML(html));
        } catch (Exception e) {
            System.out.println("Error al catch de firestill");
            ClienteSMTP mensajero= new ClienteSMTP();
            mensajero.enviarMensaje(correo, "","Verifique los datos enviados.");
        }
    }

    private void listarEquipos() {
        try {
            NegocioEquipo negocioEquipo= new NegocioEquipo();
            String html=negocioEquipo.obtenerEquiposHTML();
            Templates t= new Templates();
            ClienteSMTP mensajero= new ClienteSMTP();
            mensajero.enviarMensaje(correo, "",t.generarHTML(html));
        } catch (Exception e) {
            System.out.println("Error al catch de firestill");
            ClienteSMTP mensajero= new ClienteSMTP();
            mensajero.enviarMensaje(correo, "","Verifique los datos enviados.");
        }
    }

    
    // 12 Ficha Tecnica
    
    private void registrarFichaTecnica(String data) {
        String[] values = data.split(",");
        try {
            Integer equipo_id = getInteger_NOT_NULL(values[0]);
            Float carga = getFloat(values[1]);
            String observacion = getString(values[2]);
            String resultado = getString_NOT_NULL(values[3]);
            
            int contador=1;
            while (contador<=14 && (contador+4)<=values.length) {
                System.out.println("reviso:   "+contador);
                Integer nro_pieza=getInteger_NOT_NULL(values[contador-1+4]);
                if(nro_pieza>=1 && nro_pieza<=14){
                    contador++;
                }else{
                    new Exception("entro a la excepcion");
                }
                
            }
            
            NegocioFichaTecnica negocioFichaTecnica= new NegocioFichaTecnica();
            Integer id = negocioFichaTecnica.registrar(ejecutor.getId(), equipo_id, carga, observacion, resultado);
            /*
            contador=1;
            while (contador<=14 && (contador-1+4)<=values.length) {
                Integer nro_pieza=getInteger_NOT_NULL(values[contador-1+4]);
                negocioFichaTecnica.editar(id, nro_pieza);
            }
            
            ClienteSMTP mensajero= new ClienteSMTP();
            mensajero.enviarMensaje(correo, "","La ficha de inspeccion fue registrada exitosamente.");
*/
        } catch (Exception e) {
            System.out.println("Error al catch de firestill");
            ClienteSMTP mensajero= new ClienteSMTP();
            mensajero.enviarMensaje(correo, "","Verifique los datos enviados.");
        }
    
        //Integer trabajador_id, Integer equipo_id,Float carga, String observacion,String resultado
    }    

    private void eliminarFichaTecnica(String data) {
        String[] values = data.split(",");
        try {
            Integer id= getInteger_NOT_NULL(values[0]);
            NegocioFichaTecnica negocioFichaTecnica= new NegocioFichaTecnica();
            negocioFichaTecnica.eliminar(id);
            ClienteSMTP mensajero= new ClienteSMTP();
            mensajero.enviarMensaje(correo, "","La ficha tecnica fue eliminada.");
        } catch (Exception e) {
            System.out.println("Error al catch de firestill");
            ClienteSMTP mensajero= new ClienteSMTP();
            mensajero.enviarMensaje(correo, "","Verifique los datos enviados.");
        }
    } 

    private void mostrarFichaTecnica(String data) {
        String[] values = data.split(",");
        try {
            Integer id= getInteger_NOT_NULL(values[0]);
            NegocioFichaTecnica negocioFichaTecnica= new NegocioFichaTecnica();
            String html=negocioFichaTecnica.obtenerFichaTecnicaHTML(id);
            Templates t= new Templates();
            ClienteSMTP mensajero= new ClienteSMTP();
            mensajero.enviarMensaje(correo, "",t.generarMostrarHTML(html));
        } catch (Exception e) {
            System.out.println("Error al catch de firestill");
            ClienteSMTP mensajero= new ClienteSMTP();
            mensajero.enviarMensaje(correo, "","Verifique los datos enviados.");
        }
    }

    private void listarFichasTecnicas() {
        try {
            NegocioFichaTecnica negocioFichaTecnica= new NegocioFichaTecnica();
            String html=negocioFichaTecnica.obtenerFichasTecnicasHTML();
            Templates t= new Templates();
            ClienteSMTP mensajero= new ClienteSMTP();
            mensajero.enviarMensaje(correo, "",t.generarHTML(html));
        } catch (Exception e) {
            System.out.println("Error al catch de firestill");
            ClienteSMTP mensajero= new ClienteSMTP();
            mensajero.enviarMensaje(correo, "","Verifique los datos enviados.");
        }
    }

    private void listarPartes(){
        try {
            NegocioFichaTecnica negocioFichaTecnica= new NegocioFichaTecnica();
            String html=negocioFichaTecnica.obtenerListaPartesHTML();
            Templates t= new Templates();
            ClienteSMTP mensajero= new ClienteSMTP();
            mensajero.enviarMensaje(correo, "",t.generarHTML(html));
        } catch (Exception e) {
            System.out.println("Error al catch de firestill");
            ClienteSMTP mensajero= new ClienteSMTP();
            mensajero.enviarMensaje(correo, "","Verifique los datos enviados.");
        }
    }
    // 13 Ingreso Producto
    
    private void registrarIngresoProducto(String data) {
         String[] values = data.split(",");
        try {
            Integer proveedor_id = getInteger_NOT_NULL(values[0]);
            String nro_factura = getString_NOT_NULL(values[1]);
            if(values.length<5){
                throw new Exception();
            }
            int contador=1;
            while(contador<values.length-1){
                int producto_id=getInteger_NOT_NULL(values[contador+1]);
                NegocioProducto n_producto=new NegocioProducto();
                DatosProducto producto=n_producto.obtenerProducto(producto_id);
                int cantidad=getInteger_NOT_NULL(values[contador+2]);
                if(cantidad<=0){
                    System.out.println("entro al primer throw");
                    throw new Exception();
                }
                Float costo= getFloat_NOT_NULL(values[contador+3]);
                if(costo<0){
                    System.out.println("entro al primer throw");
                    throw new Exception();
                }
                contador=contador+3;
            }
            System.out.println("salio");
            NegocioIngresoProducto negocioIngresoProducto= new NegocioIngresoProducto();
            Integer id = negocioIngresoProducto.registrar(proveedor_id,nro_factura);
            System.out.println("entro luego de registrar");
            
            int contador2=1;
            while (contador2<values.length-1) {
                NegocioDetalleIngresoProducto detalle= new NegocioDetalleIngresoProducto();
                int producto_id2=getInteger_NOT_NULL(values[contador2+1]);
                int cantidad2=getInteger_NOT_NULL(values[contador2+2]);
                float costo2=getFloat_NOT_NULL(values[contador2+3]);
                detalle.registrar(id,producto_id2, cantidad2,  costo2);
                contador2=contador2+3;
            }
            
            ClienteSMTP mensajero= new ClienteSMTP();
            mensajero.enviarMensaje(correo, "","La ficha de inspeccion fue registrada exitosamente.");
        } catch (Exception e) {
            System.out.println("Error al catch de firestill");
            ClienteSMTP mensajero= new ClienteSMTP();
            mensajero.enviarMensaje(correo, "","Verifique los datos enviados.");
        }
     }   

    private void eliminarIngresoProducto(String data) {
        String[] values = data.split(",");
        try {
            Integer id= getInteger_NOT_NULL(values[0]);
            NegocioIngresoProducto negocioIngresoProducto= new NegocioIngresoProducto();
            negocioIngresoProducto.eliminar(id);
            ClienteSMTP mensajero= new ClienteSMTP();
            mensajero.enviarMensaje(correo, "","El ingreso de productos fue eliminado.");
        } catch (Exception e) {
            System.out.println("Error al catch de firestill");
            ClienteSMTP mensajero= new ClienteSMTP();
            mensajero.enviarMensaje(correo, "","Verifique los datos enviados.");
        }
    } 

    private void mostrarIngresoProducto(String data) {
        String[] values = data.split(",");
        try {
            Integer id= getInteger_NOT_NULL(values[0]);
            NegocioIngresoProducto negocioIngresoProducto= new NegocioIngresoProducto();
            String html=negocioIngresoProducto.obtenerIngresoProductoHTML(id);
            Templates t= new Templates();
            ClienteSMTP mensajero= new ClienteSMTP();
            mensajero.enviarMensaje(correo, "",t.generarMostrarHTML(html));
        } catch (Exception e) {
            System.out.println("Error al catch de firestill");
            ClienteSMTP mensajero= new ClienteSMTP();
            mensajero.enviarMensaje(correo, "","Verifique los datos enviados.");
        }
    }

    private void listarIngresosProductos() {
        try {
            NegocioIngresoProducto negocioIngresoProducto= new NegocioIngresoProducto();
            String html=negocioIngresoProducto.obtenerIngresosProductosHTML();
            Templates t= new Templates();
            ClienteSMTP mensajero= new ClienteSMTP();
            mensajero.enviarMensaje(correo, "",t.generarHTML(html));
        } catch (Exception e) {
            System.out.println("Error al catch de firestill");
            ClienteSMTP mensajero= new ClienteSMTP();
            mensajero.enviarMensaje(correo, "","Verifique los datos enviados.");
        }
    }
    
    // 15 Nota venta
        
     private void registrarNotaVenta(String data){
         String[] values = data.split(",");
        try {
            Integer cliente_id = getInteger_NOT_NULL(values[0]);
            if(values.length<3 || values.length %  2==0){
                throw new Exception();
            }
            int contador=0;
            while(contador<values.length-1){
                int producto_id=getInteger_NOT_NULL(values[contador+1]);
                NegocioProducto n_producto=new NegocioProducto();
                DatosProducto producto=n_producto.obtenerProducto(producto_id);
                int cantidad=getInteger_NOT_NULL(values[contador+2]);
                if(producto.getCantidad()<cantidad){
                    System.out.println("entro al primer throw");
                    throw new Exception();
                }
                contador=contador+2;
            }
            System.out.println("salio");
            NegocioNotaVenta negocioNotaVenta= new NegocioNotaVenta();
            Integer id = negocioNotaVenta.registrar(ejecutor.getId(),cliente_id);
            System.out.println("entro luego de registrar");
            
            int contador2=0;
            while (contador2<values.length-1) {
                NegocioDetalleNotaVenta detalle= new NegocioDetalleNotaVenta();
                int producto_id2=getInteger_NOT_NULL(values[contador2+1]);
                int cantidad2=getInteger_NOT_NULL(values[contador2+2]);
                detalle.registrar(id, producto_id2, cantidad2);
                contador2=contador2+2;
            }
            
            ClienteSMTP mensajero= new ClienteSMTP();
            mensajero.enviarMensaje(correo, "","La ficha de inspeccion fue registrada exitosamente.");
        } catch (Exception e) {
            System.out.println("Error al catch de firestill");
            ClienteSMTP mensajero= new ClienteSMTP();
            mensajero.enviarMensaje(correo, "","Verifique los datos enviados.");
        }
     }   
    
    public void anularNotaVenta(String data){
        String[] values = data.split(",");
        try {
            Integer id= getInteger_NOT_NULL(values[0]);
            NegocioNotaVenta negocioNotaVenta= new NegocioNotaVenta();
            negocioNotaVenta.eliminar(id);
            ClienteSMTP mensajero= new ClienteSMTP();
            mensajero.enviarMensaje(correo, "","La nota de venta fue anulada.");
        } catch (Exception e) {
            System.out.println("Error al catch de firestill");
            ClienteSMTP mensajero= new ClienteSMTP();
            mensajero.enviarMensaje(correo, "","Verifique los datos enviados.");
        }
    }
    
    public void mostrarNotaVenta(String data){
        String[] values = data.split(",");
        try {
            Integer id= getInteger_NOT_NULL(values[0]);
            NegocioNotaVenta negocioNotaVenta= new NegocioNotaVenta();
            String html=negocioNotaVenta.obtenerNotaVentaHTML(id);
            Templates t= new Templates();
            ClienteSMTP mensajero= new ClienteSMTP();
            mensajero.enviarMensaje(correo, "",t.generarMostrarHTML(html));
        } catch (Exception e) {
            System.out.println("Error al catch de firestill");
            ClienteSMTP mensajero= new ClienteSMTP();
            mensajero.enviarMensaje(correo, "","Verifique los datos enviados.");
        }
    }
    
    public void listarNotasVenta(){
        try {
            NegocioNotaVenta negocioNotaVenta= new NegocioNotaVenta();
            String html=negocioNotaVenta.obtenerNotasVentaHTML();
            Templates t= new Templates();
            ClienteSMTP mensajero= new ClienteSMTP();
            mensajero.enviarMensaje(correo, "",t.generarHTML(html));
        } catch (Exception e) {
            System.out.println("Error al catch de firestill");
            ClienteSMTP mensajero= new ClienteSMTP();
            mensajero.enviarMensaje(correo, "","Verifique los datos enviados.");
        }
    }
    
    
    
    private Boolean isAdministrador(){
        Boolean b= false;
        if(ejecutor.getTipo()=="Administrador"){
            b = true;
        }
        return b;
    }
    
    private Boolean isVentas(){
        Boolean b= false;
        if(ejecutor.getTipo()=="Venta"){
            b = true;
        }
        return b;
    }
    
    private Boolean isMantenimiento(){
        Boolean b= false;
        if(ejecutor.getTipo()=="Tecnico"){
            b = true;
        }
        return b;
    }
    
    private boolean esNulo(String texto){
        boolean b= false;
       if((texto.trim()).contentEquals("*")){
           b= true;
           System.out.println("es nulooo entro al if *");
       }
       return  b;
    }
    
    private String getString(String texto){
        System.out.println("texto="+texto);
        String valor=null;
        if(!esNulo(texto)){
           valor= texto.trim();
        }
        return valor;
    }
    
    private String getString_NOT_NULL(String texto) throws Exception{
        if(esNulo(texto)){
           throw new Exception("este campo no puede ser null");
        }
        return texto.trim();
    }
    
    private Integer getInteger_NOT_NULL(String texto) throws Exception{
        if(esNulo(texto)){
           throw new Exception("este campo no puede ser null");
        }
        return Integer.parseInt(texto.trim());
    }
    
    private Float getFloat_NOT_NULL(String texto) throws Exception{
        if(esNulo(texto)){
           throw new Exception("este campo no puede ser null");
        }
        return Float.parseFloat(texto.trim());
    }
    
    private Date getDate_NOT_NULL(String texto) throws Exception{
        if(esNulo(texto)){
           throw new Exception("este campo no puede ser null");
        }
        Date fecha=new SimpleDateFormat("dd/MM/yyyy").parse(texto.trim());
        return fecha;
    }
    
    private String getCarnet_NOT_NULL(String texto)throws Exception{
        String carnet=texto.trim();
        if(esNulo(carnet) || carnet.length()>10){
            throw new Exception();
        }
        return carnet;
    }
    
    private String getNroTelefono_NOT_NULL(String texto)throws Exception{
        String telefono=getNroTelefono(texto);
        if(telefono==null){
            throw new Exception();
        }
        return telefono;
    }
    
    private String getNroTelefono(String texto)throws Exception{
        String valor=null;
        if(!esNulo(texto)){
            int numero=Integer.parseInt(texto.trim());
            String cadena=Integer.toString(numero);
            if(cadena.length()==7 || cadena.length()==8){
                return cadena;
            }
            throw new Exception();
        }
        return valor;
    }
    
    private Integer getInteger(String texto){
        Integer valor=null;
        if(!esNulo(texto)){
           valor= Integer.parseInt(texto.trim());
        }
        return valor;
    }
    
    private Float getFloat(String texto){
        Float valor=null;
        if(!esNulo(texto)){
           valor= Float.parseFloat(texto.trim());
        }
        return valor;
    }
    
    

    
    public static void main(String[] args) {
        ComandoFirestill c= new ComandoFirestill();
//        c.ejecutarComando("nath.1475369@gmail.com", "registrarMarcaClasificacion:nueva marca");
//        c.ejecutarComando("nath.1475369@gmail.com", "editarMarcaClasificacion:1, otra marca");
//        c.ejecutarComando("nath.1475369@gmail.com", "mostrarMarcaClasificacion:2");
//        c.ejecutarComando("nath.1475369@gmail.com", "eliminarMarcaClasificacion:");
//        c.ejecutarComando("nath.1475369@gmail.com", "mostrarMarcaClasificacion:2");
            //cliente_id, producto_id, cantidad,...
         // c.ejecutarComando("rodrigo.abasto21@gmail.com", "listarNotasVenta");
          c.ejecutarComando("nath.1475369@gmail.com", "registrarFichaInspeccion:1,20,en buen estado, finalizado,1,2");
          //c.ejecutarComando("nath.1475369@gmail.com", "listarFichasInspeccion");
    }
    
}
