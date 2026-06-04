package ev3.ut6.u04repaso.practicas.madridiescanaveralconvocatoria2022;

/**
 * Ejercicio 6: ?Cual es la salida del siguiente codigo?
 * 
 * Analiza el comportamiento de bucles anidados y condiciones.
 * 
 * @author Agustin. A. Marquez. Pina
 * @since 14/01/2026
 * @see <a href="mailto:agu1406@outlook.es">agu1406@outlook.es</a>
 * @see <a href="https://github.com/Agu1406/ClasesParticulares">Repositorio GitHub</a>
 * @see <a href="https://www.agustinmarquez.dev">Sitio web</a>
 */
public class Ejercicio6_BuclesAnidados_SIN_RESOLVER {
    public static void main(String[] args) {
        int i, j, k;
        for (i = 0; i < 3; i++) {
            for (j = 1; j < 4; j++) {
                for (k = 2; k < 5; k++) {
                    if ((i == j) && (j == k)) {
                        System.out.println(i);
                    }
                }
            }
        }
    }
}
