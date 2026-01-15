package madrid.iescanaveral.ejercicios.convocatoria2022;

/**
 * Ejercicio 13: Dada el siguiente código, indicar la salida.
 * 
 * Analiza el funcionamiento de la recursión en Java.
 * 
 * @author Agustín. A. Marquez. Piña
 * @since 14/01/2026
 * @see <a href="mailto:agu1406@outlook.es">agu1406@outlook.es</a>
 * @see <a href="https://github.com/Agu1406/ClasesParticulares">Repositorio GitHub</a>
 * @see <a href="https://agu1406.github.io/ClasesParticulares">GitHub Pages</a>
 */
public class Ejercicio13_Recursion {
    public static void main(String[] args) {
        Ejercicio13_Recursion test1 = new Ejercicio13_Recursion();
        System.out.println(test1.xyz(100));
    }
    
    public int xyz(int num) {
        if (num == 1) {
            return 1;
        } else {
            return (xyz(num - 1) + num);
        }
    }
}
