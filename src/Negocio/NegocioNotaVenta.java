/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Negocio;

import Datos.DatosNotaVenta;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.Date;

/**
 *
 * @author asus
 */
public class NegocioNotaVenta {
     public NegocioNotaVenta() {
    }
    
    public Integer registrar(Integer trabajador_id,Integer cliente_id){
        DatosNotaVenta datosNotaVenta = new DatosNotaVenta();
        datosNotaVenta.setCliente_id(cliente_id);
        datosNotaVenta.setTrabajador_id(trabajador_id);
        
        DateTimeFormatter dtf = DateTimeFormatter.ofPattern("yyyy/MM/dd");
        String fecha = dtf.format(LocalDateTime.now());
        Date fecha_hoy=new Date(fecha);
        datosNotaVenta.setFecha(fecha_hoy);
        float total=0;
        datosNotaVenta.setTotal(total);
        return datosNotaVenta.insertar();
    }
    
    public static void main(String[] args) {
        NegocioNotaVenta n= new NegocioNotaVenta();
        n.registrar(4,1);
    }
    
}
