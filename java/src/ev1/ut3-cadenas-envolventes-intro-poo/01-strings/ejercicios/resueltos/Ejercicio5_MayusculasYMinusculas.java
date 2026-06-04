package general.strings.resueltos;

/**
 * Ejercicio 5: Convertir a mayusculas y minusculas
 * Crea un string y conviertelo a mayusculas usando toUpperCase() y a minusculas usando toLowerCase()
 * 
 * @author Agustin. A. Marquez. Pina
 * @since 14/06/2025
 * @see <a href="mailto:agu1406@outlook.es">agu1406@outlook.es</a>
 * @see <a href="https://github.com/Agu1406/ClasesParticulares">Repositorio GitHub</a>
 * @see <a href="https://www.agustinmarquez.dev">Sitio web</a>
 */
public class Ejercicio5_MayusculasYMinusculas {
    public static void main(String[] args) {
        // Crear un string con mayusculas y minusculas
        String texto = "Programacion en Java";
        
        // Convertir a mayusculas usando toUpperCase()
        String mayusculas = texto.toUpperCase();
        System.out.println("En mayusculas: " + mayusculas);
        
        // Convertir a minusculas usando toLowerCase()
        String minusculas = texto.toLowerCase();
        System.out.println("En minusculas: " + minusculas);
        
        // El string original no se modifica (los strings son inmutables)
        System.out.println("Texto original: " + texto);
    }
}
