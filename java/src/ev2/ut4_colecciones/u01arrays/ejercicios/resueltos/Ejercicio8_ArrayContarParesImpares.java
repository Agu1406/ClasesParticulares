package ev2.ut4_colecciones.u01arrays.ejercicios.resueltos;

/**
 * Ejercicio 8: Contar pares e impares en un array unidimensional
 * 
 * Recorre el array y usa dos contadores apoyandose en el operador
 * modulo (%) para decidir si cada elemento es par o impar.
 * 
 * int[] ejemplo = {4, 7, 5, 6, 2, 9, 8, 3}
 * 
 * Pares: 4 (4, 6, 2, 8)
 * Impares: 4 (7, 5, 9, 3)
 * 
 * @author Agustin. A. Marquez. Pina
 * @since 14/06/2025
 * @see <a href="mailto:agu1406@outlook.es">agu1406@outlook.es</a>
 * @see <a href="https://github.com/Agu1406/ClasesParticulares">Repositorio GitHub</a>
 * @see <a href="https://www.agustinmarquez.dev">Sitio web</a>
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
