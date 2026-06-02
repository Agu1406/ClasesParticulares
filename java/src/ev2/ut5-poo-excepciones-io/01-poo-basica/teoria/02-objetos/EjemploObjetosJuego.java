package general.poobasico.objetos;

public class EjemploObjetosJuego {
    public static void main(String[] args) {
        Jugador jugador1 = new Jugador("Diego", 19);
        jugador1.online = true;
        jugador1.saldo = 25.75;

        Jugador jugador2 = new Jugador("Lucia", 21);
        jugador2.online = false;
        jugador2.saldo = 8.40;

        Partida partida = new Partida("Bosque Sombrio", 10, true);
        Inventario inventario = new Inventario("Pocion", 3, 1.2);

        System.out.println("Jugador 1: " + jugador1.nombre + ", edad " + jugador1.edad);
        System.out.println("Jugador 2: " + jugador2.nombre + ", edad " + jugador2.edad);
        System.out.println("Partida: " + partida.nombreMapa + ", max " + partida.maxJugadores);
        System.out.println("Inventario: " + inventario.objeto + " x" + inventario.cantidad);
    }
}
