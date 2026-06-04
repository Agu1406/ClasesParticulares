/**
 * Teoria: depuracion con aserciones en Java (RA3.i).
 *
 * <p>Objetivo: detectar errores durante desarrollo con {@code assert}.</p>
 */
public class DepuracionAsercionesIntro {

    public static int dividir(int a, int b) {
        assert b != 0 : "El divisor no puede ser cero";
        return a / b;
    }
}
