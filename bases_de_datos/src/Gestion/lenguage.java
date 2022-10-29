/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Gestion;

/**
 *
 * @author tomas
 */
public class lenguage {
    private String countrycode;
    private String name;
    private String isofficial;
    private String percentaje;

    public lenguage(String countrycode, String name, String isofficial, String percentaje) {
        this.countrycode = countrycode;
        this.name = name;
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
    
    
    
}
