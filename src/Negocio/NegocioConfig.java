/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Negocio;

import Datos.DatosConfig;

/**
 *
 * @author asus
 */
public class NegocioConfig {
    public NegocioConfig() {
    }
    
    public Integer registrar(Integer trabajador_id){
        DatosConfig datosConfig = new DatosConfig();
        datosConfig.setTema(1);
        datosConfig.setNoche(false);
        datosConfig.setTrabajador_id(trabajador_id);
        return datosConfig.insertar();
    }
    
    
}
