package start;

import Gestion.Conexion;
import java.io.IOException;
import javafx.application.Application;
import static javafx.application.Application.launch;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;
import javax.swing.Box;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPasswordField;

public class Bases_de_datos extends Application{

    private static String pass;
    
    public static void main(String[] args) {
        
        //conexion con MYSQL
        pass = getPassword(); 
        System.out.println(pass);
        Conexion conexion = new Conexion(pass);
        conexion.conectar();
        launch(args);
    }

    

    @Override
    public void start(Stage ventana) throws IOException {
        Parent root = FXMLLoader.load(getClass().getResource("/vista/Home.fxml")); // Arma la ventana con el código XML
        Scene scene = new Scene(root);
        ventana.setScene(scene);

        ventana.setTitle("Base de Datos world");
        ventana.setResizable(false); // no permite redimensionar la ventana

        //ventana.setOnCloseRequest(event -> {event.consume();}); //deshabilita la X de cerrar...
        ventana.show();
    }
    
    private static String getPassword() {
        JPasswordField pass = new JPasswordField() ;
        JLabel jl = new JLabel("Ingrese su contraseña para conectar con SQL: ");
        Box box = Box.createVerticalBox();
        box.add(jl);
        box.add(pass);
        
        int x = JOptionPane.showConfirmDialog(null, box, "Password", JOptionPane.OK_CANCEL_OPTION);
        
        if (x == JOptionPane.OK_OPTION){
            return pass.getText();
        }
        return null;
      }
    
    
    public static String getPass() {
        return pass;
    }

}


