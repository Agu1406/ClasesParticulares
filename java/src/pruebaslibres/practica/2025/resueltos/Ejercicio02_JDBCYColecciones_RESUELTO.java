package pruebaslibres.practica.y2025.resueltos;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class Ejercicio02_JDBCYColecciones_RESUELTO {

    public static void main(String[] args) {
        System.out.println("Flujo JDBC:");
        for (String paso : flujoJDBC()) {
            System.out.println("- " + paso);
        }
        System.out.println("Valor de clave dos: " + valorDosEnMapa());
    }

    public static List<String> flujoJDBC() {
        List<String> pasos = new ArrayList<>();
        pasos.add("DriverManager -> Connection");
        pasos.add("Connection -> Statement o PreparedStatement");
        pasos.add("executeQuery/executeUpdate");
        pasos.add("ResultSet en SELECT");
        pasos.add("Cerrar recursos");
        return pasos;
    }

    public static int valorDosEnMapa() {
        Map<String, Integer> map = new HashMap<>();
        map.put("uno", 1);
        map.put("dos", 2);
        map.put("tres", 3);
        map.put("dos", 22);
        map.put(null, 100);
        return map.get("dos");
    }
}

