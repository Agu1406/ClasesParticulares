package general.strings.resueltos;

/**
 * Ejercicio 8: Dividir strings
 * Crea un string con varias palabras separadas por espacios o comas,
 * y usa split() para dividirlo en un array de strings
 * 
 * @author Agustín. A. Marquez. Piña
 * @since 14/06/2025
 * @see <a href="mailto:agu1406@outlook.es">agu1406@outlook.es</a>
 * @see <a href="https://github.com/Agu1406/ClasesParticulares">Repositorio GitHub</a>
 * @see <a href="https://agu1406.github.io/ClasesParticulares">GitHub Pages</a>
 */
public class Ejercicio8_Split {
    public static void main(String[] args) {
        // Crear un string con palabras separadas por espacios
        String textoConEspacios = "Java Python C++ JavaScript";
        System.out.println("Texto original: " + textoConEspacios);
        
        // Dividir el string usando split() con espacio como delimitador
        String[] palabras = textoConEspacios.split(" ");
        
        // Mostrar cada palabra
        System.out.println("Palabras separadas:");
        for (int i = 0; i < palabras.length; i++) {
            System.out.println("  Palabra " + (i + 1) + ": " + palabras[i]);
        }
        
        // Ejemplo con comas
        String textoConComas = "Manzana,Plátano,Naranja,Uva";
        System.out.println("\nTexto con comas: " + textoConComas);
        
        String[] frutas = textoConComas.split(",");
        System.out.println("Frutas separadas:");
        for (String fruta : frutas) {
            System.out.println("  - " + fruta);
        }
    }
}
