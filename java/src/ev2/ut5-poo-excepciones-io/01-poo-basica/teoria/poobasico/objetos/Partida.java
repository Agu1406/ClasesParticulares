package ev2.ut4.poobasico.objetos;

public class Partida {
    public String nombreMapa;
    public int maxJugadores;
    public boolean clasificada;

    public Partida(String nombreMapa, int maxJugadores, boolean clasificada) {
        this.nombreMapa = nombreMapa;
        this.maxJugadores = maxJugadores;
        this.clasificada = clasificada;
    }
}
