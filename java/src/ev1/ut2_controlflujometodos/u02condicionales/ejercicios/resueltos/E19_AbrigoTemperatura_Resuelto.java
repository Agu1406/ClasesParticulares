package ev1.ut2_controlflujometodos.u02condicionales.ejercicios.resueltos;

/**
 * <p><b>OBJETIVO:</b> Con la temperatura 12, usa if-else para mostrar Ponte abrigo si es menor que 15, y No hace falta abrigo en otro caso.</p>
 *
 * <br>
 *
 * <p><b>SOLUCIÓN:</b> {@code temp < 15} escribe Ponte abrigo.</p>
 *
 * @author Agustin. A. Marquez. Pina
 * @since 29/04/2026
 * @see <a href="mailto:agu1406@outlook.es">agu1406@outlook.es</a>
 * @see <a href="https://github.com/Agu1406/ClasesParticulares">Repositorio GitHub</a>
 * @see <a href="https://www.agustinmarquez.dev">Sitio web</a>
 */
public class E19_AbrigoTemperatura_Resuelto {
    public static void main(String[] args) {
        int temp = 12;
        if (temp < 15) {
            System.out.println("Ponte abrigo");
        } else {
            System.out.println("No hace falta abrigo");
        }
    }
}
