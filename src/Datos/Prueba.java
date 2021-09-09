/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Datos;

import java.util.Date;

/**
 *
 * @author asus
 */
public class Prueba {
    
    Date fecha;
    int entero;
    float flotante;
    String cadena;

    public Prueba(Date fecha, int entero, float flotante, String cadena) {
    
        if(fecha==null){
            System.out.println("fecha nula");
        }else{
            System.out.println(fecha.toString()+"-");
        }
        if(entero==-1){
            System.out.println("entero nulo");
        }else{
            System.out.println(entero+"-");
        }
        if(flotante==-1){
            System.out.println("flotante nulo");
        }else{
            System.out.println(flotante+"-");
        }
        if(cadena==null){
            System.out.println("cadena nula");
        }else{
            System.out.println(cadena+"-");
        }
            
    }
    
}
