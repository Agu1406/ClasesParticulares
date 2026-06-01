package madrid.iescanaveral.ejercicios.convocatoria2022;

/**
 * Ejercicio 6: ¿Cuál es la salida del siguiente código? - RESUELTO
 * 
 * RESPUESTA: 2
 * 
 * Explicación:
 * - i va de 0 a 2 (0, 1, 2)
 * - j va de 1 a 3 (1, 2, 3)
 * - k va de 2 a 4 (2, 3, 4)
 * - La condición (i == j) && (j == k) solo se cumple cuando i=2, j=2, k=2
 * - Por lo tanto, imprime 2
 * 
 * @author Agustín. A. Marquez. Piña
 * @since 14/01/2026
 * @see <a href="mailto:agu1406@outlook.es">agu1406@outlook.es</a>
 * @see <a href="https://github.com/Agu1406/ClasesParticulares">Repositorio GitHub</a>
 * @see <a href="https://www.agustinmarquez.dev">Sitio web</a>
 */
public class Ejercicio6_BuclesAnidados_RESUELTO {
    public static void main(String[] args) {
        int i, j, k;
        for (i = 0; i < 3; i++) {
            for (j = 1; j < 4; j++) {
                for (k = 2; k < 5; k++) {
                    if ((i == j) && (j == k)) {
                        System.out.println(i);  // Imprime 2
                    }
                }
            }
        }
        
        // Análisis detallado:
        // i=0: j puede ser 1,2,3; k puede ser 2,3,4 -> nunca i==j
        // i=1: j puede ser 1,2,3; k puede ser 2,3,4 -> i==j solo si j=1, pero k nunca es 1
        // i=2: j puede ser 1,2,3; k puede ser 2,3,4 -> i==j==k solo si j=2 y k=2
    }
}
