/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Utils;
import java.text.SimpleDateFormat;
import java.util.Date;
/**
 *
 * @author asus
 */
public class toStringSQL {
    public String getSQLString(Date fecha){
        String texto="null";
        if(fecha!=null){
            SimpleDateFormat formato = new SimpleDateFormat("dd-MM-yyyy"); 
            texto = "'"+formato.format(fecha)+"'";
        }
        return texto;
    }
    
    public String getSQLString(String cadena){
        String texto= "null";
        if(cadena!=null){
            texto= "'"+cadena+"'";
        }
        return texto;
    }
    
    
}
