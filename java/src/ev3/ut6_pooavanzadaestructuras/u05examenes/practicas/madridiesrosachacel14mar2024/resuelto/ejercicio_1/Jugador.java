package ev3.ut6_pooavanzadaestructuras.u05examenes.practicas.madridiesrosachacel14mar2024.resuelto.ejercicio_1;

import java.util.ArrayList;
import java.util.List;

/**
 * Jugador de la partida: nombre, puntuacion y mano de cartas.
 */
public class Jugador {

	private final String nombre;
	private int puntuacion;
	private final List<Carta> mano = new ArrayList<>();
	private Baraja baraja;

	public Jugador(String nombre) {
		this.nombre = nombre;
		this.puntuacion = 0;
	}

	public void enlazarBaraja(Baraja baraja) {
		this.baraja = baraja;
	}

	public void recibirCarta(Carta carta) {
		mano.add(carta);
		baraja.eliminar(carta);
	}

	public Carta jugarCarta(String palo) {
		Carta cartaJugada = null;

		for (Carta carta : mano) {
			if (carta.getPalo().equals(palo)) {
				if (cartaJugada == null || carta.getNumero() > cartaJugada.getNumero()) {
					cartaJugada = carta;
				}
			}
		}

		if (cartaJugada == null) {
			System.out.println("Paso");
			return null;
		}

		mano.remove(cartaJugada);
		System.out.println("Jugando el numero " + cartaJugada.getNumero() + " de " + cartaJugada.getPalo());
		return cartaJugada;
	}

	public void mostrarMano() {
		for (Carta carta : mano) {
			System.out.println(carta);
		}
	}

	public void sumarPunto() {
		puntuacion++;
	}

	public String getNombre() {
		return nombre;
	}

	public int getPuntuacion() {
		return puntuacion;
	}

	public int getTamanoMano() {
		return mano.size();
	}
}
