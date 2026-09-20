package ev2.ut5_pooexcepcionesio.u01poobasica.teoria;

/**
 * Demo de clase: varias clases del dominio "juego" trabajando juntas.
 *
 * <p><b>Objetivo:</b> crear instancias independientes de {@link U07_Jugador},
 * {@link U07_Partida} e {@link U07_Inventario} y mostrar que cada objeto guarda
 * sus propios valores. Complementa {@link U07_ObjetosIntro} (clases internas simples).</p>
 *
 * @author Agustin. A. Marquez. Pina
 * @since 05/09/2026
 * @see U07_ObjetosIntro
 * @see <a href="mailto:agu1406@outlook.es">agu1406@outlook.es</a>
 * @see <a href="https://github.com/Agu1406/ClasesParticulares">Repositorio GitHub</a>
 * @see <a href="https://www.agustinmarquez.dev">Sitio web</a>
 */
public class U07_EjemploObjetosJuego {

    public static void main(String[] args) {
        U07_Jugador jugador1 = new U07_Jugador("Diego", 19);
        jugador1.online = true;
        jugador1.saldo = 25.75;

        U07_Jugador jugador2 = new U07_Jugador("Lucia", 21);
        jugador2.online = false;
        jugador2.saldo = 8.40;

        U07_Partida partida = new U07_Partida("Bosque Sombrio", 10, true);
        U07_Inventario inventario = new U07_Inventario("Pocion", 3, 1.2);

        System.out.println("Jugador 1: " + jugador1.nombre + ", edad " + jugador1.edad
                + ", online=" + jugador1.online + ", saldo=" + jugador1.saldo);
        System.out.println("Jugador 2: " + jugador2.nombre + ", edad " + jugador2.edad
                + ", online=" + jugador2.online + ", saldo=" + jugador2.saldo);
        System.out.println("Partida: " + partida.nombreMapa + ", max " + partida.maxJugadores
                + ", clasificada=" + partida.clasificada);
        System.out.println("Inventario: " + inventario.objeto + " x" + inventario.cantidad
                + ", peso=" + inventario.pesoTotal);
    }
}
