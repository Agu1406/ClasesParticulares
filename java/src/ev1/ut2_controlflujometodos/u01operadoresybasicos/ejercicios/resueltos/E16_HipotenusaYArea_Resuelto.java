package ev1.ut2_controlflujometodos.u01operadoresybasicos.ejercicios.resueltos;

/**
 * <p><b>OBJETIVO:</b> Con los catetos 3 y 4, calcula la hipotenusa y el área
 * de un triángulo rectángulo y muéstralas con dos decimales.</p>
 *
 * <br>
 *
 * <p><b>SOLUCIÓN:</b> {@code Math.sqrt(c1 * c1 + c2 * c2)} y {@code c1 * c2 / 2.0}.
 * Sale 5.00 y 6.00.</p>
 *
 * @author Agustin. A. Marquez. Pina
 * @since 26/10/2026
 * @see <a href="mailto:agu1406@outlook.es">agu1406@outlook.es</a>
 * @see <a href="https://github.com/Agu1406/ClasesParticulares">Repositorio GitHub</a>
 * @see <a href="https://www.agustinmarquez.dev">Sitio web</a>
 */
public class E16_HipotenusaYArea_Resuelto {
    public static void main(String[] args) {
        double c1 = 3;
        double c2 = 4;
        double hipotenusa = Math.sqrt(c1 * c1 + c2 * c2);
        double area = c1 * c2 / 2.0;
        System.out.printf("Hipotenusa: %.2f%n", hipotenusa);
        System.out.printf("Area: %.2f%n", area);
    }
}
