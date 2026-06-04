package ev3.ut7.u05repaso.practicas.pruebaslibresrutareal232425;

import java.util.HashMap;
import java.util.Map;

public class EjercicioRR04_ColeccionesJDBCYFicheros_RESUELTO {

    public static void main(String[] args) {
        Map<String, Integer> mapa = new HashMap<>();
        mapa.put("dos", 2);
        mapa.put("dos", 22);
        System.out.println("map.get('dos') = " + mapa.get("dos"));

        System.out.println("Flujo JDBC:");
        System.out.println("1) DriverManager -> Connection");
        System.out.println("2) Connection -> Statement/PreparedStatement");
        System.out.println("3) executeQuery/executeUpdate");
        System.out.println("4) procesar ResultSet");
        System.out.println("5) cerrar recursos");

        System.out.println("Lectura bytes (superclase): InputStream");
        System.out.println("Lectura objetos serializados: ObjectInputStream");
        System.out.println("Fichero inexistente (apertura): FileNotFoundException");
    }
}
