package pruebaslibres.practica.coleccion.sin_resolver;

import java.util.ArrayList;
import java.util.List;

/**
 * Ejercicio integrador para practicar conceptos frecuentes de test.
 *
 * Preguntas relacionadas (orientativo):
 * - 2025: Q2, Q29, Q34 (JDBC) y preguntas de teoria aplicada.
 * - Temario especifico: JSON/GSON, ORM/Hibernate/HQL/@Entity y JavaFX.
 */
public class Ejercicio20_JDBC_JSON_ORM_JavaFX_SIN_RESOLVER {

    public static void main(String[] args) {
        // TODO 1: imprimir el orden correcto de pasos JDBC.
        // TODO 2: construir un JSON simple de alumno a mano (String).
        // TODO 3: devolver una consulta HQL basica para la entidad AlumnoEntidad.
        // TODO 4: listar componentes JavaFX minimos para una ventana.
    }

    static List<String> flujoJDBC() {
        return new ArrayList<>();
    }

    static String alumnoAJson(AlumnoEntidad alumno) {
        return "";
    }

    static String consultaHql() {
        return "";
    }

    static String componentesMinimosJavaFx() {
        return "";
    }
}

class AlumnoEntidad {
    private int id;
    private String nombre;

    AlumnoEntidad(int id, String nombre) {
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
