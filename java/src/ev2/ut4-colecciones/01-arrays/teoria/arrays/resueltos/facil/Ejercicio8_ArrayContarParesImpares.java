package general.arrays.resueltos.facil;

/**
 * Ejercicio 8: Contar pares e impares en un array unidimensional
 * 
 * Recorre el array y usa dos contadores apoyándose en el operador
 * módulo (%) para decidir si cada elemento es par o impar.
 * 
 * int[] ejemplo = {4, 7, 5, 6, 2, 9, 8, 3}
 * 
 * Pares: 4 (4, 6, 2, 8)
 * Impares: 4 (7, 5, 9, 3)
 * 
 * @author Agustín. A. Marquez. Piña
 * @since 14/06/2025
 * @see <a href="mailto:agu1406@outlook.es">agu1406@outlook.es</a>
 * @see <a href="https://github.com/Agu1406/ClasesParticulares">Repositorio GitHub</a>
 * @see <a href="https://agu1406.github.io/ClasesParticulares">GitHub Pages</a>
 */
public class Ejercicio8_ArrayContarParesImpares {
    public static void main(String[] args) {
        int[] numeros = {4, 7, 5, 6, 2, 9, 8, 3};
        
        int pares = 0;
        int impares = 0;
        
        for (int indice = 0; indice < numeros.length; indice++) {
            if (numeros[indice] % 2 == 0) {
                pares++;
            } else {
                impares++;
            }
        }
        
        System.out.println("Pares: " + pares);
        System.out.println("Impares: " + impares);
    }
}
