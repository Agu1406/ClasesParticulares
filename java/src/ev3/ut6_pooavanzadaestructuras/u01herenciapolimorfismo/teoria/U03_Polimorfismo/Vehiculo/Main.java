package ev3.ut6_pooavanzadaestructuras.u01herenciapolimorfismo.teoria.U03_Polimorfismo.Vehiculo;

/**
 * Teoria: polimorfismo con vehiculos (misma llamada, distinto comportamiento).
 *
 * <p><b>Objetivo:</b> usar una referencia de supertipo ({@link Vehiculo}) que apunta a
 * objetos de subtipos ({@link Coche}, {@link Moto}). Al llamar {@code acelerar()} se
 * ejecuta la version de la clase real (enlace dinamico). Utilizar {@code instanceof}
 * cuando haga falta bajar al tipo concreto.</p>
 *
 * @author Agustin. A. Marquez. Pina
 * @since 11/10/2026
 * @see Vehiculo
 * @see Coche
 * @see Moto
 * @see <a href="mailto:agu1406@outlook.es">agu1406@outlook.es</a>
 * @see <a href="https://github.com/Agu1406/ClasesParticulares">Repositorio GitHub</a>
 * @see <a href="https://www.agustinmarquez.dev">Sitio web</a>
 */
public class Main {

    public static void main(String[] args) {
        System.out.println("=== POLIMORFISMO: array de Vehiculo ===\n");

        Vehiculo[] flota = new Vehiculo[4];
        // AnyArgsConstructor del padre (motorEncendido = false por defecto)
        flota[0] = new Coche("1234ABC", "rojo", "Seat", 0, 180, 5);
        flota[1] = new Moto("5678XYZ", "negro", "Yamaha", 0, 220, false);
        // AllArgsConstructor (motor ya encendido)
        flota[2] = new Coche("9999ZZZ", "blanco", "Tesla", 0, 250, true, 4);
        flota[3] = new Moto("1111AAA", "azul", "Harley", 0, 200, true, true);

        System.out.println("--- Encender motores apagados ---");
        for (Vehiculo v : flota) {
            if (v.getMotorEncendido() != null && !v.getMotorEncendido()) {
                v.encenderMotor();
                System.out.println(v.getMarca() + " motor encendido.");
            }
        }

        System.out.println("\n--- Acelerar (enlace dinamico) ---");
        for (Vehiculo v : flota) {
            v.acelerar();
        }

        System.out.println("\n--- toString ---");
        for (Vehiculo v : flota) {
            System.out.println(v);
        }

        System.out.println("\n=== instanceof + downcast ===");
        for (Vehiculo v : flota) {
            if (v instanceof Coche) {
                Coche c = (Coche) v;
                System.out.println(c.getMatricula() + " " + c.getMarca()
                        + " tiene " + c.getPuertas() + " puertas");
            } else if (v instanceof Moto) {
                Moto m = (Moto) v;
                System.out.println(m.getMatricula() + " " + m.getMarca()
                        + " sidecar=" + m.isTieneSidecar());
            }
        }
    }
}
