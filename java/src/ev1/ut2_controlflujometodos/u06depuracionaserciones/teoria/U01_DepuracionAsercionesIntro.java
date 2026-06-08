package ev1.ut2_controlflujometodos.u06depuracionaserciones.teoria;

/**
 * Teoria: depuracion con aserciones en Java (RA3.i).
 *
 * <p>Objetivo: detectar errores durante desarrollo con {@code assert}.</p>
 */
public class U01_DepuracionAsercionesIntro {

    public static int dividir(int a, int b) {
        assert b != 0 : "El divisor no puede ser cero";
        return a / b;
    }
}
