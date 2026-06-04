package ev3.ut6.u01herenciapolimorfismo.practicas.madridiescalderonbarcaestacionconcepcion;

/**
 * Tren_SIN_RESOLVER de la linea 6 que para en Concepcion.
 *
 * @author Agustin. A. Marquez. Pina
 * @since 29/05/2026
 * @see <a href="mailto:agu1406@outlook.es">agu1406@outlook.es</a>
 * @see <a href="https://github.com/Agu1406/ClasesParticulares">Repositorio GitHub</a>
 * @see <a href="https://www.agustinmarquez.dev">Sitio web</a>
 */
public class Tren_SIN_RESOLVER {

    private final int numero;
    private final int capacidad;
    private int ocupacion;
    private final String sentido;

    public Tren_SIN_RESOLVER(int numero, int capacidad, String sentido) {
        this.numero = numero;
        this.capacidad = capacidad;
        this.sentido = sentido;
        this.ocupacion = 0;
    }

    public int getNumero() {
        return numero;
    }

    public int getCapacidad() {
        return capacidad;
    }

    public int getOcupacion() {
        return ocupacion;
    }

    public String getSentido() {
        return sentido;
    }

    public int plazasLibres() {
        return capacidad - ocupacion;
    }

    public boolean hayPlaza() {
        return ocupacion < capacidad;
    }

    public void subirPasajero() {
        if (hayPlaza()) {
            ocupacion++;
        }
    }

    public void bajarPasajeros(int cantidad) {
        if (cantidad < 0 || cantidad > ocupacion) {
            throw new IllegalArgumentException("Cantidad de bajadas no valida.");
        }
        ocupacion -= cantidad;
    }

    @Override
    public String toString() {
        return "Tren_SIN_RESOLVER " + numero + " (" + sentido + ") - " + ocupacion + "/" + capacidad + " plazas";
    }
}
