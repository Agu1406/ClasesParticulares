package ev2.ut5_pooexcepcionesio.u01poobasica.teoria;

/**
 * Demo de clase: jugador de un videojuego (atributos + constructor).
 *
 * <p><b>Objetivo:</b> modelar un jugador con nombre, edad, estado online y saldo.
 * Usado desde {@link U07_EjemploObjetosJuego} junto a {@link U07_Partida} e
 * {@link U07_Inventario}.</p>
 *
 * @author Agustin. A. Marquez. Pina
 * @since 05/09/2026
 * @see U07_EjemploObjetosJuego
 * @see <a href="mailto:agu1406@outlook.es">agu1406@outlook.es</a>
 * @see <a href="https://github.com/Agu1406/ClasesParticulares">Repositorio GitHub</a>
 * @see <a href="https://www.agustinmarquez.dev">Sitio web</a>
 */
public class U07_Jugador {

    /** Atributos comunes a todos los objetos de esta clase. */
    public String nombre;
    public int edad;
    public boolean online;
    public double saldo;

    public U07_Jugador(String nombre, int edad) {
        this.nombre = nombre;
        this.edad = edad;
        this.online = false;
        this.saldo = 0.0;
    }
}
