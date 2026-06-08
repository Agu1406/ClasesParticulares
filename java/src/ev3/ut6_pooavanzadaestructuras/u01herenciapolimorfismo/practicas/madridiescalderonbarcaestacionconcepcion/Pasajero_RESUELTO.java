package ev3.ut6_pooavanzadaestructuras.u01herenciapolimorfismo.practicas.madridiescalderonbarcaestacionconcepcion;

/**
 * Pasajero_RESUELTO que espera en el anden de Concepcion.
 *
 * @author Agustin. A. Marquez. Pina
 * @since 29/05/2026
 * @see <a href="mailto:agu1406@outlook.es">agu1406@outlook.es</a>
 * @see <a href="https://github.com/Agu1406/ClasesParticulares">Repositorio GitHub</a>
 * @see <a href="https://www.agustinmarquez.dev">Sitio web</a>
  *
 * * PLANTILLA DOCENTE: completar solucion docente.
 */
public class Pasajero_RESUELTO {

    private final String nombre;
    private final String destino;

    public Pasajero_RESUELTO(String nombre, String destino) {
        this.nombre = nombre;
        this.destino = destino;
    }

    public String getNombre() {
        return nombre;
    }

    public String getDestino() {
        return destino;
    }

    @Override
    public String toString() {
        return nombre + " -> " + destino;
    }
}
