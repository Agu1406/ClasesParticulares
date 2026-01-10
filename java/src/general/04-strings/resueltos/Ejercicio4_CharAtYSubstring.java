package madrid.iescalderonbarca.d_ejerciciosstrings;

/**
 * Ejercicio 4: Obtener caracteres y substrings
 * Crea un string y muestra el primer carácter usando charAt(0) y una subcadena usando substring()
 * 
 * @author Agustín. A. Marquez. Piña
 * @since 14/06/2025
 * @see <a href="mailto:agu1406@outlook.es">agu1406@outlook.es</a>
 * @see <a href="https://github.com/Agu1406/ClasesParticulares">Repositorio GitHub</a>
 * @see <a href="https://agu1406.github.io/ClasesParticulares">GitHub Pages</a>
 */
public class Ejercicio4_CharAtYSubstring {
    public static void main(String[] args) {
        // Crear un string
        String texto = "Programación";
        
        // Obtener el primer carácter usando charAt(0)
        char primerCaracter = texto.charAt(0);
        System.out.println("Primer carácter: " + primerCaracter);
        
        // Obtener el último carácter
        char ultimoCaracter = texto.charAt(texto.length() - 1);
        System.out.println("Último carácter: " + ultimoCaracter);
        
        // Obtener una subcadena usando substring(inicio, fin)
        // substring(0, 4) obtiene los caracteres desde la posición 0 hasta la 3 (no incluye la 4)
        String subcadena = texto.substring(0, 4);
        System.out.println("Subcadena (0-4): " + subcadena);
        
        // Obtener una subcadena desde una posición hasta el final
        String desdeMedio = texto.substring(4);
        System.out.println("Desde la posición 4 hasta el final: " + desdeMedio);
    }
}
