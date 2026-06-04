package ev3.ut9.pf.u01lambda.ejercicios.resueltos;



/**
 * Ejercicio 8 (Lambda y SAM): SAM Calculadora - SOLUCION.
 * 
 * Proposito del ejercicio:
 * Interfaz funcional custom y lambda compatible con su metodo abstracto.
 * 
 * Que hace este codigo resuelto:
 * Define Calculadora con calcular, asigna (factorA, factorB) -> factorA * factorB e imprime el producto de 6 y 7.
 * 
 * Conceptos que demuestra:
 *   - @FunctionalInterface y contrato SAM.
 *   - Lambda asignable a tipo funcional propio.
 *   - Sustitucion de clase anonima por expresion lambda.
 * 
 * Salida al ejecutar main:
 * 42
 *
 * @author Agustin. A. Marquez. Pina
 * @since 03/06/2026
 */
public class Ejercicio8_SamCalculadoraMultiplicar_RESUELTO {
    @FunctionalInterface
    // @FunctionalInterface garantiza una unica firma abstracta compatible con lambda.
    interface Calculadora {
        // calcular(int,int) es el metodo que la lambda debe implementar implicitamente.
        int calcular(int factorA, int factorB);
    }


    public static void main(String[] args) {
        // Instancia de Calculadora como lambda: producto de factorA y factorB.
        Calculadora mult = (factorA, factorB) -> factorA * factorB;
        // Invoca calcular con 6 y 7; la salida 42 valida la multiplicacion de la lambda.
        System.out.println(mult.calcular(6, 7));
    }
}
