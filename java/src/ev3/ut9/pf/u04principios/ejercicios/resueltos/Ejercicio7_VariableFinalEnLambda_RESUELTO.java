package ev3.ut9.pf.u04principios.ejercicios.resueltos;

// IntUnaryOperator recibe y devuelve int; util para lambdas numericas de un solo argumento.
import java.util.function.IntUnaryOperator;

/**
 * Ejercicio 7 (Principios): variable final en lambda - SOLUCION.
 * 
 * Proposito del ejercicio:
 * Captura de variable local efectivamente final.
 * 
 * Que hace este codigo resuelto:
 * op suma base (10) a 5 e imprime 15.
 * 
 * Conceptos que demuestra:
 *   - Effective finalness.
 *   - Closure sobre variable local.
 *   - IntUnaryOperator SAM.
 * 
 * Salida al ejecutar main:
 * 15
 *
 * @author Agustin. A. Marquez. Pina
 * @since 03/06/2026
 */
public class Ejercicio7_VariableFinalEnLambda_RESUELTO {
    public static void main(String[] args) {
        // base no se reasigna tras crear la lambda; requisito del compilador Java.
        int base = 10;
        // La lambda captura base del entorno; suma 10 a cualquier x recibido.
        IntUnaryOperator sumarBase = valorEntrada -> valorEntrada + base;
        // applyAsInt(5) evalua 5+10 e imprime 15 confirmando la captura de base.
        System.out.println(sumarBase.applyAsInt(5));
    }
}
