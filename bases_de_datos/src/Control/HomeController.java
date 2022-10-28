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
import java.util.ArrayList;
import java.util.List;
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
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.TextField;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.stage.StageStyle;

/**
 * FXML Controller class
 *
 * @author tomas
 */
public class HomeController implements Initializable {

    Conexion cc = new Conexion();
    Connection con = cc.conectar();

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
    @FXML
    private TextField txt_UCid;
    @FXML
    private TextField txt_UCcountrycode;
    @FXML
    private TextField txt_UCdistrict;
    @FXML
    private TextField txt_UCpopulation;
    @FXML
    private TextField txt_UCname;
    @FXML
    private Button btn_updateCity;
    @FXML
    private TextField txt_ULlanguage;
    @FXML
    private TextField txt_ULcountrycode;
    @FXML
    private Button btn_UpdateLanguage;
    @FXML
    private TextField txt_ULpercentage;
    @FXML
    private CheckBox chb_ULisofficial;
    @FXML
    private TextField txt_UPcode;
    @FXML
    private TextField txt_UPregion;
    @FXML
    private TextField txt_UPpopulation;
    @FXML
    private TextField txt_UPindepYear;
    @FXML
    private TextField txt_UPheadOfState;
    @FXML
    private TextField txt_UPgovernmentForm;
    @FXML
    private TextField txt_UPsurface;
    @FXML
    private ComboBox<String> cbx_UPcontinet;
    @FXML
    private Button btn_UpdateCountry;
    @FXML
    private ComboBox<String> cbx_Rcity;
    @FXML
    private ComboBox<String> cbx_Rcountry;
    @FXML
    private ComboBox<String> cbx_Rlanguage;
    @FXML
    private TextField txt_cityinfo;
    @FXML
    private TextField txt_Rcountryinfo;
    @FXML
    private TextField txt_countryLanguageinfo;
    @FXML
    private Button btn_Search_city;
    @FXML
    private Button btn_Search_country;
    @FXML
    private Button btn_Search_language;
    @FXML
    private TableColumn<?, ?> CLcode;
    @FXML
    private TableColumn<?, ?> CLcountryName;
    @FXML
    private TableColumn<?, ?> CLcountryPopulation;
    @FXML
    private TableColumn<?, ?> CLheadOfState;
    @FXML
    private TableColumn<?, ?> CLregion;
    @FXML
    private TableColumn<?, ?> CLcontinent;
    @FXML
    private TableColumn<?, ?> CLindepYear;
    @FXML
    private TableColumn<?, ?> CLsurface;
    @FXML
    private TableColumn<?, ?> CLgovernmentForm;
    @FXML
    private TableColumn<?, ?> CLid;
    @FXML
    private TableColumn<?, ?> CLcityName;
    @FXML
    private TableColumn<?, ?> CLcityPopulation;
    @FXML
    private TableColumn<?, ?> CLdistrict;
    @FXML
    private TableColumn<?, ?> CLlanguage;
    @FXML
    private TableColumn<?, ?> CLisOfficial;
    @FXML
    private TableColumn<?, ?> CLpercentage;
    @FXML
    private TableView<?> tbl_busqueda;

    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        // TODO
        this.modelarTabla();
        this.llenarCombos();
    }

    // Metodos de añadir a las bases de datos
    //añdir ciudad
    @FXML
    private void Add_city(ActionEvent event) {
        int Id = 0, population = 0;
        String countrycode, name, district, id = "", poblacion = "", mesg;
        boolean ok = false;

        id = this.txt_Cid.getText();
        poblacion = this.txt_Cpopulation.getText();
        countrycode = this.txt_Ccountrycode.getText();
        name = this.txt_Cname.getText();
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
                String sql = "insert into city (ID,Name,CountryCode,District,Population) values ('" + Id + "','" + name + "','" + countrycode + "','" + district + "','" + population + "')";

                PreparedStatement pst = con.prepareStatement(sql);
                pst.execute();
                mesg = "registro exitoso";
                this.showMessages(mesg, 2);

                this.txt_Cid.setText("");
                this.txt_Cpopulation.setText("");
                this.txt_Ccountrycode.setText("");
                this.txt_Cname.setText("");
                this.txt_Cdistrict.setText("");

            }
        } catch (SQLException e) {
            mesg = "el codigo del pais ya existe o no ha sido creado, vefique y vuelva a intentar";
            this.showMessages(mesg, 1);
        }
    }

    //añadir lenguaje
    @FXML
    private void Add_language(ActionEvent event) {
        float percentage = 0;
        String countrycode, language, porcentaje = "", mesg, isOfficial;
        boolean esOfficial = false;

        porcentaje = this.txt_Lpercentage.getText();
        countrycode = this.txt_Lcountrycode.getText();
        language = this.txt_Llanguage.getText();

        if (this.chb_Lisofficial.isSelected()) {
            esOfficial = true;
        }

        if (esOfficial = true) {
            isOfficial = "F";
        } else {
            isOfficial = "T";
        }

        try {
            percentage = Float.parseFloat(porcentaje);
        } catch (NumberFormatException e) {
            mesg = "Debe ingresar un porcentaje válido";
            this.showMessages(mesg, 1);
        }

        try {
            if (porcentaje.equals("") || countrycode.equals("") || language.equals("")) {
                mesg = "faltan datos por ingresar";
                this.showMessages(mesg, 1);
            } else {
                String sql = "insert into countrylanguage (CountryCode,Language,IsOfficial,Percentage) values ('" + countrycode + "','" + language + "','" + isOfficial + "','" + percentage + "')";

                PreparedStatement pst = con.prepareStatement(sql);
                pst.execute();
                mesg = "registro exitoso";
                this.showMessages(mesg, 2);

                this.txt_Lcountrycode.setText("");
                this.txt_Llanguage.setText("");
                this.txt_Lpercentage.setText("");
                this.chb_Lisofficial.setSelected(false);
            }
        } catch (SQLException e) {
            mesg = "Tanto el codigo del pais como el idioma ya existen juntos o el pais aun no ha sido creado, vefifique y vuelva a intentar";
            this.showMessages(mesg, 1);
        }
    }

    // añadir pais
    @FXML
    private void Add_country(ActionEvent event) {
        String code, name, continent, region, superficie, añoIndependencia, poblacion, espectativadevida, gnp, gnpviejo, LocalName, GovernmentForm, HeadOfState, capital, code2, mesg = "";
        float surfaceArea = 0, LifeExpentacy = 0, GNP = 0, GNPOld = 0;
        int IndepYear = 0, Population = 0, Capital = 0;

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
            if (code.equals("") || poblacion.equals("") || region.equals("") || name.equals("") || LocalName.equals("")
                    || GovernmentForm.equals("") || HeadOfState.equals("") || code2.equals("") || continent.equals("")
                    || espectativadevida.equals("") || gnp.equals("") || gnpviejo.equals("") || superficie.equals("") || añoIndependencia.equals("") || capital.equals("")) {
                mesg = "faltan datos por ingresar";
                this.showMessages(mesg, 1);
            } else {
                String sql = "insert into country (Code,Name,Continent,Region,SurfaceArea,IndepYear,Population,LifeExpectancy,GNP,GNPOld,LocalName,GovernmentForm,HeadOfState,Capital,Code2) values ('"
                        + code + "','" + name + "','" + continent + "','" + region + "','" + surfaceArea + "','" + IndepYear + "','" + Population
                        + "','" + LifeExpentacy + "','" + GNP + "','" + GNPOld + "','" + LocalName + "','" + GovernmentForm + "','" + HeadOfState
                        + "','" + Capital + "','" + code2 + "')";

                PreparedStatement pst = con.prepareStatement(sql);
                pst.execute();
                mesg = "registro exitoso";
                this.showMessages(mesg, 2);

                this.txt_Pcode.setText("");
                this.txt_Pname.setText("");
                this.txt_Pregion.setText("");
                this.txt_PlocalName.setText("");
                this.txt_Pgovernmentform.setText("");
                this.txt_PheadofState.setText("");
                this.txt_Pcode2.setText("");
                this.txt_lPifeExpentacy.setText("");
                this.txt_Pganp.setText("");
                this.txt_PgnpOld.setText("");
                this.txt_Psurface.setText("");
                this.txt_PindepYear.setText("");
                this.txt_Ppopulation.setText("");
                this.txt_Pcapital.setText("");
                this.cbx_continent.setValue("");

            }
        } catch (SQLException e) {
            mesg = "Error en la actualización, vefifique y vuelva a intentar";
            this.showMessages(mesg, 1);
        }

    }

    // Metodos de editar datos
    //editar ciudad
    @FXML
    private void Update_city(ActionEvent event) {
        String id, Name, countryCode, District, poblacion, mesg = "";
        int ID = 0, Population = 0;

        id = this.txt_UCid.getText();
        Name = this.txt_UCname.getText();
        countryCode = this.txt_UCcountrycode.getText();
        District = this.txt_UCdistrict.getText();
        poblacion = this.txt_UCpopulation.getText();

        try {
            Population = Integer.parseInt(poblacion);
            ID = Integer.parseInt(id);
        } catch (NumberFormatException e) {
            mesg = "Debe ingresar un ID o una población válido";
            this.showMessages(mesg, 1);
        }

        try {
            if (id.equals("") || countryCode.equals("") || Name.equals("") || District.equals("") || poblacion.equals("")) {
                mesg = "faltan datos por ingresar";
                this.showMessages(mesg, 1);
            } else {
                String sql = "update city set Name ='" + Name + "',CountryCode ='" + countryCode + "',District ='" + District + "',Population ='" + Population + "' where Id like '%" + ID + "%'";

                PreparedStatement pst = con.prepareStatement(sql);

                pst.execute();
                mesg = "Actualización exitosa";
                this.showMessages(mesg, 2);

                this.txt_UCid.setText("");
                this.txt_UCname.setText("");
                this.txt_UCcountrycode.setText("");
                this.txt_UCdistrict.setText("");
                this.txt_UCpopulation.setText("");

            }
        } catch (SQLException e) {
            mesg = "Error en la actualización, vefifique y vuelva a intentar";
            this.showMessages(mesg, 1);
        }
    }

    //editar lenguaje
    @FXML
    private void Update_Language(ActionEvent event) {
        String countryCode, Language, porcentaje, IsOfficial, mesg = "";
        float Percentage = 0;
        boolean EsOfficial = false;

        countryCode = this.txt_ULcountrycode.getText();
        Language = this.txt_ULlanguage.getText();
        porcentaje = this.txt_ULpercentage.getText();

        if (this.chb_ULisofficial.isSelected()) {
            EsOfficial = true;
        }

        if (EsOfficial = true) {
            IsOfficial = "F";
        } else {
            IsOfficial = "T";
        }

        try {
            Percentage = Float.parseFloat(porcentaje);
        } catch (NumberFormatException e) {
            mesg = "Debe ingresar un porcentaje válido";
            this.showMessages(mesg, 1);
        }

        try {
            if (porcentaje.equals("") || countryCode.equals("") || Language.equals("")) {
                mesg = "faltan datos por ingresar";
                this.showMessages(mesg, 1);
            } else {
                String sql = "update countrylanguage set IsOfficial ='" + IsOfficial + "',Percentage ='" + Percentage + "' where countrycode like '%" + countryCode + "%' and language like '%" + Language + "%'";

                PreparedStatement pst = con.prepareStatement(sql);

                pst.execute();
                mesg = "Actualización exitosa";
                this.showMessages(mesg, 2);

                this.txt_ULcountrycode.setText("");
                this.txt_ULlanguage.setText("");
                this.txt_ULpercentage.setText("");
                this.chb_ULisofficial.setSelected(false);
            }
        } catch (SQLException e) {
            mesg = "Tanto el codigo del pais como el idioma ya existen juntos, vefifique y vuelva a intentar";
            this.showMessages(mesg, 1);
        }

    }

    //editar pais
    @FXML
    private void Update_Country(ActionEvent event) {
        String code, Region, GovernmentForm, superficie, HeadOfState, añoindependencia, poblacion, continent, mesg = "";
        float Surface = 0;
        int IndepYear = 0, Population = 0;

        code = this.txt_UPcode.getText();
        Region = this.txt_UPregion.getText();
        GovernmentForm = this.txt_UPgovernmentForm.getText();
        superficie = this.txt_UPsurface.getText();
        HeadOfState = this.txt_UPheadOfState.getText();
        añoindependencia = this.txt_UPindepYear.getText();
        poblacion = this.txt_UPpopulation.getText();
        continent = this.cbx_UPcontinet.getSelectionModel().getSelectedItem();

        try {
            Surface = Float.parseFloat(superficie);
            IndepYear = Integer.parseInt(añoindependencia);
            Population = Integer.parseInt(poblacion);

        } catch (NumberFormatException e) {
            mesg = "Uno de los valores no esta en el formato correcto, por favor corregir";
            this.showMessages(mesg, 1);
        }

        try {
            if (code.equals("") || Region.equals("") || GovernmentForm.equals("") || superficie.equals("") || HeadOfState.equals("") || añoindependencia.equals("") || poblacion.equals("") || continent.equals("")) {
                mesg = "faltan datos por ingresar";
                this.showMessages(mesg, 1);
            } else {
                String sql = "update country set continent ='" + continent + "',region ='" + Region + "', SurfaceArea ='" + Surface + "',IndepYear ='" + IndepYear + "', Population ='" + Population + "', GovernmentForm ='" + GovernmentForm + "',HeadOfState ='" + HeadOfState + "' where code like '%" + "%'";

                PreparedStatement pst = con.prepareStatement(sql);
                pst.execute();

                mesg = "Actualización exitosa";
                this.showMessages(mesg, 2);

                this.txt_UPcode.setText("");
                this.txt_UPregion.setText("");
                this.txt_UPgovernmentForm.setText("");
                this.txt_UPsurface.setText("");
                this.txt_UPheadOfState.setText("");
                this.txt_UPindepYear.setText("");
                this.txt_UPpopulation.setText("");
                this.cbx_UPcontinet.setValue("");

            }
        } catch (SQLException e) {
            mesg = "Error en la actualización, vefifique y vuelva a intentar";
            this.showMessages(mesg, 1);
        }

    }

