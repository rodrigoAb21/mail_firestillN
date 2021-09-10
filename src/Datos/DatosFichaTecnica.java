/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Datos;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.Date;

/**
 *
 * @author asus
 */
public class DatosFichaTecnica extends Tabla{
    private Integer id ;
    private Date fecha;
    private String eCanioPesca;
    private String eZuncho;
    private String eChasis;
    private String eRueda;
    private String eRosca;
    private String eManguera;
    private String eValvula;
    private String eTobera;
    private String eRobinete;
    private String ePalanca;
    private String eManometro;
    private String eVastago;
    private String eDifusor;
    private String eDisco;
    private Float carga;
    private String observacion;
    private String resultado;
    private Integer equipo_id;
    private Integer trabajador_id;
    private String deleted_at;
    
    public DatosFichaTecnica(){
      
        conexion= new ConexionPGDB();
        
    }

    public Integer getId() {
        return id;
    }

    public Date getFecha() {
        return fecha;
    }

    public void setFecha(Date fecha) {
        this.fecha = fecha;
    }

    public String geteCanioPesca() {
        return eCanioPesca;
    }

    public void seteCanioPesca(String eCanioPesca) {
        this.eCanioPesca = eCanioPesca;
    }

    public String geteZuncho() {
        return eZuncho;
    }

    public void seteZuncho(String eZuncho) {
        this.eZuncho = eZuncho;
    }

    public String geteChasis() {
        return eChasis;
    }

    public void seteChasis(String eChasis) {
        this.eChasis = eChasis;
    }

    public String geteRueda() {
        return eRueda;
    }

    public void seteRueda(String eRueda) {
        this.eRueda = eRueda;
    }

    public String geteRosca() {
        return eRosca;
    }

    public void seteRosca(String eRosca) {
        this.eRosca = eRosca;
    }

    public String geteManguera() {
        return eManguera;
    }

    public void seteManguera(String eManguera) {
        this.eManguera = eManguera;
    }

    public String geteValvula() {
        return eValvula;
    }

    public void seteValvula(String eValvula) {
        this.eValvula = eValvula;
    }

    public String geteTobera() {
        return eTobera;
    }

    public void seteTobera(String eTobera) {
        this.eTobera = eTobera;
    }

    public String geteRobinete() {
        return eRobinete;
    }

    public void seteRobinete(String eRobinete) {
        this.eRobinete = eRobinete;
    }

    public String getePalanca() {
        return ePalanca;
    }

    public void setePalanca(String ePalanca) {
        this.ePalanca = ePalanca;
    }

    public String geteManometro() {
        return eManometro;
    }

    public void seteManometro(String eManometro) {
        this.eManometro = eManometro;
    }

    public String geteVastago() {
        return eVastago;
    }

    public void seteVastago(String eVastago) {
        this.eVastago = eVastago;
    }

    public String geteDifusor() {
        return eDifusor;
    }

    public void seteDifusor(String eDifusor) {
        this.eDifusor = eDifusor;
    }

    public String geteDisco() {
        return eDisco;
    }

    public void seteDisco(String eDisco) {
        this.eDisco = eDisco;
    }

    public Float getCarga() {
        return carga;
    }

    public void setCarga(Float carga) {
        this.carga = carga;
    }

    public String getObservacion() {
        return observacion;
    }

    public void setObservacion(String observacion) {
        this.observacion = observacion;
    }

    public String getResultado() {
        return resultado;
    }

    public void setResultado(String resultado) {
        this.resultado = resultado;
    }

    public Integer getEquipo_id() {
        return equipo_id;
    }

    public void setEquipo_id(Integer equipo_id) {
        this.equipo_id = equipo_id;
    }

    public Integer getTrabajador_id() {
        return trabajador_id;
    }

    public void setTrabajador_id(Integer trabajador_id) {
        this.trabajador_id = trabajador_id;
    }

    public String getDeleted_at() {
        return deleted_at;
    }

    public void setDeleted_at(String deleted_at) {
        this.deleted_at = deleted_at;
    }
    
    
    
    @Override
     String getNombreTabla() {
        return " ficha_tecnica ";
    }
    
