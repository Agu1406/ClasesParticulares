package ev3.ut6_pooavanzadaestructuras.u05examenes.practicas.madridiesrosachacel14mar2024.resuelto.ejercicio_1;

import java.util.Random;

/**
 * <p>Enunciado: {@code madrid-iesrosachacel-examenes-14-mar-2024.pdf} (ejercicio 1).</p>
 *
 * <p><b>OBJETIVO:</b> Modelar un juego de cartas con {@link Carta}, {@link Baraja} y {@link Jugador};
 * repartir manos, jugar la carta mas alta de un palo y finalizar cuando la baraja queda vacia.</p>
 *
 * <br>
 *
 * <p><b>SOLUCION:</b> {@link Baraja} usa {@code Set}; {@link Jugador#recibirCarta(Carta)} elimina de la baraja;
 * el bucle de jugadas repone manos solo cuando ambos pasan y corta al coger la ultima carta.</p>
 *
 * @author Agustin. A. Marquez. Pina
 * @since 03/06/2026
 * @see <a href="mailto:agu1406@outlook.es">agu1406@outlook.es</a>
 * @see <a href="https://github.com/Agu1406/ClasesParticulares">Repositorio GitHub</a>
 * @see <a href="https://www.agustinmarquez.dev">Sitio web</a>
 */
public class Main {

	public static void main(String[] args) {
		Baraja baraja = new Baraja();
		Jugador jugador1 = new Jugador("Ana");
		Jugador jugador2 = new Jugador("Luis");
		jugador1.enlazarBaraja(baraja);
		jugador2.enlazarBaraja(baraja);

		for (int i = 0; i < 10; i++) {
			repartirCarta(jugador1, baraja);
			repartirCarta(jugador2, baraja);
		}

		boolean juegoTerminado = false;
		String paloRonda = elegirPaloAleatorio();

		do {
			Carta carta1 = jugador1.jugarCarta(paloRonda);
			Carta carta2 = jugador2.jugarCarta(paloRonda);

			resolverPuntuacion(jugador1, jugador2, carta1, carta2);

			if (carta1 == null && carta2 == null) {
				juegoTerminado = reponerMano(jugador1, baraja);
				
				if (!juegoTerminado) {
					juegoTerminado = reponerMano(jugador2, baraja);
					paloRonda = elegirPaloAleatorio();
				}
			}

		} while (!juegoTerminado);

		System.out.println();
		System.out.println("Resultado final:");
		System.out.println(jugador1.getNombre() + ": " + jugador1.getPuntuacion() + " puntos");
		System.out.println(jugador2.getNombre() + ": " + jugador2.getPuntuacion() + " puntos");
	}

	private static String elegirPaloAleatorio() {
		String[] palos = {"Oros", "Copas", "Espadas", "Bastos"};
		Random random = new Random();
		String palo = palos[random.nextInt(palos.length)];
		System.out.println("Palo de la ronda: " + palo);
		return palo;
	}

	private static void resolverPuntuacion(Jugador jugador1, Jugador jugador2, Carta carta1, Carta carta2) {
		if (carta1 == null) {
			if (carta2 != null) {
				jugador2.sumarPunto();
			}
		} else if (carta2 == null) {
			jugador1.sumarPunto();
		} else {
			if (carta1.getNumero() > carta2.getNumero()) {
				jugador1.sumarPunto();
			} else if (carta2.getNumero() > carta1.getNumero()) {
				jugador2.sumarPunto();
			}
		}
	}

	private static void repartirCarta(Jugador jugador, Baraja baraja) {
		Carta carta = baraja.elegirCartaAleatoria();
		if (carta != null) {
			jugador.recibirCarta(carta);
		}
	}

	private static boolean reponerMano(Jugador jugador, Baraja baraja) {
		while (jugador.getTamanoMano() < 10 && !baraja.estaVacia()) {
			Carta carta = baraja.elegirCartaAleatoria();
			jugador.recibirCarta(carta);
			
			if (baraja.estaVacia()) {
				return true;
			}
		}
		return false;
	}
}
