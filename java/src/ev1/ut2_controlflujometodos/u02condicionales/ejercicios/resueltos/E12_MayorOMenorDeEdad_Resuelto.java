package ev1.ut2_controlflujometodos.u02condicionales.ejercicios.resueltos;

/**
 * <p><b>OBJETIVO:</b> Con la edad 16, usa if-else para mostrar Mayor de edad o Menor de edad.</p>
 *
 * <br>
 *
 * <p><b>SOLUCIÓN:</b> {@code edad >= 18} elige Mayor de edad. El 16 entra en else.</p>
 *
 * @author Agustin. A. Marquez. Pina
 * @since 29/04/2026
 * @see <a href="mailto:agu1406@outlook.es">agu1406@outlook.es</a>
 * @see <a href="https://github.com/Agu1406/ClasesParticulares">Repositorio GitHub</a>
 * @see <a href="https://www.agustinmarquez.dev">Sitio web</a>
 */
public class E12_MayorOMenorDeEdad_Resuelto {
    public static void main(String[] args) {
        int edad = 16;
        if (edad >= 18) {
            System.out.println("Mayor de edad");
        } else {
            System.out.println("Menor de edad");
        }
    }
}
