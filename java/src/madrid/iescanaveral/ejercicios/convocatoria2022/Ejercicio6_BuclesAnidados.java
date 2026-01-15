package madrid.iescanaveral.ejercicios.convocatoria2022;

/**
 * Ejercicio 6: ¿Cuál es la salida del siguiente código?
 * 
 * Analiza el comportamiento de bucles anidados y condiciones.
 * 
 * @author Agustín. A. Marquez. Piña
 * @since 14/01/2026
 * @see <a href="mailto:agu1406@outlook.es">agu1406@outlook.es</a>
 * @see <a href="https://github.com/Agu1406/ClasesParticulares">Repositorio GitHub</a>
 * @see <a href="https://agu1406.github.io/ClasesParticulares">GitHub Pages</a>
 */
public class Ejercicio6_BuclesAnidados {
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
