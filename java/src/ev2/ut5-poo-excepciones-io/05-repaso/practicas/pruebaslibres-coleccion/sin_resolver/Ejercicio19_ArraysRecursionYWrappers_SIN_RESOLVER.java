package pruebaslibres.practica.coleccion.sin_resolver;

/**
 * Preguntas relacionadas (orientativo):
 * - 2025: Q9, Q12, Q18, Q20
 * - 2021-2024: equals vs ==, arrays y recursion.
 */
public class Ejercicio19_ArraysRecursionYWrappers_SIN_RESOLVER {

    public static void main(String[] args) {
        // TODO 1: probar compararWrappers() y explicar == vs equals.
        // TODO 2: calcular factorialRecursivo(5).
        // TODO 3: provocar y capturar ArrayIndexOutOfBoundsException con mostrarCuartoElemento().
    }

    static int compararWrappers() {
        Integer a = Integer.valueOf(1000);
        Integer b = Integer.valueOf("1000");
        // TODO: sumar 10 si a.equals(b), sumar 100 si a == b.
        return 0;
    }

    static int factorialRecursivo(int n) {
        // TODO: implementar version recursiva clasica.
        return 0;
    }

    static String mostrarCuartoElemento(String[] datos) {
        // TODO: devolver datos[3].
        return "";
    }
}
