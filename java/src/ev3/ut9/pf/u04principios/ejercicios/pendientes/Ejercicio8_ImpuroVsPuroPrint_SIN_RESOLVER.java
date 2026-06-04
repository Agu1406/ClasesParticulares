package ev3.ut9.pf.u04principios.ejercicios.pendientes;



/**
 * Ejercicio 8 (Principios): impuro vs puro (print).
 * 
 * Proposito:
 * Distinguir efectos secundarios (impresion) de computacion pura (solo return), base para razonar sobre testabilidad y refactor.
 * 
 * Objetivos de aprendizaje:
 *   - Metodo impuro que imprime y devuelve.
 *   - Metodo puro que solo calcula.
 *   - Invocar ambos desde main.
 * 
 * Tu tarea:
 * Define impuroImprime (imprime x y lo devuelve) y puroDoble (return x*2). Llamalos con 3 e imprime resultado de puroDoble.
 * 
 * Salida esperada al ejecutar main:
 * 3
6
 *
 * @author Agustin. A. Marquez. Pina
 * @since 03/06/2026
 */
public class Ejercicio8_ImpuroVsPuroPrint_SIN_RESOLVER {
    static int impuroImprime(int x) { System.out.println(x); return x; }
    static int puroDoble(int x) { return x * 2; }

    public static void main(String[] args) {
        // TODO: metodo impuroImprime(int x) que imprima y devuelva x
        // TODO: metodo puroDoble(int x) solo return x*2; llamar ambos
    }
}
