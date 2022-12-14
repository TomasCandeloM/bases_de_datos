/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Gestion;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.logging.Level;
import java.util.logging.Logger;
import javafx.collections.ObservableList;

/**
 *
 * @author Gabriel J
 */
public class Country {
    
    private String code;
    private String name;
    private String continent;
    private String region;
    private Integer surfacearea;
    private Integer indepyear;
    private Integer population;
    private Integer lifeexpectancy;
    private Integer GNP;
    private Integer GNPOld;
    private String localname;
    private String governmentform;
    private String headofstate;
    private Integer capital;
    private String code2;

    public Country(String code, String name, String continent, String region, Integer surfacearea, Integer indepyear, Integer population, Integer lifeexp, Integer GNP, Integer GNPOld, String localname, String goverform, String headofstate, Integer capital, String code2) {
        this.code = code;
        this.name = name;
        this.continent = continent;
        this.region = region;
        this.surfacearea = surfacearea;
        this.indepyear = indepyear;
        this.population = population;
        this.lifeexpectancy = lifeexp;
        this.GNP = GNP;
        this.GNPOld = GNPOld;
        this.localname = localname;
        this.governmentform = goverform;
        this.headofstate = headofstate;
        this.capital = capital;
        this.code2 = code2;
    }
    
    

    public String getCode() {
        return code;
    }

    public void setCode(String code) {
        this.code = code;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getContinent() {
        return continent;
    }

    public void setContinent(String continent) {
        this.continent = continent;
    }

    public String getRegion() {
        return region;
    }

    public void setRegion(String region) {
        this.region = region;
    }

    public Integer getSurfacearea() {
        return surfacearea;
    }

    public void setSurfacearea(Integer surfacearea) {
        this.surfacearea = surfacearea;
    }

    public Integer getIndepyear() {
        return indepyear;
    }

    public void setIndepyear(Integer indepyear) {
        this.indepyear = indepyear;
    }

    public Integer getPopulation() {
        return population;
    }

    public void setPopulation(Integer population) {
        this.population = population;
    }

    public Integer getLifeexpectancy() {
        return lifeexpectancy;
    }

    public void setLifeexpectancy(Integer lifeexpectancy) {
        this.lifeexpectancy = lifeexpectancy;
    }

    public Integer getGNP() {
        return GNP;
    }

    public void setGNP(Integer GNP) {
        this.GNP = GNP;
    }

    public Integer getGNPOld() {
        return GNPOld;
    }

    public void setGNPOld(Integer GNPOld) {
        this.GNPOld = GNPOld;
    }

    public String getLocalname() {
        return localname;
    }

    public void setLocalname(String localname) {
        this.localname = localname;
    }

    public String getGovernmentform() {
        return governmentform;
    }

    public void setGovernmentform(String governmentform) {
        this.governmentform = governmentform;
    }

    public String getHeadofstate() {
        return headofstate;
    }

    public void setHeadofstate(String headofstate) {
        this.headofstate = headofstate;
    }

    public Integer getCapital() {
        return capital;
    }

    public void setCapital(Integer capital) {
        this.capital = capital;
    }

    public String getCode2() {
        return code2;
    }

    public void setCode2(String code2) {
        this.code2 = code2;
    }
    
    public static ObservableList<Country> llenarInformacionCountry(Connection connection, ObservableList<Country> lista, String sql){
        
        try {
            Statement instruccion = connection.createStatement();
            ResultSet resultado = instruccion.executeQuery(sql);
            
            while (resultado.next()){
                lista.add(new Country(resultado.getString("code"), resultado.getString("name"), resultado.getString("continent"), resultado.getString("region"), resultado.getInt("surfacearea"), resultado.getInt("indepyear"), resultado.getInt("population"), resultado.getInt("lifeexpectancy"), resultado.getInt("GNP"), resultado.getInt("GNPOld"), resultado.getString("localname"), resultado.getString("governmentform"), resultado.getString("headofstate"), resultado.getInt("capital"), resultado.getString("code2")));               
            }
            
        } catch (SQLException ex) {
            Logger.getLogger(Parameters.class.getName()).log(Level.SEVERE, null, ex);
        }
        return lista;
        
    }
    
    
    
    
    
}
