package ev1.ut2_controlflujometodos.u02condicionales.ejercicios.resueltos;

/**
 * <p><b>OBJETIVO:</b> Con el entero 14, usa un if para mostrar Esta en rango si esta entre 10 y 20, incluidos.</p>
 *
 * <br>
 *
 * <p><b>SOLUCIÓN:</b> {@code numero >= 10 && numero <= 20} escribe Esta en rango.</p>
 *
 * @author Agustin. A. Marquez. Pina
 * @since 29/04/2026
 * @see <a href="mailto:agu1406@outlook.es">agu1406@outlook.es</a>
 * @see <a href="https://github.com/Agu1406/ClasesParticulares">Repositorio GitHub</a>
 * @see <a href="https://www.agustinmarquez.dev">Sitio web</a>
 */
public class E06_NumeroEnRango_Resuelto {
    public static void main(String[] args) {
        int numero = 14;
        if (numero >= 10 && numero <= 20) {
            System.out.println("Esta en rango");
        }
    }
}
