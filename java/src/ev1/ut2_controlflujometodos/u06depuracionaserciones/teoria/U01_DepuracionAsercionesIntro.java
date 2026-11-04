package ev1.ut2_controlflujometodos.u06depuracionaserciones.teoria;

/**
 * Teoria: depuracion con aserciones en Java (RA3.i).
 *
 * <p><b>OBJETIVO:</b> Detectar errores durante el desarrollo con {@code assert}.</p>
 *
 * <p>Las aserciones solo se comprueban si el programa se ejecuta con {@code -ea}.
 * Practica en {@code ejercicios/pendientes} y {@code ejercicios/resueltos}, el E01.</p>
 *
 * @author Agustin. A. Marquez. Pina
 * @since 03/06/2026
 * @see <a href="mailto:agu1406@outlook.es">agu1406@outlook.es</a>
 * @see <a href="https://github.com/Agu1406/ClasesParticulares">Repositorio GitHub</a>
 * @see <a href="https://www.agustinmarquez.dev">Sitio web</a>
 */
public class U01_DepuracionAsercionesIntro {

    public static int dividir(int a, int b) {
        assert b != 0 : "El divisor no puede ser cero";
        return a / b;
    }

    public static void main(String[] args) {
        System.out.println(dividir(10, 2));
    }
}
