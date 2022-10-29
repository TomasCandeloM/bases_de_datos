/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Gestion;

/**
 *
 * @author tomas
 */
import java.sql.Connection;
import java.sql.SQLException;
import javafx.collections.ObservableList;
import java.sql.Statement;
import java.util.logging.Level;
import java.util.logging.Logger;
import java.sql.ResultSet;

public class Parameters {
    private String code;
    private String name;
    private int population;
    private String headofstate;
    private String region;
    private String continente;
    private String indepyear;
    private int surface;
    private String goverfrom;
    private String distric;
    private String countrycode;
    private String language;
    private String isofficial;
    private String percentaje;
    private int id;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public Parameters(String code, String countryname, int population, String headofstate, String region, String continente, String indepyear, int surface, String goverfrom, String distric, String cityname,int id, String language, String isofficial, String percentaje) {
        this.code = code;
        this.name = countryname;
        this.population = population;
        this.headofstate = headofstate;
        this.region = region;
        this.continente = continente;
        this.indepyear = indepyear;
        this.surface = surface;
        this.goverfrom = goverfrom;
        this.distric = distric;
        this.countrycode = cityname;
        this.id = id;
        this.language = language;
        this.isofficial = isofficial;
        this.percentaje = percentaje;
    }

    public String getCountrycode() {
        return countrycode;
    }

    public void setCountrycode(String countrycode) {
        this.countrycode = countrycode;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getIsofficial() {
        return isofficial;
    }

    public void setIsofficial(String isofficial) {
        this.isofficial = isofficial;
    }

    public String getPercentaje() {
        return percentaje;
    }

    public void setPercentaje(String percentaje) {
        this.percentaje = percentaje;
    }

    public String getCode() {
        return code;
    }

    public void setCode(String code) {
        this.code = code;
    }

    public int getPopulation() {
        return population;
    }

    public void setPopulation(int population) {
        this.population = population;
    }

    public String getHeadofstate() {
        return headofstate;
    }

    public void setHeadofstate(String headofstate) {
        this.headofstate = headofstate;
    }

    public String getRegion() {
        return region;
    }

    public void setRegion(String region) {
        this.region = region;
    }

    public String getContinente() {
        return continente;
    }

    public void setContinente(String continente) {
        this.continente = continente;
    }

    public String getIndepyear() {
        return indepyear;
    }

    public void setIndepyear(String indepyear) {
        this.indepyear = indepyear;
    }

    public int getSurface() {
        return surface;
    }

    public void setSurface(int surface) {
        this.surface = surface;
    }

    public String getGoverfrom() {
        return goverfrom;
    }

    public void setGoverfrom(String goverfrom) {
        this.goverfrom = goverfrom;
    }

    public String getDistric() {
        return distric;
    }

    public void setDistric(String distric) {
        this.distric = distric;
    }

    public String getLanguage() {
        return language;
    }

    public void setLanguage(String language) {
        this.language = language;
    }
    
    
    public static void llenarInformacion(Connection connection, ObservableList<Parameters> lista, String sql){
        
        try {
            Statement instruccion = connection.createStatement();
            ResultSet resultado = instruccion.executeQuery(sql);
            
            while (resultado.next()){
       //         lista.add(new Parameters(resultado.getString("code"),resultado.getString("name"),resultado.getInt("population"),
       //             resultado.getString("headofstate"),resultado.getString("region"),resultado.getString("continent"),resultado.getString("indepyear"),
       //             resultado.getInt("surface"),resultado.getString("goverfrom"),));
            }
            
        } catch (SQLException ex) {
            Logger.getLogger(Parameters.class.getName()).log(Level.SEVERE, null, ex);
        }
        
    }
    
    
}
