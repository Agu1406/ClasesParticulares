package ev3.ut6_pooavanzadaestructuras.u05examenes.practicas.madridiesrosachacel14mar2024.pendiente.ejercicio_1;

import java.util.ArrayList;
import java.util.List;

/**
 * Jugador de la partida: nombre, puntuacion y mano de cartas.
 */
public class Jugador {

	private final String nombre;
	private int puntuacion;
	private final List<Carta> mano = new ArrayList<>();

	public Jugador(String nombre) {
		this.nombre = nombre;
		this.puntuacion = 0;
	}

	public void recibirCarta(Carta carta) {
		// TODO: anadir a la mano y eliminar de la baraja
		throw new UnsupportedOperationException();
	}

	public Carta jugarCarta(String palo) {
		// TODO: jugar la carta mas alta del palo o mostrar "Paso"
		throw new UnsupportedOperationException();
	}

	public void mostrarMano() {
		// TODO: mostrar las cartas del jugador
		throw new UnsupportedOperationException();
	}

	public String getNombre() {
		return nombre;
	}

	public int getPuntuacion() {
		return puntuacion;
	}
}
