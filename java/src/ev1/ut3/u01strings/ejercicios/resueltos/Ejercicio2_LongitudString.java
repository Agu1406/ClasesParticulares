package ev1.ut3.u01strings.ejercicios.resueltos;

/**
 * Ejercicio 2: Longitud de un string
 * Crea un string y muestra su longitud por pantalla usando la funcion length()
 * 
 * @author Agustin. A. Marquez. Pina
 * @since 14/06/2025
 * @see <a href="mailto:agu1406@outlook.es">agu1406@outlook.es</a>
 * @see <a href="https://github.com/Agu1406/ClasesParticulares">Repositorio GitHub</a>
 * @see <a href="https://www.agustinmarquez.dev">Sitio web</a>
 */
public class Ejercicio2_LongitudString {
    public static void main(String[] args) {
        // Crear un string
        String texto = "Programacion en Java";
        
        // Obtener la longitud usando length()
        int longitud = texto.length();
        
        // Mostrar la longitud
        System.out.println("El texto \"" + texto + "\" tiene " + longitud + " caracteres");
        
        // Tambien se puede usar directamente en el println
        System.out.println("Longitud: " + texto.length());
    }
}
