/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Utils;

import Comunicacion.ClienteSMTP;
import Datos.DatosCliente;
import Datos.DatosTrabajador;
import Datos.Prueba;
import Negocio.NegocioBajaProducto;
import Negocio.NegocioCategoria;
import Negocio.NegocioCliente;
import Negocio.NegocioConfig;
import Negocio.NegocioContrato;
import Negocio.NegocioEquipo;
import Negocio.NegocioMarcaClasificacion;
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
                    
                    // Tipo Clasificacion
                    case "registrartipoclasificacion":
                    registrarTipoClasificacion(s[1]);
                    break;
                    
                    case "editartipoclasificacion":
                    editarTipoClasificacion(s[1]);
                    break;
                    
                    case "eliminarrtipoclasificacion":
                    editarTipoClasificacion(s[1]);
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
                    editarMarcaClasificacion(s[1]);
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
                    editarCategoria(s[1]);
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
                    
                    case "registrartrabajadormantenimiento":
                    registrarTrabajador(s[1], "Tecnico");
                    break;
                    
                    case "eliminarTrabajador":
                    eliminarTrabajador(s[1]);
                    break;
                    
                    case "mostrarTrabajador":
                    mostrarTrabajador(s[1]);
                    break;
                    
                    case "listarTrabajadores":
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
                    
                    case "mostrarProducto":
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
                    case "registrarfichatecnica":
                    registrarFichaTecnica(s[1]);
                    break;
                    
                    case "eliminarfichatecnica":
                    eliminarFichaTecnica(s[1]);
                    break;
                    
                    case "mostrarfichatecnica":
                    mostrarFichaTecnica(s[1]);
                    break;
                    
                    case "listarfichastecnicas":
                    listarFichasTecnicas();
                    break;
                    
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
            mensajero.enviarMensaje(correo, "",t.generarHTML(html));
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
            mensajero.enviarMensaje(correo, "",t.generarHTML(html));
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
            mensajero.enviarMensaje(correo, "",t.generarHTML(html));
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
            String carnet = getString_NOT_NULL(values[2]);
            System.out.println("carnet: "+carnet);
            String telefono = getString(values[3]);
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
            mensajero.enviarMensaje(correo, "",t.generarHTML(html));
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
            String telefono = getString_NOT_NULL(values[4]);
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
            String telefono = getString_NOT_NULL(values[5]);
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
            mensajero.enviarMensaje(correo, "",t.generarHTML(html));
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
            String telefono_empresa = getString(values[2]);
            String email = getString(values[3]);
            String direccion = getString(values[4]);
            String nombre_encargado = getString(values[5]);
            String cargo_encargado = getString(values[6]);
            String email_encargado = getString(values[7]);
            String telefono_encargado = getString(values[8]);
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
            String telefono_empresa = getString(values[3]);
            String email = getString(values[4]);
            String direccion = getString(values[5]);
            String nombre_encargado = getString(values[6]);
            String cargo_encargado = getString(values[7]);
            String email_encargado = getString(values[8]);
            String telefono_encargado = getString(values[9]);
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
            mensajero.enviarMensaje(correo, "",t.generarHTML(html));
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
            Integer cantidad = getInteger_NOT_NULL(values[4]);
            NegocioProducto negocioProducto= new NegocioProducto();
            Integer id = negocioProducto.registrar(categoria_id, nombre, descripcion, precio, cantidad);
            ClienteSMTP mensajero= new ClienteSMTP();
            mensajero.enviarMensaje(correo, "","El producto fue registrado exitosamente.");
        } catch (Exception e) {
            System.out.println("Error al catch de firestill");
            ClienteSMTP mensajero= new ClienteSMTP();
            mensajero.enviarMensaje(correo, "","Verifique los datos enviados.");
        }
    }

    private void editarProducto(String string) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    private void eliminarProducto(String string) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    private void mostrarProducto(String string) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    private void listarProductos() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
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

    private void eliminarBajaProducto(String string) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    private void mostrarBajaProducto(String string) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    private void listarBajaProductos() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
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
            mensajero.enviarMensaje(correo, "","La baja de producto fue registrada exitosamente.");
        } catch (Exception e) {
            System.out.println("Error al catch de firestill");
            ClienteSMTP mensajero= new ClienteSMTP();
            mensajero.enviarMensaje(correo, "","Verifique los datos enviados.");
        }
    }

    private void editarContrato(String string) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    private void eliminarContrato(String string) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    private void mostrarContrato(String string) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    private void listarContratos() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
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

    private void editarSucursal(String string) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    private void eliminarSucursal(String string) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    private void mostrarSucursal(String string) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    private void listarSucursales() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }
    
    // 11 Equipo

    private void registrarEquipo(String data) {
        /*
        String[] values = data.split(",");
        try {
            Integer sucursal_id = getInteger_NOT_NULL(values[0]);
            String nro_serie = getString_NOT_NULL(values[1]);
            String direccion = getString_NOT_NULL(values[2]);
            NegocioEquipo negocioEquipo= new NegocioEquipo();
            Integer id = negocioEquipo.registrar(contrato_id,nombre, direccion );
            ClienteSMTP mensajero= new ClienteSMTP();
            mensajero.enviarMensaje(correo, "","La sucursal fue registrada exitosamente.");
        } catch (Exception e) {
            System.out.println("Error al catch de firestill");
            ClienteSMTP mensajero= new ClienteSMTP();
            mensajero.enviarMensaje(correo, "","Verifique los datos enviados.");
        }
*/
    }

    private void editarEquipo(String data) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    private void eliminarEquipo(String data) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    private void mostrarEquipo(String data) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    private void listarEquipos() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    
    // 12 Ficha Tecnica
    
    private void registrarFichaTecnica(String string) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    private void eliminarFichaTecnica(String string) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    private void mostrarFichaTecnica(String string) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    private void listarFichasTecnicas() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    
    // 13 Ingreso Producto
    
    private void registrarIngresoProducto(String string) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    private void eliminarIngresoProducto(String string) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    private void mostrarIngresoProducto(String string) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    private void listarIngresosProductos() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
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
        
    }
    
}
