package ev3.ut9_programacionfuncional.pf.u04principios.teoria;

/**
 * Teoria: transparencia referencial (PDF diapos 32).
 *
 * <p><b>Que es?</b> Si una expresion es pura, puedes reemplazarla por su valor calculado
 * sin cambiar el comportamiento del programa. Ejemplo: {@code sumaPura(3,4)} es
 * intercambiable por {@code 7} en cualquier sitio.</p>
 *
 * <p><b>Por que importa?</b> Facilita optimizacion del compilador, razonamiento humano
 * y paralelismo: no dependes de "cuando" se evaluo si el resultado es fijo.</p>
 *
 * <p><b>Contraejemplo:</b> {@code Math.random()} no es transparente: dos llamadas no
 * producen el mismo valor; no puedes sustituir la llamada por una constante.</p>
 *
 * <p><b>Relacion con pureza:</b> las funciones puras suelen ser transparentes; las
 * impuras (I/O, reloj, random, estado global) no.</p>
 *
 * @author Agustin. A. Marquez. Pina
 * @since 03/06/2026
 */
public class U01_TransparenciaReferencialIntro {

    public static int sumaPura(int sumandoA, int sumandoB) {
        return sumandoA + sumandoB;
    }

    public static int aleatorioImpuro() {
        return (int) (Math.random() * 100);
    }

    public static void main(String[] args) {
        int sumandoA = 3;
        int sumandoB = 4;
        int resultadoLlamada = sumaPura(sumandoA, sumandoB);
        int resultadoEsperado = 7;
        System.out.println("sumaPura(3,4) == 7 (intercambiable): " + (resultadoLlamada == resultadoEsperado));

        System.out.println("aleatorioImpuro cambia en cada llamada (no transparente): "
                + aleatorioImpuro() + " vs " + aleatorioImpuro());
    }
}
