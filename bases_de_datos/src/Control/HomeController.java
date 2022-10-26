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

    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        // TODO
       
    }    

    @FXML
    private void Add_city(ActionEvent event) throws SQLException {
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
        } catch (NumberFormatException e) {
            
        }            
    }
    
    
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
}