    @Override
     String getSqlInsert() {
        String sql = "INSERT INTO "+getNombreTabla()+" ("
                + "fecha,"
                + "eCanioPesca,"
                + "eZuncho,"
                + "eChasis,"
                + "eRueda,"
                + "eRosca,"
                + "eManguera,"
                + "eValvula,"
                + "eTobera,"
                + "eRobinete,"
                + "ePalanca,"
                + "eManometro,"
                + "eVastago,"
                + "eDifusor,"
                + "carga,"
                + "observacion,"
                + "resultado,"
                + "equipo_id,"
                + "trabajador_id"
                + ")"
                + "VALUES("
                +getSQLString(this.fecha)+","
                +getSQLString(this.eCanioPesca)+","
                +getSQLString(this.eZuncho)+","
                +getSQLString(this.eChasis)+","
                +getSQLString(this.eRueda)+","
                +getSQLString(this.eRosca)+","
                +getSQLString(this.eManguera)+","
                +getSQLString(this.eValvula)+","
                +getSQLString(this.eTobera)+","
                +getSQLString(this.eRobinete)+","
                +getSQLString(this.ePalanca)+","
                +getSQLString(this.eManometro)+","
                +getSQLString(this.eVastago)+","
                +getSQLString(this.eDifusor)+","
                +getSQLString(this.carga)+","
                +getSQLString(this.observacion)+","
                +getSQLString(this.resultado)+","
                +getSQLString(this.equipo_id)+","
                +getSQLString(this.trabajador_id)
                +");";
        
        
        return sql;
    }
    
    @Override
     String getSqlUpdate() {
        String sql = "UPDATE "+getNombreTabla()+" SET "
                + "eCanioPesca="+getSQLString(this.eCanioPesca)+","
                + "eZuncho="+getSQLString(this.eZuncho)+","
                + "eChasis="+getSQLString(this.eChasis)+","
                + "eRueda="+getSQLString(this.eRueda)+","
                + "eRosca="+getSQLString(this.eRosca)+","
                + "eManguera="+getSQLString(this.eManguera)+","
                + "eValvula="+getSQLString(this.eValvula)+","
                + "eTobera="+getSQLString(this.eTobera)+","
                + "eRobinete="+getSQLString(this.eRobinete)+","
                + "ePalanca="+getSQLString(this.ePalanca)+","
                + "eManometro="+getSQLString(this.eManometro)+","
                + "eVastago="+getSQLString(this.eVastago)+","
                + "eDifusor="+getSQLString(this.eDifusor)+","
                + "eDisco="+getSQLString(this.eDisco)+" "
                + "where id="+ getSQLString(this.id)+";";
        return sql;
    }

    @Override
    String getSqlDelete() {
          DateTimeFormatter dtf = DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss");
        String fechaHora=" '"+dtf.format(LocalDateTime.now()).toString()+"' ";
        
       String sql = "UPDATE "+getNombreTabla()+" SET "
                + "deleted_at ="+fechaHora
                + "where id="+getSQLString(this.id)+";";
       return sql;
    }
    
    @Override
    ArrayList<Object> getlista(ResultSet resul) {
        ArrayList<Object> lista= new ArrayList<Object>();
        try {
            while(resul.next()){
                DatosFichaTecnica datosFichaTecnica = new DatosFichaTecnica();
                datosFichaTecnica.id=resul.getInt("id");
                datosFichaTecnica.fecha=resul.getDate("fecha");
                datosFichaTecnica.eCanioPesca=resul.getString("eCanioPesca");
                datosFichaTecnica.eZuncho=resul.getString("eZuncho");
                datosFichaTecnica.eChasis=resul.getString("eChasis");
                datosFichaTecnica.eRueda=resul.getString("eRueda");
                datosFichaTecnica.eRosca=resul.getString("eRosca");
                datosFichaTecnica.eManguera=resul.getString("eManguera");
                datosFichaTecnica.eValvula=resul.getString("eValvula");
                datosFichaTecnica.eTobera=resul.getString("eTobera");
                datosFichaTecnica.eRobinete=resul.getString("eRobinete");
                datosFichaTecnica.ePalanca=resul.getString("ePalanca");
                datosFichaTecnica.eManometro=resul.getString("eManometro");
                datosFichaTecnica.eVastago=resul.getString("eVastago");
                datosFichaTecnica.eDifusor=resul.getString("eDifusor");
                datosFichaTecnica.eDisco=resul.getString("eDisco");
                datosFichaTecnica.carga=resul.getFloat("carga");
                datosFichaTecnica.observacion=resul.getString("observacion");
                datosFichaTecnica.resultado=resul.getString("resultado");
                datosFichaTecnica.equipo_id=resul.getInt("equipo_id");
                datosFichaTecnica.trabajador_id=resul.getInt("trabajador_id");
                datosFichaTecnica.deleted_at=resul.getString("deleted_at");
                lista.add(datosFichaTecnica);
            }
        } catch (SQLException ex) {
            new Exception("error get lista ficha tecnica datos");
        }
        return lista;
    }
    
    public DatosFichaTecnica obtener(Integer id){
        return (DatosFichaTecnica)obtenerTupla(id);
    }
    
    public ArrayList<DatosFichaTecnica> obtener(){
        ArrayList<DatosFichaTecnica> lista=new ArrayList<DatosFichaTecnica>();
        for (Object object : obtenertLista()) {
            DatosFichaTecnica datosFichaTecnica= new DatosFichaTecnica();
            datosFichaTecnica= (DatosFichaTecnica) object;
            lista.add(datosFichaTecnica);
        }
        return lista;
    }

    
}
