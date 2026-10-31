package ev1.ut2_controlflujometodos.u01operadoresybasicos.ejercicios.resueltos;

/**
 * <p><b>OBJETIVO:</b> Con tres enteros fijos, muestra su media aritmética en {@code double}.</p>
 *
 * <br>
 *
 * <p><b>SOLUCIÓN:</b> Hay que dividir entre {@code 3.0}. Si se divide entre {@code 3},
 * la media de 6, 8 y 10 saldría 8 en vez de 8.0.</p>
 *
 * @author Agustin. A. Marquez. Pina
 * @since 26/10/2026
 * @see <a href="mailto:agu1406@outlook.es">agu1406@outlook.es</a>
 * @see <a href="https://github.com/Agu1406/ClasesParticulares">Repositorio GitHub</a>
 * @see <a href="https://www.agustinmarquez.dev">Sitio web</a>
 */
public class E14_MediaTres_Resuelto {
    public static void main(String[] args) {
        int a = 6;
        int b = 8;
        int c = 10;
        double media = (a + b + c) / 3.0;
        System.out.println(media);
    }
}
