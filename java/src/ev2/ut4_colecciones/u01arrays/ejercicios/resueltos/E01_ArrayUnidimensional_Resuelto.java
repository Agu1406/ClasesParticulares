package ev2.ut4_colecciones.u01arrays.ejercicios.resueltos;

/**
 * <p><b>OBJETIVO:</b> Crea un array de numeros enteros con 5 elementos, asignales valores y muestra todos los valores del array usando un bucle for int[] ejemplo = new int[] {4, 6, 5, 7, 2} Eso significa que el Array tiene 5 cajitas, una cosa es el valor dentro de las cajitas y otra la posicion que tienen las cajitas, ejemplo Valores = [4][6][5][7][2] Posiciones = [0][1][2][3][4]</p>
 *
 * <br>
 *
 * <p><b>SOLUCIÓN:</b> Se crea un array de 5 casillas, se asignan 4, 6, 5, 7 y 2, y un for imprime la posicion y el valor.</p>
 *
 * @author Agustin. A. Marquez. Pina
 * @since 14/06/2025
 * @see <a href="mailto:agu1406@outlook.es">agu1406@outlook.es</a>
 * @see <a href="https://github.com/Agu1406/ClasesParticulares">Repositorio GitHub</a>
 * @see <a href="https://www.agustinmarquez.dev">Sitio web</a>
 */
public class E01_ArrayUnidimensional_Resuelto {
    public static void main(String[] args) {
        // Crear array de 5 elementos
        int[] numeros = new int[5];
        
        // Asignar valores
        numeros[0] = 4;
        numeros[1] = 6;
        numeros[2] = 5;
        numeros[3] = 7;
        numeros[4] = 2;
        
        // Mostrar todos los valores usando bucle for
        System.out.println("Valores del array:");
        for (int indice = 0; indice < numeros.length; indice++) {
            System.out.println("Posicion " + indice + ": " + numeros[indice]);
        }
    }
}
