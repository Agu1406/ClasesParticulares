package ev1.ut2_controlflujometodos.u02condicionales.ejercicios.resueltos;

/**
 * <p><b>OBJETIVO:</b> Con el anio 2023, usa if-else para mostrar Bisiesto o No bisiesto si es divisible entre 4.</p>
 *
 * <br>
 *
 * <p><b>SOLUCIÓN:</b> {@code anio % 4 == 0} escribe Bisiesto. 2023 entra en else.</p>
 *
 * @author Agustin. A. Marquez. Pina
 * @since 29/04/2026
 * @see <a href="mailto:agu1406@outlook.es">agu1406@outlook.es</a>
 * @see <a href="https://github.com/Agu1406/ClasesParticulares">Repositorio GitHub</a>
 * @see <a href="https://www.agustinmarquez.dev">Sitio web</a>
 */
public class E17_AnioBisiesto_Resuelto {
    public static void main(String[] args) {
        int anio = 2023;
        if (anio % 4 == 0) {
            System.out.println("Bisiesto");
        } else {
            System.out.println("No bisiesto");
        }
    }
}
