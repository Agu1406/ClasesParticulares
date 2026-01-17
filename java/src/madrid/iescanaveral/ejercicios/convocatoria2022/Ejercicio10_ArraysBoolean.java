package madrid.iescanaveral.ejercicios.convocatoria2022;

/**
 * Ejercicio 10: Dado el siguiente fragmento de código, indica cuál de las siguientes afirmaciones 
 * es correcta en relación al valor de la variable foo.
 * 
 * Analiza los valores por defecto de los arrays en Java.
 * 
 * @author Agustín. A. Marquez. Piña
 * @since 14/01/2026
 * @see <a href="mailto:agu1406@outlook.es">agu1406@outlook.es</a>
 * @see <a href="https://github.com/Agu1406/ClasesParticulares">Repositorio GitHub</a>
 * @see <a href="https://agu1406.github.io/ClasesParticulares">GitHub Pages</a>
 */
public class Ejercicio10_ArraysBoolean {
    public static void main(String[] args) {
        int index = 1;
        boolean[] test = new boolean[3];
        boolean foo = test[index];
        
        System.out.println("foo tiene el valor: " + foo);
    }
}
