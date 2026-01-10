package madrid.iescalderonbarca.d_ejerciciosstrings;

/**
 * Ejercicio 5: Convertir a mayúsculas y minúsculas
 * Crea un string y conviértelo a mayúsculas usando toUpperCase() y a minúsculas usando toLowerCase()
 * 
 * @author Agustín. A. Marquez. Piña
 * @since 14/06/2025
 * @see <a href="mailto:agu1406@outlook.es">agu1406@outlook.es</a>
 * @see <a href="https://github.com/Agu1406/ClasesParticulares">Repositorio GitHub</a>
 * @see <a href="https://agu1406.github.io/ClasesParticulares">GitHub Pages</a>
 */
public class Ejercicio5_MayusculasYMinusculas {
    public static void main(String[] args) {
        // Crear un string con mayúsculas y minúsculas
        String texto = "Programación en Java";
        
        // Convertir a mayúsculas usando toUpperCase()
        String mayusculas = texto.toUpperCase();
        System.out.println("En mayúsculas: " + mayusculas);
        
        // Convertir a minúsculas usando toLowerCase()
        String minusculas = texto.toLowerCase();
        System.out.println("En minúsculas: " + minusculas);
        
        // El string original no se modifica (los strings son inmutables)
        System.out.println("Texto original: " + texto);
    }
}
