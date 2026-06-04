package ev2.ut5.u01poobasica.teoria;

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

        System.out.println("U07_Jugador 1: " + jugador1.nombre + ", edad " + jugador1.edad);
        System.out.println("U07_Jugador 2: " + jugador2.nombre + ", edad " + jugador2.edad);
        System.out.println("U07_Partida: " + partida.nombreMapa + ", max " + partida.maxJugadores);
        System.out.println("U07_Inventario: " + inventario.objeto + " x" + inventario.cantidad);
    }
}
