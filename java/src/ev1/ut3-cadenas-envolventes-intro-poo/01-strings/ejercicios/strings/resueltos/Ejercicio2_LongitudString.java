package general.strings.resueltos;

/**
 * Ejercicio 2: Longitud de un string
 * Crea un string y muestra su longitud por pantalla usando la función length()
 * 
 * @author Agustín. A. Marquez. Piña
 * @since 14/06/2025
 * @see <a href="mailto:agu1406@outlook.es">agu1406@outlook.es</a>
 * @see <a href="https://github.com/Agu1406/ClasesParticulares">Repositorio GitHub</a>
 * @see <a href="https://www.agustinmarquez.dev">Sitio web</a>
 */
public class Ejercicio2_LongitudString {
    public static void main(String[] args) {
        // Crear un string
        String texto = "Programación en Java";
        
        // Obtener la longitud usando length()
        int longitud = texto.length();
        
        // Mostrar la longitud
        System.out.println("El texto \"" + texto + "\" tiene " + longitud + " caracteres");
        
        // También se puede usar directamente en el println
        System.out.println("Longitud: " + texto.length());
    }
}
