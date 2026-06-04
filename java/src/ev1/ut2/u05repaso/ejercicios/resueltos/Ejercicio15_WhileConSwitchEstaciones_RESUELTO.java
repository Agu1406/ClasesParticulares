package ev1.ut2.u05repaso.ejercicios.resueltos;

/**
 * Ejercicio: while con switch
 * Objetivo: Recorre meses y muestra estacion con switch.
 * Version resuelta.
 *
 * @author Agustin. A. Marquez. Pina
 * @since 29/05/2026
 * @see <a href="mailto:agu1406@outlook.es">agu1406@outlook.es</a>
 * @see <a href="https://github.com/Agu1406/ClasesParticulares">Repositorio GitHub</a>
 * @see <a href="https://www.agustinmarquez.dev">Sitio web</a>
 */
public class Ejercicio15_WhileConSwitchEstaciones_RESUELTO {
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
