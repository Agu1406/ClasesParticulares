package ev2.ut4.u01arrays.ejercicios.resueltos;

/**
 * Ejercicio 3: Array unidimensional con condicional if
 * Crea un array de numeros enteros con 6 elementos y asignales valores.
 * Usa un bucle for para recorrer el array y un if para mostrar solo
 * los numeros mayores que 5
 * 
 * int[] ejemplo = new int{4, 6, 5, 7, 2}
 * 
 * Eso significa que el Array
 * tiene 5 cajitas, una cosa es el
 * valor dentro de las cajitas y
 * otra la posicion que tienen
 * las cajitas, ejemplo
 * 
 * Valores = [4][6][5][7][2]
 * Posiciones = [0][1][2][3][4]
 * 
 * @author Agustin. A. Marquez. Pina
 * @since 14/06/2025
 * @see <a href="mailto:agu1406@outlook.es">agu1406@outlook.es</a>
 * @see <a href="https://github.com/Agu1406/ClasesParticulares">Repositorio GitHub</a>
 * @see <a href="https://www.agustinmarquez.dev">Sitio web</a>
 */
public class Ejercicio3_ArrayConIf {
    public static void main(String[] args) {
        // Crear array de 6 elementos y asignar valores
        int[] numeros = {4, 6, 5, 7, 2, 9};
        
        // Recorrer el array y mostrar solo los numeros mayores que 5
        System.out.println("Numeros mayores que 5:");
        for (int indice = 0; indice < numeros.length; indice++) {
            if (numeros[indice] > 5) {
                System.out.println("Posicion " + indice + ": " + numeros[indice]);
            }
        }
    }
}

