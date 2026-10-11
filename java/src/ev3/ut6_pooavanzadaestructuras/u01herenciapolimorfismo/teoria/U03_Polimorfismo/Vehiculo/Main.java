package ev3.ut6_pooavanzadaestructuras.u01herenciapolimorfismo.teoria.U03_Polimorfismo.Vehiculo;

/**
 * Teoria: polimorfismo con vehiculos (misma llamada, distinto comportamiento).
 *
 * <p><b>Objetivo:</b> usar una referencia de supertipo ({@link Vehiculo}) que apunta a
 * objetos de subtipos ({@link Coche}, {@link Moto}). Al llamar {@code acelerar()} se
 * ejecuta la version de la clase real (enlace dinamico). Utilizar {@code instanceof}
 * cuando haga falta bajar al tipo concreto.</p>
 *
 * <p>Ejemplo paralelo a {@code teoria/U03_Polimorfismo/Figura/} (mismas ideas, otro dominio).</p>
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
        flota[0] = new Coche("Seat", 5);
        flota[1] = new Moto("Yamaha", false);
        flota[2] = new Coche("Tesla", 4);
        flota[3] = new Moto("Harley", true);

        System.out.println("--- Acelerar (enlace dinamico) ---");
        for (Vehiculo v : flota) {
            v.acelerar();
        }

        System.out.println("\n--- toString polimorfico ---");
        for (Vehiculo v : flota) {
            System.out.println(v);
        }

        System.out.println("\n=== instanceof + downcast ===");
        for (Vehiculo v : flota) {
            if (v instanceof Coche) {
                Coche c = (Coche) v;
                System.out.println(c.getMarca() + " tiene " + c.getPuertas() + " puertas");
            } else if (v instanceof Moto) {
                Moto m = (Moto) v;
                System.out.println(m.getMarca() + " sidecar=" + m.isTieneSidecar());
            }
        }
    }
}
