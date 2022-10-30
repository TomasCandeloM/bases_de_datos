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
public class Lenguage {
    private String countrycode;
    private String language;
    private boolean isofficial;
    private int percentage;

    public Lenguage(String countrycode, String language, boolean isofficial, int percentage) {
        this.countrycode = countrycode;
        this.language = language;
        this.isofficial = isofficial;
        this.percentage = percentage;
    }

    public String getCountrycode() {
        return countrycode;
    }

    public void setCountrycode(String countrycode) {
        this.countrycode = countrycode;
    }

    public String getLanguage() {
        return language;
    }

    public void setLanguage(String language) {
        this.language = language;
    }

    public boolean isIsofficial() {
        return isofficial;
    }

    public void setIsofficial(boolean isofficial) {
        this.isofficial = isofficial;
    }

    public int getPercentage() {
        return percentage;
    }

    public void setPercentage(int percentage) {
        this.percentage = percentage;
    }
    
    public static ObservableList<Lenguage> llenarInformacionLenguage(Connection connection, ObservableList<Lenguage> lista, String sql){
        
        try {
            Statement instruccion = connection.createStatement();
            ResultSet resultado = instruccion.executeQuery(sql);
            
            while (resultado.next()){
                lista.add(new Lenguage(resultado.getString("countrycode"), resultado.getString("language"), resultado.getBoolean("isofficial"),resultado.getInt("percentage")));
             
            }
            
        } catch (SQLException ex) {
            Logger.getLogger(Parameters.class.getName()).log(Level.SEVERE, null, ex);
        }
        return lista;
        
    }
    
}
