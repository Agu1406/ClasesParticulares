package ev3.ut6_pooavanzadaestructuras.u01herenciapolimorfismo.teoria.U03_Polimorfismo.Empleado;

/**
 * Teoria: polimorfismo con empleados y nominas.
 *
 * <p>Misma llamada {@code calcularNomina()} sobre un array de {@link Empleado}:
 * asalariado devuelve sueldo fijo; por horas multiplica horas × precio.</p>
 *
 * @author Agustin. A. Marquez. Pina
 * @since 11/10/2026
 * @see Empleado
 * @see EmpleadoAsalariado
 * @see EmpleadoPorHoras
 * @see <a href="mailto:agu1406@outlook.es">agu1406@outlook.es</a>
 * @see <a href="https://github.com/Agu1406/ClasesParticulares">Repositorio GitHub</a>
 * @see <a href="https://www.agustinmarquez.dev">Sitio web</a>
 */
public class Main {

    public static void main(String[] args) {
        System.out.println("=== POLIMORFISMO: array de Empleado ===\n");

        Empleado[] plantilla = new Empleado[4];
        // Con edad (AllArgs del padre)
        plantilla[0] = new EmpleadoAsalariado("Ana", "11111111A", 30, 1800);
        // Sin edad (AnyArgs del padre → edad null / "desconocido")
        plantilla[1] = new EmpleadoPorHoras("Luis", "22222222B", 80, 12.5);
        plantilla[2] = new EmpleadoAsalariado("Maria", "33333333C", 2200);
        plantilla[3] = new EmpleadoPorHoras("Pablo", "44444444D", 25, 40, 15);

        System.out.println("--- Nominas (enlace dinamico) ---");
        double total = 0;
        for (Empleado e : plantilla) {
            double nomina = e.calcularNomina();
            System.out.println(e.getNombre() + " → " + nomina + " €");
            total += nomina;
        }
        System.out.println("Total nominas: " + total + " €");

        System.out.println("\n--- toString ---");
        for (Empleado e : plantilla) {
            System.out.println(e);
        }

        System.out.println("\n=== instanceof + downcast ===");
        for (Empleado e : plantilla) {
            if (e instanceof EmpleadoAsalariado) {
                EmpleadoAsalariado a = (EmpleadoAsalariado) e;
                System.out.println(a.getNombre() + " sueldo fijo=" + a.getSueldoMensual());
            } else if (e instanceof EmpleadoPorHoras) {
                EmpleadoPorHoras h = (EmpleadoPorHoras) e;
                System.out.println(h.getNombre() + " horas=" + h.getHorasTrabajadas()
                        + " €/h=" + h.getPrecioHora());
            }
        }
    }
}
