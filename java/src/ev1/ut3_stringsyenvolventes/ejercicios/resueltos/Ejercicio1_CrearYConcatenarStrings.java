package ev1.ut3_stringsyenvolventes.ejercicios.resueltos;

/**
 * Ejercicio 1: Crear y concatenar strings
 * Crea dos variables de tipo String, asignales valores y concatenalas mostrando el resultado por pantalla
 * 
 * @author Agustin. A. Marquez. Pina
 * @since 14/06/2025
 * @see <a href="mailto:agu1406@outlook.es">agu1406@outlook.es</a>
 * @see <a href="https://github.com/Agu1406/ClasesParticulares">Repositorio GitHub</a>
 * @see <a href="https://www.agustinmarquez.dev">Sitio web</a>
 */
public class Ejercicio1_CrearYConcatenarStrings {
    public static void main(String[] args) {
        // Crear dos variables de tipo String
        String nombre = "Juan";
        String apellido = "Perez";
        
        // Concatenar strings usando el operador +
        String nombreCompleto = nombre + " " + apellido;
        
        // Mostrar el resultado
        System.out.println("Nombre completo: " + nombreCompleto);
        
        // Tambien se puede concatenar directamente en el println
        System.out.println("Hola, " + nombre + " " + apellido);
    }
}
