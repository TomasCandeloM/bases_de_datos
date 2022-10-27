/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/javafx/FXMLController.java to edit this template
 */
package Control;

import Gestion.Conexion;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Connection;
import java.net.URL;
import java.sql.SQLException;
import java.util.Optional;
import java.util.ResourceBundle;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Alert;
import javafx.scene.control.Button;
import javafx.scene.control.ButtonType;
import javafx.scene.control.CheckBox;
import javafx.scene.control.ComboBox;
import javafx.scene.control.TextField;
import javafx.stage.StageStyle;

/**
 * FXML Controller class
 *
 * @author tomas
 */
public class HomeController implements Initializable {
    
    Conexion cc = new Conexion();
    Connection con =cc.conectar();

    @FXML
    private CheckBox cbPpopulation;
    @FXML
    private CheckBox cbPRegion;
    @FXML
    private CheckBox cbPSurfacearea;
    @FXML
    private CheckBox cbPContinent;
    @FXML
    private CheckBox cbPGovernmentform;
    @FXML
    private CheckBox cbPSurfacearea1;
    @FXML
    private CheckBox cbCcountrycode;
    @FXML
    private CheckBox cbCpopulation1;
    @FXML
    private CheckBox cbCdistrict;
    @FXML
    private CheckBox cbLlanguage;
    @FXML
    private CheckBox cbLisoficial;
    @FXML
    private CheckBox cbPheadofstate;
    @FXML
    private TextField txt_Cid;
    @FXML
    private TextField txt_Cname;
    @FXML
    private TextField txt_Ccountrycode;
    @FXML
    private TextField txt_Cdistrict;
    @FXML
    private TextField txt_Cpopulation;
    @FXML
    private Button btnINSERTcity;
    @FXML
    private CheckBox chb_Lisofficial;
    @FXML
    private TextField txt_Lcountrycode;
    @FXML
    private TextField txt_Llanguage;
    @FXML
    private Button btn_addLanguage;
    @FXML
    private TextField txt_Lpercentage;
    @FXML
    private TextField txt_Pcode;
    @FXML
    private TextField txt_Pname;
    @FXML
    private TextField txt_Pregion;
    @FXML
    private TextField txt_Psurface;
    @FXML
    private TextField txt_PindepYear;
    @FXML
    private TextField txt_Ppopulation;
    @FXML
    private TextField txt_lPifeExpentacy;
    @FXML
    private TextField txt_Pganp;
    @FXML
    private TextField txt_PgnpOld;
    @FXML
    private TextField txt_PlocalName;
    @FXML
    private TextField txt_Pgovernmentform;
    @FXML
    private TextField txt_PheadofState;
    @FXML
    private TextField txt_Pcapital;
    @FXML
    private TextField txt_Pcode2;
    @FXML
    private Button btn_addCountry;
    @FXML
    private ComboBox<String> cbx_continent;
    @FXML
    private TextField txt_EPcode;
    @FXML
    private Button btn_deleteCountry;
    @FXML
    private TextField txt_ECid;
    @FXML
    private Button btn_DeleteCity;
    @FXML
    private TextField txt_ELcode;
    @FXML
    private TextField txt_ELlanguage;
    @FXML
    private Button btn_DeleteLanguage;

    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        // TODO
       this.llenarCombos();
    }    

    
 // Metodos de añadir a las bases de datos
    
    //añdir ciudad
    @FXML
    private void Add_city(ActionEvent event) {
        int Id = 0,population = 0;
        String countrycode,name,district,id = "",poblacion = "",mesg;
        boolean ok =false;
        
        id= this.txt_Cid.getText();
        poblacion = this.txt_Cpopulation.getText();
        countrycode = this.txt_Ccountrycode.getText();
        name=this.txt_Cname.getText();
        district = this.txt_Cdistrict.getText();
        
         try {
            Id = Integer.parseInt(id);
            population = Integer.parseInt(poblacion);
        } catch (NumberFormatException e) {
            mesg = "Debe ingresar un ID válido";
            this.showMessages(mesg, 1);
            ok = true;
        }
         
        try {
            population = Integer.parseInt(poblacion);
        } catch (NumberFormatException e) {
            mesg = "Debe ingresar una población válida";
            this.showMessages(mesg, 1);
            ok = true;
        }
         
        try {
           if (id.equals("") || poblacion.equals("") || countrycode.equals("") || name.equals("") || district.equals("")) {
               mesg = "faltan datos por ingresar";
               this.showMessages(mesg, 1);
            } else {
               String sql = "insert into city (ID,Name,CountryCode,District,Population) values ('"+Id+"','" + name + "','" + countrycode + "','" + district + "','" + population + "')";
               
               PreparedStatement pst = con.prepareStatement(sql);
               pst.execute();
               mesg="registro exitoso";
               this.showMessages(mesg, 2);
           }
        } catch (SQLException e) {
            mesg = "el codigo del pais ya existe, vefifique y vuelva a intentar";
            this.showMessages(mesg, 1);
        }            
    }
    
    //añadir lenguaje
    @FXML
    private void Add_language(ActionEvent event){
        float percentage = 0;
        String countrycode,language,porcentaje = "",mesg ,isOfficial;
        boolean esOfficial =false;
        
        porcentaje = this.txt_Lpercentage.getText();
        countrycode = this.txt_Lcountrycode.getText();
        language=this.txt_Llanguage.getText();
        
        if (this.chb_Lisofficial.isSelected()) {
                    esOfficial = true;
                }
        
        if (esOfficial=true){
            isOfficial = "F";
        } else{
            isOfficial = "T";
        }
         
        try {
            percentage = Float.parseFloat(porcentaje);
        } catch (NumberFormatException e) {
            mesg = "Debe ingresar un porcentaje válido";
            this.showMessages(mesg, 1);
        }
         
        try {
           if (porcentaje.equals("") || countrycode.equals("") || language.equals("") ) {
               mesg = "faltan datos por ingresar";
               this.showMessages(mesg, 1);
            } else {
               String sql = "insert into countrylanguage (CountryCode,Language,IsOfficial,Percentage) values ('"+countrycode+"','" + language + "','" + isOfficial + "','" + percentage + "')";
               
               PreparedStatement pst = con.prepareStatement(sql);
               pst.execute();
               mesg="registro exitoso";
               this.showMessages(mesg, 2);
               
               this.txt_Lcountrycode.setText("");
               this.txt_Llanguage.setText("");
               this.txt_Lpercentage.setText("");
               this.chb_Lisofficial.setSelected(false);
           }
        } catch (SQLException e) {
            mesg = "Tanto el codigo del pais como el idioma ya existen juntos, vefifique y vuelva a intentar";
            this.showMessages(mesg, 1);
        }            
    }
    
    // añadir pais
    @FXML
    private void Add_country(ActionEvent event) {
        String code,name,continent,region,superficie,añoIndependencia,poblacion,espectativadevida,gnp,gnpviejo,LocalName,GovernmentForm,HeadOfState,capital,code2,mesg="";
        float surfaceArea = 0,LifeExpentacy= 0,GNP=0, GNPOld=0;
        int IndepYear=0,Population=0,Capital=0;
        
        
        //declarar los valores
        code = this.txt_Pcode.getText();
        name = this.txt_Pname.getText();
        region = this.txt_Pregion.getText();
        LocalName = this.txt_PlocalName.getText();
        GovernmentForm = this.txt_Pgovernmentform.getText();
        HeadOfState = this.txt_PheadofState.getText();
        code2 = this.txt_Pcode2.getText();
        continent = this.cbx_continent.getSelectionModel().getSelectedItem();
        
        espectativadevida = this.txt_lPifeExpentacy.getText();
        gnp = this.txt_Pganp.getText();
        gnpviejo = this.txt_PgnpOld.getText();
        superficie = this.txt_Psurface.getText();
        añoIndependencia = this.txt_PindepYear.getText();
        poblacion = this.txt_Ppopulation.getText();
        capital = this.txt_Pcapital.getText();
        
        //validacion de que los cambos sean numericos
         try {
            LifeExpentacy = Float.parseFloat(espectativadevida);
            surfaceArea = Float.parseFloat(superficie);
            GNP = Float.parseFloat(gnp);
            GNPOld = Float.parseFloat(gnpviejo);
            IndepYear = Integer.parseInt(añoIndependencia);
            Population = Integer.parseInt(poblacion);
            Capital = Integer.parseInt(capital); 
            
        } catch (NumberFormatException e) {
            mesg = "Uno de los valores no esta en el formato correcto, por favor corregir";
            this.showMessages(mesg, 1);
        }
         
        
          try {
           if (code.equals("") || poblacion.equals("") || region.equals("") || name.equals("") || LocalName.equals("")|| 
               GovernmentForm.equals("")|| HeadOfState.equals("")|| code2.equals("")|| continent.equals("")|| 
               espectativadevida.equals("")|| gnp.equals("")|| gnpviejo.equals("")|| superficie.equals("")|| añoIndependencia.equals("")|| capital.equals("")) {
               mesg = "faltan datos por ingresar";
               this.showMessages(mesg, 1);
            } else {
               String sql = "insert into country (Code,Name,Continent,Region,SurfaceArea,IndepYear,Population,LifeExpectancy,GNP,GNPOld,LocalName,GovernmentForm,HeadOfState,Capital,Code2) values ('"
               +code+"','" + name + "','" + continent + "','" + region + "','" + surfaceArea + "','" + IndepYear + "','" + Population
               + "','" + LifeExpentacy+ "','" + GNP+ "','" + GNPOld+ "','" + LocalName+ "','" + GovernmentForm+ "','" + HeadOfState
               + "','" + Capital + "','" + code2 +"')";
               
               PreparedStatement pst = con.prepareStatement(sql);
               pst.execute();
               mesg="registro exitoso";
               this.showMessages(mesg, 2);
           }
        } catch (SQLException e) {
            mesg = "el codigo del pais ya existe, vefifique y vuelva a intentar";
            this.showMessages(mesg, 1);
        }            
    
         
         
    }
    
