package ev1.ut3.u01strings.ejercicios.resueltos;

/**
 * Ejercicio 4: Obtener caracteres y substrings
 * Crea un string y muestra el primer caracter usando charAt(0) y una subcadena usando substring()
 * 
 * @author Agustin. A. Marquez. Pina
 * @since 14/06/2025
 * @see <a href="mailto:agu1406@outlook.es">agu1406@outlook.es</a>
 * @see <a href="https://github.com/Agu1406/ClasesParticulares">Repositorio GitHub</a>
 * @see <a href="https://www.agustinmarquez.dev">Sitio web</a>
 */
public class Ejercicio4_CharAtYSubstring {
    public static void main(String[] args) {
        // Crear un string
        String texto = "Programacion";
        
        // Obtener el primer caracter usando charAt(0)
        char primerCaracter = texto.charAt(0);
        System.out.println("Primer caracter: " + primerCaracter);
        
        // Obtener el ultimo caracter
        char ultimoCaracter = texto.charAt(texto.length() - 1);
        System.out.println("Ultimo caracter: " + ultimoCaracter);
        
        // Obtener una subcadena usando substring(inicio, fin)
        // substring(0, 4) obtiene los caracteres desde la posicion 0 hasta la 3 (no incluye la 4)
        String subcadena = texto.substring(0, 4);
        System.out.println("Subcadena (0-4): " + subcadena);
        
        // Obtener una subcadena desde una posicion hasta el final
        String desdeMedio = texto.substring(4);
        System.out.println("Desde la posicion 4 hasta el final: " + desdeMedio);
    }
}
