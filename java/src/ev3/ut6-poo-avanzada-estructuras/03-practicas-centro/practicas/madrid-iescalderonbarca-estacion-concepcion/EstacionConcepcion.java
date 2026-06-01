package madrid.iescalderonbarca.ejercicios.estacionconcepcion;

import java.util.ArrayList;
import java.util.List;

/**
 * Estación Concepción (Línea 6, Metro de Madrid).
 *
 * <p>Enunciado en {@code estacion-concepcion--madrid-iescalderonbarca.pdf} (misma carpeta).</p>
 *
 * @author Agustín. A. Marquez. Piña
 * @since 29/05/2026
 * @see <a href="mailto:agu1406@outlook.es">agu1406@outlook.es</a>
 * @see <a href="https://github.com/Agu1406/ClasesParticulares">Repositorio GitHub</a>
 * @see <a href="https://www.agustinmarquez.dev">Sitio web</a>
 */
public class EstacionConcepcion {

    private static final String NOMBRE = "Concepción";
    private static final int LINEA = 6;

    private final List<Pasajero> anden;
    private int totalEmbarcados;
    private int trenesAtendidos;

    public EstacionConcepcion() {
        this.anden = new ArrayList<>();
        this.totalEmbarcados = 0;
        this.trenesAtendidos = 0;
    }

    public String getNombre() {
        return NOMBRE;
    }

    public int getLinea() {
        return LINEA;
    }

    public int getPasajerosEnAnden() {
        return anden.size();
    }

    public int getTotalEmbarcados() {
        return totalEmbarcados;
    }

    public int getTrenesAtendidos() {
        return trenesAtendidos;
    }

    public void registrarLlegadaPasajero(Pasajero pasajero) {
        anden.add(pasajero);
    }

    /**
     * Embarca pasajeros del andén en el tren mientras haya plazas libres.
     *
     * @return número de pasajeros que han subido
     */
    public int embarcarEnTren(Tren tren) {
        int embarcados = 0;
        while (!anden.isEmpty() && tren.hayPlaza()) {
            anden.remove(0);
            tren.subirPasajero();
            embarcados++;
        }
        if (embarcados > 0 || tren.getOcupacion() > 0) {
            trenesAtendidos++;
        }
        totalEmbarcados += embarcados;
        return embarcados;
    }

    public void mostrarEstado() {
        System.out.println();
        System.out.println("=== Estación " + NOMBRE + " (Línea " + LINEA + ") ===");
        System.out.println("Pasajeros en andén: " + anden.size());
        if (anden.isEmpty()) {
            System.out.println("  (anden vacío)");
        } else {
            for (int i = 0; i < anden.size(); i++) {
                System.out.println("  " + (i + 1) + ". " + anden.get(i));
            }
        }
        System.out.println("Trenes atendidos: " + trenesAtendidos);
        System.out.println("Total embarcados hoy: " + totalEmbarcados);
    }
}
