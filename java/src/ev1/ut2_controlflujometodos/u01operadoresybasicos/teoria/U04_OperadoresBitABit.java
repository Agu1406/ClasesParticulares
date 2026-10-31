package ev1.ut2_controlflujometodos.u01operadoresybasicos.teoria;

/**
 * <p><b>OBJETIVO:</b> leer un entero en binario y usar {@code &}, {@code |},
 * {@code ^}, {@code ~}, {@code <<}, {@code >>} y {@code >>>}.</p>
 *
 * <p>Cada bit vale una potencia de 2: 128 64 32 16 8 4 2 1.
 * El 45 es {@code 00101101} porque 32 + 8 + 4 + 1 = 45.</p>
 *
 * <ul>
 *   <li>{@code &} AND: 1 solo si los dos bits son 1. Apaga y comprueba.</li>
 *   <li>{@code |} OR: 1 si alguno es 1. Enciende.</li>
 *   <li>{@code ^} XOR: 1 si los bits son distintos. Invierte el bit elegido.</li>
 *   <li>{@code ~} NOT: invierte todos los bits.</li>
 *   <li>{@code x << n} desplaza a la izquierda: equivale a multiplicar por 2<sup>n</sup>.</li>
 *   <li>{@code x >> n} desplaza a la derecha conservando el signo.</li>
 *   <li>{@code x >>> n} desplaza a la derecha rellenando con ceros. Es propio de Java.</li>
 * </ul>
 *
 * <p>En un {@code int} el desplazamiento usa solo los 5 bits bajos de la
 * distancia ({@code n & 31}). Para ver 8 bits, enmascara con {@code 0xFF}:
 * {@code ~} sobre un {@code int} invierte los 32 bits, no solo los 8 de la derecha.</p>
 *
 * @author Agustin. A. Marquez. Pina
 * @since 26/10/2026
 * @see <a href="mailto:agu1406@outlook.es">agu1406@outlook.es</a>
 * @see <a href="https://github.com/Agu1406/ClasesParticulares">Repositorio GitHub</a>
 * @see <a href="https://www.agustinmarquez.dev">Sitio web</a>
 */
public class U04_OperadoresBitABit {

    /** Leer. */
    private static final int PERMISO_LEER = 1 << 0;

    /** Escribir. */
    private static final int PERMISO_ESCRIBIR = 1 << 1;

    /** Ejecutar. */
    private static final int PERMISO_EJECUTAR = 1 << 2;

    public static void main(String[] args) {
        System.out.println();
        System.out.println("¡INICIO DEL PROGRAMA!");
        System.out.println();

        /*
        PRIMERA PARTE - Ocho bits, el mas significativo a la izquierda.
        */
        System.out.println("--- PRIMERA PARTE: Binario ---");
        System.out.println();

        int numero = 45;
        System.out.println(numero + " en binario = " + bits8(numero));
        int otro = 12;
        System.out.println(otro + " en binario = " + bits8(otro));
        System.out.println();

        /*
        SEGUNDA PARTE - &  |  ^  ~
          Se muestra solo el byte de la derecha para poder leerlo.
        */
        System.out.println("--- SEGUNDA PARTE: &, |, ^, ~ ---");
        System.out.println();

        int izq = 45;
        int der = 12;
        System.out.println("a     = " + bits8(izq) + " (" + izq + ")");
        System.out.println("b     = " + bits8(der) + " (" + der + ")");
        System.out.println("a & b = " + bits8(izq & der) + " (" + (izq & der) + ")");
        System.out.println("a | b = " + bits8(izq | der) + " (" + (izq | der) + ")");
        System.out.println("a ^ b = " + bits8(izq ^ der) + " (" + (izq ^ der) + ")");
        System.out.println("~a    = " + bits8(~izq) + " (" + ( (~izq) & 0xFF ) + " en 8 bits)");
        System.out.println();

        /*
        TERCERA PARTE - Desplazamientos.
          << y >> sobre positivos coinciden con * y / por potencias de 2.
          >>> rellena con ceros: en un negativo se ve la diferencia con >>.
        */
        System.out.println("--- TERCERA PARTE: << >> >>> ---");
        System.out.println();

        int x = 5;
        System.out.println(x + " << 1 = " + (x << 1));
        System.out.println(x + " << 3 = " + (x << 3) + "  (5 * 8)");
        System.out.println("40 >> 1 = " + (40 >> 1));
        System.out.println("40 >> 3 = " + (40 >> 3) + "  (40 / 8)");
        System.out.println("1 << 10 = " + (1 << 10) + "  (2 elevado a 10)");
        System.out.println("-8 >> 1  = " + (-8 >> 1) + "  (conserva el signo)");
        System.out.println("-8 >>> 1 = " + (-8 >>> 1) + "  (rellena con ceros)");
        System.out.println();

        /*
        CUARTA PARTE - Mascaras: un bit concreto.
          ENCENDER el bit n:   valor |= (1 << n)
          APAGAR el bit n:     valor &= ~(1 << n)
          INVERTIR el bit n:   valor ^= (1 << n)
          COMPROBAR el bit n:  (valor >> n) & 1
        */
        System.out.println("--- CUARTA PARTE: Mascaras ---");
        System.out.println();

        int v = 0;
        System.out.println("inicial    : " + bits8(v));
        v |= (1 << 3);
        System.out.println("encender 3 : " + bits8(v));
        v |= (1 << 0);
        System.out.println("encender 0 : " + bits8(v));
        v ^= (1 << 3);
        System.out.println("invertir 3 : " + bits8(v));
        v &= ~(1 << 0);
        System.out.println("apagar 0   : " + bits8(v));

        int w = 0x25;
        System.out.println("bit 5 de 0x25 = " + ((w >> 5) & 1) + ", bit 4 = " + ((w >> 4) & 1));
        System.out.println();

        /*
        QUINTA PARTE - Varias opciones en un solo entero.
          Cada permiso ocupa un bit. Es la idea de los permisos rwx.
        */
        System.out.println("--- QUINTA PARTE: Permisos ---");
        System.out.println();

        int permisos = PERMISO_LEER | PERMISO_ESCRIBIR;
        System.out.println("permisos = " + permisos + "  " + bits8(permisos));
        System.out.println("puede leer?     " + tiene(permisos, PERMISO_LEER));
        System.out.println("puede ejecutar? " + tiene(permisos, PERMISO_EJECUTAR));

        permisos |= PERMISO_EJECUTAR;
        permisos &= ~PERMISO_ESCRIBIR;
        System.out.println("tras cambios: leer=" + tiene(permisos, PERMISO_LEER)
                + " escribir=" + tiene(permisos, PERMISO_ESCRIBIR)
                + " ejecutar=" + tiene(permisos, PERMISO_EJECUTAR));
        System.out.println();
        System.out.println("¡FIN DEL PROGRAMA!");
        System.out.println();
    }

    /** Ocho bits de la derecha, el mas significativo primero. */
    private static String bits8(int valor) {
        String texto = "";
        for (int bit = 7; bit >= 0; bit--) {
            texto = texto + ((valor >> bit) & 1);
        }
        return texto;
    }

    private static String tiene(int permisos, int mascara) {
        if ((permisos & mascara) != 0) {
            return "si";
        }
        return "no";
    }
}