// Metodos de eliminar datos
    //eliminar Pais
    @FXML
    private void Delete_Country(ActionEvent event) {
        String code, mesg;
        boolean ok;

        code = this.txt_EPcode.getText();

        try {
            if (code.equals("")) {
                mesg = "codigo del pais no ingresado";
                this.showMessages(mesg, 1);
            } else {
                mesg = "Confirma que desea eliminar el pais?";
                ok = this.showMessages(mesg, 3);

                if (ok) {
                    String sql = "delete from country where code like '%" + code + "%'";
                    PreparedStatement pst = con.prepareStatement(sql);
                    pst.execute();
                    mesg = "Pais eliminado";
                    this.showMessages(mesg, 2);

                    this.txt_EPcode.setText("");
                }
            }
        } catch (SQLException e) {
            mesg = "Error en los datos ingresados, verifique e intente de nuevo";
            this.showMessages(mesg, 1);
        }
    }

    //Eliminar Ciudad
    @FXML
    private void Delete_City(ActionEvent event) {
        String ID, mesg;
        int id = 0;
        boolean ok;

        ID = this.txt_ECid.getText();

        try {
            id = Integer.parseInt(ID);
        } catch (NumberFormatException e) {
            mesg = "Debe ingresar un ID válido";
            this.showMessages(mesg, 1);
            ok = true;
        }

        try {
            if (ID.equals("")) {
                mesg = "ID de la ciudad no ingresado";
                this.showMessages(mesg, 1);
            } else {
                mesg = "Confirma que desea eliminar la ciudad?";
                ok = this.showMessages(mesg, 3);

                if (ok) {
                    String sql = "delete from city where id like '%" + id + "%'";
                    PreparedStatement pst = con.prepareStatement(sql);
                    pst.execute();
                    mesg = "Ciudad eliminado";
                    this.showMessages(mesg, 2);
                    this.txt_ECid.setText("");

                }
            }
        } catch (SQLException e) {
            mesg = "Error en los datos ingresados, verifique e intente de nuevo";
            this.showMessages(mesg, 1);
        }

    }

    //Eliminar Lenguaje
    @FXML
    private void Delete_Laguage(ActionEvent event) {
        String CountryCode, language, mesg;
        boolean ok;

        CountryCode = this.txt_ELcode.getText();
        language = this.txt_ELlanguage.getText();

        try {
            if (CountryCode.equals("") || language.equals("")) {
                mesg = "Faltan datos por ingresar";
                this.showMessages(mesg, 1);
            } else {
                mesg = "Confirma que desea eliminar el lenguaje?";
                ok = this.showMessages(mesg, 3);

                if (ok) {
                    String sql = "delete from countrylanguage where countrycode like '%" + CountryCode + "%' and language like '%" + language + "%'";
                    PreparedStatement pst = con.prepareStatement(sql);
                    pst.execute();
                    mesg = "Lenguaje eliminado";
                    this.showMessages(mesg, 2);

                    this.txt_ELcode.setText("");
                    this.txt_ELlanguage.setText("");

                }
            }
        } catch (SQLException e) {
            mesg = "Error en los datos ingresados, verifique e intente de nuevo";
            this.showMessages(mesg, 1);
        }
    }

