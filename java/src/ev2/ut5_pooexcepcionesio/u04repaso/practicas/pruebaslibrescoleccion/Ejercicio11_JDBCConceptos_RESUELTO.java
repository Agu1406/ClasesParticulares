package ev2.ut5_pooexcepcionesio.u04repaso.practicas.pruebaslibrescoleccion;

public class Ejercicio11_JDBCConceptos_RESUELTO {

    public static void main(String[] args) {
        System.out.println("Flujo JDBC:");
        System.out.println("1) DriverManager obtiene una Connection.");
        System.out.println("2) Con la Connection se crea Statement o PreparedStatement.");
        System.out.println("3) Se ejecuta SQL (executeQuery / executeUpdate).");
        System.out.println("4) Si hay SELECT, se procesa ResultSet.");
        System.out.println("5) Se cierran recursos.");

        String sqlSelect = "SELECT id, nombre FROM alumnos WHERE nota >= ?";
        String sqlInsert = "INSERT INTO alumnos(nombre, nota) VALUES(?, ?)";
        System.out.println("SQL SELECT ejemplo: " + sqlSelect);
        System.out.println("SQL INSERT ejemplo: " + sqlInsert);
    }
}
