package madrid.iescanaveral.ejercicios.resueltos;

/**
 * Ejercicio 13: Dada el siguiente código, indicar la salida - RESUELTO
 * 
 * RESPUESTA: Se mostrará 5050
 * 
 * Explicación:
 * - La función xyz(num) calcula la suma de todos los números desde 1 hasta num
 * - xyz(100) = 1 + 2 + 3 + ... + 100 = 5050
 * - Es una función recursiva que suma num con la suma de todos los números anteriores
 * - Caso base: xyz(1) = 1
 * - Caso recursivo: xyz(n) = xyz(n-1) + n
 * 
 * @author Agustín. A. Marquez. Piña
 * @since 14/01/2026
 * @see <a href="mailto:agu1406@outlook.es">agu1406@outlook.es</a>
 * @see <a href="https://github.com/Agu1406/ClasesParticulares">Repositorio GitHub</a>
 * @see <a href="https://agu1406.github.io/ClasesParticulares">GitHub Pages</a>
 */
public class Ejercicio13_Recursion_RESUELTO {
    public static void main(String[] args) {
        Ejercicio13_Recursion_RESUELTO test1 = new Ejercicio13_Recursion_RESUELTO();
        System.out.println(test1.xyz(100));  // Imprime: 5050
        
        // Verificación: suma de 1 a 100 = 100 * 101 / 2 = 5050
    }
    
    public int xyz(int num) {
        if (num == 1) {
            return 1;  // Caso base
        } else {
            return (xyz(num - 1) + num);  // Caso recursivo
        }
    }
    
    // Equivalente iterativo:
    // public int xyzIterativo(int num) {
    //     int suma = 0;
    //     for (int i = 1; i <= num; i++) {
    //         suma += i;
    //     }
    //     return suma;
    // }
}
