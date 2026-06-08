package ev2.ut5_pooexcepcionesio.u04repaso.practicas.pruebaslibrescoleccion;

import java.util.ArrayList;
import java.util.List;

public class Ejercicio20_JDBC_JSON_ORM_JavaFX_RESUELTO {

    public static void main(String[] args) {
        System.out.println("Flujo JDBC:");
        for (String paso : flujoJDBC()) {
            System.out.println("- " + paso);
        }

        AlumnoEntidadR alumno = new AlumnoEntidadR(7, "Ana");
        System.out.println("JSON alumno: " + alumnoAJson(alumno));
        System.out.println("HQL: " + consultaHql());
        System.out.println("JavaFX minimo: " + componentesMinimosJavaFx());
    }

    static List<String> flujoJDBC() {
        List<String> pasos = new ArrayList<>();
        pasos.add("DriverManager obtiene Connection");
        pasos.add("Connection crea PreparedStatement");
        pasos.add("executeQuery/executeUpdate");
        pasos.add("Procesar ResultSet");
        pasos.add("Cerrar recursos");
        return pasos;
    }

    static String alumnoAJson(AlumnoEntidadR alumno) {
        return "{\"id\":" + alumno.getId() + ",\"nombre\":\"" + alumno.getNombre() + "\"}";
    }

    static String consultaHql() {
        return "from AlumnoEntidad a where a.id >= :minId";
    }

    static String componentesMinimosJavaFx() {
        return "Application, Stage, Scene y al menos un Control (Button/TextField).";
    }
}

class AlumnoEntidadR {
    private int id;
    private String nombre;

    AlumnoEntidadR(int id, String nombre) {
        this.id = id;
        this.nombre = nombre;
    }

    public int getId() {
        return id;
    }

    public String getNombre() {
        return nombre;
    }
}
