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
public class City {
    private int code;
    private String name;
    private String countrycode;
    private String district;
    private int population;

    public City(int code, String name, String countrycode, String district, int population) {
        this.code = code;
        this.name = name;
        this.countrycode = countrycode;
        this.district = district;
        this.population = population;
    }
    
    
    
    public int getCode() {
        return code;
    }

    public void setCode(int code) {
        this.code = code;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getCountrycode() {
        return countrycode;
    }

    public void setCountrycode(String countrycode) {
        this.countrycode = countrycode;
    }
    
    

    public String getDistrict() {
        return district;
    }

    public void setDistrict(String district) {
        this.district = district;
    }

    public int getPopulation() {
        return population;
    }

    public void setPopulation(int population) {
        this.population = population;
    }
    
    public static void llenarInformacionCity(Connection connection, ObservableList<City> lista, String sql){
        
        try {
            Statement instruccion = connection.createStatement();
            ResultSet resultado = instruccion.executeQuery(sql);
            
            while (resultado.next()){
             lista.add( new City(resultado.getInt("code"), resultado.getString("name"), resultado.getString("countrycode"), resultado.getString("distric"), resultado.getInt("population")));
                
                
            }
            
        } catch (SQLException ex) {
            Logger.getLogger(Parameters.class.getName()).log(Level.SEVERE, null, ex);
        }
        
    }
    
    
}
