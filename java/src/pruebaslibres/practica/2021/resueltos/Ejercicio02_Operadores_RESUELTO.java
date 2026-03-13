package pruebaslibres.practica.resueltos;

/**
 * Solución del Ejercicio 02 - Operadores a nivel de bits y operadores lógicos.
 */
public class Ejercicio02_Operadores_RESUELTO {

    public static void main(String[] args) {
        int resultadoOr = orABitDeNivelEntero(2, 1);
        int resultadoDesplazar = desplazarDerecha(17, 2);
        boolean resultadoLogico = evaluarExpresionLogica(2, 3, 2);

        System.out.println("2 | 1 = " + resultadoOr);
        System.out.println("17 >> 2 = " + resultadoDesplazar);
        System.out.println("(k + m < j) | (3 - j >= k) con j=2, k=3, m=2 -> " + resultadoLogico);
    }

    public static int orABitDeNivelEntero(int primerEntero, int segundoEntero) {
        return primerEntero | segundoEntero;
    }

    public static int desplazarDerecha(int valor, int posiciones) {
        return valor >> posiciones;
    }

    public static boolean evaluarExpresionLogica(int valorJ, int valorK, int valorM) {
        return (valorK + valorM < valorJ) | (3 - valorJ >= valorK);
    }
}

