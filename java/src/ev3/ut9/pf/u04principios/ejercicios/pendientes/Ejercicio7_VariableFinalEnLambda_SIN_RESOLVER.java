package ev3.ut9.pf.u04principios.ejercicios.pendientes;

import java.util.function.IntUnaryOperator;

/**
 * Ejercicio 7 (Principios): variable efectivamente final en lambda.
 * 
 * Proposito:
 * Regla del compilador: variables locales capturadas por lambda deben ser final o efectivamente final (no reasignadas tras captura).
 * 
 * Objetivos de aprendizaje:
 *   - int base = 10 sin reasignar.
 *   - IntUnaryOperator que usa base.
 *   - applyAsInt(5) e imprimir.
 * 
 * Tu tarea:
 * Define base=10 y lambda x -> x + base; imprime applyAsInt(5). No reasignes base despues de crear la lambda.
 * 
 * Salida esperada al ejecutar main:
 * 15
 *
 * @author Agustin. A. Marquez. Pina
 * @since 03/06/2026
 */
public class Ejercicio7_VariableFinalEnLambda_SIN_RESOLVER {
    public static void main(String[] args) {
        // TODO: int base=10; IntUnaryOperator sumarBase = valorEntrada -> valorEntrada + base; imprimir sumarBase.applyAsInt(5)
        // base no debe reasignarse despues de crear lambda
    }
}
