package ev2.ut5_pooexcepcionesio.u01poobasica.teoria;

/**
 * Demo de clase: partida / mapa de un videojuego.
 *
 * <p><b>Objetivo:</b> otra clase del mismo dominio que {@link U07_Jugador}, para
 * mostrar varios tipos de objetos relacionados.</p>
 *
 * @author Agustin. A. Marquez. Pina
 * @since 05/09/2026
 * @see U07_EjemploObjetosJuego
 * @see <a href="mailto:agu1406@outlook.es">agu1406@outlook.es</a>
 * @see <a href="https://github.com/Agu1406/ClasesParticulares">Repositorio GitHub</a>
 * @see <a href="https://www.agustinmarquez.dev">Sitio web</a>
 */
public class U07_Partida {

    public String nombreMapa;
    public int maxJugadores;
    public boolean clasificada;

    public U07_Partida(String nombreMapa, int maxJugadores, boolean clasificada) {
        this.nombreMapa = nombreMapa;
        this.maxJugadores = maxJugadores;
        this.clasificada = clasificada;
    }
}
