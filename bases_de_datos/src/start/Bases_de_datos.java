package start;

import Gestion.Conexion;

public class Bases_de_datos {

    public static void main(String[] args) {
        Conexion conexion = new Conexion();
        conexion.conectar();
    }

}
