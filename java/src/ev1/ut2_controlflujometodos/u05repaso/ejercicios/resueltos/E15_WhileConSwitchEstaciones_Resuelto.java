package ev1.ut2_controlflujometodos.u05repaso.ejercicios.resueltos;

/**
 * <p><b>OBJETIVO:</b> Recorre meses y muestra estacion con switch.</p>
 *
 * <br>
 *
 * <p><b>SOLUCIÓN:</b> El main recorre meses y muestra estacion con switch.</p>
 *
 * @author Agustin. A. Marquez. Pina
 * @since 29/05/2026
 * @see <a href="mailto:agu1406@outlook.es">agu1406@outlook.es</a>
 * @see <a href="https://github.com/Agu1406/ClasesParticulares">Repositorio GitHub</a>
 * @see <a href="https://www.agustinmarquez.dev">Sitio web</a>
 */

public class E15_WhileConSwitchEstaciones_Resuelto {
    public static void main(String[] args) {
        int mes = 1;
        while (mes <= 12) {
            switch (mes) {
                case 12, 1, 2 -> System.out.println("Mes " + mes + ": Invierno");
                case 3, 4, 5 -> System.out.println("Mes " + mes + ": Primavera");
                case 6, 7, 8 -> System.out.println("Mes " + mes + ": Verano");
                case 9, 10, 11 -> System.out.println("Mes " + mes + ": Otono");
                default -> System.out.println("Mes invalido");
            }
            mes++;
        }
    }
}
