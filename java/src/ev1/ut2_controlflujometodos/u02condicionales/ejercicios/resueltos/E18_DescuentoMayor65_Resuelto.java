package ev1.ut2_controlflujometodos.u02condicionales.ejercicios.resueltos;

/**
 * <p><b>OBJETIVO:</b> Con la edad 70, usa if-else para mostrar Tiene descuento o Sin descuento a partir de 65 anios.</p>
 *
 * <br>
 *
 * <p><b>SOLUCIÓN:</b> {@code edad >= 65} escribe Tiene descuento.</p>
 *
 * @author Agustin. A. Marquez. Pina
 * @since 29/04/2026
 * @see <a href="mailto:agu1406@outlook.es">agu1406@outlook.es</a>
 * @see <a href="https://github.com/Agu1406/ClasesParticulares">Repositorio GitHub</a>
 * @see <a href="https://www.agustinmarquez.dev">Sitio web</a>
 */
public class E18_DescuentoMayor65_Resuelto {
    public static void main(String[] args) {
        int edad = 70;
        if (edad >= 65) {
            System.out.println("Tiene descuento");
        } else {
            System.out.println("Sin descuento");
        }
    }
}
