package ev3.ut9.pf.u01lambda.ejercicios.pendientes;



/**
 * Ejercicio 8 (Lambda y SAM): interfaz funcional Calculadora.
 * 
 * Proposito:
 * Definir una interfaz funcional propia (@FunctionalInterface) y usarla como tipo de una lambda, consolidando el concepto SAM (Single Abstract Method).
 * 
 * Objetivos de aprendizaje:
 *   - Declarar interfaz con un solo metodo abstracto calcular(int, int).
 *   - Anotar con @FunctionalInterface.
 *   - Asignar lambda de multiplicacion e invocar calcular.
 * 
 * Tu tarea:
 * Completa la interfaz Calculadora y en main crea una instancia lambda que multiplique dos enteros. Imprime calcular(6, 7).
 * 
 * Salida esperada al ejecutar main:
 * 42
 *
 * @author Agustin. A. Marquez. Pina
 * @since 03/06/2026
 */
public class Ejercicio8_SamCalculadoraMultiplicar_SIN_RESOLVER {
    @FunctionalInterface
    interface Calculadora {
        int calcular(int factorA, int factorB);
    }

    public static void main(String[] args) {
        // TODO: interfaz funcional Calculadora con int calcular(int factorA, int factorB)
        // TODO: Calculadora mult = (a,b) -> a*b; imprimir mult.calcular(6,7)
    }
}
