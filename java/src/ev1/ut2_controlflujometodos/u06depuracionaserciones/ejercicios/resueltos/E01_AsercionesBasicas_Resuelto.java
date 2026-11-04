package ev1.ut2_controlflujometodos.u06depuracionaserciones.ejercicios.resueltos;

/**
 * <p><b>OBJETIVO:</b> n vale -1. Anade una asercion que compruebe que n es positivo
 * e imprime n = con su valor.</p>
 *
 * <br>
 *
 * <p><b>SOLUCIÓN:</b> En la version resuelta n vale 5, asi que {@code assert n &gt; 0}
 * pasa y se imprime el valor. Con -ea y n negativo el programa se detiene.</p>
 *
 * @author Agustin. A. Marquez. Pina
 * @since 03/06/2026
 * @see <a href="mailto:agu1406@outlook.es">agu1406@outlook.es</a>
 * @see <a href="https://github.com/Agu1406/ClasesParticulares">Repositorio GitHub</a>
 * @see <a href="https://www.agustinmarquez.dev">Sitio web</a>
 */
public class E01_AsercionesBasicas_Resuelto {
    public static void main(String[] args) {
        int n = 5;
        assert n > 0 : "n debe ser positivo";
        System.out.println("n = " + n);
    }
}
