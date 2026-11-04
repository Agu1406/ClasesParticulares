package ev1.ut2_controlflujometodos.u04metodos.ejercicios.resueltos;

/**
 * <p><b>OBJETIVO:</b> Crea el metodo int sumarDel1AlN, que sume los enteros del 1 a n con un for y devuelva el total. En main imprime Suma 1..10: y el resultado de sumarDel1AlN(10).</p>
 *
 * <br>
 *
 * <p><b>SOLUCIÓN:</b> Un acumulador suma i en el for. main llama con 10.</p>
 *
 * @author Agustin. A. Marquez. Pina
 * @since 29/04/2026
 * @see <a href="mailto:agu1406@outlook.es">agu1406@outlook.es</a>
 * @see <a href="https://github.com/Agu1406/ClasesParticulares">Repositorio GitHub</a>
 * @see <a href="https://www.agustinmarquez.dev">Sitio web</a>
 */

public class E08_ConBucleFor_Resuelto {
    public static int sumarDel1AlN(int n) {
        int suma = 0;
        for (int i = 1; i <= n; i++) {
            suma += i;
        }
        return suma;
    }

    public static void main(String[] args) {
        System.out.println("Suma 1..10: " + sumarDel1AlN(10));
    }
}
