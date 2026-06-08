package ev1.ut3_stringsyenvolventes.ejercicios.resueltos;

/**
 * Ejercicio 7: Reemplazar y eliminar espacios
 * Crea un string con espacios al inicio y al final, usa trim() para eliminarlos,
 * y usa replace() para reemplazar un caracter por otro
 * 
 * @author Agustin. A. Marquez. Pina
 * @since 14/06/2025
 * @see <a href="mailto:agu1406@outlook.es">agu1406@outlook.es</a>
 * @see <a href="https://github.com/Agu1406/ClasesParticulares">Repositorio GitHub</a>
 * @see <a href="https://www.agustinmarquez.dev">Sitio web</a>
 */
public class Ejercicio7_ReemplazarYTrim {
    public static void main(String[] args) {
        // Crear un string con espacios al inicio y al final
        String textoConEspacios = "   Programacion en Java   ";
        System.out.println("Texto original: '" + textoConEspacios + "'");
        System.out.println("Longitud: " + textoConEspacios.length());
        
        // Eliminar espacios al inicio y al final usando trim()
        String textoSinEspacios = textoConEspacios.trim();
        System.out.println("Texto sin espacios: '" + textoSinEspacios + "'");
        System.out.println("Longitud: " + textoSinEspacios.length());
        
        // Reemplazar un caracter por otro usando replace()
        String textoReemplazado = textoSinEspacios.replace('a', 'A');
        System.out.println("Reemplazando 'a' por 'A': " + textoReemplazado);
        
        // Reemplazar un substring por otro
        String textoReemplazadoSubstring = textoSinEspacios.replace("Java", "Python");
        System.out.println("Reemplazando 'Java' por 'Python': " + textoReemplazadoSubstring);
    }
}
