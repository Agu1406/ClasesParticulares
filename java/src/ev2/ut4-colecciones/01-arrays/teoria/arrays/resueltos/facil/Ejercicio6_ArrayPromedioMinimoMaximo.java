package general.arrays.resueltos.facil;

/**
 * Ejercicio 6: Promedio, mínimo y máximo de un array unidimensional
 * 
 * Crea un array de números enteros con 6 elementos y asígnales valores.
 * Recorre el array con un bucle for para calcular tres cosas a la vez:
 *  - La suma total (para luego sacar el promedio).
 *  - El valor mínimo del array.
 *  - El valor máximo del array.
 * 
 * Después de recorrerlo:
 *  - El promedio se calcula como suma / longitud del array.
 *  - Como queremos decimales en el promedio, usa double al hacer la división.
 * 
 * Muestra por pantalla los tres resultados:
 *  - "Suma: ..."
 *  - "Promedio: ..."
 *  - "Mínimo: ..."
 *  - "Máximo: ..."
 * 
 * int[] ejemplo = {4, 6, 5, 7, 2, 10}
 * 
 * Valores =    [4][6][5][7][2][10]
 * Posiciones = [0][1][2][3][4][5]
 * 
 * Suma = 4 + 6 + 5 + 7 + 2 + 10 = 34
 * Promedio = 34 / 6 = 5.66
 * Mínimo = 2
 * Máximo = 10
 * 
 * @author Agustín. A. Marquez. Piña
 * @since 14/06/2025
 * @see <a href="mailto:agu1406@outlook.es">agu1406@outlook.es</a>
 * @see <a href="https://github.com/Agu1406/ClasesParticulares">Repositorio GitHub</a>
 * @see <a href="https://www.agustinmarquez.dev">Sitio web</a>
 */
public class Ejercicio6_ArrayPromedioMinimoMaximo {
    public static void main(String[] args) {
        int[] numeros = {4, 6, 5, 7, 2, 10};
        
        int suma = 0;
        int minimo = numeros[0];
        int maximo = numeros[0];
        
        for (int indice = 0; indice < numeros.length; indice++) {
            suma = suma + numeros[indice];
            
            if (numeros[indice] < minimo) {
                minimo = numeros[indice];
            }
            
            if (numeros[indice] > maximo) {
                maximo = numeros[indice];
            }
        }
        
        double promedio = (double) suma / numeros.length;
        
        System.out.println("Suma: " + suma);
        System.out.println("Promedio: " + promedio);
        System.out.println("Mínimo: " + minimo);
        System.out.println("Máximo: " + maximo);
    }
}
