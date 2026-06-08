package ev1.ut2_controlflujometodos.u05repaso.teoria;

/**
 * Teoria: bucle {@code for} combinado con condicionales.
 *
 * <p><b>Objetivo:</b> recorrer un rango conocido y aplicar decisiones en cada vuelta.</p>
 *
 * <p><b>Patron tipico:</b> el {@code for} controla <em>cuantas veces</em> iteras; el
 * {@code if} / {@code switch} decide <em>que hacer</em> con cada valor.</p>
 *
 * <ul>
 *   <li><b>for + if</b> - filtrar (solo multiplos de 3, solo vocales, solo primos).</li>
 *   <li><b>for + if-else</b> - clasificar cada numero (par/impar, mayor/menor que X).</li>
 *   <li><b>for + switch</b> - traducir un indice a etiquetas (dias, notas, estaciones).</li>
 * </ul>
 *
 * <p>Ejercicios de referencia: 1, 3, 5, 8, 11, 14, 17, 20, 23, 26, 29 en {@code ejercicios/}.</p>
 *
 * @author Agustin. A. Marquez. Pina
 * @since 08/06/2026
 * @see <a href="mailto:agu1406@outlook.es">agu1406@outlook.es</a>
 * @see <a href="https://github.com/Agu1406/ClasesParticulares">Repositorio GitHub</a>
 * @see <a href="https://www.agustinmarquez.dev">Sitio web</a>
 */
public class U02_ForConCondicionalesIntro {

    public static void main(String[] args) {
        int indice;
        System.out.println("--- for + if: multiplos de 3 (1..15) ---");
        for (indice = 1; indice <= 15; indice++) {
            if (indice % 3 == 0) {
                System.out.println(indice);
            }
        }
        System.out.println("--- for + if-else: par o impar ---");
        for (indice = 1; indice <= 6; indice++) {
            if (indice % 2 == 0) {
                System.out.println(indice + " PAR");
            } else {
                System.out.println(indice + " IMPAR");
            }
        }
        System.out.println("--- for + switch: dias 1..3 ---");
        for (indice = 1; indice <= 3; indice++) {
            switch (indice) {
                case 1:
                    System.out.println("Lunes");
                    break;
                case 2:
                    System.out.println("Martes");
                    break;
                case 3:
                    System.out.println("Miercoles");
                    break;
                default:
                    System.out.println("Otro dia");
            }
        }
    }
}
