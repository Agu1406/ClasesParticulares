package ev3.ut6.u04repaso.practicas.madridiescanaveralconvocatoria2022;

/**
 * Ejercicio 13: Dada el siguiente codigo, indicar la salida.
 * 
 * Analiza el funcionamiento de la recursion en Java.
 * 
 * @author Agustin. A. Marquez. Pina
 * @since 14/01/2026
 * @see <a href="mailto:agu1406@outlook.es">agu1406@outlook.es</a>
 * @see <a href="https://github.com/Agu1406/ClasesParticulares">Repositorio GitHub</a>
 * @see <a href="https://www.agustinmarquez.dev">Sitio web</a>
 */
public class Ejercicio13_Recursion_SIN_RESOLVER {
    public static void main(String[] args) {
        Ejercicio13_Recursion_SIN_RESOLVER test1 = new Ejercicio13_Recursion_SIN_RESOLVER();
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
