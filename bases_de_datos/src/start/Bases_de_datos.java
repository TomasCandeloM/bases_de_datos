package start;

import Gestion.Conexion;
import java.io.IOException;
import javafx.application.Application;
import static javafx.application.Application.launch;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;

public class Bases_de_datos extends Application{

    public static void main(String[] args) {
        
        //conexion con MYSQL
        Conexion conexion = new Conexion();
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

        ventana.setOnCloseRequest(event -> {event.consume();}); //deshabilita la X de cerrar...
        ventana.show();
    }

}


