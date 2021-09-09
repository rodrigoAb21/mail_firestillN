/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Datos;

import java.sql.ResultSet;
import java.util.ArrayList;

/**
 *
 * @author asus
 */
public class DatosConfig extends Tabla{
    
    private Integer id ;
    private Integer tema;
    private boolean noche;
    private Integer trabajador_id;
    
    public DatosConfig(){
        
        conexion= new ConexionPGDB();
        
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Integer getTema() {
        return tema;
    }

    public void setTema(Integer tema) {
        this.tema = tema;
    }

    public boolean isNoche() {
        return noche;
    }

    public void setNoche(boolean noche) {
        this.noche = noche;
    }

    public Integer getTrabajador_id() {
        return trabajador_id;
    }

    public void setTrabajador_id(Integer trabajador_id) {
        this.trabajador_id = trabajador_id;
    }
    
    @Override
    String getNombreTabla() {
        return " config ";
    }
    
    @Override
    String getSqlInsert() {
        String sql = "INSERT INTO "+getNombreTabla()+" ("
                + "tema,"
                + "noche,"
                + "trabajador_id"
                + ")"
                + "VALUES("
                + getSQLString(this.tema)+","
                + getSQLString(this.noche)+","
                +getSQLString(this.trabajador_id)
                +") RETURNING ID;";
        return sql;
    }

    @Override
    String getSqlUpdate() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    String getSqlDelete() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    ArrayList<Object> getlista(ResultSet resultado) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }
}
