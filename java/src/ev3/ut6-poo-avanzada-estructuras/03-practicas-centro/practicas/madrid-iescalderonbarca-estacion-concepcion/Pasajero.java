package madrid.iescalderonbarca.ejercicios.estacionconcepcion;

/**
 * Pasajero que espera en el andén de Concepción.
 *
 * @author Agustín. A. Marquez. Piña
 * @since 29/05/2026
 * @see <a href="mailto:agu1406@outlook.es">agu1406@outlook.es</a>
 * @see <a href="https://github.com/Agu1406/ClasesParticulares">Repositorio GitHub</a>
 * @see <a href="https://www.agustinmarquez.dev">Sitio web</a>
 */
public class Pasajero {

    private final String nombre;
    private final String destino;

    public Pasajero(String nombre, String destino) {
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
        return nombre + " → " + destino;
    }
}