// Metodos de eliminar datos
    
    //eliminar Pais
    @FXML
    private void Delete_Country(ActionEvent event) {
    }

    //Eliminar Ciudad
    @FXML
    private void Delete_City(ActionEvent event) {
    }

    //Eliminar Lenguaje
    @FXML
    private void Delete_Laguage(ActionEvent event) {
    }

//metodos extra
    
    //metodo para mostrar mensajes
     private boolean showMessages(String mesg, int caso) {
        Alert msg;
        boolean ok = false;

        if (caso == 1) {
            msg = new Alert(Alert.AlertType.ERROR);
            msg.setTitle("ERROR");
            msg.setHeaderText(null);
            msg.setContentText(mesg);
            msg.showAndWait();
        }
        if (caso == 2) {
            msg = new Alert(Alert.AlertType.INFORMATION);
            msg.setTitle("INFORMACIÓN");
            msg.setHeaderText(null);
            msg.setContentText(mesg);
            msg.showAndWait();
        }
        if (caso == 3) {
            msg = new Alert(Alert.AlertType.CONFIRMATION);
            msg.setTitle("PETICIÓN CONFIRMACIÓN");
            msg.setHeaderText(null);
            msg.setContentText(mesg);
            msg.initStyle(StageStyle.UTILITY);

            Optional<ButtonType> result = msg.showAndWait();
            if (result.get() == ButtonType.OK) {
                ok = true;
            }
        }
        return ok;
       }

    //lenar combo box
     
     private void llenarCombos(){
         this.cbx_continent.getItems().clear();
         
         this.cbx_continent.getItems().add("Asia");
         this.cbx_continent.getItems().add("Europe");
         this.cbx_continent.getItems().add("North America");
         this.cbx_continent.getItems().add("AFrica");
         this.cbx_continent.getItems().add("Oceania");
         this.cbx_continent.getItems().add("Antartica");
         this.cbx_continent.getItems().add("South America");
     }


}
