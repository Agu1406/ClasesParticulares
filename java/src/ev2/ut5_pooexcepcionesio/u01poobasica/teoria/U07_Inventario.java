package ev2.ut5_pooexcepcionesio.u01poobasica.teoria;

/**
 * Demo de clase: objeto de inventario de un videojuego.
 *
 * <p><b>Objetivo:</b> tercer tipo de objeto del ejemplo de juego (junto a
 * {@link U07_Jugador} y {@link U07_Partida}).</p>
 *
 * @author Agustin. A. Marquez. Pina
 * @since 05/09/2026
 * @see U07_EjemploObjetosJuego
 * @see <a href="mailto:agu1406@outlook.es">agu1406@outlook.es</a>
 * @see <a href="https://github.com/Agu1406/ClasesParticulares">Repositorio GitHub</a>
 * @see <a href="https://www.agustinmarquez.dev">Sitio web</a>
 */
public class U07_Inventario {

    public String objeto;
    public int cantidad;
    public double pesoTotal;

    public U07_Inventario(String objeto, int cantidad, double pesoTotal) {
        this.objeto = objeto;
        this.cantidad = cantidad;
        this.pesoTotal = pesoTotal;
    }
}
