package ev3.ut9.pf.principios.resueltos;



/**
 * Ejercicio 2 (Principios): funcion pura - SOLUCION.
 * 
 * Proposito del ejercicio:
 * Cuadrado determinista sin efectos colaterales.
 * 
 * Que hace este codigo resuelto:
 * cuadrado(4) devuelve 16 en ambas llamadas e imprime dos veces el mismo valor.
 * 
 * Conceptos que demuestra:
 *   - Referential transparency.
 *   - Sin estado mutable compartido.
 *   - Metodo puro testeable.
 * 
 * Salida al ejecutar main:
 * 16
16
 *
 * @author Agustin. A. Marquez. Pina
 * @since 03/06/2026
 */
public class Ejercicio2_FuncionPuraCuadrado_RESUELTO {
    // cuadrado(int) no lee estado global ni imprime; solo calcula numero*numero.
    static int cuadrado(int numero) { return numero * numero; }


    public static void main(String[] args) {
        // Primera invocacion cuadrado(4); demuestra determinismo de funcion pura.
        System.out.println(cuadrado(4));
        // Segunda llamada con mismo argumento devuelve 16 otra vez (referential transparency).
        System.out.println(cuadrado(4));
    }
}
