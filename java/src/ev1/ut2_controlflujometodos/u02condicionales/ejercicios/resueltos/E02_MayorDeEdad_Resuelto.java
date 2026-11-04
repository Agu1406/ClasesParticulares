package ev1.ut2_controlflujometodos.u02condicionales.ejercicios.resueltos;

/**
 * <p><b>OBJETIVO:</b> Con la edad 20, usa un if para mostrar Mayor de edad si es 18 o mas.</p>
 *
 * <br>
 *
 * <p><b>SOLUCIÓN:</b> La condicion {@code edad >= 18} escribe Mayor de edad.</p>
 *
 * @author Agustin. A. Marquez. Pina
 * @since 29/04/2026
 * @see <a href="mailto:agu1406@outlook.es">agu1406@outlook.es</a>
 * @see <a href="https://github.com/Agu1406/ClasesParticulares">Repositorio GitHub</a>
 * @see <a href="https://www.agustinmarquez.dev">Sitio web</a>
 */
public class E02_MayorDeEdad_Resuelto {
    public static void main(String[] args) {
        int edad = 20;
        if (edad >= 18) {
            System.out.println("Mayor de edad");
        }
    }
}