// metodos de busqueda 
    //buscar pais
    @FXML
    private void Search_country(ActionEvent event) {
    }

    // buscar ciudad
    @FXML
    private void Search_city(ActionEvent event) {

        String code, mesg;
        boolean ok, plob_City = false, dis_City = false;
        int i = 0;
        String str = "";

        List<String> ListParameters = new ArrayList<String>();

        code = this.txt_cityinfo.getText();
        try {
            if (code.equals("")) {
                mesg = "No deje el campo en blanco";
                this.showMessages(mesg, 1);
            } else {
                
                this.CLcityName.setVisible(true);
                this.CLid.setVisible(true);

                if (this.cbCdistrict.isSelected()) {
                    dis_City = true;
                    this.CLdistrict.setVisible(true);
                }

                if (this.cbCpopulation1.isSelected()) {
                    plob_City = true;
                    this.CLcityPopulation.setVisible(true);
                }

                ListParameters.add("id, name");

                if (dis_City = true) {
                    ListParameters.add("district");
                }
                if (plob_City = true) {
                    ListParameters.add("poblation");
                }
                
		for (String parameter : ListParameters) {
                    if (i == ListParameters.size()){
                        str+= parameter;
                    }
                    else{
                        str+= parameter+",";
                    }
			
		}

                String sql = "select " + str + " from city where id like '" + code + "%' or name like '" + code + "%'";
                PreparedStatement pst = con.prepareStatement(sql);
                pst.execute();

                this.txt_cityinfo.setText("");
            }
        } catch (SQLException e) {
            mesg = "Error en los datos ingresados, verifique e intente de nuevo";
            this.showMessages(mesg, 1);
        }
    }

    //buscar lenguage
    @FXML
    private void Search_language(ActionEvent event) {String mesg,info, code;
        
        boolean ok,Iso_Lan,por_Lan;
        
        List<String> ListParameters = new ArrayList<String>();
        
        code = this.txt_countryLanguageinfo.getText();
        por_Lan = this.cbLlanguage.isSelected();
        Iso_Lan = this.cbLisoficial.isSelected();
        
        try {
           if (code.equals("")) {
               mesg = "No deje el campo en blanco";
               this.showMessages(mesg, 1);
            } else{
               
               ListParameters.add("CountryCode, Language");
               
               if (por_Lan = true){
                   ListParameters.add("IsOfficial");
               } 
               if (Iso_Lan = true){
                   ListParameters.add("Percentage");
               }
               
               String sql = "select "+ListParameters+" from countrylanguage where countrycode like '"+code+"%' or language like '"+code+"%'";
               PreparedStatement pst = con.prepareStatement(sql);
               pst.execute();
               
               this.txt_countryLanguageinfo.setText("");
           }
        } catch (SQLException e) {
            mesg = "Error en los datos ingresados, verifique e intente de nuevo";
            this.showMessages(mesg, 1);
        }

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
    private void llenarCombos() {
        this.cbx_continent.getItems().clear();

        this.cbx_continent.getItems().add("Asia");
        this.cbx_continent.getItems().add("Europe");
        this.cbx_continent.getItems().add("North America");
        this.cbx_continent.getItems().add("AFrica");
        this.cbx_continent.getItems().add("Oceania");
        this.cbx_continent.getItems().add("Antartica");
        this.cbx_continent.getItems().add("South America");

        this.cbx_UPcontinet.getItems().clear();
        this.cbx_UPcontinet.getItems().add("Asia");
        this.cbx_UPcontinet.getItems().add("Europe");
        this.cbx_UPcontinet.getItems().add("North America");
        this.cbx_UPcontinet.getItems().add("Africa");
        this.cbx_UPcontinet.getItems().add("Oceania");
        this.cbx_UPcontinet.getItems().add("Antartica");
        this.cbx_UPcontinet.getItems().add("South America");

        this.cbx_Rlanguage.getItems().clear();
        this.cbx_Rlanguage.getItems().add("Codigo del pais");
        this.cbx_Rlanguage.getItems().add("Idioma");

        this.cbx_Rcity.getItems().clear();
        this.cbx_Rcity.getItems().add("Id");
        this.cbx_Rcity.getItems().add("Nombre");

        this.cbx_Rcountry.getItems().clear();
        this.cbx_Rcountry.getItems().add("Codigo");
        this.cbx_Rcountry.getItems().add("Nombre");

    }

    //modelaar tabla
    private void modelarTabla() {
        this.CLcode.setCellValueFactory(new PropertyValueFactory("Codigo del Pais"));
        this.CLcityName.setCellValueFactory(new PropertyValueFactory("Nombre de la ciudad"));
        this.CLcityPopulation.setCellValueFactory(new PropertyValueFactory("Poblacion de la ciudad"));
        this.CLcontinent.setCellValueFactory(new PropertyValueFactory("Continente"));
        this.CLcountryName.setCellValueFactory(new PropertyValueFactory("Nombre del pais"));
        this.CLcountryPopulation.setCellValueFactory(new PropertyValueFactory("Población del pais"));
        this.CLdistrict.setCellValueFactory(new PropertyValueFactory("Distrito"));
        this.CLgovernmentForm.setCellValueFactory(new PropertyValueFactory("Forma de gobierno"));
        this.CLheadOfState.setCellValueFactory(new PropertyValueFactory("Presidente"));
        this.CLid.setCellValueFactory(new PropertyValueFactory("Id de la ciudad"));
        this.CLindepYear.setCellValueFactory(new PropertyValueFactory("año de independencia"));
        this.CLisOfficial.setCellValueFactory(new PropertyValueFactory("Es oficial?"));
        this.CLlanguage.setCellValueFactory(new PropertyValueFactory("Lenguaje"));
        this.CLpercentage.setCellValueFactory(new PropertyValueFactory("Porcentaje"));
        this.CLregion.setCellValueFactory(new PropertyValueFactory("Region"));
        this.CLsurface.setCellValueFactory(new PropertyValueFactory("Superficie"));
    }

}
