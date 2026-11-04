package ev1.ut2_controlflujometodos.u03bucles.ejercicios.resueltos;

/**
 * <p><b>OBJETIVO:</b> Usa un while para mostrar las potencias de 2 desde 1 hasta 1024, una por linea.</p>
 *
 * <br>
 *
 * <p><b>SOLUCIÓN:</b> valor empieza en 1. Se imprime y se multiplica por 2 mientras sea menor o igual que 1024.</p>
 *
 * @author Agustin. A. Marquez. Pina
 * @since 29/04/2026
 * @see <a href="mailto:agu1406@outlook.es">agu1406@outlook.es</a>
 * @see <a href="https://github.com/Agu1406/ClasesParticulares">Repositorio GitHub</a>
 * @see <a href="https://www.agustinmarquez.dev">Sitio web</a>
 */

public class E16_PotenciasDe2_Resuelto {
    public static void main(String[] args) {
        int valor = 1;
        while (valor <= 1024) {
            System.out.println(valor);
            valor *= 2;
        }
    }
}
