package ev2.ut4_colecciones.u02arraylistymapas.ejercicios.resueltos;

import java.util.HashMap;

/**
 * <p><b>OBJETIVO:</b> Cuenta cuantas notas son mayores o iguales que 5: Ana 8.0, Luis 4.5, Marta 6.0 y Pedro 3.0.</p>
 *
 * <br>
 *
 * <p><b>SOLUCIÓN:</b> Se recorren los values. Ana y Marta aprueban, asi que el contador queda en 2.</p>
 *
 * @author Agustin. A. Marquez. Pina
 * @since 29/05/2026
 * @see <a href="mailto:agu1406@outlook.es">agu1406@outlook.es</a>
 * @see <a href="https://github.com/Agu1406/ClasesParticulares">Repositorio GitHub</a>
 * @see <a href="https://www.agustinmarquez.dev">Sitio web</a>
 */
public class E17_HashMapContarAprobados_Resuelto {
    public static void main(String[] args) {
        HashMap<String, Double> notas = new HashMap<>();
        notas.put("Ana", 8.0);
        notas.put("Luis", 4.5);
        notas.put("Marta", 6.0);
        notas.put("Pedro", 3.0);

        int aprobados = 0;
        for (double nota : notas.values()) {
            if (nota >= 5.0) {
                aprobados++;
            }
        }
        System.out.println("Aprobados: " + aprobados);
    }
}
