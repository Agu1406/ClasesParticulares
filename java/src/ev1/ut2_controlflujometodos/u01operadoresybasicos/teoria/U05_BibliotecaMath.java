package ev1.ut2_controlflujometodos.u01operadoresybasicos.teoria;

import java.util.Random;

/**
 * <p><b>OBJETIVO:</b> usar {@link Math} para raíces, potencias, redondeos,
 * trigonometría y logaritmos, y {@link Random} para un entero en un rango.</p>
 *
 * <p>{@code Math} está en {@code java.lang}: no hace falta importarla.
 * Los ángulos de {@code sin}, {@code cos} y {@code tan} van en radianes;
 * {@link Math#toRadians(double)} pasa de grados a radianes.</p>
 *
 * <p>{@code Math.random()} devuelve un {@code double} en {@code [0.0, 1.0)}.
 * {@code Random} con una semilla fija repite siempre la misma serie: útil en clase.
 * Un dado del 1 al 6 es {@code 1 + aleatorio.nextInt(6)}.</p>
 *
 * @author Agustin. A. Marquez. Pina
 * @since 26/10/2026
 * @see <a href="mailto:agu1406@outlook.es">agu1406@outlook.es</a>
 * @see <a href="https://github.com/Agu1406/ClasesParticulares">Repositorio GitHub</a>
 * @see <a href="https://www.agustinmarquez.dev">Sitio web</a>
 */
public class U05_BibliotecaMath {

    public static void main(String[] args) {
        System.out.println();
        System.out.println("¡INICIO DEL PROGRAMA!");
        System.out.println();

        /*
        PRIMERA PARTE - Raiz y potencia.
          sqrt(x) raiz cuadrada     pow(x, y) x elevado a y
          cbrt(x) raiz cubica       hypot(a, b) raiz(a*a + b*b)
          Todas trabajan con double.
        */
        System.out.println("--- PRIMERA PARTE: sqrt y pow ---");
        System.out.println();

        System.out.println("sqrt(144)   = " + Math.sqrt(144));
        System.out.println("pow(2, 10)  = " + Math.pow(2, 10));
        System.out.println("pow(9, 0.5) = " + Math.pow(9, 0.5));
        System.out.println("cbrt(27)    = " + Math.cbrt(27));
        System.out.println("hypot(3, 4) = " + Math.hypot(3, 4));
        System.out.println();

        /*
        SEGUNDA PARTE - Redondeos.
          floor  hacia -infinito          ceil   hacia +infinito
          round  al entero mas cercano    (int)  quita los decimales (hacia 0)
          Math.round(double) devuelve long.
          Con .5, round(2.5) da 3 y round(-2.5) da -2: suma 0.5 y aplica floor.
        */
        System.out.println("--- SEGUNDA PARTE: Redondeos ---");
        System.out.println();

        System.out.println("    x   floor   ceil  round  (int)");
        fila(-2.5);
        fila(2.5);
        fila(2.4);
        System.out.println("abs(-7.25) = " + Math.abs(-7.25) + " | abs(-7) = " + Math.abs(-7));

        double precio = 3.14159;
        double aDosDecimales = Math.round(precio * 100) / 100.0;
        System.out.printf("%.5f redondeado a 2 decimales = %.2f%n", precio, aDosDecimales);
        System.out.println();

        /*
        TERCERA PARTE - Trigonometria en radianes.
        */
        System.out.println("--- TERCERA PARTE: Trigonometria ---");
        System.out.println();

        double grados = 30.0;
        double radianes = Math.toRadians(grados);
        System.out.printf("sin(%.0f grados) = %.3f%n", grados, Math.sin(radianes));
        System.out.printf("cos(%.0f grados) = %.3f%n", grados, Math.cos(radianes));
        System.out.printf("tan(45 grados)  = %.3f%n", Math.tan(Math.toRadians(45)));
        System.out.printf("atan(1) en grados = %.1f%n", Math.toDegrees(Math.atan(1)));
        System.out.println();

        /*
        CUARTA PARTE - Logaritmos y exponencial.
          log     neperiano (base e)     log10  base 10     exp  e elevado a x
          El numero de cifras de un entero positivo es floor(log10(n)) + 1.
        */
        System.out.println("--- CUARTA PARTE: log y exp ---");
        System.out.println();

        System.out.println("log10(1000) = " + Math.log10(1000));
        System.out.println("log(e)      = " + Math.log(Math.E));
        System.out.println("Cifras de 123456 = " + ((int) Math.log10(123456) + 1));
        System.out.println();

        /*
        QUINTA PARTE - Aleatorios.
          Semilla fija: la serie no cambia entre ejecuciones.
          nextInt(6) devuelve 0, 1, 2, 3, 4 o 5. Sumar 1 lo lleva a 1..6.
        */
        System.out.println("--- QUINTA PARTE: Random ---");
        System.out.println();

        Random fijo = new Random(12345);
        int dado1 = fijo.nextInt(6) + 1;
        int dado2 = fijo.nextInt(6) + 1;
        int dado3 = fijo.nextInt(6) + 1;
        System.out.println("Tres dados con semilla 12345: " + dado1 + " " + dado2 + " " + dado3);

        Random variable = new Random();
        int dado = variable.nextInt(6) + 1;
        System.out.println("Dado de esta ejecucion (1..6): " + dado);
        System.out.println("Math.random() en [0.0, 1.0): " + Math.random());
        System.out.println();

        /*
        SEXTA PARTE - Distancia entre dos puntos.
          d = raiz( (x2-x1)^2 + (y2-y1)^2 )
        */
        System.out.println("--- SEXTA PARTE: Distancia ---");
        System.out.println();

        double x1 = 1;
        double y1 = 2;
        double x2 = 4;
        double y2 = 6;
        double distancia = Math.sqrt(Math.pow(x2 - x1, 2) + Math.pow(y2 - y1, 2));
        System.out.printf("Distancia entre (%.0f,%.0f) y (%.0f,%.0f) = %.2f%n", x1, y1, x2, y2, distancia);
        System.out.println();
        System.out.println("¡FIN DEL PROGRAMA!");
        System.out.println();
    }

    private static void fila(double x) {
        System.out.printf("%5.1f %6.0f %6.0f %6d %6d%n",
                x, Math.floor(x), Math.ceil(x), Math.round(x), (int) x);
    }
}
