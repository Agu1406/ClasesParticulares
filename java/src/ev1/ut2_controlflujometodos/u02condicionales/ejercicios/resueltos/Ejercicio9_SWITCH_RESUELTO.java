package ev1.ut2_controlflujometodos.u02condicionales.ejercicios.resueltos;

/**
 * Ejercicio 9 (switch): Letra de calificacion por nota
 * Version resuelta.
 *
 * @author Agustin. A. Marquez. Pina
 * @since 29/04/2026
 * @see <a href="mailto:agu1406@outlook.es">agu1406@outlook.es</a>
 * @see <a href="https://github.com/Agu1406/ClasesParticulares">Repositorio GitHub</a>
 * @see <a href="https://www.agustinmarquez.dev">Sitio web</a>
 */
public class Ejercicio9_SWITCH_RESUELTO {
    public static void main(String[] args) {
        int nota = 6;
                switch (nota) {
                    case 10:
                    case 9: System.out.println("A"); break;
                    case 8:
                    case 7: System.out.println("B"); break;
                    case 6:
                    case 5: System.out.println("C"); break;
                    default: System.out.println("D");
                }
    }
}
